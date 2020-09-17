package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OrderGUI extends JFrame{
	public static void main(String args[]) {
		OrderPanel order_panel = new OrderPanel();
	}
}
class OrderPanel extends JPanel {
	// MainPanel에 올릴 컴포넌트들의 생성자 호출
	ImageIcon background = new ImageIcon("images/background_4.png"); // 배경사진은 class못만들어서 그냥 넣음
	
	OrderPanel() {
		OrderLabel order_label = new OrderLabel();
		order_label.setVisible(true);
		add(order_label);
		
		Menubar menu_box = new Menubar();
		menu_box.setVisible(true);
		add(menu_box);
		
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
class OrderLabel extends JLabel{
	OrderLabel(){
		setBounds(781, 0, 300, 120);
		setVisible(true);
		setText("주문하기");
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class Menubar extends JPanel{
	GotoOrderBtn order_button = new GotoOrderBtn();
	MenuExitButton menu_exit_button = new MenuExitButton();
	
	Menuinfo menu_1 = new Menuinfo();
	Menuinfo menu_2 = new Menuinfo();
	Menuinfo menu_3 = new Menuinfo();
	Menuinfo menu_4 = new Menuinfo();
	Menuinfo menu_5 = new Menuinfo();
	Menuinfo menu_6 = new Menuinfo();
	
	Menubar(){
		setBounds(100, 120, 1662, 825);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(112, 151, 168));
		
		add(menu_1);
		add(menu_2);
		add(menu_3);
		add(menu_4);
		add(menu_5);
		add(menu_6);
		
		add(order_button);
		add(menu_exit_button);
	}
}
class Menuinfo extends JPanel{
	static int menuCount = 0;
	String[] arr = {"아메리카노", "아이스티", "레몬에이드", "과일주스", "녹차", "마카롱"};
	
	Menuinfo(){
		setBounds(20*menuCount+254*menuCount+20, 30, 254, 430);
		setLayout(null);
		setVisible(true);
		Menutext menu_text = new Menutext(arr[menuCount]);
		MenuPlusBtn menu_plus_btn = new MenuPlusBtn();
		add(menu_text);
		add(menu_plus_btn);
		menuCount++;
	}
}
class Menutext extends JLabel{
	Menutext(String menu_name){
		setBounds(0, 380, 254, 50);
		setText(menu_name);
		setVisible(true);
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class MenuPlusBtn extends JButton{
	MenuPlusBtn(){
		setBounds(200, 380, 40, 40);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(112, 151, 168));
		setText("+");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게
	}
	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}
	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (getModel().isArmed()) {
			graphics.setColor(getBackground().darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(getBackground().brighter());
		} else {
			graphics.setColor(getBackground());
		}
		graphics.fillRoundRect(0, 0, width, height, 50, 50);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}
class GotoOrderBtn extends JButton{
	public GotoOrderBtn() {
		setBounds(950, 650, 300, 100);
		setForeground(Color.white);
		setBackground(new Color(112, 151, 168));
		setText("주문하기");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게
		
		addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getOrder_panel().setVisible(false);
				Main.MainFrame.getPayment_panel().setVisible(true);
				Payment.td2.start();
			}
		});
	}
	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}
	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (getModel().isArmed()) {
			graphics.setColor(getBackground().darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(getBackground().brighter());
		} else {
			graphics.setColor(getBackground());
		}
		graphics.fillRoundRect(0, 0, width, height, 50, 50);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}
class MenuExitButton extends JButton{
	public MenuExitButton() {
		setBounds(1300, 650, 300, 100);
		setForeground(Color.white);
		setBackground(new Color(112, 151, 168));
		setText("취소");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게
		
		addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getOrder_panel().setVisible(false);
				Main.MainFrame.getMain_panel().setVisible(true);
			}
		});
	}
	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}
	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (getModel().isArmed()) {
			graphics.setColor(getBackground().darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(getBackground().brighter());
		} else {
			graphics.setColor(getBackground());
		}
		graphics.fillRoundRect(0, 0, width, height, 50, 50);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}
class Payment extends JPanel{
	PaymentText payment_text = new PaymentText();
	static PaymentTextCount payment_text_count = new PaymentTextCount();
	
	static Timer2 t2 = new Timer2(payment_text_count);
	static Thread td2 = new Thread(t2);
	
	Payment(){
		setBounds(331, 170, 1200, 700);
		setLayout(null);
		setVisible(false);
		setBackground(new Color(112, 151, 168));
		setForeground(Color.white);
		
		add(payment_text);
		add(payment_text_count);
	}
}
class PaymentText extends JLabel{
	public PaymentText() {
		setBounds(50, 300, 750, 100);
		setVisible(true);
		setText("카드투입구에 카드를 넣어주세요");
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class PaymentTextCount extends JLabel{
	public PaymentTextCount() {
		setBounds(800, 290, 250, 120);
		setVisible(true);
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 120));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class Timer2 implements Runnable{
	private JLabel timerLabel;
	
	public Timer2(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() {
		int n = 30;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n--;
			try {
				Thread.sleep(1000); // 1/1000초 단위
			}catch(InterruptedException e) {
				return;
			}
			if(n == -1) {
				MainFrame.getPayment_panel().setVisible(false);
				MainFrame.getMain_panel().setVisible(true);
			}
			if(n <= 10) {
				Payment.payment_text_count.setForeground(Color.RED);
			}
		}
	}
}