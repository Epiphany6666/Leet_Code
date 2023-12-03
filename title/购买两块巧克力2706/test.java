package title.购买两块巧克力2706;

import java.util.Arrays;

public class test {
    public static void main(String[] args){
        int[] price = { 3, 5, 6};
        System.out.println(new Solution().buyChoco(price, 13));
    }
}
/*class Solution{
    public int buyChoco(int[] prices, int money) {
        double min1 = 1/ 0.0,  min2 = 1/ 0.0;
        for (int i : prices) {
            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }
        }
        if ((int)min1 + (int)min2 <= money) {
            return money - (int)min1 - (int)min2;
        }
        return money;
    }
}*/
/*class Solution{
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return (prices[0] + prices[1] <= money) ? (money - prices[0] - prices[1]) : money;
    }
}*/

class Solution{
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int temp = prices[0] + prices[1];
        return temp <= money ? money - temp : money;
    }
}
