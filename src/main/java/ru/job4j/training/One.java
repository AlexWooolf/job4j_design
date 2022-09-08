package ru.job4j.training;

public class One {
    String go = "walk";
    static class Two extends One {
        String go = "fly";
        String stay = "stay";
    }

    public static void main(String[] args) {
        One f = new Two();
        Two b = new Two();
        System.out.println(f.go);
        System.out.println(b.go);
    }

}
