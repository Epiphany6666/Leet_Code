package title.猜数字大小374;

public class test {
    public static void main() {

    }
}

/*
class Solution {
    public int GuessGame (int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (guess(mid) < 0) {
                left = mid + 1;
            } else if (guess(mid) > 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}*/
