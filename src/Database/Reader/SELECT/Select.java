/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database.Reader.SELECT;

/**
 * [処理概要] WHERE句抜きのSELECT命令を行う際に、SQL文を保持するクラス
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月18日
 * @version 1.0
 */
public class Select extends SqlHolder {

    /**
     * SQLのSELECT文をWHERE句抜きで実行する際に、SQL文を保持するインスタンスのコンストラクタ。
     * 検索条件を引数に持つ
     * @param column 欲しいデータのカラム名
     * @param table 欲しいデータがあるテーブル名  
     */
    public Select(final String column, final String table) {
        super(column, table);
        setSql(composeSql());
    }

    @Override
    protected String composeSql() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(getColumn());
        sql.append(" FROM ");
        sql.append(getTable());
        return sql.toString();
    }
}
