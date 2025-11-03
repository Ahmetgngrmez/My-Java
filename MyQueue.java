import java.util.Arrays;

public class MyQueue<E> {
    private E[] data;
    private int size = 0;
    private int first = 0;

    public MyQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        if (isEmpty()) return null;
        return data[first];
    }

    public E dequeue() {
        if (isEmpty()) return null;
        E x = data[first];
        data[first] = null;
        first = (first + 1) % data.length;
        size--;
        return x;
    }

    public void enqueue(E e) {
        ensureCapacity();
        int rear = (first + size) % data.length;
        data[rear] = e;
        size++;
    }

    private void ensureCapacity() {
        if (size < data.length) return;
        int oldCap = data.length;
        int newCap = oldCap * 2;
        E[] newData = (E[]) new Object[newCap];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(first + i) % oldCap];
        }
        data = newData;
        first = 0;
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
        return sb.toString() + " and Inner Array: " + Arrays.toString(data);
    }
}
