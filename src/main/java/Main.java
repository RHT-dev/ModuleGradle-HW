public class Main {
    public static void main(String[] args) {

        University university_msu = new University()
                .setId("MSU")
                .setFullName("Московский государственный университет имени М. В. Ломоносова")
                .setShortName("МГУ")
                .setYearOfFoundation(1755)
                .setMainProfile(StudyProfile.MATH);

        University university_spbgu = new University()
                .setId("SPBGU")
                .setFullName("Санкт-Петербургский государственный университет")
                .setShortName("СПбГУ")
                .setYearOfFoundation(1724)
                .setMainProfile(StudyProfile.JOURNALISM);

        University university_mai = new University()
                .setId("MAI")
                .setFullName("Московский авиационный институт")
                .setShortName("МАИ")
                .setYearOfFoundation(1930)
                .setMainProfile(StudyProfile.AVIATION);

        University university_hse = new University()
                .setId("HSE")
                .setFullName("Высшая школа экономики")
                .setShortName("ВШЭ")
                .setYearOfFoundation(1992)
                .setMainProfile(StudyProfile.ECONOMICS);


        Student student1 = new Student()
                .setFullName("Джонни Кейдж")
                .setUniversityId("MSU")
                .setCurrentCourseNumber(3)
                .setAvgExamScore(4.7f);

        Student student2 = new Student()
                .setFullName("Геральт из Ривии")
                .setUniversityId("SPBGU")
                .setCurrentCourseNumber(3)
                .setAvgExamScore(5.0f);

        Student student3 = new Student()
                .setFullName("Джек Ричер")
                .setUniversityId("MAI")
                .setCurrentCourseNumber(2)
                .setAvgExamScore(4.0f);

        Student student4 = new Student()
                .setFullName("Корпорат Ви")
                .setUniversityId("HSE")
                .setCurrentCourseNumber(1)
                .setAvgExamScore(4.4f);


        System.out.println(university_msu);
        System.out.println(university_spbgu);
        System.out.println(university_mai);
        System.out.println(university_hse);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
    }
}
