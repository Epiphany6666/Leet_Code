package title.杨辉三角Ⅱ119;

import java.util.ArrayList;
import java.util.List;

public class test {
}

/*
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        list.add(row1);
        if (rowIndex == 0) return row1;
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> t = list.get(i - 1);
            List<Integer> t2 = new ArrayList<>();
            for (int j = -1; j < t.size(); j++) {
                if (j == -1 || j == t.size() - 1) {
                    t2.add(1);
                } else {
                    t2.add(t.get(i) + t.get(i + 1));
                }
            }
            list.add(t2);
            if (list.size() == rowIndex - 1) {
                return list.get(list.size() - 1);
            }
        }
        return row1;
    }
}*/


//mind 代码不够简洁，感觉有时候还是思维没转过来
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        //note 这里不用单独创个row1
        /*List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        list.add(row1);*/
        for (int i = 0; i <= rowIndex; i++) {
            //note 这里也不用get一个
//            List<Integer> t = list.get(i - 1);
            List<Integer> t2 = new ArrayList<>();
//            for (int j = -1; j < t.size(); j++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    t2.add(1);
                } else {
                    t2.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(t2);
        }
        return list.get(rowIndex);
    }
}