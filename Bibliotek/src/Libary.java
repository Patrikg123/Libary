import java.sql.*;
import java.io.*;

/**
 * Created by Elev1 on 2016-07-07.
 */
public class Libary {

    public static void main(String[] args)throws IOException{

        System.out.println("Log in by selecting which user you are. Please enter your user number");
        BookActions.ListUsers();










                InputStreamReader ip = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(ip);



                String s = br.readLine();
                int userID = Integer.parseInt(s);


        while(true) {


            System.out.println("What do you want to do? 1 Borrow a bok, 2 Return a book, 3 List my loans 4 Quit");

            String selection = br.readLine();
            int select = Integer.parseInt(selection);

            if (select == 1) {

                System.out.println("Choose a book to borrow");
                BookActions.ListBooks();
                String t = br.readLine();
                int bookID = Integer.parseInt(t);

                BookActions.BorrowBook(bookID, userID);

            } else if (select == 2) {
                System.out.println("Choose a book to return");
                BookActions.ListLoans(userID);
                String u = br.readLine();
                int bookToReturn = Integer.parseInt(u);
                BookActions.ReturnBook(bookToReturn);
            } else if (select == 3)
                BookActions.ListLoans(userID);

            else if (select == 4)
                break;

            else
                System.out.println("Wrong selection try again!");

        }





    }
}
