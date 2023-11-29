package title.分隔链表725;

public class test {
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int cnt = 0;
        //统计链表的个数
        while (temp != null && ++cnt > 0) temp = temp.next;

        ListNode[] ans = new ListNode[k];
        //计算每个链表理应分到多少个结点
        int pre = cnt / k;
        //sum代表已经被处理的链表长度为多少
        for (int i = 0, sum = 1; i < k; i++, sum++) {
            ans[i] = head;
            temp = ans[i];
            //先分配pre的长度
            int u = pre;
            while (u-- > 1 && ++sum > 0) temp = temp.next;
            //当[已处理的链表长度 + 剩余待分配份数 * pre < cnt]，再分配一个单位长度
            int remind = k - i - 1;
            if (pre != 0 && sum + remind * pre < cnt && ++sum > 0) temp = temp.next;
            head = temp == null ? null : temp.next;
            if (temp != null) temp.next = null;
        }
        return ans;
    }
}