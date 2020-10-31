package Main;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
 
public class ManagerLogin {
    public static String bname;
    
	public ManagerLogin() {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT G_BNAME, G_ID, G_PW FROM MANAGER_TABLE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
            while (result = rset.next()) {
                if(rset.getString("G_ID").equals(GLoginPanel.getId_field().getText()) && rset.getString("G_PW").equals(GLoginPanel.getPw_field().getText())){
                	JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                	
                	bname = rset.getString("G_BNAME");
                	
                	System.out.println("메소드 밖 : " + bname);
                	ManagerInfo.getManager_name_label().setText(getG_Name());
                	ManagerInfo.getManager_id_label().setText(getG_Id());
                	ManagerInfo.getManager_pw_label().setText(getG_Pw());
                	ManagerInfo.getManager_bname_label().setText(getG_BName());
                	ManagerInfo.getManager_bphone_label().setText(getG_BPhone());
                	ManagerInfo.getManager_em_label().setText(getG_Em());

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
	public static String getG_Name() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		String g_name = null;
		
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT G_NAME FROM MANAGER_TABLE WHERE G_BNAME=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			System.out.println("메소드 안 : " + bname);
			rset = pstmt.executeQuery();
			
			boolean result = true;
			
            while (result = rset.next()) {
            	g_name = rset.getString("G_NAME");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
		return g_name;
	}
	public static String getG_Id() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		String g_id = null;
		
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT G_ID FROM MANAGER_TABLE WHERE G_BNAME=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			System.out.println("메소드 안 : " + bname);
			rset = pstmt.executeQuery();
			
			boolean result = true;
			
            while (result = rset.next()) {
            	g_id = rset.getString("G_ID");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
		return g_id;
	}
	public static String getG_Pw() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		String g_pw = null;
		
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT G_PW FROM MANAGER_TABLE WHERE G_BNAME=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			System.out.println("메소드 안 : " + bname);
			rset = pstmt.executeQuery();
			
			boolean result = true;
			
            while (result = rset.next()) {
            	g_pw = rset.getString("G_PW");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
		return g_pw;
	}
	public static String getG_BName() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		String g_bname = null;
		
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT G_BNAME FROM MANAGER_TABLE WHERE G_BNAME=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			System.out.println("메소드 안 : " + bname);
			rset = pstmt.executeQuery();
			
			boolean result = true;
			
            while (result = rset.next()) {
            	g_bname = rset.getString("G_BNAME");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
		return g_bname;
	}
	public static String getG_BPhone() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		String g_bphone = null;
		
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT G_BPHONE FROM MANAGER_TABLE WHERE G_BNAME=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			System.out.println("메소드 안 : " + bname);
			rset = pstmt.executeQuery();
			
			boolean result = true;
			
            while (result = rset.next()) {
            	g_bphone = rset.getString("G_BPHONE");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
		return g_bphone;
	}
	public static String getG_Em() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		String g_em = null;
		
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT G_EM FROM MANAGER_TABLE WHERE G_BNAME=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			System.out.println("메소드 안 : " + bname);
			rset = pstmt.executeQuery();
			
			boolean result = true;
			
            while (result = rset.next()) {
            	g_em = rset.getString("G_EM");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
		return g_em;
	}
}