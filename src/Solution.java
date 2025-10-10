class Singleton {
    private static Singleton instance;

    public String str;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {

        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class Solution {
    public  static void main(String[] args) {
        Singleton singleton = Singleton.getSingleInstance();

        String input = "hello world";
        singleton.str = input;

        System.out.println("Hello I am a singleton! Let me say " + singleton.str + " to you");
        Singleton anotherSingleton = Singleton.getSingleInstance();
        System.out.println(anotherSingleton == singleton);

    }

}