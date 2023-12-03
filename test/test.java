package test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Emp {
    private String id;
    private int salary;
    private int ts;
    private int ps;
    private int tax;
    private int truthSalary;

    public Emp() {
    }

    public Emp(String id, int salary, int ts, int ps, int tax) {
        this.id = id;
        this.salary = salary;
        this.ts = ts;
        this.ps = ps;
        this.tax = tax;
        this.truthSalary = salary + ts + ps - tax;
    }

    @Override
    public String toString() {
        return "员工号='" + id + '\'' +
                ", 基本工资=" + salary +
                ", 交通补贴=" + ts +
                ", 绩效津贴=" + ps +
                ", 扣税=" + tax +
                ", 实发工资=" + truthSalary +
                '}';
    }
}

public class test {
    public static void main(String[] args) {
        Emp[] emps = new Emp[3];
        emps[0] = new Emp("G001", 3000, 800, 1200, 150);
        emps[1] = new Emp("G002", 3500, 600, 1300, 180);
        emps[2] = new Emp("G003", 4200, 700, 1500, 230);
        for (Emp emp : emps) {
            System.out.println(emp.toString());
        }
    }
}

