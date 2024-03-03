package Leet_Code.src.BlueBridge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class 赢球票 {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        int N = scanner1.nextInt();
        List<Integer> vals = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int temp = scanner1.nextInt();
            vals.add(temp);
        }
        int count = 0;//最多能赢多少张
        for (int i = 0; i < N; i++) {//从第i张开始数
            List<Integer> temp = new ArrayList<Integer>();
            List<Integer> temp1 = new ArrayList<Integer>();//临时拷贝
            temp1.addAll(vals);
            int t = N;//因为后面会改变N，所以创个临时变量
            int k = 0;//计数器
            int j = i;
            while (j < t) {//还需要遍历多少张
                int max = Collections.max(temp1);
                k++;
                if (k > max) break;//如果k比max还要大，后面的数就更不可能了
                if (temp1.get(j) == k) {//如果卡号的数的序号，t--，并把k重新置为1，j重新置为0，然后break
                    temp.add(k);
                    temp1.remove(j);
                    t--;
                    if (t != 0) j %= t;
                    k = 0;
                    continue;
                } else {
                    ++j;
                    if (t != 0) j %= t;
                }
            }
            int sum = 0;
            for(int s = 0; s < temp.size(); s++) {
                sum += temp.get(s);
            }
            if (sum > count) count = sum;
        }
        System.out.print(count);
    }
}
