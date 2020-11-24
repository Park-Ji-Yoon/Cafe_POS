package Main;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
 
public class ManagerLogin {
    public static String nowbname;
    
    //manager 로그인 시 호출되는 DB
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
                	
                	nowbname = rset.getString("G_BNAME");
                	
                	//37~63 다른 클래스에서 필요한 정보 저장
                	ManagerPanel.bname_label.setText(nowbname);
                	EmployeePanel.bname_label.setText(nowbname);
                	EmployeePanel.bname = nowbname;
                	SalesPanel.bname = nowbname;
                	StockPanel.bname = nowbname;
                	
                	ManagerInfo.getManager_name_label().setText(getG_Name());
                	ManagerInfo.getManager_id_label().setText(getG_Id());
                	ManagerInfo.getManager_pw_label().setText(getG_Pw());
                	ManagerInfo.getManager_bname_label().setText(getG_BName());
                	ManagerInfo.getManager_bphone_label().setText(getG_BPhone());
                	ManagerInfo.getManager_em_label().setText(getG_Em());

                	SalesPanel.day_label.setText("일별 : " + Integer.toString(FranchiseDB.FranchiseDaySales(nowbname)));
                	SalesPanel.month_label.setText("월별 : " + Integer.toString(FranchiseDB.FranchiseMonthSales(nowbname)));
                	GCoffeeSalesPanel.day_label.setText("일별 : " + Integer.toString(FranchiseDB.FranchiseDaySales(nowbname)));
                	GCoffeeSalesPanel.month_label.setText("월별 : " + Integer.toString(FranchiseDB.FranchiseMonthSales(nowbname)));
                	GSmoothieSalesPanel.day_label.setText("일별 : " + Integer.toString(FranchiseDB.FranchiseDaySales(nowbname)));
                	GSmoothieSalesPanel.month_label.setText("월별 : " + Integer.toString(FranchiseDB.FranchiseMonthSales(nowbname)));
                	GTeaSalesPanel.day_label.setText("일별 : " + Integer.toString(FranchiseDB.FranchiseDaySales(nowbname)));
                	GTeaSalesPanel.month_label.setText("월별 : " + Integer.toString(FranchiseDB.FranchiseMonthSales(nowbname)));
                	GBubbleSalesPanel.day_label.setText("일별 : " + Integer.toString(FranchiseDB.FranchiseDaySales(nowbname)));
                	GBubbleSalesPanel.month_label.setText("월별 : " + Integer.toString(FranchiseDB.FranchiseMonthSales(nowbname)));
                	GCakeSalesPanel.day_label.setText("일별 : " + Integer.toString(FranchiseDB.FranchiseDaySales(nowbname)));
                	GCakeSalesPanel.month_label.setText("월별 : " + Integer.toString(FranchiseDB.FranchiseMonthSales(nowbname)));
                	GMacaronSalesPanel.day_label.setText("일별 : " + Integer.toString(FranchiseDB.FranchiseDaySales(nowbname)));
                	GMacaronSalesPanel.month_label.setText("월별 : " + Integer.toString(FranchiseDB.FranchiseMonthSales(nowbname)));
                	
                	GLoginPanel.getId_field().setText("");
                	GLoginPanel.getPw_field().setText("");
                	
                	GLoginPanel.getId_field().setVisible(true);
                	GLoginPanel.getPw_field().setVisible(true);
    				
    				Main.MainFrame.getGLogin_panel().setVisible(false);
    				Main.MainFrame.getManager_panel().setVisible(true);
					break;
                }
            }
            
            //로그인 실패 시
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
	
	//지점장 이름
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
			pstmt.setString(1, nowbname);
			System.out.println("메소드 안 : " + nowbname);
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
	
	//지점장 아이디
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
			pstmt.setString(1, nowbname);
			System.out.println("메소드 안 : " + nowbname);
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
	
	//지점장 비밀번호
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
			pstmt.setString(1, nowbname);
			System.out.println("메소드 안 : " + nowbname);
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
	
	//지점명
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
			pstmt.setString(1, nowbname);
			System.out.println("메소드 안 : " + nowbname);
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
	
	//지점 전화번호
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
			pstmt.setString(1, nowbname);
			System.out.println("메소드 안 : " + nowbname);
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
	
	//지점 직원 수
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
			pstmt.setString(1, nowbname);
			System.out.println("메소드 안 : " + nowbname);
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