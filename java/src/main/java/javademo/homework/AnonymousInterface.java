package javademo.homework;

/**
 * @program: forOffer
 * @description:
 * @author: gaorunding
 * @create: 2021-05-31 14:11
 */
public interface AnonymousInterface {
    void run();
}

class AnonymousImpletion {
    public static void main(String[] args) {
        var a = new AnonymousInterface() {

            @Override
            public void run() {

            }
        };
        a.run();
    }
}
