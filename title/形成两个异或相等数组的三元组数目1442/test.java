package title.形成两个异或相等数组的三元组数目1442;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
}

/**
 * 这题看了我几个小时。。。。。。。。。。。。。。。。。。。。。。。
 *？？
 */

//class Solution {
//    public int countTriplets(int[] arr) {
//        int n = arr.length;
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            int a = arr[i];
//            for (int j = i + 1; j < n; j++) {
//                a ^= arr[j];
//                int b = arr[j];
//                for (int k = j + 1; k < n; k++) {
//                    b ^= arr[k];
//                    if (a == b) ans++;
//                }
//            }
//        }
//        return ans;
//    }
//}

// note 0 ^ A = A
//method 自写。。
class Solution1 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = 0;
            for (int j = i + 1; j < n; j++) {
                a ^= arr[j - 1];
                int b = 0;
                for (int k = j; k < n; k++) {
                    b ^= arr[k];
                    if (a == b) ans++;
                }
            }
        }
        return ans;
    }
}

//method 1：前缀异或
//class Solution {
//    public int countTriplets(int[] arr) {
//        int n = arr.length;
//        int[] sum = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            sum[i + 1] = sum[i] ^ arr[i];
//        }
//        int ans = 0;
//        for (int i = 0; i <= n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                for (int k = j; k <= n; k++) {
//                    int a = sum[j] ^ sum[i];
//                    int b = sum[k] ^ sum[j - 1];
//                    if (a == b) ans++;
//                }
//            }
//        }
//        return ans;
//    }
//}

//method1 三叶版
class Solution2 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j; k <= n; k++) {
                    int a = sum[j - 1] ^ sum[i - 1];
                    int b = sum[k] ^ sum[j - 1];
                    if (a == b) ans++;
                }
            }
        }
        return ans;
    }
}

//method 2：前缀异或 & 哈希表
class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] ^ arr[i];
        }
        int ans = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int k = 0; k <= n; k++) {
            List<Integer> list = map.getOrDefault(sum[k], new ArrayList<>());
            for (Integer idx : list) {
                int i = idx + 1;
                ans += k - i;
            }
            list.add(k);
            map.put(sum[k], list);
        }
        return ans;
    }
}