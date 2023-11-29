package title.俄罗斯套娃信封问题354;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
//        new Solution().maxEnvelopes(new int[][] {{2, 100},{3,200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}});
    }
}

//method 通过这个测试用例我好像明白为什么排序会不行了
//[[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]
/*
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (i, j) -> {
            //这里还需要考虑宽度相等的情况，应该装高度最小的
            if (i[0] != j[0]) {
                return i[0] - j[0];
            } else {
                return i[1] - j[1];
            }
        });
        int ans = 0;
        int w = 0, h = 0;
        for (int[] envelope : envelopes) {
            if (w < envelope[0] && h < envelope[1]) {
                ans++;
                w = envelope[0];
                h = envelope[1];
            }
        }
        return ans;
    }
}*/

//method 1：动态规划
/*
class Solution {
    public int maxEnvelopes(int[][] envelopes) {

    }
}*/
