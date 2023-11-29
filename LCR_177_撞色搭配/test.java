package title.LCR_177_撞色搭配;

public class test {
}

/**
 * 这里犯了一个打错， x & (-x)是 得到的是1000，并不是它的位置
 */
class Solution {
    public int[] sockCollocation(int[] sockets) {
        int xor = 0;
        for (int socket : sockets) {
            xor ^= socket;
        }
        int mask = xor & (-xor);
        int num1 = 0, num2 = 0;
        for (int socket : sockets) {
//            if (((socket >> mask) & 1) != 0) num1 ^= socket;
//            if (((socket >> mask) & 1) != 0) num1 ^= socket;
            if ((socket & mask) != 0) num1 ^= socket;
            else num2 ^= socket;
        }
        return new int[] {num1, num2};
    }
}

/*
class Solution {
    public int[] sockCollocation(int[] sockets) {
        int xor = 0;
        for (int socket : sockets) {
            xor ^= socket;
        }
        int m = 1;
//        while ((m & 1) != 0) m <<= 1;
        while ((m & xor) == 0) m <<= 1;
        int num1 = 0, num2 = 0;
        for (int socket : sockets) {
            if ((socket & m) != 0) num1 ^= socket;
            else num2 ^= socket;
        }
        return new int[] {num1, num2};
    }
}*/
