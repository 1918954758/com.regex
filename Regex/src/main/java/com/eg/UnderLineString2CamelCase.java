package com.eg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Name: UnderLineString2CamelCase
 * @Description: 下横线转驼峰
 * @User: xdSun
 * @Date: 2023/09/03 01:19:04
 * @Version: 1.0
 **/
public class UnderLineString2CamelCase {
    public static void main(String[] args) {
        underLineString2amelCase();
    }
    /**
     * 实现 下横线字符串 转小驼峰
     * 支持 每个字符串中存在三个或者三个以内的下横线
     * 更多的下横线，需要调整代码（微调）
     */
    private static void underLineString2amelCase() {
        String[] content = {"a_zi_ch_en", "b_zch_en", "c_zhen", "d_zen", "e_zn"};
        for (String s : content) {
            int count = groups(s);
            String regex = "";
            if (count == 3) {
                regex = "_(\\w)\\w+_(\\w)\\w+_(\\w)";
            } else if (count == 2) {
                regex = "_(\\w)\\w+_(\\w)";
            } else if (count == 1 | count == 0) {
                regex = "_(\\w)";
            }
            Pattern compile = Pattern.compile(regex);
            Matcher matcher = compile.matcher(s);
            String[] groups = new String[]{"", "", "", "", "", "", "", "", "", ""};
            while (matcher.find()) {
                for (int i = 1; i <= count; i++) {
                    groups[i - 1] = matcher.group(i) != null ? matcher.group(i).toUpperCase() : "";
                }
            }
            String s1 = s;
            for (String group : groups) {
                if (!group.equals("")) {
                    s1 = s1.replaceFirst("_\\w", group);
                }
            }
            System.out.println("@JsonFormat(xxx)");
            System.out.println("private String " + s1 + ";\n");
        }
    }

    private static int groups(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.contains("_")) {
                s = s.replaceFirst("_", "");
                count++;
            }
        }
        return count;
    }
}
