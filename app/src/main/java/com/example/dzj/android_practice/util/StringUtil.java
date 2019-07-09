package com.example.dzj.android_practice.util;

import android.text.TextUtils;

import java.util.List;

/**
 * Created by dazhuanjia_rx on 17/2/22.
 */

public class StringUtil {
    /**
     * 字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str) || "null".equals(str);
    }

    /**
     * 字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmptyWithTrim(String str) {
        return isEmpty(str) || (str.trim().length() == 0);
    }

    /**
     * 是否存在空字符串
     * 只要存在一个空字符串，就返回true
     *
     * @param strings
     * @return
     */
    public static boolean isAnyoneEmpty(String... strings) {
        for (String str :
            strings) {
            if (isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串是否是数字
     */
    public static boolean isNumber(String value) {
        return value != null && (isInteger(value) || isDouble(value));
    }

    /**
     * 判断字符串是否是整数
     */
    public static boolean isInteger(String value) {
        try {
            int x = Integer.parseInt(value);
            return x != 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断字符串是否是不为0的浮点数
     */
    public static boolean isDouble(String value) {
        try {
            double i = Double.parseDouble(value);
            return value.contains(".") && i > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String getListToString2(List<String> list) {
        //只获取30字
        String strString = "";
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    strString = list.get(0);
                } else {
                    strString = strString + " " + list.get(i);
                }

                if (strString.length() > 30) {
                    break;
                }
            }
        }
        return strString;
    }

    /**
     * 将 stringList 转换成 String
     * <p>
     * 使用分隔符隔开
     * <p>
     * eg: a,b,c,d
     *
     * @param list
     * @return
     */
    public static String getListToString(List<String> list) {
        return getListToString(list, ",");
    }

    /**
     * 将 stringList 转换成 String
     * <p>
     * 使用分隔符隔开
     * <p>
     * eg: a,b,c,d
     *
     * @param list
     * @param delimiter 分隔符
     * @return
     */
    public static String getListToString(List<String> list, String delimiter) {
        StringBuffer strBuf = new StringBuffer("");
        if (list != null) {
            int size = list.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    String str = list.get(i);
                    if (strBuf.length() == 0 && !TextUtils.isEmpty(str)) {
                        strBuf.append(str);
                    } else {
                        if (!TextUtils.isEmpty(str)) {
                            strBuf.append(delimiter).append(str);
                        }
                    }
                }
            }
        }
        return strBuf.toString();
    }

}
