package title.老人的数目2678.overWrite01;

public class test {
}

/*
class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String detail : details) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) ans++;
        }
        return ans;
    }
}*/

//method 2：
class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String d : details) {
//            if ((d.charAt(11) * 10 - '0') + (d.charAt(12) - '0') > 60) ans++;
            if ((d.charAt(11) - '0') * 10 + (d.charAt(12) - '0') > 60) ans++;
        }
        return ans;
    }
}