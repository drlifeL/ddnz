package xyz.flyly.other.gui.jframe;

import xyz.flyly.other.gui.entity.User;
import xyz.flyly.other.gui.util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 注册面板
 */
public class RegisterJFrame extends JFrame implements ActionListener {

    /**
     * 姓名
     */
    private JTextField userTextField;

    /**
     * 年龄
     */
    private JTextField ageTextField;


    /**
     * 性别
     */
    private ButtonGroup sexButtonGroup;


    /**
     * 男性单选框
     */
    private JRadioButton manRadioButton;

    /**
     * 女性单选框
     */
    private JRadioButton womenRadioButton;


    /**
     * 手机号
     */
    private JTextField phoneTextField;

    /**
     * 用户名
     */
    private JTextField userNameTextField;

    /**
     * 密码
     */
    private JPasswordField pwdFiled;

    /**
     * 注册按钮
     */
    private JButton registerBtn;

    /**
     * 跳转登陆按钮
     */
    private JButton returnLoginBtn;


    public RegisterJFrame() throws HeadlessException {
        super("电影会员用户注册");

        // 初始化组件
        initComponent();

        // 初始化任务监听
        initActionListener();
    }

    /**
     * 初始化组件
     */
    private void initComponent() {

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("姓  名");
        this.userTextField = new JTextField(10);

        namePanel.setLayout(new FlowLayout());
        namePanel.add(nameLabel);
        namePanel.add(userTextField);


        JPanel agePanel = new JPanel();
        JLabel ageLabel = new JLabel("年  龄");
        this.ageTextField = new JTextField(10);

        agePanel.setLayout(new FlowLayout());
        agePanel.add(ageLabel);
        agePanel.add(ageTextField);

        // 性别
        JPanel sexPanel = new JPanel();
        JLabel sexLabel = new JLabel("性  别         ");
        this.sexButtonGroup = new ButtonGroup();
        this.manRadioButton = new JRadioButton("男", true);
        this.womenRadioButton = new JRadioButton("女");

        this.sexButtonGroup.add(this.manRadioButton);
        this.sexButtonGroup.add(this.womenRadioButton);
        sexPanel.setLayout(new FlowLayout());
        sexPanel.add(sexLabel);
        sexPanel.add(this.manRadioButton);
        sexPanel.add(this.womenRadioButton);


        JPanel phonePanel = new JPanel();
        JLabel phoneLabel = new JLabel("手机号");
        this.phoneTextField = new JTextField(10);

        phonePanel.setLayout(new FlowLayout());
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneTextField);

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


        JPanel buttonPanel = new JPanel();
        this.registerBtn = new JButton("注册");
        this.returnLoginBtn = new JButton("返回");

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(registerBtn);
        buttonPanel.add(returnLoginBtn);


        this.setLayout(new GridLayout(7, 1));
        this.add(namePanel);
        this.add(agePanel);
        this.add(sexPanel);
        this.add(phonePanel);
        this.add(userNamePanel);
        this.add(pwdPanel);
        this.add(buttonPanel);
        this.setAlwaysOnTop(true);
        this.setSize(600, 400);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * 初始化按钮的监听
     */
    private void initActionListener() {
        // 添加监听
        this.registerBtn.addActionListener(this);
        this.returnLoginBtn.addActionListener(this);
        // 设置 command
        this.registerBtn.setActionCommand("Register");
        this.returnLoginBtn.setActionCommand("returnLogin");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Register")) {
            // 校验数据
            User user = validDataOk();
            // 数据校验不通过的情况
            if (user == null) return;

            // 将用户加入到用户列表中
            Utils.userList.add(user);

            // 将用户列表写入到文件中
            try {
                Utils.writeObjToFile(Utils.userList, Utils.fileName);
            } catch (Exception ex) {
                showErrorMessage("写入数据异常,程序即将退出！");
                this.dispose();
            }

            JOptionPane.showMessageDialog(this, "注册成功,即将跳转到登陆界面!", "提示消息", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new LoginJFrame();

        } else if (e.getActionCommand().equals("returnLogin")) {
            this.dispose();
            new LoginJFrame();
        }

    }

    /**
     * 校验并返回数据
     *
     * @return
     */
    private User validDataOk() {

        String userText = this.userTextField.getText();

        if (isEmpty(userText)) {
            showErrorMessage("姓名不能为空!");
            return null;
        }

        String age = this.ageTextField.getText();
        int ageNum;
        try {
            ageNum = Integer.parseInt(age);
        } catch (Exception e) {
            showErrorMessage("年龄输入有误！");
            return null;
        }

        boolean manSelected = this.manRadioButton.isSelected();

        String phoneText = this.phoneTextField.getText();
        if (isEmpty(phoneText)) {
            showErrorMessage("手机号不能为空!");
            return null;
        }

        String userNameText = this.userNameTextField.getText();
        if (isEmpty(userNameText)) {
            showErrorMessage("用户名不能为空!");
            return null;
        }

        for (User user : Utils.userList) {
            if (user.getUserName().equals(userNameText)) {
                showErrorMessage("用户名已经被注册！");
                return null;
            }
        }

        String passwordText = new String(this.pwdFiled.getPassword());
        if (isEmpty(passwordText)) {
            showErrorMessage("密码不能为空!");
            return null;
        }

        User user = new User();
        user.setName(userText);
        user.setAge(ageNum);
        user.setSex(manSelected ? "男" : "女");
        user.setPhone(phoneText);
        user.setUserName(userNameText);
        user.setPassWord(passwordText);

        return user;
    }

    /**
     * 显示错误信息
     *
     * @param message 内容
     */
    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                "Error Message",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * 字符串是否有效
     *
     * @param str 字符串
     * @return true Or False
     */
    private boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }
}
