package ioprogramming.annotations.annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

/*
 Container annotation
*/
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports{
    BugReport[] value();
}

/*
 Repeatable annotation
*/
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport{
    String description();
}

class Software{

    @BugReport(description="Null pointer issue")
    @BugReport(description="Slow performance")
    public void run(){
        System.out.println("Running Software");
    }
}

public class RepeatableAnnotationExample{

    public static void main(String[] args) throws Exception{

        Method m = Software.class.getMethod("run");

        // Retrieve all bug reports
        BugReport[] reports = m.getAnnotationsByType(BugReport.class);

        for(BugReport r : reports){
            System.out.println("Bug: "+r.description());
        }
    }
}
