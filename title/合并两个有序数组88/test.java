package title.合并两个有序数组88;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new Solution().merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}

/**全部敲完之后，突然发现自己看错了题，简单题也不会写了，害，调试之后发现，原来是犯了一个很致命的错误。。
 * 怎么能直接nums1 = temp;啊，方法里的nums1改变了，但调用此方法的nums1并没有改变啊。。。
 **/
//法1：双指针
/*class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int p1 = 0, p2 = 0, k = -1;
        while (p1 < m && p2 < n) {
            int n1 = nums1[p1];
            int n2 = nums2[p2];
            if (n1 < n2) {
                temp[++k] = n1;
                p1++;
            } else {
                temp[++k] = n2;
                p2++;
            }
        }
        if (p1 < m) {
            for (int i = p1; i < m; i++) {
                temp[++k] = nums1[i];
            }
        }
        if (p2 < n) {
            for (int i = p2; i < n; i++) {
                temp[++k] = nums2[i];
            }
        }
        nums1 = temp;*//**千万不能犯这样的错啊*//*
        for (int i = 0; i < m + n - 1; i++) {
            nums1[i] = temp[i];
        }
    }
}*/
//自写方法简化-参考别人代码后
/*class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] temp = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            temp[p1 + p2 - 1] = cur;
        }
        for (int i = 0;i < m + n; i++) {
            nums1[i] = temp[i];
        }
    }
}*/

/**看了别人的，从后往前，太巧秒了，真的太巧秒了*/
//法2：从后往前
/*
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
            while (m >= 0 && nums1[m] > nums2[n]) {
                nums1[len--] = nums1[m--];
            }
            nums1[len--] = nums2[n--];
        }
    }
}*/

//逆向双指针另一种写法：
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        m--;
        n--;
        int cur;
        while (m >= 0 || n >= 0) {
            if (m == -1) {
                cur = nums2[n--];
            } else if (n == -1) {
                cur = nums1[m--];
            } else if (nums1[m] > nums2[n]) {
                cur = nums1[m--];
            } else {
                cur = nums2[n--];
            }
            nums1[len--] = cur;
        }
    }
}

/**数组可以排序的特性，又忘记。。*/
/*
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[n + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}*/

/***/