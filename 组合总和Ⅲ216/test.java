package title.组合总和Ⅲ216;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        new Solution().combinationSum3(9, 45);
    }
}

/*
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i = 1; i <= 9; i++) {
//            dfs(k, n, i + 1, new ArrayList<>(i));
            List<Integer> list = new ArrayList<>();
            list.add(i);
//            dfs(k - 1, n - i, i + 1, new ArrayList<>(i));
            dfs(k - 1, n - i, i + 1, list);
        }
        return ans;
    }

    private void dfs(int k, int n, int start, List<Integer> path) {
//        if (k < 0 || n < 0 || start > 9) return;
        if (k < 0 || n < 0 ) return;
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //note 大于9必须在后面判断！
        if (start > 9) return;

        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(k - 1, n - i, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}*/

//method 我写的太乱了，其实主方法里面根本不用写for
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n);
        return ans;
    }

    private void backtrack(int count, int k, int n) {
        if (k < 0 || n < 0) return;
        if (k == 0 && n == 0) ans.add(new ArrayList<>(temp));

        for (int i = count; i <= 9; i++) {
            temp.add(i);
            backtrack(i + 1, k - 1, n - i);
            temp.remove(temp.size() - 1);
        }
    }
}