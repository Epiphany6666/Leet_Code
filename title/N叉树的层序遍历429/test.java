package title.N叉树的层序遍历429;

import java.util.*;

/**
 * 总结：
 * 1.出队列时怎么确认上一排的个数：定义size变量
 * 2.改变list也会改变ans中的值
 */
class Node {
    int val;
    List<Node> child;
    Node() {}
    Node(int val) {this.val = val;}
    Node(int val, List<Node> child) {this.val = val; this.child = child;}
}

public class test {
}

//法1：BFS
/*
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> d = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) d.addLast(root);
        while (!d.isEmpty()) {
            int size = d.size();
            List<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                Node t = d.pollFirst();
                temp.add(t.val);
                for (Node node : t.child) {
                    d.addLast(node);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}*/

/*
//法2：DFS
class Solution {
    int max;
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return ans;
        dfs(root, 0);
        for (int i = 0; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    private void dfs(Node root, int depth) {
        max = Math.max(max, depth);
        List<Integer> temp = map.getOrDefault(depth, new ArrayList<>());
        temp.add(root.val);
        map.put(depth, temp);
        for (Node node : root.child) dfs(node, depth + 1);
    }
}*/

//法3：不借助哈希表
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return ans;
        dfs(root, 0);
        return ans;
    }

    private void dfs(Node root, int depth) {
        if (ans.size() == depth) ans.add(new ArrayList<>());
        List<Integer> list = ans.get(depth);
        list.add(root.val);
        for (Node node : root.child) dfs(node, depth + 1);
    }
}