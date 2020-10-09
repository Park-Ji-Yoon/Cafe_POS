package Manager;

import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Manager.Manager_List;

//DB ó��
public class ManagerDAO {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";

	private static final String USER = "system"; // DB ID
	private static final String PASS = "rootpassword"; // DB �н�����
	Manager_List mList;

	public ManagerDAO() {

	}

	public ManagerDAO(Manager_List mList) {
		this.mList = mList;
		System.out.println("DAO=>" + mList);
	}

	/** DB���� �޼ҵ� */
	public Connection getConn() {
		Connection con = null;

		try {
			Class.forName(DRIVER); // 1. ����̹� �ε�
			con = DriverManager.getConnection(URL, USER, PASS); // 2. ����̹� ����

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	/** �ѻ���� ȸ�� ������ ��� �޼ҵ� */
	public ManagerDTO getMemberDTO(String id) {

		ManagerDTO dto = new ManagerDTO();

		Connection con = null; // ����
		PreparedStatement ps = null; // ���
		ResultSet rs = null; // ���

		try {

			con = getConn();
			String sql = "select * from MANAGER_TABLE where G_ID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				dto.setG_name(rs.getString("G_NAME"));
				dto.setG_id(rs.getString("G_ID"));
				dto.setG_pw(rs.getString("G_PW"));
				dto.setG_bname(rs.getString("G_BNAME"));
				dto.setG_bphone(rs.getString("G_BPHONE"));
				dto.setG_em(rs.getInt("G_EM"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	/** �������Ʈ ��� */
	public Vector getMemberList() {

		Vector data = new Vector(); // Jtable�� ���� ���� �ִ� ��� 1. 2�����迭 2. Vector �� vector�߰�

		Connection con = null; // ����
		PreparedStatement ps = null; // ���
		ResultSet rs = null; // ���

		try {

			con = getConn();
			String sql = "select * from MANAGER_TABLE order by G_NAME asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String g_name = rs.getString("G_NAME");
				String g_id = rs.getString("G_ID");
				String g_pw = rs.getString("G_PW");
				String g_bname = rs.getString("G_BNAME");
				String g_bphone = rs.getString("G_BPHONE");
				int g_em = rs.getInt("G_EM");

				Vector row = new Vector();
				row.add(g_name);
				row.add(g_id);
				row.add(g_pw);
				row.add(g_bname);
				row.add(g_bphone);
				row.add(g_em);

				data.add(row);
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}// getMemberList()

	/** ȸ�� ��� */
	public boolean insertMember(ManagerDTO dto) {
		boolean ok = false;
		boolean coffee_ok = false;
		boolean smoothie_ok = false;
		boolean tea_ok = false;
		boolean bubble_ok = false;
		boolean cake_ok = false;
		boolean macaron_ok = false;

		Connection con = null; // ����
		PreparedStatement ps = null; // ���

		Connection coffee_con = null; // ����
		PreparedStatement coffee_ps = null; // ���
		
		Connection smoothie_con = null; // ����
		PreparedStatement smoothie_ps = null; // ���
		
		Connection tea_con = null; // ����
		PreparedStatement tea_ps = null; // ���
		
		Connection bubble_con = null; // ����
		PreparedStatement bubble_ps = null; // ���
		
		Connection cake_con = null; // ����
		PreparedStatement cake_ps = null; // ���
		
		Connection macaron_con = null; // ����
		PreparedStatement macaron_ps = null; // ���

		try {

			// ȸ��
			con = getConn();
			String sql = "insert into MANAGER_TABLE(" + "G_NAME,G_ID,G_PW,G_BNAME,G_BPHONE,G_EM) "
					+ "values(?,?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getG_name());
			ps.setString(2, dto.getG_id());
			ps.setString(3, dto.getG_pw());
			ps.setString(4, dto.getG_bname());
			ps.setString(5, dto.getG_bphone());
			ps.setInt(6, dto.getG_em());
			int r = ps.executeUpdate(); // ���� -> ����
			if (r > 0)
				ok = true; // ������ �����Ǹ� ok���� true�� ����
			if (r > 0) {
				System.out.println("���� ����");
				ok = true;
			} else {
				System.out.println("���� ����");
			}

			// Ŀ��
			coffee_con = getConn();
			String coffee_sql = "insert into MENU_COFFEE(BNAME,ICE_D,ICE_M,ICE_S,HOT_D,HOT_M,HOT_S) "
					+ "values(?,?,?,?,?,?,?)";
			coffee_ps = coffee_con.prepareStatement(coffee_sql);
			coffee_ps.setString(1, dto.getG_bname());
			coffee_ps.setInt(2, 0);
			coffee_ps.setInt(3, 0);
			coffee_ps.setInt(4, 0);
			coffee_ps.setInt(5, 0);
			coffee_ps.setInt(6, 0);
			coffee_ps.setInt(7, 0);
			int coffee_r = coffee_ps.executeUpdate(); // ���� -> ����
			// 1~n: ���� , 0 : ����
			if (coffee_r > 0)
				coffee_ok = true; // ������ �����Ǹ� ok���� true�� ����
			if (coffee_r > 0) {
				System.out.println("Ŀ�� ���� ����");
				coffee_ok = true;
			} else {
				System.out.println("Ŀ�� ���� ����");
			}

			// ������
			smoothie_con = getConn();
			String smoothie_sql = "insert into MENU_SMOOTHIE(BNAME,ORANGE_D,ORANGE_M,ORANGE_S,KIWI_D,KIWI_M,KIWI_S,GRAPE_D,GRAPE_M,GRAPE_S,STRAW_D,STRAW_M,STRAW_S,WATER_D,WATER_M,WATER_S) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			smoothie_ps = smoothie_con.prepareStatement(smoothie_sql);
			smoothie_ps.setString(1, dto.getG_bname());
			smoothie_ps.setInt(2, 0);
			smoothie_ps.setInt(3, 0);
			smoothie_ps.setInt(4, 0);
			smoothie_ps.setInt(5, 0);
			smoothie_ps.setInt(6, 0);
			smoothie_ps.setInt(7, 0);
			smoothie_ps.setInt(8, 0);
			smoothie_ps.setInt(9, 0);
			smoothie_ps.setInt(10, 0);
			smoothie_ps.setInt(11, 0);
			smoothie_ps.setInt(12, 0);
			smoothie_ps.setInt(13, 0);
			smoothie_ps.setInt(14, 0);
			smoothie_ps.setInt(15, 0);
			smoothie_ps.setInt(16, 0);
			int smoothie_r = smoothie_ps.executeUpdate(); // ���� -> ����
			// 1~n: ���� , 0 : ����
			if (smoothie_r > 0)
				smoothie_ok = true; // ������ �����Ǹ� ok���� true�� ����
			if (smoothie_r > 0) {
				System.out.println("������ ���� ����");
				smoothie_ok = true;
			} else {
				System.out.println("������ ���� ����");
			}

			// ��
			tea_con = getConn();
			String tea_sql = "insert into MENU_TEA(BNAME,GREEN_D,GREEN_M,GREEN_S,BLACK_D,BLACK_M,BLACK_S) "
					+ "values(?,?,?,?,?,?,?)";
			tea_ps = tea_con.prepareStatement(tea_sql);
			tea_ps.setString(1, dto.getG_bname());
			tea_ps.setInt(2, 0);
			tea_ps.setInt(3, 0);
			tea_ps.setInt(4, 0);
			tea_ps.setInt(5, 0);
			tea_ps.setInt(6, 0);
			tea_ps.setInt(7, 0);
			int tea_r = tea_ps.executeUpdate(); // ���� -> ����
			// 1~n: ���� , 0 : ����
			if (tea_r > 0)
				tea_ok = true; // ������ �����Ǹ� ok���� true�� ����
			if (tea_r > 0) {
				System.out.println("�� ���� ����");
				tea_ok = true;
			} else {
				System.out.println("�� ���� ����");
			}

			// ����Ƽ
			bubble_con = getConn();
			String bubble_sql = "insert into MENU_BUBBLE(BNAME,BS_D,BS_M,BS_S,TARO_D,TARO_M,TARO_S,GB_D,GB_M,GB_S) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			bubble_ps = bubble_con.prepareStatement(bubble_sql);
			bubble_ps.setString(1, dto.getG_bname());
			bubble_ps.setInt(2, 0);
			bubble_ps.setInt(3, 0);
			bubble_ps.setInt(4, 0);
			bubble_ps.setInt(5, 0);
			bubble_ps.setInt(6, 0);
			bubble_ps.setInt(7, 0);
			bubble_ps.setInt(8, 0);
			bubble_ps.setInt(9, 0);
			bubble_ps.setInt(10, 0);
			int bubble_r = bubble_ps.executeUpdate(); // ���� -> ����
			// 1~n: ���� , 0 : ����
			if (bubble_r > 0)
				bubble_ok = true; // ������ �����Ǹ� ok���� true�� ����
			if (bubble_r > 0) {
				System.out.println("����Ƽ ���� ����");
				bubble_ok = true;
			} else {
				System.out.println("����Ƽ ���� ����");
			}

			// ����ũ
			cake_con = getConn();
			String cake_sql = "insert into MENU_CAKE(BNAME,CHEESE_D,CHEESE_M,CHEESE_S,SC_D,SC_M,SC_S,CHOCO_D,CHOCO_M,CHOCO_S) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			cake_ps = cake_con.prepareStatement(cake_sql);
			cake_ps.setString(1, dto.getG_bname());
			cake_ps.setInt(2, 0);
			cake_ps.setInt(3, 0);
			cake_ps.setInt(4, 0);
			cake_ps.setInt(5, 0);
			cake_ps.setInt(6, 0);
			cake_ps.setInt(7, 0);
			cake_ps.setInt(8, 0);
			cake_ps.setInt(9, 0);
			cake_ps.setInt(10, 0);
			int cake_r = cake_ps.executeUpdate(); // ���� -> ����
			// 1~n: ���� , 0 : ����
			if (cake_r > 0)
				cake_ok = true; // ������ �����Ǹ� ok���� true�� ����
			if (cake_r > 0) {
				System.out.println("Ŀ�� ���� ����");
				cake_ok = true;
			} else {
				System.out.println("Ŀ�� ���� ����");
			}

			// ��ī��
			macaron_con = getConn();
			String macaron_sql = "insert into MENU_MACARON(BNAME,BERRY_D,BERRY_M,BERRY_S,YOGURT_D,YOGURT_M,YOGURT_S,FRUIT_D,FRUIT_M,FRUIT_S) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			macaron_ps = macaron_con.prepareStatement(macaron_sql);
			macaron_ps.setString(1, dto.getG_bname());
			macaron_ps.setInt(2, 0);
			macaron_ps.setInt(3, 0);
			macaron_ps.setInt(4, 0);
			macaron_ps.setInt(5, 0);
			macaron_ps.setInt(6, 0);
			macaron_ps.setInt(7, 0);
			macaron_ps.setInt(8, 0);
			macaron_ps.setInt(9, 0);
			macaron_ps.setInt(10, 0);
			int macaron_r = macaron_ps.executeUpdate(); // ���� -> ����
			// 1~n: ���� , 0 : ����
			if (macaron_r > 0)
				macaron_ok = true; // ������ �����Ǹ� ok���� true�� ����
			if (macaron_r > 0) {
				System.out.println("��ī�� ���� ����");
				macaron_ok = true;
			} else {
				System.out.println("��ī�� ���� ����");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}// insertMmeber

	/** ȸ������ ���� */
	public boolean updateMember(ManagerDTO vMem) {
		System.out.println("dto=" + vMem.toString());
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = getConn();
			String sql = "update MANAGER_TABLE set G_NAME=?, G_BNAME=?, G_BPHONE=?, G_EM=? " + "where G_PW=?";

			ps = con.prepareStatement(sql);

			ps.setString(1, vMem.getG_name());
			ps.setString(2, vMem.getG_bname());
			ps.setString(3, vMem.getG_bphone());
			ps.setInt(4, vMem.getG_em());
			ps.setString(5, vMem.getG_pw());

			int r = ps.executeUpdate(); // ���� -> ����
			// 1~n: ���� , 0 : ����

			if (r > 0)
				ok = true; // ������ �����Ǹ� ok���� true�� ����

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	/**
	 * ȸ������ ���� : tip: �ǹ������� ȸ�������� Delete ���� �ʰ� Ż�𿩺θ� üũ�Ѵ�.
	 */
	public boolean deleteMember(String bname, String pwd) {

		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		
		boolean coffee_ok = false;
		Connection coffee_con = null;
		PreparedStatement coffee_ps = null;
		
		boolean smoothie_ok = false;
		Connection smoothie_con = null;
		PreparedStatement smoothie_ps = null;
		
		boolean tea_ok = false;
		Connection tea_con = null;
		PreparedStatement tea_ps = null;
		
		boolean bubble_ok = false;
		Connection bubble_con = null;
		PreparedStatement bubble_ps = null;
		
		boolean cake_ok = false;
		Connection cake_con = null;
		PreparedStatement cake_ps = null;
		
		boolean macaron_ok = false;
		Connection macaron_con = null;
		PreparedStatement macaron_ps = null;

		try {
			con = getConn();
			String sql = "delete from MANAGER_TABLE where G_PW=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, pwd);
			int r = ps.executeUpdate(); // ���� -> ����
			if (r > 0)
				ok = true; // ������;
			
			coffee_con = getConn();
			String coffee_sql = "delete from MENU_COFFEE where BNAME=?";
			coffee_ps = coffee_con.prepareStatement(coffee_sql);
			coffee_ps.setString(1, bname);
			int coffee_r = coffee_ps.executeUpdate(); // ���� -> ����
			if (coffee_r > 0)
				coffee_ok = true; // ������;
			
			smoothie_con = getConn();
			String smoothie_sql = "delete from MENU_SMOOTHIE where BNAME=?";
			smoothie_ps = smoothie_con.prepareStatement(smoothie_sql);
			smoothie_ps.setString(1, bname);
			int smoothie_r = smoothie_ps.executeUpdate(); // ���� -> ����
			if (smoothie_r > 0)
				smoothie_ok = true; // ������;
			
			tea_con = getConn();
			String tea_sql = "delete from MENU_TEA where BNAME=?";
			tea_ps = tea_con.prepareStatement(tea_sql);
			tea_ps.setString(1, bname);
			int tea_r = tea_ps.executeUpdate(); // ���� -> ����
			if (tea_r > 0)
				tea_ok = true; // ������;
			
			bubble_con = getConn();
			String bubble_sql = "delete from MENU_BUBBLE where BNAME=?";
			bubble_ps = bubble_con.prepareStatement(bubble_sql);
			bubble_ps.setString(1, bname);
			int bubble_r = bubble_ps.executeUpdate(); // ���� -> ����
			if (bubble_r > 0)
				bubble_ok = true; // ������;
			
			cake_con = getConn();
			String cake_sql = "delete from MENU_CAKE where BNAME=?";
			cake_ps = cake_con.prepareStatement(cake_sql);
			cake_ps.setString(1, bname);
//            ps.setString(2, pwd);
			int cake_r = cake_ps.executeUpdate(); // ���� -> ����
			if (cake_r > 0)
				cake_ok = true; // ������;
			
			macaron_con = getConn();
			String macaron_sql = "delete from MENU_MACARON where BNAME=?";
			macaron_ps = macaron_con.prepareStatement(macaron_sql);
			macaron_ps.setString(1, bname);
			int macaron_r = macaron_ps.executeUpdate(); // ���� -> ����
			if (macaron_r > 0)
				macaron_ok = true; // ������;

		} catch (Exception e) {
			System.out.println(e + "-> �����߻�");
		}
		return ok;
	}

	/** DB������ �ٽ� �ҷ����� */
	public void userSelectAll(DefaultTableModel model) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();
			String sql = "select * from MANAGER_TABLE order by G_NAME asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			// DefaultTableModel�� �ִ� ������ �����
			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6) };

				model.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> userSelectAll fail");
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}