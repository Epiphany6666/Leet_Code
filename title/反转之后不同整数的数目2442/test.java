package title.反转之后不同整数的数目2442;

import java.util.HashSet;
import java.util.Set;

public class test {
}

//mind 我的时间复杂度太高了
/*
class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            String str = num + "";
            set.add(num);
            set.add(Integer.parseInt(new StringBuffer(str).reverse().toString()));
        }
        return set.size();
    }
}*/

//method 2
class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            int reverseNum = 0;
            while (num != 0) {
                reverseNum = reverseNum * 10 + num % 10;
                ///////////总是忘记写！
                num /= 10;
            }
            set.add(reverseNum);
        }
        return set.size();
    }
}