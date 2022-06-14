import java.io.*;

public class MergeTwoSortedLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) throws IOException {

        SinglyLinkedList result = new SinglyLinkedList();
        int temp = 0;

        while(head1 != null && head2 != null) {

            if(head1.data < head2.data) {
                temp = head1.data;
                head1 = head1.next;
            } else {
                temp = head2.data;
                head2 = head2.next;
            }
            result.insertNode(temp);
        }

        if(head1 != null)
            addRemainder(head1, result);

        if(head2 != null)
            addRemainder(head2, result);

        printSLListFromNode(result.head);
        return result.head;
    }

    public static void addRemainder(SinglyLinkedListNode node, SinglyLinkedList result) {
        while(node != null) {
            result.insertNode(node.data);
            node = node.next;
        }
    }

    public static void printSLListFromNode(SinglyLinkedListNode node) throws IOException {
        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(sw);
        printSinglyLinkedList(node, "->", bw);
        bw.flush();
        StringBuffer sb = sw.getBuffer();
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        SinglyLinkedList llist1 = new SinglyLinkedList();
        llist1.insertNode(1);
        llist1.insertNode(8);

        SinglyLinkedList llist2 = new SinglyLinkedList();
        llist2.insertNode(2);
        llist2.insertNode(9);
        llist2.insertNode(10);
        SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

    }


}


