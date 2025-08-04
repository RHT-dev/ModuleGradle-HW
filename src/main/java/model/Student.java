package model;

import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("student_full_name")
    private String fullName;

    @SerializedName("university_code")
    private String universityId;

    @SerializedName("current_course_number")
    private int currentCourseNumber;

    @SerializedName("average_exam_score")
    private float avgExamScore;

    public Student() {
        this.fullName = "";
        this.universityId = "";
        this.currentCourseNumber = 0;
        this.avgExamScore = 0;
    }

    public Student(String fullName, String universityId,
                   int currentCourseNumber, float avgExamScore) {

        this.universityId = universityId;
        this.fullName = fullName;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUniversityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    @Override
    public String toString() {
        return "Full Name: " + fullName + "\nUniversity ID: " + universityId
                + "\nCurrentCourseNumber: " + currentCourseNumber
                + "\nAverage Exam Score: " + avgExamScore + "\n";
    }
}
