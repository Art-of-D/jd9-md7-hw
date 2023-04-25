package http_tools_for_image;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private int code;
    private Scanner in;
    public void cli() throws Exception {
        in = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        try {
            code = in.nextInt();
            try{
                new HttpStatusImageDownloader().HttpStatusImageDownloader(code);
                System.out.println("The image was dowloaded.");
            } catch (Exception e ){
                System.out.println(String.format("There is not image for HTTP status %d", code));
            }
        } catch (NoSuchElementException e){
            System.out.println("Please enter valid number");
        }
    }
}
