package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: SelectorPatternCharacter
 * @Description: 元字符 - 选择匹配符 |
 * @User: xdSun
 * @Date: 2023/08/30 09:42:37
 * @Version: 1.0
 **/
public class SelectorMatchCharacter {
    public static void main(String[] args) {
        String content = "abcaefsadffef123ddd";
        String regex = "abc|123";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
