package homework.实验6;

class Computer {
    private String brand;
    private String type;
    private String madeIn;
    private double price;

    public Computer() {
        this.brand = "联想";
        this.type = "INTER 双核";
        this.madeIn = "中国";
        this.price = 7000.00;
    }

    public void show() {
        System.out.println("品牌：" + brand);
        System.out.println("型号：" + type);
        System.out.println("产地：" + madeIn);
        System.out.println("价格：" + price + "元");
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class TestComputer {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.show();

        computer.setBrand("DELL");
        computer.setType("INTER i5");
        computer.setMadeIn("美国");
        computer.setPrice(8000.00);

        computer.show();
    }
}
