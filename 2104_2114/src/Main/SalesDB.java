package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

//날짜 비교해서 일별, 월별 매출액 초기화
public class SalesDB {	
	//현재 월일 가져오기
	static Calendar cal = Calendar.getInstance();
	static int nowday = cal.get(Calendar.DAY_OF_MONTH);
	static int nowmonth = cal.get(Calendar.MONTH)+1;
	static Date date = new Date();
	
	//커피 초기화
	public static void CoffeSalesDB() {		
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
					//현재 일이 DB에 있는 일이랑 다를 때 일별 매출액 초기화
					date.setDay(nowday);
					query = "UPDATE MENU_COFFEE SET ICE_D = 0, HOT_D = 0";
					pstmt = conn.prepareStatement(query);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						//현재 월이 DB에 있는 월이랑 다를 때 월별 매출액 초기화
						date.setMonth(nowmonth);
						query = "UPDATE MENU_COFFEE SET ICE_M = 0, HOT_M = 0";
						pstmt = conn.prepareStatement(query);
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
	
	//스무디 초기화
	public static void SmoothieSalesDB() {
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
					//현재 일이 DB에 있는 일이랑 다를 때 일별 매출액 초기화
					date.setDay(nowday);
					query = "UPDATE MENU_SMOOTHIE SET ORANGE_D = 0, KIWI_D = 0, GRAPE_D = 0, STRAW_D = 0, WATER_D = 0";
					pstmt = conn.prepareStatement(query);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						//현재 월이 DB에 있는 월이랑 다를 때 월별 매출액 초기화
						date.setMonth(nowmonth);
						query = "UPDATE MENU_SMOOTHIE SET ORANGE_M = 0, KIWI_M = 0, GRAPE_M = 0, STRAW_M = 0, WATER_M = 0";
						pstmt = conn.prepareStatement(query);
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
	
	//차 초기화
	public static void TeaSalesDB() {
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
					//현재 일이 DB에 있는 일이랑 다를 때 일별 매출액 초기화
					date.setDay(nowday);
					query = "UPDATE MENU_TEA SET GREEN_D = 0, BLACK_D = 0";
					pstmt = conn.prepareStatement(query);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						//현재 월이 DB에 있는 월이랑 다를 때 월별 매출액 초기화
						date.setMonth(nowmonth);
						query = "UPDATE MENU_TEA SET GREEN_M = 0, BLACK_M = 0";
						pstmt = conn.prepareStatement(query);
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
	
	//버블티 초기화
	public static void BubbleSalesDB() {
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
					//현재 일이 DB에 있는 일이랑 다를 때 일별 매출액 초기화
					date.setDay(nowday);
					query = "UPDATE MENU_BUBBLE SET BS_D = 0, TARO_D = 0, GB_D = 0";
					pstmt = conn.prepareStatement(query);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						//현재 월이 DB에 있는 월이랑 다를 때 월별 매출액 초기화
						date.setMonth(nowmonth);
						query = "UPDATE MENU_BUBBLE SET BS_M = 0, TARO_M = 0, GB_M = 0";
						pstmt = conn.prepareStatement(query);
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
	
	//케이크 초기화
	public static void CakeSalesDB() {
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
					//현재 일이 DB에 있는 일이랑 다를 때 일별 매출액 초기화
					date.setDay(nowday);
					query = "UPDATE MENU_CAKE SET CHEESE_D = 0, SC_D = 0, CHOCO_D = 0";
					pstmt = conn.prepareStatement(query);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						//현재 월이 DB에 있는 월이랑 다를 때 월별 매출액 초기화
						date.setMonth(nowmonth);
						query = "UPDATE MENU_CAKE SET CHEESE_M = 0, SC_M = 0, CHOCO_M = 0";
						pstmt = conn.prepareStatement(query);
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
	
	//마카롱 초기화
	public static void MacaronSalesDB() {
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
				//현재 일이 DB에 있는 일이랑 다를 때 일별 매출액 초기화
					date.setDay(nowday);
					query = "UPDATE MENU_MACARON SET BERRY_D = 0, YOGURT_D = 0, FRUIT_D = 0";
					pstmt = conn.prepareStatement(query);
					pstmt.executeUpdate();
					if(nowmonth != date.month) {
						//현재 월이 DB에 있는 월이랑 다를 때 월별 매출액 초기화
						date.setMonth(nowmonth);
						query = "UPDATE MENU_MACARON SET BERRY_M = 0, YOGURT_M = 0, FRUIT_M = 0";
						pstmt = conn.prepareStatement(query);
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

//DB에 있는 월일 가져오기
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

	//일 업데이트
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

	//월 업데이트
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
