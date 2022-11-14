package ir.ac.kntu;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class Inctance {
    private UsernamesPasswords userpass = new UsernamesPasswords();

    private ArrayList<Student> studentsRF = new ArrayList<Student>();

    private ArrayList<Student> allStudents = new ArrayList<Student>();

    private ArrayList<Teacher> allTeachers = new ArrayList<Teacher>();

    private ArrayList<String>allCourseGroups=new ArrayList<String>();

    private HashMap<String,CourseGroup>courseGroupHashMap=new HashMap<String,CourseGroup>();

    //creating teacher
    private ArrayList<Teacher> teachersRF = new ArrayList<Teacher>();

    //creating course that you want to choose
    private ArrayList<CourseGroup> course = new ArrayList<CourseGroup>();

    //create an arraylist that formed by CourseGroup.
    //it shows all courses you chose and was acceptable

    //create a hashmap that save all information of your passed courses.
    private HashMap<CourseGroup, Double> passedSaeed = new HashMap<CourseGroup, Double>();

    //create an arraylist that save just String of your passed courses.
    private ArrayList<String> passedlist = new ArrayList<String>();

    //create prerequisites list(پیشنیاز ها)
    private ArrayList<String> prerequisites = new ArrayList<String>();

    private ArrayList<Student> studentsAP = new ArrayList<Student>();

    public Inctance() {
        HashMap<Date, Time> dateTime = new HashMap<>();

        //creating Hashmap that key is based on Date Class and value is based on java,sql.Time
        //reference for java.sql.Time is https://www.geeksforgeeks.org/time-class-in-java-sql/
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
        //System.out.println("++++++++++++++++++++");

        //The admin wants to make the Madar1 lesson a prerequisite for the RF circuits lesson.
        // Create RF Circuits on Mondays at 13:30 with CourseNum:222 and CourseGroupNum:222 and courseGroupName: Madarmokhaberatiha with 10 person capacity.
        //RF Circuits will present in semester 4001.
        CourseGroup madarMokhabreti = new CourseGroup(222, "Madarmokhaberati", prerequisites, dateTime, 222, "Madarmokhaberati", new ArrayList<>(), 10, teachersRF, 4001);
        setCourseGroups(madarMokhabreti,courseGroupHashMap);

        //printing and save madarMokhaberati informations.
        //System.out.println("Madar Mokhaberati info is:" + madarMokhabreti);

        //System.out.println("pishniaz:" + madarMokhabreti.getPrerequisites());

        //Making Student Saeed
        //System.out.println("++++++++++++++++++");

    /*Create Saeed as a Student with password "qweA@sdqwe" that has acceptable by "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"
    we used that regex in HW2-NameValidation.
    It is assumed that the student can choose 20 units
    */
        Student studentSaeed = new Student("Saeed", "Rajabi", 9726763, "qweA@sdqwe", 20, passedSaeed, new ArrayList<CourseGroup>());
        //print Saeed's information before Adding any lesson
        //System.out.println("Saeed's information before Adding any lesson :" + studentSaeed);

        userpass.addUserPass(studentSaeed);
        setAllStudents(studentSaeed);

        //Saeed passed the course with a score of 16.5
        //score is acceptable so add it to passed courses.
        passedSaeed.put(madar1, 16.5);
        passedlist.add(madar1.getCourseName());
        //Adding studentSaeed to madarMokhaberati
        //capacity has to decrease one with
        studentSaeed.addLessons(passedlist, madarMokhabreti, studentSaeed.getCurrentChoose(), studentSaeed);
        setStudentsRF(studentSaeed);
        //System.out.println(madarMokhabreti);

        //The admin wants to make no lesson lesson a prerequisite for the AP lesson.
        // Create AP on Tuesdays at 13:30 with CourseNum:444 and CourseGroupNum:3 and courseGroupName: AP with 20 person capacity.
        //AP will present in semester 4001.
        ArrayList<String> prerequisitesAP = new ArrayList<String>();
        HashMap<Date, Time> dateTime1 = new HashMap<>();
        Date seshanbe = new Date(4);
        dateTime1.put(seshanbe, Time.valueOf("13:30:00"));
        //creating teacher
        ArrayList<Teacher> teachersAP = new ArrayList<Teacher>();
        CourseGroup ap = new CourseGroup(444, "AP", prerequisitesAP, dateTime1, 3, "AP", studentsAP, 20, teachersAP, 4001);
        setCourseGroups(ap,courseGroupHashMap);
        //AP's information is :
        //System.out.println("AP info is:" + AP);

        //prerequisites for AP is:
        //System.out.println("pishniaz haye AP:" + AP.getPrerequisites());
        studentSaeed.addLessons(passedlist, ap, studentSaeed.getCurrentChoose(), studentSaeed);
        //System.out.println(studentSaeed);
        //System.out.println("After adding student Saeed to AP:" + AP);


        //System.out.println("define Student Reza");
        //create an arraylist that formed by CourseGroup.
        //it shows all courses you chose and was acceptable
        ArrayList<CourseGroup> currentChooseReza = new ArrayList<CourseGroup>();

        //create a hashmap that save all information of your passed courses.
        HashMap<CourseGroup, Double> passedReza = new HashMap<CourseGroup, Double>();

        //create an arraylist that save just String of your passed courses.
        ArrayList<String> passedlistReza = new ArrayList<String>();

        Student studentReza = new Student("Reza", "Khatibi", 9826763, "qweA@sdqwe", 20, passedReza, currentChooseReza);
        userpass.addUserPass(studentReza);
        setAllStudents(studentReza);
        //System.out.println(studentReza.addLessons(passedlist, AP, currentChoose1,studentReza));
        studentReza.addLessons(passedlistReza, ap, currentChooseReza, studentReza);

        //Adding Professors:
        ArrayList<String> courseSubmittedZamanian = new ArrayList<String>();
        courseSubmittedZamanian.add("Course Name: " + ap.getCourseName() + "**  Course Group Name:  " + ap.getCourseGroupName() + "**" + " At Time : " + ap.getDt());
        Teacher teacherZamanian = new Teacher("Mehdi", "Zamanian", 111111, "Qwe@123", courseSubmittedZamanian);
        userpass.addUserPassTeachers(teacherZamanian);
        allTeachers.add(teacherZamanian);
        ArrayList<String> courseSubmittedAhmadi = new ArrayList<String>();
        courseSubmittedAhmadi.add("Course Name: " + madarMokhabreti.getCourseName() + "**  Course Group Name:  " + madarMokhabreti.getCourseGroupName() + "**" + " At Time : " + madarMokhabreti.getDt());
        Teacher teacherAhmadi = new Teacher("Arash", "Ahmadi", 22222, "Qwe@123", courseSubmittedAhmadi);
        userpass.addUserPassTeachers(teacherAhmadi);
        allTeachers.add(teacherAhmadi);

    }

    public ArrayList<Teacher> getAllTeachers() {
        return allTeachers;
    }

    public UsernamesPasswords getUserpass() {
        return userpass;
    }

    public void setUserpass(UsernamesPasswords userpass) {
        this.userpass = userpass;
    }

    public ArrayList<Student> getStudentsAP() {
        return studentsAP;
    }

    public ArrayList<Student> getStudentsRF() {
        return studentsRF;
    }

    public void setStudentsRF(Student student) {

        this.studentsRF.add(student);
    }

    public ArrayList<Teacher> getTeachersRF() {
        return teachersRF;
    }

    public void setTeachersRF(ArrayList<Teacher> teachersRF) {
        this.teachersRF = teachersRF;
    }

    public ArrayList<CourseGroup> getCourse() {
        return course;
    }

    public void setCourse(ArrayList<CourseGroup> course) {
        this.course = course;
    }

    public HashMap<CourseGroup, Double> getPassedSaeed() {
        return passedSaeed;
    }

    public void setPassedSaeed(HashMap<CourseGroup, Double> passedSaeed) {
        this.passedSaeed = passedSaeed;
    }

    public ArrayList<String> getPassedlist() {
        return passedlist;
    }

    public void setPassedlist(ArrayList<String> passedlist) {
        this.passedlist = passedlist;
    }

    public ArrayList<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(ArrayList<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(Student student) {

        this.allStudents.add(student);
    }

    public void setAllTeachers(Teacher teacher) {

        this.allTeachers.add(teacher);
    }

    public ArrayList<String> getAllCourseGroups() {
        return allCourseGroups;
    }

    public void setCourseGroups(CourseGroup courseGroup,HashMap<String,CourseGroup>courseGroupHashMap) {
        ArrayList<String>allCourseGroup=new ArrayList<String>();
        allCourseGroup=this.allCourseGroups;
        allCourseGroup.add(courseGroup.getCourseName()+": "+courseGroup.getDt());
        this.allCourseGroups=allCourseGroup;
        this.courseGroupHashMap.put(courseGroup.getCourseGroupName(),courseGroup);
    }

    public HashMap<String, CourseGroup> getCourseGroupHashMap() {
        return courseGroupHashMap;
    }
}
