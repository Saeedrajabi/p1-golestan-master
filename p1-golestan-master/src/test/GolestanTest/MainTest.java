package ir.ac.kntu.GolestanTest;

import ir.ac.kntu.*;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class MainTest {
    @Test
    public void testRecords1() throws Exception{
        /**creating userpass class
         *
         */
        UsernamesPasswords userpass = new UsernamesPasswords();

        /**creating student object
         *
         */
        ArrayList<Student> studentsRF = new ArrayList<Student>();

        //creating teacher
        ArrayList<Teacher> teachersRF = new ArrayList<Teacher>();

        //creating course that you want to choose
        ArrayList<CourseGroup> course = new ArrayList<CourseGroup>();

        //create an arraylist that formed by CourseGroup.
        //it shows all courses you chose and was acceptable

        //create a hashmap that save all information of your passed courses.
        HashMap<CourseGroup, Double> passedSaeed = new HashMap<CourseGroup, Double>();

        //create an arraylist that save just String of your passed courses.
        ArrayList<String> passedlist = new ArrayList<String>();

        //create prerequisites list(پیشنیاز ها)
        ArrayList<String> prerequisites = new ArrayList<String>();

        //creating a file
        File outputtxt = new File("out.txt");

        //creating writer class
        FileWriter fw = new FileWriter(outputtxt);

        //creating a print write class
        PrintWriter pw = new PrintWriter(fw);

        //creating Hashmap that key is based on Date Class and value is based on java,sql.Time
        //reference for java.sql.Time is https://www.geeksforgeeks.org/time-class-in-java-sql/
        HashMap<Date, Time> dateTime = new HashMap<>();
        //Monday created
        Date doshanbe = new Date(3);
        //putting in Hashmap dateTime
        //it is for planning class on this time
        dateTime.put(doshanbe, Time.valueOf("13:30:00"));

        //Define course Madar1.
        //The admin wants to make the Madar1 lesson a prerequisite for the RF circuits lesson.
        CourseGroup madar1 = new CourseGroup(111, "Madar1", prerequisites, dateTime, 111, "Madar1", studentsRF, 10, teachersRF, 3991);
        prerequisites.add("Madar1");

        //Print Madar1 all information.
        //System.out.println("Madar1 info is:" + madar1);
        pw.write(String.valueOf("Course madar1 submitted successfully and info is :       " + madar1));
        //System.out.println("++++++++++++++++++++");

        //The admin wants to make the Madar1 lesson a prerequisite for the RF circuits lesson.
        // Create RF Circuits on Mondays at 13:30 with CourseNum:222 and CourseGroupNum:222 and courseGroupName: Madarmokhaberatiha with 10 person capacity.
        //RF Circuits will present in semester 4001.
        CourseGroup madarMokhabreti = new CourseGroup(222, "Madarmokhaberati", prerequisites, dateTime, 222, "Madarmokhaberatiha", studentsRF, 10, teachersRF, 4001);
        //printing and save madarMokhaberati informations.
        //System.out.println("Madar Mokhaberati info is:" + madarMokhabreti);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("Madar Mokhaberati info is:" + madarMokhabreti));
        //System.out.println("pishniaz:" + madarMokhabreti.getPrerequisites());
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("pishniaz:" + madarMokhabreti.getPrerequisites()));

        //Making Student Saeed
        //System.out.println("++++++++++++++++++");
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("Making Student Saeed"));

        /*Create Saeed as a Student with password "qweA@sdqwe" that has acceptable by "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"
        we used that regex in HW2-NameValidation.
        It is assumed that the student can choose 20 units
        */
        Student studentSaeed = new Student("Saeed", "Rajabi", 9726763, "qweA@sdqwe", 20, passedSaeed, new ArrayList<CourseGroup>());
        //print Saeed's information before Adding any lesson
        //System.out.println("Saeed's information before Adding any lesson :" + studentSaeed);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("Saeed's information before Adding any lesson :" + studentSaeed));
        userpass.addUserPass(studentSaeed);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("User Pass of  " + studentSaeed.getFirstName() + " " + studentSaeed.getLastName() + "  is:    " + studentSaeed.getStudentNum() + " : " + userpass.getUserPassStudents().get(studentSaeed.getStudentNum())));

        //Saeed passed the course with a score of 16.5
        //score is acceptable so add it to passed courses.
        passedSaeed.put(madar1, 16.5);
        passedlist.add(madar1.getCourseName());
        //Adding studentSaeed to madarMokhaberati
        //capacity has to decrease one with
        //System.out.println(studentSaeed.addLessons(passedlist, madarMokhabreti, currentChoose,studentSaeed));
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("Saeed Adding MadarMokhaberati log:" + studentSaeed.addLessons(passedlist, madarMokhabreti, studentSaeed.getCurrentChoose(), studentSaeed)));
        //System.out.println(madarMokhabreti);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("MadarMokhaberati's information after Adding student Saeed :" + madarMokhabreti));

        //The admin wants to make no lesson lesson a prerequisite for the AP lesson.
        // Create AP on Tuesdays at 13:30 with CourseNum:444 and CourseGroupNum:3 and courseGroupName: AP with 20 person capacity.
        //AP will present in semester 4001.
        ArrayList<String> prerequisitesAP = new ArrayList<String>();
        HashMap<Date, Time> dateTime1 = new HashMap<>();
        Date seshanbe = new Date(4);
        dateTime1.put(seshanbe, Time.valueOf("13:30:00"));
        ArrayList<Student> studentsAP = new ArrayList<Student>();
        //creating teacher
        ArrayList<Teacher> teachersAP = new ArrayList<Teacher>();
        CourseGroup AP = new CourseGroup(444, "AP", prerequisitesAP, dateTime1, 3, "AP", studentsAP, 20, teachersAP, 4001);

        //AP's information is :
        //System.out.println("AP info is:" + AP);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("AP submitted with info:   " + AP));

        //prerequisites for AP is:
        //System.out.println("pishniaz haye AP:" + AP.getPrerequisites());
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("pishniaz haye AP:" + AP.getPrerequisites()));
        //System.out.println(studentSaeed.addLessons(passedlist, AP, currentChoose,studentSaeed));
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("AP log while adding Student Saeed to it:" + studentSaeed.addLessons(passedlist, AP, new ArrayList<CourseGroup>(), studentSaeed)));
        //System.out.println(studentSaeed);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("Saeed info after adding to AP:    " + studentSaeed));
        //System.out.println("After adding student Saeed to AP:" + AP);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("AP info after adding Saeed:    " + studentSaeed));


        System.out.println("define Student Reza");
        //create an arraylist that formed by CourseGroup.
        //it shows all courses you chose and was acceptable
        ArrayList<CourseGroup> currentChooseReza = new ArrayList<CourseGroup>();

        //create a hashmap that save all information of your passed courses.
        HashMap<CourseGroup, Double> passedReza = new HashMap<CourseGroup, Double>();

        //create an arraylist that save just String of your passed courses.
        ArrayList<String> passedlistReza = new ArrayList<String>();

        Student studentReza = new Student("Reza", "Khatibi", 9826763, "qweA@sdqwe", 20, passedReza, currentChooseReza);
        System.out.println(studentReza);
        System.out.println("Reza's information before Adding any lesson :" + studentReza);
        userpass.addUserPass(studentReza);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("User Pass of  " + studentReza.getFirstName() + " " + studentReza.getLastName() + "  is:    " + studentReza.getStudentNum() + " : " + userpass.getUserPassStudents().get(studentReza.getStudentNum())));
        //System.out.println(studentReza.addLessons(passedlist, AP, currentChoose1,studentReza));
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf(studentReza.getFirstName() + " : " + studentReza.getLastName() + "Adding AP log:" + studentReza.addLessons(passedlistReza, AP, currentChooseReza, studentReza)));
        System.out.println("AP info after adding reza is:" + AP);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("AP info after adding reza is:" + AP));


        System.out.println("All Passwords are :");
        System.out.println(userpass.getUserPassStudents());
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("All Passwords are : " + userpass.getUserPassStudents()));
        pw.close();
        int actual = AP.getCapacity();
        assertEquals(18,actual,0.000001);
    }
    @Test
    public void testRecords2() throws Exception{
        /**creating userpass class
         *
         */
        UsernamesPasswords userpass = new UsernamesPasswords();

        /**creating student object
         *
         */
        ArrayList<Student> students = new ArrayList<Student>();

        //creating teacher
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();

        //creating course that you want to choose
        ArrayList<CourseGroup> course = new ArrayList<CourseGroup>();

        //create an arraylist that formed by CourseGroup.
        //it shows all courses you chose and was acceptable
        ArrayList<CourseGroup> currentChoose = new ArrayList<CourseGroup>();

        //create a hashmap that save all information of your passed courses.
        HashMap<CourseGroup, Double> passed = new HashMap<CourseGroup, Double>();

        //create an arraylist that save just String of your passed courses.
        ArrayList<String> passedlist = new ArrayList<String>();

        //create prerequisites list(پیشنیاز ها)
        ArrayList<String> prerequisites = new ArrayList<String>();

        //creating a file
        File outputtxt = new File("out.txt");

        //creating writer class
        FileWriter fw = new FileWriter(outputtxt);

        //creating a print write class
        PrintWriter pw = new PrintWriter(fw);

        //creating Hashmap that key is based on Date Class and value is based on java,sql.Time
        //reference for java.sql.Time is https://www.geeksforgeeks.org/time-class-in-java-sql/
        HashMap<Date, Time> dateTime = new HashMap<>();
        //Monday created
        Date doshanbe = new Date(3);
        //putting in Hashmap dateTime
        //it is for planning class on this time
        dateTime.put(doshanbe, Time.valueOf("13:30:00"));

        //Define course Madar1.
        //The admin wants to make the Madar1 lesson a prerequisite for the RF circuits lesson.
        CourseGroup madar1 = new CourseGroup(111, "Madar1", prerequisites, dateTime, 111, "Madar1", students, 10, teachers, 3991);
        prerequisites.add("Madar1");

        //Print Madar1 all information.
        System.out.println("Madar1 info is:" + madar1);
        pw.write(String.valueOf("Course madar1 submitted successfully and info is :       " + madar1));
        System.out.println("++++++++++++++++++++");

        //The admin wants to make the Madar1 lesson a prerequisite for the RF circuits lesson.
        // Create RF Circuits on Mondays at 13:30 with CourseNum:222 and CourseGroupNum:222 and courseGroupName: Madarmokhaberatiha with 10 person capacity.
        //RF Circuits will present in semester 4001.
        CourseGroup madarMokhabreti = new CourseGroup(222, "Madarmokhaberati", prerequisites, dateTime, 222, "Madarmokhaberatiha", students, 10, teachers, 4001);
        //printing and save madarMokhaberati informations.
        System.out.println("Madar Mokhaberati info is:" + madarMokhabreti);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("Madar Mokhaberati info is:" + madarMokhabreti));
        System.out.println("pishniaz:" + madarMokhabreti.getPrerequisites());
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("pishniaz:" + madarMokhabreti.getPrerequisites()));

        //Making Student Saeed
        System.out.println("++++++++++++++++++");
        System.out.println("Making Student Saeed");

        /*Create Saeed as a Student with password "qweA@sdqwe" that has acceptable by "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"
        we used that regex in HW2-NameValidation.
        It is assumed that the student can choose 20 units
        */
        Student studentSaeed = new Student("Saeed", "Rajabi", 9726763, "qweA@sdqwe", 20, passed, currentChoose);
        //print Saeed's information before Adding any lesson
        System.out.println("Saeed's information before Adding any lesson :" + studentSaeed);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("Saeed's information before Adding any lesson :" + studentSaeed));
        userpass.addUserPass(studentSaeed);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("User Pass of  " + studentSaeed.getFirstName() + " " + studentSaeed.getLastName() + "  is:    " + studentSaeed.getStudentNum() + " : " + userpass.getUserPassStudents().get(studentSaeed.getStudentNum())));

        //Saeed passed the course with a score of 16.5
        //score is acceptable so add it to passed courses.
        passed.put(madar1, 16.5);
        passedlist.add(madar1.getCourseName());

        //here is place that want to add Student to course.
        System.out.println("Add lesson");
        //Case 1 is:AP overlapped timing with madarmokhaberati
        //Adding studentSaeed to madarMokhaberati
        //capacity has to decrease one with
        //System.out.println(studentSaeed.addLessons(passedlist, madarMokhabreti, currentChoose,studentSaeed));
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("Saeed Adding MadarMokhaberati log:" + studentSaeed.addLessons(passedlist, madarMokhabreti, currentChoose, studentSaeed)));
        System.out.println(madarMokhabreti);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("MadarMokhaberati's information after Adding student Saeed :" + madarMokhabreti));

        //The admin wants to make no lesson lesson a prerequisite for the AP lesson.
        // Create AP on Tuesdays at 13:30 with CourseNum:444 and CourseGroupNum:3 and courseGroupName: AP with 20 person capacity.
        //AP will present in semester 4001.
        ArrayList<String> prerequisitesAP_overlap = new ArrayList<String>();
        dateTime.put(doshanbe, Time.valueOf("13:30:00"));
        ArrayList<Student> studentsAP = new ArrayList<Student>();
        CourseGroup AP_overlap = new CourseGroup(444, "AP", prerequisitesAP_overlap, dateTime, 3, "APOverlap", studentsAP, 20, teachers, 4001);

        //AP's information is :
        System.out.println("AP info is:" + AP_overlap);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("AP submitted with info:   " + AP_overlap));

        //prerequisites for AP is:
        System.out.println("pishniaz haye AP:" + AP_overlap.getPrerequisites());
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("pishniaz haye AP:" + AP_overlap.getPrerequisites()));
        //System.out.println(studentSaeed.addLessons(passedlist, AP, currentChoose,studentSaeed));
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("AP log while adding Student Saeed to it:" + studentSaeed.addLessons(passedlist, AP_overlap, currentChoose, studentSaeed)));
        System.out.println(studentSaeed);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("Saeed info after adding to AP:    " + studentSaeed));
        pw.write("\n");
        pw.write("\n");
        System.out.println("define Student Reza");
        ArrayList<CourseGroup> currentChooseReza = new ArrayList<CourseGroup>();

        //create a hashmap that save all information of your passed courses.
        HashMap<CourseGroup, Double> passedReza = new HashMap<CourseGroup, Double>();

        //create an arraylist that save just String of your passed courses.
        ArrayList<String> passedlistReza = new ArrayList<String>();
        Student studentReza = new Student("Reza", "Khatibi", 9826763, "qweA@sdqwe", 20, passedReza, currentChooseReza);
        System.out.println(studentReza);
        System.out.println("Reza's information before Adding any lesson :" + studentReza);
        userpass.addUserPass(studentReza);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("User Pass of  " + studentReza.getFirstName() + " " + studentReza.getLastName() + "  is:    " + studentReza.getStudentNum() + " : " + userpass.getUserPassStudents().get(studentReza.getStudentNum())));
        //System.out.println(studentReza.addLessons(passedlist, AP, currentChoose1,studentReza));
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf(studentReza.getFirstName() + " : " + studentReza.getLastName() + "Adding AP log:" + studentReza.addLessons(passedlistReza, AP_overlap, currentChooseReza, studentReza)));
        System.out.println("AP info after adding reza is:" + AP_overlap);
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("AP info after adding reza is:" + AP_overlap));
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf(studentReza.getCurrentChoose()));
        pw.write("\n");
        pw.write("\n");
        pw.write(String.valueOf("Reza info after adding to APOverlap:"+studentReza));
        pw.close();
        int actual = AP_overlap.getCapacity();
        assertEquals(19,actual,0.000001);
    }





}