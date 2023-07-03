package rpg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Singleton object to be used where ever user input is required
 * @author Sam
 *
 */
public final class UserInput {
    
    private static UserInput INSTANCE;
    
    public static UserInput getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserInput();
        }
        
        return INSTANCE;
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
