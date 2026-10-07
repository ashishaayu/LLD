import java.util.HashMap;
import java.util.Map;

public class LRUCache implements Cache{

    Map<Integer, Node> entity = new HashMap<>();
    DoublyLinkedList order;
    int capacity;

    LRUCache(int capacity) {
        this.order = new DoublyLinkedList();
        this.capacity = capacity;
    }

    @Override
    public int get(int key) {

        Node node = entity.get(key);
        if(node==null)
            return -1;

        order.deletionOfNode(node);
        order.insertAfterHead(node);

        return node.value;
    }

    @Override
    public void put(int key, int value) {

        Node node = entity.get(key);
        if(node == null){

            if(entity.size()==capacity){
                node = order.tail.prev;
                entity.remove(node);
                order.deletionOfNode(node);
            }

            node = new Node();
            node.key = key;
            node.value = value;
            order.insertAfterHead(node);

        }
        else {
            node.value=value;
            order.deletionOfNode(node);
            order.insertAfterHead(node);
        }
        entity.put(key,node);
    }

    public void printOrder() {
        Node current = order.head.next;

        System.out.print("MRU -> ");
        while (current != order.tail) {
            System.out.print(
                    "[" + current.key + "=" + current.value + "] -> "
            );
            current = current.next;
        }
        System.out.println("LRU");
    }


}
