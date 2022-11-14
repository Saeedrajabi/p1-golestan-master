package ir.ac.kntu;

import java.util.HashMap;

public class UsernamesPasswords {
    private HashMap<Integer, String> userPassStudents = new HashMap<Integer, String>();
    private HashMap<Integer,String>userPassTeachers=new HashMap<Integer,String>();
    private HashMap<Integer,String>userPassAdmin=new HashMap<Integer,String>();
    private int userTemp;
    private String passTemp;

    public UsernamesPasswords() {
        userPassAdmin.put(1,"admin");
    }


    public HashMap<Integer, String> getUserPassTeachers() {
        return userPassTeachers;
    }

    public HashMap<Integer, String> getUserPassStudents() {
        return userPassStudents;
    }

    public void setUserPass(HashMap<Integer, String> userPass) {
        this.userPassStudents = userPassStudents;
    }

    public int getUserTemp() {
        return userTemp;
    }

    public void setUserTemp(int userTemp) {
        this.userTemp = userTemp;
    }

    public String getPassTemp() {
        return passTemp;
    }

    public HashMap<Integer, String> getUserPassAdmin() {
        return userPassAdmin;
    }

    public void setPassTemp(String passTemp) {
        this.passTemp = passTemp;
    }

    /**
     * This function would add any usernames and passwords of a student to a hashmap to have all userpassesStudnet.
     * @param student
     */
    public void addUserPass(Student student) {
        if (userPassStudents.containsKey(student.getStudentNum())) {
            System.out.println("This student number is available.");
            System.out.println("Try by another student number.");
        } else {
            userPassStudents.put(student.getStudentNum(), student.getPassword());
        }
    }

    /**
     * This function would add any usernames and passwords of a teacher to a hashmap to have all userpassesteachers.
     * @param teacher
     */
    public void addUserPassTeachers(Teacher teacher) {
        if (userPassTeachers.containsKey(teacher.getTeacherNum())) {
            System.out.println("This Professor number is available.");
            System.out.println("Try by another Professor number.");
        } else {
            userPassTeachers.put(teacher.getTeacherNum(), teacher.getPassword());
        }
    }


    @Override
    public String toString() {
        return "UsernamesPasswords{" +
                "userPass=" + userPassStudents + '\'' +
                '}';
    }
}
