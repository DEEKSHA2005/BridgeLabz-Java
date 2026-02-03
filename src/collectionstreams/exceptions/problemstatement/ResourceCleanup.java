package collectionstreams.exceptions.problemstatement;

class Connection {
    void open() {
        System.out.println("Connection opened");
    }

    void close() {
        System.out.println("Connection closed");
    }
}

public class ResourceCleanup {
    public static void main(String[] args) {

        Connection con = new Connection();

        try {
            con.open();
            throw new RuntimeException("Error occurred");
        } catch (Exception e) {
            System.out.println("Exception handled");
        } finally {
            con.close();
        }
    }
}

