package 周赛.第361场.生成特殊数字的最少操作8040;
/**
 * 总结
 * 1.判断字符串里面是否有子字符串，可以使用contains方法。
 */

public class test {
}

/*
class Solution {
    public int minimumOperations(String num) {
        for (int i = 0; i < num.length(); i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < num.length(); j++) {
                if (j != i) {

                }
            }
        }
    }
}*/

//害，没一点思路，没一点数学思维啊。。。
class Solution {
    int ans;
    public int minimumOperations(String num) {
        ans = num.length();
        if (num.contains("0")) ans--;
        f(num, "00");
        f(num, "25");
        f(num, "50");
        f(num, "75");
        return ans;
    }

    public void f(String num, String tail) {
        int n = num.length();
        int i = num.lastIndexOf(tail.charAt(1));
        if (i < 0) return;
        i = num.lastIndexOf(tail.charAt(0), i - 1);
        if (i < 0) return;
        ans = Math.min(ans, n - i - 2);
    }
}
