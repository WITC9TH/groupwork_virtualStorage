package CategoryMaster;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Constants.TableConstants.CATEGORY_MASTER;
import Database.Reader.Reader;
import Database.Reader.SqlHolder;
import Database.Reader.Select.Select;

public class UI_Category extends JPanel {

    private static JPanel categoryPanel = new JPanel();
    private JTextField categoryIDText;
    private JTextField categoryNameText;

    public UI_Category() {
        setLayout(null);

        categoryPanel.setBounds(0, 0, 684, 441);
        categoryPanel.setLayout(null);

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
        checkBtn.setBounds(217, 309, 91, 21);
        categoryPanel.add(checkBtn);

        JLabel productTopLabel = new JLabel("商品マスタ登録");
        productTopLabel.setSize(new Dimension(72, 19));
        productTopLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        productTopLabel.setAlignmentY(0.0f);
        productTopLabel.setAlignmentX(0.5f);
        productTopLabel.setBounds(285, 33, 80, 47);
        productTopLabel.setSize(productTopLabel.getPreferredSize());
        categoryPanel.add(productTopLabel);

        JLabel productIDLabel = new JLabel("分類ID：");
        productIDLabel.setSize(new Dimension(72, 19));
        productIDLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        productIDLabel.setAlignmentY(0.0f);
        productIDLabel.setAlignmentX(0.5f);
        productIDLabel.setBounds(217, 116, 76, 19);
        productIDLabel.setSize(productIDLabel.getPreferredSize());
        categoryPanel.add(productIDLabel);

        JLabel categoryIDLabel = new JLabel("分類名：");
        categoryIDLabel.setSize(new Dimension(72, 19));
        categoryIDLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        categoryIDLabel.setAlignmentY(0.0f);
        categoryIDLabel.setAlignmentX(0.5f);
        categoryIDLabel.setBounds(217, 161, 76, 19);
        categoryIDLabel.setSize(categoryIDLabel.getPreferredSize());
        categoryPanel.add(categoryIDLabel);

        categoryIDText = new JTextField();
        categoryIDText.setColumns(10);
        categoryIDText.setBounds(392, 118, 96, 19);
        categoryPanel.add(categoryIDText);

        categoryNameText = new JTextField();
        categoryNameText.setColumns(10);
        categoryNameText.setBounds(392, 163, 96, 19);
        categoryPanel.add(categoryNameText);
        SqlHolder sh1 = new Select(CATEGORY_MASTER.C_ID.getColumn(), CATEGORY_MASTER.getTableName());
        List<String> id = Reader.read(String.class, sh1);
        String[] array = new String[id.size()];

        JButton initializeBtn = new JButton("初期化");
        initializeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                categoryIDText.setText(null);
                categoryNameText.setText(null);
            }
        });
        initializeBtn.setBounds(397, 309, 91, 21);
        categoryPanel.add(initializeBtn);

        JButton returnToMenuBtn = new JButton("戻る");
        returnToMenuBtn.setBounds(397, 355, 91, 21);
        categoryPanel.add(returnToMenuBtn);

    }

    public JPanel getProductPanel() {
        return categoryPanel;
    }
}