package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//주문량과 재고 비교
public class StockDB {
	//커피 주문량 재고 비교
	public static int CoffeStockDB(String bname, int icecount, int hotcount) {
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
				//아이스 주문량 재고 비교
				if(rset.getInt("ICE_S") < icecount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "ICE COFFEE", JOptionPane.ERROR_MESSAGE);		
					return -1;
				}
				
				//핫 주문량 재고 비교
				if(rset.getInt("HOT_S")  < hotcount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "HOT COFFEE", JOptionPane.ERROR_MESSAGE);		
					return -1;
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
		return 0;
	}
	
	//스무디 주문량 재고 비교
	public static int SmoothieStockDB(String bname, int orangecount, int kiwicount, int grapecount, int strawcount, int watercount) {
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
			
			while(rset.next()) {
				//오렌지 주문량 재고 비교
				if(rset.getInt("ORANGE_S") < orangecount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "ORANGE SMOOTHIE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//키위 주문량 재고 비교
				if(rset.getInt("KIWI_S") < kiwicount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "KIWI SMOOTHIE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//포도 주문량 재고 비교
				if(rset.getInt("GRAPE_S") < grapecount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "GRAPE SMOOTHIE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//딸기 주문량 재고 비교
				if(rset.getInt("STRAW_S") < strawcount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "STRAW SMOOTHIE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//수박 주문량 재고 비교
				if(rset.getInt("WATER_S") < watercount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "WATER SMOOTHIE", JOptionPane.ERROR_MESSAGE);
					return -1;
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
		return 0;
	}
	
	//차 주문량 재고 비교
	public static int TeaStockDB(String bname, int greencount, int blackcount) {
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
			
			while(rset.next()) {
				//녹차 주문량 재고 비교
				if(rset.getInt("GREEN_S") < greencount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "GREEN TEA", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//홍차 주문량 재고 비교
				if(rset.getInt("BLACK_S") < blackcount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "BLACK TEA", JOptionPane.ERROR_MESSAGE);
					return -1;
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
		return 0;
	}
	
	//버블티 주문량 재고 비교
	public static int BubbleStockDB(String bname, int bscount, int tarocount, int gbcount) {
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
			
			while(rset.next()) {				
				//흑당 주문량 재고 비교
				if(rset.getInt("BS_S") < bscount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "BROWNSUGAR BUBBLETEA", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//타로 주문량 재고 비교
				if(rset.getInt("TARO_S") < tarocount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "TARO BUBBLETEA", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//녹차 주문량 재고 비교
				if(rset.getInt("GB_S") < gbcount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "GREEN BUBBLETEA", JOptionPane.ERROR_MESSAGE);
					return -1;
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
		return 0;
	}
	
	//케이크 주문량 재고 비교
	public static int CakeStockDB(String bname,int cheesecount, int sccount, int chococount) {
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
			
			while(rset.next()) {
				//치즈 주문량 재고 비교
				if(rset.getInt("CHEESE_S") < cheesecount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "CHEESE CAKE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//딸기 주문량 재고 비교
				if(rset.getInt("SC_S") < sccount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "STRAWBERRY CAKE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//초코 주문량 재고 비교
				if(rset.getInt("CHOCO_S") < chococount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "CHOCOLATE CAKE", JOptionPane.ERROR_MESSAGE);
					return -1;
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
		return 0;
	}
	
	//마카롱 주문량 재고 비교
	public static int MacaronStockDB(String bname, int berrycount, int yogurtcount, int fruitcount) {
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
				//베리 주문량 재고 비교
				if(rset.getInt("BERRY_S") < berrycount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "BERRY MACARON", JOptionPane.ERROR_MESSAGE);		
					return -1;
				}
				
				//요거트 주문량 재고 비교
				if(rset.getInt("YOGURT_S") < yogurtcount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "YOGURT MACARON", JOptionPane.ERROR_MESSAGE);	
					return -1;	
				}
				
				//과일 주문량 재고 비교
				if(rset.getInt("FRUIT_S") < fruitcount) {
					JOptionPane.showMessageDialog(null, "주문량이 재고보다 많습니다.", "FRUIT MACARON", JOptionPane.ERROR_MESSAGE);	
					return -1;	
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
		return 0;
	}
}
