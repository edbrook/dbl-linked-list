package uk.co.dekoorb.java;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void insertObject(T value) {
        addObject(value, 0);
    }

    public void addObject(T value) {
        addObject(value, size);
    }

    public void addObject(T value, int pos) {
        // Bound check
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException(
                    String.format("Inserting into LinkedList at invalid index (%d). "
                            + "Valid index range is [min:0 max:%d]", pos, size));
        }

        // Create the new node with given value;
        Node<T> node = new Node<>(value);

        // If the list is empty...
        if (size == 0) {
            head = tail = node;
        } else {
            // Inserting at the beginning of the list
            if (pos == 0) {
                node.setNext(head);
                head.setPrev(node);
                head = node;
            } else {
                // Inserting anywhere else in the list
                // Get a pointer to the node before the insertion point
                Node<T> ptr = head;
                for (int i = 0; i < pos-1; i++) {
                    ptr = ptr.getNext();
                }
                node.setPrev(ptr);
                node.setNext(ptr.getNext());
                ptr.setNext(node);
                if (ptr == tail) {
                    tail = node;
                }
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList(").append(size).append("){");
        Node<T> ptr = head;
        while (ptr != null) {
            if (ptr != head) {
                sb.append(", ");
            }
            sb.append(ptr);
            ptr = ptr.getNext();
        }
        sb.append("}");
        return sb.toString();
    }
}