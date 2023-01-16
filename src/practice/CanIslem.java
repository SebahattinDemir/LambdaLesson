package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CanIslem {

    //Add them into a list
//Check if all average scores are less than 98
//Check if all course names contain "Day" word
//Check if any number of students is 154
//Check if any season is Winter
//Check if no number of students is 100
//Sort the elements in natural order according to the average score
//Sort the elements in reverse order according to the number of students
//Sort the elements in reverse order according to the course name

    public static void main(String[] args) {

        CanPojo can1 = new CanPojo("Summer","Java Day",99,6071);
        CanPojo can2 = new CanPojo("winter","Github Day",75,4528);
        CanPojo can3 = new CanPojo("Autumn","Lambda Day",100,4589);
        CanPojo can4 = new CanPojo("Spring","SQLDay",50,154);
        List<CanPojo> list = new ArrayList<>(Arrays.asList(can1,can2,can3,can4));
        //Check if all average scores are less than 98
        boolean soru1 = list.stream().allMatch(w->w.getAverageScore()<98);
        System.out.println(soru1);
        //Check if all course names contain "Day" word
        boolean soru2 = list.stream().allMatch(w->w.getCourseName().contains("Day"));
        System.out.println(soru2);
        //Check if any number of students is 154
        boolean soru3 = list.stream().anyMatch(w->w.getNumberOfStudents()==154);
        System.out.println(soru3);
        //Check if any season is Winter
        boolean soru4 = list.stream().anyMatch(w->w.getSeason()=="winter");
        System.out.println(soru4);
        //Check if no number of students is 100
        boolean soru5 = list.stream().noneMatch(w->w.getNumberOfStudents()==100);
        System.out.println(soru5);
        //Sort the elements in natural order according to the average score
        list.stream().sorted(Comparator.comparing(CanPojo::getAverageScore)).forEach(System.out::println);
        System.out.println();
        //Sort the elements in reverse order according to the number of students
        list.stream().sorted(Comparator.comparing(CanPojo::getNumberOfStudents).reversed()).forEach(System.out::println);
        System.out.println();
        //Sort the elements in reverse order according to the course name
        list.stream().sorted(Comparator.comparing(CanPojo::getCourseName).reversed()).forEach(System.out::println);
    }
}
