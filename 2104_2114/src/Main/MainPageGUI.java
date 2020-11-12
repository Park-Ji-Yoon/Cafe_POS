package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.*;

import Manager.Manager_List;
import javazoom.jl.player.Player;

public class MainPageGUI extends JFrame {
	public static MainFrame main_frame;
	public static Music introMusic; // ������� �ʱ�ȭ

	// main �޼���
	public static void main(String[] args) {
		main_frame = new MainFrame();
		introMusic = new Music("bgm_president.mp3", true);  // introMusic �ݺ�����ǵ��� ����
	    introMusic.start(); // introMusic ���� ����
	}
	
	// main_frame�� getter
	public static MainFrame getMain_frame() {
		return main_frame;
	}
}

// MainFrameŬ���� (JFrame�� ��ӹ���)
class MainFrame extends JFrame {
	
	// main_frame�� �ø� �гε��� ����
	static MainPanel main_panel; // ���� �г�
	static OrderPanel order_panel; // �ֹ��ϱ� �г�
	static Payment payment_panel; // ���� �г�
	static LoginPanel login_panel; // �α��� ���� ȭ�� �г�
	static GLoginPanel glogin_panel; // ������ �α��� ȭ�� �г�
	static SLoginPanel slogin_panel; // ������ �α��� ȭ�� �г�
	static ManagerPanel manager_panel; // �Ŵ��� Ȩ ȭ�� �г�
	static SalesPanel sales_panel; // ����� Ȯ�� �г�
	static StockPanel stock_panel; // ��� Ȯ�� �г�
	static GCoffeeSalesPanel gcoffee_sales_panel;
	static GSmoothieSalesPanel gsmoothie_sales_panel;
	static GTeaSalesPanel gtea_sales_panel;
	static GBubbleSalesPanel gbubble_sales_panel;
	static GCakeSalesPanel gcake_sales_panel;
	static GMacaronSalesPanel gmacaron_sales_panel;
	static GCoffeeStockPanel gcoffee_stock_panel;
	static GSmoothieStockPanel gsmoothie_stock_panel;
	static GTeaStockPanel gtea_stock_panel;
	static GBubbleStockPanel gbubble_stock_panel;
	static GCakeStockPanel gcake_stock_panel;
	static GMacaronStockPanel gmacaron_stock_panel;
	static EmployeePanel employee_panel;
	static MasterPanel master_panel;
	static SCoffeeSalesPanel scoffee_sales_panel;
	static SSmoothieSalesPanel ssmoothie_sales_panel;
	static STeaSalesPanel stea_sales_panel;
	static SBubbleSalesPanel sbubble_sales_panel;
	static SCakeSalesPanel scake_sales_panel;
	static SMacaronSalesPanel smacaron_sales_panel;
	static FranchisePanel franchise_panel;
	static PaySuccessPanel pay_success_panel;
	static ChoiceArea choice_area_panel;
	static ChoiceStore choice_store_panel;
	static ChoiceAreaMaster master_choice_area_panel;
	static ChoiceStoreMaster master_choice_store_panel;
	static Manager_List manager_list_frame;
	static MasterInfo master_info_panel; // ������ ���� �г�
	static ManagerInfo manager_info_panel; // ������ ���� �г�
	
	static CoffeeInfoPanel coffee_info_panel; // Ŀ�� �������� �г�
	static SmooInfoPanel smoo_info_panel; // ������ �������� �г�
	static TeaInfoPanel tea_info_panel; // �� �������� �г�
	static BubbleInfoPanel bubble_info_panel; // ����Ƽ �������� �г�
	static CakeInfoPanel cake_info_panel; // ����ũ �������� �г�
	static MacaronInfoPanel macaron_info_panel; // ��ī�� �������� �г�

	// MainFrame ������
	public MainFrame() {
		// Ŀ�� �����ϴ� �ڵ�
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image cursorimage=tk.getImage("images/cursor_2.png"); // �������� Ŀ�� ����
		Point point=new Point(20,20);
		Cursor cursor=tk.createCustomCursor(cursorimage, point, "haha");
		
		// Ŀ�� ����
		setCursor(cursor);
		
		// panel�� �ʱ�ȭ
		main_panel = new MainPanel();
		main_panel.setVisible(true);

		order_panel = new OrderPanel();
		order_panel.setVisible(false);

		payment_panel = new Payment();
		payment_panel.setVisible(false);

		login_panel = new LoginPanel();
		login_panel.setVisible(false);

		glogin_panel = new GLoginPanel();
		glogin_panel.setVisible(false);

		slogin_panel = new SLoginPanel();
		slogin_panel.setVisible(false);
		
		manager_panel = new ManagerPanel();
		manager_panel.setVisible(false);
		
		gcoffee_sales_panel = new GCoffeeSalesPanel();
		gcoffee_sales_panel.setVisible(false);

		gsmoothie_sales_panel = new GSmoothieSalesPanel();
		gsmoothie_sales_panel.setVisible(false);

		gtea_sales_panel = new GTeaSalesPanel();
		gtea_sales_panel.setVisible(false);

		gbubble_sales_panel = new GBubbleSalesPanel();
		gbubble_sales_panel.setVisible(false);

		gcake_sales_panel = new GCakeSalesPanel();
		gcake_sales_panel.setVisible(false);

		gmacaron_sales_panel = new GMacaronSalesPanel();
		gmacaron_sales_panel.setVisible(false);
		
		gcoffee_stock_panel = new GCoffeeStockPanel();
		gcoffee_stock_panel.setVisible(false);

		gsmoothie_stock_panel = new GSmoothieStockPanel();
		gsmoothie_stock_panel.setVisible(false);

		gtea_stock_panel = new GTeaStockPanel();
		gtea_stock_panel.setVisible(false);

		gbubble_stock_panel = new GBubbleStockPanel();
		gbubble_stock_panel.setVisible(false);

		gcake_stock_panel = new GCakeStockPanel();
		gcake_stock_panel.setVisible(false);

		gmacaron_stock_panel = new GMacaronStockPanel();
		gmacaron_stock_panel.setVisible(false);
		
		master_panel = new MasterPanel();
		master_panel.setVisible(false);
		
		sales_panel = new SalesPanel();
		sales_panel.setVisible(false);
		
		stock_panel = new StockPanel();
		stock_panel.setVisible(false);
		
		scoffee_sales_panel = new SCoffeeSalesPanel();
		scoffee_sales_panel.setVisible(false);

		ssmoothie_sales_panel = new SSmoothieSalesPanel();
		ssmoothie_sales_panel.setVisible(false);

		stea_sales_panel = new STeaSalesPanel();
		stea_sales_panel.setVisible(false);

		sbubble_sales_panel = new SBubbleSalesPanel();
		sbubble_sales_panel.setVisible(false);

		scake_sales_panel = new SCakeSalesPanel();
		scake_sales_panel.setVisible(false);

		smacaron_sales_panel = new SMacaronSalesPanel();
		smacaron_sales_panel.setVisible(false);
		
		employee_panel = new EmployeePanel();
		employee_panel.setVisible(false);
		
		franchise_panel = new FranchisePanel();
		franchise_panel.setVisible(false);
		
		pay_success_panel = new PaySuccessPanel();
		pay_success_panel.setVisible(false);
		
		choice_area_panel = new ChoiceArea();
		choice_area_panel.setVisible(false);
		
		choice_store_panel = new ChoiceStore();
		choice_store_panel.setVisible(false);
		
		master_choice_area_panel = new ChoiceAreaMaster();
		master_choice_area_panel.setVisible(false);
		
		master_choice_store_panel = new ChoiceStoreMaster();
		master_choice_store_panel.setVisible(false);
		
		master_info_panel = new MasterInfo();
		master_info_panel.setVisible(false);
		
		manager_info_panel = new ManagerInfo();
		manager_info_panel.setVisible(false);
		
		coffee_info_panel = new CoffeeInfoPanel();
		coffee_info_panel.setVisible(false);
		
		smoo_info_panel = new SmooInfoPanel();
		smoo_info_panel.setVisible(false);
		
		tea_info_panel = new TeaInfoPanel();
		smoo_info_panel.setVisible(false);
		
		bubble_info_panel = new BubbleInfoPanel();
		bubble_info_panel.setVisible(false);
		
		cake_info_panel = new CakeInfoPanel();
		cake_info_panel.setVisible(false);
		
		macaron_info_panel = new MacaronInfoPanel();
		macaron_info_panel.setVisible(false);

		// MainFrame �Ӽ� ����
		setTitle("���� ���̼�"); // JFrame ���� �� Ÿ��Ʋ ����
		setBounds(20, 0, 1880, 1070); // JFrame ��ġ�� ũ�� (x, y, w, h)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x������ ����
		setResizable(false);
		getContentPane().setLayout(null); // ������ ���̾ƿ� null�� ����
		setVisible(true);
		
		// ���� main_panel�� �߰���
		getContentPane().add(main_panel); 

		// main_panel ���� ��� �гε��� �߰�
		add(main_panel);
		add(order_panel);
		add(payment_panel);
		add(login_panel);
		add(glogin_panel);
		add(slogin_panel);
		add(manager_panel);
		add(sales_panel);
		add(stock_panel);
		add(gcoffee_sales_panel);
		add(gsmoothie_sales_panel);
		add(gtea_sales_panel);
		add(gbubble_sales_panel);
		add(gcake_sales_panel);
		add(gmacaron_sales_panel);
		add(gcoffee_stock_panel);
		add(gsmoothie_stock_panel);
		add(gtea_stock_panel);
		add(gbubble_stock_panel);
		add(gcake_stock_panel);
		add(gmacaron_stock_panel);
		add(employee_panel);
		add(master_panel);
		add(scoffee_sales_panel);
		add(ssmoothie_sales_panel);
		add(stea_sales_panel);
		add(sbubble_sales_panel);
		add(scake_sales_panel);
		add(smacaron_sales_panel);
		add(franchise_panel);
		add(pay_success_panel);
		add(choice_area_panel);
		add(choice_store_panel);
		add(master_choice_area_panel);
		add(master_choice_store_panel);
		add(master_info_panel);
		add(manager_info_panel);
		
		add(coffee_info_panel);
		add(smoo_info_panel);
		add(tea_info_panel);
		add(bubble_info_panel);
		add(cake_info_panel);
		add(macaron_info_panel);

		// ������ �� �� ������
		ImageIcon icon = new ImageIcon("images/logo_20.png");
		setIconImage(icon.getImage());	
	}
	
	// �ٸ� Ŭ�����鿡�� setVisible()�� �����ϱ� ���� getter �޼���
	public static MainPanel getMain_panel() {
		return main_panel;
	}
	public static OrderPanel getOrder_panel() {
		return order_panel;
	}
	public static Payment getPayment_panel() {
		return payment_panel;
	}
	public static LoginPanel getLogin_panel() {
		return login_panel;
	}
	public static GLoginPanel getGLogin_panel() {
		return glogin_panel;
	}
	public static SLoginPanel getSLogin_panel() {
		return slogin_panel;
	}
	public static ManagerPanel getManager_panel() {
		return manager_panel;
	}
	public static SalesPanel getSales_panel() {
		return sales_panel;
	}
	public static StockPanel getStock_panel() {
		return stock_panel;
	}
	public static GCoffeeSalesPanel getGCoffee_sales_panel() {
		return gcoffee_sales_panel;
	}
	public static GSmoothieSalesPanel getGSmoothie_sales_panel() {
		return gsmoothie_sales_panel;
	}
	public static GTeaSalesPanel getGTea_sales_panel() {
		return gtea_sales_panel;
	}
	public static GBubbleSalesPanel getGBubble_sales_panel() {
		return gbubble_sales_panel;
	}
	public static GCakeSalesPanel getGCake_sales_panel() {
		return gcake_sales_panel;
	}
	public static GMacaronSalesPanel getGMacaron_sales_panel() {
		return gmacaron_sales_panel;
	}
	public static GCoffeeStockPanel getGCoffee_stock_panel() {
		return gcoffee_stock_panel;
	}
	public static GSmoothieStockPanel getGSmoothie_stock_panel() {
		return gsmoothie_stock_panel;
	}
	public static GTeaStockPanel getGTea_stock_panel() {
		return gtea_stock_panel;
	}
	public static GBubbleStockPanel getGBubble_stock_panel() {
		return gbubble_stock_panel;
	}
	public static GCakeStockPanel getGCake_stock_panel() {
		return gcake_stock_panel;
	}
	public static GMacaronStockPanel getGMacaron_stock_panel() {
		return gmacaron_stock_panel;
	}
	public static EmployeePanel getEmployee_panel() {
		return employee_panel;
	}	
	public static MasterPanel getMaster_panel() {
		return master_panel;
	}
	public static SCoffeeSalesPanel getSCoffee_sales_panel() {
		return scoffee_sales_panel;
	}
	public static SSmoothieSalesPanel getSSmoothie_sales_panel() {
		return ssmoothie_sales_panel;
	}
	public static STeaSalesPanel getSTea_sales_panel() {
		return stea_sales_panel;
	}
	public static SBubbleSalesPanel getSBubble_sales_panel() {
		return sbubble_sales_panel;
	}
	public static SCakeSalesPanel getSCake_sales_panel() {
		return scake_sales_panel;
	}
	public static SMacaronSalesPanel getSMacaron_sales_panel() {
		return smacaron_sales_panel;
	}
	public static FranchisePanel getFranchise_panel() {
		return franchise_panel;
	}
	public static PaySuccessPanel getPay_success_panel() {
		return pay_success_panel;
	}
	public static ChoiceArea getChoice_area_panel() {
		return choice_area_panel;
	}
	public static ChoiceStore getChoice_store_panel() {
		return choice_store_panel;
	}
	public static ChoiceAreaMaster getChoice_area_master_panel() {
		return master_choice_area_panel;
	}
	public static ChoiceStoreMaster getChoice_store_master_panel() {
		return master_choice_store_panel;
	}
	public static MasterInfo getMaster_info_panel() {
		return master_info_panel;
	}
	public static ManagerInfo getManager_info_panel() {
		return manager_info_panel;
	}
	
	public static CoffeeInfoPanel getCoffee_info_panel() {
		return coffee_info_panel;
	}
	public static SmooInfoPanel getSmoo_info_panel() {
		return smoo_info_panel;
	}
	public static TeaInfoPanel getTea_info_panel() {
		return tea_info_panel;
	}
	public static BubbleInfoPanel getBubble_info_panel() {
		return bubble_info_panel;
	}
	public static CakeInfoPanel getCake_info_panel() {
		return cake_info_panel;
	}
	public static MacaronInfoPanel getMacaron_info_panel() {
		return macaron_info_panel;
	}
}

// MainPanel�г� Ŭ���� ����
class MainPanel extends JPanel {
	static Icon icon = new ImageIcon("images/back_1.png");
	
	// MainPanel�� �ø� ������Ʈ���� ������ ȣ��
	ImageIcon background = new ImageIcon("images/background_8.png"); // �������� class������ �׳� ����
	static JButton order_btn = new JButton(icon); // '�ֹ��ϱ�' ��ư ������ ȣ��
	static JButton login_btn = new JButton(icon); // '�α���' ��ư ������ ȣ��

	// MainPanel ������
	MainPanel() {
		setBounds(0, 0, 1862, 1055); // ��ġ�� ũ�� ����
		setLayout(null);
		
		order_btn.setBounds(1250, 650, 550, 120);
		order_btn.setVisible(true);
		order_btn.setBorderPainted(false);
		order_btn.setContentAreaFilled(false);
		order_btn.setFocusPainted(false);
		order_btn.setOpaque(false);
		order_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Main.MainFrame.getMain_panel().setVisible(false);
					Main.MainFrame.getChoice_area_panel().setVisible(true);
					
					// Ŀ��
					PaySuccessDetail.ice_coffee_pay.setVisible(false);
					PaySuccessDetail.hot_coffee_pay.setVisible(false);
					
					// ������
					PaySuccessDetail.orange_smoo_pay.setVisible(false);
					PaySuccessDetail.kiwi_smoo_pay.setVisible(false);
					PaySuccessDetail.grape_smoo_pay.setVisible(false);
					PaySuccessDetail.strawberry_smoo_pay.setVisible(false);
					PaySuccessDetail.watermelon_smoo_pay.setVisible(false);
					
					// ��
					PaySuccessDetail.black_tea_pay.setVisible(false);
					PaySuccessDetail.green_tea_pay.setVisible(false);
					
					// ����Ƽ
					PaySuccessDetail.brown_bubble_pay.setVisible(false);
					PaySuccessDetail.taro_bubble_pay.setVisible(false);
					PaySuccessDetail.green_bubble_pay.setVisible(false);
					
					// ����ũ
					PaySuccessDetail.cheese_cake_pay.setVisible(false);
					PaySuccessDetail.strawberry_cake_pay.setVisible(false);
					PaySuccessDetail.chocolate_cake_pay.setVisible(false);
					
					// ��ī��
					PaySuccessDetail.berry_macaron_pay.setVisible(false);
					PaySuccessDetail.yogurt_macaron_pay.setVisible(false);
					PaySuccessDetail.fruit_macaron_pay.setVisible(false);
			}
		});
		
		login_btn.setFont(new Font("Black Han Sans", Font.PLAIN, 45));
		login_btn.setBounds(1250, 800, 570, 120);
		login_btn.setVisible(true);
		login_btn.setBorderPainted(false);
		login_btn.setContentAreaFilled(false);
		login_btn.setFocusPainted(false);
		login_btn.setOpaque(false);
		login_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Main.MainFrame.getMain_panel().setVisible(false);
					Main.MainFrame.getLogin_panel().setVisible(true);
			}
		});
		
		add(order_btn); // MainPanel�� order_btn �߰�
		add(login_btn); // MainPanel�� login_btn �߰�
		setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	public static JButton getOrder_btn() {
		return order_btn;
	}
	public static JButton getLogin_btn() {
		return login_btn;
	}
}

//�ձ� ��ư ����� RoundedButton Ŭ����
class RoundedButton extends JButton {
	public RoundedButton() {
		super();
		decorate();
	}

	public RoundedButton(String text) {
		super(text);
		decorate();
	}

	public RoundedButton(Action action) {
		super(action);
		decorate();
	}

	public RoundedButton(Icon icon) {
		super(icon);
		decorate();
	}

	public RoundedButton(String text, Icon icon) {
		super(text, icon);
		decorate();
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