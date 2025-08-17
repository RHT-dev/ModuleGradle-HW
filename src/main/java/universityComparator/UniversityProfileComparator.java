package universityComparator;

import model.University;

public class UniversityProfileComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return o1.getUniversityProfile().compareTo(o2.getUniversityProfile());
    }
}

