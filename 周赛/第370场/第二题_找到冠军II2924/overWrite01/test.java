package 周赛.第370场.第二题_找到冠军II2924.overWrite01;

public class test {
}

/**
 * 参考题解：灵茶山艾府
 */
// mind 再做一次还是不会，哎
class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] isWeak = new boolean[n];
        for (int[] e : edges) {
            isWeak[e[1]] = true;
        }
        int ans = -1;
        for (int i = 0; i < isWeak.length; i++) {
            if (isWeak[i]) continue;
            if (ans != -1) {
                return -1;
            }
            ans = i;
        }
        return ans;
    }
}