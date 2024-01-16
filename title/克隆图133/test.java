package title.克隆图133;

import java.util.*;

public class test {
}


class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

//DFS
//class Solution {
//    Node clone;
//    boolean[] visited = new boolean[101];
//    public Node cloneGraph(Node node) {
//        if (node == null) return node;
//        clone = new Node(node.val);
//        visited[node.val] = true;
//        for (Node neighbor : node.neighbors) {
////            clone.neighbors.add(new Node(neighbor.val));
//            if (!visited[neighbor.val]) {
//                cloneGraph(neighbor);
//            }
//        }
//        return clone;
//    }
//}

// 官方解析
// DFS
class Solution1 {
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return node;
        if (map.containsKey(node)) return map.get(node);
        Node cloneNode = new Node(node.val, new ArrayList<>());
        map.put(node, cloneNode);
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}

//BFS
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val));
        Deque<Node> q = new ArrayDeque<>();
        q.offer(node);
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            for (Node neighbor : tmp.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    q.offer(neighbor);
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                }
                visited.get(tmp).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}