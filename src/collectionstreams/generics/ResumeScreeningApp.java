package collectionstreams.generics;

import java.util.ArrayList;
import java.util.List;


abstract class JobRole {

    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }


    public abstract void screenResume();
}


class SoftwareEngineer extends JobRole {

    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public void screenResume() {
        System.out.println(getCandidateName()
                + " screened for Software Engineer role (DSA + Coding Test)");
    }
}

class DataScientist extends JobRole {

    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public void screenResume() {
        System.out.println(getCandidateName()
                + " screened for Data Scientist role (ML + Statistics)");
    }
}

class ProductManager extends JobRole {

    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public void screenResume() {
        System.out.println(getCandidateName()
                + " screened for Product Manager role (Strategy + Communication)");
    }
}


class Resume<T extends JobRole> {

    private List<T> resumes = new ArrayList<>();

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public List<T> getResumes() {
        return resumes;
    }
}


class ScreeningUtil {

    public static void screenAll(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            role.screenResume();
        }
    }


    public static <T extends JobRole> void screenCandidate(T candidate) {
        candidate.screenResume();
    }
}


public class ResumeScreeningApp {

    public static void main(String[] args) {


        Resume<SoftwareEngineer> seResumes = new Resume<>();
        seResumes.addResume(new SoftwareEngineer("Alice"));
        seResumes.addResume(new SoftwareEngineer("Bob"));


        Resume<DataScientist> dsResumes = new Resume<>();
        dsResumes.addResume(new DataScientist("Charlie"));
        dsResumes.addResume(new DataScientist("Diana"));


        Resume<ProductManager> pmResumes = new Resume<>();
        pmResumes.addResume(new ProductManager("Eve"));

        System.out.println("---- Software Engineer Screening ----");
        ScreeningUtil.screenAll(seResumes.getResumes());

        System.out.println("\n---- Data Scientist Screening ----");
        ScreeningUtil.screenAll(dsResumes.getResumes());

        System.out.println("\n---- Product Manager Screening ----");
        ScreeningUtil.screenAll(pmResumes.getResumes());

        System.out.println("\n---- Single Candidate Screening ----");
        ScreeningUtil.screenCandidate(new SoftwareEngineer("Frank"));
    }
}

