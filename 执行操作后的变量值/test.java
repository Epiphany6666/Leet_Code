package title.执行操作后的变量值;

public class test {
    public static void main(String[] args) {
        String[] operations = {"--X", "X++", "X++"};
        System.out.println(new Solution().finalValueAfterOperations(operations));
    }
}

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String i : operations) {//op
            if (i.equals("X++") || i.equals("++X")) x++;//比较时常量写前面
            else x--;
        }
        return x;
    }
}
