package Leet_Code.src.BlueBridge;

public class 门牌制作 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i <= 2020; i++) {
            int temp = i;
            while (temp != 0) {
                if (temp % 10 == 2) count++;
                temp /= 10;
            }
        }
        System.out.print(count);
    }

    public void methode2(int i)  {
        int count = 0;
        for (int j = i; j > 0; j /= 10) {
            if (j % 2 == 0) count++;
        }
    }

    public void method3(int i) {
        int count = 0;
        String a = "";
        for (int j = 0; j < a.length(); j++) {
            if (a.charAt(j) == '2') count++;
        }
    }
}
