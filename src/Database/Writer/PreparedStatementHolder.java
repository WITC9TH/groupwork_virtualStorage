/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Writer;

import Constants.ERROR_MESSAGE;
import Database.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author longi
 */
public abstract class PreparedStatementHolder {
    private PreparedStatement preparedStatement = null;
    private Connection con = null;
    
    protected void setPreparedStatement(final PreparedStatement preparedStatement){
        this.preparedStatement = preparedStatement;
    }
    
    public PreparedStatement getPreparedStatement(){
        return this.preparedStatement;
    }
    
    protected Connection getConnection(){
        this.con = DatabaseUtil.getConnectionInstance();
        try{
            con.setAutoCommit(false);
        }catch(SQLException e){
            ERROR_MESSAGE.showErrorMessage(ERROR_MESSAGE.CANNOT_SET_AUTO_COMMIT_FALSE.getString());
            e.printStackTrace();
        }   
        return con;
    }
    
    protected abstract PreparedStatement composePreparedStatement();
    protected abstract String composeSqlStatement();
}
