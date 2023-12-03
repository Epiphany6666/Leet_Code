package 双周赛.第115场双周赛.第1题;

import java.util.ArrayList;
import java.util.List;

public class test {
}

/*
class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> ans = new ArrayList<>();
        int idx = -1;
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.equals("prev")) {
                if (i > 0 && words.get(i - 1).equals(words.get(i))) {
                    ans.add(ans.get(ans.size() - 1) - 1);
                } else {
                    ans.add(idx);
                }
            } else {
                idx = Integer.parseInt(words.get(i));
            }
        }
        return ans;
    }
}*/

class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> ans = new ArrayList<>(), nums = new ArrayList<>();
        int k = 0;
        for (String word : words) {
            if (word.equals("prev")) {
                k++;
                if (k > nums.size()) ans.add(ans.get(-1));
                else ans.add(nums.get(nums.size() - k));
            } else {
                nums.add(Integer.parseInt(word));
                k = 0;
            }
        }
        return ans;
    }
}