//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1,10);
        lruCache.printOrder();
        lruCache.put(2,20);
        lruCache.printOrder();
        lruCache.put(3,30);
        lruCache.printOrder();
        lruCache.put(4,40);
        lruCache.printOrder();
        lruCache.put(4,100);
        lruCache.printOrder();
        lruCache.put(5,100);
        System.out.println(lruCache.get(2));
        lruCache.printOrder();

    }
}