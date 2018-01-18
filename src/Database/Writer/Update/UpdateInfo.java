/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Writer.Update;

/**
 *
 * @author longi
 */
public class UpdateInfo<X, Y> {

    private String updatedTable = null;
    private String allColumnsWithComma = null;
    private String updatedColumn = null;
    private Y newValue = null;
    private String searchColumn = null;
    private X searchValue = null;

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
