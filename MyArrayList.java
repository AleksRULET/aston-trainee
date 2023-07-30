import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
        size = 0;
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        array[size] = element;
        size++;
    }

    public void add(int index, E element) {
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public boolean addAll(Collection<? extends E> c) {
        int numNew = c.size();
        ensureCapacity(size + numNew);
        Object[] srcArray = c.toArray();
        System.arraycopy(srcArray, 0, array, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) array[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = (E) array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null;
        return oldValue;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(array[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public void sort(Comparator<? super E> c) {
        quickSort(0, size - 1, c);
    }

    private void quickSort(int low, int high, Comparator<? super E> c) {
        if (low < high) {
            int pi = partition(low, high, c);

            quickSort(low, pi - 1, c);
            quickSort(pi + 1, high, c);
        }
    }

    private int partition(int low, int high, Comparator<? super E> c) {
        E pivot = (E) array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (c.compare((E) array[j], pivot) < 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - array.length > 0) {
            int oldCapacity = array.length;
            int newCapacity = (int) ((oldCapacity * 1.5) + 1);
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; ; i++) {
            sb.append(array[i]);
            if (i == size - 1) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }
}
