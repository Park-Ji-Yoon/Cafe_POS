package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OrderDB {	
	public static void CoffeOrderDB(String bname, int icecount, int hotcount) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_COFFEE WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				query = "UPDATE MENU_COFFEE SET ICE_D = ?, HOT_D = ?, ICE_M = ?, HOT_M = ?, ICE_S = ?, HOT_S = ? WHERE BNAME = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, rset.getInt("ICE_D") + icecount);
				pstmt.setInt(2, rset.getInt("HOT_D") + hotcount);
				pstmt.setInt(3, rset.getInt("ICE_M") + icecount);
				pstmt.setInt(4, rset.getInt("HOT_M") + hotcount);
				pstmt.setInt(5, rset.getInt("ICE_S") - icecount);
				pstmt.setInt(6, rset.getInt("HOT_S") - hotcount);
				pstmt.setString(7, bname);
				pstmt.executeUpdate();
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
	public static void SmoothieOrderDB(String bname, int orangecount, int kiwicount, int grapecount, int strawcount, int watercount) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_SMOOTHIE WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				query = "UPDATE MENU_SMOOTHIE SET ORANGE_D = ?, KIWI_D = ?, GRAPE_D = ?, STRAW_D = ?, WATER_D = ?, ORANGE_M = ?, KIWI_M = ?, GRAPE_M = ?, STRAW_M = ?, WATER_M = ?, ORANGE_S = ?, KIWI_S = ?, GRAPE_S = ?, STRAW_S = ?, WATER_S = ? WHERE BNAME = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, rset.getInt("ORANGE_D") + orangecount);
				pstmt.setInt(2, rset.getInt("KIWI_D") + kiwicount);
				pstmt.setInt(3, rset.getInt("GRAPE_D") + grapecount);
				pstmt.setInt(4, rset.getInt("STRAW_D") + strawcount);
				pstmt.setInt(5, rset.getInt("WATER_D") + watercount);
				pstmt.setInt(6, rset.getInt("ORANGE_M") + orangecount);
				pstmt.setInt(7, rset.getInt("KIWI_M") + kiwicount);
				pstmt.setInt(8, rset.getInt("GRAPE_M") + grapecount);
				pstmt.setInt(9, rset.getInt("STRAW_M") + strawcount);
				pstmt.setInt(10, rset.getInt("WATER_M") + watercount);
				pstmt.setInt(11, rset.getInt("ORANGE_S") - orangecount);
				pstmt.setInt(12, rset.getInt("KIWI_S") - kiwicount);
				pstmt.setInt(13, rset.getInt("GRAPE_S") - grapecount);
				pstmt.setInt(14, rset.getInt("STRAW_S") - strawcount);
				pstmt.setInt(15, rset.getInt("WATER_S") - watercount);
				pstmt.setString(16, bname);
				pstmt.executeUpdate();
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
	public static void TeaOrderDB(String bname, int greencount, int blackcount) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_TEA WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				query = "UPDATE MENU_TEA SET GREEN_D = ?, BLACK_D = ?, GREEN_M = ?, BLACK_M = ?, GREEN_S = ?, BLACK_S = ? WHERE BNAME = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, rset.getInt("GREEN_D") + greencount);
				pstmt.setInt(2, rset.getInt("BLACK_D") + blackcount);
				pstmt.setInt(3, rset.getInt("GREEN_M") + greencount);
				pstmt.setInt(4, rset.getInt("BLACK_M") + blackcount);
				pstmt.setInt(5, rset.getInt("GREEN_S") - greencount);
				pstmt.setInt(6, rset.getInt("BLACK_S") - blackcount);
				pstmt.setString(7, bname);
				pstmt.executeUpdate();
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
	public static void BubbleOrderDB(String bname, int bscount, int tarocount, int gbcount) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_BUBBLE WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				query = "UPDATE MENU_BUBBLE SET BS_D = ?, TARO_D = ?, GB_D = ?, BS_M = ?, TARO_M = ?, GB_M = ?, BS_S = ?, TARO_S = ?, GB_S = ? WHERE BNAME = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, rset.getInt("BS_D") + bscount);
				pstmt.setInt(2, rset.getInt("TARO_D") + tarocount);
				pstmt.setInt(3, rset.getInt("GB_D") + gbcount);
				pstmt.setInt(4, rset.getInt("BS_M") + bscount);
				pstmt.setInt(5, rset.getInt("TARO_M") + tarocount);
				pstmt.setInt(6, rset.getInt("GB_M") + gbcount);
				pstmt.setInt(7, rset.getInt("BS_S") - bscount);
				pstmt.setInt(8, rset.getInt("TARO_S") - tarocount);
				pstmt.setInt(9, rset.getInt("GB_S") - gbcount);
				pstmt.setString(10, bname);
				pstmt.executeUpdate();
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
	public static void CakeOrderDB(String bname,int cheesecount, int sccount, int chococount) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_CAKE WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				query = "UPDATE MENU_CAKE SET CHEESE_D = ?, SC_D = ?, CHOCO_D = ?, CHEESE_M = ?, SC_M = ?, CHOCO_M = ?, CHEESE_S = ?, SC_S = ?, CHOCO_S = ? WHERE BNAME = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, rset.getInt("CHEESE_D") + cheesecount);
				pstmt.setInt(2, rset.getInt("SC_D") + sccount);
				pstmt.setInt(3, rset.getInt("CHOCO_D") + chococount);
				pstmt.setInt(4, rset.getInt("CHEESE_M") + cheesecount);
				pstmt.setInt(5, rset.getInt("SC_M") + sccount);
				pstmt.setInt(6, rset.getInt("CHOCO_M") + chococount);
				pstmt.setInt(7, rset.getInt("CHEESE_S") - cheesecount);
				pstmt.setInt(8, rset.getInt("SC_S") - sccount);
				pstmt.setInt(9, rset.getInt("CHOCO_S") - chococount);
				pstmt.setString(10, bname);
				pstmt.executeUpdate();
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
	public static void MacaronOrderDB(String bname, int berrycount, int yogurtcount, int fruitcount) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_MACARON WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				query = "UPDATE MENU_MACARON SET BERRY_D = ?, YOGURT_D = ?, FRUIT_D = ?, BERRY_M = ?, YOGURT_M = ?, FRUIT_M = ?, BERRY_S = ?, YOGURT_S = ?, FRUIT_S = ? WHERE BNAME = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, rset.getInt("BERRY_D") + berrycount);
				pstmt.setInt(2, rset.getInt("YOGURT_D") + yogurtcount);
				pstmt.setInt(3, rset.getInt("FRUIT_D") + fruitcount);
				pstmt.setInt(4, rset.getInt("BERRY_M") + berrycount);
				pstmt.setInt(5, rset.getInt("YOGURT_M") + yogurtcount);
				pstmt.setInt(6, rset.getInt("FRUIT_M") + fruitcount);
				pstmt.setInt(7, rset.getInt("BERRY_S") - berrycount);
				pstmt.setInt(8, rset.getInt("YOGURT_S") - yogurtcount);
				pstmt.setInt(9, rset.getInt("FRUIT_S") - fruitcount);
				pstmt.setString(10, bname);
				pstmt.executeUpdate();
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
