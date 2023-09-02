package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: FindIndex
 * @Description: 正则查询索引
 * @User: xdSun
 * @Date: 2023/09/02 22:13:10
 * @Version: 1.0
 **/
public class FindIndex {
    public static void main(String[] args) {
        String content = "hello edu jack tom hello smith hello";
        String regex = "\\bhello\\b";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
//        String newContent = "";
        while (matcher.find()) {
            System.out.println("----------------------");
            System.out.println(matcher.start());// 取得 hello 的开始索引 0   19  31
            System.out.println(matcher.end());  // 取得 hello 的结束索引 5   24  36
            System.out.println(content.substring(matcher.start(), matcher.end()));
            // matcher 自带的 replaceAll 方法不会破坏原串，它会返回一个新串
            System.out.println(content.replaceAll("\\bedu\\b", "ziChen"));
//            newContent = content.replaceAll("\\bedu\\b", "ziChen");
        }
        System.out.println(content);
    }
}
