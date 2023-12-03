package title.卡牌分组914;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
}

/*
//mind WA了好多次了，，，，
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        //note 这个条件你为什么不加？
        if (deck == null || deck.length < 2) return false;
        int pre = 0, cnt = 1;
        Arrays.sort(deck);
        for (int i = 1; i < deck.length; i++) {
            if (deck[i] == deck[i - 1]) {
                cnt++;
            } else {
                if (pre == 0) {
                    pre = cnt;
                    cnt = 1;
                    continue;
                }
                else {
                    if (pre != cnt) return false;
                    cnt = 1;
                }
            }
        }
        if (pre != 0 && pre != cnt) return false;
        return true;
    }
}*/

//method 1：暴力
/*
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        int[] count = new int[(int)1e4 + 1];
        for (int i : deck) {
            count[i]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 1e4; i++) {
            if (count[i] != 0) list.add(count[i]);
        }

        //note 题解是直接用len来模
//        int x = count[deck[0]];
        for (int i = 2; i <= len; i++) {
//            if (x % i == 0) {
            if (len % i == 0) {
                boolean flag = true;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) % i != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }
}*/


//method 2：求最大公约数
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] cnt = new int[(int)1e4 + 1];
        for (int i : deck) {
            cnt[i]++;
        }

        int x = cnt[deck[0]];
        for (int i = 0; i < (int) 1e4 + 1; i++) {
            if (cnt[i] == 1) return false;
            if (cnt[i] > 1) {
                x = gcd(x, cnt[i]);
            }

            if (x == 1) return false;
        }
        return true;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}