package title.安排电影院座位1386;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test {
}

/*
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            Set<Integer> set = map.getOrDefault(reservedSeat[0], new HashSet<>());
            set.add(reservedSeat[1]);
            map.put(reservedSeat[0], set);
        }

        int ans = 2 * n;
        for (Integer row : map.keySet()) {
            Set<Integer> set = map.get(row);
            int cnt = 0;
            if (isOk(2, 5, set)) {
                cnt++;
                if (isOk(6, 9, set)) {
                    cnt++;
                    //note 如果这两种情况都成立，但是少考虑了一种情况，就是4，7之间是没有的，所以此时应该将它加上
                    if (!isOk(4, 7, set)) cnt--;
                }
            } else {
                if(isOk(4, 7, set)) {
                    cnt++;
//                    if (isOk(6, 9, set)) {
//                        cnt++;
//                    }
                } else if (isOk(6, 9, set)) {
                    cnt++;
                }
//                ans -= cnt;
            }
            ans -= cnt;
        }
        return ans;
    }

    private boolean isOk(int i, int i1, Set<Integer> set) {
        for (int j = i; j <= i1; j++) {
            if (set.contains(j)) return true;
        }
        return false;
    }
}*/

//还是这样好理解，嘿嘿
/*
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            Set<Integer> set = map.getOrDefault(reservedSeat[0], new HashSet<>());
            set.add(reservedSeat[1]);
            map.put(reservedSeat[0], set);
        }

        int ans = 2 * n;
        for (Integer row : map.keySet()) {
            Set<Integer> set = map.get(row);
            int cnt = 0;
            //考虑2,5之间知否有
            if (isOk(2, 5, set)) {
                cnt++;
            }

            //考虑6，9之间是否有
            if (isOk(6, 9, set)) {
                cnt++;
                //这里还有一种特殊情况：就是2,5有，但是都在最左边；6,9有，但是都在最右边，而此时4,7就符合条件，不需要减去
                if (isOk(2, 5, set) && !isOk(4, 7, set)) cnt--;
            }
            ans -= cnt;
        }
        return ans;
    }


    private boolean isOk(int i, int i1, Set<Integer> set) {
        for (int j = i; j <= i1; j++) {
            if (set.contains(j)) return true;
        }
        return false;
    }
}*/

//method 2：位运算
//mind 看完答案有点似懂非懂。。。
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int left = 0b11110000;
//        int middle = 0b00111100;
        int middle = 0b11000011;
        int right = 0b00001111;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int origin = map.containsKey(seat[0]) ? map.get(seat[0]) : 0;
            int value = origin | (1 << (seat[1] - 2));
//            map.put(origin, value);
            map.put(seat[0], value);
        }

//        int ans = 0;
        int ans = (n - map.size()) * 2;
        for (Integer value : map.values()) {
//            if ((value | left) == 0 || (value | middle) == 0 || (value | right) == 0) {
            if ((value | left) == left || (value | middle) == middle || (value | right) == right) {
                ans++;
            }
        }
        return ans;
    }
}