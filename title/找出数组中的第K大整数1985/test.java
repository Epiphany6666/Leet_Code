package title.找出数组中的第K大整数1985;

import java.util.Arrays;

/**
 * 新知识：
 * o1.compareTo(o2)
 *      1.长度不等，返回compareTo 返回字符串长度之差
 */

public class test {
    public static void main(String[] args) {
        new Solution().kthLargestNumber(new String[] {"3","6","7","10"}, 4);
    }
}

/*class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        //注意题目是从大到小排
        PriorityQueue<String> pq =
                new PriorityQueue<>((i, j) ->
                        (new BigInteger(i).subtract(new BigInteger(j)).toString().charAt(0) == '-' ? 1 : -1));

        for (String num : nums) {
            pq.offer(num);
        }

        String ans = "";
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                ans = pq.poll();
                break;
            }
            else pq.poll();
        }
        return ans;
    }
}*/

/**
 * 我没有使用直接排序的原因是因为我怕会溢出，使用了BigInteger，结果告诉我：
 * 测试用例通过了，但耗时太长。
 * 但不过也不算难过，因为至少证明我BigInteger使用对了
 */
/*
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (i, j) -> -(Integer.parseInt(i) - Integer.parseInt(j)));
        return nums[k - 1];
    }
}*/

/**想也不用想，会溢出
 * 1.先根据长度排序，如果长度一样，就根据长度的最高位依次排序
 * */
/*
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (i, j) -> (j.length() - i.length()));
        return nums[k - 1];
    }
}*/

/**参考别人的做法*/
/*
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (i, j) -> {
            if(i.length() < j.length())
                return 1;
            else if (i.length() > j.length())
                return -1;
            else
//                return i.compareTo(j);
                return j.compareTo(i);
        });
        return nums[k - 1];
    }
}*/

/**
 * 还是不能这么做，因为如果是按照升序排，则长度大的会在前面
 * 如果是按照降序排，则长度大的又会在后面
 */
/*
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (i, j) -> (i.compareTo(j)));
        return nums[k - 1];
    }
}*/

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (o1, o2) -> (o1.length() == o2.length() ? o2.compareTo(o1) : o2.length() - o1.length()));
        return nums[k - 1];
    }
}