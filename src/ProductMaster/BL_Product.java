/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package ProductMaster;

import AbstractClass.BusinessLogic;
import static Constants.TableConstants.PRODUCT_MASTER.*;

/**
 * [処理概要]
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月25日
 * @version 1.0
 */

public class BL_Product extends BusinessLogic{
    public BL_Product(DTO_Product dto){
        super(dto);
    }
    
    @Override
    protected boolean callIsValidInput() {
        return isValidInput("正規表現", 0,P_ID.getColumn(), getTableName());
    }

    @Override
    protected void processNormally() {
        
    }


}
