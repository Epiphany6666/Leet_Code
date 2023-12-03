package title.搜索推荐系统1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int len = searchWord.length();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String substring = searchWord.substring(0, i + 1);
            List<String> list = new ArrayList<>();
            for (String product : products) {
                if (product.length() < substring.length()) continue;
                if (substring.equals(product.substring(0, i + 1))) {
                    list.add(product);
                    if (list.size() >= 3) {
                        break;
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }
}