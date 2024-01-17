package title.数字范围按位与201;

public class test {
}

//class Solution {
//    public int rangeBitwiseAnd(int left, int right) {
//        int ans = left;
//        for (int i = left + 1; i < right; i++) {
//            ans &= i;
//        }
//        return ans;
//    }
//}

//找公共前缀
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        int mask = 1 << 30;
        while (mask > 0 && ((left & mask) == (right & mask))) {
            ans |= (left & mask);
            mask >>= 1;
        }
        return ans;
    }
}