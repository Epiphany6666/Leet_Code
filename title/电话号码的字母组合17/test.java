package title.电话号码的字母组合17;

//import org.junit.jupiter.api.Test;

import java.util.*;

public class test {
    public static void main(String[] args) {
        String digits = "34";
        new Solution().letterCombinations(digits);
    }
}

/*
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        int n = digits.length();
        char[][] temp = new char[n][n];
        for (int i = 0; i < n; i++) {
            int ch = digits.charAt(i) - '0';
            int i_ = ch + 94;
            switch(ch) {
                case 8:
                    temp = new char[n][3];
                    i_ = i + 96;
                    for (int j = 0; j < 3; j++) {
                        temp[i][j] = (char)(i_ + j);
                    }
                    break;
                case 7:
                    temp = new char[n][4];
                    for (int j = 0; j < 4; j++) {
                        temp[i][j] = (char)(i_ + j);
                    }
                    break;
                case 9:
                    temp = new char[n][4];
                    i_ = i + 96;
                    for (int j = 0; j < 4; j++) {
                        temp[i][j] = (char)(i_ + j);
                    }
                    break;
                default:
                    temp = new char[n][3];
                    for (int j = 0; j < 3; j++) {
                        temp[i][j] = (char)(i_ + j);
                    }
                    break;
            }
        }
        int a = n;
        for (int i = 0; i < a - 1; i++) {//循环的次数
            int b = temp[i].length;
            for (int k = 0; k < b; k++) {
                int c = temp[i + 1].length;
                for (int j = 0; j < c; j++) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(temp[i][k]);
                    sb.append(temp[i + 1][j]);
                    ans.add(sb.toString());
                }
            }
        }
        return ans;
    }
}*/

/*
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int n = digits.length();
        if (n == 0) return ans;
        Map<Character, String> phone = new HashMap<>();
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");
        StringBuffer path = new StringBuffer();
        dfs(ans, digits, n, 0, phone, path);
        return ans;
    }

    private void dfs(List<String> ans, String digits, int n, int depth, Map<Character, String> phone, StringBuffer path) {
        if (depth == n) {
            ans.add(path.toString());
            return;
        }
        String letter = phone.get(digits.charAt(depth));
        int m = letter.length();
        for (int i = 0; i < m; i++) {
            char ch = letter.charAt(i);
            path.append(ch);
            dfs(ans, digits, n, depth + 1, phone, path);
            path.deleteCharAt(depth);
        }
    }
}*/

//法2：队列
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) return combinations;
        int length = digits.length();
        Queue<String> queue = new LinkedList<>();
        Map<Character, String[]> phone = new HashMap<>();
        phone.put('2', new String[] {"a", "b", "c"});
        phone.put('3', new String[] {"d", "e", "f"});
        phone.put('4', new String[] {"g", "h", "i"});
        phone.put('5', new String[] {"j", "k", "l"});
        phone.put('6', new String[] {"m", "n", "o"});
        phone.put('7', new String[] {"p", "q", "r", "s"});
        phone.put('8', new String[] {"t", "u", "v"});
        phone.put('9', new String[] {"w", "x", "y", "z"});
        for (int i = 0; i < length; i++) {
            queue_(queue, phone.get(digits.charAt(i)));
        }
        for (String letter : queue) {
            combinations.add(letter);
        }
        return combinations;
    }

    private void queue_(Queue<String> queue, String[] letters) {
        if (queue.size() == 0) {
            for (String letter : letters) {
                queue.add(letter);
            }
        } else {
            int queue_size = queue.size();
            for (int i = 0; i < queue_size; i++) {
                String s = queue.poll();
                for (String letter : letters) {
                    queue.add(s + letter);
                }
            }
        }
    }
}