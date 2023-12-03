package title.将数组和减半的最少操作次数2208;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 总结：不能直接用int除以2啊！！
 * Comparator.reverseOrder返回比较器以逆转自然排序。
 */
public class test {
}

/*class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (int i : nums) {
            pq.offer(i);
            sum += i;
        }
        int count = 0;
        int sub = 0;
        while (sub < sum / 2) {
            int x = pq.poll();
            sub += x / 2;
            pq.offer(x / 2);
            count++;
        }
        return count;
    }
}*/

class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;//double。。。sum相加就应该考虑溢出
        /*for (double i : nums) {
            pq.offer(i);
            sum += i;
        }*/
        for (int i : nums) {
            pq.offer(i * 1.0);
            sum += i;
        }
        int count = 0;
        /*double sub = 0;
        while (sub < (double)sum / 2) {
            double x = pq.poll();
            sub += x / 2;
            pq.offer(x / 2);
            count++;
        }*/
        sum /= 2;
        while (sum > 0) {
            double t = pq.poll() / 2;
            sum -= t;
            pq.offer(t);
            count++;
        }
        return count;
    }
}