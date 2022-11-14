package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;

public class Loggin {
    private int username;
    private String password;
    private boolean hasSubmitted;
    private Student studentTemp;
    private Teacher teachertemp;

    public Teacher getTeachertemp() {
        return teachertemp;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public Student getStudentTemp() {
        return studentTemp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * return a student who wanted to log in.
     *
     * @param students
     */

    public void returnStudent(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentNum() == username) {
                this.studentTemp = students.get(i);
            }

        }
    }

    /**
     * return a teacher who wanted to log in.
     *
     * @param teachers
     */
    public void returnTeacher(ArrayList<Teacher> teachers) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getTeacherNum() == username) {
                this.teachertemp = teachers.get(i);
            }

        }
    }

    /**
     * find out student wanted to log in submitted or not.
     *
     * @param userPass
     * @param students
     * @return
     */
    public boolean hasSubmittedStudent(HashMap<Integer, String> userPass, ArrayList<Student> students) {
        if (userPass.containsKey(username)) {
            if (userPass.get(username).equals(password)) {
                returnStudent(students);
                return true;
            } else {
                System.out.println("your password was not correct.");
            }
        } else {
            System.out.println("Username unavailable.");
            return false;

        }

        return false;
    }

    /**
     * find out professor wanted to log in submitted or not.
     *
     * @param userPass
     * @param teachers
     * @return
     */
    public boolean hasSubmittedTeacher(HashMap<Integer, String> userPass, ArrayList<Teacher> teachers) {
        if (userPass.containsKey(username)) {
            if (userPass.get(username).equals(password)) {
                returnTeacher(teachers);
                return true;
            } else {
                System.out.println("your password was not correct.");
            }
        } else {
            System.out.println("Username unavailable.");
            return false;

        }
        return false;
    }

    /**
     * find out admin submitted or not
     *
     * @param userPass
     * @return
     */
    public boolean hasSubmittedAdmin(HashMap<Integer, String> userPass) {
        if (userPass.containsKey(username)) {
            if (userPass.get(username).equals(password)) {
                return true;
            } else {
                System.out.println("your password was not correct.");
            }
        } else {
            System.out.println("Username unavailable.");
            return false;

        }
        return false;
    }
}
