package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

//지점 정보 가져오는 DB(지점명, 전화번호, 일별 매출액, 월별 매출액)
public class FranchiseDB {	
	
	//지점명
	public static String FranchiseManagerName(String bname) {		
		String manager_name = null;
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

            query = "SELECT * FROM MANAGER_TABLE WHERE G_BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				manager_name = rset.getString("G_NAME");

				return manager_name;
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
		return manager_name;
	}
	
	//지점 전화번호
	public static String FranchisePhone(String bname) {
		String franchise_phone = null;
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");

            query = "SELECT * FROM MANAGER_TABLE WHERE G_BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				franchise_phone = rset.getString("G_BPHONE");
				
				return franchise_phone;
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
		return franchise_phone;
	}
	
	//일별 커피 매출액
	public static int FranchiseDayCoffeeSales(String bname) {
		int franchise_day_sales = 0;
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

			while (rset.next()) {
				franchise_day_sales += rset.getInt("ICE_D") + rset.getInt("HOT_D");
			}
			
			return franchise_day_sales*2500;
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
		return franchise_day_sales;
	}
	
	//일별 스무디 매출액
	public static int FranchiseDaySmoothieSales(String bname) {
		int franchise_day_sales = 0;
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
			
			while (rset.next()) {
				franchise_day_sales += rset.getInt("ORANGE_D") + rset.getInt("KIWI_D") + rset.getInt("GRAPE_D") + rset.getInt("STRAW_D") + rset.getInt("WATER_D");
			}
			
			return franchise_day_sales*3500;
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
		return franchise_day_sales;
	}
	
	//일별 차 매출액
	public static int FranchiseDayTeaSales(String bname) {
		int franchise_day_sales = 0;
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

			while (rset.next()) {
				franchise_day_sales += rset.getInt("GREEN_D") + rset.getInt("BLACK_D");
			}
			
			return franchise_day_sales*3000;
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
		return franchise_day_sales;
	}
	
	//일별 버블티 매출액
	public static int FranchiseDayBubbleSales(String bname) {
		int franchise_day_sales = 0;
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

			while (rset.next()) {
				franchise_day_sales += rset.getInt("BS_D") + rset.getInt("TARO_D") + rset.getInt("GB_D");
			}
			
			return franchise_day_sales*4000;
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
		return franchise_day_sales;
	}
	
	//일별 케이크 매출액
	public static int FranchiseDayCakeSales(String bname) {
		int franchise_day_sales = 0;
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

			while (rset.next()) {
				franchise_day_sales += rset.getInt("CHEESE_D") + rset.getInt("SC_D") + rset.getInt("CHOCO_D");
			}
			
			return franchise_day_sales*5000;
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
		return franchise_day_sales;
	}
	
	//일별 마카롱 매출액
	public static int FranchiseDayMacaronSales(String bname) {
		int franchise_day_sales = 0;
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

			while (rset.next()) {
				franchise_day_sales += rset.getInt("BERRY_D") + rset.getInt("YOGURT_D") + rset.getInt("FRUIT_D");
			}
			
			return franchise_day_sales*2500;
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
		return franchise_day_sales;
	}
	
	//일별 총 매출액
	public static int FranchiseDaySales(String bname) {
		int franchise_day_sales = 0;
		
		franchise_day_sales = FranchiseDayCoffeeSales(bname) + FranchiseDaySmoothieSales(bname) + FranchiseDayTeaSales(bname) + FranchiseDayBubbleSales(bname) + FranchiseDayCakeSales(bname) + FranchiseDayMacaronSales(bname);
		
		return franchise_day_sales;
	}
	
	//월별 커피 매출액
	public static int FranchiseMonthCoffeeSales(String bname) {
		int franchise_month_sales = 0;
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

			while (rset.next()) {
				franchise_month_sales += rset.getInt("ICE_M") + rset.getInt("HOT_M");
			}

			return franchise_month_sales*2500;
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
		return franchise_month_sales;
	}
	
	//월별 스무디 매출액
	public static int FranchiseMonthSmoothieSales(String bname) {
		int franchise_month_sales = 0;
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

			while (rset.next()) {
				franchise_month_sales += rset.getInt("ORANGE_M") + rset.getInt("KIWI_M") + rset.getInt("GRAPE_M") + rset.getInt("STRAW_M") + rset.getInt("WATER_M");
			}

			return franchise_month_sales*3500;
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
		return franchise_month_sales;
	}
	
	//월별 차 매출액
	public static int FranchiseMonthTeaSales(String bname) {
		int franchise_month_sales = 0;
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
			while (rset.next()) {
				franchise_month_sales += rset.getInt("GREEN_M") + rset.getInt("BLACK_M");
			}
			
			return franchise_month_sales*3000;
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
		return franchise_month_sales;
	}
	
	//월별 버블티 매출액
	public static int FranchiseMonthBubbleSales(String bname) {
		int franchise_month_sales = 0;
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
			while (rset.next()) {
				franchise_month_sales += rset.getInt("BS_M") + rset.getInt("TARO_M") + rset.getInt("GB_M");
			}
			
			return franchise_month_sales*4000;
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
		return franchise_month_sales;
	}
	
	//월별 케이크 매출액
	public static int FranchiseMonthCakeSales(String bname) {
		int franchise_month_sales = 0;
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
			while (rset.next()) {
				franchise_month_sales += rset.getInt("CHEESE_M") + rset.getInt("SC_M") + rset.getInt("CHOCO_M");
			}

			return franchise_month_sales*5000;
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
		return franchise_month_sales;
	}
	
	//월별 마카롱 매출액
	public static int FranchiseMonthMacaronSales(String bname) {
		int franchise_month_sales = 0;
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
			while (rset.next()) {
				franchise_month_sales += rset.getInt("BERRY_M") + rset.getInt("YOGURT_M") + rset.getInt("FRUIT_M");
			}

			return franchise_month_sales*2500;
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
		return franchise_month_sales;
	}
	
	//월별 총 매출액
	public static int FranchiseMonthSales(String bname) {
		int franchise_month_sales = 0;
		
		franchise_month_sales = FranchiseMonthCoffeeSales(bname) + FranchiseMonthSmoothieSales(bname) + FranchiseMonthTeaSales(bname) + FranchiseMonthBubbleSales(bname) + FranchiseMonthCakeSales(bname) + FranchiseMonthMacaronSales(bname);
		
		return franchise_month_sales;
	}
}
