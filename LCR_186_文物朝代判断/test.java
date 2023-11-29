package title.LCR_186_文物朝代判断;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test {
}

/*
//method 1：辅助哈希表
class Solution {
    public boolean checkDynasty(int[] places) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int place : places) {
            if (place == 0) continue;
            max = Math.max(max, place);
            min = Math.min(min, place);
            if (repeat.contains(place))  return false;
            repeat.add(place);
        }
        return max - min < 5;
    }
}*/

//method 2：排序＋遍历
class Solution {
    public boolean checkDynasty(int[] places) {
        Arrays.sort(places);
        int joker = 0;
//        for (int i = 0; i < places.length - 1; i++) {
//            if (places[i] == 0) continue;
//            if (places[i] == places[i + 1]) return false;
//        }
        for (int i = 0; i < places.length - 1; i++) {
            if (places[i] == 0) joker++;
            else if (places[i] == places[i + 1]) return false;
        }
        return places[4] - places[joker] < 5;
    }
}