/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */

package Menu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import productMaster.UI_Product;

/**
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 鶴田雄基
 * @since 2018年01月18日
 * @version 1.0
 */

public class UI_Menu {

	private JFrame frame;
	private JPanel menuPanel = new JPanel();
	private JPanel productPanel = new JPanel();
	private JPanel categoryPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Menu window = new UI_Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI_Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setSize(new Dimension(700, 480));
		frame.getContentPane().setLayout(null);

//		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 684, 441);
		frame.getContentPane().add(menuPanel);
		menuPanel.setLayout(null);

		UI_Product productVrb = new UI_Product();
		productPanel=productVrb.getProductPanel();
		frame.getContentPane().add(productPanel);
		productPanel.setVisible(false);

//		UI_Category categoryVrb = new UI_Product();
//		categoryPanel=categoryVrb.getCategoryPanel();
//		frame.getContentPane().add(categoryPanel);
//		categoryPanel.setVisible(false);

		JLabel menuTopLabel = new JLabel("在庫管理");
		menuTopLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		menuTopLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		menuTopLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuTopLabel.setBounds(288, 28, 80, 47);
		menuTopLabel.setSize(menuTopLabel.getPreferredSize());
		menuPanel.add(menuTopLabel);

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String strToday = sdf.format(cal.getTime());

		JLabel todayLabel = new JLabel(strToday);
		todayLabel.setSize(new Dimension(72, 19));
		todayLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		todayLabel.setAlignmentY(0.0f);
		todayLabel.setAlignmentX(0.5f);
		todayLabel.setBounds(491, 56, 72, 19);
		todayLabel.setSize(todayLabel.getPreferredSize());
		menuPanel.add(todayLabel);

		JLabel masterLabel = new JLabel("マスタ機能");
		masterLabel.setSize(new Dimension(72, 19));
		masterLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		masterLabel.setAlignmentY(0.0f);
		masterLabel.setAlignmentX(0.5f);
		masterLabel.setBounds(48, 74, 72, 19);
		masterLabel.setSize(masterLabel.getPreferredSize());
		menuPanel.add(masterLabel);

		JLabel transactionLabel = new JLabel("トランザクション処理");
		transactionLabel.setSize(new Dimension(72, 19));
		transactionLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		transactionLabel.setAlignmentY(0.0f);
		transactionLabel.setAlignmentX(0.5f);
		transactionLabel.setBounds(48, 193, 72, 19);
		transactionLabel.setSize(transactionLabel.getPreferredSize());
		menuPanel.add(transactionLabel);

		JLabel systemLabel = new JLabel("システム終了");
		systemLabel.setSize(new Dimension(72, 19));
		systemLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		systemLabel.setAlignmentY(0.0f);
		systemLabel.setAlignmentX(0.5f);
		systemLabel.setBounds(48, 312, 72, 19);
		systemLabel.setSize(systemLabel.getPreferredSize());
		menuPanel.add(systemLabel);

		JButton userRegistrationButton = new JButton("ユーザー登録");
		userRegistrationButton.setBounds(80, 103, 230, 35);
		menuPanel.add(userRegistrationButton);

		JButton categoryButton = new JButton("分類マスタ登録");
		categoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				categoryPanel.setVisible(true);
			}
		});
		categoryButton.setBounds(80, 148, 230, 35);
		menuPanel.add(categoryButton);

		JButton productButton = new JButton("商品マスタ登録");
		productButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				productPanel.setVisible(true);
			}
		});
		productButton.setBounds(386, 103, 230, 35);
		menuPanel.add(productButton);

		JButton loginButton = new JButton("ログイン");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.setBounds(80, 222, 230, 35);
		menuPanel.add(loginButton);

		JButton inputBuyDataButton = new JButton("仕入データ入力");
		inputBuyDataButton.setBounds(386, 222, 230, 35);
		menuPanel.add(inputBuyDataButton);

		JButton inputSellDataButton = new JButton("売り上げデータ入力");
		inputSellDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		inputSellDataButton.setBounds(80, 267, 230, 35);
		menuPanel.add(inputSellDataButton);

		JButton checkStockButton = new JButton("在庫確認（商品別）");
		checkStockButton.setBounds(386, 267, 230, 35);
		menuPanel.add(checkStockButton);

		JButton exitButton = new JButton("システム終了");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(80, 341, 230, 35);
		menuPanel.add(exitButton);
		frame.setBounds(100, 100, 700, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
