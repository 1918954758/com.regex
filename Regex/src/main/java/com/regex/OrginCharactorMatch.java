package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: OrginCharactorPattern
 * @Description: 元字符匹配
 * [abc]       可接受的字符列表，匹配一个字符 a|b|c
 * [^abc]      可接受的字符列表，匹配一个字符 除a、除b、除c之外的其他字符
 * -           连字符，范围匹配，如：[a-z]，匹配abcdef...xyz等26个小写字母
 * .           匹配除\n以外的所有字符
 * \\d         匹配数字，相等于 [0-9]
 * \\D         陪陪非数字，相当于 [^0-9]
 * \\w         匹配数字、下横线、大小写字母，相当于 [0-9a-zA-Z_]
 * \\W         匹配非数字、下横线、大小写字母，相当于 [^0-9a-zA-Z_]
 * \\s         匹配任何空白字符（空格、制表符等）
 * \\S         匹配任何非空白字符
 * @User: xdSun
 * @Date: 2023/08/29 20:28:17
 * @Version: 1.0
 **/
public class OrginCharactorMatch {
    public static void main(String[] args) {
        String content = "* [abc]       可接受的字符列表，匹配一个字符 a|b|c\n" +
                " * [^abc]      可接受的字符列表，匹配一个字符 除a、除b、除c之外的其他字符\n" +
                " * -           连字符，范围匹配，如：[a-z]，匹配abcdef...xyz等26个小写字母\n" +
                " * .           匹配除\\n以外的所有字符\n" +
                " * \\\\d         匹配数字，相等于 [0-9]\n" +
                " * \\\\D         陪陪非数字，相当于 [^0-9]\n" +
                " * \\\\w         匹配数字、下横线、大小写字母，相当于 [0-9a-zA-Z_]\n" +
                " * \\\\W         匹配非数字、下横线、大小写字母，相当于 [^0-9a-zA-Z_]\n" +
                " * \\\\s         匹配任何空白字符（空格、制表符等）\n" +
                " * \\\\S         匹配任何非空白字符";
//        String regex = "[AZ]";
//        String regex = "\\d";
//        String regex = "\\S|\\s";
        String regex = "\\w";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.print(matcher.group(0) + "\t");
        }
    }
}
