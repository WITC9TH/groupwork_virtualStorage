package ProductMaster;

import static Constants.TableConstants.CATEGORY_MASTER.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.Reader.Reader;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Constants.TableConstants.CATEGORY_MASTER;
import Database.Reader.SqlHolder;
import Database.Reader.Select.Select;

public class UI_Product extends JPanel {

    private static JPanel productPanel = new JPanel();
    private JTextField productIDText;
    private JTextField productNameText;
    private JTextField inputPriceText;
    private JTextField outputPriceText;
    
    public UI_Product() {
        setLayout(null);
        
        productPanel.setBounds(0, 0, 684, 441);
        productPanel.setLayout(null);
        
        JButton checkBtn = new JButton("確認");
        checkBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//				LineBorder border = null;
//
//				String input = productIDText.getText();
//				if(input == null) {
//					border = new LineBorder(Color.RED);
//				} else {
//					border = new LineBorder(Color.GRAY);
//				}
//
//
//
//				productIDText.setBorder(changeBorderColor(input));
            }
        });
        checkBtn.setBounds(217, 370, 91, 21);
        productPanel.add(checkBtn);
        
        JLabel productTopLabel = new JLabel("商品マスタ登録");
        productTopLabel.setSize(new Dimension(72, 19));
        productTopLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        productTopLabel.setAlignmentY(0.0f);
        productTopLabel.setAlignmentX(0.5f);
        productTopLabel.setBounds(285, 33, 80, 47);
        productTopLabel.setSize(productTopLabel.getPreferredSize());
        productPanel.add(productTopLabel);
        
        JLabel productIDLabel = new JLabel("商品ID：");
        productIDLabel.setSize(new Dimension(72, 19));
        productIDLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        productIDLabel.setAlignmentY(0.0f);
        productIDLabel.setAlignmentX(0.5f);
        productIDLabel.setBounds(217, 116, 76, 19);
        productIDLabel.setSize(productIDLabel.getPreferredSize());
        productPanel.add(productIDLabel);
        
        JLabel categoryIDLabel = new JLabel("カテゴリID：");
        categoryIDLabel.setSize(new Dimension(72, 19));
        categoryIDLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        categoryIDLabel.setAlignmentY(0.0f);
        categoryIDLabel.setAlignmentX(0.5f);
        categoryIDLabel.setBounds(217, 161, 76, 19);
        categoryIDLabel.setSize(categoryIDLabel.getPreferredSize());
        productPanel.add(categoryIDLabel);
        
        JLabel productNameLabel = new JLabel("商品名：");
        productNameLabel.setSize(new Dimension(72, 19));
        productNameLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        productNameLabel.setAlignmentY(0.0f);
        productNameLabel.setAlignmentX(0.5f);
        productNameLabel.setBounds(217, 209, 76, 19);
        productNameLabel.setSize(productNameLabel.getPreferredSize());
        productPanel.add(productNameLabel);
        
        JLabel inputPriceLabel = new JLabel("仕入価格：");
        inputPriceLabel.setSize(new Dimension(72, 19));
        inputPriceLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        inputPriceLabel.setAlignmentY(0.0f);
        inputPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPriceLabel.setBounds(217, 257, 76, 19);
        inputPriceLabel.setSize(inputPriceLabel.getPreferredSize());
        productPanel.add(inputPriceLabel);
        
        JLabel outputPriceLabel = new JLabel("売上価格：");
        outputPriceLabel.setSize(new Dimension(72, 19));
        outputPriceLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        outputPriceLabel.setAlignmentY(0.0f);
        outputPriceLabel.setAlignmentX(0.5f);
        outputPriceLabel.setBounds(217, 305, 76, 19);
        outputPriceLabel.setSize(outputPriceLabel.getPreferredSize());
        productPanel.add(outputPriceLabel);
        
        productIDText = new JTextField();
        productIDText.setColumns(10);
        productIDText.setBounds(392, 118, 96, 19);
        productPanel.add(productIDText);
        
        productNameText = new JTextField();
        productNameText.setColumns(10);
        productNameText.setBounds(392, 209, 96, 19);
        productPanel.add(productNameText);
        
        inputPriceText = new JTextField();
        inputPriceText.setColumns(10);
        inputPriceText.setBounds(392, 259, 96, 19);
        productPanel.add(inputPriceText);
        
        outputPriceText = new JTextField();
        outputPriceText.setColumns(10);
        outputPriceText.setBounds(392, 307, 96, 19);
        productPanel.add(outputPriceText);
        
        JComboBox categoryIDCmb = new JComboBox();
        SqlHolder sh1 = new Select(CATEGORY_MASTER.C_ID.getColumn(), CATEGORY_MASTER.getTableName());
        List<String> id = Reader.read(String.class, sh1);
        String[] array = new String[id.size()];     
        
        categoryIDCmb.setModel(new DefaultComboBoxModel(id.toArray(array)));
        categoryIDCmb.setBounds(392, 163, 96, 19);
        productPanel.add(categoryIDCmb);
        
        JButton button = new JButton("初期化");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                productIDText.setText(null);
                productNameText.setText(null);
                inputPriceText.setText(null);
                outputPriceText.setText(null);
                
            }
        });
        button.setBounds(397, 370, 91, 21);
        productPanel.add(button);
        
    }
    
    public JPanel getProductPanel() {
        return productPanel;
    }

//	private LineBorder changeBorderColor(final String input) {
//		LineBorder border = null;
//		if(input == null) {
//			border = new LineBorder(Color.RED);
//		} else {
//			border = new LineBorder(Color.GRAY);
//		}
//		return border;
//	}
}
