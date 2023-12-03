package Leet_Code.可获得的最大点数1423;

/**
 * 逆向思维。。。
 */
public class test {
}

//method 滑动窗口＋逆向思维
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, cur = 0;
        int len = cardPoints.length, left = len - k;
        for (int i = 0; i < len; i++) {
            sum += cardPoints[i];
        }
        for (int i = 0; i < left; i++) {
            cur += cardPoints[i];
        }
        int min = cur;
        for (int i = left; i < len; i++) {
            cur = cur + cardPoints[i] - cardPoints[i - left];
            min = Math.min(min, cur);
        }
        return sum - min;
    }
}