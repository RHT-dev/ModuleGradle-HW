package model;

import java.util.List;

public class Statistics {
    private String studyProfile;
    private float avgExamScore;
    private int studentCountInProfile;
    private int universityCountInProfile;
    private List<String> universityNames;

    public Statistics() {
    }

    public Statistics(String studyProfile, float avgExamScore, int studentCount, int universityCountInProfile, List<String> universityNames) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.studentCountInProfile = studentCount;
        this.universityCountInProfile = universityCountInProfile;
        this.universityNames = universityNames;
    }

    public String getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(String studyProfile) {
        this.studyProfile = studyProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getStudentCountInProfile() {
        return studentCountInProfile;
    }

    public void setStudentCountInProfile(int studentCountInProfile) {
        this.studentCountInProfile = studentCountInProfile;
    }

    public int getUniversityCountInProfile() {
        return universityCountInProfile;
    }

    public void setUniversityCountInProfile(int universityCountInProfile) {
        this.universityCountInProfile = universityCountInProfile;
    }

    public List<String> getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(List<String> universityNames) {
        this.universityNames = universityNames;
    }
}