package title.丑数Ⅱ264;

public class test {
    public static void main(String[] args) {
        new Solution().nthUglyNumber(10);
    }
}

//mind  .......
/*
class Solution {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n];
        int idx = 0;
        for (int i = 1; ; i++) {
            if (isUglyNumber(i)) {
                ans[idx++] = i;
            }
            if (idx >= n) {
                break;
            }
        }
        return ans[n - 1];
    }

    private boolean isUglyNumber(int i) {
        if (i == 1) {
            return true;
        }

        if (i % 4 == 0) {
            return false;
        }

        if (i % 7 == 0) {
            return false;
        }
        return true;
    }
}*/

/*
class Solution {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n];
        int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>(Arrays.asList(2, 3, 5));
        while (!dq.isEmpty()) {
            int x = dq.poll();
            ans[idx++] = x;
            if (idx >= x) break;
            dq.offer(x * 2);
            dq.offer(x * 3);
            dq.offer(x * 5);
        }
        return ans[n - 1];
    }
}*/

class Solution {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = res[a] * 2, n3 = res[b] * 3, n5 = res[c] * 5;
            res[i] = Math.min(Math.min(n2, n3), n5);
            if (res[i] == n2) a++;
            if (res[i] == n3) b++;
            if (res[i] == n5) c++;
        }
        return res[n - 1];
    }
}