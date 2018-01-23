/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package AbstractClass;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.border.LineBorder;

/**
 *[処理概要] 各ビジネスロジックに共通する処理を提供する
 * @author 株式会社ワールドインテック SI事業部 東京営業所 池田　裕斗
 * @since 2018年01月18日
 * @version 1.0
 */
public abstract class BusinessLogic{
    	
        /**
	 * 入力の書式が正しいかチェックする
         * @param regex
         * @param  target
         * @return 
	 */
	public boolean isMach(final String regex, final String target) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		return (matcher.find());
	}
/**
	 * 入力の書式が誤っている場合の処理
	 * @param isResult
	 * @return
	 */

	public LineBorder paintLineBorder(boolean isResult) {
		LineBorder border = new LineBorder(Color.WHITE);
		if (! isResult) {
			border = new LineBorder(Color.RED);
		}
		return border;
	}

}
