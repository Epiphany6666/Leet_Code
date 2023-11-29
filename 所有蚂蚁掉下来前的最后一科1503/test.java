package title.所有蚂蚁掉下来前的最后一科1503;

public class test {
}

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int i : left) {
            //note left表示的是往左移动的蚂蚁现在所在的位置！
//            ans = Math.max(ans, n - i);
            ans = Math.max(ans, i);
        }

        for (int i : right) {
//            ans = Math.max(ans, i);
            ans = Math.max(ans, n - i);
        }
        return ans;
    }
}