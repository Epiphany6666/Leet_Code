package title.LCP_50_宝石补给;

/**
 * 简单题的代码也写的乱七八糟，为什么啊
 * 跟数组内的元素找最大最小值，直接令它们的初始值为首元素不就行了吗
 * 加减为什么还要奇偶呢？加多少肯定就减多少啊，为什么没有考虑用一个变量来记录呢？
 */
public class test {
    public static void main(String[] args) {

    }
}

/*
class Solution {
    public int giveGem(int[] gem, int[][] operations) {
        int max = 0;
        int min = 0x3f3f3f3f;
        for (int i = 0; i < operations.length; i++) {
            int x = operations[i][0];
            int y = operations[i][1];
            gem[y] += gem[x] / 2;
            if (gem[y] % 2 == 0) gem[y] /= 2;
            else gem[y] = (gem[y] + 1) / 2;
        }

        for (int i : gem) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return max - min;
    }
}*/

class Solution {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int x = operation[0], y = operation[1];
            int number = gem[x] / 2;
            gem[y] += number;
            gem[x] -= number;
        }

        int max = gem[0];
        int min = gem[0];
        for (int number : gem) {
            max = Math.max(max, number);
            min = Math.min(min, number);
        }
        return max - min;
    }
}