package title.递枕头2582;

public class test {
}

/*
class Solution {
    public int passThePillow(int n, int time) {
//        int ans = (n + time) % (2 * n - 1);
//        int ans = time % (2 * n - 1);
//        time %= (2 * n - 1);
        */
/*if (ans < n) {
        //note (n - 1) * 2才是回到起点
            return ans;
        } else {
            return 2 * n - ans;
        }*//*

        //note n - (time - (n - 1))
        return time < n ? time + 1 : 2 * n - time - 1;
    }
}*/

//method 2：灵神做法
class Solution {
    public int passThePillow(int n, int time) {
        int t = time % (n - 1);
        return time / (n - 1) % 2 > 0 ? n - t : 1 + t;
    }
}