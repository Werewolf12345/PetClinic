import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

/**
 * Created by Alexey on 3/1/2017.
 */
public class ClinicMain {
    public static void main(String[] args) {
        Address address = new Address(Address.US.ILLINOIS, "920 Cherry Valley RD #105 Vernon Hills", 60061);
        Client vasya = new Client("Vasya", "Ivanov", address, "708-415-5808");
        Dog bobik = new Dog("Bobik", "терьер", 5, vasya);

        address = new Address(Address.US.ALABAMA, "450 Wind st Libertyvill", 50051);
        Client petya = new Client("Petya", "Sidorov", address, "840-745-5887");
        Dog tuzik = new Dog("Tuzik", "двортерьер", 1, petya);

        address = new Address(Address.US.WISCONSIN, "113 Maple st Skokie", 30031);
        Client kolya = new Client("Kolya", "Boriskov", address, "555-415-5555");
        Dog belka = new Dog("Belka", "немецкая овчарка", 10, kolya);


        try {
            FileOutputStream file = new FileOutputStream("clinicDB.ser");
            ObjectOutputStream object = new ObjectOutputStream(file);

            object.writeObject(bobik);
            object.writeObject(tuzik);
            object.writeObject(belka);
            object.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        vasya = null;
        bobik = null;
        petya = null;
        tuzik = null;
        kolya = null;
        belka = null;

        try {

            ObjectInputStream is = new ObjectInputStream(new FileInputStream("clinicDB.ser"));

            belka = (Dog) is.readObject();
            bobik = (Dog) is.readObject();
            tuzik = (Dog) is.readObject();
            is.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

       /* System.out.println(bobik);
        System.out.println(tuzik);
        System.out.println(belka);*/
        /*try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }*/

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic?" +
                            "user=root&password=terminalx1053&useSSL=true");

            con.setAutoCommit(false);

            PreparedStatement updateSales = con.prepareStatement(
                    "UPDATE COFFEES SET SALES = ? WHERE COF_NAME = ?");
            updateSales.setInt(1, 50);
            updateSales.setString(2, "Colombian");
            updateSales.executeUpdate();
            PreparedStatement updateTotal = con.prepareStatement(
                    "UPDATE COFFEES SET TOTAL = TOTAL + ? WHERE COF_NAME = ?");
            updateTotal.setInt(1, 50);
            updateTotal.setString(2, "Colombian");
            updateTotal.executeUpdate();
            con.commit();

            con.setAutoCommit(true);

            /*stmt = conn.createStatement();

            stmt.executeUpdate("insert into SUPPLIERS values (101, " +
                    "'Acme, Inc.', '99 Market Street', 'Groundsville', " +
                    "'CA', '95199')");
            stmt.executeUpdate("insert into SUPPLIERS values (49, " +
                    "'Superior Coffee', '1 Party Place', 'Mendocino', 'CA', " +
                    "'95460')");
            stmt.executeUpdate("insert into SUPPLIERS values (150, " +
                    "'The High Ground', '100 Coffee Lane', 'Meadows', 'CA', " +
                    "'93966')");*/

            /*if (stmt.execute("UPDATE COFFEES " +
                    "SET TOTAL = TOTAL + 75 " +
                    "WHERE COF_NAME = 'Colombian'")) {
                rs = stmt.getResultSet();
                while (rs.next()) {
                    String s = rs.getString("COF_NAME");
                    float n = rs.getFloat("PRICE");
                    System.out.println(s + " " + n);
                }

                PreparedStatement updateSales = (PreparedStatement) conn.prepareStatement(
                        "UPDATE COFFEES SET SALES = ? WHERE COF_NAME = ?");


            }*/
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }

    }
}