package title.账户合并721;

import java.util.*;

public class test {
    public static void main(String[] args) {
//        UnionFind myUnion = new UnionFind();
    }
}

/*class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 作用：存储每个邮箱属于哪个账户 ，同时 在遍历邮箱时，判断邮箱是否出现过[去重]
        // 格式：<邮箱，账户id>
        Map<String, Integer> emailToId = new HashMap<>();
        int n = accounts.size();//id个数
        UnionFind myUnion = new UnionFind(n);
        for(int i = 0; i < n; i++){
            int num = accounts.get(i).size();
            for(int j = 1; j < num; j++){//遍历所有的邮箱
                String curEmail = accounts.get(i).get(j);
                //当前邮箱没有出现过
                if(!emailToId.containsKey(curEmail)){
                    emailToId.put(curEmail, i);
                }else{//当前邮箱已经出现过，那么代表这两个用户是同一个
                    myUnion.union(i, emailToId.get(curEmail));
                }
            }
        }
        //进行完上面的步骤，同一个用户的所有邮箱已经属于同一个连通域了，但是就算在同一个连通域，不同的邮箱还是可能会对应不同的id
        // 作用： 存储每个账户下的邮箱
        // 格式： <账户id, 邮箱列表> >
        // 注意：这里的key必须是账户id，不能是账户名称，名称可能相同，会造成覆盖
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        //将同一个连通域内的邮箱对应到同一个id【也就是第一次出现的id，比如4、5在同一个连通域，那么这个连通域对应的id就是4】
        for(Map.Entry<String, Integer> entry : emailToId.entrySet()){//取出来的是<邮箱，id>
            int id = myUnion.find(entry.getValue());//得到的是id的头
            List<String> emails = idToEmails.getOrDefault(id, new ArrayList<>());
            emails.add(entry.getKey());//邮箱
            idToEmails.put(id,emails);
        }
        //经过上面的步骤，已经做到了id和邮箱集合对应起来，接下来把用户名对应起来就可以了
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry : idToEmails.entrySet()){//<Id, Email(集合)>
            List<String> emails = entry.getValue();//Email(集合)
            Collections.sort(emails);//排序
            List<String> tmp = new ArrayList<>();
            tmp.add(accounts.get(entry.getKey()).get(0));//先添加用户名
            tmp.addAll(emails);
            res.add(tmp);
        }
        return res;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}*/

/*
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> account) {
        List<List<String>> ans = new ArrayList<>();
        int m = account.size();
        Map<String, Integer> emailToId = new HashMap<>();
        UnionFind myUnion = new UnionFind(m);
        //去重
        for (int i = 0; i < m; i++) {
            int n = account.get(i).size();
            for (int j = 1; j < n; j++) {
                String email = account.get(i).get(j);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, i);
                } else {
                    myUnion.union(emailToId.get(email), i);
                }
            }
        }
        Map<Integer, List<String>> idToEmail = new HashMap<>();
        //合并
        for (Map.Entry<String, Integer> entry : emailToId.entrySet()) {
            int id = entry.getValue();
            List<String> email = idToEmail.getOrDefault(id, new ArrayList<>());
            email.add(entry.getKey());
            idToEmail.put(id, email);
        }

        //名字对应邮箱
        for (Map.Entry<Integer, List<String>> entry : idToEmail.entrySet()) {
            int id = entry.getKey();
            List<String> email = entry.getValue();
            List<String> temp = new ArrayList<>();
            temp.add(account.get(id).get(0));
            Collections.sort(email);
            temp.addAll(email);
            ans.add(temp);
        }
        return ans;
    }
}

class UnionFind {
    int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = index1;
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}*/

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        Map<String, String> emailToName = new HashMap<String, String>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}