package title.餐厅过滤器1333;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class test {
}

/*
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> (i - j));
        for (int[] restaurant : restaurants) {
//            if (pq.isEmpty() || pq.peek() != restaurant[1]) {
                pq.offer(restaurant[1]);
//            }
        }
    }
}*/

/*//mind 看完答案又觉得很简单了。。。
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> {
            if (i[1] != j[1]) {
                return j[1] - i[1];
            } else {
                return j[0] - i[0];
            }
        });

        for (int[] restaurant : restaurants) {
        //note  ！
//            if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance && !(veganFriendly == 1 && restaurant[2] == 1)) {
            if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance && !(veganFriendly == 1 && restaurant[2] == 0)) {
                pq.offer(restaurant);
            }
        }

        List<Integer> ans = new ArrayList<>();
        //note 不能这样遍历pq！
        for (int[] i : pq) {
            ans.add(i[0]);
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll()[0]);
        }
        return ans;
    }
}*/

//mind 为啥堆排序过不了啊    原来是因为粗心！
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> filters = new ArrayList<>();

        for (int[] restaurant : restaurants) {
            if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance && !(veganFriendly == 1 && restaurant[2] == 0)) {
                filters.add(restaurant);
            }
        }

        Collections.sort(filters, (i, j) -> {
            if (i[1] != j[1]) {
                return j[1] - i[1];
            } else {
                return j[0] - i[0];
            }
        });

        List<Integer> ans = new ArrayList<>();

        for (int[] filter : filters) {
            ans.add(filter[0]);
        }
        return ans;
    }
}