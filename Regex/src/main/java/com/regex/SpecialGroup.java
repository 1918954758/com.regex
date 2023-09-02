package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: SpecialGroup
 * @Description: 特殊分组
 *
 *      ?  表示询问
 *      =  表示是否匹配后面的正则表达式
 *      !  表示是否不匹配后面的表达式
 *      <  反向匹配
 *      (?:pattern)         匹配pattern但是不捕获该匹配的子表达式，即它是一个非捕获匹配，
 *                              不存储供以后使用的匹配，这对于用“|”组合的表达式有优化效果，
 *                              比如：industr(?:y|ies) 比 industry|industries 更加经济
 *      (?=pattern)         非捕获匹配，正向肯定预查，匹配 pattern 前面的位置，也就是()前面的位置
 *                              比如：Windows(?=95|98|NT|2000) 能匹配 Windows2000 中的 Windows
 *                                     但不能匹配 Windows3.1 中的 Windows
 *      (?!pattern)         非捕获匹配，正向否定预查，在任何不匹配 pattern 的字符串开始处匹配查找字符串
 *                              比如：Windows(?!95|98|NT|2000) 能匹配 Windows3.1 中的 Windows
 *                                     但不能匹配 Windows95 前面的 Windows
 *      (?<=pattern)        反向肯定预查，与正向肯定预查类似，只是方向相反
 *                              比如： (?<=95|98|NT|2000)Windows 能匹配 2000Windows 中的 Windows
 *                                  但不能匹配 3.1Windows 中的 Windows
 *      (?<!pattern)        反向否定预查，与正向否定预查类似，只是方向相反
 *                              比如： (?<!95|98|NT|2000)Windows 能匹配 3.1Windows 中的 Windows
 *                                  但不能匹配 95Windows 中的 Windows
 *      注：预查不消耗字符，也就是说，在一个匹配发生后，在最后一次匹配之后立即开始下一次匹配的搜索，而不是从包含预查的字符之后开始。
 *      (?:pattern)Windows 和 (?=pattern)Windows (?!pattern)Windows (?<=pattern)Windows (?<!pattern)Windows的区别：
 *      (?:pattern)Windows 匹配的字符不关包含Windows，同时和匹配pattern的内容
 *      (?=pattern)Windows (?!pattern)Windows (?<=pattern)Windows (?<!pattern)Windows只匹配Windows内容
 * @User: xdSun
 * @Date: 2023/08/30 12:37:47
 * @Version: 1.0
 **/
public class SpecialGroup {
    public static void main(String[] args) {
        String content = "Windows095 Windows198 Windows2NT Windows32000 Windows43.1 95Windows5 98Windows6 NTWindows7 2000Windows8 3.1Windows9";
        System.out.println("1：=======================================>");
        // (?=pattern)
        test1(content);
        System.out.println("2：=======================================>");
        // (?!pattern)
        test2(content);
        System.out.println("3：=======================================>");
        // (?<=pattern)
        test3(content);
        System.out.println("4：=======================================>");
        // (?<!pattern)
        test4(content);
        System.out.println("5：=======================================>");
        // (?:pattern)  正向使用
        test5(content);
        System.out.println("6：=======================================>");
        // (?:pattern)  反向使用
        test6(content);
    }

    private static void test6(String content) {
        String regex = "(?:95|98|NT|2000)Windows[\\d]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }

    private static void test5(String content) {
        String regex = "Windows[\\d](?:95|98|NT|2000)";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }

    private static void test4(String content) {
        String regex = "(?<!95|98|NT|2000)Windows[\\d]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }

    private static void test3(String content) {
        String regex = "(?<=95|98|NT|2000)Windows[\\d]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }

    private static void test2(String content) {
        String regex = "Windows[\\d](?!95|98|NT|2000)";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }

    private static void test1(String content) {
        String regex = "Windows[\\d](?=95|98|NT|2000)";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
