package 双周赛.第113场双周赛;

import java.util.*;

public class test {
    public static void main(String[] args) {
//        new Solution().minLengthAfterRemovals(new ArrayList<>(Arrays.asList(1,1,2,3,4,4)));
    }
}

/*
class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int len = nums.size();
        int[] min = new int[2];
        min[0] = nums.get(0);
        for (int i = 0; i < len; i++) {
            if (nums.get(i) < min[0]) {
                min[0] = nums.get(i);
                min[1] = i;
            }
        }
        int[] n = new int[len];
        int idx = 0;
        for (int i = min[1]; i < len; i++) {
            n[idx++] = nums.get(i);
        }
        for (int i = 0; i < min[1]; i++) {
            n[idx++] = nums.get(i);
        }

        for (int i = 1; i < len; i++) {
            if (n[i] < n[i - 1]) return -1;
        }
        return min[1] == 0 ? 0 : len - min[1];
    }
}
*/

/*
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(nums.get(0));
        for (int i = 1; i < nums.size(); i++) {
            if (!dq.isEmpty() && nums.get(i) > dq.peek()) {
                dq.poll();
            } else {
                dq.offer(nums.get(i));
            }
        }
        return dq.size();
    }
}*/

/*class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(nums.get(nums.size() - 1));
        for (int i = nums.size() - 2; i > 0 ; i--) {
            if (!dq.isEmpty() && nums.get(i) <= dq.peek()) {
                dq.poll();
            } else {
                dq.offer(nums.get(i));
            }
        }
        return dq.size();
    }
}*/

/*
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int cnt1 = minLengthAfterRemovals1(nums);
        int cnt2 = minLengthAfterRemovals2(nums);
        return Math.min(cnt1, cnt2);
    }

    public int minLengthAfterRemovals1(List<Integer> nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(nums.get(nums.size() - 1));
        for (int i = nums.size() - 2; i >= 0 ; i--) {
            if (!dq.isEmpty() && nums.get(i) < dq.peek()) {
                dq.poll();
            } else {
                dq.offer(nums.get(i));
            }
        }
        return dq.size();
    }

    public int minLengthAfterRemovals2(List<Integer> nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(nums.get(0));
        for (int i = 1; i < nums.size(); i++) {
            if (!dq.isEmpty() && nums.get(i) > dq.peek()) {
                dq.poll();
            } else {
                dq.offer(nums.get(i));
            }
        }
        return dq.size();
    }
}*/

/*class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int size = coordinates.size();
        int ans = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int x1 = coordinates.get(i).get(0);
                int x2 = coordinates.get(j).get(0);
                int y1 = coordinates.get(i).get(1);
//                int y2 = coordinates.get(i).get(1);
                int y2 = coordinates.get(j).get(1);
                if (((x1 ^ x2) + (y1 ^ y2)) == k) ans++;
            }
        }
        return ans;
    }
}*/

/*
class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int size = coordinates.size();
        int ans = 0;
        HashMap<int[], Integer> map1 = new HashMap<>();
        HashMap<int[], Integer> map2 = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int x1 = coordinates.get(i).get(0);
                int x2 = coordinates.get(j).get(0);
                int y1 = coordinates.get(i).get(1);
//                int y2 = coordinates.get(i).get(1);
                int y2 = coordinates.get(j).get(1);
                int[] a = new int[] {x1, x2};
                int[] b = new int[] {y1, y2};
                if (Arrays.equals(a, ))
                int m = ((x1 ^ x2) + (y1 ^ y2));
                if (( + ) == k) ans++;
            }
        }
        return ans;
    }
}*/

/*
class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int size = coordinates.size();
        int ans = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int x1 = coordinates.get(i).get(0);
                int x2 = coordinates.get(j).get(0);
                int y1 = coordinates.get(i).get(1);
                int y2 = coordinates.get(j).get(1);
                int m = 0, n = 0;
                String a = x1 + "_" + x2;
                if (map1.containsKey(a)) {
                    m = map1.get(a);
                } else {
                    map1.put(a, x1 ^ x2);
                    m = map1.get(a);
                }
                String b = y1 + "_" + y2;
                if (map2.containsKey(b)) {
                    n = map2.get(b);
                } else {
                    map2.put(b, y1 ^ y2);
                    n = map2.get(b);
                }
                if ((m + n) == k) ans++;
            }
        }
        return ans;
    }
}*/

class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int size = coordinates.size();
        int ans = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int x1 = coordinates.get(i).get(0);
                int x2 = coordinates.get(j).get(0);
                int y1 = coordinates.get(i).get(1);
                int y2 = coordinates.get(j).get(1);
                int m = 0, n = 0;
                String a = x1 + "_" + x2;
                String a2 = x2 + "_" + x1;
                if (map1.containsKey(a)) {
                    m = map1.get(a);
                } else if (map1.containsKey(a2)){
                    m = map1.get(a2);
                } else {
                    map1.put(a, x1 ^ x2);
                    m = map1.get(a);
                }
                String b = y1 + "_" + y2;
                String b2 = y2 + "_" + y1;
                if (map2.containsKey(b)) {
                    n = map2.get(b);
                } else if (map2.containsKey(b2)){
                    map2.containsKey(b2);
                } else {
                    map2.put(b, y1 ^ y2);
                    n = map2.get(b);
                }
                if ((m + n) == k) ans++;
            }
        }
        return ans;
    }
}