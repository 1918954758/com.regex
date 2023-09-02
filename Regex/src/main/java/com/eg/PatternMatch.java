package com.eg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: PatternMatch
 * @Description: 模式匹配
 * @User: xdSun
 * @Date: 2023/09/02 17:00:03
 * @Version: 1.0
 **/
public class PatternMatch {
    public static void main(String[] args) {
        patternMatch();
        String[] context1 = {"Windows98", "Windows", "Windows97", "Windows3.1", "Windows2000"};

        System.out.println("Windows(?:98|97|3.1|2000)============================>start");
        String regex1 = "Windows(?:98|97|3.1|2000)";// 匹配的内容会包含Windows，同时也包含98、97等
        // xxxx(?:pattern)
        test(context1, regex1);
        System.out.println("Windows(?:98|97|3.1|2000)============================>end\n");

        System.out.println("Windows(?=98|97|3.1|2000)============================>start");
        String regex2 = "Windows(?=98|97|3.1|2000)";// 只匹配 Windows，但不会包含98、97等
        // xxxx(?=pattern)
        test(context1, regex2);
        System.out.println("Windows(?=98|97|3.1|2000)============================>end\n");

        System.out.println("Windows(?=98|97|3.1|2000)============================>start");
        // xxxx(?!pattern)
        String regex3 = "Windows(?!98|97|3.1|2000)";
        test(context1, regex3);
        System.out.println("Windows(?=98|97|3.1|2000)============================>end\n");


        String[] context2 = {"98Windows", "Windows", "97Windows", "3.1Windows", "2000Windows"};

        System.out.println("(?:98|97|3.1|2000)Windows============================>start");
        // (?:pattern)xxxx
        String regex4 = "(?:98|97|3.1|2000)Windows";
        test(context2, regex4);
        System.out.println("(?:98|97|3.1|2000)Windows============================>end\n");

        System.out.println("(?:98|97|3.1|2000)Windows============================>start");
        String regex5 = "(?<=98|97|3.1|2000)Windows";
        // (?<=pattern)xxxx
        test(context2, regex5);
        System.out.println("(?<=98|97|3.1|2000)Windows============================>end\n");

        System.out.println("(?:98|97|3.1|2000)Windows============================>start");
        String regex6 = "(?<!98|97|3.1|2000)Windows";
        // (?<!pattern)xxxx
        test(context2, regex6);
        System.out.println("(?<=98|97|3.1|2000)Windows============================>end\n");
    }



    private static void test(String[] context, String regex) {
        for (String s : context) {
            Pattern compile = Pattern.compile(regex);
            Matcher matcher = compile.matcher(s);
            while (matcher.find()) {
                System.out.println("找到：" + matcher.group(0));
            }
        }
    }

    private static void patternMatch() {
        String[] content = {
                "子辰",// 汉字
                "300000",// 邮政编码（1-9开头的6位数字）
                "1918954747",// QQ号码（1-9开头的5-10位数）
                "18516549245"// 手机号（由13、14、15、18开头的11位数）
        };
        String[] regex = {
                "^[\u0391-\uffe5]+$",// 汉字
                "^[1-9]\\d{5}$",// 邮政编码
                "^[1-9]\\d{4,10}$",// QQ号码
                "^(?:13|14|15|18)\\d{9}$"// 手机号
        };
        for (int i = 0; i < 4; i++) {
            Pattern compile = Pattern.compile(regex[i]);
            Matcher matcher = compile.matcher(content[i]);
            while (matcher.find()) {
                System.out.println("验证：" + matcher.group(0));
            }
        }
    }
}
