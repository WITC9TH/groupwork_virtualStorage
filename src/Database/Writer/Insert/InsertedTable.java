/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Writer.Insert;

/**
 *
 * @author longi
 */
public class InsertedTable <T> {
    private String table = null;
    private String allColums = null;
    private String searchColumn = null;
    private T searchValue = null;

    public InsertedTable(final String table, final String allColums, final String searchColumn, final T searchValue){
        this.table = table;
        this.allColums = allColums;
        this.searchColumn = searchColumn;
        this.searchValue = searchValue;
    }
    public String getTable() {
        return table;
    }

    public String getAllColums() {
        return allColums;
    }

    public String getSearchColumn() {
        return searchColumn;
    }

    public T getSearchValue() {
        return searchValue;
    }
    
    
}
