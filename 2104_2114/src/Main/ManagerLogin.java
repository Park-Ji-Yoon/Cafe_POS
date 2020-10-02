package Main;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
 
public class ManagerLogin {
    public ManagerLogin() {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT G_ID, G_PW FROM MANAGER_TABLE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
            while (result = rset.next()) {
                if(rset.getString("G_ID").equals(GLoginPanel.getId_field().getText()) && rset.getString("G_PW").equals(GLoginPanel.getPw_field().getText())){
                	JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                	GLoginPanel.getId_field().setText("");
                	GLoginPanel.getPw_field().setText("");
                	
                	GLoginPanel.getId_field().setVisible(true);
                	GLoginPanel.getPw_field().setVisible(true);
    				
    				Main.MainFrame.getGLogin_panel().setVisible(false);
    				Main.MainFrame.getManager_panel().setVisible(true);
    				
					break;
                }
            }
            
            if(result == false) {
            	JOptionPane.showMessageDialog(null, "아이디, 비밀번호가 잘못입력되었습니다.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rset.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}