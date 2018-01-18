/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants;

import javax.swing.JOptionPane;

/**
 * [処理概要] 定数として保持するエラーメッセージを表示する。
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月18日
 * @version 1.0
 */
public enum ERROR_MESSAGE {

    ERROR("エラー"),
    
    CANNOT_FIND_PROPERTY_FILE("プロパティファイルが見つかりませんでした"),
    CANNOT_FIND_DRIVER("ドライバーが見つかりませんでした"),
    
    CANNOT_READ_PROPERTY_FILE("プロパティファイルが読み込めませんでした"),
    CANNOT_READ_DATABASE("データベースからデータが読み込めませんでした"),
    CANNOT_ESTABLISH_CONNECTION("データベースへの接続が確立できませんでした"),    
    ABNORMAL_CONNECTION_ENDING("データベースへの接続が正常に終了しませんでした"),
    
    ILLEGAL_VALUE_TYPE("このプログラムで対応していないデータの種類を、データベースから読み込もうとしています"),
    CANNOT_SET_AUTO_COMMIT_FALSE("自動的にデータベースが更新されてしまう設定(autoCommit)をOFFにできませんでした"),
    
    CANNOT_LOAD_SQL("SQL文が読み込めませんでした"),
    CANNOT_SET_VALUES_TO_SQL("SQL文に値がセットできませんでした"),
    CANNOT_UPDATE_DATABASE("データベースが更新できませんでした"),
    
    PASS_ENUM_ONLY("このメソッドの引数には、列挙型のクラスインスタンス以外渡さないでください");
    
    private final String message;

    ERROR_MESSAGE(final String message) {
        this.message = message;
    }

    public String getString() {
        return this.message;
    }

    public static void showErrorMessage(final String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, ERROR.getString(), JOptionPane.ERROR_MESSAGE);
    }
}
