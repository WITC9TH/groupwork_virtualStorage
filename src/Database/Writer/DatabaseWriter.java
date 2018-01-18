/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Writer;

import Constants.ERROR_MESSAGE;
import static Constants.ERROR_MESSAGE.CANNOT_UPDATE_DATABASE;
import Constants.INFORMATIONAL_MESSAGE;
import static Constants.INFORMATIONAL_MESSAGE.UPDATED_SUCCESSFULLY;
import Database.DatabaseUtil;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author longi
 */
public class DatabaseWriter {

    public static void write(final PreparedStatementHolder psh) {
        PreparedStatement pstmt = psh.getPreparedStatement();
        try {
            if (pstmt.executeUpdate() < 0) {
                throw new SQLException();
            }
            pstmt.getConnection().commit();
            INFORMATIONAL_MESSAGE.showInformationalMessage(UPDATED_SUCCESSFULLY.getString());
        } catch (SQLException e) {
            ERROR_MESSAGE.showErrorMessage(CANNOT_UPDATE_DATABASE.getString());
            e.printStackTrace();
        } finally {
            DatabaseUtil.close(pstmt);
        }
    }
}
