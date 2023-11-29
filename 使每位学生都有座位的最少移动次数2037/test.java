package 使每位学生都有座位的最少移动次数2037;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 为什么要把简单问题复杂化？
 */

public class test {
    public static void main(String[] args) {
        int[] seats = {2,2,6,6};
        int[] students = {1,3,2,6};
        System.out.println(new Solution().minMovesToSeat(seats, students));
    }
}

/*
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int count = 0;
        Map<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        */
/*for (int i = 0; i < seats.length; i++) {
            hashTable.put(seats[i], 0);
        }*//*

        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            if (!hashTable.containsKey(students[i]) && isExist(seats, students[i])) {
                hashTable.put(seats[i], 1);
            } else {
                for (int j = 0; j < seats.length; j++) {
                    if (!hashTable.containsKey(seats[j])) {
                        hashTable.put(seats[j], 1);
                        count += Math.abs(seats[j] - students[i]);
                    }
                }
            }
        }
        return count;
    }

    public boolean isExist(int[] seats, int nums) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == nums)
                return true;
        }
        return false;
    }
}*/

/*
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            if (hashTable.containsKey(seats[i])) {
                hashTable.put(seats[i], hashTable.get(i) + 1);
            } else {
                hashTable.put(seats[i], 1);
            }
        }
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            if (hashTable.containsKey(students[i]) && hashTable.get(students[i]) != 0) {
                hashTable.put(students[i], hashTable.get(students[i]) - 1);
            } else {
                for (int j = 0; j < seats.length; j++) {
                    if (hashTable.get(seats[j]) != true) {
                        hashTable.put(seats[j], true);
                        count += Math.abs(seats[j] - students[i]);
                        break;
                    }
                }
            }
        }
        return count;
    }
}*/

//。。。。
class Solution {
    public int minMovesToSeat(int[] seat, int[] student) {
        int count = 0;
        Arrays.sort(seat);
        Arrays.sort(student);
        for (int i = 0; i < seat.length; i++) {
            count += Math.abs(seat[i] - student[i]);
        }
        return count;
    }
}