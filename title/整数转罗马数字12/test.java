package title.整数转罗马数字12;

/**
 * 参考题解：liweiwei1419
 * 可以发现 规律：数字 1、5、10、50、100、500、1000 是分水岭，转换的时候默认使用加法，如果一个字符超过 3 次重复使用，就改成减法
 */
public class test {
}

/**
 * 这题的做法是使用两个数组来充当hash表
 * 写完这道题，只有一个感想：不是，罗马人有病吧，列死我了，，，
 */
class Solution {
    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9 , 5, 4, 1};
        String[] reps = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                num -=  value[i];
                ans.append(reps[i]);
            }
        }
        return ans.toString();
    }
}