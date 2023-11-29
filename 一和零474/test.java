package title.一和零474;
/**
 * 总结
 * 1.如果不是提前知道这是背包问题，我可能都不会往递归这个方向思考。。。。还是得有一套自己的思路，靠脑子单想想不到的话，就需要走套路了。
 * 2.一定要把这道题和求树的高度分开，每个结点确实都会走一遍，但是如果不选的话，高度是不能+1的！
 * 3.题目都已经说了strs里的字符串都已经是二进制了，计算1的方法居然还用(num >> i) & 1的方法来计算？
 *   我还特别麻烦的将字符串转为了int来计算，主要是我转为int之后，还没有考虑到int会超出范围的问题。明明直接字符串就能统计了啊，为什么要往很复杂的方向想？
 * 4.想到了递归，那一定要想想能不能用记忆化搜索来做，这样可以节省很多时间和空间
 */

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
//        System.out.println(new Solution().findMaxForm(strs, 4, 3));
    }
}

/*class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return dfs(strs, 0, m, n);
    }

    public int dfs(String[] strs, int depth, int m, int n) {
        if (depth == strs.length - 1 || m <= 0 || n <= 0) return 0;
        int count1 = count(strs[depth]);
        int count0 = strs[depth].length() - count1;
        return Math.max(dfs(strs, depth + 1, m - count0, n - count1), dfs(strs, depth + 1, m, n)) + 1;
    }

    public int count(String s) {
        int num = Integer.parseInt(s);//这里的m本来就是二进制位了，不能再用二进制位转为二进制位
        int ans = 0;
        while(num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}*/

/*class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return dfs(strs, 0, m, n);
    }

    public int dfs(String[] strs, int depth, int m, int n) {
//        if (depth >= strs.length || m <= 0 || n <= 0) return 0;//这里条件也有误，m=0的时候，n有可能不等于0
//        if (depth >= strs.length || m < 0 || n < 0) return 0;
        //递归结束条件还是不对，我这里将left和right分开算，但如果选了这层m<0或者n<0了呢？所以真正的递归出口应该是先判断当前层会不会让m或n<0
        //啊啊啊啊啊感觉也不对啊，本层如果没选的话，为什么要判断这个
        if (depth >= strs.length) return 0;
        int count1 = count(strs[depth]);
        int count0 = strs[depth].length() - count1;
        int left = 0;
        if (!(m - count0 < 0 || n - count1 < 0)) {//终于对了，就是这里，如果选了本层导致m或n小于0的话，就不能进行选择！，但是超时了
            left = dfs(strs, depth + 1, m - count0, n - count1) + 1;
        }
        int right = dfs(strs, depth + 1, m, n);
//        return Math.max(left, right) + 1;//right并没有选这层，为什么能＋1呢？
        return Math.max(left, right);
    }

    public int count(String s) {
        int num = Integer.parseInt(s);//这里的m本来就是二进制位了，不能再用二进制位转为二进制位
        int ans = 0;
        while(num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}*/

/**记忆化搜索*/
/*
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return dfs(strs, 0, m, n);
    }

    Map<String, Integer> map = new HashMap<>();
    public int dfs(String[] strs, int depth, int m, int n) {
        String s = depth + "_" + m + "_" + n;
        if (map.containsKey(s)) return map.get(s);
        if (depth >= strs.length) {
            map.put(s, 0);
            return map.get(s);
        }
        int count1 = count(strs[depth]);
        int count0 = strs[depth].length() - count1;
        int left = 0;
        if (!(m - count0 < 0 || n - count1 < 0)) {
            left = dfs(strs, depth + 1, m - count0, n - count1) + 1;
        }
        int right = dfs(strs, depth + 1, m, n);
        map.put(s, Math.max(left, right));
        return map.get(s);
    }

    //不超时了，但是int超过范围了，果然还是不能随意将s转为int
    */
/*public int count(String s) {
        int num = Integer.parseInt(s);
        int ans = 0;
        while(num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }*//*

    public int count(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') ans++;
        }
        return ans;
    }
}*/

/**动态规划 - 不会自己写，看答案了*/
/*
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] =
    }
}
class Node {
    int m, n;
}*/

/***/