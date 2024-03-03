package title.树中距离之和834;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
}

class Solution1 {
    int[] table;
    int[] distSum;
    int[] nodeNum;
    public int[] sumOfDistanceInTree(int N, int[][]edges) {
        //构建邻接表
        table = new int[N];
        for (int i = 0; i < edges.length; i++) {
            table[edges[i][0]] = edges[i][1];
        }
        distSum = new int[N];
        nodeNum = new int[N];
//        postTraversal();
        return distSum;
    }
}

class Solution {
    private List<List<Integer>> graph = new ArrayList<>();
    int[] distSum;
    int[] nodeNum;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }
        distSum = new int[N];
        nodeNum = new int[N];
        Arrays.fill(nodeNum, 1);
        postOrder(0, -1);
        preOrder(0, -1);
        return distSum;
    }
    private void postOrder(int root, int parent) {
        List<Integer> neighbors = graph.get(root);
        for(Integer neighbor : neighbors) {
            if(neighbor == parent)
                continue;
            postOrder(neighbor, root);
            nodeNum[root] += nodeNum[neighbor];
            distSum[root] += distSum[neighbor] + nodeNum[neighbor];
        }
    }
    private void preOrder(int root, int parent) {
        List<Integer> neighbors = graph.get(root);
        for(Integer neighbor : neighbors) {
            if(neighbor == parent)
                continue;
            distSum[neighbor] = distSum[root] - nodeNum[neighbor] + (graph.size() - nodeNum[neighbor]);
            preOrder(neighbor, root);
        }
    }
}
