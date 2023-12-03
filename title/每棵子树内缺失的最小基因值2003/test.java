package title.每棵子树内缺失的最小基因值2003;

import java.util.*;

public class test {
}
class Solution {
    List<List<Integer>> children;   // 子节点列表
    Set<Integer> genSet;            // 基因值集合

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        children = new ArrayList<>();
        for(int i = 0; i < n; i++){
            children.add(new ArrayList<>());    // 生成每个节点的子节点列表
        }
        int genOnePathNode = nums[0] == 1 ? 0 : -1;     // 表示基因值为1的节点到根节点上的所有节点，初始为基因值为1的节点（可能不存在）
        for(int i = 1; i < n; i++){
            children.get(parents[i]).add(i);        // 添加子节点
            if(nums[i] == 1)genOnePathNode = i;     // 找到基因值为1的节点
        }

        int[] res = new int[n];
        Arrays.fill(res, 1);    // 初始每个节点为根的子树最小缺失值都为1
        int lastNode = -1;      // 上一个处理的节点，其子树无需处理
        int missVal = 2;        // 基因值为1的节点所在路径上的节点，最小缺失值从2开始搜索
        genSet = new HashSet<>();
        while(genOnePathNode != -1){
            dfs(genOnePathNode, lastNode, nums);        // 搜索以genOnePathNode为根的子树的基因值
            while(genSet.contains(missVal))missVal++;   // 找到最小缺失值
            res[genOnePathNode] = missVal;
            lastNode = genOnePathNode;
            genOnePathNode = parents[genOnePathNode];   // 更新genOnePathNode，为其父节点，直到到达根节点
        }

        return res;
    }

    private void dfs(int node, int genOnePathNode, int[] nums){
        genSet.add(nums[node]);                 // 添加节点基因值
        for(int child: children.get(node)){
            if(child == genOnePathNode)continue;    // 如果子节点为路径上的节点，已经搜索过了无需搜索
            dfs(child, genOnePathNode, nums);       // 递归搜索子节点的子树
        }
    }
}