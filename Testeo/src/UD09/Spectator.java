package UD09;

public class Spectator {
    private String name;
    private int age;
    private double money;

    public Spectator(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}