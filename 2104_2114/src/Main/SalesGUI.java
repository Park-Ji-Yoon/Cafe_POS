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
	
	ImageIcon background = new ImageIcon("images/background_23.png");

	JButton sales_exit_button = new JButton(icon);
	JButton coffe_sales_button = new JButton(icon);
	JButton smoothie_sales_button = new JButton(icon);
	JButton tea_sales_button = new JButton(icon);
	JButton bubble_sales_button = new JButton(icon);
	JButton cake_sales_button = new JButton(icon);
	JButton macaron_sales_button = new JButton(icon);
	
	static JLabel day_label = new JLabel();
	static JLabel month_label = new JLabel();
		
	static String bname;

	SalesPanel() {		
		setBounds(0, 0, 1862, 1055); // ��ġ�� ũ�� ����
		setLayout(null);
		setVisible(true);

		//������� ���
		sales_exit_button.setBounds(61, 35, 126, 35);
		sales_exit_button.setVisible(true);
		sales_exit_button.setBorderPainted(false);
		sales_exit_button.setContentAreaFilled(false);
		sales_exit_button.setFocusPainted(false);
		sales_exit_button.setOpaque(false);
		sales_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(sales_exit_button);


		day_label.setBounds(600, 35, 300, 80);
		day_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		day_label.setVisible(true);
		day_label.setForeground(Color.BLACK);
		add(day_label);


		month_label.setBounds(1000, 35, 300, 80);
		month_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		month_label.setVisible(true);
		month_label.setForeground(Color.BLACK);
		add(month_label);
		
		//Ŀ�� ����� ��ư
		coffe_sales_button.setBounds(115, 184, 67, 30);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCoffeeSalesPanel.coffee_db();
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//������ ����� ��ư
		smoothie_sales_button.setBounds(412, 184, 103, 35);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GSmoothieSalesPanel.smoothie_db();
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//�� ����� ��ư
		tea_sales_button.setBounds(755, 182, 35, 32);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GTeaSalesPanel.tea_db();
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//����Ƽ ����� ��ư
		bubble_sales_button.setBounds(1035, 183, 103, 39);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GBubbleSalesPanel.bubble_db();
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//����ũ ����� ��ư
		cake_sales_button.setBounds(1338, 184, 107, 30);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCakeSalesPanel.cake_db();
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//��ī�� ����� ��ư
		macaron_sales_button.setBounds(1655, 184, 106, 39);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GMacaronSalesPanel.macaron_db();
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getSales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);
		
		SalesDB.CoffeSalesDB();
		SalesDB.SmoothieSalesDB();
		SalesDB.TeaSalesDB();
		SalesDB.BubbleSalesDB();
		SalesDB.CakeSalesDB();
		SalesDB.MacaronSalesDB();
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

	static JLabel ice_d = new JLabel();
	static JLabel ice_m = new JLabel();
	static JLabel hot_d = new JLabel();
	static JLabel hot_m = new JLabel();

	static JLabel day_label = new JLabel();
	static JLabel month_label = new JLabel();
	
	static int ice_d_db;
	static int ice_m_db;
	static int hot_d_db;
	static int hot_m_db;

	GCoffeeSalesPanel() {
		coffee_db();
		
		setBounds(0, 0, 1862, 1055); // ��ġ�� ũ�� ����
		setLayout(null);
		setVisible(true);

		//������� ���
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

		day_label.setBounds(600, 35, 300, 80);
		day_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		day_label.setVisible(true);
		day_label.setForeground(Color.BLACK);
		add(day_label);


		month_label.setBounds(1000, 35, 300, 80);
		month_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		month_label.setVisible(true);
		month_label.setForeground(Color.BLACK);
		add(month_label);
		
		//������ ����� ��ư
		smoothie_sales_button.setBounds(402, 180, 114, 40);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GSmoothieSalesPanel.smoothie_db();
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getGCoffee_sales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//�� ����� ��ư
		tea_sales_button.setBounds(745, 178, 39, 36);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GTeaSalesPanel.tea_db();
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getGCoffee_sales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//����Ƽ ����� ��ư
		bubble_sales_button.setBounds(1025, 179, 113, 43);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GBubbleSalesPanel.bubble_db();
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getGCoffee_sales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//����ũ ����� ��ư
		cake_sales_button.setBounds(1329, 180, 116, 35);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCakeSalesPanel.cake_db();
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getGCoffee_sales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//��ī�� ����� ��ư
		macaron_sales_button.setBounds(1645, 180, 116, 43);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GMacaronSalesPanel.macaron_db();
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getGCoffee_sales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);

		//���̽� �Ϻ�
		ice_d.setBounds(762, 551, 312, 121);
		ice_d.setText(Integer.toString(ice_d_db));
		ice_d.setHorizontalAlignment(JLabel.CENTER);
		ice_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(ice_d);

		//���̽� ����
		ice_m.setBounds(1078, 551, 320, 121);
		ice_m.setText(Integer.toString(ice_m_db));
		ice_m.setHorizontalAlignment(JLabel.CENTER);
		ice_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(ice_m);

		//�� �Ϻ�
		hot_d.setBounds(762, 675, 312, 134);
		hot_d.setText(Integer.toString(hot_d_db));
		hot_d.setHorizontalAlignment(JLabel.CENTER);
		hot_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(hot_d);

		//�� ����
		hot_m.setBounds(1078, 675, 320, 134);
		hot_m.setText(Integer.toString(hot_m_db));
		hot_m.setHorizontalAlignment(JLabel.CENTER);
		hot_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
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
	
	//Ŀ�� �Ϻ�, ���� �����
	public static void coffee_db() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT * FROM MENU_COFFEE WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, SalesPanel.bname);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
            while (result = rset.next()) {
            	ice_d_db = rset.getInt("ICE_D") * 2500;
        		ice_d.setText(Integer.toString(ice_d_db));
            	ice_m_db = rset.getInt("ICE_M") * 2500;
        		ice_m.setText(Integer.toString(ice_m_db));
            	hot_d_db = rset.getInt("HOT_D") * 2500;
        		hot_d.setText(Integer.toString(hot_d_db));
            	hot_m_db = rset.getInt("HOT_M") * 2500;
        		hot_m.setText(Integer.toString(hot_m_db));
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

	static JLabel orange_d = new JLabel();
	static JLabel orange_m = new JLabel();
	static JLabel kiwi_d = new JLabel();
	static JLabel kiwi_m = new JLabel();
	static JLabel grape_d = new JLabel();
	static JLabel grape_m = new JLabel();
	static JLabel straw_d = new JLabel();
	static JLabel straw_m = new JLabel();
	static JLabel water_d = new JLabel();
	static JLabel water_m = new JLabel();


	static int orange_d_db;
	static int orange_m_db;
	static int kiwi_d_db;
	static int kiwi_m_db;
	static int grape_d_db;
	static int grape_m_db;
	static int straw_d_db;
	static int straw_m_db;
	static int water_d_db;
	static int water_m_db;

	static JLabel day_label = new JLabel();
	static JLabel month_label = new JLabel();
	
	GSmoothieSalesPanel() {
		smoothie_db();
		
		setBounds(0, 0, 1862, 1055); // ��ġ�� ũ�� ����
		setLayout(null);
		setVisible(true);

		//������� ���
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
		
		day_label.setBounds(600, 35, 300, 80);
		day_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		day_label.setVisible(true);
		day_label.setForeground(Color.BLACK);
		add(day_label);


		month_label.setBounds(1000, 35, 300, 80);
		month_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		month_label.setVisible(true);
		month_label.setForeground(Color.BLACK);
		add(month_label);
		

		//Ŀ�� ����� ��ư
		coffe_sales_button.setBounds(111, 180, 73, 34);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCoffeeSalesPanel.coffee_db();
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//�� ����� ��ư
		tea_sales_button.setBounds(745, 178, 39, 36);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GTeaSalesPanel.tea_db();
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//����Ƽ ����� ��ư
		bubble_sales_button.setBounds(1025, 179, 113, 43);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GBubbleSalesPanel.bubble_db();
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//����ũ ����� ��ư
		cake_sales_button.setBounds(1329, 180, 116, 35);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCakeSalesPanel.cake_db();
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//��ī�� ����� ��ư
		macaron_sales_button.setBounds(1645, 180, 116, 43);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GMacaronSalesPanel.macaron_db();
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);

		//������ �Ϻ�
		orange_d.setBounds(762, 429, 312, 102);
		orange_d.setText(Integer.toString(orange_d_db));
		orange_d.setHorizontalAlignment(JLabel.CENTER);
		orange_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(orange_d);

		//������ ����
		orange_m.setBounds(1078, 429, 321, 102);
		orange_m.setText(Integer.toString(orange_m_db));
		orange_m.setHorizontalAlignment(JLabel.CENTER);
		orange_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(orange_m);

		//Ű�� �Ϻ�
		kiwi_d.setBounds(762, 535, 312, 102);
		kiwi_d.setText(Integer.toString(kiwi_d_db));
		kiwi_d.setHorizontalAlignment(JLabel.CENTER);
		kiwi_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(kiwi_d);

		//Ű�� ����
		kiwi_m.setBounds(1078, 535, 321, 102);
		kiwi_m.setText(Integer.toString(kiwi_m_db));
		kiwi_m.setHorizontalAlignment(JLabel.CENTER);
		kiwi_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(kiwi_m);

		//���� �Ϻ�
		grape_d.setBounds(762, 641, 312, 102);
		grape_d.setText(Integer.toString(grape_d_db));
		grape_d.setHorizontalAlignment(JLabel.CENTER);
		grape_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(grape_d);

		//���� ����
		grape_m.setBounds(1078, 641, 321, 102);
		grape_m.setText(Integer.toString(grape_m_db));
		grape_m.setHorizontalAlignment(JLabel.CENTER);
		grape_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(grape_m);

		//���� �Ϻ�
		straw_d.setBounds(762, 747, 312, 102);
		straw_d.setText(Integer.toString(straw_d_db));
		straw_d.setHorizontalAlignment(JLabel.CENTER);
		straw_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(straw_d);

		//���� ����
		straw_m.setBounds(1078, 747, 321, 102);
		straw_m.setText(Integer.toString(straw_m_db));
		straw_m.setHorizontalAlignment(JLabel.CENTER);
		straw_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(straw_m);

		//���� �Ϻ�
		water_d.setBounds(762, 853, 312, 106);
		water_d.setText(Integer.toString(water_d_db));
		water_d.setHorizontalAlignment(JLabel.CENTER);
		water_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(water_d);

		//���� ����
		water_m.setBounds(1078, 853, 321, 106);
		water_m.setText(Integer.toString(water_m_db));
		water_m.setHorizontalAlignment(JLabel.CENTER);
		water_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
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
	
	//������ �Ϻ�, ���� �����
	public static void smoothie_db() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT * FROM MENU_SMOOTHIE WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, SalesPanel.bname);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
            while (result = rset.next()) {
            	orange_d_db = rset.getInt("ORANGE_D") * 3500;
        		orange_d.setText(Integer.toString(orange_d_db));
            	orange_m_db = rset.getInt("ORANGE_M") * 3500;
        		orange_m.setText(Integer.toString(orange_m_db));
            	kiwi_d_db = rset.getInt("KIWI_D") * 3500;
        		kiwi_d.setText(Integer.toString(kiwi_d_db));
            	kiwi_m_db = rset.getInt("KIWI_M") * 3500;
        		kiwi_m.setText(Integer.toString(kiwi_m_db));
            	grape_d_db = rset.getInt("GRAPE_D") * 3500;
        		grape_d.setText(Integer.toString(grape_d_db));
            	grape_m_db = rset.getInt("GRAPE_M") * 3500;
        		grape_m.setText(Integer.toString(grape_m_db));
            	straw_d_db = rset.getInt("STRAW_D") * 3500;
        		straw_d.setText(Integer.toString(straw_d_db));
            	straw_m_db = rset.getInt("STRAW_M") * 3500;
        		straw_m.setText(Integer.toString(straw_m_db));
            	water_d_db = rset.getInt("WATER_D") * 3500;
        		water_d.setText(Integer.toString(water_d_db));
            	water_m_db = rset.getInt("WATER_M") * 3500;
        		water_m.setText(Integer.toString(water_m_db));
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

	static JLabel green_d = new JLabel();
	static JLabel green_m = new JLabel();
	static JLabel black_d = new JLabel();
	static JLabel black_m = new JLabel();

	static int green_d_db;
	static int green_m_db;
	static int black_d_db;
	static int black_m_db;

	static JLabel day_label = new JLabel();
	static JLabel month_label = new JLabel();
	
	GTeaSalesPanel() {
		tea_db();
		
		setBounds(0, 0, 1862, 1055); // ��ġ�� ũ�� ����
		setLayout(null);
		setVisible(true);

		//������� ���
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

		day_label.setBounds(600, 35, 300, 80);
		day_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		day_label.setVisible(true);
		day_label.setForeground(Color.BLACK);
		add(day_label);


		month_label.setBounds(1000, 35, 300, 80);
		month_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		month_label.setVisible(true);
		month_label.setForeground(Color.BLACK);
		add(month_label);
		
		//Ŀ�� ����� ��ư
		coffe_sales_button.setBounds(111, 180, 73, 34);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCoffeeSalesPanel.coffee_db();
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getGTea_sales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//������ ����� ��ư
		smoothie_sales_button.setBounds(402, 180, 114, 40);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GSmoothieSalesPanel.smoothie_db();
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getGTea_sales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//����Ƽ ����� ��ư
		bubble_sales_button.setBounds(1025, 179, 113, 43);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GBubbleSalesPanel.bubble_db();
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getGTea_sales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//����ũ ����� ��ư
		cake_sales_button.setBounds(1329, 180, 116, 35);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCakeSalesPanel.cake_db();
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getGTea_sales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//��ī�� ����� ��ư
		macaron_sales_button.setBounds(1645, 180, 116, 43);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GMacaronSalesPanel.macaron_db();
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getGTea_sales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);

		//���� �Ϻ�
		green_d.setBounds(762, 549, 312, 134);
		green_d.setText(Integer.toString(green_d_db));
		green_d.setHorizontalAlignment(JLabel.CENTER);
		green_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(green_d);

		//���� ����
		green_m.setBounds(1078, 549, 320, 134);
		green_m.setText(Integer.toString(green_m_db));
		green_m.setHorizontalAlignment(JLabel.CENTER);
		green_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(green_m);

		//ȫ�� �Ϻ�
		black_d.setBounds(762, 686, 312, 134);
		black_d.setText(Integer.toString(black_d_db));
		black_d.setHorizontalAlignment(JLabel.CENTER);
		black_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(black_d);

		//ȫ�� ����
		black_m.setBounds(1078, 686, 320, 134);
		black_m.setText(Integer.toString(black_m_db));
		black_m.setHorizontalAlignment(JLabel.CENTER);
		black_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
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
	
	//�� �Ϻ�, ���� �����
	public static void tea_db() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT * FROM MENU_TEA WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, SalesPanel.bname);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
            while (result = rset.next()) {
            	green_d_db = rset.getInt("GREEN_D") * 3000;
        		green_d.setText(Integer.toString(green_d_db));
            	green_m_db = rset.getInt("GREEN_M") * 3000;
        		green_m.setText(Integer.toString(green_m_db));
            	black_d_db = rset.getInt("BLACK_D") * 3000;
        		black_d.setText(Integer.toString(black_d_db));
            	black_m_db = rset.getInt("BLACK_M") * 3000;
        		black_m.setText(Integer.toString(black_m_db));
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

	static JLabel bs_d = new JLabel();
	static JLabel bs_m = new JLabel();
	static JLabel taro_d = new JLabel();
	static JLabel taro_m = new JLabel();
	static JLabel gb_d = new JLabel();
	static JLabel gb_m = new JLabel();


	static int bs_d_db;
	static int bs_m_db;
	static int taro_d_db;
	static int taro_m_db;
	static int gb_d_db;
	static int gb_m_db;

	static JLabel day_label = new JLabel();
	static JLabel month_label = new JLabel();
	
	GBubbleSalesPanel() {
		bubble_db();
		
		setBounds(0, 0, 1862, 1055); // ��ġ�� ũ�� ����
		setLayout(null);
		setVisible(true);

		//������� ���
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

		day_label.setBounds(600, 35, 300, 80);
		day_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		day_label.setVisible(true);
		day_label.setForeground(Color.BLACK);
		add(day_label);


		month_label.setBounds(1000, 35, 300, 80);
		month_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		month_label.setVisible(true);
		month_label.setForeground(Color.BLACK);
		add(month_label);
		
		//Ŀ�� ����� ��ư
		coffe_sales_button.setBounds(111, 180, 73, 34);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCoffeeSalesPanel.coffee_db();
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getGBubble_sales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//������ ����� ��ư
		smoothie_sales_button.setBounds(402, 180, 114, 40);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GSmoothieSalesPanel.smoothie_db();
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getGBubble_sales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//�� ����� ��ư
		tea_sales_button.setBounds(745, 178, 39, 36);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GTeaSalesPanel.tea_db();
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getGBubble_sales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//����ũ ����� ��ư
		cake_sales_button.setBounds(1329, 180, 116, 35);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCakeSalesPanel.cake_db();
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getGBubble_sales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//��ī�� ����� ��ư
		macaron_sales_button.setBounds(1645, 180, 116, 43);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GMacaronSalesPanel.macaron_db();
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getGBubble_sales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);

		//��� �Ϻ�
		bs_d.setBounds(762, 509, 312, 134);
		bs_d.setText(Integer.toString(bs_d_db));
		bs_d.setHorizontalAlignment(JLabel.CENTER);
		bs_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(bs_d);

		//��� ����
		bs_m.setBounds(1078, 509, 320, 134);
		bs_m.setText(Integer.toString(bs_m_db));
		bs_m.setHorizontalAlignment(JLabel.CENTER);
		bs_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(bs_m);

		//Ÿ�� �Ϻ�
		taro_d.setBounds(762, 646, 312, 134);
		taro_d.setText(Integer.toString(taro_d_db));
		taro_d.setHorizontalAlignment(JLabel.CENTER);
		taro_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(taro_d);

		//Ÿ�� ����
		taro_m.setBounds(1078, 646, 320, 134);
		taro_m.setText(Integer.toString(taro_m_db));
		taro_m.setHorizontalAlignment(JLabel.CENTER);
		taro_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(taro_m);

		//���� �Ϻ�
		gb_d.setBounds(762, 783, 312, 134);
		gb_d.setText(Integer.toString(gb_d_db));
		gb_d.setHorizontalAlignment(JLabel.CENTER);
		gb_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(gb_d);

		//���� ����
		gb_m.setBounds(1078, 783, 320, 134);
		gb_m.setText(Integer.toString(gb_m_db));
		gb_m.setHorizontalAlignment(JLabel.CENTER);
		gb_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
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
	
	//����Ƽ �Ϻ�, ���� �����
	public static void bubble_db() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT * FROM MENU_BUBBLE WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, SalesPanel.bname);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
            while (result = rset.next()) {
            	bs_d_db = rset.getInt("BS_D") * 4000;
        		bs_d.setText(Integer.toString(bs_d_db));
            	bs_m_db = rset.getInt("BS_M") * 4000;
        		bs_m.setText(Integer.toString(bs_m_db));
            	taro_d_db = rset.getInt("TARO_D") * 4000;
        		taro_d.setText(Integer.toString(taro_d_db));
            	taro_m_db = rset.getInt("TARO_M") * 4000;
        		taro_m.setText(Integer.toString(taro_m_db));
            	gb_d_db = rset.getInt("GB_D") * 4000;
        		gb_d.setText(Integer.toString(gb_d_db));
            	gb_m_db = rset.getInt("GB_M") * 4000;
        		gb_m.setText(Integer.toString(gb_m_db));
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

	static JLabel cheese_d = new JLabel();
	static JLabel cheese_m = new JLabel();
	static JLabel sc_d = new JLabel();
	static JLabel sc_m = new JLabel();
	static JLabel choco_d = new JLabel();
	static JLabel choco_m = new JLabel();

	static int cheese_d_db;
	static int cheese_m_db;
	static int sc_d_db;
	static int sc_m_db;
	static int choco_d_db;
	static int choco_m_db;

	static JLabel day_label = new JLabel();
	static JLabel month_label = new JLabel();
	
	GCakeSalesPanel() {
		cake_db();
		
		setBounds(0, 0, 1862, 1055); // ��ġ�� ũ�� ����
		setLayout(null);
		setVisible(true);

		//������� ���
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

		day_label.setBounds(600, 35, 300, 80);
		day_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		day_label.setVisible(true);
		day_label.setForeground(Color.BLACK);
		add(day_label);


		month_label.setBounds(1000, 35, 300, 80);
		month_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		month_label.setVisible(true);
		month_label.setForeground(Color.BLACK);
		add(month_label);
		
		//Ŀ�� ����� ��ư
		coffe_sales_button.setBounds(111, 180, 73, 34);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCoffeeSalesPanel.coffee_db();
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getGCake_sales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//������ ����� ��ư
		smoothie_sales_button.setBounds(402, 180, 114, 40);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GSmoothieSalesPanel.smoothie_db();
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getGCake_sales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//�� ����� ��ư
		tea_sales_button.setBounds(745, 178, 39, 36);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GTeaSalesPanel.tea_db();
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getGCake_sales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//����Ƽ ����� ��ư
		bubble_sales_button.setBounds(1025, 179, 113, 43);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GBubbleSalesPanel.bubble_db();
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getGCake_sales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//��ī�� ����� ��ư
		macaron_sales_button.setBounds(1645, 180, 116, 43);
		macaron_sales_button.setVisible(true);
		macaron_sales_button.setBorderPainted(false);
		macaron_sales_button.setContentAreaFilled(false);
		macaron_sales_button.setFocusPainted(false);
		macaron_sales_button.setOpaque(false);
		macaron_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GMacaronSalesPanel.macaron_db();
				Main.MainFrame.getGMacaron_sales_panel().setVisible(true);
				Main.MainFrame.getGCake_sales_panel().setVisible(false);
			}
		});
		add(macaron_sales_button);

		//ġ�� �Ϻ�
		cheese_d.setBounds(762, 509, 312, 134);
		cheese_d.setText(Integer.toString(cheese_d_db));
		cheese_d.setHorizontalAlignment(JLabel.CENTER);
		cheese_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(cheese_d);

		//ġ�� ����
		cheese_m.setBounds(1078, 509, 320, 134);
		cheese_m.setText(Integer.toString(cheese_m_db));
		cheese_m.setHorizontalAlignment(JLabel.CENTER);
		cheese_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(cheese_m);

		//���� �Ϻ�
		sc_d.setBounds(762, 646, 312, 134);
		sc_d.setText(Integer.toString(sc_d_db));
		sc_d.setHorizontalAlignment(JLabel.CENTER);
		sc_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(sc_d);

		//���� ����
		sc_m.setBounds(1078, 646, 320, 134);
		sc_m.setText(Integer.toString(sc_m_db));
		sc_m.setHorizontalAlignment(JLabel.CENTER);
		sc_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(sc_m);

		//���� �Ϻ�
		choco_d.setBounds(762, 783, 312, 134);
		choco_d.setText(Integer.toString(choco_d_db));
		choco_d.setHorizontalAlignment(JLabel.CENTER);
		choco_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(choco_d);

		//���� ����
		choco_m.setBounds(1078, 783, 320, 134);
		choco_m.setText(Integer.toString(choco_m_db));
		choco_m.setHorizontalAlignment(JLabel.CENTER);
		choco_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
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
	
	//����ũ �Ϻ�, ���� �����
	public static void cake_db() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT * FROM MENU_CAKE WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, SalesPanel.bname);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
            while (result = rset.next()) {
            	cheese_d_db = rset.getInt("CHEESE_D") * 5000;
        		cheese_d.setText(Integer.toString(cheese_d_db));
            	cheese_m_db = rset.getInt("CHEESE_M") * 5000;
        		cheese_m.setText(Integer.toString(cheese_m_db));
            	sc_d_db = rset.getInt("SC_D") * 5000;
        		sc_d.setText(Integer.toString(sc_d_db));
            	sc_m_db = rset.getInt("SC_M") * 5000;
        		sc_m.setText(Integer.toString(sc_m_db));
            	choco_d_db = rset.getInt("CHOCO_D") * 5000;
        		choco_d.setText(Integer.toString(choco_d_db));
            	choco_m_db = rset.getInt("CHOCO_M") * 5000;
        		choco_m.setText(Integer.toString(choco_m_db));
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

	static JLabel berry_d = new JLabel();
	static JLabel berry_m = new JLabel();
	static JLabel yogurt_d = new JLabel();
	static JLabel yogurt_m = new JLabel();
	static JLabel fruit_d = new JLabel();
	static JLabel fruit_m = new JLabel();


	static 	int berry_d_db;
	static 	int berry_m_db;
	static int yogurt_d_db;
	static int yogurt_m_db;
	static int fruit_d_db;
	static int fruit_m_db;

	static JLabel day_label = new JLabel();
	static JLabel month_label = new JLabel();
	
	GMacaronSalesPanel() {
		macaron_db();
		
		setBounds(0, 0, 1862, 1055); // ��ġ�� ũ�� ����
		setLayout(null);
		setVisible(true);

		//������� ���
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

		day_label.setBounds(600, 35, 300, 80);
		day_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		day_label.setVisible(true);
		day_label.setForeground(Color.BLACK);
		add(day_label);


		month_label.setBounds(1000, 35, 300, 80);
		month_label.setFont(new Font("������ũ��� M", Font.PLAIN, 50));
		month_label.setVisible(true);
		month_label.setForeground(Color.BLACK);
		add(month_label);
		
		//Ŀ�� ����� ��ư
		coffe_sales_button.setBounds(111, 180, 73, 34);
		coffe_sales_button.setVisible(true);
		coffe_sales_button.setBorderPainted(false);
		coffe_sales_button.setContentAreaFilled(false);
		coffe_sales_button.setFocusPainted(false);
		coffe_sales_button.setOpaque(false);
		coffe_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCoffeeSalesPanel.coffee_db();
				Main.MainFrame.getGCoffee_sales_panel().setVisible(true);
				Main.MainFrame.getGMacaron_sales_panel().setVisible(false);
			}
		});
		add(coffe_sales_button);

		//������ ����� ��ư
		smoothie_sales_button.setBounds(402, 180, 114, 40);
		smoothie_sales_button.setVisible(true);
		smoothie_sales_button.setBorderPainted(false);
		smoothie_sales_button.setContentAreaFilled(false);
		smoothie_sales_button.setFocusPainted(false);
		smoothie_sales_button.setOpaque(false);
		smoothie_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GSmoothieSalesPanel.smoothie_db();
				Main.MainFrame.getGSmoothie_sales_panel().setVisible(true);
				Main.MainFrame.getGMacaron_sales_panel().setVisible(false);
			}
		});
		add(smoothie_sales_button);

		//�� ����� ��ư
		tea_sales_button.setBounds(745, 178, 39, 36);
		tea_sales_button.setVisible(true);
		tea_sales_button.setBorderPainted(false);
		tea_sales_button.setContentAreaFilled(false);
		tea_sales_button.setFocusPainted(false);
		tea_sales_button.setOpaque(false);
		tea_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GTeaSalesPanel.tea_db();
				Main.MainFrame.getGTea_sales_panel().setVisible(true);
				Main.MainFrame.getGMacaron_sales_panel().setVisible(false);
			}
		});
		add(tea_sales_button);

		//����Ƽ ����� ��ư
		bubble_sales_button.setBounds(1025, 179, 113, 43);
		bubble_sales_button.setVisible(true);
		bubble_sales_button.setBorderPainted(false);
		bubble_sales_button.setContentAreaFilled(false);
		bubble_sales_button.setFocusPainted(false);
		bubble_sales_button.setOpaque(false);
		bubble_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GBubbleSalesPanel.bubble_db();
				Main.MainFrame.getGBubble_sales_panel().setVisible(true);
				Main.MainFrame.getGMacaron_sales_panel().setVisible(false);
			}
		});
		add(bubble_sales_button);

		//����ũ ����� ��ư
		cake_sales_button.setBounds(1329, 180, 116, 35);
		cake_sales_button.setVisible(true);
		cake_sales_button.setBorderPainted(false);
		cake_sales_button.setContentAreaFilled(false);
		cake_sales_button.setFocusPainted(false);
		cake_sales_button.setOpaque(false);
		cake_sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GCakeSalesPanel.cake_db();
				Main.MainFrame.getGCake_sales_panel().setVisible(true);
				Main.MainFrame.getGMacaron_sales_panel().setVisible(false);
			}
		});
		add(cake_sales_button);

		//���� �Ϻ�
		berry_d.setBounds(762, 509, 312, 134);
		berry_d.setText(Integer.toString(berry_d_db));
		berry_d.setHorizontalAlignment(JLabel.CENTER);
		berry_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(berry_d);

		//���� ����
		berry_m.setBounds(1078, 509, 320, 134);
		berry_m.setText(Integer.toString(berry_m_db));
		berry_m.setHorizontalAlignment(JLabel.CENTER);
		berry_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(berry_m);

		//���Ʈ �Ϻ�
		yogurt_d.setBounds(762, 646, 312, 134);
		yogurt_d.setText(Integer.toString(yogurt_d_db));
		yogurt_d.setHorizontalAlignment(JLabel.CENTER);
		yogurt_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(yogurt_d);

		//���Ʈ ����
		yogurt_m.setBounds(1078, 646, 320, 134);
		yogurt_m.setText(Integer.toString(yogurt_m_db));
		yogurt_m.setHorizontalAlignment(JLabel.CENTER);
		yogurt_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(yogurt_m);

		//���� �Ϻ�
		fruit_d.setBounds(762, 783, 312, 134);
		fruit_d.setText(Integer.toString(fruit_d_db));
		fruit_d.setHorizontalAlignment(JLabel.CENTER);
		fruit_d.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
		add(fruit_d);

		//���� ����
		fruit_m.setBounds(1078, 783, 320, 134);
		fruit_m.setText(Integer.toString(fruit_m_db));
		fruit_m.setHorizontalAlignment(JLabel.CENTER);
		fruit_m.setFont(new Font("������ũ��� L", Font.PLAIN, 45));
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
	
	//��ī�� �Ϻ�, ���� �����
	public static void macaron_db() {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT * FROM MENU_MACARON WHERE BNAME = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, SalesPanel.bname);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
            while (result = rset.next()) {
            	berry_d_db = rset.getInt("BERRY_D") * 2500;
        		berry_d.setText(Integer.toString(berry_d_db));
            	berry_m_db = rset.getInt("BERRY_M") * 2500;
        		berry_m.setText(Integer.toString(berry_m_db));
            	yogurt_d_db = rset.getInt("YOGURT_D") * 2500;
        		yogurt_d.setText(Integer.toString(yogurt_d_db));
            	yogurt_m_db = rset.getInt("YOGURT_M") * 2500;
        		yogurt_m.setText(Integer.toString(yogurt_m_db));
            	fruit_d_db = rset.getInt("FRUIT_D") * 2500;
        		fruit_d.setText(Integer.toString(fruit_d_db));
            	fruit_m_db = rset.getInt("FRUIT_M") * 2500;
        		fruit_m.setText(Integer.toString(fruit_m_db));
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