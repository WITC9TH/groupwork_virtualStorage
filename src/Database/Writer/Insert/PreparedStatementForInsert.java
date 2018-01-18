/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Writer.Insert;

import static Constants.ERROR_MESSAGE.CANNOT_LOAD_SQL;
import static Constants.ERROR_MESSAGE.CANNOT_SET_VALUES_TO_SQL;
import Constants.ERROR_MESSAGE;
import Database.Writer.PreparedStatementHolder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author longi
 */
public class PreparedStatementForInsert<T> extends PreparedStatementHolder {

    private String table = null;
    private String allColumns = null;
    private int commaNum = 0;
    private String searchColumn = null;
    private T searchValue = null;

    private List<String> varcharValues = null;
    private int varcharSize = 0;
    private List<Integer> intValues = null;
    private int intSize = 0;
    private List<Timestamp> timestampValues = null;
    private int timestampSize = 0;

    public PreparedStatementForInsert(final InsertedTable insertedTable, final InsertedData insertedData) {
        this.table = insertedTable.getTable();
        this.allColumns = insertedTable.getAllColums();
        countCommaNum();
        this.searchColumn = insertedTable.getSearchColumn();
        this.searchValue = (T) insertedTable.getSearchValue();

        this.varcharValues = insertedData.getVarcharValues();
        this.varcharSize = listSize(varcharValues);

        this.intValues = insertedData.getIntValues();
        this.intSize = listSize(intValues);

        this.timestampValues = insertedData.getTimestampValues();
        this.timestampSize = listSize(timestampValues);

        setPreparedStatement(composePreparedStatement());
    }

    private int listSize(List<?> list) {
        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    @Override
    protected PreparedStatement composePreparedStatement() {
        PreparedStatement pstmt = null;
        Connection con = getConnection();

        try {
            pstmt = con.prepareStatement(composeSqlStatement());
            setValuesToPreparedStatement(pstmt);
        } catch (SQLException e) {
            ERROR_MESSAGE.showErrorMessage(CANNOT_LOAD_SQL.getString());
            e.printStackTrace();
        }
        System.out.println(pstmt);
        return pstmt;
    }

    private void countCommaNum() {
        for (int i = 0; i < allColumns.length(); i++) {
            if (allColumns.charAt(i) == ',') {
                this.commaNum++;
            }
        }
    }

    @Override
    protected String composeSqlStatement() {
        StringBuilder sb = new StringBuilder();
        //sb.append(TABLE.DISABLE_FOREIGN_KEY_CHECK());
        sb.append("INSERT INTO ");
        sb.append(table);
        sb.append(" SELECT ");

        for (int i = 0; i < this.commaNum; i++) {
            sb.append("?,");
        }

        sb.append("? FROM DUAL WHERE NOT EXISTS(SELECT ");
        sb.append(allColumns);
        sb.append(" FROM ");
        sb.append(table);
        sb.append(" WHERE ");
        sb.append(searchColumn);
        sb.append(" = ");
        if (searchValue.getClass() == String.class || searchValue.getClass() == Timestamp.class) {
            sb.append("'");
            sb.append(searchValue);
            sb.append("'");
        } else {
            sb.append(searchValue);
        }
        sb.append(") ");
        //sb.append(TABLE.ENABLE_FOREIGN_KEY_CHECK());
        return sb.toString();
    }

    private void setValuesToPreparedStatement(PreparedStatement pstmt) {
        try {
            if (this.varcharValues != null) {
                for (int i = 0; i < this.varcharSize; i++) {
                    pstmt.setString(i + 1, varcharValues.get(i));
                }
            }

            if (this.intValues != null) {
                for (int i = 0; i < intSize; i++) {
                    pstmt.setInt(i + varcharSize + 1, intValues.get(i));
                }
            }

            if (this.timestampValues != null) {
                for (int i = 0; i < timestampSize; i++) {
                    pstmt.setTimestamp(i + varcharSize + intSize + 1, timestampValues.get(i));
                }
            }
        } catch (SQLException e) {
            ERROR_MESSAGE.showErrorMessage(CANNOT_SET_VALUES_TO_SQL.getString());
            e.printStackTrace();
        }

    }

}
