package singleton;

public class Engine {
    

    private Engine() {
        
    }

    private static class EngineHolder {
        private static final Engine INSTANCE = new Engine();
    }

    public static Engine getInstance() {
        return EngineHolder.INSTANCE;
    }

    public void start() {
        System.out.println("Engine started.");
    }
}
