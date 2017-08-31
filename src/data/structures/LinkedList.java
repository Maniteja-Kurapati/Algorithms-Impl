package data.structures;

public class LinkedList<T> {
    private Node head;

    private class Node {
        private T data;
        private Node next;
        private Node previous;
    }

    public void add(final T t) {
        if (head == null) {
            head = new Node();
            head.data = t;
            head.previous = null;
            head.next = null;
        } else {
            Node node = new Node();
            node.data = t;
            node.next = head;
            head.previous = node;
            node.previous = null;
            head = node;
        }
    }

    public boolean delete(final T t) {
        Node toBeDeleted = getNodeWithElement(t);
        if (toBeDeleted != null) {
            toBeDeleted.previous.next = toBeDeleted.next;
            toBeDeleted.next.previous = toBeDeleted.previous;
            toBeDeleted = null;
            return true;
        }
        return false;
    }

    public int indexOf(final T t) {
        int index = 0;
        if (head != null) {
            Node current = head;
            while (current != null) {
                if (current.data == t) {
                    return index;
                }
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    public boolean contains(final T t) {
        if (indexOf(t) >= 0) {
            return true;
        }
        return false;
    }

    public void printList() {
        if (head != null) {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + ", ");
                current = current.next;
            }
            System.out.println();
        }
    }

    private Node getNodeWithElement(final T t) {
        if (head != null) {
            Node current = head;
            while (current != null) {
                if (current.data == t) {
                    return current;
                }
                current = current.next;
            }
        }
        return null;
    }

}
