package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.EventHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class OrderGUI extends JFrame {
	public static void main(String args[]) {
		OrderPanel order_panel = new OrderPanel();
	}
}

class OrderPanel extends JPanel {
	static Icon icon = new ImageIcon("images/back_2.png");
	
	static WhichStoreLabel which = new WhichStoreLabel();

	JButton order_button = new JButton(icon);
	JButton menu_exit_button = new JButton(icon);

	// 메뉴 가격
	static int ice_coffee_price = 2500;
	static int hot_coffee_price = 2500;

	static int orange_smoothie_price = 3500;
	static int kiwi_smoothie_price = 3500;
	static int grape_smoothie_price = 3500;
	static int strawberry_smoothie_price = 3500;
	static int watermelon_smoothie_price = 3500;

	static int black_tea_price = 3000;
	static int green_tea_price = 3000;

	static int brown_sugar_bubble_price = 4000;
	static int taro_bubble_price = 4000;
	static int green_bubble_price = 4000;

	static int cheese_cake_price = 5000;
	static int strawberry_cake_price = 5000;
	static int chocolate_cake_price = 5000;

	static int berry_macaron_price = 2500;
	static int yogurt_macaron_price = 2500;
	static int fruit_macaron_price = 2500;

	// 주문 개수
	static int ice_coffee_count = 0;
	static int hot_coffee_count = 0;

	static int orange_smoothie_count = 0;
	static int kiwi_smoothie_count = 0;
	static int grape_smoothie_count = 0;
	static int strawberry_smoothie_count = 0;
	static int watermelon_smoothie_count = 0;

	static int black_tea_count = 0;
	static int green_tea_count = 0;

	static int brown_sugar_bubble_count = 0;
	static int taro_bubble_count = 0;
	static int green_bubble_count = 0;

	static int cheese_cake_count = 0;
	static int strawberry_cake_count = 0;
	static int chocolate_cake_count = 0;

	static int berry_macaron_count = 0;
	static int yogurt_macaron_count = 0;
	static int fruit_macaron_count = 0;

	static int all_count = OrderPanel.ice_coffee_count + OrderPanel.hot_coffee_count + OrderPanel.orange_smoothie_count
			+ OrderPanel.kiwi_smoothie_count + OrderPanel.grape_smoothie_count + OrderPanel.strawberry_smoothie_count
			+ OrderPanel.watermelon_smoothie_count + black_tea_count + green_tea_count + brown_sugar_bubble_count
			+ taro_bubble_count + green_bubble_count + cheese_cake_count + strawberry_cake_count + chocolate_cake_count
			+ berry_macaron_count + yogurt_macaron_count + fruit_macaron_count;

	static int all_price;

	// 커피
	Icon ice_coffee = new ImageIcon("images/ice_coffee.png");
	Icon hot_coffee = new ImageIcon("images/hot_coffee.png");
	JLabel ice_coffee_label = new JLabel("", ice_coffee, JLabel.CENTER);
	JLabel hot_coffee_label = new JLabel("", hot_coffee, JLabel.CENTER);

	JButton add_ice_coffee = new JButton("Ice");
	JButton add_hot_coffee = new JButton("Hot");

	// 스무디(과일)
	Icon smoo_orange = new ImageIcon("images/orange-juice.png");
	Icon smoo_kiwi = new ImageIcon("images/kiwi-juice.png");
	Icon smoo_grape = new ImageIcon("images/grape-juice.png");
	Icon smoo_strawberry = new ImageIcon("images/strawberry-juice.png");
	Icon smoo_watermelon = new ImageIcon("images/watermelon-juice.png");
	JLabel smoo_orange_label = new JLabel("", smoo_orange, JLabel.CENTER);
	JLabel smoo_kiwi_label = new JLabel("", smoo_kiwi, JLabel.CENTER);
	JLabel smoo_grape_label = new JLabel("", smoo_grape, JLabel.CENTER);
	JLabel smoo_strawberry_label = new JLabel("", smoo_strawberry, JLabel.CENTER);
	JLabel smoo_watermelon_label = new JLabel("", smoo_watermelon, JLabel.CENTER);

	JButton add_orange_smoo = new JButton("Orange");
	JButton add_kiwi_smoo = new JButton("Kiwi");
	JButton add_grape_smoo = new JButton("Grape");
	JButton add_strawberry_smoo = new JButton("Strawberry");
	JButton add_watermelon_smoo = new JButton("Watermelon");

	// 차
	Icon tea_hong = new ImageIcon("images/tea_hong.png");
	Icon tea_green = new ImageIcon("images/tea_green.png");
	JLabel tea_hong_label = new JLabel("", tea_hong, JLabel.CENTER);
	JLabel tea_green_label = new JLabel("", tea_green, JLabel.CENTER);

	JButton add_hong_tea = new JButton("Black tea");
	JButton add_green_tea = new JButton("Green tea");

	// 버블티
	Icon bubble_brown = new ImageIcon("images/bubble-tea-brown.png");
	Icon bubble_taro = new ImageIcon("images/bubble-tea-taro.png");
	Icon bubble_green = new ImageIcon("images/bubble-tea-green.png");
	JLabel bubble_brown_label = new JLabel("", bubble_brown, JLabel.CENTER);
	JLabel bubble_taro_label = new JLabel("", bubble_taro, JLabel.CENTER);
	JLabel bubble_green_label = new JLabel("", bubble_green, JLabel.CENTER);

	JButton add_black_bubble = new JButton("Black sugar");
	JButton add_taro_bubble = new JButton("Taro");
	JButton add_green_bubble = new JButton("Green tea");

	// 케익
	Icon cake_cheese = new ImageIcon("images/cake_cheese.png");
	Icon cake_strawberry = new ImageIcon("images/cake-strawberry.png");
	Icon cake_chocolate = new ImageIcon("images/cake-chocolate.png");
	JLabel cake_cheese_label = new JLabel("", cake_cheese, JLabel.CENTER);
	JLabel cake_strawberry_label = new JLabel("", cake_strawberry, JLabel.CENTER);
	JLabel cake_chocolate_label = new JLabel("", cake_chocolate, JLabel.CENTER);

	JButton add_cake_cheese = new JButton("Cheese");
	JButton add_cake_strawberry = new JButton("Strawberry");
	JButton add_cake_chocolate = new JButton("Chocolate");

	// 마카롱
	Icon macaron_berry = new ImageIcon("images/macaron-berry.png");
	Icon macaron_yogurt = new ImageIcon("images/macaron-yogurt.png");
	Icon macaron_fruit = new ImageIcon("images/macaron-fruit.png");
	JLabel macaron_berry_label = new JLabel("", macaron_berry, JLabel.CENTER);
	JLabel macaron_yogurt_label = new JLabel("", macaron_yogurt, JLabel.CENTER);
	JLabel macaron_fruit_label = new JLabel("", macaron_fruit, JLabel.CENTER);

	JButton add_macaron_berry = new JButton("Berry");
	JButton add_macaron_yogurt = new JButton("Yogurt");
	JButton add_macaron_fruit = new JButton("Fruit");

	// MainPanel에 올릴 컴포넌트들의 생성자 호출
	ImageIcon background = new ImageIcon("images/background_15.png"); // 배경사진은 class못만들어서 그냥 넣음

	static OrderList order_list = new OrderList();

	static OrderDetails iceCoffee = new OrderDetails();
	static OrderDetails hotCoffee = new OrderDetails();
	static OrderDetails orangeSmoo = new OrderDetails();
	static OrderDetails kiwiSmoo = new OrderDetails();
	static OrderDetails grapeSmoo = new OrderDetails();
	static OrderDetails strawberrySmoo = new OrderDetails();
	static OrderDetails watermalonSmoo = new OrderDetails();
	static OrderDetails blackTea = new OrderDetails();
	static OrderDetails greenTea = new OrderDetails();
	static OrderDetails brownBubble = new OrderDetails();
	static OrderDetails taroBubble = new OrderDetails();
	static OrderDetails greenBubble = new OrderDetails();
	static OrderDetails cheeseCake = new OrderDetails();
	static OrderDetails strayberryCake = new OrderDetails();
	static OrderDetails chocolateCake = new OrderDetails();
	static OrderDetails berryMacaron = new OrderDetails();
	static OrderDetails yogurtMacaron = new OrderDetails();
	static OrderDetails fruitMacaron = new OrderDetails();

	static OrderDetails space = new OrderDetails();

	static PriceSum price_sum = new PriceSum();

	static int order_btn_count = 0;

	public static OrderDetails getIceCoffee() {
		return iceCoffee;
	}

	OrderPanel() {
		add(which);
		
		add(order_list);
		add(price_sum);

		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		order_button.setBounds(1300, 900, 200, 50);
		order_button.setVisible(true);
		order_button.setBorderPainted(false);
		order_button.setContentAreaFilled(false);
		order_button.setFocusPainted(false);
		order_button.setOpaque(false);

		order_button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (all_price == 0) {
					JOptionPane.showMessageDialog(null, "메뉴를 하나 이상 선택해주세요", "메뉴부족", JOptionPane.ERROR_MESSAGE);
				} else {
					order_btn_count++;
					if (order_btn_count == 1) {
						Main.MainFrame.getOrder_panel().setVisible(false);
						Main.MainFrame.getPayment_panel().setVisible(true);
						Payment.td2.start();
					} else {
						Main.MainFrame.getOrder_panel().setVisible(false);
						Main.MainFrame.getPayment_panel().setVisible(true);
						synchronized (Payment.td2) {
							Payment.td2.notify();
						}
					}
				}
				all_count = 0;
				all_price = 0;
				price_sum.setText("결제금액 : " + all_price + "원");
			}
		});

		menu_exit_button.setBounds(1550, 900, 200, 50);
		menu_exit_button.setVisible(true);
		menu_exit_button.setBorderPainted(false);
		menu_exit_button.setContentAreaFilled(false);
		menu_exit_button.setFocusPainted(false);
		menu_exit_button.setOpaque(false);

		menu_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getOrder_panel().setVisible(false);
				Main.MainFrame.getMain_panel().setVisible(true);
				OrderPanel.getOrder_list().removeAll();

				all_count = 0;
				all_price = 0;
				price_sum.setText("결제금액 : " + all_price + "원");
				
				Main.MainFrame.getChoice_store_panel().remove(ChoiceArea.store_combobox);
				ChoiceArea.area_combobox.setSelectedIndex(0);		
				ChoiceArea.store_combobox.setSelectedIndex(0);
				ChoiceArea.area_choice_label.setText("지역을 선택해 주세요");
				ChoiceArea.store_choice_label.setText("지점을 선택해 주세요");
			}
		});

		add(order_button);
		add(menu_exit_button);

		// 커피
		ice_coffee_label.setBounds(140, 180, 145, 145);
		ice_coffee_label.setVerticalTextPosition(JLabel.CENTER);
		ice_coffee_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(ice_coffee_label);

		hot_coffee_label.setBounds(140, 180, 145, 145);
		hot_coffee_label.setVerticalTextPosition(JLabel.CENTER);
		hot_coffee_label.setHorizontalTextPosition(JLabel.RIGHT);
		hot_coffee_label.setVisible(false);
		add(hot_coffee_label);

		add_ice_coffee.setBounds(320, 210, 100, 40);
		add_ice_coffee.setFont(new Font("인터파크고딕 M", Font.PLAIN, 24));
		add_ice_coffee.setBorderPainted(false);
		add_ice_coffee.setBackground(new Color(255, 220, 212));
		add_ice_coffee.setFocusPainted(false);
		add(add_ice_coffee);
		add_ice_coffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ice_coffee_label.setVisible(true);
				hot_coffee_label.setVisible(false);
			}
		});
		add_ice_coffee.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setLocation(0, 0);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(iceCoffee);
				if (e.getClickCount() == 2) {

					iceCoffee.setBounds(0, all_count * 70, 500, 50);
//					iceCoffee.setHorizontalAlignment(JLabel.CENTER);
					iceCoffee.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					iceCoffee.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_ice_coffee = new JButton();
					minus_ice_coffee.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_ice_coffee.setBounds(10, 0, 30, 30);

					minus_ice_coffee.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_ice_coffee.setFocusPainted(false);
					minus_ice_coffee.setOpaque(false);
					minus_ice_coffee.setIcon(minus);
					iceCoffee.add(minus_ice_coffee);

					minus_ice_coffee.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ice_coffee_count--;
							iceCoffee.setText(" 뺌   Ice-coffee  |  " + String.valueOf(ice_coffee_count) + "   |  "
									+ String.valueOf(ice_coffee_count * 2500) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.ice_coffee_pay.setText("Ice-coffee  " + ice_coffee_count + "개  "
									+ ice_coffee_count * ice_coffee_price + "원");
							if (ice_coffee_count == 0) {
								OrderPanel.iceCoffee.setVisible(false);
							}
						}
					});
					iceCoffee.add(minus_ice_coffee);
					if (ice_coffee_count < 2) {
						ice_coffee_count++;
						iceCoffee.setText(" 뺌   Ice-coffee  |  " + String.valueOf(ice_coffee_count) + "   |  "
								+ String.valueOf(ice_coffee_count * 2500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.ice_coffee_pay.setText(
								"Ice-coffee  " + ice_coffee_count + "개  " + ice_coffee_count * ice_coffee_price + "원");
					} else {
						ice_coffee_count++;
						iceCoffee.setText(" 뺌   Ice-coffee  |  " + String.valueOf(ice_coffee_count) + "   |  "
								+ String.valueOf(ice_coffee_count * 2500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.ice_coffee_pay.setText(
							"Ice-coffee  " + ice_coffee_count + "개  " + ice_coffee_count * ice_coffee_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		add_hot_coffee.setBounds(320, 260, 100, 40);
		add_hot_coffee.setFont(new Font("인터파크고딕 M", Font.PLAIN, 24));
		add_hot_coffee.setBorderPainted(false);
		add_hot_coffee.setBackground(new Color(255, 220, 212));
		add_hot_coffee.setFocusPainted(false);
		add(add_hot_coffee);
		add_hot_coffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ice_coffee_label.setVisible(false);
				hot_coffee_label.setVisible(true);
			}
		});
		add_hot_coffee.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(hotCoffee);
				if (e.getClickCount() == 2) {
					hotCoffee.setBounds(0, all_count * 70, 500, 50);
					hotCoffee.setHorizontalAlignment(JLabel.LEFT);
					hotCoffee.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					hotCoffee.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_hot_coffee = new JButton();
					minus_hot_coffee.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_hot_coffee.setBounds(10, 0, 30, 30);

					minus_hot_coffee.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_hot_coffee.setFocusPainted(false);
					minus_hot_coffee.setOpaque(false);
					minus_hot_coffee.setIcon(minus);
					hotCoffee.add(minus_hot_coffee);

					minus_hot_coffee.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							hot_coffee_count--;
							hotCoffee.setText(" 뺌   Hot-coffee  |  " + String.valueOf(hot_coffee_count) + "  |  "
									+ String.valueOf(hot_coffee_count * 2500) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.hot_coffee_pay.setText("Hot-coffee  " + hot_coffee_count + "개  "
									+ hot_coffee_count * hot_coffee_price + "원");
							if (hot_coffee_count == 0) {
								OrderPanel.hotCoffee.setVisible(false);
							}
						}
					});
					hotCoffee.add(minus_hot_coffee);
					if (hot_coffee_count < 2) {
						hot_coffee_count++;
						hotCoffee.setText(" 뺌   Hot-coffee  |  " + String.valueOf(hot_coffee_count) + "  |  "
								+ String.valueOf(hot_coffee_count * 2500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.hot_coffee_pay.setText(
								"Hot-coffee  " + hot_coffee_count + "개  " + hot_coffee_count * hot_coffee_price + "원");
					} else {
						hot_coffee_count++;
						hotCoffee.setText(" 뺌   Hot-coffee  |  " + String.valueOf(hot_coffee_count) + "  |  "
								+ String.valueOf(hot_coffee_count * 2500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.hot_coffee_pay.setText(
							"Hot-coffee  " + hot_coffee_count + "개  " + hot_coffee_count * hot_coffee_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		// 스무디
		smoo_orange_label.setBounds(590, 180, 145, 145);
		smoo_orange_label.setVerticalTextPosition(JLabel.CENTER);
		smoo_orange_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(smoo_orange_label);
		smoo_orange_label.setVisible(true);

		smoo_kiwi_label.setBounds(590, 180, 145, 145);
		smoo_kiwi_label.setVerticalTextPosition(JLabel.CENTER);
		smoo_kiwi_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(smoo_kiwi_label);
		smoo_kiwi_label.setVisible(false);

		smoo_grape_label.setBounds(590, 180, 145, 145);
		smoo_grape_label.setVerticalTextPosition(JLabel.CENTER);
		smoo_grape_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(smoo_grape_label);
		smoo_grape_label.setVisible(false);

		smoo_strawberry_label.setBounds(590, 180, 145, 145);
		smoo_strawberry_label.setVerticalTextPosition(JLabel.CENTER);
		smoo_strawberry_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(smoo_strawberry_label);
		smoo_strawberry_label.setVisible(false);

		smoo_watermelon_label.setBounds(590, 180, 145, 145);
		smoo_watermelon_label.setVerticalTextPosition(JLabel.CENTER);
		smoo_watermelon_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(smoo_watermelon_label);
		smoo_watermelon_label.setVisible(false);

		add_orange_smoo.setBounds(740, 170, 170, 27);
		add_orange_smoo.setFont(new Font("인터파크고딕 M", Font.PLAIN, 22));
		add_orange_smoo.setBorderPainted(false);
		add_orange_smoo.setBackground(new Color(247, 255, 212));
		add_orange_smoo.setFocusPainted(false);
		add(add_orange_smoo);
		add_orange_smoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smoo_orange_label.setVisible(true);
			}
		});
		add_orange_smoo.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(orangeSmoo);
				if (e.getClickCount() == 2) {
					orangeSmoo.setBounds(0, all_count * 70, 500, 50);
					orangeSmoo.setHorizontalAlignment(JLabel.LEFT);
					orangeSmoo.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					orangeSmoo.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_orange_smoo = new JButton();
					minus_orange_smoo.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_orange_smoo.setBounds(10, 0, 30, 30);

					minus_orange_smoo.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_orange_smoo.setFocusPainted(false);
					minus_orange_smoo.setOpaque(false);
					minus_orange_smoo.setIcon(minus);
					hotCoffee.add(minus_orange_smoo);

					minus_orange_smoo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							orange_smoothie_count--;
							hotCoffee.setText(" 뺌   Orange-smoothie  |  " + String.valueOf(orange_smoothie_count)
									+ "  |  " + String.valueOf(orange_smoothie_count * 3500) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.orange_smoo_pay.setText("Orange-smoothie  " + orange_smoothie_count + "개  "
									+ orange_smoothie_count * orange_smoothie_price + "원");
							if (orange_smoothie_count == 0) {
								OrderPanel.orangeSmoo.setVisible(false);
							}
						}
					});
					orangeSmoo.add(minus_orange_smoo);
					if (orange_smoothie_count < 2) {
						orange_smoothie_count++;
						orangeSmoo.setText(" 뺌   Orange-smoothie  |  " + String.valueOf(orange_smoothie_count) + "  |  "
								+ String.valueOf(orange_smoothie_count * 3500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					} else {
						orange_smoothie_count++;
						orangeSmoo.setText(" 뺌   Orange-smoothie  |  " + String.valueOf(orange_smoothie_count) + "  |  "
								+ String.valueOf(orange_smoothie_count * 3500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.orange_smoo_pay.setText("Orange-smoothie  " + orange_smoothie_count + "개  "
								+ orange_smoothie_count * orange_smoothie_price + "원");
					}
					PaySuccessDetail.orange_smoo_pay.setText("Orange-smoothie  " + orange_smoothie_count + "개  "
							+ orange_smoothie_count * orange_smoothie_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		add_kiwi_smoo.setBounds(740, 205, 170, 27);
		add_kiwi_smoo.setFont(new Font("인터파크고딕 M", Font.PLAIN, 22));
		add_kiwi_smoo.setBorderPainted(false);
		add_kiwi_smoo.setBackground(new Color(247, 255, 212));
		add_kiwi_smoo.setFocusPainted(false);
		add(add_kiwi_smoo);
		add_kiwi_smoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smoo_orange_label.setVisible(false);
				smoo_kiwi_label.setVisible(true);
				smoo_grape_label.setVisible(false);
				smoo_strawberry_label.setVisible(false);
				smoo_watermelon_label.setVisible(false);
			}
		});
		add_kiwi_smoo.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(kiwiSmoo);
				if (e.getClickCount() == 2) {
					kiwiSmoo.setBounds(0, all_count * 70, 500, 50);
					kiwiSmoo.setHorizontalAlignment(JLabel.LEFT);
					kiwiSmoo.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					kiwiSmoo.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_kiwi_smoo = new JButton();
					minus_kiwi_smoo.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_kiwi_smoo.setBounds(10, 0, 30, 30);

					minus_kiwi_smoo.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_kiwi_smoo.setFocusPainted(false);
					minus_kiwi_smoo.setOpaque(false);
					minus_kiwi_smoo.setIcon(minus);
					kiwiSmoo.add(minus_kiwi_smoo);

					minus_kiwi_smoo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							kiwi_smoothie_count--;
							kiwiSmoo.setText(" 뺌   Kiwi-smoothie  |  " + String.valueOf(kiwi_smoothie_count) + "  |  "
									+ String.valueOf(kiwi_smoothie_count * 3500) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.kiwi_smoo_pay.setText("Kiwi-smoothie  " + kiwi_smoothie_count + "개  "
									+ kiwi_smoothie_count * kiwi_smoothie_price + "원");
							if (kiwi_smoothie_count == 0) {
								OrderPanel.kiwiSmoo.setVisible(false);
							}
						}
					});
					kiwiSmoo.add(minus_kiwi_smoo);
					if (kiwi_smoothie_count < 2) {
						kiwi_smoothie_count++;
						kiwiSmoo.setText(" 뺌   Kiwi-smoothie  |  " + String.valueOf(kiwi_smoothie_count) + "  |  "
								+ String.valueOf(kiwi_smoothie_count * 3500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.kiwi_smoo_pay.setText("Kiwi-smoothie  " + kiwi_smoothie_count + "개  "
								+ kiwi_smoothie_count * kiwi_smoothie_price + "원");
					} else {
						kiwi_smoothie_count++;
						kiwiSmoo.setText(" 뺌   Kiwi-smoothie  |  " + String.valueOf(kiwi_smoothie_count) + "  |  "
								+ String.valueOf(kiwi_smoothie_count * 3500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.kiwi_smoo_pay.setText("Kiwi-smoothie  " + kiwi_smoothie_count + "개  "
							+ kiwi_smoothie_count * kiwi_smoothie_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		add_grape_smoo.setBounds(740, 240, 170, 27);
		add_grape_smoo.setFont(new Font("인터파크고딕 M", Font.PLAIN, 22));
		add_grape_smoo.setBorderPainted(false);
		add_grape_smoo.setBackground(new Color(247, 255, 212));
		add_grape_smoo.setFocusPainted(false);
		add(add_grape_smoo);
		add_grape_smoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smoo_orange_label.setVisible(false);
				smoo_kiwi_label.setVisible(false);
				smoo_grape_label.setVisible(true);
				smoo_strawberry_label.setVisible(false);
				smoo_watermelon_label.setVisible(false);
			}
		});
		add_grape_smoo.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(grapeSmoo);
				if (e.getClickCount() == 2) {
					grapeSmoo.setBounds(0, all_count * 70, 500, 50);
					grapeSmoo.setHorizontalAlignment(JLabel.LEFT);
					grapeSmoo.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					grapeSmoo.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_grape_smoo = new JButton();
					minus_grape_smoo.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_grape_smoo.setBounds(10, 0, 30, 30);

					minus_grape_smoo.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_grape_smoo.setFocusPainted(false);
					minus_grape_smoo.setOpaque(false);
					minus_grape_smoo.setIcon(minus);
					grapeSmoo.add(minus_grape_smoo);

					minus_grape_smoo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							grape_smoothie_count--;
							grapeSmoo.setText(" 뺌   Grape-smoothie  |  " + String.valueOf(grape_smoothie_count)
									+ "  |  " + String.valueOf(grape_smoothie_count * 3500) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.grape_smoo_pay.setText("Grape-smoothie  " + grape_smoothie_count + "개  "
									+ grape_smoothie_count * grape_smoothie_price + "원");
							if (grape_smoothie_count == 0) {
								OrderPanel.grapeSmoo.setVisible(false);
							}
						}
					});
					grapeSmoo.add(minus_grape_smoo);
					if (grape_smoothie_count < 2) {
						grape_smoothie_count++;
						grapeSmoo.setText(" 뺌   Grape-smoothie  |  " + String.valueOf(grape_smoothie_count) + "  |  "
								+ String.valueOf(grape_smoothie_count * 3500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.grape_smoo_pay.setText("Grape-smoothie  " + grape_smoothie_count + "개  "
								+ grape_smoothie_count * grape_smoothie_price + "원");
					} else {
						grape_smoothie_count++;
						grapeSmoo.setText(" 뺌   Grape-smoothie  |  " + String.valueOf(grape_smoothie_count) + "  |  "
								+ String.valueOf(grape_smoothie_count * 3500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.grape_smoo_pay.setText("Grape-smoothie  " + grape_smoothie_count + "개  "
							+ grape_smoothie_count * grape_smoothie_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		add_strawberry_smoo.setBounds(740, 275, 170, 27);
		add_strawberry_smoo.setFont(new Font("인터파크고딕 M", Font.PLAIN, 22));
		add_strawberry_smoo.setBorderPainted(false);
		add_strawberry_smoo.setBackground(new Color(247, 255, 212));
		add_strawberry_smoo.setFocusPainted(false);
		add(add_strawberry_smoo);
		add_strawberry_smoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smoo_orange_label.setVisible(false);
				smoo_kiwi_label.setVisible(false);
				smoo_grape_label.setVisible(false);
				smoo_strawberry_label.setVisible(true);
				smoo_watermelon_label.setVisible(false);
			}
		});
		add_strawberry_smoo.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(strawberrySmoo);
				if (e.getClickCount() == 2) {
					strawberrySmoo.setBounds(0, all_count * 70, 500, 50);
					strawberrySmoo.setHorizontalAlignment(JLabel.LEFT);
					strawberrySmoo.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					strawberrySmoo.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_strawberry_smoo = new JButton();
					minus_strawberry_smoo.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_strawberry_smoo.setBounds(10, 0, 30, 30);

					minus_strawberry_smoo.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_strawberry_smoo.setFocusPainted(false);
					minus_strawberry_smoo.setOpaque(false);
					minus_strawberry_smoo.setIcon(minus);
					strawberrySmoo.add(minus_strawberry_smoo);

					minus_strawberry_smoo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							strawberry_smoothie_count--;
							strawberrySmoo
									.setText(" 뺌   Strawberry-smoothie  |  " + String.valueOf(strawberry_smoothie_count)
											+ "  |  " + String.valueOf(strawberry_smoothie_count * 3500) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.strawberry_smoo_pay
									.setText("Strawberry-smoothie  " + strawberry_smoothie_count + "개  "
											+ strawberry_smoothie_count * strawberry_smoothie_price + "원");
							if (strawberry_smoothie_count == 0) {
								OrderPanel.strawberrySmoo.setVisible(false);
							}
						}
					});
					strawberrySmoo.add(minus_strawberry_smoo);
					if (strawberry_smoothie_count < 2) {
						strawberry_smoothie_count++;
						strawberrySmoo
								.setText(" 뺌   Strawberry-smoothie  |  " + String.valueOf(strawberry_smoothie_count)
										+ "  |  " + String.valueOf(strawberry_smoothie_count * 3500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.strawberry_smoo_pay.setText("Strawberry-smoothie  " + strawberry_smoothie_count
								+ "개  " + strawberry_smoothie_count * strawberry_smoothie_price + "원");
					} else {
						strawberry_smoothie_count++;
						strawberrySmoo
								.setText(" 뺌   Strawberry-smoothie  |  " + String.valueOf(strawberry_smoothie_count)
										+ "  |  " + String.valueOf(strawberry_smoothie_count * 3500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.strawberry_smoo_pay.setText("Strawberry-smoothie  " + strawberry_smoothie_count
							+ "개  " + strawberry_smoothie_count * strawberry_smoothie_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		add_watermelon_smoo.setBounds(740, 310, 170, 27);
		add_watermelon_smoo.setFont(new Font("인터파크고딕 M", Font.PLAIN, 22));
		add_watermelon_smoo.setBorderPainted(false);
		add_watermelon_smoo.setBackground(new Color(247, 255, 212));
		add_watermelon_smoo.setFocusPainted(false);
		add(add_watermelon_smoo);
		add_watermelon_smoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smoo_orange_label.setVisible(false);
				smoo_kiwi_label.setVisible(false);
				smoo_grape_label.setVisible(false);
				smoo_strawberry_label.setVisible(false);
				smoo_watermelon_label.setVisible(true);
			}
		});
		add_watermelon_smoo.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(watermalonSmoo);
				if (e.getClickCount() == 2) {
					watermalonSmoo.setBounds(0, all_count * 70, 500, 50);
					watermalonSmoo.setHorizontalAlignment(JLabel.LEFT);
					watermalonSmoo.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					watermalonSmoo.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_watermelon_smoo = new JButton();
					minus_watermelon_smoo.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_watermelon_smoo.setBounds(10, 0, 30, 30);

					minus_watermelon_smoo.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_watermelon_smoo.setFocusPainted(false);
					minus_watermelon_smoo.setOpaque(false);
					minus_watermelon_smoo.setIcon(minus);
					watermalonSmoo.add(minus_watermelon_smoo);

					minus_watermelon_smoo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							watermelon_smoothie_count--;
							watermalonSmoo
									.setText(" 뺌  Watermelon-smoothie  |  " + String.valueOf(watermelon_smoothie_count)
											+ "  |  " + String.valueOf(watermelon_smoothie_count * 3500) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.watermelon_smoo_pay
									.setText("Watermelon-smoothie  " + watermelon_smoothie_count + "개  "
											+ watermelon_smoothie_count * watermelon_smoothie_price + "원");
							if (watermelon_smoothie_count == 0) {
								OrderPanel.watermalonSmoo.setVisible(false);
							}
						}
					});
					watermalonSmoo.add(minus_watermelon_smoo);
					if (watermelon_smoothie_count < 2) {
						watermelon_smoothie_count++;
						watermalonSmoo
								.setText(" 뺌  Watermelon-smoothie  |  " + String.valueOf(watermelon_smoothie_count)
										+ "  |  " + String.valueOf(watermelon_smoothie_count * 3500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.watermelon_smoo_pay.setText("Watermelon-smoothie  " + watermelon_smoothie_count
								+ "개  " + watermelon_smoothie_count * watermelon_smoothie_price + "원");
					} else {
						watermelon_smoothie_count++;
						watermalonSmoo
								.setText(" 뺌  Watermelon-smoothie  |  " + String.valueOf(watermelon_smoothie_count)
										+ "  |  " + String.valueOf(watermelon_smoothie_count * 3500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.watermelon_smoo_pay.setText("Watermelon-smoothie  " + watermelon_smoothie_count
							+ "개  " + watermelon_smoothie_count * watermelon_smoothie_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		// 차
		tea_hong_label.setBounds(140, 476, 145, 145);
		tea_hong_label.setVerticalTextPosition(JLabel.CENTER);
		tea_hong_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(tea_hong_label);

		tea_green_label.setBounds(140, 476, 145, 145);
		tea_green_label.setVerticalTextPosition(JLabel.CENTER);
		tea_green_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(tea_green_label);
		tea_green_label.setVisible(false);

		add_hong_tea.setBounds(320, 500, 150, 40);
		add_hong_tea.setFont(new Font("인터파크고딕 M", Font.PLAIN, 24));
		add_hong_tea.setBorderPainted(false);
		add_hong_tea.setBackground(new Color(191, 252, 255));
		add_hong_tea.setFocusPainted(false);
		add(add_hong_tea);
		add_hong_tea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tea_hong_label.setVisible(true);
				tea_green_label.setVisible(false);
			}
		});
		add_hong_tea.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(blackTea);
				if (e.getClickCount() == 2) {
					blackTea.setBounds(0, all_count * 70, 500, 50);
					blackTea.setHorizontalAlignment(JLabel.LEFT);
					blackTea.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					blackTea.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_black_tea = new JButton();
					minus_black_tea.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_black_tea.setBounds(10, 0, 30, 30);

					minus_black_tea.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_black_tea.setFocusPainted(false);
					minus_black_tea.setOpaque(false);
					minus_black_tea.setIcon(minus);
					blackTea.add(minus_black_tea);

					minus_black_tea.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							black_tea_count--;
							blackTea.setText(" 뺌  Black-tea  |  " + String.valueOf(black_tea_count) + "  |  "
									+ String.valueOf(black_tea_count * 3000) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.black_tea_pay.setText(
									"Black-tea  " + black_tea_count + "개  " + black_tea_count * black_tea_price + "원");
							if (black_tea_count == 0) {
								OrderPanel.blackTea.setVisible(false);
							}
						}
					});
					blackTea.add(minus_black_tea);
					if (black_tea_count < 2) {
						black_tea_count++;
						blackTea.setText(" 뺌  Black-tea  |  " + String.valueOf(black_tea_count) + "  |  "
								+ String.valueOf(black_tea_count * 3000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.black_tea_pay.setText(
								"Black-tea  " + black_tea_count + "개  " + black_tea_count * black_tea_price + "원");
					} else {
						black_tea_count++;
						blackTea.setText(" 뺌  Black-tea  |  " + String.valueOf(black_tea_count) + "  |  "
								+ String.valueOf(black_tea_count * 3000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.black_tea_pay
							.setText("Black-tea  " + black_tea_count + "개  " + black_tea_count * black_tea_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		add_green_tea.setBounds(320, 550, 150, 40);
		add_green_tea.setFont(new Font("인터파크고딕 M", Font.PLAIN, 24));
		add_green_tea.setBorderPainted(false);
		add_green_tea.setBackground(new Color(191, 252, 255));
		add_green_tea.setFocusPainted(false);
		add(add_green_tea);
		add_green_tea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tea_hong_label.setVisible(false);
				tea_green_label.setVisible(true);
			}
		});
		add_green_tea.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(greenTea);
				if (e.getClickCount() == 2) {
					greenTea.setBounds(0, all_count * 70, 500, 50);
					greenTea.setHorizontalAlignment(JLabel.LEFT);
					greenTea.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					greenTea.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_green_tea = new JButton();
					minus_green_tea.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_green_tea.setBounds(10, 0, 30, 30);

					minus_green_tea.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_green_tea.setFocusPainted(false);
					minus_green_tea.setOpaque(false);
					minus_green_tea.setIcon(minus);
					greenTea.add(minus_green_tea);

					minus_green_tea.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							green_tea_count--;
							greenTea.setText(" 뺌  Green-tea  |  " + String.valueOf(green_tea_count) + "  |  "
									+ String.valueOf(green_tea_count * 3000) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.green_tea_pay.setText(
									"Green-tea  " + green_tea_count + "개  " + green_tea_count * green_tea_price + "원");
							if (green_tea_count == 0) {
								OrderPanel.greenTea.setVisible(false);
							}
						}
					});
					greenTea.add(minus_green_tea);
					if (green_tea_count < 2) {
						green_tea_count++;
						greenTea.setText(" 뺌  Green-tea  |  " + String.valueOf(green_tea_count) + "  |  "
								+ String.valueOf(green_tea_count * 3000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.green_tea_pay.setText(
								"Green-tea  " + green_tea_count + "개  " + green_tea_count * green_tea_price + "원");
					} else {
						green_tea_count++;
						greenTea.setText(" 뺌  Green-tea  |  " + String.valueOf(green_tea_count) + "  |  "
								+ String.valueOf(green_tea_count * 3000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.green_tea_pay
							.setText("Green-tea  " + green_tea_count + "개  " + green_tea_count * green_tea_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		// 버블
		bubble_brown_label.setBounds(590, 472, 145, 145);
		bubble_brown_label.setVerticalTextPosition(JLabel.CENTER);
		bubble_brown_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(bubble_brown_label);

		bubble_taro_label.setBounds(590, 472, 145, 145);
		bubble_taro_label.setVerticalTextPosition(JLabel.CENTER);
		bubble_taro_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(bubble_taro_label);
		bubble_taro_label.setVisible(false);

		bubble_green_label.setBounds(590, 472, 145, 145);
		bubble_green_label.setVerticalTextPosition(JLabel.CENTER);
		bubble_green_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(bubble_green_label);
		bubble_green_label.setVisible(false);

		add_black_bubble.setBounds(740, 475, 180, 40);
		add_black_bubble.setFont(new Font("인터파크고딕 M", Font.PLAIN, 26));
		add_black_bubble.setBorderPainted(false);
		add_black_bubble.setBackground(new Color(201, 255, 245));
		add_black_bubble.setFocusPainted(false);
		add(add_black_bubble);
		add_black_bubble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bubble_brown_label.setVisible(true);
			}
		});
		add_black_bubble.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(brownBubble);
				if (e.getClickCount() == 2) {
					brownBubble.setBounds(0, all_count * 70, 500, 50);
					brownBubble.setHorizontalAlignment(JLabel.LEFT);
					brownBubble.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					brownBubble.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_brown_bubble = new JButton();
					minus_brown_bubble.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_brown_bubble.setBounds(10, 0, 30, 30);

					minus_brown_bubble.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_brown_bubble.setFocusPainted(false);
					minus_brown_bubble.setOpaque(false);
					minus_brown_bubble.setIcon(minus);
					brownBubble.add(minus_brown_bubble);

					minus_brown_bubble.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							brown_sugar_bubble_count--;
							brownBubble.setText(" 뺌 Brownsugar-bubbleT  |  " + String.valueOf(brown_sugar_bubble_count)
									+ "  |  " + String.valueOf(brown_sugar_bubble_count * 4000) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.brown_bubble_pay.setText("Brownsugar-bubbleT  " + brown_sugar_bubble_count
									+ "개  " + brown_sugar_bubble_count * brown_sugar_bubble_price + "원");
							if (brown_sugar_bubble_count == 0) {
								OrderPanel.brownBubble.setVisible(false);
							}
						}
					});
					brownBubble.add(minus_brown_bubble);
					if (brown_sugar_bubble_count < 2) {
						brown_sugar_bubble_count++;
						brownBubble.setText(" 뺌 Brownsugar-bubbleT  |  " + String.valueOf(brown_sugar_bubble_count)
								+ "  |  " + String.valueOf(brown_sugar_bubble_count * 4000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.brown_bubble_pay.setText("Brownsugar-bubbleT  " + brown_sugar_bubble_count
								+ "개  " + brown_sugar_bubble_count * brown_sugar_bubble_price + "원");
					} else {
						brown_sugar_bubble_count++;
						brownBubble.setText(" 뺌 Brownsugar-bubbleT  |  " + String.valueOf(brown_sugar_bubble_count)
								+ "  |  " + String.valueOf(brown_sugar_bubble_count * 4000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.brown_bubble_pay.setText("Brownsugar-bubbleT  " + brown_sugar_bubble_count + "개  "
							+ brown_sugar_bubble_count * brown_sugar_bubble_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		add_taro_bubble.setBounds(740, 525, 180, 40);
		add_taro_bubble.setFont(new Font("인터파크고딕 M", Font.PLAIN, 26));
		add_taro_bubble.setBorderPainted(false);
		add_taro_bubble.setBackground(new Color(201, 255, 245));
		add_taro_bubble.setFocusPainted(false);
		add(add_taro_bubble);
		add_taro_bubble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bubble_brown_label.setVisible(false);
				bubble_taro_label.setVisible(true);
				bubble_green_label.setVisible(false);
			}
		});
		add_taro_bubble.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(taroBubble);
				if (e.getClickCount() == 2) {
					taroBubble.setBounds(0, all_count * 70, 500, 50);
					taroBubble.setHorizontalAlignment(JLabel.LEFT);
					taroBubble.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					taroBubble.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_taro_bubble = new JButton();
					minus_taro_bubble.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_taro_bubble.setBounds(10, 0, 30, 30);

					minus_taro_bubble.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_taro_bubble.setFocusPainted(false);
					minus_taro_bubble.setOpaque(false);
					minus_taro_bubble.setIcon(minus);
					taroBubble.add(minus_taro_bubble);

					minus_taro_bubble.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							taro_bubble_count--;
							taroBubble.setText(" 뺌 Taro-bubbleT  |  " + String.valueOf(taro_bubble_count) + "  |  "
									+ String.valueOf(taro_bubble_count * 4000) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.taro_bubble_pay.setText("Taro-bubbleT  " + taro_bubble_count + "개  "
									+ taro_bubble_count * taro_bubble_price + "원");
							if (taro_bubble_count == 0) {
								OrderPanel.taroBubble.setVisible(false);
							}
						}
					});
					taroBubble.add(minus_taro_bubble);
					if (taro_bubble_count < 2) {
						taro_bubble_count++;
						taroBubble.setText(" 뺌 Taro-bubbleT  |  " + String.valueOf(taro_bubble_count) + "  |  "
								+ String.valueOf(taro_bubble_count * 4000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.taro_bubble_pay.setText("Taro-bubbleT  " + taro_bubble_count + "개  "
								+ taro_bubble_count * taro_bubble_price + "원");
					} else {
						taro_bubble_count++;
						taroBubble.setText(" 뺌 Taro-bubbleT  |  " + String.valueOf(taro_bubble_count) + "  |  "
								+ String.valueOf(taro_bubble_count * 4000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.taro_bubble_pay.setText(
							"Taro-bubbleT  " + taro_bubble_count + "개  " + taro_bubble_count * taro_bubble_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

//		add_taro_bubble.setBounds(740, 525, 180, 40);
//		add_taro_bubble.setFont(new Font("인터파크고딕 M", Font.PLAIN, 26));
//		add_taro_bubble.setBorderPainted(false);
//		add_taro_bubble.setBackground(new Color(201, 255, 245));
//		add_taro_bubble.setFocusPainted(false);
//		add(add_taro_bubble);
//		add_taro_bubble.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				bubble_brown_label.setVisible(false);
//				bubble_taro_label.setVisible(true);
//				bubble_green_label.setVisible(false);
//			}
//		});

		add_green_bubble.setBounds(740, 575, 180, 40);
		add_green_bubble.setFont(new Font("인터파크고딕 M", Font.PLAIN, 26));
		add_green_bubble.setBorderPainted(false);
		add_green_bubble.setBackground(new Color(201, 255, 245));
		add_green_bubble.setFocusPainted(false);
		add(add_green_bubble);
		add_green_bubble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bubble_brown_label.setVisible(false);
				bubble_taro_label.setVisible(false);
				bubble_green_label.setVisible(true);
			}
		});
		add_green_bubble.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(greenBubble);
				if (e.getClickCount() == 2) {
					greenBubble.setBounds(0, all_count * 70, 500, 50);
					greenBubble.setHorizontalAlignment(JLabel.LEFT);
					greenBubble.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					greenBubble.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_green_bubble = new JButton();
					minus_green_bubble.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_green_bubble.setBounds(10, 0, 30, 30);

					minus_green_bubble.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_green_bubble.setFocusPainted(false);
					minus_green_bubble.setOpaque(false);
					minus_green_bubble.setIcon(minus);
					taroBubble.add(minus_green_bubble);

					minus_green_bubble.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							green_bubble_count--;
							greenBubble.setText(" 뺌 Green-bubbleT  |  " + String.valueOf(green_bubble_count) + "  |  "
									+ String.valueOf(green_bubble_count * 4000) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.green_bubble_pay.setText("Green-bubbleT  " + green_bubble_count + "개  "
									+ green_bubble_count * green_bubble_price + "원");
							if (green_bubble_count == 0) {
								OrderPanel.greenBubble.setVisible(false);
							}
						}
					});
					greenBubble.add(minus_green_bubble);
					if (green_bubble_count < 2) {
						green_bubble_count++;
						greenBubble.setText(" 뺌 Green-bubbleT  |  " + String.valueOf(green_bubble_count) + "  |  "
								+ String.valueOf(green_bubble_count * 4000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.green_bubble_pay.setText("Green-bubbleT  " + green_bubble_count + "개  "
								+ green_bubble_count * green_bubble_price + "원");
					} else {
						green_bubble_count++;
						greenBubble.setText(" 뺌 Green-bubbleT  |  " + String.valueOf(green_bubble_count) + "  |  "
								+ String.valueOf(green_bubble_count * 4000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.green_bubble_pay.setText("Green-bubbleT  " + green_bubble_count + "개  "
							+ green_bubble_count * green_bubble_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		// 케익
		cake_cheese_label.setBounds(140, 764, 145, 145);
		cake_cheese_label.setVerticalTextPosition(JLabel.CENTER);
		cake_cheese_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(cake_cheese_label);

		cake_strawberry_label.setBounds(140, 764, 145, 145);
		cake_strawberry_label.setVerticalTextPosition(JLabel.CENTER);
		cake_strawberry_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(cake_strawberry_label);
		cake_strawberry_label.setVisible(false);

		cake_chocolate_label.setBounds(140, 764, 145, 145);
		cake_chocolate_label.setVerticalTextPosition(JLabel.CENTER);
		cake_chocolate_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(cake_chocolate_label);
		cake_chocolate_label.setVisible(false);

		add_cake_cheese.setBounds(315, 765, 170, 40);
		add_cake_cheese.setFont(new Font("인터파크고딕 M", Font.PLAIN, 24));
		add_cake_cheese.setBorderPainted(false);
		add_cake_cheese.setBackground(new Color(255, 212, 250));
		add_cake_cheese.setFocusPainted(false);
		add(add_cake_cheese);
		add_cake_cheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cake_cheese_label.setVisible(true);
				cake_chocolate_label.setVisible(false);
				cake_strawberry_label.setVisible(false);
			}
		});
		add_cake_cheese.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(cheeseCake);
				if (e.getClickCount() == 2) {
					cheeseCake.setBounds(0, all_count * 70, 500, 50);
					cheeseCake.setHorizontalAlignment(JLabel.LEFT);
					cheeseCake.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					cheeseCake.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_cheese_cake = new JButton();
					minus_cheese_cake.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_cheese_cake.setBounds(10, 0, 30, 30);

					minus_cheese_cake.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_cheese_cake.setFocusPainted(false);
					minus_cheese_cake.setOpaque(false);
					minus_cheese_cake.setIcon(minus);
					cheeseCake.add(minus_cheese_cake);

					minus_cheese_cake.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cheese_cake_count--;
							cheeseCake.setText(" 뺌  Cheese-cake  |  " + String.valueOf(cheese_cake_count) + "  |  "
									+ String.valueOf(cheese_cake_count * 5000) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.cheese_cake_pay.setText("Cheese-cake  " + cheese_cake_count + "개  "
									+ cheese_cake_count * cheese_cake_price + "원");
							if (cheese_cake_count == 0) {
								OrderPanel.cheeseCake.setVisible(false);
							}
						}
					});
					cheeseCake.add(minus_cheese_cake);
					if (cheese_cake_count < 2) {
						cheese_cake_count++;
						cheeseCake.setText(" 뺌  Cheese-cake  |  " + String.valueOf(cheese_cake_count) + "  |  "
								+ String.valueOf(cheese_cake_count * 5000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.cheese_cake_pay.setText("Cheese-cake  " + cheese_cake_count + "개  "
								+ cheese_cake_count * cheese_cake_price + "원");
					} else {
						cheese_cake_count++;
						cheeseCake.setText(" 뺌  Cheese-cake  |  " + String.valueOf(cheese_cake_count) + "  |  "
								+ String.valueOf(cheese_cake_count * 5000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.cheese_cake_pay.setText(
							"Cheese-cake  " + cheese_cake_count + "개  " + cheese_cake_count * cheese_cake_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		add_cake_strawberry.setBounds(315, 815, 170, 40);
		add_cake_strawberry.setFont(new Font("인터파크고딕 M", Font.PLAIN, 24));
		add_cake_strawberry.setBorderPainted(false);
		add_cake_strawberry.setBackground(new Color(255, 212, 250));
		add_cake_strawberry.setFocusPainted(false);
		add(add_cake_strawberry);
		add_cake_strawberry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cake_cheese_label.setVisible(false);
				cake_strawberry_label.setVisible(true);
				cake_chocolate_label.setVisible(false);
			}
		});
		add_cake_strawberry.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(strayberryCake);
				if (e.getClickCount() == 2) {
					strayberryCake.setBounds(0, all_count * 70, 500, 50);
					strayberryCake.setHorizontalAlignment(JLabel.LEFT);
					strayberryCake.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					strayberryCake.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_strawberry_cake = new JButton();
					minus_strawberry_cake.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_strawberry_cake.setBounds(10, 0, 30, 30);

					minus_strawberry_cake.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_strawberry_cake.setFocusPainted(false);
					minus_strawberry_cake.setOpaque(false);
					minus_strawberry_cake.setIcon(minus);
					strayberryCake.add(minus_strawberry_cake);

					minus_strawberry_cake.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							strawberry_cake_count--;
							strayberryCake.setText(" 뺌  Strawberry-cake  |  " + String.valueOf(strawberry_cake_count)
									+ "  |  " + String.valueOf(strawberry_cake_count * 5000) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.strawberry_cake_pay.setText("Strawberry-cake  " + strawberry_cake_count
									+ "개  " + strawberry_cake_count * strawberry_cake_price + "원");
							if (strawberry_cake_count == 0) {
								OrderPanel.strayberryCake.setVisible(false);
							}
						}
					});
					strayberryCake.add(minus_strawberry_cake);
					if (strawberry_cake_count < 2) {
						strawberry_cake_count++;
						strayberryCake.setText(" 뺌  Strawberry-cake  |  " + String.valueOf(strawberry_cake_count)
								+ "  |  " + String.valueOf(strawberry_cake_count * 5000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.strawberry_cake_pay.setText("Strawberry-cake  " + strawberry_cake_count + "개  "
								+ strawberry_cake_count * strawberry_cake_price + "원");
					} else {
						strawberry_cake_count++;
						strayberryCake.setText(" 뺌  Strawberry-cake  |  " + String.valueOf(strawberry_cake_count)
								+ "  |  " + String.valueOf(strawberry_cake_count * 5000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.strawberry_cake_pay.setText("Strawberry-cake  " + strawberry_cake_count + "개  "
							+ strawberry_cake_count * strawberry_cake_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		add_cake_chocolate.setBounds(315, 865, 170, 40);
		add_cake_chocolate.setFont(new Font("인터파크고딕 M", Font.PLAIN, 24));
		add_cake_chocolate.setBorderPainted(false);
		add_cake_chocolate.setBackground(new Color(255, 212, 250));
		add_cake_chocolate.setFocusPainted(false);
		add(add_cake_chocolate);
		add_cake_chocolate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cake_cheese_label.setVisible(false);
				cake_strawberry_label.setVisible(false);
				cake_chocolate_label.setVisible(true);
			}
		});
		add_cake_chocolate.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(chocolateCake);
				if (e.getClickCount() == 2) {
					chocolateCake.setBounds(0, all_count * 70, 500, 50);
					chocolateCake.setHorizontalAlignment(JLabel.LEFT);
					chocolateCake.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					chocolateCake.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_chocolate_cake = new JButton();
					minus_chocolate_cake.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_chocolate_cake.setBounds(10, 0, 30, 30);

					minus_chocolate_cake.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_chocolate_cake.setFocusPainted(false);
					minus_chocolate_cake.setOpaque(false);
					minus_chocolate_cake.setIcon(minus);
					chocolateCake.add(minus_chocolate_cake);

					minus_chocolate_cake.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							chocolate_cake_count--;
							chocolateCake.setText(" 뺌 Chocolate-cake  |  " + String.valueOf(chocolate_cake_count)
									+ "  |  " + String.valueOf(chocolate_cake_count * 5000) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.chocolate_cake_pay.setText("Chocolate-cake  " + chocolate_cake_count
									+ "개  " + chocolate_cake_count * chocolate_cake_price + "원");
							if (chocolate_cake_count == 0) {
								OrderPanel.chocolateCake.setVisible(false);
							}
						}
					});
					chocolateCake.add(minus_chocolate_cake);
					if (chocolate_cake_count < 2) {
						chocolate_cake_count++;
						chocolateCake.setText(" 뺌 Chocolate-cake  |  " + String.valueOf(chocolate_cake_count) + "  |  "
								+ String.valueOf(chocolate_cake_count * 5000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.chocolate_cake_pay.setText("Chocolate-cake  " + chocolate_cake_count + "개  "
								+ chocolate_cake_count * chocolate_cake_price + "원");
					} else {
						chocolate_cake_count++;
						chocolateCake.setText(" 뺌 Chocolate-cake  |  " + String.valueOf(chocolate_cake_count) + "  |  "
								+ String.valueOf(chocolate_cake_count * 5000) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.chocolate_cake_pay.setText("Chocolate-cake  " + chocolate_cake_count + "개  "
							+ chocolate_cake_count * chocolate_cake_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		// 마카롱
		macaron_berry_label.setBounds(590, 764, 145, 145);
		macaron_berry_label.setVerticalTextPosition(JLabel.CENTER);
		macaron_berry_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(macaron_berry_label);

		macaron_yogurt_label.setBounds(590, 764, 145, 145);
		macaron_yogurt_label.setVerticalTextPosition(JLabel.CENTER);
		macaron_yogurt_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(macaron_yogurt_label);
		macaron_yogurt_label.setVisible(false);

		macaron_fruit_label.setBounds(590, 764, 145, 145);
		macaron_fruit_label.setVerticalTextPosition(JLabel.CENTER);
		macaron_fruit_label.setHorizontalTextPosition(JLabel.RIGHT);
		add(macaron_fruit_label);
		macaron_fruit_label.setVisible(false);

		add_macaron_berry.setBounds(775, 765, 140, 40);
		add_macaron_berry.setFont(new Font("인터파크고딕 M", Font.PLAIN, 24));
		add_macaron_berry.setBorderPainted(false);
		add_macaron_berry.setBackground(new Color(243, 201, 255));
		add_macaron_berry.setFocusPainted(false);
		add(add_macaron_berry);
		add_macaron_berry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				macaron_berry_label.setVisible(true);
			}
		});
		add_macaron_berry.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(berryMacaron);
				if (e.getClickCount() == 2) {
					berryMacaron.setBounds(0, all_count * 70, 500, 50);
					berryMacaron.setHorizontalAlignment(JLabel.LEFT);
					berryMacaron.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					berryMacaron.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_berry_macaron = new JButton();
					minus_berry_macaron.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_berry_macaron.setBounds(10, 0, 30, 30);

					minus_berry_macaron.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_berry_macaron.setFocusPainted(false);
					minus_berry_macaron.setOpaque(false);
					minus_berry_macaron.setIcon(minus);
					berryMacaron.add(minus_berry_macaron);

					minus_berry_macaron.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							berry_macaron_count--;
							berryMacaron.setText(" 뺌 Berry-macaron  |  " + String.valueOf(berry_macaron_count) + "  |  "
									+ String.valueOf(berry_macaron_count * 2500) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.berry_macaron_pay.setText("Berry-macaron  " + berry_macaron_count + "개  "
									+ berry_macaron_count * berry_macaron_price + "원");
							if (berry_macaron_count == 0) {
								OrderPanel.berryMacaron.setVisible(false);
							}
						}
					});
					berryMacaron.add(minus_berry_macaron);
					if (berry_macaron_count < 2) {
						berry_macaron_count++;
						berryMacaron.setText(" 뺌 Berry-macaron  |  " + String.valueOf(berry_macaron_count) + "  |  "
								+ String.valueOf(berry_macaron_count * 2500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.berry_macaron_pay.setText("Berry-macaron  " + berry_macaron_count + "개  "
								+ berry_macaron_count * berry_macaron_price + "원");
					} else {
						berry_macaron_count++;
						berryMacaron.setText(" 뺌 Berry-macaron  |  " + String.valueOf(berry_macaron_count) + "  |  "
								+ String.valueOf(berry_macaron_count * 200) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.berry_macaron_pay.setText("Berry-macaron  " + berry_macaron_count + "개  "
							+ berry_macaron_count * berry_macaron_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		add_macaron_yogurt.setBounds(775, 815, 140, 40);
		add_macaron_yogurt.setFont(new Font("인터파크고딕 M", Font.PLAIN, 24));
		add_macaron_yogurt.setBorderPainted(false);
		add_macaron_yogurt.setBackground(new Color(243, 201, 255));
		add_macaron_yogurt.setFocusPainted(false);
		add(add_macaron_yogurt);
		add_macaron_yogurt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				macaron_berry_label.setVisible(false);
				macaron_yogurt_label.setVisible(true);
				macaron_fruit_label.setVisible(false);
			}
		});
		add_macaron_yogurt.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(yogurtMacaron);
				if (e.getClickCount() == 2) {
					yogurtMacaron.setBounds(0, all_count * 70, 500, 50);
					yogurtMacaron.setHorizontalAlignment(JLabel.LEFT);
					yogurtMacaron.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					yogurtMacaron.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_yogurt_macaron = new JButton();
					minus_yogurt_macaron.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_yogurt_macaron.setBounds(10, 0, 30, 30);

					minus_yogurt_macaron.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_yogurt_macaron.setFocusPainted(false);
					minus_yogurt_macaron.setOpaque(false);
					minus_yogurt_macaron.setIcon(minus);
					yogurtMacaron.add(minus_yogurt_macaron);

					minus_yogurt_macaron.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							yogurt_macaron_count--;
							yogurtMacaron.setText(" 뺌 Yogurt-macaron  |  " + String.valueOf(yogurt_macaron_count)
									+ "  |  " + String.valueOf(yogurt_macaron_count * 2500) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.yogurt_macaron_pay.setText("Yogurt-macaron  " + yogurt_macaron_count
									+ "개  " + yogurt_macaron_count * yogurt_macaron_price + "원");
							if (yogurt_macaron_count == 0) {
								OrderPanel.yogurtMacaron.setVisible(false);
							}
						}
					});
					yogurtMacaron.add(minus_yogurt_macaron);
					if (yogurt_macaron_count < 2) {
						yogurt_macaron_count++;
						yogurtMacaron.setText(" 뺌 Yogurt-macaron  |  " + String.valueOf(yogurt_macaron_count) + "  |  "
								+ String.valueOf(yogurt_macaron_count * 2500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.yogurt_macaron_pay.setText("Yogurt-macaron  " + yogurt_macaron_count + "개  "
								+ yogurt_macaron_count * yogurt_macaron_price + "원");
					} else {
						yogurt_macaron_count++;
						yogurtMacaron.setText(" 뺌 Yogurt-macaron  |  " + String.valueOf(yogurt_macaron_count) + "  |  "
								+ String.valueOf(yogurt_macaron_count * 2500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.yogurt_macaron_pay.setText("Yogurt-macaron  " + yogurt_macaron_count + "개  "
							+ yogurt_macaron_count * yogurt_macaron_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		add_macaron_fruit.setBounds(775, 865, 140, 40);
		add_macaron_fruit.setFont(new Font("인터파크고딕 M", Font.PLAIN, 24));
		add_macaron_fruit.setBorderPainted(false);
		add_macaron_fruit.setBackground(new Color(243, 201, 255));
		add_macaron_fruit.setFocusPainted(false);
		add(add_macaron_fruit);
		add_macaron_fruit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				macaron_berry_label.setVisible(false);
				macaron_yogurt_label.setVisible(false);
				macaron_fruit_label.setVisible(true);
			}
		});
		add_macaron_fruit.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (OrderPanel.all_count == 0) {
//					space.setText("========================");
//					space.setBackground(Color.RED);
//					space.setBounds(0, 0, 500, 50);
					OrderPanel.getOrder_list().add(space);
				}
				OrderPanel.getOrder_list().add(fruitMacaron);
				if (e.getClickCount() == 2) {
					fruitMacaron.setBounds(0, all_count * 70, 500, 50);
					fruitMacaron.setHorizontalAlignment(JLabel.LEFT);
					fruitMacaron.setFont(new Font("인터파크고딕 M", Font.PLAIN, 30));
					fruitMacaron.setVisible(true);

					ImageIcon minus = new ImageIcon("images/minus.png");

					JButton minus_fruit_macaron = new JButton();
					minus_fruit_macaron.setFont(new Font("인터파크고딕 L", Font.PLAIN, 20));
					minus_fruit_macaron.setBounds(10, 0, 30, 30);

					minus_fruit_macaron.setBorderPainted(false); // 테두리색
//					minus_ice_coffee.setContentAreaFilled(false);
					minus_fruit_macaron.setFocusPainted(false);
					minus_fruit_macaron.setOpaque(false);
					minus_fruit_macaron.setIcon(minus);
					fruitMacaron.add(minus_fruit_macaron);

					minus_fruit_macaron.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							fruit_macaron_count--;
							fruitMacaron.setText(" 뺌 Fruit-macaron  |  " + String.valueOf(fruit_macaron_count) + "  |  "
									+ String.valueOf(fruit_macaron_count * 2500) + "원");
							all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
									+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
									+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
									+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
									+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
									+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
									+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
									+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
									+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
									+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
									+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
									+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
									+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
									+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
									+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
									+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
									+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
									+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
							price_sum.setText("결제금액 : " + all_price + "원");
							Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
							PaySuccessDetail.fruit_macaron_pay.setText("Fruit-macaron  " + fruit_macaron_count + "개  "
									+ fruit_macaron_count * fruit_macaron_price + "원");
							if (fruit_macaron_count == 0) {
								OrderPanel.fruitMacaron.setVisible(false);
							}
						}
					});
					fruitMacaron.add(minus_fruit_macaron);
					if (fruit_macaron_count < 2) {
						fruit_macaron_count++;
						fruitMacaron.setText(" 뺌 Fruit-macaron  |  " + String.valueOf(fruit_macaron_count) + "  |  "
								+ String.valueOf(fruit_macaron_count * 2500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
						PaySuccessDetail.fruit_macaron_pay.setText("Fruit-macaron  " + fruit_macaron_count + "개  "
								+ fruit_macaron_count * fruit_macaron_price + "원");
					} else {
						fruit_macaron_count++;
						fruitMacaron.setText(" 뺌 Fruit-macaron  |  " + String.valueOf(fruit_macaron_count) + "  |  "
								+ String.valueOf(fruit_macaron_count * 2500) + "원");
						all_price = OrderPanel.ice_coffee_count * OrderPanel.ice_coffee_price
								+ OrderPanel.hot_coffee_count * OrderPanel.hot_coffee_price
								+ OrderPanel.orange_smoothie_count * OrderPanel.orange_smoothie_price
								+ OrderPanel.kiwi_smoothie_count * OrderPanel.kiwi_smoothie_price
								+ OrderPanel.grape_smoothie_count * OrderPanel.grape_smoothie_price
								+ OrderPanel.strawberry_smoothie_count * OrderPanel.strawberry_smoothie_price
								+ OrderPanel.watermelon_smoothie_count * OrderPanel.watermelon_smoothie_price
								+ OrderPanel.black_tea_count * OrderPanel.black_tea_price
								+ OrderPanel.green_tea_count * OrderPanel.green_tea_price
								+ OrderPanel.brown_sugar_bubble_count * OrderPanel.brown_sugar_bubble_price
								+ OrderPanel.taro_bubble_count * OrderPanel.taro_bubble_price
								+ OrderPanel.green_bubble_count * OrderPanel.green_bubble_price
								+ OrderPanel.cheese_cake_count * OrderPanel.cheese_cake_price
								+ OrderPanel.strawberry_cake_count * OrderPanel.strawberry_cake_price
								+ OrderPanel.chocolate_cake_count * OrderPanel.chocolate_cake_price
								+ OrderPanel.berry_macaron_count * OrderPanel.berry_macaron_price
								+ OrderPanel.yogurt_macaron_count * OrderPanel.yogurt_macaron_price
								+ OrderPanel.fruit_macaron_count * OrderPanel.fruit_macaron_price;
						price_sum.setText("결제금액 : " + all_price + "원");
						Payment.pay_price_sum.setText(OrderPanel.price_sum.getText());
					}
					PaySuccessDetail.fruit_macaron_pay.setText("Fruit-macaron  " + fruit_macaron_count + "개  "
							+ fruit_macaron_count * fruit_macaron_price + "원");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
	}

	public static OrderList getOrder_list() {
		return order_list;
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

//class PaymentExitBtn extends JButton {
//	PaymentExitBtn() {
//		setBounds(1160, 840, 157, 50);
//		setVisible(true);
//		setBackground(Color.BLUE);
////		setBorderPainted(false);
////		setContentAreaFilled(false);
////		setFocusPainted(false);
////		setOpaque(false);
//		
//		addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Main.MainFrame.getOrder_panel().setVisible(true);
//				Main.MainFrame.getPayment_panel().setVisible(false);
//			}
//		});
//	}
//}
//class PaySuccessBtn extends JButton{
//	PaySuccessBtn(){
//		setBounds(900, 840, 157, 50);
//		setVisible(true);
//		setBackground(Color.RED);
////		setBorderPainted(false);
////		setContentAreaFilled(false);
////		setFocusPainted(false);
////		setOpaque(false);
//
//		addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(OrderPanel.ice_coffee_count > 0) {
//					PaySuccessDetail.ice_coffee_pay.setVisible(true);
//				}
//				if(OrderPanel.hot_coffee_count > 0) {
//					PaySuccessDetail.hot_coffee_pay.setVisible(true);
//				}
//				if(OrderPanel.orange_smoothie_count > 0) {
//					PaySuccessDetail.orange_smoo_pay.setVisible(true);
//				}
//				if(OrderPanel.kiwi_smoothie_count > 0) {
//					PaySuccessDetail.kiwi_smoo_pay.setVisible(true);
//				}
//				if(OrderPanel.grape_smoothie_count > 0) {
//					PaySuccessDetail.grape_smoo_pay.setVisible(true);
//				}
//				if(OrderPanel.strawberry_smoothie_count > 0) {
//					PaySuccessDetail.strawberry_smoo_pay.setVisible(true);
//				}
//				if(OrderPanel.watermelon_smoothie_count > 0) {
//					PaySuccessDetail.watermelon_smoo_pay.setVisible(true);
//				}
//				if(OrderPanel.black_tea_count > 0) {
//					PaySuccessDetail.black_tea_pay.setVisible(true);
//				}
//				if(OrderPanel.green_tea_count > 0) {
//					PaySuccessDetail.green_tea_pay.setVisible(true);
//				}
//				if(OrderPanel.brown_sugar_bubble_count > 0) {
//					PaySuccessDetail.brown_bubble_pay.setVisible(true);
//				}
//				if(OrderPanel.taro_bubble_count > 0) {
//					PaySuccessDetail.taro_bubble_pay.setVisible(true);
//				}
//				if(OrderPanel.green_bubble_count > 0) {
//					PaySuccessDetail.green_bubble_pay.setVisible(true);
//				}
//				if(OrderPanel.cheese_cake_count > 0) {
//					PaySuccessDetail.cheese_cake_pay.setVisible(true);
//				}
//				if(OrderPanel.strawberry_cake_count > 0) {
//					PaySuccessDetail.strawberry_cake_pay.setVisible(true);
//				}
//				if(OrderPanel.chocolate_cake_count > 0) {
//					PaySuccessDetail.chocolate_cake_pay.setVisible(true);
//				}
//				if(OrderPanel.berry_macaron_count > 0) {
//					PaySuccessDetail.berry_macaron_pay.setVisible(true);
//				}
//				if(OrderPanel.yogurt_macaron_count > 0) {
//					PaySuccessDetail.yogurt_macaron_pay.setVisible(true);
//				}
//				if(OrderPanel.fruit_macaron_count > 0) {
//					PaySuccessDetail.fruit_macaron_pay.setVisible(true);
//				}
//				Main.MainFrame.getPay_success_panel().setVisible(true);
//				Main.MainFrame.getPayment_panel().setVisible(false);
//				// 커피
//				OrderPanel.ice_coffee_count = 0;
//				OrderPanel.hot_coffee_count = 0;
//				//스무디
//				OrderPanel.orange_smoothie_count = 0;
//				OrderPanel.kiwi_smoothie_count = 0;
//				OrderPanel.grape_smoothie_count = 0;
//				OrderPanel.strawberry_smoothie_count = 0;
//				OrderPanel.watermelon_smoothie_count = 0;
//				// 차
//				OrderPanel.black_tea_count = 0;
//				OrderPanel.green_tea_count = 0;
//				// 버블티
//				OrderPanel.brown_sugar_bubble_count = 0;
//				OrderPanel.taro_bubble_count = 0;
//				OrderPanel.green_bubble_count = 0;
//				// 케이크
//				OrderPanel.cheese_cake_count = 0;
//				OrderPanel.strawberry_cake_count = 0;
//				OrderPanel.chocolate_cake_count = 0;
//				// 마카롱
//				OrderPanel.berry_macaron_count = 0;
//				OrderPanel.yogurt_macaron_count = 0;
//				OrderPanel.fruit_macaron_count = 0;
//			}
//		});
//	}
//}
class Payment extends JPanel {
	static PaymentTextCount payment_text_count = new PaymentTextCount();

	static Timer t2 = new Timer(payment_text_count);
	static Thread td2 = new Thread(t2);

	ImageIcon background = new ImageIcon("images/background_11.png"); // 배경사진은 class못만들어서 그냥 넣음
//	PaymentExitBtn payment_exit_btn = new PaymentExitBtn();
//	PaySuccessBtn pay_success_btn = new PaySuccessBtn();
	static PriceSum pay_price_sum = new PriceSum();
	static TextField pay_text = new TextField();

	Payment() {

		setBounds(0, 0, 1862, 1055);
		setLayout(null);
		setVisible(false);
		setBackground(new Color(112, 151, 168));
		setForeground(Color.white);

		pay_price_sum.setForeground(new Color(255, 93, 82));
		pay_price_sum.setBounds(670, 560, 500, 100);
		pay_price_sum.setFont(new Font("인터파크고딕 M", Font.PLAIN, 60));

		pay_text.setBounds(500, 500, 0, 0);
		pay_text.setVisible(true);

		add(pay_price_sum);
		add(payment_text_count);
//		add(payment_exit_btn);
//		add(pay_success_btn);
		add(pay_text);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

	public static Thread getTd2() {
		return td2;
	}
}

class PaymentTextCount extends JLabel {
	public PaymentTextCount() {
		setBounds(740, 290, 300, 150);
		setVisible(true);
		setForeground(Color.black);
		setFont(new Font("인터파크고딕 B", Font.PLAIN, 160));
		setHorizontalAlignment(JLabel.CENTER);
	}
}

class Timer implements Runnable {
	private JLabel timerLabel;

	static int n = 10;

	public Timer(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	@Override
	public void run() {
		while (true) {
			timerLabel.setText(Integer.toString(n));
			n--;
			try {
				Thread.sleep(1000); // 1/1000초 단위
			} catch (InterruptedException e) {
				return;
			}
			if (n == -1) {
				Main.MainFrame.getPay_success_panel().setVisible(true);
				Main.MainFrame.getPayment_panel().setVisible(false);
				if (OrderPanel.ice_coffee_count > 0) {
					PaySuccessDetail.ice_coffee_pay.setVisible(true);
				}
				if (OrderPanel.hot_coffee_count > 0) {
					PaySuccessDetail.hot_coffee_pay.setVisible(true);
				}
				if (OrderPanel.orange_smoothie_count > 0) {
					PaySuccessDetail.orange_smoo_pay.setVisible(true);
				}
				if (OrderPanel.kiwi_smoothie_count > 0) {
					PaySuccessDetail.kiwi_smoo_pay.setVisible(true);
				}
				if (OrderPanel.grape_smoothie_count > 0) {
					PaySuccessDetail.grape_smoo_pay.setVisible(true);
				}
				if (OrderPanel.strawberry_smoothie_count > 0) {
					PaySuccessDetail.strawberry_smoo_pay.setVisible(true);
				}
				if (OrderPanel.watermelon_smoothie_count > 0) {
					PaySuccessDetail.watermelon_smoo_pay.setVisible(true);
				}
				if (OrderPanel.black_tea_count > 0) {
					PaySuccessDetail.black_tea_pay.setVisible(true);
				}
				if (OrderPanel.green_tea_count > 0) {
					PaySuccessDetail.green_tea_pay.setVisible(true);
				}
				if (OrderPanel.brown_sugar_bubble_count > 0) {
					PaySuccessDetail.brown_bubble_pay.setVisible(true);
				}
				if (OrderPanel.taro_bubble_count > 0) {
					PaySuccessDetail.taro_bubble_pay.setVisible(true);
				}
				if (OrderPanel.green_bubble_count > 0) {
					PaySuccessDetail.green_bubble_pay.setVisible(true);
				}
				if (OrderPanel.cheese_cake_count > 0) {
					PaySuccessDetail.cheese_cake_pay.setVisible(true);
				}
				if (OrderPanel.strawberry_cake_count > 0) {
					PaySuccessDetail.strawberry_cake_pay.setVisible(true);
				}
				if (OrderPanel.chocolate_cake_count > 0) {
					PaySuccessDetail.chocolate_cake_pay.setVisible(true);
				}
				if (OrderPanel.berry_macaron_count > 0) {
					PaySuccessDetail.berry_macaron_pay.setVisible(true);
				}
				if (OrderPanel.yogurt_macaron_count > 0) {
					PaySuccessDetail.yogurt_macaron_pay.setVisible(true);
				}
				if (OrderPanel.fruit_macaron_count > 0) {
					PaySuccessDetail.fruit_macaron_pay.setVisible(true);
				}
				// 커피
				OrderPanel.ice_coffee_count = 0;
				OrderPanel.hot_coffee_count = 0;
				// 스무디
				OrderPanel.orange_smoothie_count = 0;
				OrderPanel.kiwi_smoothie_count = 0;
				OrderPanel.grape_smoothie_count = 0;
				OrderPanel.strawberry_smoothie_count = 0;
				OrderPanel.watermelon_smoothie_count = 0;
				// 차
				OrderPanel.black_tea_count = 0;
				OrderPanel.green_tea_count = 0;
				// 버블티
				OrderPanel.brown_sugar_bubble_count = 0;
				OrderPanel.taro_bubble_count = 0;
				OrderPanel.green_bubble_count = 0;
				// 케이크
				OrderPanel.cheese_cake_count = 0;
				OrderPanel.strawberry_cake_count = 0;
				OrderPanel.chocolate_cake_count = 0;
				// 마카롱
				OrderPanel.berry_macaron_count = 0;
				OrderPanel.yogurt_macaron_count = 0;
				OrderPanel.fruit_macaron_count = 0;

				try {
					n = 10;
					synchronized (Payment.td2) {
						Payment.td2.wait();
					}
				} catch (InterruptedException e) {
					System.out.println("스레드 멈춤");
				}
			}
			if (n <= 3) {
				Payment.payment_text_count.setForeground(Color.RED);
			}
		}
	}
}

class OrderList extends JPanel {
	static OrderDetails jumon_1 = new OrderDetails();
	static OrderDetails jumon_2 = new OrderDetails();
	static OrderDetails jumon_3 = new OrderDetails();
	static OrderDetails jumon_4 = new OrderDetails();
	static OrderDetails jumon_5 = new OrderDetails();
	static OrderDetails jumon_6 = new OrderDetails();
	static OrderDetails jumon_7 = new OrderDetails();
	static OrderDetails jumon_8 = new OrderDetails();
	static OrderDetails jumon_9 = new OrderDetails();
	static OrderDetails jumon_10 = new OrderDetails();
	static OrderDetails jumon_11 = new OrderDetails();
	static OrderDetails jumon_12 = new OrderDetails();
	static OrderDetails jumon_13 = new OrderDetails();
	static OrderDetails jumon_14 = new OrderDetails();
	static OrderDetails jumon_15 = new OrderDetails();
	static OrderDetails jumon_16 = new OrderDetails();
	static OrderDetails jumon_17 = new OrderDetails();
	static OrderDetails jumon_18 = new OrderDetails();
	static OrderDetails jumon_19 = new OrderDetails();

	OrderList() {
		setBounds(1140, 175, 570, 610);
		setVisible(true);
		setBackground(Color.WHITE);

		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.LEADING);
		setLayout(fl);
	}

	public static OrderDetails getJumon_1() {
		return jumon_1;
	}

	public static OrderDetails getJumon_2() {
		return jumon_2;
	}

	public static OrderDetails getJumon_3() {
		return jumon_3;
	}

	public static OrderDetails getJumon_4() {
		return jumon_4;
	}

	public static OrderDetails getJumon_5() {
		return jumon_5;
	}

	public static OrderDetails getJumon_6() {
		return jumon_6;
	}

	public static OrderDetails getJumon_7() {
		return jumon_7;
	}

	public static OrderDetails getJumon_8() {
		return jumon_8;
	}

	public static OrderDetails getJumon_9() {
		return jumon_9;
	}

	public static OrderDetails getJumon_10() {
		return jumon_10;
	}

	public static OrderDetails getJumon_11() {
		return jumon_11;
	}

	public static OrderDetails getJumon_12() {
		return jumon_12;
	}

	public static OrderDetails getJumon_13() {
		return jumon_13;
	}

	public static OrderDetails getJumon_14() {
		return jumon_14;
	}

	public static OrderDetails getJumon_15() {
		return jumon_15;
	}

	public static OrderDetails getJumon_16() {
		return jumon_16;
	}

	public static OrderDetails getJumon_17() {
		return jumon_17;
	}

	public static OrderDetails getJumon_18() {
		return jumon_18;
	}

	public static OrderDetails getJumon_19() {
		return jumon_19;
	}
}

class OrderDetails extends JLabel {
	OrderDetails() {
//		setBounds(0, 70*(OrderPanel.ice_coffee_count + OrderPanel.hot_coffee_count + OrderPanel.orange_smoothie_count + OrderPanel.kiwi_smoothie_count + OrderPanel.grape_smoothie_count + OrderPanel.strawberry_smoothie_count + OrderPanel.watermelon_smoothie_count), 700, 100);
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 28));
		setVisible(true);
		setHorizontalAlignment(JLabel.LEFT);
	}
}

class PriceSum extends JLabel {
	PriceSum() {
		setVisible(true);
		setBounds(1330, 750, 300, 100);
		setText("결제금액 : 0원");
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 33));
	}
}

class PaySuccessPanel extends JPanel {
	ImageIcon background_2 = new ImageIcon("images/background_21.png");
	TextField pay_text = new TextField();
	PaySuccessDetail pay_success_detail = new PaySuccessDetail();

	JButton exit = new JButton();

	PaySuccessPanel() {

		setVisible(true);
		setBounds(0, 0, 1862, 1055);
		setLayout(null);

		exit.setVisible(true);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);
		exit.setOpaque(false);
		exit.setBounds(815, 930, 200, 70);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getPayment_panel().setVisible(false);
				Main.MainFrame.getPay_success_panel().setVisible(false);
				Main.MainFrame.getMain_panel().setVisible(true);
				OrderPanel.getOrder_list().removeAll();
			}
		});

		add(pay_success_detail);
		add(exit);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background_2.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}

class PaySuccessDetail extends JPanel {
	// 커피
	static PaySuccessLabel ice_coffee_pay = new PaySuccessLabel("images/ice_coffee_small.png");
	static PaySuccessLabel hot_coffee_pay = new PaySuccessLabel("images/hot_coffee_small.png");
	// 스무디
	static PaySuccessLabel orange_smoo_pay = new PaySuccessLabel("images/orange_juice_small.png");
	static PaySuccessLabel kiwi_smoo_pay = new PaySuccessLabel("images/kiwi_juice_small.png");
	static PaySuccessLabel grape_smoo_pay = new PaySuccessLabel("images/grape_juice_small.png");
	static PaySuccessLabel strawberry_smoo_pay = new PaySuccessLabel("images/strawberry_juice_small.png");
	static PaySuccessLabel watermelon_smoo_pay = new PaySuccessLabel("images/watermelon_juice_small.png");
	// 차
	static PaySuccessLabel black_tea_pay = new PaySuccessLabel("images/tea_hong_small.png");
	static PaySuccessLabel green_tea_pay = new PaySuccessLabel("images/tea_green_small.png");
	// 버블티
	static PaySuccessLabel brown_bubble_pay = new PaySuccessLabel("images/bubble_tea_brown_small.png");
	static PaySuccessLabel taro_bubble_pay = new PaySuccessLabel("images/bubble_tea_taro_small.png");
	static PaySuccessLabel green_bubble_pay = new PaySuccessLabel("images/bubble_tea_green_small.png");
	// 케이크
	static PaySuccessLabel cheese_cake_pay = new PaySuccessLabel("images/cake_cheese_small.png");
	static PaySuccessLabel strawberry_cake_pay = new PaySuccessLabel("images/cake_strawberry_small.png");
	static PaySuccessLabel chocolate_cake_pay = new PaySuccessLabel("images/cake_chocolate_small.png");
	// 마카롱
	static PaySuccessLabel berry_macaron_pay = new PaySuccessLabel("images/macaron_berry_small.png");
	static PaySuccessLabel yogurt_macaron_pay = new PaySuccessLabel("images/macaron_yogurt_small.png");
	static PaySuccessLabel fruit_macaron_pay = new PaySuccessLabel("images/macaron_fruit_small.png");

	PaySuccessDetail() {
		setVisible(true);
		setBackground(Color.WHITE);
		setBounds(600, 220, 650, 700);
		setLayout(new FlowLayout());

		add(ice_coffee_pay);
		add(hot_coffee_pay);
		add(orange_smoo_pay);
		add(kiwi_smoo_pay);
		add(grape_smoo_pay);
		add(strawberry_smoo_pay);
		add(watermelon_smoo_pay);
		add(black_tea_pay);
		add(green_tea_pay);
		add(brown_bubble_pay);
		add(taro_bubble_pay);
		add(green_bubble_pay);
		add(cheese_cake_pay);
		add(strawberry_cake_pay);
		add(chocolate_cake_pay);
		add(berry_macaron_pay);
		add(yogurt_macaron_pay);
		add(fruit_macaron_pay);
	}
}

class PaySuccessLabel extends JLabel {
	PaySuccessLabel(String string) {
		ImageIcon i = new ImageIcon(string);
		setIcon(i);
		setVisible(false);
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 35));
	}
}

class ChoiceArea extends JPanel {
	static ArrayList<String> area_names = new ArrayList<String>(Arrays.asList("...", "부산", "대구", "울산", "경주", "창원"));

	ArrayList<String> busan_stores_name = new ArrayList<String>(Arrays.asList("부산해운대점", "부산진장점", "부산꼭두각시점"));
	ArrayList<String> daegu_stores_name = new ArrayList<String>(
			Arrays.asList("대구해운대점", "대구진장점", "대구꼭두각시점", "대구명성푸르지오점"));
	ArrayList<String> ulsan_stores_name = new ArrayList<String>(
			Arrays.asList("울산해운대점", "울산진장점", "울산꼭두각시점", "울산천상점", "울산삼산점"));
	ArrayList<String> kyeongju_stores_name = new ArrayList<String>(Arrays.asList("경주해운대점", "경주진장점"));
	ArrayList<String> changwon_stores_name = new ArrayList<String>(Arrays.asList("창원해운대점", "창원진장점", "창원꼭두각시점"));

	ImageIcon background = new ImageIcon("images/choice_1.png");

	static ChoiceBtn area_choice_btn = new ChoiceBtn();
	static ExitBtn area_exit_btn = new ExitBtn();
	
	static Choice store_combobox;

	static Choice area_combobox = new Choice(area_names.toArray(new String[area_names.size()]));

	static String choisen_area, choisen_store;
	
	static ChoiceLabel area_choice_label = new ChoiceLabel("지역을 선택해 주세요");
	static ChoiceLabel store_choice_label = new ChoiceLabel("지점을 선택해 주세요");
	
	ChoiceArea() {
		setBounds(0, 0, 1862, 1055);
		setLayout(null);

		add(area_combobox);
		add(area_choice_btn);
		add(area_exit_btn);
		add(area_choice_label);
				
		area_combobox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choisen_area = area_combobox.getSelectedItem().toString();		
				area_choice_label.setText(choisen_area + "이(가) 선택되었습니다");
			}
		});
		
		area_choice_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;

				if (choisen_area == "부산") {
					store_combobox = new Choice(busan_stores_name.toArray(new String[area_names.size()]));
					Main.MainFrame.getChoice_store_panel().add(store_combobox);
					flag = true;
				} else if (choisen_area == "대구") {
					store_combobox = new Choice(daegu_stores_name.toArray(new String[area_names.size()]));
					Main.MainFrame.getChoice_store_panel().add(store_combobox);
					flag = true;
				} else if (choisen_area == "울산") {
					store_combobox = new Choice(ulsan_stores_name.toArray(new String[area_names.size()]));
					Main.MainFrame.getChoice_store_panel().add(store_combobox);
					flag = true;
				} else if (choisen_area == "경주") {
					store_combobox = new Choice(kyeongju_stores_name.toArray(new String[area_names.size()]));
					Main.MainFrame.getChoice_store_panel().add(store_combobox);
					flag = true;
				} else if (choisen_area == "창원") {
					store_combobox = new Choice(changwon_stores_name.toArray(new String[area_names.size()]));
					Main.MainFrame.getChoice_store_panel().add(store_combobox);
					flag = true;
				} else {
					JOptionPane.showMessageDialog(null, "지역을 선택해주세요", "지역선택오류", JOptionPane.ERROR_MESSAGE);
				}
				if (flag == true) {
					Main.MainFrame.getChoice_area_panel().setVisible(false);
					Main.MainFrame.getChoice_store_panel().setVisible(true);
					store_combobox.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								choisen_store = ChoiceArea.store_combobox.getSelectedItem().toString();
								store_choice_label.setText(choisen_store + "이(가) 선택되었습니다");
							}catch(NullPointerException e1) {
								JOptionPane.showMessageDialog(null, "잘못된 지점을 선택했습니다", "지점 선택 오류", JOptionPane.ERROR_MESSAGE);
							}
							
						}
					});
				}
			}
		});
		area_exit_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getChoice_area_panel().setVisible(false);
				Main.MainFrame.getMain_panel().setVisible(true);
				area_combobox.setSelectedIndex(0);
				ChoiceArea.area_choice_label.setText("지역을 선택해 주세요");
				ChoiceArea.store_choice_label.setText("지점을 선택해 주세요");
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}

class ChoiceStore extends JPanel {
	ImageIcon background = new ImageIcon("images/choice_2.png");

	static ChoiceBtn store_choice_btn = new ChoiceBtn();
	static ExitBtn store_exit_btn = new ExitBtn();
	
	ChoiceStore() {
		setBounds(0, 0, 1862, 1055);
		setLayout(null);
		
		add(store_choice_btn);
		add(store_exit_btn);
		add(ChoiceArea.store_choice_label);
		
		store_choice_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getOrder_panel().setVisible(true);
				Main.MainFrame.getChoice_store_panel().setVisible(false);
				// String에 저장시키기========================================================================================================================
				OrderPanel.which.setText(ChoiceArea.choisen_store);				
				Main.MainFrame.getChoice_store_panel().remove(ChoiceArea.store_combobox);
				ChoiceArea.area_combobox.setSelectedIndex(0);		
				ChoiceArea.store_combobox.setSelectedIndex(0);
				ChoiceArea.area_choice_label.setText("지역을 선택해 주세요");
				ChoiceArea.store_choice_label.setText("지점을 선택해 주세요");
			}
		});
		store_exit_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getChoice_area_panel().setVisible(true);
				Main.MainFrame.getChoice_store_panel().setVisible(false);
				Main.MainFrame.getChoice_store_panel().remove(ChoiceArea.store_combobox);
				ChoiceArea.area_combobox.setSelectedIndex(0);		
				ChoiceArea.store_combobox.setSelectedIndex(0);
				ChoiceArea.area_choice_label.setText("지역을 선택해 주세요");
				ChoiceArea.store_choice_label.setText("지점을 선택해 주세요");
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}

class Choice extends JComboBox {
	Choice(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			addItem(arr[i]);
		}
		setBounds(781, 350, 300, 70);
		setVisible(true);
		setBackground(Color.MAGENTA);
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 36));
		setBackground(new Color(255, 212, 216));
	}
}

class ChoiceBtn extends JButton {
	ChoiceBtn() {
		setBounds(732, 700, 160, 80);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}
}

class ExitBtn extends JButton {
	ExitBtn() {
		setBounds(972, 700, 160, 80);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}
}
class ChoiceLabel extends JLabel{
	ChoiceLabel(String text){
		setText(text);
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 32));
		setBounds(581, 500, 700, 60);
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(new Color(255, 115, 125));
		setVisible(true);
	}
}
class WhichStoreLabel extends JLabel{
	WhichStoreLabel() {
		setBounds(120, 30, 400, 100);
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 28));
		setForeground(new Color(255, 115, 125));
		setVisible(true);
	}
}