package BlueBridge.第十四届;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cnt = 0;
        for (int i = 1; ; i++) {
            if (check(i, 2) && check(i, 8) && check(i, 10) && check(i, 16)) cnt++;
            if (cnt == 2023) {
                System.out.println(i);
                break;
            }
        }
        scan.close();
    }

    private static boolean check(int x, int mod) {
        int tmp = x;
        int sum = 0;
        while (x > 0) {
            int m = x % mod;
            sum += m;
            x /= mod;
        }
        return tmp % sum == 0;
    }
}