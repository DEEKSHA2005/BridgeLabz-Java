package ioprogramming.annotations.annotations;
import java.lang.annotation.*;   // Import classes for creating custom annotations
import java.lang.reflect.*;     // Import reflection classes like Method

/*
   Custom annotation RoleAllowed
   This annotation will be used to restrict
   access to certain methods based on user role
*/
@Retention(RetentionPolicy.RUNTIME)   // Annotation available during runtime
@Target(ElementType.METHOD)           // Annotation can only be applied to methods
@interface RoleAllowed{

    // Role required to access the method
    String value();
}

/*
   Service class containing an admin-only method
*/
class AdminService{

    // Only ADMIN role should access this method
    @RoleAllowed("ADMIN")
    public void deleteUser(){

        // Method functionality
        System.out.println("User Deleted");
    }
}

/*
   Main class to simulate role-based access control
*/
public class RoleAccessExample{

    public static void main(String[] args) throws Exception{

        // Simulated user role (can be changed to ADMIN to allow access)
        String userRole = "USER";

        /*
         Retrieve deleteUser() method
         using Reflection API
        */
        Method m = AdminService.class.getMethod("deleteUser");

        // Retrieve RoleAllowed annotation from the method
        RoleAllowed role = m.getAnnotation(RoleAllowed.class);

        /*
         Check if current user role matches
         the role required by the annotation
        */
        if(role.value().equals(userRole)){

            // Create object of AdminService
            AdminService service = new AdminService();

            // Invoke method dynamically
            m.invoke(service);

        }else{

            // If roles do not match, deny access
            System.out.println("Access Denied!");
        }
    }
}
