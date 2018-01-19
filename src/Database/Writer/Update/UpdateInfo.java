/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database.Writer.Update;

/**
 * [処理概要] データベースを更新する際に、その更新内容を保持するクラス
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月18日
 * @version 1.0
 */
public class UpdateInfo<X, Y> {

    private String updatedTable = null;
    private String allColumnsWithComma = null;
    private String updatedColumn = null;
    private Y newValue = null;
    private String searchColumn = null;
    private X searchValue = null;

    /**
     * データベースを更新する際に、その更新内容を保持するインスタンスを作る
     * @param updatedTable　更新するテーブル
     * @param allColumnsWithComma　全てのカラム名をコンマ区切りでつなげた文字列
     * @param updatedColumn　更新するカラム
     * @param newValue　新しい値
     * @param searchColumn　検索に使うカラム
     * @param searchValue 検索に使う値
     */
    public UpdateInfo(final String updatedTable, final String allColumnsWithComma, final String updatedColumn, final Y newValue, final String searchColumn, final X searchValue) {
        this.updatedTable = updatedTable;
        this.allColumnsWithComma = allColumnsWithComma;
        this.updatedColumn = updatedColumn;
        this.newValue = newValue;
        this.searchColumn = searchColumn;
        this.searchValue = searchValue;
    }

    //以下、アクセサーメソッド
    public String getUpdatedTable() {
        return updatedTable;
    }
    
    public String getAllColumnsWithComma(){
        return allColumnsWithComma;
    }

    public String getUpdatedColumn() {
        return updatedColumn;
    }

    public Y getNewValue() {
        return newValue;
    }

    public String getSearchColumn() {
        return searchColumn;
    }

    public X getSearchValue() {
        return searchValue;
    }
}
