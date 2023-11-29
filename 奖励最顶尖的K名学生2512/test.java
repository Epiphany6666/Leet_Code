package title.奖励最顶尖的K名学生2512;

import java.util.*;

public class test {
    public static void main(String[] args) {
        new Solution().topStudents(new String[] {"smart","brilliant","studious"},
                new String[] {"not"}, new String[] {"this student is not studious","the student is smart"},
                new int[] {1, 2}, 2
                );
    }
}

/*
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Integer> list = new ArrayList<>();
        */
/*PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> {
            if (i[1] != j[1]) {
                return j[1] - i[1];
            } else {
                return i[0] - j[0];
            }
        });*//*

        //note 简写
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> (i[1] == j[1] ? i[0] - j[0]) : j[1] - i[1]);

        int len = report.length;
        int[][] r = new int[len][2];
        Set<String> positive_feedbackSet = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative_feedbackSet = new HashSet<>(Arrays.asList(negative_feedback));

        for (int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            int score = 0;
            for (String s : str) {
                if (positive_feedbackSet.contains(s)) score += 3;
                else if (negative_feedbackSet.contains(s)) score -= 1;
            }
            //note 很讨厌你这种自以为是的
//            pq.offer(new int[] {i, score});
            pq.offer(new int[] {student_id[i], score});
        }

        //note 题目要求是前K名学生。。。
//        while (!pq.isEmpty()) {
        while (!pq.isEmpty() && k-- > 0) {
            list.add(pq.poll()[0]);
        }
        return list;
    }
}*/

//method 2：直接使用hash表进行存储
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> (i[1] == j[1] ? i[0] - j[0] : j[1] - i[1]));

        for (String s : positive_feedback) {
            map.put(s, 3);
        }

        for (String s : negative_feedback) {
            map.put(s, -1);
        }

        for (int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            int score = 0;
            for (String s : str) {
                score += map.getOrDefault(s, 0);
            }
            pq.offer(new int[] {student_id[i], score});
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(pq.poll()[0]);
        }
        return ans;
    }
}