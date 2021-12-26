package leetcode;

public class DoubleList {
    int size;
    Node head;
    Node tail;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirstNode(Node node) {
        Node next = head.next;
        head.next = node;

        node.prev = head;
        node.next = next;
        next.prev = node;

        size++;
    }

    public void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        size--;
    }

    public Node removeLastNode() {
        Node prev = tail.prev;
        if (prev == head) {
            return null;
        }
        removeNode(prev);
        return prev;
    }

    public int getSize() {
        return size;
    }
}
