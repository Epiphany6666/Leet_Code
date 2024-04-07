package title.王位继承顺序1600;

import java.util.*;

public class test {
}

/**
 * 参考题解：力扣官方题解
 */
// method 1：前序遍历
class ThroneInheritance1 {
    private Map<String, List<String>> map = new HashMap<>();
    private String kingName;
    // 记录已经死了的人
    Set<String> dead = new HashSet<>();
    public ThroneInheritance1(String kingName) {
        this.kingName = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> children = map.getOrDefault(parentName, new ArrayList<>());
        children.add(childName);
        map.put(parentName, children);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        preorder(ans, kingName);
        return ans;
    }

    private void preorder(List<String> ans, String name) {
        if (!dead.contains(name)) {
            ans.add(name);
        }
        List<String> child = map.getOrDefault(name, new ArrayList<>());
        for (String n : child) {
            preorder(ans, n);
        }
    }
}

/**
 * 参考题解：宫水三叶
 */
// method 2：单向链表
class ThroneInheritance {
    class Node {
        String name;
        Node next;
        Node last;
        boolean isDelete = false;
        public Node (String name) {
            this.name = name;
        }
    }
    Node head = new Node(""), tail = new Node("");
    HashMap<String, Node> map = new HashMap<>();
    public ThroneInheritance(String kingName) {
        Node king = new Node(kingName);
        map.put(kingName, king);
        king.next = tail;
        head.next = king;
    }

    public void birth(String parentName, String childName) {
        Node child = new Node(childName);
        map.put(childName, child);
        Node p = map.get(parentName);
        Node tmp = p;
        while (tmp.last != null) tmp = tmp.last;
        child.next = tmp.next;
        tmp.next = child;
        p.last = child;
    }

    public void death(String name) {
        map.get(name).isDelete = true;
    }

    public List<String> getInheritanceOrder() {
        Node tmp = head.next;
        List<String> ans = new ArrayList<>();
        while (tmp.next != null) {
            if (!tmp.isDelete) {
                ans.add(tmp.name);
            }
            tmp = tmp.next;
        }
        return ans;
    }
}