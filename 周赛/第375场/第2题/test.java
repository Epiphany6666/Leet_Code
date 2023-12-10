package 周赛.第375场.第2题;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class test {
}

class Solution2 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        int n = variables.length;
        for (int i = 0; i < n; i++) {
            int[] v = variables[i];
            if (Math.pow(Math.pow(v[0], v[1]) % 10, v[3]) == target) ans.add(i);
        }
        return ans;
    }
}

class Solution3 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        int n = variables.length;
        for (int i = 0; i < n; i++) {
            int[] v = variables[i];
            if ((long)Math.pow((long)Math.pow(v[0], v[1]) % 10, v[2]) % v[3] == target) ans.add(i);
        }
        return ans;
    }
}

//终于过了。。。
class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        int n = variables.length;
        for (int i = 0; i < n; i++) {
            int[] v = variables[i];
            BigInteger a = new BigInteger(Integer.toString(v[0]));
            BigInteger b = new BigInteger(Integer.toString(v[1]));
            BigInteger c = new BigInteger(Integer.toString(v[2]));
            BigInteger d = new BigInteger(Integer.toString(v[3]));
            BigInteger x = new BigInteger(Integer.toString(1));
            for (int j = 0; j < v[1]; j++) {
                x.multiply(a);
            }
            x = x.remainder(new BigInteger(Integer.toString(10)));
            BigInteger y = new BigInteger(Integer.toString(1));
            for (int j = 0; j < v[2]; j++) {
                y.multiply(x);
            }
            y = y.remainder(d);

            if (y.intValue() == target) ans.add(i);
        }
        return ans;
    }
}