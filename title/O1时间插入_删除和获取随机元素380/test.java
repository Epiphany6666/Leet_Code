package title.O1时间插入_删除和获取随机元素380;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class test {
}

/**
 * random.nextInt()：返回一个伪随机的、均匀分布的 int 值，介于 0（含）和指定值（不含）之间
 */
class RandomizedSet {
    Map<Integer, Integer> map = new HashMap<>();
    static int[] nums = new int[2 * (int)1e5 + 10];
    int idx = -1;
    Random random = new Random();

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, ++idx);
        nums[idx] = val;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.remove(val);
        //note 不能写反
        //mind 被这句话给绕到了。。。
//        if (loc != idx) nums[loc] = nums[idx--];
//        map.put(nums[loc], loc);
        if (loc != idx) map.put(nums[idx], loc);
        nums[loc] = nums[idx--];
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }
}