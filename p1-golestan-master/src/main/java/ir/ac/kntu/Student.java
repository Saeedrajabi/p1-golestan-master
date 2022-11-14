package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Student {
    private HashMap<CourseGroup, Double> passedLessons;
    private ArrayList<String> passedlist = new ArrayList<String>();
    private String firstName;
    private String lastName;
    private int studentNum;
    private String password;
    private int unitsTakenNum;
    private ArrayList<CourseGroup> currentChoose;

    public Student(String firstName, String lastName, int studentNum, String password, int unitsTakenNum, HashMap<CourseGroup, Double> passedLessons, ArrayList<CourseGroup> currentChoose) {
        this.passedLessons = passedLessons;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNum = studentNum;
        this.password = password;
        this.unitsTakenNum = unitsTakenNum;
        this.currentChoose = currentChoose;
    }

    public Student() {
    }

    /**
     * this function would accept only Strings that follow this format:^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$
     *
     * @param str :Password would pass into this function
     * @return boolean answer that entered password has accepted or not.
     */
    public static boolean isValidPassword(String str) {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
        Pattern p = Pattern.compile(regex);
        if (str == null || str.equals("") || str.equals(" ") || str.equals("  ")) {
            return false;

        }
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * This function has no input.
     *
     * @return names of lesson that a student passed.
     */

    private ArrayList<String> getPassedLessonsNames() {
        ArrayList<String> courseName = new ArrayList<>();
        for (int i = 0; i < this.currentChoose.size(); i++) {
            courseName.add(this.currentChoose.get(i).getCourseName());
        }
        return courseName;
    }

    public ArrayList<String> getPassedlist() {
        return passedlist;
    }

    /**
     * @return Student all information.
     */
    @Override
    public String toString() {
        return "Student{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentNum=" + studentNum +
                ", password='" + password + '\'' +
                ", unitsTakenNum=" + unitsTakenNum +
                ", currentChoose=" + getPassedLessonsNames() +
                '}';
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String getPassword() {
        return password;
    }

    /**
     * This function would check password and if entered password was wrong get new password and check it again.
     *
     * @param password
     */

    public void setPassword(String password) {
        if (isValidPassword(password)) {
            this.password = password;
        } else {
            System.out.println("your entered password was not valid");
            System.out.println("please enter another one:");
            Scanner sc = new Scanner(System.in);
            String newPass = sc.nextLine();
            setPassword(newPass);
        }
    }

    public int getUnitsTakenNum() {
        return unitsTakenNum;
    }

    public void setUnitsTakenNum(int unitsTakenNum) {

        this.unitsTakenNum = unitsTakenNum;
    }

    public HashMap<CourseGroup, Double> getPassedLessons() {
        return passedLessons;
    }

    public void setPassedLessons(HashMap<CourseGroup, Double> passedLessons) {
        this.passedLessons = passedLessons;
    }

    public ArrayList<CourseGroup> getCurrentChoose() {
        return currentChoose;
    }

    public void setCurrentChoose(ArrayList<CourseGroup> currentChoose) {
        this.currentChoose = currentChoose;
    }

    /**
     * This function would check number of student's free units.
     *
     * @param currentChoose is array list of courses that student chose successfully.
     * @return boolean that you have free units or not.
     */

    public boolean isfreeunits(ArrayList<CourseGroup> currentChoose) {
        if (20 - currentChoose.size() > 0) {
            return true;
        } else {
            System.out.println("You have reached the limit of number of unit selection");
            return false;
        }

    }

    /**
     * This funtion would check if you passed this lesson or not.
     *
     * @param passedLessons hashmap of your passed lessons.
     * @param course        The course that student decided to choose.
     * @return Passed this lesson or not.
     */

    public boolean havePassed(HashMap<CourseGroup, Double> passedLessons, Course course) {
        if (passedLessons.containsKey(course.getCourseName())) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * This function would check if student passed prerequisites lessons or not.
     *
     * @param passedlist Arraylist of names of passed lessons.
     * @param course     The course that student decided to choose.
     * @return
     */
    public boolean passedpreq(ArrayList<String> passedlist, CourseGroup course) {
        return passedlist.containsAll(course.getPrerequisites());
    }

    /**
     * This function check if Student are free at course time or not.
     *
     * @param currentChoose is array list of courses that student chose successfully.
     * @param course        The course that student decided to choose.
     * @return
     */

    public boolean isFreeAtTime(ArrayList<CourseGroup> currentChoose, CourseGroup course) {
        for (int i = 0; i < currentChoose.size(); i++) {
            if (course.getDt().equals(currentChoose.get(i).getDt())) {
                return false;
            }
        }
        return true;
    }


    /**
     * This function would check all condition for adding a lesson and decrease from free units for student and decrement capacity of course.
     * For example: if student has free time and have not passed this lesson and student have passed prerequisites and student has no class at that time.
     *
     * @param passedlist    is means this func has to take Arraylist of passed lesson names
     * @param course        The course that student decided to choose.
     * @param currentChoose is array list of courses that student chose successfully.
     * @param student       student
     * @return returns any error that student has to solve them.
     */
    public String addLessons(ArrayList<String> passedlist, CourseGroup course, ArrayList<CourseGroup> currentChoose, Student student) {
        if (isfreeunits(currentChoose)) {
            if (havePassed(passedLessons, course)) {
                if (passedpreq(passedlist, course)) {
                    if (isFreeAtTime(currentChoose, course)) {
                        currentChoose.add(course);
                        course.setCapacity(course.getCapacity() - 1);
                        course.addStudents(student);
                        this.unitsTakenNum = this.unitsTakenNum - 1;
                        return "Unit selection was successful.";
                    } else {
                        return "Please select another time.You have Class in that time.";
                    }
                } else {
                    return "You have not passed prerequisites lessons.";
                }
            } else {
                return "You have passed this course.";
            }
        } else {
            return "You have reached the limit of number of unit selection";
        }
    }

}
