package title.编辑距离72;

public class test {
}

//method 1：递归（超时）
/*
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 || len2 == 0) {
            return Math.max(word1.length(), word2.length());
        }

        if (word1.charAt(len1 - 1) == word2.charAt(len2 - 1)) {
            return minDistance(word1.substring(0, len1 - 1), word2.substring(0, len2 - 1));
        }

        int insert = minDistance(word1, word2.substring(0, len2 - 1));
        int replace = minDistance(word1.substring(0, len1 - 1), word2.substring(0, len2 - 1));
        int delete = minDistance(word1.substring(0, len1 - 1), word2);
        return Math.min(insert, Math.min(replace, delete)) + 1;
    }
}*/

//method 2：动态规划
//mind 动态规划真的是一学就会，一写就废啊。。。
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] op = new int[len1 + 1][len2 + 1];
        //初始化
        for (int j = 1; j < len2; j++) {
            op[0][j] = op[0][j - 1] + 1;
        }

        for (int i = 1; i < len1; i++) {
            op[i][0] = op[i - 1][0] + 1;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) op[i][j] = op[i - 1][j - 1];
                else op[i][j] = Math.min(op[i - 1][j - 1], Math.min(op[i - 1][j], op[i][j - 1])) + 1;
            }
        }
        return op[len1][len2];
    }
}