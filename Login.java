package logAndReg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    Container c;
    JLabel imageLabel;
    JTextField textField1, textField2;
    ImageIcon icon;
    JButton Register, Login;
    Font f1, f2;

    Login() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 100, 505, 328);
        this.setTitle("Login");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);

        f1 = new Font("Arial", Font.BOLD + Font.ITALIC, 22);
        f2 = new Font("Arial", Font.BOLD + Font.ITALIC, 16);

        icon = new ImageIcon(getClass().getResource("Login.png"));

        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(imageLabel);

        textField1 = new JTextField();
        textField1.setBounds(260, 110, 200, 40);
        textField1.setBackground(Color.LIGHT_GRAY);
        textField1.setFont(f2);
        imageLabel.add(textField1);

        textField2 = new JTextField();
        textField2.setBounds(260, 160, 200, 40);
        textField2.setBackground(Color.LIGHT_GRAY);
        textField2.setFont(f2);
        imageLabel.add(textField2);

        Register = new JButton("Register");
        Register.setBounds(80, 230, 130, 40);
        Register.setFont(f1);
        Register.setBackground(Color.black);
        Register.setForeground(Color.white);
        imageLabel.add(Register);

        Login = new JButton("Login");
        Login.setBounds(300, 230, 130, 40);
        Login.setFont(f1);
        Login.setBackground(Color.black);
        Login.setForeground(Color.white);
        imageLabel.add(Login);

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Registration();
            }

        });
        
        setVisible(true);

          Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String  email = textField1.getText();
                String password = textField2.getText();
                
                 DbConnect db = new DbConnect();
                
               String queryLogin = "Select * From `userinfo`";
                db.LoginData(queryLogin,email,password);
            }
        });
    }

    public static void main(String[] args) {
        new Login();
        
    }
}
