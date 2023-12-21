package ArrayListConcepts;
import java.util.ArrayList;

public class VirtualCapacityArrayList {
    public static void main(String[] args){

        ArrayList<Object> ar = new ArrayList<>();
// by default internally 10 virtual capacity will be available
        System.out.println(ar.size());
        ar.add(100);
        System.out.println(ar.size());
        ar.add(200);
        ar.add(300);
        ar.add(400);
        System.out.println(ar.size());
//        System.out.println(ar.remove(0));
        System.out.println(ar);
    }
}
