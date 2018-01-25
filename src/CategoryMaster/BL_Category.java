/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package CategoryMaster;

import AbstractClass.BusinessLogic;
import ProductMaster.DTO_Product;


/**
 * [処理概要]
 * 商品マスター画面における基幹処理を行う
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月19日
 * @version 1.0
 */
public class BL_Category extends BusinessLogic {

    public BL_Category (DTO_Category dto){
        super(dto);
    }

    @Override
    protected boolean callIsValidInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processNormally() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
