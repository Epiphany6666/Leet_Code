package title.LFU缓存460;

import java.util.HashMap;
import java.util.Map;

/**
 * 太乱了。。。
 */

public class test {
}

class LFUCache {
    Map<Integer, Bucket> map = new HashMap<>();
    Bucket head, tail;
    int n;
    int cnt;

    class Item {
        int key, val;
        Item l, r;
        public Item(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class Bucket {
        //三叶姐Map一般初始化都是在全局变量
        Map<Integer, Item> map = new HashMap<>();
        Item head, tail;
        Bucket l, r;
        int idx;
        public Bucket(int idx) {
            this.idx = idx;
            head = new Item(-1, -1);
            tail = new Item(-1, -1);
            head.r = tail;
            tail.l = head;
        }

        public void put(int key, int val) {
            Item item = null;
            //判断key是否存在
            if (map.containsKey(key)) {
                item = map.get(key);
                item.val = val;
                //note 这里的移除不用remove方法
                //remove(key);
                item.l.r = item.r;
                item.r.l = item.l;
                //note 一定不要忘记添加到hash表中
                map.put(key, item);
            } else {
                item = new Item(key, val);
            }
            //question 为什么如果存在，移除之后不需要加入 idx+1 的桶
            //拼接到头
            item.r = head.r;
            item.l = head;
            head.r.l = item;
            head.r = item;
        }

        /*private void remove(Item item) {
            item.l.r = item.r;
            item.r.l = item.l;
        }*/
        //note remove的返回值是Item，形参是key
        private Item remove(int key) {
            if (map.containsKey(key)) {
                Item item = map.get(key);
                item.l.r = item.r;
                item.r.l = item.l;
            }
            return null;
        }

        //清除尾部的结点
        private Item clear() {
            Item item = tail.r;
            item.r.l = item.l;
            item.l.r = item.r;
            return item;
        }

        private boolean isEmpty() {
            //note 不要再重新创建一个变量了！
            return map.size() == 0;
        }
    }

    public LFUCache(int capacity) {
        n = capacity;
        head = new Bucket(-1);
        tail = new Bucket(-1);
        head.r = tail;
        tail.l = head;
        cnt = 0;
    }

    public int get(int key) {
        Bucket bucket = null;
        //判断key是否存在
        if (map.containsKey(key)) {
            //存在的话，就需要1.获取键的值   2.bucket的索引+1
            bucket = map.get(key);
            Item item = bucket.remove(key);

            Bucket target = null;
            //判断下一个桶是否存在
            if (bucket.l.idx != bucket.idx + 1) {
                //如果不存在，就创建一个桶
                target = new Bucket(bucket.idx + 1);
                //链接其他桶
                target.l = bucket;
                target.r = bucket.r;
                bucket.r.l = target;
                bucket.r = target;
            } else {
                //note 总是忘
                target = bucket.r;
            }
            //note 更新当前桶的信息
            map.put(key, target);

//            target.put(key, item.val);
            target.put(item.key, item.val);
            //如果在移除掉当前键值对后，当前桶为空，则将当前桶删除（确保空间是O(n)的）
            //也确保调用编号最小的桶的clear方法，能够有效移除掉一个元素
            deleteIfEmpty(bucket);

            return item.val;
        }
        return -1;
    }


    public void put(int key, int value) {
        Bucket bucket = null;
        //判断是否存在
        if (map.containsKey(key)) {
            //若存在，则执行更新操作
            bucket = map.get(key);
            //note 为什么还要提取出来，不就是bucket.put(key, value)吗
            /*Item item = bucket.remove(key);
            item.val = value;*/
            bucket.put(key, value);
            //再执行一次get操作，使其计数器加1
            get(key);
        } else {
            //判断容量是否满了
            if (cnt == n) {
                bucket = head.l;
                Item clear = bucket.clear();
                //从map中删除
                map.remove(clear.key);
                deleteIfEmpty(bucket);
                cnt--;
            }

            bucket = null;
            //没有第一个桶则创建
            if (head.r.idx != 1) {
                bucket = new Bucket(1);
                bucket.l = head;
                bucket.r = head.r;
                head.r.l = bucket;
                head.r = bucket;
            } else {
                bucket = head.r;
            }
            bucket.put(key, value);
            //存入hash表
            map.put(key, bucket);
            //cnt++
            cnt++;
        }
    }

    private void deleteIfEmpty(Bucket bucket) {
        if (bucket.isEmpty()) {
            bucket.l = bucket.r;
            bucket.r = bucket.r;
            bucket = null;//question help GC
        }
    }
}