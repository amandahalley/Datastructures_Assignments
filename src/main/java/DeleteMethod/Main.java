package DeleteMethod;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.insertInLinkedList(1,8);
        sll.insertInLinkedList(2,1);
        sll.insertInLinkedList(3,3);
        sll.insertInLinkedList(4,4);

        System.out.println("Complete List: "); //1 -> 2 -> 3 -> 4
        sll.traverseLinkedList();
        sll.searchNode(4); //Found the node: 4 at location: 3


        //delete method
        sll.deleteFromLinkedList(0);
        System.out.print("Deleting index 0: "); //2 -> 3 -> 4
        sll.traverseLinkedList();

        sll.deleteFromLinkedList(2);
        System.out.print("Deleting index 2: "); //2 -> 3
        sll.traverseLinkedList();

        sll.deleteFromLinkedList(1);
        System.out.print("Deleting index 1: "); //2
        sll.traverseLinkedList();

        System.out.println("\nList after all deletions: "); //2
        sll.traverseLinkedList();
    }
}
