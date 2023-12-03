package title.LRU缓存146;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 原来这就是设计类题目，昨天那道题没看懂就直接CV了。。。。
 * 不会的就逃避，这不是我的作风啊。
 * 况且刚刚看了题解，也不难哇，既然知道思路了，那就好好自己写一遍吧
*/

public class test {
}

//设计双向链表
//mind 第一次知道链表也是可以设置两个值的
class ListNode {
    int key;
    int val;
    ListNode front, next;
    ListNode () {}
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

//mind 我又想通过一个变量来记录个数了，但其实map.size()就可以知道个数
class LRUCache {
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.front = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode list = map.get(key);
            moveToPrimary(list);
            return list.val;
        } else {
            return -1;
        }
    }

    private void moveToPrimary(ListNode list) {
        list.front.next = list.next;
        list.next.front = list.front;
        head.next.front = list;
        list.next = head.next;
        list.front = head;
        head.next = list;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                moveTail();
            }
            ListNode newNode = new ListNode(key, value);
            //note 把tail和head弄反了。。。
            /*tail.front.next = newNode;
            newNode.front = tail.front;
            newNode.next = tail;
            tail.front = newNode;*/
            //node 这个应该是插在头部
            newNode.next = head.next;
            head.next.front = newNode;
            newNode.front = head;
            head.next = newNode;
            map.put(key, newNode);
        } else {
            ListNode node = map.get(key);
            node.val = value;
            moveToPrimary(node);
        }
    }

    private void moveTail() {
        ListNode lastNode = tail.front;
        /*head.next.next.front = head;
        head.next = head.next.next;*/
        tail.front.front.next = tail;
        tail.front = tail.front.front;
        map.remove(lastNode.key);
    }
}
