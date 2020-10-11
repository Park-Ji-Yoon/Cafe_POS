package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StockGUI {
	public static void main(String args[]) {
		StockPanel stock_panel = new StockPanel();
	}
}
class StockPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_44.png");

	JButton stock_exit_button = new JButton(icon);
	JButton coffe_stock_button = new JButton(icon);
	JButton smoothie_stock_button = new JButton(icon);
	JButton tea_stock_button = new JButton(icon);
	JButton bubble_stock_button = new JButton(icon);
	JButton cake_stock_button = new JButton(icon);
	JButton macaron_stock_button = new JButton(icon);
	
	StockPanel() {
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//재고 관리 취소
		stock_exit_button.setBounds(61, 35, 126, 35);
		stock_exit_button.setVisible(true);
		stock_exit_button.setBorderPainted(false);
		stock_exit_button.setContentAreaFilled(false);
		stock_exit_button.setFocusPainted(false);
		stock_exit_button.setOpaque(false);
		stock_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getStock_panel().setVisible(false);
			}
		});
		add(stock_exit_button);

		//커피 재고 버튼
		coffe_stock_button.setBounds(115, 184, 67, 30);
		coffe_stock_button.setVisible(true);
		coffe_stock_button.setBorderPainted(false);
		coffe_stock_button.setContentAreaFilled(false);
		coffe_stock_button.setFocusPainted(false);
		coffe_stock_button.setOpaque(false);
		coffe_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_stock_panel().setVisible(true);
				Main.MainFrame.getStock_panel().setVisible(false);
			}
		});
		add(coffe_stock_button);

		//스무디 재고 버튼
		smoothie_stock_button.setBounds(412, 184, 103, 35);
		smoothie_stock_button.setVisible(true);
		smoothie_stock_button.setBorderPainted(false);
		smoothie_stock_button.setContentAreaFilled(false);
		smoothie_stock_button.setFocusPainted(false);
		smoothie_stock_button.setOpaque(false);
		smoothie_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(true);
				Main.MainFrame.getStock_panel().setVisible(false);
			}
		});
		add(smoothie_stock_button);

		//차 재고 버튼
		tea_stock_button.setBounds(755, 182, 35, 32);
		tea_stock_button.setVisible(true);
		tea_stock_button.setBorderPainted(false);
		tea_stock_button.setContentAreaFilled(false);
		tea_stock_button.setFocusPainted(false);
		tea_stock_button.setOpaque(false);
		tea_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_stock_panel().setVisible(true);
				Main.MainFrame.getStock_panel().setVisible(false);
			}
		});
		add(tea_stock_button);

		//버블티 재고 버튼
		bubble_stock_button.setBounds(1035, 183, 103, 39);
		bubble_stock_button.setVisible(true);
		bubble_stock_button.setBorderPainted(false);
		bubble_stock_button.setContentAreaFilled(false);
		bubble_stock_button.setFocusPainted(false);
		bubble_stock_button.setOpaque(false);
		bubble_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_stock_panel().setVisible(true);
				Main.MainFrame.getStock_panel().setVisible(false);
			}
		});
		add(bubble_stock_button);

		//케이크 재고 버튼
		cake_stock_button.setBounds(1338, 184, 107, 30);
		cake_stock_button.setVisible(true);
		cake_stock_button.setBorderPainted(false);
		cake_stock_button.setContentAreaFilled(false);
		cake_stock_button.setFocusPainted(false);
		cake_stock_button.setOpaque(false);
		cake_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_stock_panel().setVisible(true);
				Main.MainFrame.getStock_panel().setVisible(false);
			}
		});
		add(cake_stock_button);

		//마카롱 재고 버튼
		macaron_stock_button.setBounds(1655, 184, 106, 39);
		macaron_stock_button.setVisible(true);
		macaron_stock_button.setBorderPainted(false);
		macaron_stock_button.setContentAreaFilled(false);
		macaron_stock_button.setFocusPainted(false);
		macaron_stock_button.setOpaque(false);
		macaron_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_stock_panel().setVisible(true);
				Main.MainFrame.getStock_panel().setVisible(false);
			}
		});
		add(macaron_stock_button);
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
class GCoffeeStockPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_38.png");

	JButton stock_exit_button = new JButton(icon);
	JButton smoothie_stock_button = new JButton(icon);
	JButton tea_stock_button = new JButton(icon);
	JButton bubble_stock_button = new JButton(icon);
	JButton cake_stock_button = new JButton(icon);
	JButton macaron_stock_button = new JButton(icon);

	String bname = ManagerPanel.getBname();
	
	JLabel ice_s = new JLabel();
	JLabel hot_s = new JLabel();

	JTextField ice_cnt = new JTextField();
	JTextField hot_cnt = new JTextField();
	
	JButton ice_in = new JButton();
	JButton hot_in = new JButton();
	
	int ice_s_db;
	int hot_s_db;
	
	GCoffeeStockPanel() {
		coffee_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//재고 관리 취소
		stock_exit_button.setBounds(61, 35, 126, 35);
		stock_exit_button.setVisible(true);
		stock_exit_button.setBorderPainted(false);
		stock_exit_button.setContentAreaFilled(false);
		stock_exit_button.setFocusPainted(false);
		stock_exit_button.setOpaque(false);
		stock_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGCoffee_stock_panel().setVisible(false);
				ice_cnt.setText("");
				hot_cnt.setText("");
			}
		});
		add(stock_exit_button);

		//스무디 재고 버튼
		smoothie_stock_button.setBounds(402, 180, 114, 40);
		smoothie_stock_button.setVisible(true);
		smoothie_stock_button.setBorderPainted(false);
		smoothie_stock_button.setContentAreaFilled(false);
		smoothie_stock_button.setFocusPainted(false);
		smoothie_stock_button.setOpaque(false);
		smoothie_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(true);
				Main.MainFrame.getGCoffee_stock_panel().setVisible(false);
				ice_cnt.setText("");
				hot_cnt.setText("");
			}
		});
		add(smoothie_stock_button);

		//차 재고 버튼
		tea_stock_button.setBounds(745, 178, 39, 36);
		tea_stock_button.setVisible(true);
		tea_stock_button.setBorderPainted(false);
		tea_stock_button.setContentAreaFilled(false);
		tea_stock_button.setFocusPainted(false);
		tea_stock_button.setOpaque(false);
		tea_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_stock_panel().setVisible(true);
				Main.MainFrame.getGCoffee_stock_panel().setVisible(false);
				ice_cnt.setText("");
				hot_cnt.setText("");
			}
		});
		add(tea_stock_button);

		//버블티 재고 버튼
		bubble_stock_button.setBounds(1025, 179, 113, 43);
		bubble_stock_button.setVisible(true);
		bubble_stock_button.setBorderPainted(false);
		bubble_stock_button.setContentAreaFilled(false);
		bubble_stock_button.setFocusPainted(false);
		bubble_stock_button.setOpaque(false);
		bubble_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_stock_panel().setVisible(true);
				Main.MainFrame.getGCoffee_stock_panel().setVisible(false);
				ice_cnt.setText("");
				hot_cnt.setText("");
			}
		});
		add(bubble_stock_button);

		//케이크 재고 버튼
		cake_stock_button.setBounds(1329, 180, 116, 35);
		cake_stock_button.setVisible(true);
		cake_stock_button.setBorderPainted(false);
		cake_stock_button.setContentAreaFilled(false);
		cake_stock_button.setFocusPainted(false);
		cake_stock_button.setOpaque(false);
		cake_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_stock_panel().setVisible(true);
				Main.MainFrame.getGCoffee_stock_panel().setVisible(false);
				ice_cnt.setText("");
				hot_cnt.setText("");
			}
		});
		add(cake_stock_button);

		//마카롱 재고 버튼
		macaron_stock_button.setBounds(1645, 180, 116, 43);
		macaron_stock_button.setVisible(true);
		macaron_stock_button.setBorderPainted(false);
		macaron_stock_button.setContentAreaFilled(false);
		macaron_stock_button.setFocusPainted(false);
		macaron_stock_button.setOpaque(false);
		macaron_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_stock_panel().setVisible(true);
				Main.MainFrame.getGCoffee_stock_panel().setVisible(false);
				ice_cnt.setText("");
				hot_cnt.setText("");
			}
		});
		add(macaron_stock_button);

		//아이스 재고
		ice_s.setBounds(768, 571, 312, 121);
		ice_s.setText(Integer.toString(ice_s_db) + "잔");
		ice_s.setHorizontalAlignment(JLabel.CENTER);
		ice_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(ice_s);
		
		//아이스 재고 추가 필드
		ice_cnt.setBounds(1083, 571, 160, 121);
		ice_cnt.setVisible(true);
		ice_cnt.setOpaque(false);
		ice_cnt.setBorder(BorderFactory.createEmptyBorder());
		ice_cnt.setHorizontalAlignment(JTextField.CENTER);
		ice_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(ice_cnt);
		
		//아이스 재고 추가
		ice_in.setBounds(1245, 571, 160, 121);
		ice_in.setVisible(true);
		ice_in.setBorderPainted(false);
		ice_in.setContentAreaFilled(false);
		ice_in.setFocusPainted(false);
		ice_in.setOpaque(false);
		ice_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee_db("ice");
				ice_s.setText(Integer.toString(ice_s_db) + "잔");
				ice_cnt.setText("");
			}
		});
		add(ice_in);		

		//핫 재고
		hot_s.setBounds(768, 695, 312, 134);
		hot_s.setText(Integer.toString(hot_s_db) + "잔");
		hot_s.setHorizontalAlignment(JLabel.CENTER);
		hot_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(hot_s);
		
		//핫 재고 추가 필드
		hot_cnt.setBounds(1083, 695, 160, 134);
		hot_cnt.setVisible(true);
		hot_cnt.setOpaque(false);
		hot_cnt.setBorder(BorderFactory.createEmptyBorder());
		hot_cnt.setHorizontalAlignment(JTextField.CENTER);
		hot_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(hot_cnt);
		
		//핫 재고 추가
		hot_in.setBounds(1245, 695, 160, 134);
		hot_in.setVisible(true);
		hot_in.setBorderPainted(false);
		hot_in.setContentAreaFilled(false);
		hot_in.setFocusPainted(false);
		hot_in.setOpaque(false);
		hot_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee_db("hot");
				hot_s.setText(Integer.toString(hot_s_db) + "잔");
				hot_cnt.setText("");
			}
		});
		add(hot_in);
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
            	ice_s_db = rset.getInt("ICE_S");
            	hot_s_db = rset.getInt("HOT_S");
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
	public void coffee_db(String menu) {	
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
            	if(menu.equals("ice")){
            		ice_s_db = rset.getInt("ICE_S") + Integer.parseInt(ice_cnt.getText());
                	query = "UPDATE MENU_COFFEE SET ICE_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, ice_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("hot")) {
            		hot_s_db = rset.getInt("HOT_S") + Integer.parseInt(hot_cnt.getText());
                	query = "UPDATE MENU_COFFEE SET HOT_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, hot_s_db);
        			pstmt.executeUpdate();
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
class GSmoothieStockPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_39.png");

	JButton stock_exit_button = new JButton(icon);
	JButton coffe_stock_button = new JButton(icon);
	JButton tea_stock_button = new JButton(icon);
	JButton bubble_stock_button = new JButton(icon);
	JButton cake_stock_button = new JButton(icon);
	JButton macaron_stock_button = new JButton(icon);

	String bname = ManagerPanel.getBname();
	
	JLabel orange_s = new JLabel();
	JLabel kiwi_s = new JLabel();
	JLabel grape_s = new JLabel();
	JLabel straw_s = new JLabel();
	JLabel water_s = new JLabel();

	JTextField orange_cnt = new JTextField();
	JTextField kiwi_cnt = new JTextField();
	JTextField grape_cnt = new JTextField();
	JTextField straw_cnt = new JTextField();
	JTextField water_cnt = new JTextField();
	
	JButton orange_in = new JButton();
	JButton kiwi_in = new JButton();
	JButton grape_in = new JButton();
	JButton straw_in = new JButton();
	JButton water_in = new JButton();
	
	int orange_s_db;
	int kiwi_s_db;
	int grape_s_db;
	int straw_s_db;
	int water_s_db;
	
	GSmoothieStockPanel() {
		smoothie_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//재고 관리 취소
		stock_exit_button.setBounds(61, 35, 126, 35);
		stock_exit_button.setVisible(true);
		stock_exit_button.setBorderPainted(false);
		stock_exit_button.setContentAreaFilled(false);
		stock_exit_button.setFocusPainted(false);
		stock_exit_button.setOpaque(false);
		stock_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(false);
				orange_cnt.setText("");
				kiwi_cnt.setText("");
				grape_cnt.setText("");
				straw_cnt.setText("");
				water_cnt.setText("");
			}
		});
		add(stock_exit_button);

		//커피 재고 버튼
		coffe_stock_button.setBounds(111, 180, 73, 34);
		coffe_stock_button.setVisible(true);
		coffe_stock_button.setBorderPainted(false);
		coffe_stock_button.setContentAreaFilled(false);
		coffe_stock_button.setFocusPainted(false);
		coffe_stock_button.setOpaque(false);
		coffe_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_stock_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(false);
				orange_cnt.setText("");
				kiwi_cnt.setText("");
				grape_cnt.setText("");
				straw_cnt.setText("");
				water_cnt.setText("");
			}
		});
		add(coffe_stock_button);

		//차 재고 버튼
		tea_stock_button.setBounds(745, 178, 39, 36);
		tea_stock_button.setVisible(true);
		tea_stock_button.setBorderPainted(false);
		tea_stock_button.setContentAreaFilled(false);
		tea_stock_button.setFocusPainted(false);
		tea_stock_button.setOpaque(false);
		tea_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_stock_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(false);
				orange_cnt.setText("");
				kiwi_cnt.setText("");
				grape_cnt.setText("");
				straw_cnt.setText("");
				water_cnt.setText("");
			}
		});
		add(tea_stock_button);

		//버블티 재고 버튼
		bubble_stock_button.setBounds(1025, 179, 113, 43);
		bubble_stock_button.setVisible(true);
		bubble_stock_button.setBorderPainted(false);
		bubble_stock_button.setContentAreaFilled(false);
		bubble_stock_button.setFocusPainted(false);
		bubble_stock_button.setOpaque(false);
		bubble_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_stock_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(false);
				orange_cnt.setText("");
				kiwi_cnt.setText("");
				grape_cnt.setText("");
				straw_cnt.setText("");
				water_cnt.setText("");
			}
		});
		add(bubble_stock_button);

		//케이크 재고 버튼
		cake_stock_button.setBounds(1329, 180, 116, 35);
		cake_stock_button.setVisible(true);
		cake_stock_button.setBorderPainted(false);
		cake_stock_button.setContentAreaFilled(false);
		cake_stock_button.setFocusPainted(false);
		cake_stock_button.setOpaque(false);
		cake_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_stock_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(false);
				orange_cnt.setText("");
				kiwi_cnt.setText("");
				grape_cnt.setText("");
				straw_cnt.setText("");
				water_cnt.setText("");
			}
		});
		add(cake_stock_button);

		//마카롱 재고 버튼
		macaron_stock_button.setBounds(1645, 180, 116, 43);
		macaron_stock_button.setVisible(true);
		macaron_stock_button.setBorderPainted(false);
		macaron_stock_button.setContentAreaFilled(false);
		macaron_stock_button.setFocusPainted(false);
		macaron_stock_button.setOpaque(false);
		macaron_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_stock_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(false);
				orange_cnt.setText("");
				kiwi_cnt.setText("");
				grape_cnt.setText("");
				straw_cnt.setText("");
				water_cnt.setText("");
			}
		});
		add(macaron_stock_button);

		//오렌지 재고
		orange_s.setBounds(762, 457, 312, 102);
		orange_s.setText(Integer.toString(orange_s_db) + "잔");
		orange_s.setHorizontalAlignment(JLabel.CENTER);
		orange_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(orange_s);
		
		//오렌지 재고  추가 필드
		orange_cnt.setBounds(1077, 457, 157, 103);
		orange_cnt.setVisible(true);
		orange_cnt.setOpaque(false);
		orange_cnt.setBorder(BorderFactory.createEmptyBorder());
		orange_cnt.setHorizontalAlignment(JTextField.CENTER);
		orange_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 70));
		add(orange_cnt);

		//오렌지 재고 추가
		orange_in.setBounds(1237, 456, 162, 103);
		orange_in.setVisible(true);
		orange_in.setBorderPainted(false);
		orange_in.setContentAreaFilled(false);
		orange_in.setFocusPainted(false);
		orange_in.setOpaque(false);
		orange_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smoothie_db("orange");
				orange_s.setText(Integer.toString(orange_s_db) + "잔");
				orange_cnt.setText("");
			}
		});
		add(orange_in);
		
		//키위 재고
		kiwi_s.setBounds(762, 563, 312, 102);
		kiwi_s.setText(Integer.toString(kiwi_s_db) + "잔");
		kiwi_s.setHorizontalAlignment(JLabel.CENTER);
		kiwi_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(kiwi_s);
		
		//키위 재고  추가 필드
		kiwi_cnt.setBounds(1077, 563, 157, 103);
		kiwi_cnt.setVisible(true);
		kiwi_cnt.setOpaque(false);
		kiwi_cnt.setBorder(BorderFactory.createEmptyBorder());
		kiwi_cnt.setHorizontalAlignment(JTextField.CENTER);
		kiwi_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 70));
		add(kiwi_cnt);

		//키위 재고 추가
		kiwi_in.setBounds(1237, 562, 162, 103);
		kiwi_in.setVisible(true);
		kiwi_in.setBorderPainted(false);
		kiwi_in.setContentAreaFilled(false);
		kiwi_in.setFocusPainted(false);
		kiwi_in.setOpaque(false);
		kiwi_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smoothie_db("kiwi");
				kiwi_s.setText(Integer.toString(kiwi_s_db) + "잔");
				kiwi_cnt.setText("");
			}
		});
		add(kiwi_in);

		//포도 재고
		grape_s.setBounds(762, 669, 312, 102);
		grape_s.setText(Integer.toString(grape_s_db) + "잔");
		grape_s.setHorizontalAlignment(JLabel.CENTER);
		grape_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(grape_s);
		
		//포도 재고  추가 필드
		grape_cnt.setBounds(1077, 669, 157, 103);
		grape_cnt.setVisible(true);
		grape_cnt.setOpaque(false);
		grape_cnt.setBorder(BorderFactory.createEmptyBorder());
		grape_cnt.setHorizontalAlignment(JTextField.CENTER);
		grape_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 70));
		add(grape_cnt);

		//포도 재고 추가
		grape_in.setBounds(1237, 668, 162, 103);
		grape_in.setVisible(true);
		grape_in.setBorderPainted(false);
		grape_in.setContentAreaFilled(false);
		grape_in.setFocusPainted(false);
		grape_in.setOpaque(false);
		grape_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smoothie_db("grape");
				grape_s.setText(Integer.toString(grape_s_db) + "잔");
				grape_cnt.setText("");
			}
		});
		add(grape_in);

		//딸기 재고
		straw_s.setBounds(762, 775, 312, 102);
		straw_s.setText(Integer.toString(straw_s_db) + "잔");
		straw_s.setHorizontalAlignment(JLabel.CENTER);
		straw_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(straw_s);
		
		//딸기 재고  추가 필드
		straw_cnt.setBounds(1077, 775, 157, 103);
		straw_cnt.setVisible(true);
		straw_cnt.setOpaque(false);
		straw_cnt.setBorder(BorderFactory.createEmptyBorder());
		straw_cnt.setHorizontalAlignment(JTextField.CENTER);
		straw_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 70));
		add(straw_cnt);

		//딸기 재고 추가
		straw_in.setBounds(1237, 774, 162, 103);
		straw_in.setVisible(true);
		straw_in.setBorderPainted(false);
		straw_in.setContentAreaFilled(false);
		straw_in.setFocusPainted(false);
		straw_in.setOpaque(false);
		straw_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smoothie_db("straw");
				straw_s.setText(Integer.toString(straw_s_db) + "잔");
				straw_cnt.setText("");
			}
		});
		add(straw_in);

		//수박 재고
		water_s.setBounds(762, 881, 312, 106);
		water_s.setText(Integer.toString(water_s_db) + "잔");
		water_s.setHorizontalAlignment(JLabel.CENTER);
		water_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(water_s);
		
		//딸기 재고  추가 필드
		water_cnt.setBounds(1077, 881, 157, 103);
		water_cnt.setVisible(true);
		water_cnt.setOpaque(false);
		water_cnt.setBorder(BorderFactory.createEmptyBorder());
		water_cnt.setHorizontalAlignment(JTextField.CENTER);
		water_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 70));
		add(water_cnt);
		
		//수박 재고 추가
		water_in.setBounds(1237, 880, 162, 103);
		water_in.setVisible(true);
		water_in.setBorderPainted(false);
		water_in.setContentAreaFilled(false);
		water_in.setFocusPainted(false);
		water_in.setOpaque(false);
		water_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smoothie_db("water");
				water_s.setText(Integer.toString(water_s_db) + "잔");
				water_cnt.setText("");
			}
		});
		add(water_in);

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
            	orange_s_db = rset.getInt("ORANGE_S");
            	kiwi_s_db = rset.getInt("KIWI_S");
            	grape_s_db = rset.getInt("GRAPE_S");
            	straw_s_db = rset.getInt("STRAW_S");
            	water_s_db = rset.getInt("WATER_S");
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
	public void smoothie_db(String menu) {		
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
            	if(menu.equals("orange")){
            		orange_s_db = rset.getInt("ORANGE_S") + Integer.parseInt(orange_cnt.getText());
                	query = "UPDATE MENU_SMOOTHIE SET ORANGE_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, orange_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("kiwi")) {
            		kiwi_s_db = rset.getInt("KIWI_S") + Integer.parseInt(kiwi_cnt.getText());
                	query = "UPDATE MENU_SMOOTHIE SET KIWI_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, kiwi_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("grape")) {
            		grape_s_db = rset.getInt("GRAPE_S") + Integer.parseInt(grape_cnt.getText());
                	query = "UPDATE MENU_SMOOTHIE SET GRAPE_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, grape_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("straw")) {
            		straw_s_db = rset.getInt("STRAW_S") + Integer.parseInt(straw_cnt.getText());
                	query = "UPDATE MENU_SMOOTHIE SET STRAW_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, straw_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("water")) {
            		water_s_db = rset.getInt("WATER_S") + Integer.parseInt(water_cnt.getText());
                	query = "UPDATE MENU_SMOOTHIE SET WATER_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, water_s_db);
        			pstmt.executeUpdate();
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
class GTeaStockPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_40.png");

	JButton stock_exit_button = new JButton(icon);
	JButton coffe_stock_button = new JButton(icon);
	JButton smoothie_stock_button = new JButton(icon);
	JButton bubble_stock_button = new JButton(icon);
	JButton cake_stock_button = new JButton(icon);
	JButton macaron_stock_button = new JButton(icon);

	String bname = ManagerPanel.getBname();
	
	JLabel green_s = new JLabel();
	JLabel black_s = new JLabel();

	JTextField green_cnt = new JTextField();
	JTextField black_cnt = new JTextField();
	
	JButton green_in = new JButton();
	JButton black_in = new JButton();
	
	int green_s_db;
	int black_s_db;

	GTeaStockPanel() {
		tea_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//재고 관리 취소
		stock_exit_button.setBounds(61, 35, 126, 35);
		stock_exit_button.setVisible(true);
		stock_exit_button.setBorderPainted(false);
		stock_exit_button.setContentAreaFilled(false);
		stock_exit_button.setFocusPainted(false);
		stock_exit_button.setOpaque(false);
		stock_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGTea_stock_panel().setVisible(false);
				green_cnt.setText("");
				black_cnt.setText("");
			}
		});
		add(stock_exit_button);

		//커피 재고 버튼
		coffe_stock_button.setBounds(111, 180, 73, 34);
		coffe_stock_button.setVisible(true);
		coffe_stock_button.setBorderPainted(false);
		coffe_stock_button.setContentAreaFilled(false);
		coffe_stock_button.setFocusPainted(false);
		coffe_stock_button.setOpaque(false);
		coffe_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_stock_panel().setVisible(true);
				Main.MainFrame.getGTea_stock_panel().setVisible(false);
				green_cnt.setText("");
				black_cnt.setText("");
			}
		});
		add(coffe_stock_button);

		//스무디 재고 버튼
		smoothie_stock_button.setBounds(402, 180, 114, 40);
		smoothie_stock_button.setVisible(true);
		smoothie_stock_button.setBorderPainted(false);
		smoothie_stock_button.setContentAreaFilled(false);
		smoothie_stock_button.setFocusPainted(false);
		smoothie_stock_button.setOpaque(false);
		smoothie_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(true);
				Main.MainFrame.getGTea_stock_panel().setVisible(false);
				green_cnt.setText("");
				black_cnt.setText("");
			}
		});
		add(smoothie_stock_button);

		//버블티 재고 버튼
		bubble_stock_button.setBounds(1025, 179, 113, 43);
		bubble_stock_button.setVisible(true);
		bubble_stock_button.setBorderPainted(false);
		bubble_stock_button.setContentAreaFilled(false);
		bubble_stock_button.setFocusPainted(false);
		bubble_stock_button.setOpaque(false);
		bubble_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_stock_panel().setVisible(true);
				Main.MainFrame.getGTea_stock_panel().setVisible(false);
				green_cnt.setText("");
				black_cnt.setText("");
			}
		});
		add(bubble_stock_button);

		//케이크 재고 버튼
		cake_stock_button.setBounds(1329, 180, 116, 35);
		cake_stock_button.setVisible(true);
		cake_stock_button.setBorderPainted(false);
		cake_stock_button.setContentAreaFilled(false);
		cake_stock_button.setFocusPainted(false);
		cake_stock_button.setOpaque(false);
		cake_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_stock_panel().setVisible(true);
				Main.MainFrame.getGTea_stock_panel().setVisible(false);
				green_cnt.setText("");
				black_cnt.setText("");
			}
		});
		add(cake_stock_button);

		//마카롱 재고 버튼
		macaron_stock_button.setBounds(1645, 180, 116, 43);
		macaron_stock_button.setVisible(true);
		macaron_stock_button.setBorderPainted(false);
		macaron_stock_button.setContentAreaFilled(false);
		macaron_stock_button.setFocusPainted(false);
		macaron_stock_button.setOpaque(false);
		macaron_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_stock_panel().setVisible(true);
				Main.MainFrame.getGTea_stock_panel().setVisible(false);
				green_cnt.setText("");
				black_cnt.setText("");
			}
		});
		add(macaron_stock_button);

		//녹차 재고
		green_s.setBounds(762, 568, 312, 134);
		green_s.setText(Integer.toString(green_s_db) + "잔");
		green_s.setHorizontalAlignment(JLabel.CENTER);
		green_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(green_s);
		
		//녹차 재고  추가 필드
		green_cnt.setBounds(1077, 568, 160, 134);
		green_cnt.setVisible(true);
		green_cnt.setOpaque(false);
		green_cnt.setBorder(BorderFactory.createEmptyBorder());
		green_cnt.setHorizontalAlignment(JTextField.CENTER);
		green_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(green_cnt);
		
		//녹차 재고 추가
		green_in.setBounds(1240, 568, 159, 134);
		green_in.setVisible(true);
		green_in.setBorderPainted(false);
		green_in.setContentAreaFilled(false);
		green_in.setFocusPainted(false);
		green_in.setOpaque(false);
		green_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tea_db("green");
				green_s.setText(Integer.toString(green_s_db) + "잔");
				green_cnt.setText("");
			}
		});
		add(green_in);

		//홍차 재고
		black_s.setBounds(762, 705, 312, 134);
		black_s.setText(Integer.toString(black_s_db) + "잔");
		black_s.setHorizontalAlignment(JLabel.CENTER);
		black_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(black_s);
		
		//홍차 재고  추가 필드
		black_cnt.setBounds(1077, 705, 160, 134);
		black_cnt.setVisible(true);
		black_cnt.setOpaque(false);
		black_cnt.setBorder(BorderFactory.createEmptyBorder());
		black_cnt.setHorizontalAlignment(JTextField.CENTER);
		black_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(black_cnt);
		
		//홍차 재고 추가
		black_in.setBounds(1240, 705, 159, 134);
		black_in.setVisible(true);
		black_in.setBorderPainted(false);
		black_in.setContentAreaFilled(false);
		black_in.setFocusPainted(false);
		black_in.setOpaque(false);
		black_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tea_db("black");
				black_s.setText(Integer.toString(black_s_db) + "잔");
				black_cnt.setText("");
			}
		});
		add(black_in);
		
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
            	green_s_db = rset.getInt("GREEN_S");
            	black_s_db = rset.getInt("BLACK_S");
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
	public void tea_db(String menu) {		
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
            	if(menu.equals("green")){
            		green_s_db = rset.getInt("GREEN_S") + Integer.parseInt(green_cnt.getText());
                	query = "UPDATE MENU_TEA SET GREEN_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, green_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("black")) {
            		black_s_db = rset.getInt("BLACK_S") + Integer.parseInt(black_cnt.getText());
                	query = "UPDATE MENU_TEA SET BLACK_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, black_s_db);
        			pstmt.executeUpdate();
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
class GBubbleStockPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_41.png");

	JButton stock_exit_button = new JButton(icon);
	JButton coffe_stock_button = new JButton(icon);
	JButton smoothie_stock_button = new JButton(icon);
	JButton tea_stock_button = new JButton(icon);
	JButton cake_stock_button = new JButton(icon);
	JButton macaron_stock_button = new JButton(icon);

	String bname = ManagerPanel.getBname();
	
	JLabel bs_s = new JLabel();
	JLabel taro_s = new JLabel();
	JLabel gb_s = new JLabel();
	
	JTextField bs_cnt = new JTextField();
	JTextField taro_cnt = new JTextField();
	JTextField gb_cnt = new JTextField();
	
	JButton bs_in = new JButton();
	JButton taro_in = new JButton();
	JButton gb_in = new JButton();
	
	int bs_s_db;
	int taro_s_db;
	int gb_s_db;

	GBubbleStockPanel() {
		bubble_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//재고 관리 취소
		stock_exit_button.setBounds(61, 35, 126, 35);
		stock_exit_button.setVisible(true);
		stock_exit_button.setBorderPainted(false);
		stock_exit_button.setContentAreaFilled(false);
		stock_exit_button.setFocusPainted(false);
		stock_exit_button.setOpaque(false);
		stock_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGBubble_stock_panel().setVisible(false);
				bs_cnt.setText("");
				taro_cnt.setText("");
				gb_cnt.setText("");
			}
		});
		add(stock_exit_button);

		//커피 재고 버튼
		coffe_stock_button.setBounds(111, 180, 73, 34);
		coffe_stock_button.setVisible(true);
		coffe_stock_button.setBorderPainted(false);
		coffe_stock_button.setContentAreaFilled(false);
		coffe_stock_button.setFocusPainted(false);
		coffe_stock_button.setOpaque(false);
		coffe_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_stock_panel().setVisible(true);
				Main.MainFrame.getGBubble_stock_panel().setVisible(false);
				bs_cnt.setText("");
				taro_cnt.setText("");
				gb_cnt.setText("");
			}
		});
		add(coffe_stock_button);

		//스무디 재고 버튼
		smoothie_stock_button.setBounds(402, 180, 114, 40);
		smoothie_stock_button.setVisible(true);
		smoothie_stock_button.setBorderPainted(false);
		smoothie_stock_button.setContentAreaFilled(false);
		smoothie_stock_button.setFocusPainted(false);
		smoothie_stock_button.setOpaque(false);
		smoothie_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(true);
				Main.MainFrame.getGBubble_stock_panel().setVisible(false);
				bs_cnt.setText("");
				taro_cnt.setText("");
				gb_cnt.setText("");
			}
		});
		add(smoothie_stock_button);

		//차 재고 버튼
		tea_stock_button.setBounds(745, 178, 39, 36);
		tea_stock_button.setVisible(true);
		tea_stock_button.setBorderPainted(false);
		tea_stock_button.setContentAreaFilled(false);
		tea_stock_button.setFocusPainted(false);
		tea_stock_button.setOpaque(false);
		tea_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_stock_panel().setVisible(true);
				Main.MainFrame.getGBubble_stock_panel().setVisible(false);
				bs_cnt.setText("");
				taro_cnt.setText("");
				gb_cnt.setText("");
			}
		});
		add(tea_stock_button);

		//케이크 재고 버튼
		cake_stock_button.setBounds(1329, 180, 116, 35);
		cake_stock_button.setVisible(true);
		cake_stock_button.setBorderPainted(false);
		cake_stock_button.setContentAreaFilled(false);
		cake_stock_button.setFocusPainted(false);
		cake_stock_button.setOpaque(false);
		cake_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_stock_panel().setVisible(true);
				Main.MainFrame.getGBubble_stock_panel().setVisible(false);
				bs_cnt.setText("");
				taro_cnt.setText("");
				gb_cnt.setText("");
			}
		});
		add(cake_stock_button);

		//마카롱 재고 버튼
		macaron_stock_button.setBounds(1645, 180, 116, 43);
		macaron_stock_button.setVisible(true);
		macaron_stock_button.setBorderPainted(false);
		macaron_stock_button.setContentAreaFilled(false);
		macaron_stock_button.setFocusPainted(false);
		macaron_stock_button.setOpaque(false);
		macaron_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_stock_panel().setVisible(true);
				Main.MainFrame.getGBubble_stock_panel().setVisible(false);
				bs_cnt.setText("");
				taro_cnt.setText("");
				gb_cnt.setText("");
			}
		});
		add(macaron_stock_button);

		//흑당 재고
		bs_s.setBounds(762, 509, 312, 134);
		bs_s.setText(Integer.toString(bs_s_db) + "잔");
		bs_s.setHorizontalAlignment(JLabel.CENTER);
		bs_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(bs_s);
		
		//흑당 재고  추가 필드
		bs_cnt.setBounds(1077, 509, 160, 134);
		bs_cnt.setVisible(true);
		bs_cnt.setOpaque(false);
		bs_cnt.setBorder(BorderFactory.createEmptyBorder());
		bs_cnt.setHorizontalAlignment(JTextField.CENTER);
		bs_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(bs_cnt);

		//흑당 재고 추가
		bs_in.setBounds(1240, 509, 159, 134);
		bs_in.setVisible(true);
		bs_in.setBorderPainted(false);
		bs_in.setContentAreaFilled(false);
		bs_in.setFocusPainted(false);
		bs_in.setOpaque(false);
		bs_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bubble_db("bs");
				bs_s.setText(Integer.toString(bs_s_db) + "잔");
				bs_cnt.setText("");
			}
		});
		add(bs_in);
		
		//타로 재고
		taro_s.setBounds(762, 646, 312, 134);
		taro_s.setText(Integer.toString(taro_s_db) + "잔");
		taro_s.setHorizontalAlignment(JLabel.CENTER);
		taro_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(taro_s);
		
		//타로 재고  추가 필드
		taro_cnt.setBounds(1077, 646, 160, 134);
		taro_cnt.setVisible(true);
		taro_cnt.setOpaque(false);
		taro_cnt.setBorder(BorderFactory.createEmptyBorder());
		taro_cnt.setHorizontalAlignment(JTextField.CENTER);
		taro_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(taro_cnt);
		
		//타로 재고 추가
		taro_in.setBounds(1240, 646, 159, 134);
		taro_in.setVisible(true);
		taro_in.setBorderPainted(false);
		taro_in.setContentAreaFilled(false);
		taro_in.setFocusPainted(false);
		taro_in.setOpaque(false);
		taro_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bubble_db("taro");
				taro_s.setText(Integer.toString(taro_s_db) + "잔");
				taro_cnt.setText("");
			}
		});
		add(taro_in);
		
		//녹차 재고
		gb_s.setBounds(762, 783, 312, 134);
		gb_s.setText(Integer.toString(gb_s_db) + "잔");
		gb_s.setHorizontalAlignment(JLabel.CENTER);
		gb_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(gb_s);
		
		//녹차 재고  추가 필드
		gb_cnt.setBounds(1077, 783, 160, 134);
		gb_cnt.setVisible(true);
		gb_cnt.setOpaque(false);
		gb_cnt.setBorder(BorderFactory.createEmptyBorder());
		gb_cnt.setHorizontalAlignment(JTextField.CENTER);
		gb_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(gb_cnt);
		
		//녹차 재고 추가
		gb_in.setBounds(1240, 783, 159, 134);
		gb_in.setVisible(true);
		gb_in.setBorderPainted(false);
		gb_in.setContentAreaFilled(false);
		gb_in.setFocusPainted(false);
		gb_in.setOpaque(false);
		gb_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bubble_db("gb");
				gb_s.setText(Integer.toString(gb_s_db) + "잔");
				gb_cnt.setText("");
			}
		});
		add(gb_in);		
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
            	bs_s_db = rset.getInt("BS_S");
            	taro_s_db = rset.getInt("TARO_S");
            	gb_s_db = rset.getInt("GB_S");
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
	public void bubble_db(String menu) {	
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
            	if(menu.equals("bs")){
            		bs_s_db = rset.getInt("BS_S") + Integer.parseInt(bs_cnt.getText());
                	query = "UPDATE MENU_BUBBLE SET BS_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, bs_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("taro")) {
            		taro_s_db = rset.getInt("TARO_S") + Integer.parseInt(taro_cnt.getText());
                	query = "UPDATE MENU_BUBBLE SET TARO_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, taro_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("gb")) {
            		gb_s_db = rset.getInt("GB_S") + Integer.parseInt(gb_cnt.getText());
                	query = "UPDATE MENU_BUBBLE SET GB_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, gb_s_db);
        			pstmt.executeUpdate();
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
class GCakeStockPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_42.png");

	JButton stock_exit_button = new JButton(icon);
	JButton coffe_stock_button = new JButton(icon);
	JButton smoothie_stock_button = new JButton(icon);
	JButton tea_stock_button = new JButton(icon);
	JButton bubble_stock_button = new JButton(icon);
	JButton macaron_stock_button = new JButton(icon);

	String bname = ManagerPanel.getBname();
	
	JLabel cheese_s = new JLabel();
	JLabel sc_s = new JLabel();
	JLabel choco_s = new JLabel();
	
	JTextField cheese_cnt = new JTextField();
	JTextField sc_cnt = new JTextField();
	JTextField choco_cnt = new JTextField();
	
	JButton cheese_in = new JButton();
	JButton sc_in = new JButton();
	JButton choco_in = new JButton();
	
	int cheese_s_db;
	int sc_s_db;
	int choco_s_db;

	GCakeStockPanel() {
		cake_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//재고 관리 취소
		stock_exit_button.setBounds(61, 35, 126, 35);
		stock_exit_button.setVisible(true);
		stock_exit_button.setBorderPainted(false);
		stock_exit_button.setContentAreaFilled(false);
		stock_exit_button.setFocusPainted(false);
		stock_exit_button.setOpaque(false);
		stock_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGCake_stock_panel().setVisible(false);
				cheese_cnt.setText("");
				sc_cnt.setText("");
				choco_cnt.setText("");
			}
		});
		add(stock_exit_button);

		//커피 재고 버튼
		coffe_stock_button.setBounds(111, 180, 73, 34);
		coffe_stock_button.setVisible(true);
		coffe_stock_button.setBorderPainted(false);
		coffe_stock_button.setContentAreaFilled(false);
		coffe_stock_button.setFocusPainted(false);
		coffe_stock_button.setOpaque(false);
		coffe_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_stock_panel().setVisible(true);
				Main.MainFrame.getGCake_stock_panel().setVisible(false);
				cheese_cnt.setText("");
				sc_cnt.setText("");
				choco_cnt.setText("");
			}
		});
		add(coffe_stock_button);

		//스무디 재고 버튼
		smoothie_stock_button.setBounds(402, 180, 114, 40);
		smoothie_stock_button.setVisible(true);
		smoothie_stock_button.setBorderPainted(false);
		smoothie_stock_button.setContentAreaFilled(false);
		smoothie_stock_button.setFocusPainted(false);
		smoothie_stock_button.setOpaque(false);
		smoothie_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(true);
				Main.MainFrame.getGCake_stock_panel().setVisible(false);
				cheese_cnt.setText("");
				sc_cnt.setText("");
				choco_cnt.setText("");
			}
		});
		add(smoothie_stock_button);

		//차 재고 버튼
		tea_stock_button.setBounds(745, 178, 39, 36);
		tea_stock_button.setVisible(true);
		tea_stock_button.setBorderPainted(false);
		tea_stock_button.setContentAreaFilled(false);
		tea_stock_button.setFocusPainted(false);
		tea_stock_button.setOpaque(false);
		tea_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_stock_panel().setVisible(true);
				Main.MainFrame.getGCake_stock_panel().setVisible(false);
				cheese_cnt.setText("");
				sc_cnt.setText("");
				choco_cnt.setText("");
			}
		});
		add(tea_stock_button);

		//버블티 재고 버튼
		bubble_stock_button.setBounds(1025, 179, 113, 43);
		bubble_stock_button.setVisible(true);
		bubble_stock_button.setBorderPainted(false);
		bubble_stock_button.setContentAreaFilled(false);
		bubble_stock_button.setFocusPainted(false);
		bubble_stock_button.setOpaque(false);
		bubble_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_stock_panel().setVisible(true);
				Main.MainFrame.getGCake_stock_panel().setVisible(false);
				cheese_cnt.setText("");
				sc_cnt.setText("");
				choco_cnt.setText("");
			}
		});
		add(bubble_stock_button);

		//마카롱 재고 버튼
		macaron_stock_button.setBounds(1645, 180, 116, 43);
		macaron_stock_button.setVisible(true);
		macaron_stock_button.setBorderPainted(false);
		macaron_stock_button.setContentAreaFilled(false);
		macaron_stock_button.setFocusPainted(false);
		macaron_stock_button.setOpaque(false);
		macaron_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGMacaron_stock_panel().setVisible(true);
				Main.MainFrame.getGCake_stock_panel().setVisible(false);
				cheese_cnt.setText("");
				sc_cnt.setText("");
				choco_cnt.setText("");
			}
		});
		add(macaron_stock_button);

		//치즈 재고
		cheese_s.setBounds(762, 515, 312, 134);
		cheese_s.setText(Integer.toString(cheese_s_db) + "조각");
		cheese_s.setHorizontalAlignment(JLabel.CENTER);
		cheese_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(cheese_s);
		
		//치즈 재고  추가 필드
		cheese_cnt.setBounds(1077, 515, 160, 134);
		cheese_cnt.setVisible(true);
		cheese_cnt.setOpaque(false);
		cheese_cnt.setBorder(BorderFactory.createEmptyBorder());
		cheese_cnt.setHorizontalAlignment(JTextField.CENTER);
		cheese_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(cheese_cnt);
		
		//치즈 재고 추가
		cheese_in.setBounds(1240, 515, 159, 134);
		cheese_in.setVisible(true);
		cheese_in.setBorderPainted(false);
		cheese_in.setContentAreaFilled(false);
		cheese_in.setFocusPainted(false);
		cheese_in.setOpaque(false);
		cheese_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cake_db("cheese");
				cheese_s.setText(Integer.toString(cheese_s_db) + "조각");
				cheese_cnt.setText("");
			}
		});
		add(cheese_in);

		//딸기 재고
		sc_s.setBounds(762, 652, 312, 134);
		sc_s.setText(Integer.toString(sc_s_db) + "조각");
		sc_s.setHorizontalAlignment(JLabel.CENTER);
		sc_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(sc_s);
		
		//딸기 재고  추가 필드
		sc_cnt.setBounds(1077, 652, 160, 134);
		sc_cnt.setVisible(true);
		sc_cnt.setOpaque(false);
		sc_cnt.setBorder(BorderFactory.createEmptyBorder());
		sc_cnt.setHorizontalAlignment(JTextField.CENTER);
		sc_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(sc_cnt);
		
		//딸기 재고 추가
		sc_in.setBounds(1240, 652, 159, 134);
		sc_in.setVisible(true);
		sc_in.setBorderPainted(false);
		sc_in.setContentAreaFilled(false);
		sc_in.setFocusPainted(false);
		sc_in.setOpaque(false);
		sc_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cake_db("sc");
				sc_s.setText(Integer.toString(sc_s_db) + "조각");
				sc_cnt.setText("");
			}
		});
		add(sc_in);

		//초코 재고
		choco_s.setBounds(762, 789, 312, 134);
		choco_s.setText(Integer.toString(choco_s_db) + "조각");
		choco_s.setHorizontalAlignment(JLabel.CENTER);
		choco_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(choco_s);
		
		//초코 재고  추가 필드
		choco_cnt.setBounds(1077, 789, 160, 134);
		choco_cnt.setVisible(true);
		choco_cnt.setOpaque(false);
		choco_cnt.setBorder(BorderFactory.createEmptyBorder());
		choco_cnt.setHorizontalAlignment(JTextField.CENTER);
		choco_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(choco_cnt);
		
		//초코 재고 추가
		choco_in.setBounds(1240, 789, 159, 134);
		choco_in.setVisible(true);
		choco_in.setBorderPainted(false);
		choco_in.setContentAreaFilled(false);
		choco_in.setFocusPainted(false);
		choco_in.setOpaque(false);
		choco_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cake_db("choco");
				choco_s.setText(Integer.toString(choco_s_db) + "조각");
				choco_cnt.setText("");
			}
		});
		add(choco_in);		
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
            	cheese_s_db = rset.getInt("CHEESE_S");
            	sc_s_db = rset.getInt("SC_S");
            	choco_s_db = rset.getInt("CHOCO_S");
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
	public void cake_db(String menu) {	
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
            	if(menu.equals("cheese")){
            		cheese_s_db = rset.getInt("CHEESE_S") + Integer.parseInt(cheese_cnt.getText());
                	query = "UPDATE MENU_CAKE SET CHEESE_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, cheese_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("sc")) {
            		sc_s_db = rset.getInt("SC_S") + Integer.parseInt(sc_cnt.getText());
                	query = "UPDATE MENU_CAKE SET SC_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, sc_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("choco")) {
            		choco_s_db = rset.getInt("CHOCO_S") + Integer.parseInt(choco_cnt.getText());
                	query = "UPDATE MENU_CAKE SET CHOCO_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, choco_s_db);
        			pstmt.executeUpdate();
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
class GMacaronStockPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_43.png");

	JButton stock_exit_button = new JButton(icon);
	JButton coffe_stock_button = new JButton(icon);
	JButton smoothie_stock_button = new JButton(icon);
	JButton tea_stock_button = new JButton(icon);
	JButton bubble_stock_button = new JButton(icon);
	JButton cake_stock_button = new JButton(icon);

	String bname = ManagerPanel.getBname();
	
	JLabel berry_s = new JLabel();
	JLabel yogurt_s = new JLabel();
	JLabel fruit_s = new JLabel();
	
	JTextField berry_cnt = new JTextField();
	JTextField yogurt_cnt = new JTextField();
	JTextField fruit_cnt = new JTextField();
	
	JButton berry_in = new JButton();
	JButton yogurt_in = new JButton();
	JButton fruit_in = new JButton();

	int berry_s_db;
	int yogurt_s_db;
	int fruit_s_db;
	
	GMacaronStockPanel() {
		macaron_db();
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//재고 출관리 취소
		stock_exit_button.setBounds(61, 35, 126, 35);
		stock_exit_button.setVisible(true);
		stock_exit_button.setBorderPainted(false);
		stock_exit_button.setContentAreaFilled(false);
		stock_exit_button.setFocusPainted(false);
		stock_exit_button.setOpaque(false);
		stock_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getGMacaron_stock_panel().setVisible(false);
				berry_cnt.setText("");
				yogurt_cnt.setText("");
				fruit_cnt.setText("");
			}
		});
		add(stock_exit_button);

		//커피 재고 버튼
		coffe_stock_button.setBounds(111, 180, 73, 34);
		coffe_stock_button.setVisible(true);
		coffe_stock_button.setBorderPainted(false);
		coffe_stock_button.setContentAreaFilled(false);
		coffe_stock_button.setFocusPainted(false);
		coffe_stock_button.setOpaque(false);
		coffe_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCoffee_stock_panel().setVisible(true);
				Main.MainFrame.getGMacaron_stock_panel().setVisible(false);
				berry_cnt.setText("");
				yogurt_cnt.setText("");
				fruit_cnt.setText("");
			}
		});
		add(coffe_stock_button);

		//스무디 재고 버튼
		smoothie_stock_button.setBounds(402, 180, 114, 40);
		smoothie_stock_button.setVisible(true);
		smoothie_stock_button.setBorderPainted(false);
		smoothie_stock_button.setContentAreaFilled(false);
		smoothie_stock_button.setFocusPainted(false);
		smoothie_stock_button.setOpaque(false);
		smoothie_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGSmoothie_stock_panel().setVisible(true);
				Main.MainFrame.getGMacaron_stock_panel().setVisible(false);
				berry_cnt.setText("");
				yogurt_cnt.setText("");
				fruit_cnt.setText("");
			}
		});
		add(smoothie_stock_button);

		//차 재고 버튼
		tea_stock_button.setBounds(745, 178, 39, 36);
		tea_stock_button.setVisible(true);
		tea_stock_button.setBorderPainted(false);
		tea_stock_button.setContentAreaFilled(false);
		tea_stock_button.setFocusPainted(false);
		tea_stock_button.setOpaque(false);
		tea_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGTea_stock_panel().setVisible(true);
				Main.MainFrame.getGMacaron_stock_panel().setVisible(false);
				berry_cnt.setText("");
				yogurt_cnt.setText("");
				fruit_cnt.setText("");
			}
		});
		add(tea_stock_button);

		//버블티 재고 버튼
		bubble_stock_button.setBounds(1025, 179, 113, 43);
		bubble_stock_button.setVisible(true);
		bubble_stock_button.setBorderPainted(false);
		bubble_stock_button.setContentAreaFilled(false);
		bubble_stock_button.setFocusPainted(false);
		bubble_stock_button.setOpaque(false);
		bubble_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGBubble_stock_panel().setVisible(true);
				Main.MainFrame.getGMacaron_stock_panel().setVisible(false);
				berry_cnt.setText("");
				yogurt_cnt.setText("");
				fruit_cnt.setText("");
			}
		});
		add(bubble_stock_button);

		//케이크 재고 버튼
		cake_stock_button.setBounds(1329, 180, 116, 35);
		cake_stock_button.setVisible(true);
		cake_stock_button.setBorderPainted(false);
		cake_stock_button.setContentAreaFilled(false);
		cake_stock_button.setFocusPainted(false);
		cake_stock_button.setOpaque(false);
		cake_stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getGCake_stock_panel().setVisible(true);
				Main.MainFrame.getGMacaron_stock_panel().setVisible(false);
				berry_cnt.setText("");
				yogurt_cnt.setText("");
				fruit_cnt.setText("");
			}
		});
		add(cake_stock_button);

		//베리 재고
		berry_s.setBounds(762, 509, 312, 134);
		berry_s.setText(Integer.toString(berry_s_db) + "개");
		berry_s.setHorizontalAlignment(JLabel.CENTER);
		berry_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(berry_s);
		
		//베리 재고  추가 필드
		berry_cnt.setBounds(1077, 509, 160, 134);
		berry_cnt.setVisible(true);
		berry_cnt.setOpaque(false);
		berry_cnt.setBorder(BorderFactory.createEmptyBorder());
		berry_cnt.setHorizontalAlignment(JTextField.CENTER);
		berry_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(berry_cnt);
		
		//베리 재고 추가
		berry_in.setBounds(1240, 509, 159, 134);
		berry_in.setVisible(true);
		berry_in.setBorderPainted(false);
		berry_in.setContentAreaFilled(false);
		berry_in.setFocusPainted(false);
		berry_in.setOpaque(false);
		berry_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				macaron_db("berry");
				berry_s.setText(Integer.toString(berry_s_db) + "개");
				berry_cnt.setText("");
			}
		});
		add(berry_in);

		//요거트 재고
		yogurt_s.setBounds(762, 646, 312, 134);
		yogurt_s.setText(Integer.toString(yogurt_s_db) + "개");
		yogurt_s.setHorizontalAlignment(JLabel.CENTER);
		yogurt_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(yogurt_s);
		
		//요거트 재고  추가 필드
		yogurt_cnt.setBounds(1077, 646, 160, 134);
		yogurt_cnt.setVisible(true);
		yogurt_cnt.setOpaque(false);
		yogurt_cnt.setBorder(BorderFactory.createEmptyBorder());
		yogurt_cnt.setHorizontalAlignment(JTextField.CENTER);
		yogurt_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(yogurt_cnt);
		
		//요거트 재고 추가
		yogurt_in.setBounds(1240, 646, 159, 134);
		yogurt_in.setVisible(true);
		yogurt_in.setBorderPainted(false);
		yogurt_in.setContentAreaFilled(false);
		yogurt_in.setFocusPainted(false);
		yogurt_in.setOpaque(false);
		yogurt_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				macaron_db("yogurt");
				yogurt_s.setText(Integer.toString(yogurt_s_db) + "개");
				yogurt_cnt.setText("");
			}
		});
		add(yogurt_in);

		//과일 재고
		fruit_s.setBounds(762, 783, 312, 134);
		fruit_s.setText(Integer.toString(fruit_s_db) + "개");
		fruit_s.setHorizontalAlignment(JLabel.CENTER);
		fruit_s.setFont(new Font("인터파크고딕 L", Font.PLAIN, 45));
		add(fruit_s);
		
		//과일 재고  추가 필드
		fruit_cnt.setBounds(1077, 783, 160, 134);
		fruit_cnt.setVisible(true);
		fruit_cnt.setOpaque(false);
		fruit_cnt.setBorder(BorderFactory.createEmptyBorder());
		fruit_cnt.setHorizontalAlignment(JTextField.CENTER);
		fruit_cnt.setFont(new Font("인터파크고딕 L", Font.PLAIN, 80));
		add(fruit_cnt);
		
		//과일 재고 추가
		fruit_in.setBounds(1240, 783, 159, 134);
		fruit_in.setVisible(true);
		fruit_in.setBorderPainted(false);
		fruit_in.setContentAreaFilled(false);
		fruit_in.setFocusPainted(false);
		fruit_in.setOpaque(false);
		fruit_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				macaron_db("fruit");
				fruit_s.setText(Integer.toString(fruit_s_db) + "개");
				fruit_cnt.setText("");
			}
		});
		add(fruit_in);
		
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
            	berry_s_db = rset.getInt("BERRY_S");
            	yogurt_s_db = rset.getInt("YOGURT_S");
            	fruit_s_db = rset.getInt("FRUIT_S");
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
	public void macaron_db(String menu) {
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
            	if(menu.equals("berry")){
            		berry_s_db = rset.getInt("BERRY_S") + Integer.parseInt(berry_cnt.getText());
                	query = "UPDATE MENU_MACARON SET BERRY_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, berry_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("yogurt")) {
            		yogurt_s_db = rset.getInt("YOGURT_S") + Integer.parseInt(yogurt_cnt.getText());
                	query = "UPDATE MENU_MACARON SET YOGURT_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, yogurt_s_db);
        			pstmt.executeUpdate();
            	}else if(menu.equals("fruit")) {
            		fruit_s_db = rset.getInt("FRUIT_S") + Integer.parseInt(fruit_cnt.getText());
                	query = "UPDATE MENU_MACARON SET FRUIT_S = ?";
                	pstmt = conn.prepareStatement(query);
        			pstmt.setInt(1, fruit_s_db);
        			pstmt.executeUpdate();
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