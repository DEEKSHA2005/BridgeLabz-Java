package ioprogramming.annotations.annotations;
/*
 Class representing an old API
*/
class LegacyAPI{

    /*
     Old method marked deprecated
     Compiler will show warning
    */
    @Deprecated
    public void oldFeature(){
        System.out.println("Old Feature - Do not use");
    }

    // New improved method
    public void newFeature(){
        System.out.println("New Feature - Recommended");
    }
}

public class DeprecatedExample{

    public static void main(String[] args){

        LegacyAPI api = new LegacyAPI();

        // Calling deprecated method
        api.oldFeature();

        // Calling recommended method
        api.newFeature();
    }
}