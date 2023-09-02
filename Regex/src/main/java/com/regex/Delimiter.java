package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: Delimiter
 * @Description: 元字符 - 定界符
 *
 *      ^           匹配一行的开始位置 （The beginning of a line）
 *      $           匹配一行的结束位置 （The end of a line）
 *      \b          匹配单词边界 （A word boundary）
 *      \B          匹配非单词边界 （A non-word boundary）
 *      \A          匹配输入的开始位置 （The beginning of the input）
 *      \G          上一次匹配的结束位置 （The end of the previous match）
 *      \z          匹配输入的结束位置 （The end of the input）
 *      \Z          最后一次输入的结束 （The end of the input but for the final）
 *      \R          任何Unicode的换行字符 （Any Unicode linebreak sequence）
 *                      如： u000A u000B u000C u000D u0085 u2028 u2029
 *
 *
 * @User: xdSun
 * @Date: 2023/08/30 11:04:49
 * @Version: 1.0
 **/
public class Delimiter {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test2() {
        String content = "abd efae gfasdq e fa.";
        String regex = "\\be\\p{Alpha}+e\\b";
        Matcher matcher = Pattern.compile(regex).matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }

    private static void test1() {
        String content = "abcd123";
        String regex = "[a-z]+";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
