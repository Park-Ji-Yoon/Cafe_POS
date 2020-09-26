package Main;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
 
public class MasterLogin {
    public MasterLogin() {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT S_ID, S_PW FROM MASTER_TABLE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
            while (result = rset.next()) {
                if(rset.getString("S_ID").equals(Main.FillIn.getS_id_field().getText()) && rset.getString("S_PW").equals(Main.FillIn.getS_pw_field().getText())){
                	JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

    				Main.FillIn.getId_field().setText("");
    				Main.FillIn.getPw_field().setText("");	
    				Main.FillIn.getG_id_field().setText("");
    				Main.FillIn.getG_pw_field().setText("");	
    				Main.FillIn.getS_id_field().setText("");
    				Main.FillIn.getS_pw_field().setText("");					

    				Main.FillIn.getG_id_field().setVisible(false);
    				Main.FillIn.getG_pw_field().setVisible(false);
    				
    				Main.FillIn.getS_id_field().setVisible(false);
    				Main.FillIn.getS_pw_field().setVisible(false);
    				
    				Main.FillIn.getId_field().setVisible(true);
    				Main.FillIn.getPw_field().setVisible(true);
    				
    				Main.Loginarea.getLogin_button().setVisible(true);
    				Main.Loginarea.getG_login_button().setVisible(false);
    				Main.Loginarea.getS_login_button().setVisible(false);
    				
    				Main.MainFrame.getLogin_panel().setVisible(false);
    				Main.MainFrame.getMaster_panel().setVisible(true);
    				
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