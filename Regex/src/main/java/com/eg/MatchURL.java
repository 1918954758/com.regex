package com.eg;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: MatchURL
 * @Description: 匹配URL
 * @User: xdSun
 * @Date: 2023/09/02 18:07:03
 * @Version: 1.0
 **/
public class MatchURL {
    public static void main(String[] args) {
        String[] content={"https://www.bilibili.com/",
                "https://www.bilibili.com/video/BV1QS4y1G7KU?spm_id_from=333.851.b_7265636f6d6d656e64.1",
                "http://www.bilibili.com/video/BV1sJ411a7dG/?spm_id_from=333.788.recommend_more_video.2",
                "https://www.bilibili.com/video/BV1sJ411a7dG/?spm_id_from=333.788.recommend_more_video.2",
                "https://www.bilibili.com/video/BV16m4y1R7Q2?spm_id_from=333.851.b_62696c695f7265706f72745f646f756761.12",
                "http://www.bilibili.com/video/BV16m4y1R7Q2?spm_id_from=333.851.b_62696c695f7265706f72745f646f756761.12",
                "https://www.biliBili.com/video/BV16m4y1R7Q2?spm_id_from=333.851.b_62696c695f7265706f72745f646f756761.12",
                "https://www.bilibili.com/video/BV1nL411N7FV?spm_id_from=333.851.b_62696c695f7265706f72745f646f756761.42"};
//        String regex = "^(http)s?://www.bilibili.com/([\\p{Alnum}\\p{Punct}]+)?$";
//        String regex = "^(http)s?://[w]{3}\\.[\\p{Lower}\\p{Digit}]+\\.com/([\\p{Alnum}\\p{Punct}]+)?$";
        String regex = "^htt(?:p|ps)://[w]{3}\\.[\\w]+\\.com/([\\w=?./&%-]*)?$";
//        String regex = "^(http)s?://www.bilibili.com/[\\w=?./&%-]*$";//网上的写法
        test(content, regex);


    }

    private static void test(String[] content, String regex) {
        for (String s : content) {
            Pattern compile = Pattern.compile(regex);
            Matcher matcher = compile.matcher(s);
            while (matcher.find()) {
                System.out.println("找到：" + matcher.group(0));
            }
        }
    }
}
