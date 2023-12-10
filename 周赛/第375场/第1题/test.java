package 周赛.第375场.第1题;

public class test {
}

class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                ans++;
                for (int j = i + 1; j < batteryPercentages.length; j++) {
                    batteryPercentages[j]--;
                }
            }
        }
        return ans;
    }
}