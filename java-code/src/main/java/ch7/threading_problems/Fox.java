package ch7.threading_problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Food {
    protected int id;

    public Food(int id) {
        this.id = id;
    }
}

class Water {
    protected int id;

    public Water(int id) {
        this.id = id;
    }
}

public class Fox {
    public void eatAndDrink(Food food, Water water) {
        synchronized (food) {
            System.out.printf("Food%d locked by thread %s%n", food.id, Thread.currentThread().getName());
            System.out.println("Got Food!");
            move();
            synchronized (water) {
                System.out.printf("Water%d locked by thread %s%n", water.id, Thread.currentThread().getName());
                System.out.println("Got Water!");
            }
            System.out.printf("Water%d released by thread %s%n", water.id, Thread.currentThread().getName());
        }
        System.out.printf("Food%d released by thread %s%n", food.id, Thread.currentThread().getName());
    }

    public void drinkAndEat(Food food, Water water) {
        synchronized (water) {
            System.out.printf("Water%d locked by thread %s%n", water.id, Thread.currentThread().getName());
            System.out.println("Got Water!");
            move();
            synchronized (food) {
                System.out.printf("Food%d locked by thread %s%n", food.id, Thread.currentThread().getName());
                System.out.println("Got Food!");
            }
            System.out.printf("Food%d released by thread %s%n", food.id, Thread.currentThread().getName());
        }
        System.out.printf("Water%d released by thread %s%n", water.id, Thread.currentThread().getName());
    }

    public void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Handle exception
        }
    }

    public static void main(String[] args) {
        // Create participants and resources
        Fox foxy = new Fox();
        Fox tails = new Fox();
        Food food1 = new Food(1);
        Food food2 = new Food(2);
        Water water1 = new Water(1);
        Water water2 = new Water(2);

        // Process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);

            // shares resources ==> deadlock
//            service.submit(() -> foxy.eatAndDrink(food1, water1));
//            service.submit(() -> tails.drinkAndEat(food1, water1));

            // each fox own resources
            service.submit(() -> foxy.eatAndDrink(food1, water2));
            service.submit(() -> tails.drinkAndEat(food2, water1));
        } finally {
            if (service != null) service.shutdown();
        }
    }
}