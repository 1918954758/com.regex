package com.regex;

import java.util.regex.Pattern;

/**
 * @Name: RegexClass
 * @Description: 正则表达式类
 * @User: xdSun
 * @Date: 2023/09/02 22:38:53
 * @Version: 1.0
 **/
public class RegexClass {
    /*
     * Pattern.class
     *      是一个正则表达式对象，没有公共构造方法，所以要创建一个 Pattern 对象，必须要借助其公共静态方法
     * Matcher.class
     *      是对输入字符串进行解释和匹配的引擎，与 Pattern 类一样，Matcher类也没有公共构造方法
     * PatternSyntaxException.class
     *      非强制异常，表示正则表达式中的语法错误
     */
    public void test() {
        Class<Pattern> patternClass = Pattern.class;
    }
}
