package BlueBridge.双周赛.第2题;

import java.util.Scanner;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            String S = scan.next();
            int k = 1;
            for (char c : S.toCharArray()) {
                if (c == 'L') {
                    //note 太粗心了。
//                    k = i * 2 - 1;
                    k = k * 2 - 1;
                } else {
//                    k = i * 2;
                    k = k * 2;
                }
            }
            System.out.println(k);
        }
        scan.close();
    }
}