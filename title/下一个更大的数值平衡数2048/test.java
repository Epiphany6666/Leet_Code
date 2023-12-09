package title.下一个更大的数值平衡数2048;

public class test {
    public static void main(String[] args) {
        new helper().nextBeautifulNumber();
    }
}

//method 1：枚举
class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) {
            int[] cnt = new int[10];
            int x = i;
            for (int j = x; j > 0; j /= 10) {
                cnt[j % 10]++;
            }
            boolean ok = true;
            for (int j = x; j > 0; j /= 10) {
                if (j % 10 != cnt[j % 10]) {
                    ok = false;
                    break;
                }
            }
            if (ok) return x;
        }
    }
}

class helper {
    public void nextBeautifulNumber() {
        for (int i = 1; i <= 124444; i++) {
            int[] cnt = new int[10];
            int x = i;
            for (int j = x; j > 0; j /= 10) {
                cnt[j % 10]++;
            }
            boolean ok = true;
            for (int j = x; j > 0; j /= 10) {
                if (j % 10 != cnt[j % 10]) {
                    ok = false;
                    break;
                }
            }
            if (ok) System.out.print(x + ", ");
        }
    }
}

//method 2：打表 + 二分
class Solution2 {
    private static final int[] balance = new int[] {
            1, 22, 122, 212, 221, 333, 1333, 3133, 3313, 3331, 4444, 14444, 22333, 23233, 23323, 23332, 32233, 32323, 32332, 33223, 33232, 33322, 41444, 44144, 44414, 44441, 55555, 122333, 123233, 123323, 123332, 132233, 132323, 132332, 133223, 133232, 133322, 155555, 212333, 213233, 213323, 213332, 221333, 223133, 223313, 223331, 224444, 231233, 231323, 231332, 232133, 232313, 232331, 233123, 233132, 233213, 233231, 233312, 233321, 242444, 244244, 244424, 244442, 312233, 312323, 312332, 313223, 313232, 313322, 321233, 321323, 321332, 322133, 322313, 322331, 323123, 323132, 323213, 323231, 323312, 323321, 331223, 331232, 331322, 332123, 332132, 332213, 332231, 332312, 332321, 333122, 333212, 333221, 422444, 424244, 424424, 424442, 442244, 442424, 442442, 444224, 444242, 444422, 515555, 551555, 555155, 555515, 555551, 666666, 1224444};

//    public int nextBeautifulNumber(int n) {
//        int l = n + 1, r = 1224444;
//        while (l < r) {
//            int mid = l + ((r - l) >> 1);
//            if (balance[mid] <= n) l = mid + 1;
//            else r = mid;
//        }
//        return l;
//    }

    public int nextBeautifulNumber(int n) {
        int l = 0, r = balance.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (balance[mid] <= n) l = mid + 1;
            else r = mid;
        }
        return balance[l];
    }
}