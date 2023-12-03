package title.加油站134;
/**
 * 总加油>=总油耗就一定有解
 */
public class test {
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int spare = 0, len = gas.length, minSpare = Integer.MAX_VALUE, minIndex = 0;
        for (int i = 0; i < len; i++) {
            //note 粗心酿成大错
//            spare = gas[i] - cost[i];
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        //note 从下一个点开始，是因为下一个点是第一个开始上升的点，亏空最严重的一个点必须放在最后一步走，等着前面剩余的救助
//        return spare < 0 ? -1 : (minIndex + 1) % len;
        return spare < 0 ? -1 : minSpare >= 0 ? 0 : (minIndex + 1) % len;
    }
}