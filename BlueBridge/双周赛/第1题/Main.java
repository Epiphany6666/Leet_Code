package BlueBridge.双周赛.第1题;

import java.util.HashMap;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int T = scan.nextInt();
        scan.nextLine();
        String[] str = new String[T];
        boolean[] ans = new boolean[T];
        for (int i = 0; i < T; i++) {

            str[i] = scan.nextLine();
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : str[i].toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            boolean flag = false;
            for (Integer value : map.values()) {
                if (value == 3) flag = true;
            }
            ans[i] = flag;
        }

        for (int i = 0; i < T; i++) {
            System.out.println(ans[i] ? "Yes" : "No");
        }
        scan.close();
    }
}