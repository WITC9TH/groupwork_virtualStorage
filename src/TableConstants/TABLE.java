/*
 * Java研修生9期グループワーク
 * 仮想在庫システム
 */
package TableConstants;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * [処理概要] このシステムは、テーブル名やカラム名などのテーブル関連の定数を、列挙型で管理する 各列挙型に共通する操作を、このインターフェースにて定義する
 *
 * @author 株式会社ワールドインテック SI事業部 福岡営業所 長島雅人
 * @since 2018年01月18日
 * @version 1.0
 */
public interface TABLE {

    static <T> String getTableName(final Class<T> clazz) {
        String tableName = null;

        if (clazz.isEnum()) {
            tableName = clazz.getSimpleName();
        } else {
            throwIllegalArgumentException();
        }

        return tableName;
    }

    static <T> String getAllColumnsWithComma(final Class<T> clazz) {
        StringBuilder sb = new StringBuilder();

        if (clazz.isEnum()) {
            try {
                Field[] fields = clazz.getFields();
                int commaNum = fields.length - 1;

                for (int i = 0; i < commaNum; i++) {
                    Field field = fields[i];
                    sb.append(field.get(field));
                    sb.append(",");
                }

                sb.append(fields[commaNum].get(fields[commaNum]));
            } catch (IllegalAccessException e) {
                System.err.println("テーブル名とカラム名が取得できません");
                e.printStackTrace();
            }

        } else {
            throwIllegalArgumentException();
        }

        return sb.toString();
    }

    static <T> List<String> getAllColumnsAsStringList(final Class<T> clazz) {
        List<String> allColumns = new ArrayList<>();

        if (clazz.isEnum()) {
            for (Field field : clazz.getFields()) {
                allColumns.add(field.getName());
            }
        }else{
            throwIllegalArgumentException();
        }

        return allColumns;
    }

    static void throwIllegalArgumentException() {
        try {
            throw new IllegalArgumentException("このメソッドの引数には、列挙型のクラスインスタンス以外渡さないでください");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
