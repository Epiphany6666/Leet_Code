package title.LCR_139_训练计划I;

public class test {
}

/*
class Solution {
    public int[] trainingPlan(int[] actions) {
        int len = actions.length;
        int[] ans = new int[len];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if ((actions[i] & 1) != 0) ans[idx++] = actions[i];
        }
        for (int i = 0; i < len; i++) {
            if ((actions[i] & 1) == 0) ans[idx++] = actions[i];
        }
        return ans;
    }
}*/

//method 1：双指针
/*
class Solution {
    public int[] trainingPlan(int[] actions) {
        int i = 0, j = actions.length - 1, t = 0;
        while (i < j) {
            while (i < j && (actions[i] & 1) != 0) i++;
            while (i < j && (actions[i] & 1) == 0) j--;
            t = actions[i];
            actions[i] = actions[j];
            actions[j] = t;
        }
        return actions;
    }
}*/

//method 2：快慢指针
class Solution {
    public int[] trainingPlan(int[] actions) {
        int len = actions.length;
        int low = 0, fast = 0;
        while (fast < len) {
            if ((actions[fast] & 1) != 0) {
                int t = actions[low];
                actions[low] = actions[fast];
                actions[fast] = t;
                low++;
            }
            fast++;
        }
        return actions;
    }
}