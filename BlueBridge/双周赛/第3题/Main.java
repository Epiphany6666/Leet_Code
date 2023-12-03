package BlueBridge.双周赛.第3题;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        int mod = n - k;
        if (mod == 0) {
            System.out.println(0);
        } else {
            System.out.println(mod);
        }
        scan.close();
    }
}