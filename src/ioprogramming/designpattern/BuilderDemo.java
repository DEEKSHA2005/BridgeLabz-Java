package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Builder Pattern
 Used for complex object creation
*/

class User {

    private String name;
    private int age;
    private String email;

    // private constructor
    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
    }

    // display method
    public void showUser() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }

    /* Static Builder class */
    static class Builder {

        private String name;
        private int age;
        private String email;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

public class BuilderDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Enter age:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter email:");
        String email = sc.nextLine();

        // build object
        User user = new User.Builder()
                .setName(name)
                .setAge(age)
                .setEmail(email)
                .build();

        user.showUser();
    }
}
