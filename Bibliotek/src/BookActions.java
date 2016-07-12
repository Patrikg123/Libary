import java.sql.*;

/**
 * Created by Elev1 on 2016-07-07.
 */
public class BookActions {

    public static void BorrowBook(int bookid, int userid) {


        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/LibaryDB", "postgres", "delllenovo")) {
            try (Statement stmt = con.createStatement()) {
                String sql = "INSERT INTO borrowed (borrowerid, \"BookID\", isreturned) VALUES (" + userid + "," + bookid + ", FALSE);";
                stmt.executeUpdate(sql);

                // ResultSet rs = stmt.executeQuery("SELECT \"BookID\" FROM \"Books\" WHERE \"BookID\" =" + bookid + ";");
                // while (rs.next())
                //     System.out.println(rs.getString("BookID"));


                // sql = "DROP TABLE EMPLOYEES";
                //stmt.executeUpdate(sql);
            }
        } catch (SQLException sqlex) {
            while (sqlex != null) {
                System.err.println("SQL error : " + sqlex.getMessage());
                System.err.println("SQL state : " + sqlex.getSQLState());
                System.err.println("Error code: " + sqlex.getErrorCode());
                System.err.println("Cause: " + sqlex.getCause());
                sqlex = sqlex.getNextException();
            }
        }

        System.out.println("Sucess");
    }

    public static void ListLoans(int userid) {


        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/LibaryDB", "postgres", "delllenovo")) {
            try (Statement stmt = con.createStatement()) {
                String sql = "SELECT b.borrowedid, bok.\"Title\" as titel, bor.borrowerfirstname as firstname, bor.borrowerlastname as lastname FROM borrowed b JOIN \"Books\" bok ON b.\"BookID\" = bok.\"BookID\" JOIN borrower bor  ON b.borrowerid = bor.borrowerid  WHERE b.borrowerid =" + userid + " AND b.isreturned = FALSE;";
                // stmt.executeUpdate(sql);

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next())
                    System.out.println(rs.getInt("borrowedid") + " " + rs.getString("titel") + rs.getString("firstname") + rs.getString("lastname"));


                // sql = "DROP TABLE EMPLOYEES";
                //stmt.executeUpdate(sql);
            }
        } catch (SQLException sqlex) {
            while (sqlex != null) {
                System.err.println("SQL error : " + sqlex.getMessage());
                System.err.println("SQL state : " + sqlex.getSQLState());
                System.err.println("Error code: " + sqlex.getErrorCode());
                System.err.println("Cause: " + sqlex.getCause());
                sqlex = sqlex.getNextException();
            }
        }


    }

    public static void ReturnBook(int brid) {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/LibaryDB", "postgres", "delllenovo")) {
            try (Statement stmt = con.createStatement()) {
                String sql = "UPDATE borrowed SET isreturned=TRUE  WHERE borrowedid=" + brid + ";";
                stmt.executeUpdate(sql);
            }

        } catch (SQLException sqlex) {
            while (sqlex != null) {
                System.err.println("SQL error : " + sqlex.getMessage());
                System.err.println("SQL state : " + sqlex.getSQLState());
                System.err.println("Error code: " + sqlex.getErrorCode());
                System.err.println("Cause: " + sqlex.getCause());
                sqlex = sqlex.getNextException();
            }
        }
        System.out.println("Sucess");
    }

    public static void ListUsers() {


        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/LibaryDB", "postgres", "delllenovo")) {
            try (Statement stmt = con.createStatement()) {
                String sql = "SELECT borrowerid, borrowerfirstname, borrowerlastname FROM borrower;";
                // stmt.executeUpdate(sql);

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next())
                    System.out.println(rs.getInt("borrowerid") + " " + rs.getString("borrowerfirstname") + rs.getString("borrowerlastname"));


                // sql = "DROP TABLE EMPLOYEES";
                //stmt.executeUpdate(sql);
            }
        } catch (SQLException sqlex) {
            while (sqlex != null) {
                System.err.println("SQL error : " + sqlex.getMessage());
                System.err.println("SQL state : " + sqlex.getSQLState());
                System.err.println("Error code: " + sqlex.getErrorCode());
                System.err.println("Cause: " + sqlex.getCause());
                sqlex = sqlex.getNextException();
            }
        }


    }

    public static void ListBooks() {


        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/LibaryDB", "postgres", "delllenovo")) {
            try (Statement stmt = con.createStatement()) {
                String sql = "SELECT \"BookID\", \"Title\" FROM \"Books\";";
                // stmt.executeUpdate(sql);

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next())
                    System.out.println(rs.getInt("BookID") + " " + rs.getString("Title"));


                // sql = "DROP TABLE EMPLOYEES";
                //stmt.executeUpdate(sql);
            }
        } catch (SQLException sqlex) {
            while (sqlex != null) {
                System.err.println("SQL error : " + sqlex.getMessage());
                System.err.println("SQL state : " + sqlex.getSQLState());
                System.err.println("Error code: " + sqlex.getErrorCode());
                System.err.println("Cause: " + sqlex.getCause());
                sqlex = sqlex.getNextException();
            }
        }

    }
}