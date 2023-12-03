package title.IP地址无效化1108;

/**
 * replace和replaceAll是JAVA中常用的替换字符的方法,它们的区别是:
 *
 * 1)replace的参数是char和CharSequence,即可以支持字符的替换,也支持字符串的替换(CharSequence即字符串序列的意思,说白了也就是字符串);
 *
 * 2)replaceAll的参数是regex,即基于规则表达式的替换,比如,可以通过replaceAll("\\d", "*")把一个字符串所有的数字字符都换成星号;
 */
public class test {
    public static void main(String[] args) {

    }
}

/*
class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("//.", "[.]");
    }
}*/

//method 2
class Solution {
    public String defangIPaddr(String address) {
        StringBuffer sb = new StringBuffer();
        for (char c : address.toCharArray()) {
            if (c == '.') sb.append('[');
            sb.append(c);
            if (c == '.') sb.append(']');
        }
        return sb.toString();
    }
}