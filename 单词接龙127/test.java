package title.单词接龙127;

import java.util.*;

public class test {
    public static void main(String[] args) {
        new Solution().ladderLength("hit", "cog", new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}

//method 1：广度优先遍历
/*
class Solution {
    HashSet<String> wordSet;
    HashSet<String> visited = new HashSet<>();
    Deque<String> q = new ArrayDeque<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        */
/*for (String word : wordList) {
            wordSet.add(word);
        }*//*

        //note 简写
        wordSet = new HashSet<>(wordList);

        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        wordSet.remove(beginWord);

        q.offer(beginWord);
        visited.add(beginWord);
        int step = 1;//包含自己
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curWord = q.poll();
                if (isEndWord(curWord, endWord)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean isEndWord(String curWord, String endWord) {
        char[] charArray = curWord.toCharArray();
        for (int i = 0; i < curWord.length(); i++) {
            char tempChar = charArray[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (tempChar == j) continue;
                charArray[i] = j;
                String newWord = String.valueOf(charArray);
                if (wordSet.contains(newWord)) {
                    if (newWord.equals(endWord)) {
                        return true;
                    }

                    if (!visited.contains(newWord)) {
                        q.offer(newWord);
                        visited.add(newWord);
                    }
                }
            }
            //恢复
            charArray[i] = tempChar;
        }
        return false;
    }
}*/

//method 2：双向优先遍历
class Solution {
    HashSet<String> wordSet;
    Set<String> visited;
    Deque<String> beginVisited;
    Deque<String> endVisited;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        visited = new HashSet<>(Arrays.asList(beginWord, endWord));

        beginVisited = new ArrayDeque<>() ;
        beginVisited.offer(beginWord);
        endVisited = new ArrayDeque<>();
        endVisited.offer(endWord);

        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            if (beginVisited.size() > endVisited.size()) {
                Deque<String> temp;
                temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            int size = beginVisited.size();
            while (size-- > 0) {
                String curWord = beginVisited.poll();
                if (isUnion(curWord, endWord)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean isUnion(String curWord, String endWord) {
        char[] charArray = curWord.toCharArray();
        for (int i = 0; i < curWord.length(); i++) {
            char tmp = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (tmp == k) continue;
                charArray[i] = k;
                String newWord = String.valueOf(charArray);
                if (wordSet.contains(newWord)) {
                    if (endVisited.contains(newWord)) {
                        return true;
                    }
                    if (!visited.contains(newWord)) {
                        beginVisited.offer(newWord);
                        visited.add(newWord);
                    }
                }
            }
            //恢复
            charArray[i] = tmp;
        }
        return false;
    }
}