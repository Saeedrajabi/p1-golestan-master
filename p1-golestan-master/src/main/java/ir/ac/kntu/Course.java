package ir.ac.kntu;

import java.util.ArrayList;

public class Course {
    private int courseNum;

    private String courseName;

    private ArrayList<String> prerequisites;

    public Course(int courseNum, String courseName, ArrayList<String> prerequisites) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.prerequisites = prerequisites;
    }


    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<String> getPrerequisites() {
        return new ArrayList<>(prerequisites);
    }

    public void setPrerequisites(ArrayList<String> prerequisites,String str) {
        ArrayList<String>prt=new ArrayList<>(prerequisites);
        prt.add(str);
        this.prerequisites=prt;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseNum=" + courseNum +
                ", courseName='" + courseName + '\'' +
                ", prerequisites=" + prerequisites +
                '}';
    }
}
