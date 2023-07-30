import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(0, 1);
        System.out.println("Add one element: " + myArrayList);

        myArrayList.add(1, 2);
        System.out.println("Add second element: " + myArrayList);

        myArrayList.add(1, 3);
        System.out.println("Add element between elements: " + myArrayList);

        System.out.println("Get element by index 2: " + myArrayList.get(1));

        myArrayList.clear();
        System.out.println("Clear: " + myArrayList);

        System.out.println("Empty: " + myArrayList.isEmpty());
        myArrayList.add(3);
        System.out.println("Add 3. Not empty: " + myArrayList.isEmpty());

        List<Integer> newList = new ArrayList<>();
        newList.add(2);
        newList.add(1);
        myArrayList.addAll(newList);
        System.out.println("Add collection[2,1]: " + myArrayList);

        myArrayList.sort(Comparator.naturalOrder());
        System.out.println("Sort collection: " + myArrayList);

        myArrayList.remove(0);
        System.out.println("Remove element with index \"0\": " + myArrayList);

        myArrayList.remove(1);
        System.out.println("Remove element with index \"1\": " + myArrayList);

        Integer element = 2;
        myArrayList.remove(element);
        System.out.println("Remove element with object \"2\": " + myArrayList);
    }
}
