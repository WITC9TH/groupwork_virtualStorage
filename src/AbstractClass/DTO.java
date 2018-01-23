/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package AbstractClass;

import java.util.List;
import javax.swing.JTextField;

/**
 * [処理概要]
 * 入力データを保持するクラスの抽象クラス
 * @author  株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since   2018年01月23日
 * @version 1.0
 */
public class DTO {
    private List<JTextField> jTextFieldList = null;
    protected DTO(final List<JTextField> jTextFieldList){
        this.jTextFieldList = jTextFieldList;
    }
    public List<JTextField> getJTextFieldArray(){
        return this.jTextFieldList;
    }
}
