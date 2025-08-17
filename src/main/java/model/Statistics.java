package model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "universityProfile")
    private String universityProfile;

    @XmlElement(name = "avgScore")
    private double avgScore;

    public Statistics() {}

    public Statistics(String universityProfile, double avgScore) {
        this.universityProfile = universityProfile;
        this.avgScore = avgScore;
    }

    public String getUniversityProfile() {
        return universityProfile;
    }
    public void setUniversityProfile(String universityProfile) {
        this.universityProfile = universityProfile;
    }
    public double getAvgScore() {
        return avgScore;
    }
    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }
}