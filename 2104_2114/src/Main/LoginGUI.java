package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginGUI extends JFrame{
	public LoginGUI() {
	}
	public static void main(String args[]) {
		LoginPanel login_panel = new LoginPanel();
	}
}

class LoginPanel extends JPanel{
	ImageIcon background = new ImageIcon("images/background_4.png");
	
	LoginPanel(){
		LoginLabel login_label = new LoginLabel();
		login_label.setVisible(true);
		add(login_label);
		
		Loginarea login_area = new Loginarea();
		login_area.setVisible(true);
		add(login_area);
		
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
class LoginLabel extends JLabel{
	LoginLabel(){
		setBounds(781, 0, 300, 120);
		setVisible(true);
		setText("로그인");
		setForeground(new Color(0, 0, 0));
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class Loginarea extends JPanel{
	static GotoLoginBtn login_button = new GotoLoginBtn();
	LoginExitButton login_exit_button = new LoginExitButton();
	ManagerAuthority manager_authority = new ManagerAuthority();
	MasterAuthority master_authority = new MasterAuthority();
	FillIn fill_in = new FillIn();

	static Manager_GotoLoginBtn g_login_button = new Manager_GotoLoginBtn();
	static Master_GotoLoginBtn s_login_button = new Master_GotoLoginBtn();
	
	Loginarea(){
		setBounds(100, 120, 1662, 825);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(112, 151, 168));
		
		add(login_button);
		add(login_exit_button);
		add(manager_authority);
		add(master_authority);
		add(fill_in);

		add(g_login_button);
		add(s_login_button);
	}
	public static GotoLoginBtn getLogin_button() {
		return login_button;
	}
	public static Manager_GotoLoginBtn getG_login_button() {
		return g_login_button;
	}
	public static Master_GotoLoginBtn getS_login_button() {
		return s_login_button;
	}
}
class ManagerAuthority extends JButton{
	public ManagerAuthority() {
		setBounds(560, 50, 250, 100);
		setForeground(Color.black);
		setBackground(Color.WHITE);
		setText("지점장");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게
		
		addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Main.FillIn.getG_id_field().setText("");
				Main.FillIn.getG_pw_field().setText("");				
				
				Main.FillIn.getG_id_field().setVisible(true);
				Main.FillIn.getG_pw_field().setVisible(true);
				
				Main.FillIn.getS_id_field().setVisible(false);
				Main.FillIn.getS_pw_field().setVisible(false);
				
				Main.FillIn.getId_field().setVisible(false);
				Main.FillIn.getPw_field().setVisible(false);
				
				Main.Loginarea.getLogin_button().setVisible(false);
				Main.Loginarea.getG_login_button().setVisible(true);
				Main.Loginarea.getS_login_button().setVisible(false);
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
class MasterAuthority extends JButton{
	public MasterAuthority() {
		setBounds(851, 50, 250, 100);
		setForeground(Color.black);
		setBackground(Color.WHITE);
		setText("관리자");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게
		
		addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Main.FillIn.getS_id_field().setText("");
				Main.FillIn.getS_pw_field().setText("");	
				
				Main.FillIn.getG_id_field().setVisible(false);
				Main.FillIn.getG_pw_field().setVisible(false);
				
				Main.FillIn.getS_id_field().setVisible(true);
				Main.FillIn.getS_pw_field().setVisible(true);
				
				Main.FillIn.getId_field().setVisible(false);
				Main.FillIn.getPw_field().setVisible(false);
				
				Main.Loginarea.getLogin_button().setVisible(false);
				Main.Loginarea.getG_login_button().setVisible(false);
				Main.Loginarea.getS_login_button().setVisible(true);
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
class FillIn extends JPanel{
	IdLabel id_label = new IdLabel();
	PwLabel pw_label = new PwLabel();
	static IdField id_field = new IdField();
	static PwField pw_field = new PwField();

	static Manager_IdField g_id_field = new Manager_IdField();
	static Manager_PwField g_pw_field = new Manager_PwField();
	
	static Master_IdField s_id_field = new Master_IdField();
	static Master_PwField s_pw_field = new Master_PwField();
	
	FillIn(){
		setBounds(0, 200, 1662, 500);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(112, 151, 168));
		
		add(id_label);
		add(pw_label);
		add(id_field);
		add(pw_field);

		add(g_id_field);
		add(g_pw_field);
		add(s_id_field);
		add(s_pw_field);
	}
	public static IdField getId_field() {
		return id_field;
	}
	public static PwField getPw_field() {
		return pw_field;
	}
	public static Manager_IdField getG_id_field() {
		return g_id_field;
	}
	public static Manager_PwField getG_pw_field() {
		return g_pw_field;
	}
	public static Master_IdField getS_id_field() {
		return s_id_field;
	}
	public static Master_PwField getS_pw_field() {
		return s_pw_field;
	}
}
class IdLabel extends JLabel{
	public IdLabel(){
		setBounds(350, 70, 200, 120);
		setVisible(true);
		setText("아이디");
		setForeground(new Color(255, 255, 255));
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class PwLabel extends JLabel{
	public PwLabel(){
		setBounds(350, 250, 200, 120);
		setVisible(true);
		setText("비밀번호");
		setForeground(new Color(255, 255, 255));
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
class IdField extends JTextField{
	public IdField(){
		setBounds(600, 70, 600, 120);
		setVisible(true);
		setForeground(new Color(0, 0, 0));
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
	}
}
class PwField extends JPasswordField{
	public PwField(){
		setBounds(600, 250, 600, 120);
		setVisible(true);
		setForeground(new Color(0, 0, 0));
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
	}
}
class Manager_IdField extends JTextField{
	public Manager_IdField(){
		setBounds(600, 70, 600, 120);
		setVisible(false);
		setForeground(Color.RED);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
	}
}
class Manager_PwField extends JPasswordField{
	public Manager_PwField(){
		setBounds(600, 250, 600, 120);
		setVisible(false);
		setForeground(Color.RED);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
	}
}
class Master_IdField extends JTextField{
	public Master_IdField(){
		setBounds(600, 70, 600, 120);
		setVisible(false);
		setForeground(Color.BLUE);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
	}
}
class Master_PwField extends JPasswordField{
	public Master_PwField(){
		setBounds(600, 250, 600, 120);
		setVisible(false);
		setForeground(Color.BLUE);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
	}
}
class GotoLoginBtn extends JButton{
	public GotoLoginBtn() {
		setBounds(601, 700, 200, 80);
		setForeground(Color.black);
		setBackground(Color.WHITE);
		setText("로그인");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게
		
		addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "지점장, 관리자 중 하나를 선택해주십시오.", "Authority Error", JOptionPane.ERROR_MESSAGE);
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
class Manager_GotoLoginBtn extends JButton{
	public Manager_GotoLoginBtn() {
		setBounds(601, 700, 200, 80);
		setForeground(Color.RED);
		setBackground(Color.WHITE);
		setText("로그인");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		setVisible(false);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게
		
		addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new ManagerLogin();
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
class Master_GotoLoginBtn extends JButton{
	public Master_GotoLoginBtn() {
		setBounds(601, 700, 200, 80);
		setForeground(Color.BLUE);
		setBackground(Color.WHITE);
		setText("로그인");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		setVisible(false);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게
		
		addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new MasterLogin();
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
class LoginExitButton extends JButton{
	public LoginExitButton() {
		setBounds(861, 700, 200, 80);
		setForeground(Color.black);
		setBackground(Color.WHITE);
		setText("취소");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 30));
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게
		
		addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Main.FillIn.getId_field().setText("");
				Main.FillIn.getPw_field().setText("");	
				Main.FillIn.getG_id_field().setText("");
				Main.FillIn.getG_pw_field().setText("");	
				Main.FillIn.getS_id_field().setText("");
				Main.FillIn.getS_pw_field().setText("");						

				Main.FillIn.getG_id_field().setVisible(false);
				Main.FillIn.getG_pw_field().setVisible(false);
				
				Main.FillIn.getS_id_field().setVisible(false);
				Main.FillIn.getS_pw_field().setVisible(false);
				
				Main.FillIn.getId_field().setVisible(true);
				Main.FillIn.getPw_field().setVisible(true);
				
				Main.Loginarea.getLogin_button().setVisible(true);
				Main.Loginarea.getG_login_button().setVisible(false);
				Main.Loginarea.getS_login_button().setVisible(false);
				
				Main.MainFrame.getMain_panel().setVisible(true);
				Main.MainFrame.getLogin_panel().setVisible(false);
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