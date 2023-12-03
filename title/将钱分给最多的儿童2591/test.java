package title.将钱分给最多的儿童2591;

public class test {
}
class Solution {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }

        if (money > children * 8) {
            return children - 1;
        }

        if (money == children * 8 - 4) {
            return children - 2;
        }

        return (money - children) / 7;
    }
}