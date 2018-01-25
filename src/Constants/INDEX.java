/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package Constants;

/**
 * [処理概要]
 * 配列やリストの添え字を定数としてまとめる。
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月25日
 * @version 1.0
 */
public enum INDEX {
    INDEX_EMPTY(0),
    INDEX_ILLEGAL_FORMAT(1);
    
    private final int index;
    
    INDEX(final int index){
        this.index = index;
    }
    
    public int getIndex(){
        return this.index;
    }
}
