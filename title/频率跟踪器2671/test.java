package title.频率跟踪器2671;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test {
}
// mind delete的时候记得注意特判，我已经因为这个wa了好几次。。。结果是超时。。。
class FrequencyTracker0 {
    Map<Integer, Integer> map;
//    Set<Integer> set;
    public FrequencyTracker0() {
        map = new HashMap<>();
//        set = new HashSet<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
//        set.add(map.get(number));
    }

    public void deleteOne(int number) {
        if (map.get(number) == null || map.get(number) == 0) return;
        map.put(number, map.get(number) - 1);
    }

    public boolean hasFrequency(int frequency) {
        for (Integer v : map.values()) {
            if (v == frequency) return true;
        }
        return false;
    }
}

// method 自写 - 错误写法
class FrequencyTracker1 {
    Map<Integer, Integer> nums = new HashMap<>();
    Map<Integer, Integer> frequency = new HashMap<>();
    public FrequencyTracker1() {

    }

    public void add(int number) {
        nums.put(number, nums.getOrDefault(number, 0) + 1);
        int f = nums.get(number);
        frequency.put(f, frequency.getOrDefault(f, 0) + 1);
        if (frequency.get(f - 1) != null) {
            frequency.put(f - 1, frequency.get(f - 1) - 1);
        }
    }

    public void deleteOne(int number) {
        if (nums.get(number) == null || nums.get(number) == 0) return;
        nums.put(number, nums.get(number) - 1);
        int f = nums.get(number);
        frequency.put(f, frequency.get(f - 1));
        frequency.put(f + 1, frequency.get(f + 1) - 1);
    }

    public boolean hasFrequency(int frequency) {
        return this.frequency.getOrDefault(frequency, 0) > 0;
    }
}

/**
 * 参考题解：画图小匠
 */
// method 自写 - 修改后正确的代码，自己写的垃圾代码，写着写着都给自己绕晕了。。。
class FrequencyTracker2 {
    Map<Integer, Integer> nums;
    Map<Integer, Integer> frequency;
    public FrequencyTracker2() {
        nums = new HashMap<>();
        frequency = new HashMap<>();
    }

    public void add(int number) {
        nums.put(number, nums.getOrDefault(number, 0) + 1);
        int f = nums.get(number);
        frequency.put(f, frequency.getOrDefault(f, 0) + 1);
        //if (frequency.get(f - 1) != null) {
        frequency.put(f - 1, frequency.getOrDefault(f - 1, 0) - 1);
        //}
    }

    public void deleteOne(int number) {
        if (nums.getOrDefault(number, 0) == 0) return;
        nums.put(number, nums.get(number) - 1);
        int f = nums.get(number);
        frequency.put(f, frequency.getOrDefault(f, 0) + 1);
        //if (frequency.get(f + 1) != null)
        frequency.put(f + 1, frequency.getOrDefault(f + 1, 0) - 1);
    }

    public boolean hasFrequency(int frequency) {
        //if (this.frequency.get(frequency) == null) return false;
        return this.frequency.getOrDefault(frequency, 0) > 0;
    }
}