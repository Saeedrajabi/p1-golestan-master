package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teacher {
    private String firstName;
    private String lastName;
    private int teacherNum;
    private String password;
    private ArrayList<String> courseSubmitted;

    public Teacher(String firstName, String lastName, int teacherNum, String password, ArrayList<String> courseSubmitted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherNum = teacherNum;
        this.password = password;
        this.courseSubmitted = courseSubmitted;
    }

    /**
     * this function would accept only Strings that follow this format:^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$
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

    public int getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(int teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getPassword() {
        return password;
    }
    /**
     * This function would check password and if entered password was wrong get new password and check it again.
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

    public ArrayList<String> getCourseSubmitted() {
        return courseSubmitted;
    }

    public void setCourseSubmitted(ArrayList<String> courseSubmitted) {
        this.courseSubmitted = courseSubmitted;
    }

    @Override

    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teacherNum=" + teacherNum +
                ", password='" + password + '\'' +
                ", courseSubmitted=" + courseSubmitted +
                '}';
    }
}
