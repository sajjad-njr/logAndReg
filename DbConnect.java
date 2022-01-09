package logAndReg;

import java.sql.*;
import javax.swing.*;

public class DbConnect {

    private Statement st;
    private Connection con;
    ResultSet rs;

    public DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wassi10", "root", "");
            st = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void InsertRegister(String insertQuery) {
        try {
            st.executeUpdate(insertQuery);
            JOptionPane.showMessageDialog(null, "Sucessfull log in ");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Not Sucessfull log in ");
        }
    }

    public void LoginData(String queryLogin, String userName, String password) {

        int flag = 1;
        try {
            rs = st.executeQuery(queryLogin);

            while (rs.next()) {
                String tableName = rs.getString(2);
                String tablePass = rs.getString(4);

                if (userName.equals(tableName) && password.equals(tablePass)) {
                    JOptionPane.showMessageDialog(null, "You are sucessfully done ");
                    flag = 0;
                    break;
                }

            }

            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Email or Password did not match ");
            }
        } catch (Exception e) {
        }
    }

}
