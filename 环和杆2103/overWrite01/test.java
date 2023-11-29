package title.环和杆2103.overWrite01;

public class test {
}

//method 1：位运算 - 统计环
/*class Solution {
    public int countPoints(String rings) {
        int[] map = new int[128];
        for (int i = 0; i < rings.length(); i += 2) {
            map[rings.charAt(i) - 'B'] |= 1 << (rings.charAt(i - 1) - '0');
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            int total = 0;
            for (char c : new char[] {'R', 'G', 'B'}) total += (map[c - 'B'] >> i) & 1;
            if (total == 3) ans++;
        }
        return ans;
    }
}*/

//method 2：位运算 - 统计杆
class Solution {
    public int countPoints(String rings) {
        int[] pole = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            char c = rings.charAt(i);
            int idx = -1;
            if (c == 'R') idx = 0;
            else if (c == 'G') idx = 1;
            else idx = 2;
            pole[rings.charAt(i + 1) - '0'] |= 1 << idx;
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            //note 这一步真的，真的，真的好聪明啊
            if (pole[i] == (1 << 3) - 1) ans++;
        }
        return ans;
    }
}