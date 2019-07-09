package com.example.dzj.android_practice.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gavin on 17/3/6.
 */

public class ListUtil {

    /**
     * 获取List中的内容，只截取钱30个字
     *
     * @param list
     * @return
     */
    public static String toString30(List<String> list) {
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

    public static <T> T getData(List<T> list, int position) {
        if (list == null) {
            return null;
        }
        if (list.size() > position) {
            return list.get(position);
        }
        return null;
    }

    /**
     * 判空
     *
     * @param list
     * @return
     */
    public static boolean isEmpty(List list) {
        if (list != null && list.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 获取第一个
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T getFirst(List<T> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    /**
     * String[] --> List<String>
     *
     * @param strings
     * @return
     */
    public static List<String> getList(String[] strings) {
        if (strings == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        Collections.addAll(list, strings);
        return list;
    }

    /**
     * 添加List操作
     *
     * @param originList
     * @param list
     * @param <T>
     */
    public static <T> void addListWithCheck(List<T> originList, List<T> list) {
        if (!isEmpty(list)) {
            originList.addAll(list);
        }
    }
}
