package title.Dota2参议院649;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

/*
class Solution {
    public String predictPartyVictory(String senate) {
        int cnt1 = 0, cnt2 = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') cnt1++;
            else cnt2++;
        }
        return cnt1 - cnt2 > 0 ? "Radiant" : "Dire";
    }
}*/

class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> radiant = new LinkedList<>();
        Deque<Integer> dire = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') radiant.offer(i);
            else dire.offer(i);
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int x = radiant.poll(), y = dire.poll();
            if (x < y) radiant.offer(x + n);
            else dire.offer(y + n);
        }
        return radiant.isEmpty() ? "Radiant" : "Dire";
    }
}