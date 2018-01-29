/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants.TableConstants;

/**
 * [処理概要]
 * アカウントマスタに関する定数と処理を定義する
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月26日
 * @version 1.0
 */
public enum ACCOUNT_MASTER implements TABLES {
    USER_ID,
    USER_PW,
    CREATE_DATE,
    CREATE_USER;
        
    public static String getTableName(){
        return TABLES.getTableName(ACCOUNT_MASTER.class);
    }
    
    public static String getMainKey(){
        return USER_ID.getColumn();
    }
    
    public static String getAllColumnsWithComma(){
        return TABLES.getAllColumnsWithComma(ACCOUNT_MASTER.class);
    }
    
    public String getColumn(){
        return this.name();
    }
    
}
