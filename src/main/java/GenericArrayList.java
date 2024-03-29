public class GenericArrayList {

    private int size;
    private Object[] data;

    public GenericArrayList() {
        data = new Object[1];
        size = 0;
    }

    public GenericArrayList(int capacity) {
        if (capacity < 1) {
            capacity = 1;
        }
        data = new Object[capacity];
        size = 0;
    }

    public void add(Object element) {
        updateCapacity(size + 1);
        data[size++] = element;
    }

    /**
     * If index is higher than length of list then object is appended
     */
    public void insert(int index, Object element) {
        updateCapacity(size + 1);

        if (index < 0) {
            throw new IllegalArgumentException("Index must be equal to or higher than 0!");
        }

        Object[] newArray = new Object[size + 1];

        if (index > size) {
            index = data.length;
            newArray = new Object[size + 2];
        }

        System.arraycopy(data, 0, newArray, 0, index);

        if (size - index >= 0) System.arraycopy(data, index, newArray, index + 1, size - index);
        newArray[index] = element;
        data = newArray;
    }


    public void remove(int index) {
        checkIfInBounds(index);
        Object[] newArray = new Object[data.length - 1];
        if (index > 0) {

            System.arraycopy(data, 0, newArray, 0, index);

            if (newArray.length - index >= 0)
                System.arraycopy(data, index + 1, newArray, index, newArray.length - index);
        } else {

            if (data.length - 1 >= 0) System.arraycopy(data, 1, newArray, 0, data.length - 1);
        }
        data = newArray;
        size = newArray.length;
    }

    private void checkIfInBounds(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index + " size: " + size);

    }

    private void updateCapacity(int minimumCapacity) {
        int previousCapacity = data.length;

        if (minimumCapacity > previousCapacity) {
            int newCapacity = (previousCapacity * 2);
            if (newCapacity < minimumCapacity)
                newCapacity = minimumCapacity;

            Object[] newData = new Object[minimumCapacity];

            System.arraycopy(data, 0, newData, 0, previousCapacity);
            data = newData;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (Object object : data) {
            output.append(object.toString()).append(" ");
        }
        return output.toString().trim();
    }

}