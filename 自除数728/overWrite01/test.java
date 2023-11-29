package title.自除数728.overWrite01;

import java.util.ArrayList;
import java.util.List;

public class test {

}
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelf(i)) ans.add(i);
        }
        return ans;
    }

    private boolean isSelf(int i) {
        int x = i;
        while (x != 0) {
            if (i % (x % 10) != 0) {
                return false;
            }
            x /= 10;
        }
        return true;
    }
}