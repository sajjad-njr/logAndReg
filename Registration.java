package logAndReg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Registration extends JFrame {

    Container c;
    JLabel imageLabel;
    JTextField textField1, textField2, textField3, textField4, textField5, textField6;
    ImageIcon icon;
    JButton Register, Login;
    Font f1, f2;

    Registration() {
        initComponent();
    }

    public void initComponent() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 50, 505, 632);
        this.setTitle("Registration");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);

        f1 = new Font("Arial", Font.BOLD + Font.ITALIC, 18);
        f2 = new Font("Arial", Font.BOLD, 16);

        icon = new ImageIcon(getClass().getResource("reg.png"));

        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(imageLabel);

        //user name
        textField1 = new JTextField();
        textField1.setBounds(260, 145, 200, 40);
        textField1.setBackground(Color.LIGHT_GRAY);
        textField1.setFont(f2);
        imageLabel.add(textField1);

        //email
        textField2 = new JTextField();
        textField2.setBounds(260, 207, 200, 40);
        textField2.setBackground(Color.LIGHT_GRAY);
        textField2.setFont(f2);
        imageLabel.add(textField2);

        //mobile
        textField3 = new JTextField();
        textField3.setBounds(260, 270, 200, 40);
        textField3.setBackground(Color.LIGHT_GRAY);
        textField3.setFont(f2);
        imageLabel.add(textField3);

        //password
        textField4 = new JTextField();
        textField4.setBounds(260, 332, 200, 40);
        textField4.setBackground(Color.LIGHT_GRAY);
        textField4.setFont(f2);
        imageLabel.add(textField4);

        //confirm password
        textField5 = new JTextField();
        textField5.setBounds(260, 395, 200, 40);
        textField5.setBackground(Color.LIGHT_GRAY);
        textField5.setFont(f2);
        imageLabel.add(textField5);

        //Address
        textField6 = new JTextField();
        textField6.setBounds(260, 460, 200, 40);
        textField6.setBackground(Color.LIGHT_GRAY);
        textField6.setFont(f2);
        imageLabel.add(textField6);

        Register = new JButton("Register");
        Register.setBounds(290, 520, 130, 50);
        Register.setFont(f1);
        Register.setBackground(Color.black);
        Register.setForeground(Color.white);
        imageLabel.add(Register);

        Login = new JButton("Login");
        Login.setBounds(80, 520, 130, 50);
        Login.setFont(f1);
        Login.setBackground(Color.black);
        Login.setForeground(Color.white);
        imageLabel.add(Login);

        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }

        });

        //register btn
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = textField1.getText();
                String email = textField2.getText();
                String mobile = textField3.getText();
                String password = textField4.getText();
                String confirmPasswod = textField4.getText();
                String adderess = textField6.getText();

                String userNameRegex = "^[a-zA-Z .]+$";
                String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
                String passRegex = "(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%&*()]).{6,20}";
                String mobileRegex = "(\\+88)?-?01[3-9]\\d{8}";

                if (!Pattern.matches(userNameRegex, userName)) {
                    JOptionPane.showMessageDialog(null, "Only char is allowed!!");
                } else if (!Pattern.matches(emailRegex, email)) {
                    JOptionPane.showMessageDialog(null, "In-valid Email!!");
                } else if (!Pattern.matches(mobileRegex, mobile)) {
                    JOptionPane.showMessageDialog(null, "In-valid Mobile Number!!");
                } else if (!Pattern.matches(passRegex, password)) {
                    JOptionPane.showMessageDialog(null, "1 digit, 1 lower, 1 upper, 1 special char and length 6-20");
                } else if (!confirmPasswod.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Password and confirm password is not matching!!");
                } else if (adderess.equals("")) {
                    JOptionPane.showMessageDialog(null, "In valid address");
                } else {
                      
                    String insertQuery = "INSERT INTO `userinfo`(`userName`, `email`, `mobile`, `passwod`, `address`)"
                            + " VALUES ('" + userName + "','"+ email + "','"+mobile+ "','" +password+ "', '" +adderess+ "')";
                   
                    DbConnect db = new DbConnect();
                    db.InsertRegister(insertQuery);

                }
            }

        });
        
        setVisible(true);
    }

    public static void main(String[] args) {

         new Registration();
        
    }
}
