package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SalesGUI {
	public static void main(String args[]) {
		SalesPanel sales_panel = new SalesPanel();
	}
}
class SalesPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_30.png");

	JButton franchise_exit_button = new JButton(icon);
	JButton coffe_sales_button = new JButton(icon);
	JButton smoothie_sales_button = new JButton(icon);
	JButton tea_sales_button = new JButton(icon);
	JButton bubble_sales_button = new JButton(icon);
	JButton cake_sales_button = new JButton(icon);
	JButton macaron_sales_button = new JButton(icon);
	JButton panel_button = new JButton(icon);

	SalesPanel() {
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//매출관리 취소
		franchise_exit_button.setBounds(61, 35, 126, 35);
		franchise_exit_button.setVisible(true);
		franchise_exit_button.setBorderPainted(false);
		franchise_exit_button.setContentAreaFilled(false);
		franchise_exit_button.setFocusPainted(false);
		franchise_exit_button.setOpaque(false);
		franchise_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getMaster_panel().setVisible(true);
				Main.MainFrame.getFranchise_panel().setVisible(false);
			}
		});
		add(franchise_exit_button);

		//커피 매출액 버튼
		coffe_sales_button.setBounds(115, 184, 67, 30);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//스무디 매출액 버튼
		smoothie_sales_button.setBounds(412, 184, 103, 35);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//차 매출액 버튼
		tea_sales_button.setBounds(755, 182, 35, 32);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//버블티 매출액 버튼
		bubble_sales_button.setBounds(1035, 183, 103, 39);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//케이크 매출액 버튼
		cake_sales_button.setBounds(1338, 184, 107, 30);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//마카롱 매출액 버튼
		macaron_sales_button.setBounds(1655, 184, 106, 39);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);

		//판넬 버튼
		panel_button.setBounds(0, 223, 1861, 800);
		panel_button.setVisible(true);
		panel_button.setBorderPainted(false);
		panel_button.setContentAreaFilled(false);
		panel_button.setFocusPainted(false);
		panel_button.setOpaque(false);
		panel_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "매출액을 확인할 메뉴를 선택해주십시오.", "Error", JOptionPane.ERROR_MESSAGE);	
			}
		});
		add(panel_button);		
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
}
class GCoffeeSalesPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_24.png");

	JButton sales_exit_button = new JButton(icon);
	JButton smoothie_sales_button = new JButton(icon);
	JButton tea_sales_button = new JButton(icon);
	JButton bubble_sales_button = new JButton(icon);
	JButton cake_sales_button = new JButton(icon);
	JButton macaron_sales_button = new JButton(icon);

	JLabel ice_d = new JLabel();
	JLabel ice_m = new JLabel();
	JLabel hot_d = new JLabel();
	JLabel hot_m = new JLabel();

	String bname = ManagerPanel.getBname();
	int ice_d_db;
	int ice_m_db;
	int hot_d_db;
	int hot_m_db;

	GCoffeeSalesPanel() {
		coffee_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//매출관리 취소
		sales_exit_button.setBounds(61, 35, 126, 35);
		sales_exit_button.setVisible(true);
		sales_exit_button.setBorderPainted(false);
		sales_exit_button.setContentAreaFilled(false);
		sales_exit_button.setFocusPainted(false);
		sales_exit_button.setOpaque(false);
		sales_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGCoffee_sales_panel().setVisible(false);
			}
		});
		add(sales_exit_button);

		//스무디 매출액 버튼
		smoothie_sales_button.setBounds(402, 180, 114, 40);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getGCoffee_sales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//차 매출액 버튼
		tea_sales_button.setBounds(745, 178, 39, 36);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getGCoffee_sales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//버블티 매출액 버튼
		bubble_sales_button.setBounds(1025, 179, 113, 43);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getGCoffee_sales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//케이크 매출액 버튼
		cake_sales_button.setBounds(1329, 180, 116, 35);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getGCoffee_sales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//마카롱 매출액 버튼
		macaron_sales_button.setBounds(1645, 180, 116, 43);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getGCoffee_sales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);

		//아이스 일별
		ice_d.setBounds(762, 551, 312, 121);
		ice_d.setText(Integer.toString(ice_d_db));
		ice_d.setHorizontalAlignment(JLabel.CENTER);
		ice_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(ice_d);

		//아이스 월별
		ice_m.setBounds(1078, 551, 320, 121);
		ice_m.setText(Integer.toString(ice_m_db));
		ice_m.setHorizontalAlignment(JLabel.CENTER);
		ice_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(ice_m);

		//핫 일별
		hot_d.setBounds(762, 675, 312, 134);
		hot_d.setText(Integer.toString(hot_d_db));
		hot_d.setHorizontalAlignment(JLabel.CENTER);
		hot_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(hot_d);

		//핫 월별
		hot_m.setBounds(1078, 675, 320, 134);
		hot_m.setText(Integer.toString(hot_m_db));
		hot_m.setHorizontalAlignment(JLabel.CENTER);
		hot_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(hot_m);
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	public void coffee_db() {		
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
            	ice_d_db = rset.getInt("ICE_D") * 2500;
            	ice_m_db = rset.getInt("ICE_M") * 2500;
            	hot_d_db = rset.getInt("HOT_D") * 2500;
            	hot_m_db = rset.getInt("HOT_M") * 2500;
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
class GSmoothieSalesPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_25.png");

	JButton sales_exit_button = new JButton(icon);
	JButton coffe_sales_button = new JButton(icon);
	JButton tea_sales_button = new JButton(icon);
	JButton bubble_sales_button = new JButton(icon);
	JButton cake_sales_button = new JButton(icon);
	JButton macaron_sales_button = new JButton(icon);

	JLabel orange_d = new JLabel();
	JLabel orange_m = new JLabel();
	JLabel kiwi_d = new JLabel();
	JLabel kiwi_m = new JLabel();
	JLabel grape_d = new JLabel();
	JLabel grape_m = new JLabel();
	JLabel straw_d = new JLabel();
	JLabel straw_m = new JLabel();
	JLabel water_d = new JLabel();
	JLabel water_m = new JLabel();

	String bname = ManagerPanel.getBname();
	int orange_d_db;
	int orange_m_db;
	int kiwi_d_db;
	int kiwi_m_db;
	int grape_d_db;
	int grape_m_db;
	int straw_d_db;
	int straw_m_db;
	int water_d_db;
	int water_m_db;
	
	GSmoothieSalesPanel() {
		smoothie_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//매출관리 취소
		sales_exit_button.setBounds(61, 35, 126, 35);
		sales_exit_button.setVisible(true);
		sales_exit_button.setBorderPainted(false);
		sales_exit_button.setContentAreaFilled(false);
		sales_exit_button.setFocusPainted(false);
		sales_exit_button.setOpaque(false);
		sales_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(false);
			}
		});
		add(sales_exit_button);

		//커피 매출액 버튼
		coffe_sales_button.setBounds(111, 180, 73, 34);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//차 매출액 버튼
		tea_sales_button.setBounds(745, 178, 39, 36);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//버블티 매출액 버튼
		bubble_sales_button.setBounds(1025, 179, 113, 43);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//케이크 매출액 버튼
		cake_sales_button.setBounds(1329, 180, 116, 35);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//마카롱 매출액 버튼
		macaron_sales_button.setBounds(1645, 180, 116, 43);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);

		//오렌지 일별
		orange_d.setBounds(762, 429, 312, 102);
		orange_d.setText(Integer.toString(orange_d_db));
		orange_d.setHorizontalAlignment(JLabel.CENTER);
		orange_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(orange_d);

		//오렌지 월별
		orange_m.setBounds(1078, 429, 321, 102);
		orange_m.setText(Integer.toString(orange_m_db));
		orange_m.setHorizontalAlignment(JLabel.CENTER);
		orange_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(orange_m);

		//키위 일별
		kiwi_d.setBounds(762, 535, 312, 102);
		kiwi_d.setText(Integer.toString(kiwi_d_db));
		kiwi_d.setHorizontalAlignment(JLabel.CENTER);
		kiwi_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(kiwi_d);

		//키위 월별
		kiwi_m.setBounds(1078, 535, 321, 102);
		kiwi_m.setText(Integer.toString(kiwi_m_db));
		kiwi_m.setHorizontalAlignment(JLabel.CENTER);
		kiwi_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(kiwi_m);

		//포도 일별
		grape_d.setBounds(762, 641, 312, 102);
		grape_d.setText(Integer.toString(grape_d_db));
		grape_d.setHorizontalAlignment(JLabel.CENTER);
		grape_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(grape_d);

		//포도 월별
		grape_m.setBounds(1078, 641, 321, 102);
		grape_m.setText(Integer.toString(grape_m_db));
		grape_m.setHorizontalAlignment(JLabel.CENTER);
		grape_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(grape_m);

		//딸기 일별
		straw_d.setBounds(762, 747, 312, 102);
		straw_d.setText(Integer.toString(straw_d_db));
		straw_d.setHorizontalAlignment(JLabel.CENTER);
		straw_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(straw_d);

		//딸기 월별
		straw_m.setBounds(1078, 747, 321, 102);
		straw_m.setText(Integer.toString(straw_m_db));
		straw_m.setHorizontalAlignment(JLabel.CENTER);
		straw_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(straw_m);

		//수박 일별
		water_d.setBounds(762, 853, 312, 106);
		water_d.setText(Integer.toString(water_d_db));
		water_d.setHorizontalAlignment(JLabel.CENTER);
		water_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(water_d);

		//수박 월별
		water_m.setBounds(1078, 853, 321, 106);
		water_m.setText(Integer.toString(water_m_db));
		water_m.setHorizontalAlignment(JLabel.CENTER);
		water_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(water_m);
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	public void smoothie_db() {		
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
            	orange_d_db = rset.getInt("ORANGE_D") * 3500;
            	orange_m_db = rset.getInt("ORANGE_M") * 3500;
            	kiwi_d_db = rset.getInt("KIWI_D") * 3500;
            	kiwi_m_db = rset.getInt("KIWI_M") * 3500;
            	grape_d_db = rset.getInt("GRAPE_D") * 3500;
            	grape_m_db = rset.getInt("GRAPE_M") * 3500;
            	straw_d_db = rset.getInt("STRAW_D") * 3500;
            	straw_m_db = rset.getInt("STRAW_M") * 3500;
            	water_d_db = rset.getInt("WATER_D") * 3500;
            	water_m_db = rset.getInt("WATER_M") * 3500;
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
class GTeaSalesPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_26.png");

	JButton sales_exit_button = new JButton(icon);
	JButton coffe_sales_button = new JButton(icon);
	JButton smoothie_sales_button = new JButton(icon);
	JButton bubble_sales_button = new JButton(icon);
	JButton cake_sales_button = new JButton(icon);
	JButton macaron_sales_button = new JButton(icon);

	JLabel green_d = new JLabel();
	JLabel green_m = new JLabel();
	JLabel black_d = new JLabel();
	JLabel black_m = new JLabel();

	String bname = ManagerPanel.getBname();
	int green_d_db;;
	int green_m_db;
	int black_d_db;;
	int black_m_db;;

	GTeaSalesPanel() {
		tea_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//매출관리 취소
		sales_exit_button.setBounds(61, 35, 126, 35);
		sales_exit_button.setVisible(true);
		sales_exit_button.setBorderPainted(false);
		sales_exit_button.setContentAreaFilled(false);
		sales_exit_button.setFocusPainted(false);
		sales_exit_button.setOpaque(false);
		sales_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGTea_sales_panel().setVisible(false);
			}
		});
		add(sales_exit_button);

		//커피 매출액 버튼
		coffe_sales_button.setBounds(111, 180, 73, 34);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getGTea_sales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//스무디 매출액 버튼
		smoothie_sales_button.setBounds(402, 180, 114, 40);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getGTea_sales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//버블티 매출액 버튼
		bubble_sales_button.setBounds(1025, 179, 113, 43);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getGTea_sales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//케이크 매출액 버튼
		cake_sales_button.setBounds(1329, 180, 116, 35);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getGTea_sales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//마카롱 매출액 버튼
		macaron_sales_button.setBounds(1645, 180, 116, 43);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getGTea_sales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);

		//녹차 일별
		green_d.setBounds(762, 549, 312, 134);
		green_d.setText(Integer.toString(green_d_db));
		green_d.setHorizontalAlignment(JLabel.CENTER);
		green_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(green_d);

		//녹차 월별
		green_m.setBounds(1078, 549, 320, 134);
		green_m.setText(Integer.toString(green_m_db));
		green_m.setHorizontalAlignment(JLabel.CENTER);
		green_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(green_m);

		//홍차 일별
		black_d.setBounds(762, 686, 312, 134);
		black_d.setText(Integer.toString(black_d_db));
		black_d.setHorizontalAlignment(JLabel.CENTER);
		black_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(black_d);

		//홍차 월별
		black_m.setBounds(1078, 686, 320, 134);
		black_m.setText(Integer.toString(black_m_db));
		black_m.setHorizontalAlignment(JLabel.CENTER);
		black_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(black_m);
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	public void tea_db() {		
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
            	green_d_db = rset.getInt("GREEN_D") * 3000;
            	green_m_db = rset.getInt("GREEN_M") * 3000;
            	black_d_db = rset.getInt("BLACK_D") * 3000;
            	black_m_db = rset.getInt("BLACK_M") * 3000;
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
class GBubbleSalesPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_27.png");

	JButton sales_exit_button = new JButton(icon);
	JButton coffe_sales_button = new JButton(icon);
	JButton smoothie_sales_button = new JButton(icon);
	JButton tea_sales_button = new JButton(icon);
	JButton cake_sales_button = new JButton(icon);
	JButton macaron_sales_button = new JButton(icon);

	JLabel bs_d = new JLabel();
	JLabel bs_m = new JLabel();
	JLabel taro_d = new JLabel();
	JLabel taro_m = new JLabel();
	JLabel gb_d = new JLabel();
	JLabel gb_m = new JLabel();

	String bname = ManagerPanel.getBname();
	int bs_d_db;
	int bs_m_db;
	int taro_d_db;
	int taro_m_db;
	int gb_d_db;
	int gb_m_db;

	GBubbleSalesPanel() {
		bubble_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//매출관리 취소
		sales_exit_button.setBounds(61, 35, 126, 35);
		sales_exit_button.setVisible(true);
		sales_exit_button.setBorderPainted(false);
		sales_exit_button.setContentAreaFilled(false);
		sales_exit_button.setFocusPainted(false);
		sales_exit_button.setOpaque(false);
		sales_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGBubble_sales_panel().setVisible(false);
			}
		});
		add(sales_exit_button);

		//커피 매출액 버튼
		coffe_sales_button.setBounds(111, 180, 73, 34);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getGBubble_sales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//스무디 매출액 버튼
		smoothie_sales_button.setBounds(402, 180, 114, 40);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getGBubble_sales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//차 매출액 버튼
		tea_sales_button.setBounds(745, 178, 39, 36);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getGBubble_sales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//케이크 매출액 버튼
		cake_sales_button.setBounds(1329, 180, 116, 35);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getGBubble_sales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//마카롱 매출액 버튼
		macaron_sales_button.setBounds(1645, 180, 116, 43);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getGBubble_sales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);

		//흑당 일별
		bs_d.setBounds(762, 509, 312, 134);
		bs_d.setText(Integer.toString(bs_d_db));
		bs_d.setHorizontalAlignment(JLabel.CENTER);
		bs_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(bs_d);

		//흑당 월별
		bs_m.setBounds(1078, 509, 320, 134);
		bs_m.setText(Integer.toString(bs_m_db));
		bs_m.setHorizontalAlignment(JLabel.CENTER);
		bs_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(bs_m);

		//타로 일별
		taro_d.setBounds(762, 646, 312, 134);
		taro_d.setText(Integer.toString(taro_d_db));
		taro_d.setHorizontalAlignment(JLabel.CENTER);
		taro_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(taro_d);

		//타로 월별
		taro_m.setBounds(1078, 646, 320, 134);
		taro_m.setText(Integer.toString(taro_m_db));
		taro_m.setHorizontalAlignment(JLabel.CENTER);
		taro_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(taro_m);

		//녹차 일별
		gb_d.setBounds(762, 783, 312, 134);
		gb_d.setText(Integer.toString(gb_d_db));
		gb_d.setHorizontalAlignment(JLabel.CENTER);
		gb_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(gb_d);

		//녹차 월별
		gb_m.setBounds(1078, 783, 320, 134);
		gb_m.setText(Integer.toString(gb_m_db));
		gb_m.setHorizontalAlignment(JLabel.CENTER);
		gb_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(gb_m);
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	public void bubble_db() {		
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
            	bs_d_db = rset.getInt("BS_D") * 4000;
            	bs_m_db = rset.getInt("BS_M") * 4000;
            	taro_d_db = rset.getInt("TARO_D") * 4000;
            	taro_m_db = rset.getInt("TARO_M") * 4000;
            	gb_d_db = rset.getInt("GB_D") * 4000;
            	gb_m_db = rset.getInt("GB_M") * 4000;
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
class GCakeSalesPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_28.png");

	JButton sales_exit_button = new JButton(icon);
	JButton coffe_sales_button = new JButton(icon);
	JButton smoothie_sales_button = new JButton(icon);
	JButton tea_sales_button = new JButton(icon);
	JButton bubble_sales_button = new JButton(icon);
	JButton macaron_sales_button = new JButton(icon);

	JLabel cheese_d = new JLabel();
	JLabel cheese_m = new JLabel();
	JLabel sc_d = new JLabel();
	JLabel sc_m = new JLabel();
	JLabel choco_d = new JLabel();
	JLabel choco_m = new JLabel();

	String bname = ManagerPanel.getBname();
	int cheese_d_db;
	int cheese_m_db;
	int sc_d_db;
	int sc_m_db;
	int choco_d_db;
	int choco_m_db;

	GCakeSalesPanel() {
		cake_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//매출관리 취소
		sales_exit_button.setBounds(61, 35, 126, 35);
		sales_exit_button.setVisible(true);
		sales_exit_button.setBorderPainted(false);
		sales_exit_button.setContentAreaFilled(false);
		sales_exit_button.setFocusPainted(false);
		sales_exit_button.setOpaque(false);
		sales_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGCake_sales_panel().setVisible(false);
			}
		});
		add(sales_exit_button);

		//커피 매출액 버튼
		coffe_sales_button.setBounds(111, 180, 73, 34);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getGCake_sales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//스무디 매출액 버튼
		smoothie_sales_button.setBounds(402, 180, 114, 40);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getGCake_sales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//차 매출액 버튼
		tea_sales_button.setBounds(745, 178, 39, 36);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getGCake_sales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//버블티 매출액 버튼
		bubble_sales_button.setBounds(1025, 179, 113, 43);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getGCake_sales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//마카롱 매출액 버튼
		macaron_sales_button.setBounds(1645, 180, 116, 43);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getGCake_sales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);

		//치즈 일별
		cheese_d.setBounds(762, 509, 312, 134);
		cheese_d.setText(Integer.toString(cheese_d_db));
		cheese_d.setHorizontalAlignment(JLabel.CENTER);
		cheese_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(cheese_d);

		//치즈 월별
		cheese_m.setBounds(1078, 509, 320, 134);
		cheese_m.setText(Integer.toString(cheese_m_db));
		cheese_m.setHorizontalAlignment(JLabel.CENTER);
		cheese_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(cheese_m);

		//딸기 일별
		sc_d.setBounds(762, 646, 312, 134);
		sc_d.setText(Integer.toString(sc_d_db));
		sc_d.setHorizontalAlignment(JLabel.CENTER);
		sc_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(sc_d);

		//딸기 월별
		sc_m.setBounds(1078, 646, 320, 134);
		sc_m.setText(Integer.toString(sc_m_db));
		sc_m.setHorizontalAlignment(JLabel.CENTER);
		sc_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(sc_m);

		//초코 일별
		choco_d.setBounds(762, 783, 312, 134);
		choco_d.setText(Integer.toString(choco_d_db));
		choco_d.setHorizontalAlignment(JLabel.CENTER);
		choco_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(choco_d);

		//초코 월별
		choco_m.setBounds(1078, 783, 320, 134);
		choco_m.setText(Integer.toString(choco_m_db));
		choco_m.setHorizontalAlignment(JLabel.CENTER);
		choco_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(choco_m);
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	public void cake_db() {		
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
            	cheese_d_db = rset.getInt("CHEESE_D") * 5000;
            	cheese_m_db = rset.getInt("CHEESE_M") * 5000;
            	sc_d_db = rset.getInt("SC_D") * 5000;
            	sc_m_db = rset.getInt("SC_M") * 5000;
            	choco_d_db = rset.getInt("CHOCO_D") * 5000;
            	choco_m_db = rset.getInt("CHOCO_M") * 5000;
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
class GMacaronSalesPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_29.png");

	JButton sales_exit_button = new JButton(icon);
	JButton coffe_sales_button = new JButton(icon);
	JButton smoothie_sales_button = new JButton(icon);
	JButton tea_sales_button = new JButton(icon);
	JButton bubble_sales_button = new JButton(icon);
	JButton cake_sales_button = new JButton(icon);

	JLabel berry_d = new JLabel();
	JLabel berry_m = new JLabel();
	JLabel yogurt_d = new JLabel();
	JLabel yogurt_m = new JLabel();
	JLabel fruit_d = new JLabel();
	JLabel fruit_m = new JLabel();

	String bname = ManagerPanel.getBname();
	int berry_d_db;
	int berry_m_db;
	int yogurt_d_db;
	int yogurt_m_db;
	int fruit_d_db;
	int fruit_m_db;
	
	GMacaronSalesPanel() {
		macaron_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//매출관리 취소
		sales_exit_button.setBounds(61, 35, 126, 35);
		sales_exit_button.setVisible(true);
		sales_exit_button.setBorderPainted(false);
		sales_exit_button.setContentAreaFilled(false);
		sales_exit_button.setFocusPainted(false);
		sales_exit_button.setOpaque(false);
		sales_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGMacaron_sales_panel().setVisible(false);
			}
		});
		add(sales_exit_button);

		//커피 매출액 버튼
		coffe_sales_button.setBounds(111, 180, 73, 34);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getGMacaron_sales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//스무디 매출액 버튼
		smoothie_sales_button.setBounds(402, 180, 114, 40);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getGMacaron_sales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//차 매출액 버튼
		tea_sales_button.setBounds(745, 178, 39, 36);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getGMacaron_sales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//버블티 매출액 버튼
		bubble_sales_button.setBounds(1025, 179, 113, 43);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getGMacaron_sales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//케이크 매출액 버튼
		cake_sales_button.setBounds(1329, 180, 116, 35);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getGMacaron_sales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//베리 일별
		berry_d.setBounds(762, 509, 312, 134);
		berry_d.setText(Integer.toString(berry_d_db));
		berry_d.setHorizontalAlignment(JLabel.CENTER);
		berry_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(berry_d);

		//베리 월별
		berry_m.setBounds(1078, 509, 320, 134);
		berry_m.setText(Integer.toString(berry_m_db));
		berry_m.setHorizontalAlignment(JLabel.CENTER);
		berry_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(berry_m);

		//요거트 일별
		yogurt_d.setBounds(762, 646, 312, 134);
		yogurt_d.setText(Integer.toString(yogurt_d_db));
		yogurt_d.setHorizontalAlignment(JLabel.CENTER);
		yogurt_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(yogurt_d);

		//요거트 월별
		yogurt_m.setBounds(1078, 646, 320, 134);
		yogurt_m.setText(Integer.toString(yogurt_m_db));
		yogurt_m.setHorizontalAlignment(JLabel.CENTER);
		yogurt_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(yogurt_m);

		//과일 일별
		fruit_d.setBounds(762, 783, 312, 134);
		fruit_d.setText(Integer.toString(fruit_d_db));
		fruit_d.setHorizontalAlignment(JLabel.CENTER);
		fruit_d.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(fruit_d);

		//과일 월별
		fruit_m.setBounds(1078, 783, 320, 134);
		fruit_m.setText(Integer.toString(fruit_m_db));
		fruit_m.setHorizontalAlignment(JLabel.CENTER);
		fruit_m.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(fruit_m);
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	public void macaron_db() {		
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
            	berry_d_db = rset.getInt("BERRY_D") * 2500;
            	berry_m_db = rset.getInt("BERRY_M") * 2500;
            	yogurt_d_db = rset.getInt("YOGURT_D") * 2500;
            	yogurt_m_db = rset.getInt("YOGURT_M") * 2500;
            	fruit_d_db = rset.getInt("FRUIT_D") * 2500;
            	fruit_m_db = rset.getInt("FRUIT_M") * 2500;
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