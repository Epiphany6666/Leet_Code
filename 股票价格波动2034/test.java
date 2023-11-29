package title.股票价格波动2034;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 第一次使用TreeMap，从小到大排
 * 法2：使用两个优先队列
 */
public class test {
}

class StockPrice {
    int cur;
    Map<Integer, Integer> map = new HashMap<>();
    TreeMap<Integer, Integer> ts = new TreeMap<Integer, Integer>();
    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        cur = Math.max(cur, timestamp);
        if (map.containsKey(timestamp)) {
            int old = map.get(timestamp);
            if (ts.get(old) == 1) ts.remove(old);
            else ts.put(old, ts.get(old) - 1);
        }
        map.put(timestamp, price);
        ts.put(price, ts.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return map.get(cur);
    }

    public int maximum() {
        return ts.lastKey();
    }

    public int minimum() {
        return ts.firstKey();
    }
}