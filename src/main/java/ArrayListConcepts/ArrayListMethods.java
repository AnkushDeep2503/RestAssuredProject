package ArrayListConcepts;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayListMethods {
    public static void main(String[] args){
        ArrayList<String> ar = new ArrayList<String>(Arrays.asList("Ankush", "Surbhi", "Maa", "Papa", "New Baby"));
        ar.add("Ankush");
        System.out.println(ar);

        ArrayList<String> ar1 = new ArrayList<String>(Arrays.asList("Deep", "Verma"));
        ar1.add("Lil Baby for ArrayList 2");
        System.out.println(ar1);

//      its just like extend method of python for adding one list to another
        ar.addAll(ar1);
        System.out.println(ar);

//        for clearing array -- This will return an empty array
//        ar.clear();
//        System.out.println(ar);

//        for cloning
        ArrayList<String> cloneList = (ArrayList<String>)ar.clone();
        System.out.println(cloneList);

//        Boolean for true or false if the arraylist contains smth or not
        System.out.println(ar.contains("Ankush"));
        System.out.println(ar1.contains("Verma"));
        System.out.println(ar1.contains("My Dog's name"));

//        indexOf
        System.out.println(ar.indexOf("Papa")==3);

        ArrayList<Integer> num = new ArrayList<Integer>(Arrays.asList(1,2, 3,4, 7 , 100, 99));
        System.out.println(num);
        for(int i=0; i<num.size(); i++) {
            System.out.println(num.get(i));
        }

//      remove method
        num.remove(2);
        System.out.println(num);

        num.remove(4);
        System.out.println(num);

//        removeIf method for array list
        ArrayList<Integer> newNum = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 3, 5, 7, 9));
        System.out.println(newNum);
        newNum.removeIf(n -> n%2 != 0);
        System.out.println(newNum);

//        retainAll method

        ArrayList<String> namesList = new ArrayList<String>(Arrays.asList("Python", "Java", "SQL", "API", "Github", "Python"));
        System.out.println(namesList);
        namesList.retainAll(Collections.singleton("Python"));
        System.out.println(namesList);

//        creating a sublist from arraylist
        ArrayList<Integer> newSubList = new ArrayList<Integer>(newNum.subList(1, 4));
        System.out.println(newSubList);

//        converting arraylist to an array
        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("Ankush", "Amit", "Gaurav", "Mayur", "Rituraj"));
        Object arr[] = list1.toArray();
        System.out.println(Arrays.toString(arr));

        for(Object o: arr){
            System.out.println((String)o);
        }


    }


}
