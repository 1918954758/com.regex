package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: GroupMatch
 * @Description: 分组匹配
 *
 *      (pattern)               非命名捕获，捕获匹配的字符串，
 *                                  编号为 0 的第一个捕获的是由整个正则表达式模式匹配的文本，
 *                                  其他捕获结果则是根据左括号书写的顺序从 1 开始自动编号
 *      (?<name>pattern)        命名捕获，将匹配的子字符串捕获到一个组名称或编号名称中，
 *                                  用于name的字符串不能包含任何标点符号，并且不能以数字开头
 *
 * @User: xdSun
 * @Date: 2023/08/30 12:23:55
 * @Version: 1.0
 **/
public class GroupMatch {
    public static void main(String[] args) {
        String content = "hanshunping s7789 nn1189han";
        test1(content);
        System.out.println("-----------------------");
        test2(content);
//        System.out.println("-----------------------");
//        test3(content);
    }

//    private static void test3(String content) {
//        String regex = "(?'name1'hun).*(?'name2'1189)";// (?'name'pattern) 测试失败，不支持 '' 替代 <>
//        Matcher matcher = Pattern.compile(regex).matcher(content);
//        while (matcher.find()) {
//            System.out.println("找到：" + matcher.group(0));
//            System.out.println("找到：" + matcher.group("name1"));
//            System.out.println("找到：" + matcher.group("name2"));
//        }
//    }

    private static void test2(String content) {
        String regex = "(?<name1>hun).*(?<name2>1189)";
        Matcher matcher = Pattern.compile(regex).matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
            System.out.println("找到：" + matcher.group("name1"));
            System.out.println("找到：" + matcher.group("name2"));
        }
    }

    private static void test1(String content) {
        String regex = "(hun).*(nn11)";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
            System.out.println("找到：" + matcher.group(1));
            System.out.println("找到：" + matcher.group(2));
        }
    }
}
