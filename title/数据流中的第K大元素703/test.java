package title.数据流中的第K大元素703;

import javax.print.DocFlavor;
import java.util.PriorityQueue;

public class test {
}

/*class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> (j - i));
    public KthLargest(int k, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //note 这里就算修改为等于，那它也不会走底下那个分支了，但如果是小于，等于的时候
            //就会走下面那个分支，而下面那个分支的大小永远<k，所以我的做法很明显不正确
            if (pq.size() <= k) {
                pq.offer(nums[i]);
            } else {
//                pq.poll();
//                pq.offer(nums[i]);
                pq.offer(nums[i]);
                pq.poll();
            }
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else {
            pq.offer(val);
            pq.poll();
//            pq.poll();
//            pq.offer(val);
        }
        return pq.peek();
    }
}*/


class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}
