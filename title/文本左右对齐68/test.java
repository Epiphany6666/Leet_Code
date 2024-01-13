package title.文本左右对齐68;

import java.util.ArrayList;
import java.util.List;

public class test {
}

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int cnt = 0; // 用来记录字符个数
        int bg = 0; // 开始处理的索引
        for (int i = 0; i < words.length; i++) {
            // note 记得把后面的空格也加上
//            cnt += words[i].length();
            cnt += words[i].length() + 1;
            // note 这里并不会越界
            if (i == words.length - 1 || cnt + words[i + 1].length() > maxWidth) {
//                ans.add(fillWords(words, bg, i, maxWidth, i == words.length));
                ans.add(fillWords(words, bg, i, maxWidth, i == words.length - 1));
                bg = i + 1;
                cnt = 0;
            }
        }
        return ans;
    }

    private String fillWords(String[] words, int begin, int end, int maxWidth, boolean lastLine) {
        int wordCount = end - begin + 1;
        int spaceCount = maxWidth + 1 - wordCount;
        for (int i = begin; i <= end; i++) {
            spaceCount -= words[i].length();
        }

        int spaceSuffix = 1;
        int spaceAvg = wordCount == 1 ? 1 : spaceCount / (wordCount - 1);
        int spaceExtra = (wordCount == 1) ? 0 : spaceCount % (wordCount - 1);

        StringBuffer ans = new StringBuffer();
        for (int i = begin; i < end; i++) {
            ans.append(words[i]);
//           单独处理最后一行
            if (lastLine) {
                ans.append(' ');
                continue;
            }
            int cnt = spaceSuffix + spaceAvg + (i - begin < spaceExtra ? 1 : 0);
            for (int j = 0; j < cnt; j++) {
                ans.append(' ');
            }
        }
//        单独处理最后一个单词
        ans.append(words[end]);
//        int cnt = maxWidth - ans.length();
//        for (int i = 0; i < cnt; i++) ans.append(' ');
        while (ans.length() < maxWidth) ans.append(' ');
        return ans.toString();
    }
}