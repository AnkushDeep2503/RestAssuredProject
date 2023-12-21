package ArrayListConcepts;
import java.util.ArrayList;

public class ArrayListJava {
    public static void main(String[] args){

        //default class
        //dynamic array
        //how to create

        ArrayList<Object> ar = new ArrayList<Object>();
        ar.add(100);
        ar.add(200);
        ar.add("Ankush");
        ar.add(2.5);
        ar.add('a');

//        add method is to add the value and get method is to get the value

        System.out.println(ar);
        System.out.println(ar.get(4));
        System.out.println(ar.size());
        System.out.println("The Lowest Index is: "+ ar.get(0));
        System.out.println("The Highest Index is: "+ (ar.size()-1));

    }
}
