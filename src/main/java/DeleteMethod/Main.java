package DeleteMethod;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.insertInLinkedList(1,8);
        sll.insertInLinkedList(2,1);
        sll.insertInLinkedList(3,3);
        sll.insertInLinkedList(4,4);

        sll.traverseLinkedList();
        sll.searchNode(4);
    }
}
