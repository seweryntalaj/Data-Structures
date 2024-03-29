import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

public class GenericStack<T> {

    private Object[] array;
    private int size;
    private int top;

    public GenericStack(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Stack must be size 1 or higher!");
        }
        this.size = size;
        this.top = -1;
        this.array = new Object[size];
    }

    public T push(T item) throws StackOverflowException {
        if (this.top + 1 == this.size) {
            throw new StackOverflowException("Reached stack size limit!");
        }
        this.array[++this.top] = item;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T pop() throws StackUnderflowException {
        if (top == -1) {
            throw new StackUnderflowException("Stack is empty!");
        }
        Object poppedIdem = array[top--];
        return (T) poppedIdem;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) array[top];
    }

    public int size() {
        return this.size;
    }

    public int spaceTaken() {
        return this.top + 1;
    }

    public int spaceLeft() {
        return this.size - (this.top + 1);
    }

}
