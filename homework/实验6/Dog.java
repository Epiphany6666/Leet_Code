package homework.实验6;

public class Dog {
    private String chineseName;
    private String englishName;
    private double weight;
    private String color;
    private double price;
    private String origin;

    public Dog(String chineseName, String englishName, double weight, String color, double price, String origin) {
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.weight = weight;
        this.color = color;
        this.price = price;
        this.origin = origin;
    }

    public void eat(String time) {
        if (time.equals("morning")) {
            System.out.println("狗在早晨吃饭");
        } else if (time.equals("noon")) {
            System.out.println("狗在中午吃肉");
        } else if (time.equals("evening")) {
            System.out.println("狗在晚上吃骨头");
        }
    }

    public void sleep() {
        System.out.println("狗在睡觉");
    }

    public void modifyPrice() {
        if (weight < 30) {
            price = 500;
        } else if (weight >= 30 && weight <= 50) {
            price = 2000;
        } else {
            price = 4000;
        }
    }

    public void bark(String time) {
        if (time.equals("morning")) {
            System.out.println("狗吠的声音小");
        } else if (time.equals("evening")) {
            System.out.println("狗吠的声音很大");
        }
    }

    public void displayInfo() {
        System.out.println("中文名称：" + chineseName);
        System.out.println("英文名称：" + englishName);
        System.out.println("体重：" + weight + "kg");
        System.out.println("毛色：" + color);
        System.out.println("价格：" + price + "元");
        System.out.println("原产地：" + origin);
    }

    public static void main(String[] args) {
        Dog dog = new Dog("哈士奇", "Husky", 25, "灰白色", 0, "西伯利亚");
        dog.displayInfo();
        dog.modifyPrice();
        System.out.println("修改后的价格：" + dog.price + "元");
        dog.bark("morning");
        dog.eat("morning");
    }
}
