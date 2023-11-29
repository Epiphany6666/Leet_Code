package title.LCR_164_破解闯关密码;

import java.util.Arrays;

public class test {
}

//method 1：内置函数
/*
class Solution {
    public String crackPassword(int[] password) {
        String[] strs = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            strs[i] = String.valueOf(password[i]);
        }
        Arrays.sort(strs, (i, j) -> ((i + j).compareTo(j + i)));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
*/

//method 2：快排
class Solution {
    public String crackPassword(int[] password) {
        String[] strs = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            strs[i] = String.valueOf(password[i]);
        }
        quickSort(strs, 0, password.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    private void quickSort(String[] strs, int l, int r) {
        //note 居然忘记写结束条件
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[l];
        while (i < j) {
            //只能先从后往前找一个小一点的
//            while (i < j && (strs[i] + strs[l]).compareTo(strs[l] + strs[i]) >= 0) i++;
//            while (i < j && (strs[l] + strs[j]).compareTo(strs[j] + strs[l]) <= 0) j--;
            while((strs[l] + strs[i]).compareTo(strs[i] + strs[l]) >= 0 && i < j) i++;
            while((strs[l] + strs[j]).compareTo(strs[j] + strs[l]) <= 0 && i < j) j--;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}