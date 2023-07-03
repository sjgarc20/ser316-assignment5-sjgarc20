package RPG;

import java.util.Random;

/**
 * RNG singleton, made with seed to make generation predictable.
 * This will allow for an automated playthrough for grading purposes
 * @author Sam
 *
 */
public final class RandomNumberGenerator {
    
    private static long SEED = 1234567890;
    private static RandomNumberGenerator INSTANCE;
    private static Random generator;
    
    /**
     * Checks if instance already exists, and creates a new instance.
     * if it doesn't
     * @return instance of RandomNumberGenerator
     */
    public static RandomNumberGenerator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RandomNumberGenerator();
            generator = new Random(SEED);
        }
        
        return INSTANCE;
    }
    
    public static double getRandomDouble() {
        return generator.nextDouble();
    }
    
    public static int getRandomIntRange(int lowerBound, int upperBound) {
        return generator.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}
