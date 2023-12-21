package ArrayListConcepts;

import java.util.ArrayList;

public class GenericArrayList {
    public static void main(String[] args){
        ArrayList<Integer> marksList = new ArrayList<Integer>();
        marksList.add(200);

        ArrayList<Double> marksPercentage = new ArrayList<Double>();
        marksPercentage.add(22.5);
        marksPercentage.add(85.9);

        ArrayList<String> studentName = new ArrayList<String>();
        studentName.add("Ankush");
        studentName.add("Surbhi");

        System.out.println(marksList);
        System.out.println(marksPercentage);
        System.out.println(studentName);

    }

}
