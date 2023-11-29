package title.LCR_173_点名;

public class test {
}

//note records = [0]，没有考虑为一个或没有的情况
/*class Solution {
    public int takeAttendance(int[] records) {
        for (int i = 1; i < records.length; i++) {
            //note 对应的应该刚好就是这个位置的下标！
//            if (records[i] != records[i - 1] + 1) return i - 1;
            if (records[i] != records[i - 1] + 1) return i;
        }
        return -1;
    }
}*/

//mind 改了之后，这个测试用例又过不了，，，records = [0,1]
/*
class Solution {
    public int takeAttendance(int[] records) {
        if (records == null || records.length == 0) return 0;
        if (records.length == 1) return records[0] == 1 ? 0 : 1;
        for (int i = 1; i < records.length; i++) {
            if (records[i] != records[i - 1] + 1) return i;
        }
        return -1;
    }
}*/

//method 二分查找
//mind 为什么这么明显的二分我却想不到啊，，，
class Solution {
    public int takeAttendance(int[] records) {
        int l = 0, r = records.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (records[mid] != mid) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}