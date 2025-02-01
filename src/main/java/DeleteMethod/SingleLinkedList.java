package DeleteMethod;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    //create a linked list
    public Node createLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    //insert into linked list
    //1.If the link doesnt exist
    //2. inserting at the beginning
    //3. inserting at the ending
    //4.inserting anywhere

    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {                 //doesnt exist
            createLinkedList(nodeValue);
            return;
        } else if (location == 0) {         //insert at beginning
            node.next = head;
            head = node;
        } else if (location >= size) {      //insert at end
            tail.next = node;
            node.next= null;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = node;
            node.next = nextNode;
        }
        size++;
    }

    //Deleting a Node from the linked list
    //0. if the link doesn't exist
    //1. delete at the beginning
    //2. delete at the ending
    //3. delete anywhere

    public void deleteFromLinkedList(int location) {
        //link doesn't exist
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        //delete at beginning
        if (location == 0) {
            head = head.next;
            size--;
        //delete at end
        } else if (location >= size - 1) {
            Node tempNode = head;
            for (int i = 0; i < size - 2; i++) { //traverse to second last node
                tempNode = tempNode.next;
            }
            tempNode.next = null; //remove last node and update tail to be new last node
            tail = tempNode;
            size --;
        //delete in the middle
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) { //find node before one to delete
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next; //removes node to be deleted
            size--;
        }



    }

    // Traverse a Linked List
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if ( i != size -1) {
                    System.out.print(" -> ");
                }
                tempNode=tempNode.next;
            }
            System.out.print("\n");
        }
    }
    //search for node
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found.");
        return false;
    }
}
