package title.LCR_187_破冰游戏;

import java.util.ArrayList;

public class test {
}

/**
 * 至于这种思路的代码实现，我尝试了下 LinkedList 会超时，我猜是因为 LinkedList 虽然删除指定节点的时间复杂度是 O(1)O(1)O(1) 的，但是在 remove 时间复杂度仍然是 O(n)O(n)O(n) 的，因为需要从头遍历到需要删除的位置。那 ArrayList 呢？索引到需要删除的位置，时间复杂度是 O(1)O(1)O(1)，删除元素时间复杂度是 O(n)O(n)O(n)（因为后续元素需要向前移位）， remove 整体时间复杂度是 O(n)O(n)O(n) 的。看起来LinkedList 和 ArrayList 单次删除操作的时间复杂度是一样的 ？所累哇多卡纳！ArrayList 的 remove 操作在后续移位的时候，其实是内存连续空间的拷贝的！所以相比于LinkedList大量非连续性地址访问，ArrayList的性能是很 OK 的！
 */
//method 1：模拟链表
class Solution {
    public int iceBreakingGame(int n, int target) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + target - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}

//method 2：数学解法
class Solution2 {
    public int iceBreakingGame(int num, int target) {
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            ans = (ans + target) % i;
        }
        return ans;
    }
}