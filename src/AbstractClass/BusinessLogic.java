/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package AbstractClass;

import Constants.ERROR_MESSAGE;
import static Constants.ERROR_MESSAGE.ERROR_ALREADY_EXISTS;
import static Constants.ERROR_MESSAGE.ERROR_IS_NULL;
import static Constants.ERROR_MESSAGE.ERROR_WRONG_INPUT;
import static Constants.ERROR_MESSAGE.showErrorMessage;
import Database.Reader.Reader;
import Database.Reader.Select.Select;
import Database.Writer.DatabaseWriter;
import Database.Writer.Insert.InsertedData;
import Database.Writer.Insert.InsertedTable;
import Database.Writer.Insert.PreparedStatementForInsert;
import java.awt.Color;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * [処理概要] 各ビジネスロジックに共通する処理を提供する
 *
 * @author 株式会社ワールドインテック SI事業部 東京営業所 池田　裕斗
 * @since 2018年01月18日
 * @version 1.0
 */
public abstract class BusinessLogic {

    protected List<JTextField> allJTextField;

    protected BusinessLogic(DTO dto) {
        this.allJTextField = dto.getAllJTextField();
        facade();
    }

    private void facade() {
        if (callIsValidInput()) {
            processNormally();
        }
    }

    protected abstract boolean callIsValidInput();

    protected abstract void processNormally();

    protected void register(InsertedData id, InsertedTable it) {
        if (callIsValidInput()) {
            DatabaseWriter.write(new PreparedStatementForInsert(it, id));
        }
    }

    protected boolean isValidInput(final String regex, final int index,
            final String column, final String table) {

        boolean isValidInput = true;
        List<String> idList = Reader.read(String.class, new Select(column, table));
        for (int i = 0; i < this.allJTextField.size(); i++) {
            JTextField jTextField = this.allJTextField.get(i);

            if (jTextField.getText().isEmpty()) {
                processInvalidInput(ERROR_IS_NULL, jTextField);
                isValidInput = false;
            }

            if (i == index) {
                isValidInput = isValidIndexValue(regex, idList, jTextField);
            }
        }
        return isValidInput;
    }

    private void processInvalidInput(final ERROR_MESSAGE msg, final JTextField jTextField) {
        showErrorMessage(msg);
        paintLineBorder(jTextField);
    }

    public void paintLineBorder(JTextField jTextField) {
        jTextField.setBorder(new LineBorder(Color.RED));
    }

    private boolean isValidIndexValue(final String regex, final List<String> idList, final JTextField jTextField) {
        boolean isValidIndexValue = true;

        if (!isMatch(regex, jTextField)) {
            processInvalidInput(ERROR_WRONG_INPUT, jTextField);
            isValidIndexValue = false;
        }

        if (idList.contains(jTextField.getText())) {
            processInvalidInput(ERROR_ALREADY_EXISTS, jTextField);
            isValidIndexValue = false;
        }

        return isValidIndexValue;
    }

    private boolean isMatch(final String regex, final JTextField target) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target.getText());
        return (matcher.find());
    }

}
