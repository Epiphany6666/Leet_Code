package title.老人的数目2678;

public class test {
}

/*
class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String detail : details) {
//            int i = Integer.parseInt(detail.substring(10, 13));
            int i = Integer.parseInt(detail.substring(11, 13));
            if (i > 60) ans++;
        }
        return ans;
    }
}*/

//TODO 法2：
class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String detail : details) {
//            if (detail.charAt(11) * 10 + detail.charAt(12) > 60) ans++;
            //字符数字转化为普通数字你不会了？
            if ((detail.charAt(11) - '0') * 10 + (detail.charAt(12) - '0') > 60) ans++;
        }
        return ans;
    }
}