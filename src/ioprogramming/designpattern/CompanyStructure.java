import java.util.*;

/*
 Composite Pattern
 Allows treating individual objects and groups the same way
*/

// Component interface
interface Staff {
    void displayInfo();
}

// Leaf class
class Engineer implements Staff {

    String name;

    Engineer(String name) {
        this.name = name;
    }

    // display engineer details
    public void displayInfo() {
        System.out.println("Engineer: " + name);
    }
}

// Composite class
class TeamLead implements Staff {

    List<Staff> teamMembers = new ArrayList<>();

    // add member
    void addMember(Staff s) {
        teamMembers.add(s);
    }

    // remove member
    void removeMember(Staff s) {
        teamMembers.remove(s);
    }

    // show all members
    public void displayInfo() {

        System.out.println("Team Lead supervising:");

        for (Staff s : teamMembers) {
            s.displayInfo();
        }
    }
}

public class CompanyStructure {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Engineer 1 name:");
        String e1 = sc.nextLine();

        System.out.println("Enter Engineer 2 name:");
        String e2 = sc.nextLine();

        // leaf objects
        Engineer eng1 = new Engineer(e1);
        Engineer eng2 = new Engineer(e2);

        // composite object
        TeamLead lead = new TeamLead();

        lead.addMember(eng1);
        lead.addMember(eng2);

        // display hierarchy
        lead.displayInfo();
    }
}