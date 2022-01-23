package com.example.javademo;

public enum Gender {
    MAIE("男") {
        @Override
        public void info() {

        }
    }, FEMALE("女") {
        @Override
        public void info() {

        }
    };
    private String name;

    public String getName() {
        return name;
    }

    Gender(String name) {
        this.name = name;
    }

    public abstract void info();
}

class GenderTest {
    public static void main(String[] args) {
        Gender g = Gender.FEMALE;
        System.out.println(g + "代表" + g.getName());
    }
}
