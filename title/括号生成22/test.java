package title.括号生成22;

import java.util.ArrayList;
import java.util.List;

public class test {
}

/*//法1：减法
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        dfs("", n, n, ans);
        return ans;
    }

    private void dfs(String s, int left, int right, List<String> ans) {
        if (left == 0 && right == left) {
            ans.add(s);
            return;
        }
        if (left > right) return;
        if (left > 0) dfs(s + "(", left - 1, right, ans);
        if (right > 0) dfs(s + ")", left, right - 1, ans);
    }
}*/


//法2：加法
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        dfs(ans, 0, 0, n, "");
        return ans;
    }

    private void dfs(List<String> ans, int left, int right, int n, String s) {
        if (left == n && left == right) {
            ans.add(s);
            return;
        }
        if (right > left) return;
        if (left < n) dfs(ans, left + 1, right, n, s + "(");
        if (right < n) dfs(ans, left, right + 1, n, s + ")");
    }
}