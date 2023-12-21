package ArrayListConcepts;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIteration {
    public static void main(String[]args){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ankush");
        names.add("Surbhi");
        names.add("Mom");
        names.add("Dad");
        names.add("New Kid");


//        typical for loop
        for(int i=0; i<names.size(); i++) {
            System.out.println(names.get(i));
        }

            System.out.println("______________________________________");

            // for each loop
            for(String s: names)
            {
                System.out.println(s);
            }
        System.out.println("______________________________________");

//            Iterating using Lambda function
        names.stream().forEach(ele -> System.out.println(ele));

        System.out.println("______________________________________");

//        Iterator interface is using for collection
        Iterator<String> it = names.iterator();
        while(it.hasNext()){
            System.out.println("iterator way: " + it.next());
        }
        }
    }

