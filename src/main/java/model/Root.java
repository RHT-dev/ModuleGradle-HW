package model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {
    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    private List<Student> studentsInfo;

    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private List<University> universitiesInfo;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statisticalInfo;

    @XmlElement(name = "processedAt")
    private String processedAt;

    public List<Student> getStudentsInfo() {
        return studentsInfo;
    }

    public void setStudentsInfo(List<Student> studentsInfo) {
        this.studentsInfo = studentsInfo;
    }

    public List<University> getUniversitiesInfo() {
        return universitiesInfo;
    }

    public void setUniversitiesInfo(List<University> universitiesInfo) {
        this.universitiesInfo = universitiesInfo;
    }

    public List<Statistics> getStatisticalInfo() {
        return statisticalInfo;
    }

    public void setStatisticalInfo(List<Statistics> statisticalInfo) {
        this.statisticalInfo = statisticalInfo;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(String processedAt) {
        this.processedAt = processedAt;
    }
}
