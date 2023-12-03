package title.计算应缴税款总额2303;

public class test {
    public static void main(String[] args) {
        new Solution().calculateTax(new int[][] {{3, 50}, {7, 10}, {12, 25}}, 10);
    }
}

/*
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        boolean[] valid = new boolean[brackets.length];
        int prev = 0;
        while (income > 0) {
            for (int i = 0; i < brackets.length; i++) {
                if (!valid[i]) {
                    valid[i] = true;
                    int number = brackets[i][0] - prev;
                    prev = brackets[i][0];
                    if (income >= number) {
                        ans +=  number * brackets[i][1] * 0.01;
                        income -= number;
                    } else {
                        ans += income * brackets[i][1];
                        income = 0;
                    }
                    break;
                }
            }
        }
        return ans;
    }
}*/

//method 2官方代码真的很整洁
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int taxTotal = 0;
        int lower = 0;
        for (int[] bracket : brackets) {
            int upper = bracket[0], percent = bracket[1];
            int tax = (Math.min(income, upper) - lower) * percent;
            taxTotal += tax;
            if (income <= upper) {
                break;
            }
            lower = upper;
        }
        return (double) taxTotal / 100.0;
    }
}