public class Queue<T> {
    private Node<T> front, rear;

    // Node inner class
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }

    // Method to move an item to the back of the queue
    public void moveToBack(T item) {
        if (front == null || front.data.equals(item)) {
            return; // Item not in the queue or already at front
        }

        Node<T> current = front, prev = null;
        while (current != null && !current.data.equals(item)) {
            prev = current;
            current = current.next;
        }

        if (current != null && current.data.equals(item)) {
            if (current.next == null) {
                return; // Item already at the back
            }
            // Remove current node and add it to the back
            prev.next = current.next;
            rear.next = current;
            current.next = null;
            rear = current;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = front;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}
