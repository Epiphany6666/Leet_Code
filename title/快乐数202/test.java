package title.快乐数202;

import java.util.HashSet;
import java.util.Set;

public class test {
}

//method 快慢指针
class Solution {
    public int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }
}

//method 使用哈希来判断是否循环
class Solution2 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        //note 又是小错误
//        while(set.contains(n)) {
        while(!set.contains(n)) {
            set.add(n);
            n = isHappyHelper(n);
        }
        return n == 1;
    }

    private int isHappyHelper(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            sum /= 10;
        }
        return sum;
    }
}