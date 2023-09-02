package com.eg;

import java.util.regex.Pattern;

/**
 * @Name: MatchAllString
 * @Description: 演示整体匹配
 * @User: xdSun
 * @Date: 2023/09/02 22:27:48
 * @Version: 1.0
 **/
public class MatchAllString {
    public static void main(String[] args) {
        String content = "hello abc hello";
        String regex = "^(hello).*(hello)$";
        boolean matches = Pattern.matches(regex, content);
        System.out.println("整体匹配：" + matches);
    }
}
