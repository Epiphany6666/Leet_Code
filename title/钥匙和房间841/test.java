package 钥匙和房间841;

import java.util.*;

public class test {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(2)));
        list.add(new ArrayList<>(Arrays.asList(3)));
        list.add(new ArrayList<>(Arrays.asList()));
        new Solution().canVisitAllRooms(list);
    }
}

//method bfs
/*class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> q = new LinkedList<>();
        int size = rooms.size();
        boolean[] visited = new boolean[size];
        visited[0] = true;
        q.offer(0);

        while (!q.isEmpty()) {
            int x = q.poll();
            if (!visited[x]) {
                visited[x] = true;
                for (Integer i : rooms.get(x)) {
                    q.offer(i);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if  (!visited[i]) return false;
        }
        return true;
    }
}*/

//method dfs
/*
class Solution {
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        visited = new boolean[size];
        visited[0] = true;
        dfs(rooms, 0);

        for (int i = 0; i < size; i++) {
            if  (!visited[i]) return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int n) {
        for (Integer i : rooms.get(n)) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(rooms, i);
            }
        }
    }
}*/

//bfs修改
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> q = new LinkedList<>();
        int size = rooms.size();
        boolean[] visited = new boolean[size];
        visited[0] = true;
        q.offer(0);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (Integer i : rooms.get(x)) {
                //note 太粗心了。。。
//                if (!visited[x]) {
//                    visited[x] = true;
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}