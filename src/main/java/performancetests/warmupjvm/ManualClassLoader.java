package performancetests.warmupjvm;

public class ManualClassLoader {

    public static void load() {
        for (int i = 0; i < 100000; i++) {
            Dummy dummy = new Dummy();
            dummy.m();
        }
    }
}
