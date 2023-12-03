package title.比较版本号165;

public class test {
}

/*
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
//        int len = Math.min(v1.length, v2.length);
        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            String s1 = i < v1.length ? v1[i] : new String();
            String s2 = i < v2.length ? v2[i] : new String();
            int idx1 = 0, idx2 = 0;
//            while (v1[i].charAt(idx1) == '0') idx1++;
//            while (v2[i].charAt(idx2) == '0') idx2++;
            while (idx1 < s1.length() && s1.charAt(idx1) == '0') idx1++;
            while (idx2 < s2.length() && s2.charAt(idx2) == '0') idx2++;
            while (idx1 < s1.length() || idx2 < s2.length()) {
                int n1 = idx1 < s1.length() ? s1.charAt(idx1) - '0' : -1;
                int n2 = idx2 < s2.length() ? s2.charAt(idx2) - '0' : -1;
                if (n1 < n2) return -1;
                else if (n1 > n2) return 1;
                idx1++;
                idx2++;
            }
        }
        return 0;
    }
}*/

//method 无语了，原来一直是我误解错题目意思了
//note 不是一个数字一个数字的比较，而是一个字符串一个字符串比较啊。。。，那这不简单好多了吗，我居然还在这里写这么久
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int idx1 = 0, idx2 = 0;
        while (idx1 < v1.length || idx2 < v2.length) {
//            int n1 = idx1 < v1.length ? Integer.parseInt(v1[idx1]) : -1;
//            int n2 = idx2 < v2.length ? Integer.parseInt(v2[idx2]) : -1;
            //note 这里默认值为多少还是要动脑筋思考一下的。上面默认值为-1是因为一个数也有可能是0。
            int n1 = idx1 < v1.length ? Integer.parseInt(v1[idx1]) : 0;
            int n2 = idx2 < v2.length ? Integer.parseInt(v2[idx2]) : 0;
            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
            idx1++;
            idx2++;
        }
        return 0;
    }
}