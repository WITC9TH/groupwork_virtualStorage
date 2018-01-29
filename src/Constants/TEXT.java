/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants;

/**
 * [処理概要] このパッケージの他の列挙型で定義している以外の、細かな文字列定数・処理を定義する
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月29日
 */
public enum TEXT {
    ADMIN("admin"),
    CONFIRMATION("確認"),
    UI_GOTHIC("MS UI Gothic"),
    PRODUCT_ID("商品ID："),
    CATEGORY_ID("カテゴリID："),
    PRODUCT_NAME("商品名："),
    BUYING_PRICE("仕入れ価格:"),
    SELLING_PRICE("売上価格:"),
    INITIALIZATION("初期化"),
    GO_BACK("戻る"),
    PRODUCT_MASTER_REGISTRATION("商品マスタ登録");
    
    
    private final String text;
    private TEXT(final String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
}
