package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class SalesDB {	
	static Calendar cal = Calendar.getInstance();
	static int nowday = cal.get(Calendar.DAY_OF_MONTH);
	static int nowmonth = cal.get(Calendar.MONTH)+1;
	static Date date = new Date();
	
	public static void CoffeSalesDB(String bname) {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_COFFEE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				if(nowday != date.day) {
					date.setDay(nowday);
					query = "UPDATE MENU_COFFEE SET ICE_D = ?, HOT_D = ? WHERE BNAME = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, 0);
					pstmt.setInt(2, 0);
					pstmt.setString(3, bname);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						date.setMonth(nowmonth);
						query = "UPDATE MENU_COFFEE SET ICE_M = ?, HOT_M = ? WHERE BNAME = ?";
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, 0);
						pstmt.setInt(2, 0);
						pstmt.setString(3, bname);
						pstmt.executeUpdate();
					}
				}
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
	public static void SmoothieSalesDB(String bname) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_SMOOTHIE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				if(nowday != date.day) {
					date.setDay(nowday);
					query = "UPDATE MENU_SMOOTHIE SET ORANGE_D = ?, KIWI_D = ?, GRAPE_D = ?, STRAW_D = ?, WATER_D = ? WHERE BNAME = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, 0);
					pstmt.setInt(2, 0);
					pstmt.setInt(3, 0);
					pstmt.setInt(4, 0);
					pstmt.setInt(5, 0);
					pstmt.setString(6, bname);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						date.setMonth(nowmonth);
						query = "UPDATE MENU_SMOOTHIE SET ORANGE_M = ?, KIWI_M = ?, GRAPE_M = ?, STRAW_M = ?, WATER_M = ? WHERE BNAME = ?";
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, 0);
						pstmt.setInt(2, 0);
						pstmt.setInt(3, 0);
						pstmt.setInt(4, 0);
						pstmt.setInt(5, 0);
						pstmt.setString(6, bname);
						pstmt.executeUpdate();
					}
				}
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
	public static void TeaSalesDB(String bname) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_TEA";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				if(nowday != date.day) {
					date.setDay(nowday);
					query = "UPDATE MENU_TEA SET GREEN_D = ?, BLACK_D = ? WHERE BNAME = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, 0);
					pstmt.setInt(2, 0);
					pstmt.setString(3, bname);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						date.setMonth(nowmonth);
						query = "UPDATE MENU_TEA SET GREEN_M = ?, BLACK_M = ? WHERE BNAME = ?";
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, 0);
						pstmt.setInt(2, 0);
						pstmt.setString(3, bname);
						pstmt.executeUpdate();
					}
				}
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
	public static void BubbleSalesDB(String bname) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_BUBBLE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				if(nowday != date.day) {
					date.setDay(nowday);
					query = "UPDATE MENU_BUBBLE SET BS_D = ?, TARO_D = ?, GB_D = ? WHERE BNAME = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, 0);
					pstmt.setInt(2, 0);
					pstmt.setInt(3, 0);
					pstmt.setString(4, bname);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						date.setMonth(nowmonth);
						query = "UPDATE MENU_BUBBLE SET BS_M = ?, TARO_M = ?, GB_M = ? WHERE BNAME = ?";
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, 0);
						pstmt.setInt(2, 0);
						pstmt.setInt(3, 0);
						pstmt.setString(4, bname);
						pstmt.executeUpdate();
					}
				}
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
	public static void CakeSalesDB(String bname) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_CAKE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				if(nowday != date.day) {
					date.setDay(nowday);
					query = "UPDATE MENU_CAKE SET CHEESE_D = ?, SC_D = ?, CHOCO_D = ? WHERE BNAME = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, 0);
					pstmt.setInt(2, 0);
					pstmt.setInt(3, 0);
					pstmt.setString(4, bname);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						date.setMonth(nowmonth);
						query = "UPDATE MENU_CAKE SET CHEESE_M = ?, SC_M = ?, CHOCO_M = ? WHERE BNAME = ?";
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, 0);
						pstmt.setInt(2, 0);
						pstmt.setInt(3, 0);
						pstmt.setString(4, bname);
						pstmt.executeUpdate();
					}
				}
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
	public static void MacaronSalesDB(String bname) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM MENU_MACARON";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				if(nowday != date.day) {
					date.setDay(nowday);
					query = "UPDATE MENU_MACARON SET BERRY_D = ?, YOGURT_D = ?, FRUIT_D = ? WHERE BNAME = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, 0);
					pstmt.setInt(2, 0);
					pstmt.setInt(3, 0);
					pstmt.setString(4, bname);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						date.setMonth(nowmonth);
						query = "UPDATE MENU_MACARON SET BERRY_M = ?, YOGURT_M = ?, FRUIT_M = ? WHERE BNAME = ?";
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, 0);
						pstmt.setInt(2, 0);
						pstmt.setInt(3, 0);
						pstmt.setString(4, bname);
						pstmt.executeUpdate();
					}
				}
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


class Date {
	public static int day;
	public static int month;

	Date(){
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM RESET_TABLE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				day = rset.getInt("DAY");
				month = rset.getInt("MONTH");
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

	public static void setDay(int day) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM RESET_TABLE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				query = "UPDATE RESET_TABLE SET DAY = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, day);
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

	public static void setMonth(int month) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

			query = "SELECT * FROM RESET_TABLE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			boolean result = true;

			while (result = rset.next()) {
				query = "UPDATE RESET_TABLE SET MONTH = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, month);
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
