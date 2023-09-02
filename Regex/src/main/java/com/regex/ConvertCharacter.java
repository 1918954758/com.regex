package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: convertCharacter
 * @Description: 转义字符的使用 \
 * @User: xdSun
 * @Date: 2023/08/29 17:49:21
 * @Version: 1.0
 **/
public class ConvertCharacter {
    /**
     * 需要使用到转义字符的字符，列举如下：
     *  * + ( ) $ / \ ? [ ] ^ { }
     *
     */
    public static void main(String[] args) {
        String content = "abc&(abc(123(";
        String regex = "\\(";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            // matcher.group(0); 获取的内容是匹配到的内容，比如 (
            System.out.println(matcher.group(0));
        }
    }
}
