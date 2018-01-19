package Test;

/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */

import java.util.List;

import Database.DatabaseUtil;
import Database.Reader.SqlHolder;
import Database.Reader.Reader;

//以下の2つはどちらかを状況に合わせて使ってください
import Database.Reader.Select.Select;//WHERE句での絞り込みを行わない場合
import Database.Reader.Select.SelectWhere; //WHERE句での絞り込みを行う場合

import Constants.TableConstants.TABLES;
//以下の2つはどちらかを状況に合わせて使ってください
import Constants.TableConstants.CATEGORY_MASTER;//分類マスターテーブルを使いたい場合
import Constants.TableConstants.PRODUCT_MASTER;//商品マスターテーブルを使いたい場合

//以下の2つはどちらかを状況に合わせて使ってください
import static Constants.TableConstants.CATEGORY_MASTER.*;
import static Constants.TableConstants.PRODUCT_MASTER.*;

/**
 * [処理概要]
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月19日
 * @version 1.0
 */
public class TestSelect {

    public static void main(String[] args) {
        
    }
}
