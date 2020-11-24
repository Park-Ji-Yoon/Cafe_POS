package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//�ֹ����� ��� ��
public class StockDB {
	//Ŀ�� �ֹ��� ��� ��
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
				//���̽� �ֹ��� ��� ��
				if(rset.getInt("ICE_S") < icecount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "ICE COFFEE", JOptionPane.ERROR_MESSAGE);		
					return -1;
				}
				
				//�� �ֹ��� ��� ��
				if(rset.getInt("HOT_S")  < hotcount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "HOT COFFEE", JOptionPane.ERROR_MESSAGE);		
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
	
	//������ �ֹ��� ��� ��
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
				//������ �ֹ��� ��� ��
				if(rset.getInt("ORANGE_S") < orangecount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "ORANGE SMOOTHIE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//Ű�� �ֹ��� ��� ��
				if(rset.getInt("KIWI_S") < kiwicount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "KIWI SMOOTHIE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//���� �ֹ��� ��� ��
				if(rset.getInt("GRAPE_S") < grapecount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "GRAPE SMOOTHIE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//���� �ֹ��� ��� ��
				if(rset.getInt("STRAW_S") < strawcount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "STRAW SMOOTHIE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//���� �ֹ��� ��� ��
				if(rset.getInt("WATER_S") < watercount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "WATER SMOOTHIE", JOptionPane.ERROR_MESSAGE);
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
	
	//�� �ֹ��� ��� ��
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
				//���� �ֹ��� ��� ��
				if(rset.getInt("GREEN_S") < greencount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "GREEN TEA", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//ȫ�� �ֹ��� ��� ��
				if(rset.getInt("BLACK_S") < blackcount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "BLACK TEA", JOptionPane.ERROR_MESSAGE);
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
	
	//����Ƽ �ֹ��� ��� ��
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
				//��� �ֹ��� ��� ��
				if(rset.getInt("BS_S") < bscount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "BROWNSUGAR BUBBLETEA", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//Ÿ�� �ֹ��� ��� ��
				if(rset.getInt("TARO_S") < tarocount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "TARO BUBBLETEA", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//���� �ֹ��� ��� ��
				if(rset.getInt("GB_S") < gbcount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "GREEN BUBBLETEA", JOptionPane.ERROR_MESSAGE);
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
	
	//����ũ �ֹ��� ��� ��
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
				//ġ�� �ֹ��� ��� ��
				if(rset.getInt("CHEESE_S") < cheesecount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "CHEESE CAKE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//���� �ֹ��� ��� ��
				if(rset.getInt("SC_S") < sccount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "STRAWBERRY CAKE", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				
				//���� �ֹ��� ��� ��
				if(rset.getInt("CHOCO_S") < chococount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "CHOCOLATE CAKE", JOptionPane.ERROR_MESSAGE);
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
	
	//��ī�� �ֹ��� ��� ��
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
				//���� �ֹ��� ��� ��
				if(rset.getInt("BERRY_S") < berrycount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "BERRY MACARON", JOptionPane.ERROR_MESSAGE);		
					return -1;
				}
				
				//���Ʈ �ֹ��� ��� ��
				if(rset.getInt("YOGURT_S") < yogurtcount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "YOGURT MACARON", JOptionPane.ERROR_MESSAGE);	
					return -1;	
				}
				
				//���� �ֹ��� ��� ��
				if(rset.getInt("FRUIT_S") < fruitcount) {
					JOptionPane.showMessageDialog(null, "�ֹ����� ����� �����ϴ�.", "FRUIT MACARON", JOptionPane.ERROR_MESSAGE);	
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
