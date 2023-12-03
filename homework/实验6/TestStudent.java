package homework.实验6;

class Student {
    private String name;
    private String gender;
    private int age;
    private double height;
    private double weight;
    private int score;
    private String className;

    public Student(String name, String gender, int age, double height, double weight, int score, String className) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.score = score;
        this.className = className;
    }

    public void introduce() {
        System.out.println("我是" + className + "班的一名" + gender + "同学，今年" + age + "岁，身高：" + height + "，体重" + weight);
        System.out.println("今年考了" + score + "分");
    }

    public void dining() {
        System.out.println("我在吃饭。。。。。");
        weight += 1;
    }

    public void walk() {
        System.out.println("我在走路。。。。。");
        weight -= 1;
    }
}

public class TestStudent {
    public static void main(String[] args) {
        Student stu1 = new Student("张三", "男", 18, 170, 60, 90, "高三一班");
        Student stu2 = new Student("李四", "女", 17, 165, 55, 85, "高三二班");

        stu1.introduce();
        stu2.introduce();

        stu1.dining();
        stu1.walk();
        stu2.dining();
        stu2.walk();
    }
}

