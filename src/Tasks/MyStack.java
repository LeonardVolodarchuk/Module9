package Tasks;

public class MyStack {
    private Object[] stackArray;
    private int top;

    public MyStack() {
        stackArray = new Object[10];
        top = -1;
    }

    public void push(Object value) {
        if (top == stackArray.length - 1) {

            Object[] newArray = new Object[stackArray.length * 2];
            System.arraycopy(stackArray, 0, newArray, 0, stackArray.length);
            stackArray = newArray;
        }
        top++;
        stackArray[top] = value;
    }

    public void remove(int index) {
        if (index >= 0 && index <= top) {
            for (int i = index; i < top; i++) {
                stackArray[i] = stackArray[i + 1];
            }
            stackArray[top] = null;
            top--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void clear() {
        for (int i = 0; i <= top; i++) {
            stackArray[i] = null;
        }
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public Object peek() {
        if (top == -1) {
            throw new IllegalStateException();
        }
        return stackArray[top];
    }

    public Object pop() {
        if (top == -1) {
            throw new IllegalStateException();
        }

        Object value = stackArray[top];
        stackArray[top] = null;
        top--;
        return value;
    }
}
