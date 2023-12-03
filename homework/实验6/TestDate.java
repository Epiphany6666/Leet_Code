package homework.实验6;

class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void displayInfo() {
        System.out.println(year + "年" + month + "月" + String.format("%02d", day) + "日");
    }
}

public class TestDate {
    public static void main(String[] args) {
        Date date = new Date(2008, 10, 1);
        date.displayInfo();
    }
}
