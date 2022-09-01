package xyz.flyly.other.gui.jframe;

import xyz.flyly.other.gui.util.Utils;
import xyz.flyly.other.gui.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 登陆面板
 */
public class LoginJFrame extends JFrame implements ActionListener {

    // 用户名字段
    private JTextField userNameTextField;

    // 密码字段
    private JPasswordField pwdFiled;

    // 确认按钮
    private JButton confirmBtn;

    // 验证码显示标签
    private JLabel codeWindowLabel;

    // 验证码输入框
    private JTextField inputCodeTextField;

    // 验证码值
    private String code;


    // 跳转注册按钮
    private JButton jmpRegisterBtn;


    public LoginJFrame() throws HeadlessException {
        super("电影会员用户登陆");

        // 初始化控件
        initComponent();

        // 初始化按钮监听
        initActionListener();

    }

    /**
     * 初始化按钮的监听
     */
    private void initActionListener() {
        // 添加监听
        this.confirmBtn.addActionListener(this);
        this.jmpRegisterBtn.addActionListener(this);
        // 设置 command
        this.confirmBtn.setActionCommand("Login");
        this.jmpRegisterBtn.setActionCommand("jmpRegister");
    }

    /**
     * 初始化控件
     */
    private void initComponent() {
        JPanel userNamePanel = new JPanel();
        JLabel userNameLabel = new JLabel("用户名");
        this.userNameTextField = new JTextField(10);

        userNamePanel.setLayout(new FlowLayout());
        userNamePanel.add(userNameLabel);
        userNamePanel.add(userNameTextField);

        JPanel pwdPanel = new JPanel();
        JLabel pwdLabel = new JLabel("密  码");
        this.pwdFiled = new JPasswordField(10);
        pwdFiled.setEchoChar('*');

        pwdPanel.setLayout(new FlowLayout());
        pwdPanel.add(pwdLabel);
        pwdPanel.add(pwdFiled);

        JPanel codePanel = new JPanel();
        this.inputCodeTextField = new JTextField(5);
        this.codeWindowLabel = new JLabel();
        refreshCode();
        // 添加监听事件
        this.codeWindowLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                refreshCode();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        codePanel.setLayout(new FlowLayout());
        codePanel.add(inputCodeTextField);
        codePanel.add(this.codeWindowLabel);


        JPanel buttonPanel = new JPanel();
        this.confirmBtn = new JButton("登陆");
        this.jmpRegisterBtn = new JButton("注册");

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(confirmBtn);
        buttonPanel.add(jmpRegisterBtn);


        this.setLayout(new GridLayout(4, 1));
        this.add(userNamePanel);
        this.add(pwdPanel);
        this.add(codePanel);
        this.add(buttonPanel);
        this.setAlwaysOnTop(true);
        this.setSize(400, 200);
        this.setVisible(true);
        this.setResizable(false);
//        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            String userName = this.userNameTextField.getText();
            String pwd = new String(this.pwdFiled.getPassword());
            String inputCode = this.inputCodeTextField.getText();
            if (userName != null && userName.length() > 0 && pwd.length() > 0) {
                if (inputCode == null || inputCode.length() == 0) {
                    JOptionPane.showMessageDialog(this,
                            "验证码不能为空!",
                            "Error Message",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!inputCode.equalsIgnoreCase(code)) {
                    JOptionPane.showMessageDialog(this,
                            "验证码输入错误!",
                            "Error Message",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                for (User user : Utils.userList) {
                    if (user.getUserName().equals(userName)) {
                        if (pwd.equals(user.getPassWord())) {
                            JOptionPane.showMessageDialog(this,
                                    String.format("%s登陆成功", user.getName()));
                            this.userNameTextField.setText("");
                            this.pwdFiled.setText("");
                            this.inputCodeTextField.setText("");
                            // 刷新验证码
                            refreshCode();
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(this,
                        "用户不存在!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this,
                        "用户名或者密码不能为空!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }


        } else if (e.getActionCommand().equals("jmpRegister")) {
            // 销毁自己的界面
            this.dispose();
            // 跳转到注册界面
            new RegisterJFrame();
        }

    }


    /**
     * 刷新验证码
     */
    private void refreshCode() {
        Utils.Image newImage = Utils.createImage();
        this.code = newImage.getCode();
        this.codeWindowLabel.setIcon(newImage.getImageIcon());
    }
}
