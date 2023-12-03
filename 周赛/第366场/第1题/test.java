package 周赛.第366场.第1题;

public class test {
}

class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;

        for (int i = 1; i <= n; i++) {
//            if (m % i != 0) num1 += i;
            if (i % m != 0) num1 += i;
            else num2 += i;
        }
        return num1 - num2;
    }
}