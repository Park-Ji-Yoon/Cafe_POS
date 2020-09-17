package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FranchiseGUI {
	public static void main(String[] args) {
	
	}
}
class FranchisePanel extends JPanel{
	ImageIcon background = new ImageIcon("images/background_4.png");
	
	static String[] header = {"메뉴", "매출액(단위:원)"};
	static String[][] menu = {{"아메리카노", ""}, {"아이스티", ""}, {"레몬에이드", ""}, {"과일주스", ""}, {"녹차", ""}, {"마카롱", ""}};

	static JTable daily_sales_list = new JTable(menu, header);
	static JTable monthly_sales_list = new JTable(menu, header);
	
	public FranchisePanel() {
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);
		setLayout(null);
		
		FranchiseLabel franchise_label = new FranchiseLabel();
		add(franchise_label);
		
		SalesLabel sales_label = new SalesLabel();
		add(sales_label);
		
		Daily daily_btn = new Daily();
		add(daily_btn);
		
		Monthly monthly_btn = new Monthly();
		add(monthly_btn);
		
		add(daily_sales_list);
		daily_sales_list.setBounds(56, 330, 850, 620);
		daily_sales_list.setVisible(true);
		daily_sales_list.setFont(new Font("서울남산 장체 B", Font.PLAIN, 40));
		daily_sales_list.setRowHeight(80);
		
		add(monthly_sales_list);
		monthly_sales_list.setBounds(56, 330, 850, 620);
		monthly_sales_list.setVisible(true);
		monthly_sales_list.setFont(new Font("서울남산 장체 B", Font.PLAIN, 40));
		monthly_sales_list.setRowHeight(80);
		monthly_sales_list.setForeground(Color.BLUE);
		
		NoeLabel noe_label = new NoeLabel();
		add(noe_label);
		
		NoePanel noe_panel = new NoePanel();
		add(noe_panel);
		
		BrunchManagerLabel brmanager_label = new BrunchManagerLabel();
		add(brmanager_label);
		
		BRMPanel brm_panel = new BRMPanel();
		add(brm_panel);
		
		GoToBack gotoback_btn = new GoToBack();
		add(gotoback_btn);
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	public static JTable getDaily_sales_list() {
		return daily_sales_list;
	}
	public static JTable getMonthly_sales_list() {
		return monthly_sales_list;
	}
}
class FranchiseLabel extends JLabel {
	FranchiseLabel() {
		setBounds(781, 0, 300, 120);
		setVisible(true);
		setText("XXXX점");
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class SalesLabel extends JLabel {
	SalesLabel() {
		setBounds(381, 150, 200, 50);
		setVisible(true);
		setText("매출액");
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class Daily extends JButton{
	Daily(){
		setBounds(361, 230, 120, 65);
		setText("일별");
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(112, 151, 168));
		setVisible(true);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		
		addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Main.FranchisePanel.getDaily_sales_list().setVisible(true);
				Main.FranchisePanel.getMonthly_sales_list().setVisible(false);
			}
		});
	}
}
class Monthly extends JButton{
	Monthly(){
		setBounds(481, 230, 120, 65);
		setText("월별");
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(112, 151, 168));
		setVisible(true);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		
		addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Main.FranchisePanel.getDaily_sales_list().setVisible(false);
				Main.FranchisePanel.getMonthly_sales_list().setVisible(true);
			}
		});
	}
}
class NoeLabel extends JLabel{
	NoeLabel() {
		setBounds(1262, 170, 300, 50);
		setVisible(true);
		setText("직원 수");
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class NoePanel extends JPanel{
	ImageIcon background = new ImageIcon("images/background_4.png");
	
	NoePanel(){
		setBounds(1262, 250, 300, 120);
		setVisible(true);
		setBackground(null);
		setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY, 3), ""));
		setLayout(null);
		
		NumberOfEmployee numberofemployee = new NumberOfEmployee();
		add(numberofemployee);
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
class NumberOfEmployee extends JLabel{
	NumberOfEmployee(){
		setVisible(true);
		setText("XX명");
		setBounds(0, 0, 300, 120);
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class BrunchManagerLabel extends JLabel{
	BrunchManagerLabel() {
		setBounds(1262, 440, 300, 50);
		setVisible(true);
		setText("지점장");
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class BRMPanel extends JPanel{
	ImageIcon background = new ImageIcon("images/background_4.png");
	
	BRMPanel(){
		setBounds(1062, 500, 700, 450);
		setVisible(true);
		setBackground(null);
		setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY, 3), ""));
		setLayout(null);
		
		BranchManager_N brunch_manager_n = new BranchManager_N();
		add(brunch_manager_n);
		
		BranchManager_ID brunch_manager_id = new BranchManager_ID();
		add(brunch_manager_id);
		
		BranchManager_PW brunch_manager_pw = new BranchManager_PW();
		add(brunch_manager_pw);
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
class BranchManager_N extends JLabel{
	BranchManager_N(){
		setVisible(true);
		setText("이름 : " + "박뒤휸");
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));
		setHorizontalAlignment(JLabel.CENTER);
		setBounds(10, 70, 690, 100);
	}
}
class BranchManager_ID extends JLabel{
	BranchManager_ID(){
		setVisible(true);
		setText("아이디 : " + "purun0515");
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));
		setHorizontalAlignment(JLabel.CENTER);
		setBounds(10, 170, 690, 100);
	}
}
class BranchManager_PW extends JLabel{
	BranchManager_PW(){
		setVisible(true);
		setText("비밀번호 : " + "password");
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));
		setHorizontalAlignment(JLabel.CENTER);
		setBounds(10, 270, 690, 100);
	}
}
class GoToBack extends JButton{
	GoToBack(){
		setBounds(20, 20, 170, 60);
		setText("뒤로가기");
		setVisible(true);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 25));
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(112, 151, 168));
		
		addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getFranchise_panel().setVisible(false);
				Main.MainFrame.getMaster_panel().setVisible(true);
			}
		});
	}
}