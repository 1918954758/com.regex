package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: Find2UpperOrLower
 * @Description: 特殊元字符匹配
 *
 *  \p{Lower}           匹配小写字母 [a-z]
 *  \p{Upper}           匹配大写字母 [A-Z]
 *  \p{ASCII}           匹配所有ASCII码 [\x00-\x7F]
 *  \p{Alpha}           匹配大写字母或小写字母 [\p{Lower}\p{Upper}] or [a-zA-Z]
 *  \p{Digit}           匹配数字 [0-9]
 *  \p{Alnum}           匹配大写字母、小写字母或者数字 [\p{Alpha}\{Digit}] or [\p{Lower}\p{Upper}\p{Digit}]
 *  \p{Punct}           匹配所有符号 One of !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
 *  \p{Graph}           匹配大小写字母、数字或者符号 [\p{Alnum}\p{Punct}]
 *  \p{Print}           匹配可打印字符 [\p{Graph}\x20]
 *  \p{Blank}           匹配空格或者制表符 [ \t]
 *  \p{Cntrl}           匹配控制字符 [\x00-\x1F\x7F]
 *  \p{XDigit}          匹配十六进制数 [0-9a-fA-F]
 *  \p{Space}           匹配空白符 [ \t\n\x0B\f\r]
 *
 * @User: xdSun
 * @Date: 2023/08/29 20:58:31
 * @Version: 1.0
 **/
public class SpecialOrginCharacter {
    public static void main(String[] args) {
        String content = "abc";
        String regex = "\\p{Lower}";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }

}
