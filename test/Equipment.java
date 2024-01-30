package test;

class a {
    public static void main(String[] args) {
        String s = "$$$   $e$$   asy$";
        String[] strs = s.split("\\$");
        for (String str : strs) {
            System.out.println(str);
        }
    }
}