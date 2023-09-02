package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: IgnoreUpperLower
 * @Description: 不区分大小写
 * @User: xdSun
 * @Date: 2023/08/29 20:47:26
 * @Version: 1.0
 **/
public class IgnoreUpperLower {
    public static void main(String[] args) {
        String content = "abcdABCfjqeofjLJJDFLJOjlfjqoewjfJDLFJALJLjlhsGJKHKJEWgjgGYFytfhydrsXVJNJKvhXGF";
        // 区分大小写
//        String regex = "ew";
        // 不区分大小写，((?i)str) str表示不区分大小写的字串
        String regex = "((?i)ew)";// 写法一
        Pattern compile = Pattern.compile(regex);
//        Pattern.compile(regex, Pattern.CASE_INSENSITIVE); // 写法二
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
