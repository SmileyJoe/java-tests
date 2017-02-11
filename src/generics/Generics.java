import java.util.ArrayList;

public class Generics {
	
	public static void main(String[] args){
        ArrayList<Integer> array = populateArray(Integer.class);
        System.out.println("Array Size: " + array.size());

        for(int i = 0; i < array.size(); i++){
            System.out.println("Item " + i + ": " + ((Object) array.get(i)).toString());
        }
    }

    private static <T> ArrayList<T> populateArray(Class<T> classType){
        ArrayList<T> array = new ArrayList();
        Integer number = new Integer(1234);
        array.add((T) "Cody");
        array.add((T) number);

        return array;
    }
}