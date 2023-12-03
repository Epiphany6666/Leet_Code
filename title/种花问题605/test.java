package title.种花问题605;

public class test {
}

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; ) {
            //当前位置如果为0
            if (flowerbed[i] == 0) {
                //如果i为最后一个位置，直接种
                if (i == flowerbed.length - 1) {
                    n--;
                    i++;
                } else if (flowerbed[i + 1] == 0) {
                    //如果下一个位置为0，可以直接种
                    n--;
                    i += 2;
                } else {
                    //如果下一个位置为1
                    i += 3;
                }
            } else {//当前位置为1
                i += 2;
            }
        }
        return n <= 0;
    }
}