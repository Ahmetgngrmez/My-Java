import java.util.Arrays;

public class MyQueue<E> {
    private E[] data;
    private int size = 0; // element count
    private int first = 0; // index of front element

    public MyQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        if (isEmpty()) return null;
        return data[first]; // front element
    }

    public E dequeue() {
        if (isEmpty()) return null;
        E x = data[first];
        data[first] = null;
        first = (first + 1) % data.length; // circular shift
        size--;
        return x;
    }

    public void enqueue(E e) {
        ensureCapacity();
        int rear = (first + size) % data.length; // rear index
        data[rear] = e;
        size++;
    }

    private void ensureCapacity() {
        if (size < data.length) return;
        int oldCap = data.length;
        int newCap = oldCap * 2;
        E[] newData = (E[]) new Object[newCap];
        // copy and re-align
        for (int i = 0; i < size; i++) {
            newData[i] = data[(first + i) % oldCap];
        }
        data = newData;
        first = 0; // reset front
        System.out.println("Queue capacity: " + oldCap + " -> " + newCap);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(data[(first + i) % data.length]);
        }
        sb.append("]");
        // full array contents
        return sb.toString() + " and Inner Array: " + Arrays.toString(data); 
    }
}