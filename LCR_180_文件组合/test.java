package title.LCR_180_文件组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {
}

/*
class Solution {
    public int[][] fileCombination(int target) {
        List<List<Integer>> list = new LinkedList<>();
//        List<int[]> list = new LinkedList<>();
        for (int i = 1; i < target / 2; i++) {
            int sum = 0;
            List<Integer> temp = new ArrayList<>();
            for (int j = i; ; j++) {
                sum += j;
                if (sum > target) break;
                temp.add(j);
                if (sum == target) {
                    list.add(temp);
                    break;
                }
            }
        }
        int[][] ans = new int[list.size()][]
    }
}*/

class Solution {
    public int[][] fileCombination(int target) {
        List<int[]> ans = new ArrayList<>();
        //note 永远都是小错误
//        for (int i = 1; i < target / 2; i++) {
        for (int i = 1; i <= target / 2; i++) {
            int sum = 0;
            for (int j = i; ; j++) {
                sum += j;
                if (sum > target) break;
                if (sum == target) {
                    int[] arr = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        arr[k - i] = k;
                    }
                    ans.add(arr);
                    break;
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}