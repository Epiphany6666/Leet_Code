package title.不浪费原料的汉堡制作方案1276;

import java.util.List;

public class test {
}

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int y = 2 * cheeseSlices - tomatoSlices / 2;
        int x = cheeseSlices - y;
        return tomatoSlices % 2 != 0 || x < 0 || y < 0 ? List.of() : List.of(x, y);
    }
}