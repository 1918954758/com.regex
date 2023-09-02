package com.regex;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: RegexExpReverse
 * @Description: 反向引用
 * @User: xdSun
 * @Date: 2023/09/02 22:54:59
 * @Version: 1.0
 **/
public class RegexExpReverse {
    public static void main(String[] args) {
        test();
    }

    /**
     * 需求：
     * 给定一段文本，找出所有四个数字连在一起的子串，
     * 并且要求这四个数字是回文序列（比如：1221,3443等）
     * 分组：
     * 圆括号组成的一个比较复杂的匹配模式，这个圆括号的部分就叫分组
     * 引用：
     * 把正则表达式中分组匹配的内容，保存到内存中以数字编号或显式命名的组里，方便后面引用，从左向右
     * 反向引用：
     * 圆括号的内容被捕获后，可以在这个括号中被使用，从而写出一个比较使用的匹配模式，这就被称为反向引用
     * 这种引用可以在正则表达式的外部，也可以在正则表达式的内部
     * 在外部使用 $ 分组号
     * 在内部使用 \\ 分组号
     */
    private static void test() {
        matchReverseInner();
        System.out.println("===============================");
        matchReverseOutter();
        System.out.println("===============================");
        demo();
    }

    private static void demo() {
        /*
         * 1.要匹配两个连续的相同数字
         * 2.要匹配五个连续的相同数字
         * 3.要匹配4位回文序列
         * 5.5位数-九位数(连续三位要相同)
         * */
        String content="1238418723426478377271231423-111222333777324723173432231-566538471278879710-000999222993993-3332321-12331331";
        String[] regStr={"(\\d)\\1","(\\d)\\1{4}","(\\d)(\\d)\\2\\1","\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}"};
        for(String i:regStr){
            Pattern pattern=Pattern.compile(i);
            Matcher matcher=pattern.matcher(content);
            while(matcher.find()){
                System.out.println("匹配到:"+matcher.group(0));
            }
        }
    }

    private static void matchReverseOutter() {
        String content = "_abc_edf_g";
//        String regex = "_(a)\\w+_(e)\\w+_(g)";
//        Pattern compile = Pattern.compile(regex);
//        Matcher matcher = compile.matcher(content);
//        while (matcher.find()) {
//            String group1 = matcher.group(0).replaceAll("(_a)\\w+(_e)\\w+(_g)", "$1$2$3");
//            System.out.println(group1);// _a_e_g
//        }
        String s = content.replaceAll("(_a)\\w+(_e)\\w+(_g)", "$1$2$3");
        System.out.println(s);
    }

    /**
     * 内部引用示例
     */
    private static void matchReverseInner() {
        String content = "122134435665877890900990";
        String regex = "(\\d)(\\d)\\2\\1";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
