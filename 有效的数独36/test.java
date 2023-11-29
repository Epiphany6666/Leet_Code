package title.有效的数独36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 推导当前位置和所在编号的公式是什么鬼啊
 * idx=i / 3 * 3 + j / 3;
 */
public class test {
}

//method 1：哈希表
/*
class Solution {
    public boolean isValidSudoku(char[][] board) {
        */
/*Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> area = new HashMap<>();*//*

        //note 不可以嵌套map，但是可以存放set
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> col = new HashMap<>();
        Map<Integer, Set<Integer>> area = new HashMap<>();

        //note 2 ：又忘记set的初始化
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int x = board[i][j] - '0';
                int idx = i / 3 * 3 + j / 3;
                if (row.get(i).contains(x) ||
                    col.get(j).contains(x) ||
                    area.get(idx).contains(x)) {
                    return false;
                }
                row.get(i).add(x);
                col.get(j).add(x);
                area.get(idx).add(x);
            }
        }
        return true;
    }
}*/

//method 2：数组
//note 大多数的哈希表计数问题，都能转换为使用数组解决。虽然时间复杂度一样，但哈希表的更新和查询复杂度为均摊 O(1)O(1)O(1)，而定长数组的的更新和查询复杂度则是严格 O(1)O(1)O(1)。因此从执行效率上来说，数组要比哈希表快上不少。
/*
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] area = new boolean[9][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                int num = ch - '0';
                int idx = i / 3 * 3 + j / 3;
                if (row[i][num] || col[j][num] || area[idx][num]) {
                    return false;
                }
                */
/*row[i][num] = true;
                col[j][num] = true;
                area[idx][num] = true;*//*

                //note 数组是可以连等的。。。
                row[i][num] = col[j][num] = area[idx][num] = true;
            }
        }
        return true;
    }
}*/

//method 3：位运算
//mind 这种方式我好像已经见到过很多次了，但是每次自己做就不会
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] area = new int[9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int num = ch - '0';
                int idx = i / 3 * 3 + j / 3;
                if (((row[i] >> num) & 1) == 1 ||
                      ((col[j] >> num) & 1) == 1 ||
                        ((area[idx] >> num) & 1) == 1)
                    return false;

                row[i] |= (1 << num);
                col[j] |= (1 << num);
                area[idx] |= (1 << num);
            }
        }
        return true;
    }
}