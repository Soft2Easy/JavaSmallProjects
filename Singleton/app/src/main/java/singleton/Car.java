package singleton;

public class Car {
    private final Engine engine;

    private Car() {
        this.engine = Engine.getInstance();
    }

    private static class CarHolder {
        private static final Car INSTANCE = new Car();
    }

    public static Car getInstance() {
        return CarHolder.INSTANCE;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving.");
    }
}
