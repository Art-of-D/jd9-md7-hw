import http_tools_for_image.HttpImageStatusCli;
import http_tools_for_image.HttpStatusChecker;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new HttpStatusChecker().getStatusImage(101));
        Scanner in = new Scanner(System.in);
        int stop = 1;
        while (stop != 0) {
            new HttpImageStatusCli().cli();
            System.out.println("If you want to exit please enter - 0, another case enter some number.");
            try {
                stop = in.nextInt();
            } catch (NoSuchElementException e){
                System.out.println("Please enter valid number");
            }
        }
    }
}
