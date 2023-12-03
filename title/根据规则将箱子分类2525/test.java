package title.根据规则将箱子分类2525;

public class test {
}

class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
//        boolean bulky = false, heavy = false;
//        if ((length >= (int)1e4 || width >= (int)1e4 || height >= (int)1e4) || ((long)length * width * height) >= 1e9) {
//            bulky = true;
//        }
//        if (mass >= 100) heavy = true;

        //note 简写
        //用除法防止越界
//        boolean bulky = ((length >= (int)1e4 || width >= (int)1e4 || height >= (int)1e4) || ((long)length * width * height) >= 1e9);
        boolean bulky = ((length >= (int)1e4 || width >= (int)1e4 || height >= (int)1e4) || (length * width) >= 1e9 / height);
        boolean heavy = mass >= 100;
        if (bulky && heavy) return "Both";
        else if (bulky) return "Bulky";
        else if (heavy) return "Heavy";
        else return "Neither";
    }
}