package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: NumberCharacter
 * @Description: 元字符 - 数量符
 *
 *      *           0 - 多次匹配
 *      +           1 - 多次匹配
 *      ？           0 或 1 次匹配
 *      {n}         n 次匹配
 *      {n,}        至少 n 次匹配
 *      {n,m}       n 到 m 次匹配
 *      java是贪婪匹配，尽可能多的匹配
 *          如：a{3,4}  优先匹配4个a
 *
 * @User: xdSun
 * @Date: 2023/08/30 09:48:57
 * @Version: 1.0
 **/
public class NumberCharacter {
    public static void main(String[] args) {
        String content = "abcabcabcabcabcabcccccccccertertert";
        String regex = "(abc){1,4}";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
//        matcher.find();
//        System.out.println("找到：" + matcher.group(0));
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
