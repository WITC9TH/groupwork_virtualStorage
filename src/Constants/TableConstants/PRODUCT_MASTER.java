package Constants.TableConstants;

import java.util.List;

public enum PRODUCT_MASTER implements TABLES {
    P_ID,
    C_ID,
    P_NAME,
    BUY_PRICE,
    SELL_PRICE,
    CREATE_DATE,
    CREATE_USER;
 
    public static String getTableName(){
        return TABLES.getTableName(PRODUCT_MASTER.class);
    }
    
    public static String getMainKey() {
        return P_ID.getColumn();
    }
    
    public static String getForeingKey() {
        return C_ID.getColumn();
    }
    
    public static String getAllColumnsWithComma(){
        return TABLES.getAllColumnsWithComma(PRODUCT_MASTER.class);
    }
    
    public static List<String> getAllColumnsAsStringList(){
        return TABLES.getAllColumnsAsStringList(PRODUCT_MASTER.class);
    }

    public String getColumn() {
        return this.name();
    }
}
