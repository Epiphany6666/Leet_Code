package title.LCR_138_有效数字;

import java.util.HashMap;
import java.util.Map;

public class test {
}

/*
class Solution {
    public boolean validNumber(String s) {
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
        }
    }
}*/

//method 1：有限状态自动机
class Solution {
    public boolean validNumber(String s) {
        Map[] status = {
                new HashMap<>() {{ put(' ', 0); put('s', 0); put('d', 2); put('.', 4); }},
//                new HashMap<>() {{ put('d', 2); put('.', 4); }},
                new HashMap<>() {{ put('d', 2); put('.', 3); }},
                new HashMap<>() {{ put('d', 2); put('.', 4); put('e', 5); put(' ', 8); }},
                new HashMap<>() {{ put('e', 5); put('d', 3); put(' ', 8); }},
                new HashMap<>() {{ put('d', 3); }},
                new HashMap<>() {{ put('s', 6); put('d', 7); }},
                new HashMap<>() {{ put('d', 7); }},
                new HashMap<>() {{ put('d', 7); put(' ', 8); }},
                new HashMap<>() {{ put(' ', 8); }}
        };
        int p = 0;
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') c = 's';
            else if (c >= '0' && c <= '9') c = 'd';
            else if (c == 'e' || c == 'E') c = 'e';
            //漏了
            else if (c == '.' || c == ' ') c = c;
            else c = '?';

            if (!status[p].containsKey(c)) return false;
            p = (int)status[p].get(c);
        }
//        return true;
        return p == 2 || p== 3 || p == 7 || p == 8;
    }
}
