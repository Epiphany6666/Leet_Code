package title.合并K个升序链表23;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val;this.next=next;}
}

public class test {
    public static void main(String[] args) {
        ListNode[] list = new ListNode[3];
        ListNode p1 = new ListNode(5);
        ListNode p2 = new ListNode(4, p1);
        ListNode p3 = new ListNode(1, p2);
        list[0] = p3;
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(3, p4);
        ListNode p6 = new ListNode(1, p4);
        list[1] = p6;
        ListNode p7 = new ListNode(6);
        ListNode p9 = new ListNode(2, p7);
        list[2] = p9;
        new Solution().mergeKLists(list);
    }
}

//法1：自写
/*
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        if (lists.length == 0) return head;
//        ListNode head2 = new ListNode(Integer.MIN_VALUE);
        for (ListNode list : lists) {
            ListNode p1 = head == null ? head : head.next, p2 = list;
            ListNode temp = new ListNode(Integer.MIN_VALUE), tail = temp;
            while (p1 != null || p2 != null) {
                int n1 = (p1 == null) ? 0x3f3f3f3f : p1.val;
                int n2 = (p2 == null) ? 0x3f3f3f3f : p2.val;
                ListNode t = null;
                if (n1 < n2) {
                    t = new ListNode(n1);
                    tail.next = t;
                    tail = tail.next;
                    p1 = p1.next;
                } else {
                    t = new ListNode(n2);
                    tail.next = t;
                    tail = tail.next;
                    p2 = p2.next;
                }

                */
/*if (p1 != null) p1 = p1.next;//注意判断是否为空
                if (p2 != null) p2 = p2.next;//只需要移动一个哇！*//*

            }
            head = temp;
        }
        return head.next;
    }
}*/

/*
//法2：K指针
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (true) {
            ListNode minNode = null;
            int minPoint = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) continue;
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPoint = i;
                }
            }
            if (minNode == null) break;
            tail.next = minNode;
            tail = tail.next;
            lists[minPoint] = lists[minPoint].next;
        }
        return dummyHead.next;
    }
}*/

/*
//法3：使用小根堆对法2进行优化
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((i, j) -> i.val - j.val);
        for (ListNode list : lists) {
            if (list != null) pq.offer(list);
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode list = pq.poll();
            tail.next = list;
            tail = tail.next;
            if (list.next != null) pq.offer(list.next);
        }
        return dummyHead.next;
    }
}*/


//法4：逐一合并两条链表-递归
/*
class Solution {
    */
/*public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        for (ListNode list : lists) {
            dummyHead = mergeTwoLists(dummyHead, list);
        }
        return dummyHead.next;
    }*//*


    //这里是可以直接传空的
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode res = null;
        for (ListNode list : lists) {
            res = mergeTwoLists(res, list);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}*/

/*
//法5：两两合并-迭代
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k < 1) return null;
        while (k > 1) {
            int idx = 0;
            for (int i = 0; i < k; i += 2) {
//                if (i - 1 == k) {
                if (i == k - 1) {
                    lists[idx++] = lists[i];
                } else {
                    lists[idx++] = mergeTwoLists(lists[i], lists[i + 1]);
                }
            }
            k = idx;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}*/

//法5：两两合并-递归
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k < 1) return null;
        return partition(lists, 0, k - 1);
    }

    public ListNode partition(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = partition(lists, left, mid);
        ListNode l2 = partition(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}