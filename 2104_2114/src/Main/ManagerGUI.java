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
		
		bname_label.setBounds(90, 203, 300, 80);
		bname_label.setText(getBname());
		bname_label.setHorizontalAlignment(JLabel.RIGHT);
		bname_label.setFont(new Font("인터파크고딕 L", Font.PLAIN, 40));
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
				//Main.MainFrame.getStock_panel().setVisible(true);
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
				//Main.MainFrame.getMypage_panel().setVisible(true);
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
<<<<<<< HEAD
	public String getBname() {
=======
	public static String getBname() {
>>>>>>> master
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