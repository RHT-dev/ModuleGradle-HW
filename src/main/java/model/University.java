package model;

import com.google.gson.annotations.SerializedName;
import enumeration.StudyProfile;

public class University {

    @SerializedName("university_id")
    private String id;

    @SerializedName("university_full_name")
    private String fullName;

    @SerializedName("university_title")
    private String shortName;

    @SerializedName("foundation_year")
    private int yearOfFoundation;

    @SerializedName("main_profile")
    private StudyProfile mainProfile;

    public University() {
        this.id = "";
        this.fullName = "";
        this.shortName = "";
        this.yearOfFoundation = 0;
        this.mainProfile = null;
    }

    public University(String id, String fullName, String shortName,
                      int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nFull Name: " + fullName
                + "\nShort Name: " + shortName
                + "\nYear of Foundation: " + yearOfFoundation
                + "\nStudy Profile: " + (mainProfile != null ? mainProfile.getProfileName() : "null") + "\n";
    }
}
