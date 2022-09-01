package xyz.flyly.other.gui.util;

import xyz.flyly.other.gui.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    private static char[] chars = ("0123456789"
            + "abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIGKLMNOPQRSTUVWXYZ").toCharArray();

    public static String fileName = "out.txt";

    public static List<User> userList = readObjFromFile(fileName);


    /**
     * 将对象信息写入到文件中
     *
     * @param users    user 对象
     * @param fileName 文件名
     * @throws Exception
     */
    public static void writeObjToFile(List<User> users, String fileName) throws Exception {
        if (users == null || users.size() == 0) {
            return;
        }

        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file);

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(users);
        oos.flush();

        oos.close();
        fos.close();
    }

    /**
     * 将文件中的数据反序列化
     *
     * @param fileName 文件名
     * @return 反序列化后的数据
     */
    public static List<User> readObjFromFile(String fileName) {

        File file = new File(fileName);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis);) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                return (List<User>) obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


    public static Image createImage() {
        StringBuilder sb = new StringBuilder();
        // 创建空白图片
        BufferedImage image = new BufferedImage(80, 40, BufferedImage.TYPE_3BYTE_BGR);
        // 获取画笔
        Graphics graphics = image.getGraphics();
        // 设置画笔颜色
        graphics.setColor(Color.GRAY);
        // 绘制背景
        graphics.fillRect(0, 0, 80, 40);
        // 画随机字符
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            // 字符 idx
            int charIdx = r.nextInt(chars.length);
            // 随机颜色
            graphics.setColor(randomColor());
            // 字体大小
            graphics.setFont(new Font("Default", Font.BOLD + Font.ITALIC, 30));
            // 画字符
            graphics.drawString(chars[charIdx] + "", i * 80 / 4, 40 / 2 + 10);
            // 记录
            sb.append(chars[charIdx]);
        }
        // 画干扰线
        for (int i = 0; i < 10; i++) {
            graphics.setColor(randomColor());
            graphics.drawLine(r.nextInt(80), r.nextInt(40), r.nextInt(80), r.nextInt(40));
        }


        return new Image(new ImageIcon(image), sb.toString());
    }

    private static Color randomColor() {
        Random r = new Random();
        return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }

    /**
     * 内部类
     */
    public static class Image {
        /**
         * 图片
         */
        private ImageIcon imageIcon;

        /**
         * 验证码
         */
        private String code;

        public Image(ImageIcon imageIcon, String code) {
            this.imageIcon = imageIcon;
            this.code = code;
        }

        public ImageIcon getImageIcon() {
            return imageIcon;
        }

        public void setImageIcon(ImageIcon imageIcon) {
            this.imageIcon = imageIcon;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

    }


}
