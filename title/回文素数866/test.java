package title.回文素数866;

public class test {
}

class Solution {
    public int primePalindrome(int n) {
        for (int i = n; i < (int)10e8; i++) {
            if (isPrime(n) && isPalindrome(n)) return i;
        }
        return -1;
    }

    private boolean isPalindrome(int n) {
        int reverse = 0;
        while (n > reverse) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse == n || reverse / 10 == n;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}