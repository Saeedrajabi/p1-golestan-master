package ir.ac.kntu;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
            throws Exception {
        int username;
        Main main = new Main();
        String password;Inctance inctance = new Inctance();Loggin loggin = new Loggin();Scanner sc = new Scanner(System.in);
        System.out.println("Admin is 0" + "\n" + "Student is 1" + "\n" + "Professor is 2" + "\n" + "Enter your position:");
        String loginway="3";
        loginway = sc.nextLine();
        switch (loginway) {
            case "2":
                System.out.println("Enter your login Username code:");
                username = Integer.parseInt(sc.nextLine());
                System.out.println("Enter your login password code:");
                password = (sc.nextLine());
                loggin.setPassword(password);
                loggin.setUsername(username);
                boolean flagTeacher = loggin.hasSubmittedTeacher(inctance.getUserpass().getUserPassTeachers(), inctance.getAllTeachers());
                if (flagTeacher) {
                    main.loginAcceptedTeacher(loginway, loggin);
                }
                break;
            case "1":
                System.out.println("Enter your login Username code:");
                username = Integer.parseInt(sc.nextLine());
                System.out.println("Enter your login password code:");
                password = (sc.nextLine());
                loggin.setPassword(password);
                loggin.setUsername(username);
                boolean flagStudent = loggin.hasSubmittedStudent(inctance.getUserpass().getUserPassStudents(), inctance.getAllStudents());
                if (flagStudent) {
                    main.loginAcceptedStudent(loginway, loggin);
                }
                break;
            case "0":
                System.out.println("Enter your login Username code:");
                username = Integer.parseInt(sc.nextLine());
                System.out.println("Enter your login password code:");
                password = (sc.nextLine());
                loggin.setPassword(password);
                loggin.setUsername(username);
                boolean flagAdmin = loggin.hasSubmittedAdmin(inctance.getUserpass().getUserPassAdmin());
                if (flagAdmin) {
                    main.loginAcceptedAdmin(loginway, loggin);
                }
                break;
            default:
                break;

        }
        System.out.println("Thank you for choosing us.");
    }

    /**
     * access to student when logged in successfully.
     * @param loginway
     * @param loggin
     */

    public void loginAcceptedStudent(String loginway, Loggin loggin) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want: " + "\n" + "Show your classes is 0 " + "\n" + "Exit is 9");
        String request="9";
        request= sc.nextLine();
        switch (request) {
            case "0":
                System.out.println(loggin.getStudentTemp());
                break;
            case "9":
                System.out.println("You exited");
                break;
            default:
                break;
        }

    }

    /**
     * access to teacher when logged in successfully.
     * @param loginway
     * @param loggin
     */

    public void loginAcceptedTeacher(String loginway, Loggin loggin) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want: " + "\n" + "Show your classes is 0 " + "\n" + "Exit is 9");
        String request ="9";
        request=sc.nextLine();
        switch (request) {
            case "0":
                System.out.println(loggin.getTeachertemp().getCourseSubmitted());
                break;
            case "9":
                System.out.println("You exited");
                break;
            default:break;
        }

    }

    /**
     * defining new class when admin logged in successfully would work with this function.
     */

    public void addClass() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new Course number:");
        int coursenumber = Integer.parseInt(sc.nextLine());
        System.out.println("Enter new Course Name:");
        String coursename = sc.nextLine();
        System.out.println("Enter number of Course prerequisites:");
        int coursNumPrerequisites = Integer.parseInt(sc.nextLine());
        ArrayList<String> prerequisites = new ArrayList<String>();
        for (int i = 0; i < coursNumPrerequisites; i++) {
            System.out.println("Enter prerequisites name: ");
            prerequisites.add(sc.nextLine());
        }
        CourseGroup courseGroup = new CourseGroup(coursenumber, coursename, prerequisites);
        System.out.println("Shanbe 1,yekshanbe 2,doshanbe 3,seshanbe 4, chaharshanbe 5,panjshanbe 6" + "\n"
                + "Enter Day you want to add class:");
        Date day = new Date(Integer.parseInt(sc.nextLine()));
        HashMap<Date, Time> dateTime = new HashMap<>();
        System.out.println("Enter Time you want add class:" + "\n" + "Should be in this format:H:M:S");
        dateTime.put(day, Time.valueOf(sc.nextLine()));
        courseGroup.setDt(dateTime);
        System.out.println("Enter new CourseGroup number:");
        courseGroup.setCourseGroupNum(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter new CourseGroup Name:");
        courseGroup.setCourseGroupName(sc.nextLine());
        courseGroup.setStudents(new ArrayList<Student>());
        System.out.println("Enter Class Capacity:");
        courseGroup.setCapacity(Integer.parseInt(sc.nextLine()));
        courseGroup.setTeachers(new ArrayList<Teacher>());
        courseGroup.setPresentationSemester(4001);
        Inctance inctance1 = new Inctance();
        inctance1.setCourseGroups(courseGroup, inctance1.getCourseGroupHashMap());
        System.out.println(inctance1.getAllCourseGroups());

    }

    /**
     * defining new student when admin logged in successfully would work with this function.
     */

    public void addStudnet() {
        Scanner sc = new Scanner(System.in);
        Inctance inctance = new Inctance();
        Student newStudent = new Student();
        newStudent.setPassedLessons(new HashMap<CourseGroup, Double>());
        System.out.println("Enter new student first name:");
        newStudent.setFirstName(sc.nextLine());
        System.out.println("Enter new student last name:");
        newStudent.setLastName(sc.nextLine());
        System.out.println("Enter new student ID:");
        newStudent.setStudentNum(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter new student Password:");
        newStudent.setPassword(sc.nextLine());
        System.out.println("Enter new student can select how many units :");
        newStudent.setUnitsTakenNum(Integer.parseInt(sc.nextLine()));
        newStudent.setCurrentChoose(new ArrayList<CourseGroup>());
        inctance.getAllStudents().add(newStudent);
        inctance.getUserpass().addUserPass(newStudent);
        System.out.println("New Student Created is: " + newStudent);

    }

    /**
     * editing class when admin logged in successfully would work with this function.
     */

    public void editClass() {
        Scanner sc = new Scanner(System.in);Inctance inctance2 = new Inctance();System.out.println("Which Class you want to edit:");
        System.out.println("Classes are:" + inctance2.getAllCourseGroups());System.out.println("Enter course name you want to edit:");
        CourseGroup tempCourseGroup = new CourseGroup(0, "", new ArrayList<String>());String editPartName = sc.nextLine();
        String tempCourseGroupname = inctance2.getCourseGroupHashMap().get(editPartName).getCourseName();
        tempCourseGroup = inctance2.getCourseGroupHashMap().get(tempCourseGroupname);
        System.out.println("Which part you want to edit:" + "\n" + "1)courseName,2)courseNum,3)prerequisites,4)Date & Time,5)courseGroupNum," +
                "6)courseGroupName,7)capacity,8)presentationSemester");
        String whichPart ="9";whichPart=sc.nextLine();
        switch (whichPart) {
            case "1":
                System.out.println("Previous is :" + tempCourseGroup.getCourseName());
                System.out.println("Enter Your new Course Name:");tempCourseGroup.setCourseName(sc.nextLine());
                System.out.println("Here is Class after your editing");System.out.println(tempCourseGroup.getCourseName());break;
            case "2":
                System.out.println("Previous is :" + tempCourseGroup.getCourseNum());
                System.out.println("Enter Your new Course Num:");tempCourseGroup.setCourseNum((Integer.parseInt(sc.nextLine())));
                System.out.println("Here is Class after your editing");System.out.println(tempCourseGroup.getCourseNum());break;
            case "3":
                System.out.println("Previous is :" + tempCourseGroup.getPrerequisites());
                System.out.println("Enter Your new Course prerequisites:");tempCourseGroup.setPrerequisites(tempCourseGroup.getPrerequisites(), sc.nextLine());
                System.out.println("Here is Class after your editing");System.out.println(tempCourseGroup.getPrerequisites());break;
            case "4":
                System.out.println("Previous is :" + tempCourseGroup.getDt());
                System.out.println("Enter Your new Course Date & time:");
                System.out.println("Enter new Day:" + "\n" + "Shanbe 1,yekshanbe 2,doshanbe 3,seshanbe 4, chaharshanbe 5,panjshanbe 6");
                Date d = new Date(Integer.parseInt(sc.nextLine()));HashMap<Date, Time> dt2 = new HashMap<Date, Time>();
                System.out.println("Enter Time you want add class:" + "\n" + "Should be in this format:H:M:S");dt2.put(d, Time.valueOf(sc.nextLine()));
                tempCourseGroup.setDt(dt2);System.out.println("Here is Class after your editing"+tempCourseGroup.getDt());break;
            case "5":
                System.out.println("Previous is :" + tempCourseGroup.getCourseGroupNum());
                System.out.println("Enter Your new Course Group Num:");tempCourseGroup.setCourseGroupName((sc.nextLine()));
                System.out.println("Here is Class after your editing"+tempCourseGroup.getCourseGroupNum());break;
            case "6":
                System.out.println("Previous is :" + tempCourseGroup.getCourseGroupName());
                System.out.println("Enter Your new Course group Name:");
                tempCourseGroup.setCourseGroupName(sc.nextLine());
                System.out.println("Here is Class after your editing"+ tempCourseGroup.getCourseGroupName());break;
            case "7":
                System.out.println("Capacity is : " + tempCourseGroup.getCapacity());
                System.out.println("Enter new capacity:");
                tempCourseGroup.setCapacity(Integer.parseInt(sc.nextLine()));
                System.out.println("new capacity is:   " + tempCourseGroup.getCapacity());break;
            case "8":
                System.out.println("Presentation semester is:  " + tempCourseGroup.getPresentationSemester());
                System.out.println("Enter new semester presentation :"+ tempCourseGroup.getPresentationSemester());
                tempCourseGroup.setPresentationSemester(Integer.parseInt(sc.nextLine()));break;
            default: break;
        }
    }

    /**
     * if admin logged in successfully,this function will work for adding new student or adding new class or editing class or exit.
     * @param loginway
     * @param loggin
     */

    public void loginAcceptedAdmin(String loginway, Loggin loggin) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want: " + "\n" + "Add new Stunted is 0 " + "\n" + "Add new Class is 1 " + "\n"
                + "Edit Class is 2 " + "\n" + "Exit is 9");
        String request ="9";
        request=sc.nextLine();
        switch (request) {
            case "0":
                addStudnet();break;
            case "1":
                addClass();break;
            case "2":
                editClass();break;

            case "9":
                System.out.println("You exited");break;
            default:break;
        }

    }


}