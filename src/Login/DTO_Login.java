/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Login;

/**
 * [処理概要]ログイン画面のデータを保持するDTOです。
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 鶴田雄基
 * @since 2018年01月18日
 * @version 1.0
 */
public class DTO_Login {

    private String userID;
    private String userPassword;

    public DTO_Login(
            String userID,
            String userPassword) {
        this.userID = userID;
        this.userPassword = userPassword;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPassword() {
        return userPassword;
    }
    
}
