package Tasks;

public class MyQueue {
    private Object[] elements;
    private int size;
    private int head;
    private int tail;

    public MyQueue() {
        elements = new Object[10];
        size = 0;
        head = 0;
        tail = 0;
    }

    public void add(Object value) {
        if (size == elements.length) {
            resizeArray();
        }
        elements[tail] = value;
        tail = (tail + 1) % elements.length;
        size++;
    }

    private void resizeArray() {
        Object[] newArray = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[(head + i) % elements.length];
        }
        elements = newArray;
        head = 0;
        tail = size;
    }

    public void clear() {
        elements = new Object[10];
        size = 0;
        head = 0;
        tail = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return elements[head];
    }

    public Object poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        Object value = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return value;
    }
}
