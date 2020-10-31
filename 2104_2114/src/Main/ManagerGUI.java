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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ManagerGUI extends JFrame{
	public ManagerGUI() {
	}
	public static void main(String args[]) {
		ManagerPanel manager_panel = new ManagerPanel();
	}
}
class ManagerPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_19.png");

	JButton manager_exit_button = new JButton(icon);
	JLabel bname_label = new JLabel();
	JButton sales_button = new JButton(icon);
	JButton stock_button = new JButton(icon);
	JButton employee_button = new JButton(icon);
	JButton mypage_button = new JButton(icon);

	ManagerPanel() {
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//로그인 취소
		manager_exit_button.setBounds(273, 781, 196, 80);
		manager_exit_button.setVisible(true);
		manager_exit_button.setBorderPainted(false);
		manager_exit_button.setContentAreaFilled(false);
		manager_exit_button.setFocusPainted(false);
		manager_exit_button.setOpaque(false);
		manager_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getLogin_panel().setVisible(true);
				Main.MainFrame.getManager_panel().setVisible(false);
			}
		});
		add(manager_exit_button);
		
		bname_label.setBounds(20, 203, 370, 80);
		bname_label.setText(getBname());
		bname_label.setHorizontalAlignment(JLabel.RIGHT);
		bname_label.setFont(new Font("인터파크고딕 M", Font.PLAIN, 40));
		add(bname_label);

		//매출 관리 버튼
		sales_button.setBounds(908, 98, 780, 158);
		sales_button.setVisible(true);
		sales_button.setBorderPainted(false);
		sales_button.setContentAreaFilled(false);
		sales_button.setFocusPainted(false);
		sales_button.setOpaque(false);
		sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getSales_panel().setVisible(true);
				Main.MainFrame.getManager_panel().setVisible(false);
			}
		});
		add(sales_button);

		//재고 관리 버튼
		stock_button.setBounds(908, 329, 780, 158);
		stock_button.setVisible(true);
		stock_button.setBorderPainted(false);
		stock_button.setContentAreaFilled(false);
		stock_button.setFocusPainted(false);
		stock_button.setOpaque(false);
		stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getStock_panel().setVisible(true);
				Main.MainFrame.getManager_panel().setVisible(false);
			}
		});
		add(stock_button);

		//직원 관리 버튼
		employee_button.setBounds(908, 560, 780, 158);
		employee_button.setVisible(true);
		employee_button.setBorderPainted(false);
		employee_button.setContentAreaFilled(false);
		employee_button.setFocusPainted(false);
		employee_button.setOpaque(false);
		employee_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getEmployee_panel().setVisible(true);
				Main.MainFrame.getManager_panel().setVisible(false);				
			}
		});
		add(employee_button);
		
		//정보 관리 버튼
		mypage_button.setBounds(908, 791, 780, 158);
		mypage_button.setVisible(true);
		mypage_button.setBorderPainted(false);
		mypage_button.setContentAreaFilled(false);
		mypage_button.setFocusPainted(false);
		mypage_button.setOpaque(false);
		mypage_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_info_panel().setVisible(true);
				Main.MainFrame.getManager_panel().setVisible(false);
			}
		});
		add(mypage_button);		
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
	public static String getBname() {
		String bname = "";
		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT G_BNAME FROM MANAGER_TABLE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
            while (result = rset.next()) {
                bname = rset.getString("G_BNAME");
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
		return bname;
	}
}
class ManagerInfo extends JPanel{
	ImageIcon background = new ImageIcon("images/manager1.png");
	GoBackBtn2 go_back_btn2 = new GoBackBtn2();
	
	static ManagerNameLabel manager_name_label = new ManagerNameLabel();
	static ManagerIdLabel manager_id_label = new ManagerIdLabel();
	static ManagerPwLabel manager_pw_label = new ManagerPwLabel();
	static ManagerBNameLabel manager_bname_label = new ManagerBNameLabel();
	static ManagerBPhoneLabel manager_bphone_label = new ManagerBPhoneLabel();
	static ManagerEmLabel manager_em_label = new ManagerEmLabel();
	
	ManagerInfo() {
		setBounds(0, 0, 1862, 1055);
		setLayout(null);
		setVisible(true);
		
		add(go_back_btn2);
		
		add(manager_name_label);
		add(manager_id_label);
		add(manager_pw_label);
		add(manager_bname_label);
		add(manager_bphone_label);
		add(manager_em_label);
	}
	
	public static ManagerNameLabel getManager_name_label() {
		return manager_name_label;
	}

	public static ManagerIdLabel getManager_id_label() {
		return manager_id_label;
	}

	public static ManagerPwLabel getManager_pw_label() {
		return manager_pw_label;
	}

	public static ManagerBNameLabel getManager_bname_label() {
		return manager_bname_label;
	}

	public static ManagerBPhoneLabel getManager_bphone_label() {
		return manager_bphone_label;
	}

	public static ManagerEmLabel getManager_em_label() {
		return manager_em_label;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
class GoBackBtn2 extends JButton{
	GoBackBtn2() {
		setBounds(20, 20, 200, 70);
		setVisible(true);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Main.MainFrame.getManager_info_panel().setVisible(false);
				Main.MainFrame.getManager_panel().setVisible(true);				
			}
		});
	}
}
class ManagerNameLabel extends JLabel{
	ManagerNameLabel() {
		setBounds(950, 245, 400, 50);
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 36));
	}
}
class ManagerIdLabel extends JLabel{
	ManagerIdLabel() {
		setBounds(950, 367, 400, 50);
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 36));
	}
}
class ManagerPwLabel extends JLabel{
	ManagerPwLabel() {
		setBounds(950, 480, 400, 50);
		setText("123456789");
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 36));
	}
}
class ManagerBNameLabel extends JLabel{
	ManagerBNameLabel() {
		setBounds(950, 590, 400, 50);
		setText("울산현대백화점점");
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 36));
	}
}
class ManagerBPhoneLabel extends JLabel{
	ManagerBPhoneLabel() {
		setBounds(950, 713, 400, 50);
		setText("010-5135-4735");
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 36));
	}
}
class ManagerEmLabel extends JLabel{
	ManagerEmLabel() {
		setBounds(950, 825, 400, 50);
		setText("박지윤유낭명");
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 36));
	}
}