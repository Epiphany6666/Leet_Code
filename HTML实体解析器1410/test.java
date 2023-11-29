package title.HTML实体解析器1410;

import java.util.HashMap;

public class test {
}

class Solution {
    public String entityParser(String text) {
        HashMap<String, String> map = new HashMap<>(){{
            put("&quot;", "\"");
            put("&apos;", "'");
            put("&amp;", "&");
            put("&gt;", ">");
            put("&lt;", "<");
            put("&frasl;", "/");
        }};

        int n = text.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ) {
            if (text.charAt(i) == '&') {
                int j = i + 1;
                while (j < n && j - i < 6 && text.charAt(j) != ';') j++;
                String sub = text.substring(i, Math.min(j + 1, n));
                if (map.containsKey(sub)) {
                    sb.append(map.get(sub));
                    i = j + 1;
                    continue;
                }
            }
            sb.append(text.charAt(i++));
        }
        return sb.toString();
    }
}