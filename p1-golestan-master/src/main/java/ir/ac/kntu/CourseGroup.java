package ir.ac.kntu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Time;

public class CourseGroup extends Course{
    private int courseGroupNum;

    private HashMap<Date, Time> dt = new HashMap<Date, Time>();

    private String courseGroupName;

    private ArrayList<Student> students;

    private int capacity;

    private ArrayList<Teacher> teachers;

    private int presentationSemester;

    public CourseGroup(int courseNum, String courseName, ArrayList<String> prerequisites) {
        super(courseNum, courseName, prerequisites);
    }


    public CourseGroup(int courseNum, String courseName, ArrayList<String> prerequisites, HashMap<Date, Time> dt, int courseGroupNum, String courseGroupName, ArrayList<Student> students, int capacity, ArrayList<Teacher> teachers, int presentationSemester) {
        super(courseNum, courseName, prerequisites);
        this.dt = dt;
        this.courseGroupNum = courseGroupNum;
        this.courseGroupName = courseGroupName;
        this.students = students;
        this.capacity = capacity;
        this.teachers = teachers;
        this.presentationSemester = presentationSemester;
    }

    public int getCourseGroupNum() {
        return courseGroupNum;
    }

    public void setCourseGroupNum(int courseGroupNum) {
        this.courseGroupNum = courseGroupNum;
    }

    public String getCourseGroupName() {
        return courseGroupName;
    }

    public void setCourseGroupName(String courseGroupName) {
        this.courseGroupName = courseGroupName;
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public HashMap<Date, Time> getDt() {
        return dt;
    }

    public void setDt(HashMap<Date, Time> dt) {
        this.dt = dt;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = new ArrayList<>(teachers);
    }

    public int getPresentationSemester() {
        return presentationSemester;
    }

    public void setPresentationSemester(int presentationSemester) {
        this.presentationSemester = presentationSemester;
    }

    /**
     * This function would use in Student.java
     * functionality is adding a student to students list of a course.
     * @param student
     */
    public void addStudents(Student student) {
        this.students.add(student);
        //System.out.println(getCourseName()+" Students are  "+students);

    }

    /**
     * functionality is adding a Teacher to teachers list of a course.
     * @param teacher
     */
    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        //System.out.println(getCourseName()+" Teachers are  "+teachers);
    }


    @Override
    public String toString() {
        return "CourseGroup{" +
                "dt=" + dt +
                ", courseGroupNum=" + courseGroupNum +
                ", courseGroupName='" + courseGroupName + '\'' +
                ", students=" + students +
                ", capacity=" + capacity +
                ", teachers=" + teachers +
                ", presentationSemester=" + presentationSemester +
                '}';
    }
}
