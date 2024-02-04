package title.无法吃午餐的学生数量1700;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
}

//class Solution {
//    public int countStudents(int[] students, int[] sandwiches) {
//        Deque<Integer> q = new ArrayDeque<>() {{
//            for (int sandwich : sandwiches) {
//                offer(sandwich);
//            }
//        }};
//        Deque<Integer>
//    }
//}

//mind 害，啥时候才能学会大佬的思想
class Solution1 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        for (int student : students) {
            cnt[student]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (--cnt[sandwiches[i]] == -1) return sandwiches.length - i;
        }
        return 0;
    }
}

class Solution {
    public int countStudents(int[] a, int[] b) {
        int[] cnt = new int[2];
        for (int i : a) {
            cnt[i]++;
        }
        for (int i = 0; i < b.length; i++) {
            if (--cnt[b[i]] == -1) return b.length - i;
        }
        return 0;
    }
}