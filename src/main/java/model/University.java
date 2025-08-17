package model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class University {
    @XmlElement(name = "universityId")
    private String universityId;

    @XmlElement(name = "universityName")
    private String universityName;

    @XmlElement(name = "universityProfile")
    private String universityProfile;



    // по какой-то причине не используется в XML-структуре задания 29.5,
    // но при удалении этого поля нарушается работа соответствующего компаратора.
    // поэтому, принято решение оставить поле, но не "транслировать" его в XML структуру
    private int yearOfFoundation;

    // по какой-то причине не используется в XML-структуре задания 29.5,
    // но при удалении этого поля нарушается работа соответствующего компаратора.
    // поэтому, принято решение оставить поле, но не "транслировать" его в XML структуру
    private String shortName;


    public University() {}

    public University(String universityId, String universityName, String universityProfile) {
        this.universityId = universityId;
        this.universityName = universityName;
        this.universityProfile = universityProfile;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityProfile() {
        return universityProfile;
    }

    public void setUniversityProfile(String universityProfile) {
        this.universityProfile = universityProfile;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

}
