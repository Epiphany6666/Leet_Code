package title.计算列车到站时间2651.overWrite01;

public class test {
}

class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}