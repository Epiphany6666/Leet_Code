package title.数据流的中位数295.overWrite01;

import java.util.PriorityQueue;

public class test {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        double param_2 = obj.findMedian();
        obj.addNum(3);
        double param_3 = obj.findMedian();
    }
}

// note 都没和顶点比大小。。。
//class MedianFinder {
//    PriorityQueue<Integer> left, right;
//    public MedianFinder() {
////        left = new PriorityQueue<>((i, j) -> (i - j));
//        left = new PriorityQueue<>((i, j) -> (j - i));
//        right = new PriorityQueue<>((i, j) -> (i - j));
//    }
//
//    public void addNum(int num) {
//        left.offer(num);
//        while (left.size() > right.size()) {
//            right.offer(left.poll());
//        }
//    }
//
//    public double findMedian() {
//        if (right.size() > left.size()) {
//            return right.peek();
//        } else {
//            return ((double) right.peek() + left.peek()) / 2;
//        }
//    }
//}

//method 三叶
class MedianFinder1 {
    PriorityQueue<Integer> left = new PriorityQueue<>((i, j) -> (j - i));
    PriorityQueue<Integer> right = new PriorityQueue<>((i, j) -> (i - j));
    public MedianFinder1() {

    }

    public void addNum(int num) {
        int l = left.size(), r = right.size();
        if (l == r) {
            if (right.isEmpty() || num <= right.peek()) {
                left.offer(num);
            } else {
                left.offer(right.poll());
                right.offer(num);
            }
        } else {
            if (num >= left.peek()) {
                right.offer(num);
            } else {
                right.offer(left.poll());
                left.offer(num);
            }
        }
    }

    public double findMedian() {
        int l = left.size(), r = right.size();
        if (l == r) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}

//method K神
class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>((i, j) -> (j - i));
    PriorityQueue<Integer> right = new PriorityQueue<>((i, j) -> (i - j));

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (left.size() != right.size()) {
            left.offer(num);
            right.offer(left.poll());
        } else {
            right.offer(num);
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        return left.size() != right.size() ? left.peek() : (left.peek() + right.peek()) / 2.0;
    }
}