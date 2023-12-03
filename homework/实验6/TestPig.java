package homework.实验6;
public class TestPig {
    public static void main(String[] args) {
        Pig pig = new Pig("白色", 5, 50, 0.8);
        pig.displayInfo();
    }
}


class Pig {
    private String color;
    private int size;
    private int attack;
    private double accuracy;

    public Pig(String color, int size, int attack, double accuracy) {
        this.color = color;
        this.size = size;
        this.attack = attack;
        this.accuracy = accuracy;
    }

    public void displayInfo() {
        System.out.println("一只" + color + "的猪，个头" + size + "厘米，攻击力为" + attack + "点血，准确度为" + accuracy + "，我好怕怕呀");
    }
}

