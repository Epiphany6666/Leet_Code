package title.H指数274;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > ans) ans++;
            else break;
        }
        return ans;
    }
}*/

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i++;
        }
        return h;
    }
}

//method 2：二分
/*
class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length - 1;
        while (l < r) {
            //+1，防止死循环
//            int mid = l + ((r - l) >> 1);
            int mid = l + ((r - l + 1) >> 1);
            if (check(citations, mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    private boolean check(int[] citations, int mid) {
        int cnt = 0;
        for (int citation : citations) {
            if (citation >= mid) cnt++;
        }
        return cnt >= mid;
    }
}*/

//method 3：计数排序
/*
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] cnt = new int[len];
        for (int c : citations) {
            if (c >= len) cnt[len]++;
            else cnt[c]++;
        }
        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += cnt[i];
            if (sum >= i) return i;
        }
        return -1;
    }
}*/
