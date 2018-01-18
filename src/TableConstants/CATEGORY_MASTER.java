package TableConstants;

import java.util.List;

public enum CATEGORY_MASTER {
    C_ID,
    C_NAME,
    CREATE_DATE,
    CREATE_USER;
   
    public static String getTableName(){
        return TABLES.getTableName(CATEGORY_MASTER.class);
    }
    
    public static String getMainKey() {
        return C_ID.getColumn();
    }
    
    public static String getAllColumnsWithComma(){
        return TABLES.getAllColumnsWithComma(CATEGORY_MASTER.class);
    }
    
    public static List<String> getAllColumnsAsStringList(){
        return TABLES.getAllColumnsAsStringList(CATEGORY_MASTER.class);
    }

    public String getColumn() {
        return this.name();
    }
}
