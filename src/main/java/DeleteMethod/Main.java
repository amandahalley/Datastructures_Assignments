package DeleteMethod;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.insertInLinkedList(1,8);
        sll.insertInLinkedList(2,1);
        sll.insertInLinkedList(3,3);
        sll.insertInLinkedList(4,4);

        System.out.println("Complete List: ");
        sll.traverseLinkedList();
        sll.searchNode(4);


        //delete method
        sll.deleteFromLinkedList(0);
        System.out.print("Deleting index 0: ");
        sll.traverseLinkedList();

        sll.deleteFromLinkedList(2);
        System.out.print("Deleting index 2: ");
        sll.traverseLinkedList();

        sll.deleteFromLinkedList(1);
        System.out.print("Deleting index 1: ");
        sll.traverseLinkedList();

        System.out.println("After all deletions: ");
        sll.traverseLinkedList();
    }
}
