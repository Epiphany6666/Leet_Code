package 周赛.第363场.第2;

import java.util.Collections;
import java.util.List;

public class test {
}

/*
class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int ans = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (Integer num : nums) {
            dq.offer(num);
        }
        while (!dq.isEmpty()) {
            int x = dq.poll();
            int cnt = 1;
            while (!dq.isEmpty() && dq.peek() == x) {
                dq.poll();
                cnt++;
            }
            while (!dq.isEmpty() && cnt <= x) {
                x = Math.max(x, dq.poll());
                cnt++;
            }
            if (cnt <= x || (!dq.isEmpty() && dq.peek() <= cnt)) break;
            ans++;
        }
        return ans;
    }
}*/

class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int ans = 0;
        if (nums.get(0) != 0) ans++;
        for (int i = 0; i < nums.size(); i++) {
            if (i < nums.size() - 1 && nums.get(i) == nums.get(i + 1)) continue;
            if (i + 1 > nums.get(i)) {
                if (i == nums.size() - 1) {
                    ans++;
                } else {
                    if (i + 1 < nums.get(i + 1)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}