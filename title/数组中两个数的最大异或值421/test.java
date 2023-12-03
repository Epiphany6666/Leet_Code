package title.数组中两个数的最大异或值421;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 异或性质：如果 a ^ b = c 成立，那么a ^ c = b 与 b ^ c = a 均成立。
 */
public class test {
}

/*
//method 必定越界
class Solution {
    public int findMaximumXOR(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                ans = Math.max(ans, nums[i] ^ nums[j]);
            }
        }
        return ans;
    }
}*/

/*
//method 1：贪心
class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            int temp = ans | (1 << i);
            for (Integer prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    ans = temp;
                    break;
                }
            }
        }
        return ans;
    }
}*/

/*
//method 2：Trie数组实现
class Solution {
    static int N = (int)2e5 * 31, idx = 0;
    static int[][] Trie = new int[N][2];

    public Solution() {
        for (int row = idx; row >= 0; row--) {
            Arrays.fill(Trie[row],  0);
        }
        idx = 0;
    }

    public void add(int x) {
        int p = 0;
//        for (int i = 30; i >= 0; i--) {
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (Trie[p][u] == 0) Trie[p][u] = ++idx;
            p = Trie[p][u];
        }
    }

    public int get(int x) {
        int p = 0, ans = 0;
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1, b = 1 - a;
            if (Trie[p][b] != 0) {
                ans |= (b << i);
                p = Trie[p][b];
            } else {
                ans |= (a << i);
                p = Trie[p][a];
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            add(num);
            ans = Math.max(ans, num ^ get(num));
        }
        return ans;
    }
}*/

//method 3：Trie类实现
class Solution {
    class TrieNode {
        TrieNode[] tns = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    public void add(int x) {
        TrieNode p = root;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (p.tns[u] == null) p.tns[u] = new TrieNode();
            p = p.tns[u];
        }
    }

    public int getVal(int x) {
        TrieNode p = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1, b = 1 - a;
            if (p.tns[b] != null) {
                ans |= (b << i);
                p = p.tns[b];
            } else {
                ans |= (a << i);
                p  = p.tns[a];
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            add(num);
            ans = Math.max(ans, num ^ getVal(num));
        }
        return ans;
    }
}