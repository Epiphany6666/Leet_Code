package title.移动片段得到字符串2337;
/**
 * 总结
 * 1.灵神666666666666666
 * 2.String的replaceAll方法，知道但从来没用过。
 * 3.如果两个if刚好对立，可以尝试使用(start.charAt(i) == 'L') == i < j简写版本
 */

public class test {
}

class Solution {
    public boolean canChange(String start, String target) {
        if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
            return false;
        }

        for (int i = 0, j = 0; i < start.length(); i++) {
            if (start.charAt(i) == '_') continue;

            while (target.charAt(j) == '_') j++;
            /*if (i != j && start.charAt(i) == 'L' && i < j) return false;
            if (i != j && start.charAt(i) == 'R' && i > j) return false;*/
            //简写：
            if (i != j && ((start.charAt(i) == 'L') == i < j)) return false;
            j++;
        }
        return true;
    }
}