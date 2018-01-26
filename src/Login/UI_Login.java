/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Login;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Menu.UI_Menu;
import javax.swing.JPasswordField;

/**
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 鶴田雄基
 * @since 2018年01月18日
 * @version 1.0
 */
public class UI_Login extends JPanel {

    private static JPanel loginPanel = new JPanel();
    private JTextField userIDText;
    private JPasswordField passwordPass;

    public UI_Login() {
        setLayout(null);

        loginPanel.setBounds(0, 0, 684, 441);
        loginPanel.setLayout(null);

        JButton loginBtn = new JButton("ログイン");
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DTO_Login vrbDto = new DTO_Login(
                        userIDText.getText(), inputPassBuild(passwordPass.getPassword())
                );

                BL_Login vrbBl = new BL_Login(vrbDto);
            }
        });
        loginBtn.setBounds(217, 309, 91, 21);
        loginPanel.add(loginBtn);

        JLabel loginTopLabel = new JLabel("ログイン");
        loginTopLabel.setSize(new Dimension(72, 19));
        loginTopLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        loginTopLabel.setAlignmentY(0.0f);
        loginTopLabel.setAlignmentX(0.5f);
        loginTopLabel.setBounds(285, 33, 80, 47);
        loginTopLabel.setSize(loginTopLabel.getPreferredSize());
        loginPanel.add(loginTopLabel);

        JLabel userIDLabel = new JLabel("ユーザーID：");
        userIDLabel.setSize(new Dimension(72, 19));
        userIDLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        userIDLabel.setAlignmentY(0.0f);
        userIDLabel.setAlignmentX(0.5f);
        userIDLabel.setBounds(217, 116, 76, 19);
        userIDLabel.setSize(userIDLabel.getPreferredSize());
        loginPanel.add(userIDLabel);

        JLabel passwordLabel = new JLabel("パスワード：");
        passwordLabel.setSize(new Dimension(72, 19));
        passwordLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
        passwordLabel.setAlignmentY(0.0f);
        passwordLabel.setAlignmentX(0.5f);
        passwordLabel.setBounds(217, 161, 76, 19);
        passwordLabel.setSize(passwordLabel.getPreferredSize());
        loginPanel.add(passwordLabel);

        userIDText = new JTextField();
        userIDText.setColumns(10);
        userIDText.setBounds(392, 118, 96, 19);
        loginPanel.add(userIDText);

        JButton initializeBtn = new JButton("初期化");
        initializeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userIDText.setText(null);
                passwordPass.setText(null);
            }
        });
        initializeBtn.setBounds(397, 309, 91, 21);
        loginPanel.add(initializeBtn);

        JButton returnToMenuBtn = new JButton("戻る");
        returnToMenuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI_Menu.getMenuPanel().setVisible(true);
                loginPanel.setVisible(false);
            }
        });
        returnToMenuBtn.setBounds(397, 355, 91, 21);
        loginPanel.add(returnToMenuBtn);

        passwordPass = new JPasswordField();
        passwordPass.setEchoChar('*');
        passwordPass.setBounds(392, 163, 96, 19);
        loginPanel.add(passwordPass);

    }

    public String inputPassBuild(char[] input_pass_char) {

        StringBuilder sbdrPass = new StringBuilder();
        for (char solo : input_pass_char) {
            sbdrPass.append(solo);
        }
        return sbdrPass.toString();
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }
}
