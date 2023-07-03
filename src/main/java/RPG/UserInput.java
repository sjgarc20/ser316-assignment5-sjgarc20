package rpg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Singleton object to be used where ever user input is required.
 * @author Sam
 *
 */
public final class UserInput {
    
    private static UserInput INSTANCE;
    private String fileInput = "";
    
    private UserInput() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                fileInput = fileInput + line;
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    /**
     * Checks if instance already exits, creates instance if it doesn't exist.
     * @return instance of UserInput
     */
    public static UserInput getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserInput();
        }
        
        return INSTANCE;
    }
    
    /**
     * Gets console input from user.
     * @return integer input by user
     * @throws IOException if user puts in anything that can't be parsed for an int
     */
    public int getSelection() throws IOException {
        String input = fileInput.substring(0,1);
        fileInput = fileInput.substring(1);
        
        int i = 0;
        try {
            System.out.println();
            Thread.sleep(200);
            System.out.println("You entered: " + input);
            System.out.println();
            Thread.sleep(800);
            i = Integer.parseInt(input);
            
        } catch (NumberFormatException e) {
            System.err.println("Invalid selection");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return i;
    }
}
