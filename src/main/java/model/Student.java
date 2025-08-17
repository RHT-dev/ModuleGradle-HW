package model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlElement(name = "studentName")
    private String studentName;

    @XmlElement(name = "universityId")
    private String universityId;

    @XmlElement(name = "avgScore")
    private double avgScore;



    // по какой-то причине не используется в XML-структуре задания 29.5,
    // но при удалении этого поля нарушается работа соответствующего компаратора.
    // поэтому, принято решение оставить поле, но не "транслировать" его в XML структуру
    private int currentCourseNumber;



    public Student() {}

    public Student(String studentName, String universityId, double avgScore) {
        this.studentName = studentName;
        this.universityId = universityId;
        this.avgScore = avgScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

}
