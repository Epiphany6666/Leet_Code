package title.统计共同度过的日子数2409;

public class test {
}

class Solution {
    private final static int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String a = arriveAlice.compareTo(arriveBob) < 0 ? arriveBob : arriveAlice;
//        String b = leaveAlice.compareTo(leaveBob) < 0 ? leaveBob : leaveAlice;
        String b = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
//        return Math.max(f(a) - f(b) + 1, 0);
        return Math.max(f(b) - f(a) + 1, 0);
    }

    private int f(String a) {
        int ans = 0;
        for (int i = 0; i < Integer.parseInt(a.substring(0, 2)) - 1; i++) {
            ans += month[i];
        }
        ans += Integer.parseInt(a.substring(3));
        return ans;
    }
}