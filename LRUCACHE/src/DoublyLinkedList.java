public class DoublyLinkedList {

    Node tail;
    Node head;


    DoublyLinkedList() {
        tail = new Node();
        head = new Node();
        tail.prev = head;
        head.next = tail;
    }


    public void insertAfterHead(Node node){

        Node firstNode = head.next;
        node.prev = head;
        node.next = firstNode;
        firstNode.prev = node;
        head.next = node;
    }

    public void deletionOfNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = node.next;
        nextNode.prev = node.prev;

    }

}
