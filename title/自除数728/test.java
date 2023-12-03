package title.自除数728;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        System.out.println(new Solution().selfDividingNumbers(40,57));
//        System.out.println(ans);
    }
}

/**
 * 总结：
 * 1.初步认识List<Integer> ans = new ArrayList<>()的使用，
 *    以及打表方法；
 * 2.明明早就已经对break和continue有了很明确的了解，却在写题时犯这么愚蠢的错误；
 * 3.做题方法依旧很败类，需要进一步的优化；
 * 4.很多学过的知识，比如静态代码块，却一直没有实践过。我还愚笨的创了个方法，然后去调用它；
 * 5.对二分查找有了进一步的了解用法，以前只知道可以用它来查找确定的某个数，却忽略了它可以去查找一个范围的边界数；
 * 6.写题写着写着不小心把l和left给混在一起了，以后必须多加注意。
 */

class Solution {
    /*static List<Integer> ans = new ArrayList<>();
    static{
        out:
        for (int i = 1; i <= 10000; i++) {
            int temp = i;
            while (temp > 0) {
                int t = temp % 10;
                if (t == 0 || i % t != 0) {
                    continue out;
                }
                temp /= 10;
            }
            ans.add(i);
        }
    }
    //打表的方法
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        int l = 0;
        int r = ans.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (ans.get(mid) >= left) r = mid;
//            else left = mid + 1;
            else l  = mid + 1;
        }
        while(r < ans.size() && ans.get(r) <= right) list.add(ans.get(r++));
        return list;
    }*/

    /*

    public List<Integer> binary(int left, int right, int sz) {
        int star = 0;
        int end = sz - 1;
        while (star < end) {
            int mid = left + (right - left) / 2;
            if (mid < star)

        }
    }*/
    /*public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ans = new ArrayList<>();//isSelfDividing
        out:for (int i = left; i <= right; i++) {
            *//*if (isSelfDviding(i)) {
                ans.add(i);
            }*//*
            int cur = i;
            while (cur != 0) {
                int t = cur % 10;
                if (t == 0 || i % t != 0)
                    continue out;
                cur /= 10;
            }
            ans.add(i);
        }
        return ans;
    }*/

    /*public boolean dividing(int i) {
        int k = -1;
        int n = i;
//        int m = -1;
        int[] ans = new int[5];
        while ((n / 10) != 0) {
            ans[++k] = n % 10;
            n = n / 10;
        }
        ans[++k] = n;
        for (int j = 0; j <= k; j++) {
            if (ans[j] == 0 || i % ans[j] != 0 )
                return false;
        }
        return true;
    }*/
    /*public boolean isSelfDviding(int num){
        int temp = num;
        while (temp > 0) {
            int digit = temp  % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }*/

    /*public List<Integer> selfDividingNumbers(int left, int right) {

    }*/
    static List<Integer> list = new ArrayList<Integer>();
    static int[] hash = new int[10010];
    static{
        for (int i = 1; i <= 10000; i++){
            int temp = i;
            boolean flag = true;
            while (temp > 0 && flag) {
                int t = temp % 10;
                if (t == 0 || i % t != 0) flag = false;
                temp /= 10;
            }
//            if (flag == true) {
            if (flag){
                list.add(i);
            }
            hash[i] = list.size() - 1;
        }
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        int idx = list.get(hash[left]) == left ? hash[left] : hash[left] + 1;
        List<Integer> ans = new ArrayList<Integer>();
        while (idx < list.size() && list.get(idx) <= right) {
            ans.add(list.get(idx++));
        }
        return ans;
    }
}
