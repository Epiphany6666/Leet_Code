package title.拼车1094;

public class test {
}

/*
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] sortie = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            //note 这里不能写j<=trips[i][2]，因为等于的时候司机就把乘客防下来了！
//            for (int j = trips[i][1]; j <= trips[i][2]; j++) {
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
//                sortie[j]++;
                sortie[j]++;
            }
        }

        for (int i : sortie) {
            if (i > capacity) return false;
        }
        return true;
    }
}*/

//method 2：只需要遍历一次循环
//mind 看完差分数组的题解才意识到，原来这种做法就是差分数组的做法！
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] sites = new int[1001];
        for (int[] trip : trips) {
            sites[trip[1]] += trip[0];
            sites[trip[2]] -= trip[0];
        }

        int total = 0;
        for (int site : sites) {
            total += site;
            if (total > capacity) {
                return false;
            }
        }
        return true;
    }
}