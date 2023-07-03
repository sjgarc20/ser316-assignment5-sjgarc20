package rpg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter something: ");
        try {
            System.out.println(getSelection());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static int getSelection() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int i = 0;
        try {
            i = Integer.parseInt(input);
        } catch(NumberFormatException e) {
            System.err.println("Invalid selection");
        }
        return i;
    }
}
