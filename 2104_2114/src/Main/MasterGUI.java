package Main;

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
import javax.swing.JPanel;

import Manager.Manager_List;

public class MasterGUI extends JFrame{
	public MasterGUI() {
	}
	public static void main(String args[]) {
		MasterPanel master_panel = new MasterPanel();
	}
}
class MasterPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_37.png");

	JButton master_exit_button = new JButton(icon);
	JLabel sname_label = new JLabel();
	JButton managerfix_button = new JButton(icon);
	JButton franchise_button = new JButton(icon);
	JButton mypage_button = new JButton(icon);

	MasterPanel() {
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//로그인 취소
		master_exit_button.setBounds(273, 781, 196, 80);
		master_exit_button.setVisible(true);
		master_exit_button.setBorderPainted(false);
		master_exit_button.setContentAreaFilled(false);
		master_exit_button.setFocusPainted(false);
		master_exit_button.setOpaque(false);
		master_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getLogin_panel().setVisible(true);
				Main.MainFrame.getMaster_panel().setVisible(false);
			}
		});
		add(master_exit_button);
		
		sname_label.setBounds(90, 203, 300, 80);
		sname_label.setText(getSname());
		sname_label.setHorizontalAlignment(JLabel.RIGHT);
		sname_label.setFont(new Font("인터파크고딕 M", Font.PLAIN, 40));
		add(sname_label);

		//지점장 관리 버튼
		managerfix_button.setBounds(908, 152, 780, 158);
		managerfix_button.setVisible(true);
		managerfix_button.setBorderPainted(false);
		managerfix_button.setContentAreaFilled(false);
		managerfix_button.setFocusPainted(false);
		managerfix_button.setOpaque(false);
		managerfix_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Main.MainFrame.getMaster_panel().setVisible(false);
//				Main.MainFrame.getManager_panel().setVisible(true);
				Main.MainFrame.manager_list_frame = new Manager_List();
			}
		});
		add(managerfix_button);

		//지점별 정보 버튼
		franchise_button.setBounds(908, 448, 780, 158);
		franchise_button.setVisible(true);
		franchise_button.setBorderPainted(false);
		franchise_button.setContentAreaFilled(false);
		franchise_button.setFocusPainted(false);
		franchise_button.setOpaque(false);
		franchise_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Main.MainFrame.getMaster_panel().setVisible(false);
				Main.MainFrame.getFranchise_panel().setVisible(true);				
			}
		});
		add(franchise_button);
		
		//정보 관리 버튼
		mypage_button.setBounds(908, 738, 780, 158);
		mypage_button.setVisible(true);
		mypage_button.setBorderPainted(false);
		mypage_button.setContentAreaFilled(false);
		mypage_button.setFocusPainted(false);
		mypage_button.setOpaque(false);
		mypage_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getMaster_panel().setVisible(false);
				//Main.MainFrame.getSMypage_panel().setVisible(true);
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
	public static String getSname() {
		String sname = "";
		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT S_NAME FROM MASTER_TABLE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			boolean result = true;
			
            while (result = rset.next()) {
            	sname = rset.getString("S_NAME");
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
		return sname;
	}
}