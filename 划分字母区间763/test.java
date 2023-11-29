package title.划分字母区间763;

import java.util.ArrayList;
import java.util.List;

public class test {
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] ends = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ends[s.charAt(i) - 'a'] = i;
        }

//        for (int i = 0; i < s.length(); i++) {
//            int j = ends[s.charAt(i) - 'a'];
//            ans.add(j - i + 1);
//            i = j;
//        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, ends[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end  + 1;
            }
        }
        return ans;
    }
}