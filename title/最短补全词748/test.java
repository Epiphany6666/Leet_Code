package title.最短补全词748;

public class test {
}

/*
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licenseCnt = getCnt(licensePlate);

        String ans = "";
        int cnt = Integer.MAX_VALUE;
        for (String word : words) {
            int[] cntWord = getCnt(word);
            int i = 0;
            for (i = 0; i < 26; i++) {
                if (licenseCnt[i] == 0) continue;
                if (cntWord[i] < licenseCnt[i]) break;
            }
            if (i >= 26 && cnt < word.length()) {
                ans = word;
                cnt = word.length();
            }
        }
        return ans;
    }

    private int[] getCnt(String str) {
        int[] cnt = new int[26];
        for (char c : str.toCharArray()) {
            cnt[Character.toLowerCase(c) - 'a']++;
        }
        return cnt;
    }
}*/

//method 三叶姐的做法是没有额外的统计字符串的长度
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licenseCnt = getCnt(licensePlate);

        String ans = null;
        for (String word : words) {
            int[] cntWord = getCnt(word);
            boolean ok = true;
//            for (int i = 0; i < 26; i++) {
//                if (cntWord[i] < licenseCnt[i]) break;
            for (int i = 0; i < 26 && ok; i++) {
                if (cntWord[i] < licenseCnt[i]) ok = false;
            }
            //note 真的很多粗心的小问题。。。
//            if (ok && (ans == null || ans.length() < word.length())) ans = word;
            if (ok && (ans == null || ans.length() > word.length())) ans = word;
        }
        return ans;
    }

    private int[] getCnt(String str) {
        int[] cnt = new int[26];
        for (char c : str.toCharArray()) {
//            cnt[Character.toLowerCase(c) - 'a']++;
            //note 这里还需要判断是不是字母！！！
            if (Character.isLetter(c)) cnt[Character.toLowerCase(c) - 'a']++;
        }
        return cnt;
    }
}