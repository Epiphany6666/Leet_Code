package title.猜数字游戏299;

public class test {
}

/**
 * 参考题解：宫水三叶
 */
class Solution {
    public String getHint(String secret, String guess) {
        int x = 0, y = 0;
//        int[] cnt1 = new int[9], cnt2 = new int[9];
        int[] cnt1 = new int[10], cnt2 = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int c1 = secret.charAt(i) - '0', c2 = guess.charAt(i) - '0';
            if (c1 == c2) x++;
            else {
                cnt1[c1]++;
                cnt2[c2]++;
            }
        }
//        for (int i = 0; i < 9; i++) {
        for (int i = 0; i < 10; i++) {
            y += Math.min(cnt1[i], cnt2[i]);
        }
        return x + "A" + y + "B";
    }
}