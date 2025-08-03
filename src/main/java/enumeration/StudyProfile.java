package enumeration;

public enum StudyProfile {
    ECONOMICS("Экономика"),
    PSYCHOLOGY("Психология"),
    MEDICINE("Медицина"),
    MATH("Математика"),
    DESIGN("Дизайн"),
    AVIATION("Авиация"),
    JOURNALISM("Журналистика"),
    ENGINEERING("Инженерия");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
