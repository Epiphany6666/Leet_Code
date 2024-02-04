package title.四因数1390;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
}

//method 自写
class Solution1 {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int[] cnt = fourDivisors(num);
            if(cnt.length == 4) {
                for (int i : cnt) {
                    ans += i;
                }
            }
        }
        return ans;
    }

    private int[] fourDivisors(int num) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        // note num本身也需要添加进来
        list.add(num);
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
                // note 判断 i 和我 num/i 是否相等，若不相等才能将 num/i 看成新的因数
//                list.add(num / i);
                if (i * i != num) list.add(num / i);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

// method 官解
class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int cnt = 0, sum = 0;
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    cnt++;
                    sum += i;
                    if (i * i != num) {
                        cnt++;
                        sum += num / i;
                    }
                }
            }
            if (cnt == 4) {
                ans += sum;
            }
        }
        return ans;
    }
}