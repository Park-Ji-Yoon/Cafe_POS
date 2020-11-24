package Main;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
 
public class MasterLogin {
	//master �α��� �� ȣ��Ǵ� DB
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
                if(rset.getString("S_ID").equals(SLoginPanel.getId_field().getText()) && rset.getString("S_PW").equals(SLoginPanel.getPw_field().getText())){
                	JOptionPane.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                	SLoginPanel.getId_field().setText("");
                	SLoginPanel.getPw_field().setText("");
                	
                	SLoginPanel.getId_field().setVisible(true);
                	SLoginPanel.getPw_field().setVisible(true);
    				
    				Main.MainFrame.getSLogin_panel().setVisible(false);
    				Main.MainFrame.getMaster_panel().setVisible(true);
    				
					break;
                }
            }
            
            //�α��� ���� ��
            if(result == false) {
            	JOptionPane.showMessageDialog(null, "���̵�, ��й�ȣ�� �߸��ԷµǾ����ϴ�.", "Error", JOptionPane.ERROR_MESSAGE);
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