package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: ShortestMatcher
 * @Description: 非贪婪匹配
 *
 *      当 ? 字符紧随任何其他限定符 (*+?{n}{n,}{n,m}) 之后时，匹配模式是非贪婪的，非贪婪匹配尽可能少的字符（java默认匹配尽可能多的字符）
 *
 * @User: xdSun
 * @Date: 2023/08/30 20:38:28
 * @Version: 1.0
 **/
public class ShortestMatch {
    public static void main(String[] args) {
        String content = "hello111111";
//        String regex = "\\d+?";
        String regex = "\\d+";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
