/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Database.Writer.Update;

import Constants.ERROR_MESSAGE;
import static Constants.ERROR_MESSAGE.CANNOT_LOAD_SQL;
import Database.Writer.PreparedStatementHolder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * [処理概要]
 * テーブルの更新をする際に、PreparedStatementを保持するクラス
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月18日
 * @version 1.0
 */
public class PreparedStatementForUpdate<X, Y> extends PreparedStatementHolder {

    private String updatedTable = null;
    private String allColumnsWithComma = null;
    private String updatedColumn = null;
    private Y newValue = null;
    private String searchColumn = null;
    private X searchValue = null;

    /**
     * テーブルの更新をする際に、PreparedStatementを保持するインスタンスを作る
     * @param ui UpdateInfoクラスのインスタンス
     */
    public PreparedStatementForUpdate(UpdateInfo ui) {
        this.updatedTable = ui.getUpdatedTable();
        this.allColumnsWithComma = ui.getAllColumnsWithComma();
        this.updatedColumn = ui.getUpdatedColumn();
        this.newValue = (Y) ui.getNewValue();
        this.searchColumn = ui.getSearchColumn();
        this.searchValue = (X) ui.getSearchValue();
        setPreparedStatement(composePreparedStatement());
    }

    private String composeSqlStatementSelectFor() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(this.allColumnsWithComma);
        sb.append(" FROM ");
        sb.append(this.updatedTable);
        sb.append(" WHERE ");
        sb.append(this.searchColumn);
        sb.append(" = ");
        if (this.searchValue.getClass() == String.class || this.searchValue.getClass() == Timestamp.class) {
            sb.append("'");
            sb.append(this.searchValue);
            sb.append("'");
        } else {
            sb.append(this.searchValue);
        }
        sb.append(" FOR  UPDATE ");
        return sb.toString();
    }

    @Override
    protected PreparedStatement composePreparedStatement() {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        try {
            PreparedStatement selectFor = con.prepareStatement(composeSqlStatementSelectFor());
            ResultSet rs = selectFor.executeQuery();
            String sql = composeSqlStatement();
            do {
                pstmt = con.prepareStatement(composeSqlStatement());
            }while(rs.next());

        } catch (SQLException e) {
            ERROR_MESSAGE.showErrorMessage(CANNOT_LOAD_SQL.getString());
            e.printStackTrace();
        }
        return pstmt;
    }

    @Override
    protected String composeSqlStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(this.updatedTable);
        sb.append(" SET ");
        sb.append(this.updatedColumn);
        sb.append(" = ");
        if(this.newValue.getClass() == String.class || this.newValue.getClass() == Timestamp.class){
            sb.append("'");
            sb.append(this.newValue);
            sb.append("'");
        }else {
            sb.append(this.newValue);
        }
        sb.append(" WHERE ");
        sb.append(this.searchColumn);
        sb.append(" = ");
        if (this.searchValue.getClass() == String.class || this.searchValue.getClass() == Timestamp.class) {
            sb.append("'");
            sb.append(this.searchValue);
            sb.append("'");
        } else {
            sb.append(this.searchValue);
        }
        return sb.toString();
    }

}
