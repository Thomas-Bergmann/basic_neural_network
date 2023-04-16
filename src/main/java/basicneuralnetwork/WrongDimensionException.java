package basicneuralnetwork;

import java.util.Arrays;

/**
 * Created by KimFeichtinger on 28.04.18.
 */
public class WrongDimensionException extends RuntimeException {

    private static final long serialVersionUID = 7161116748701896260L;

	public WrongDimensionException(int actual, int expected, String layer){
        super("Expected " + expected + " value(s) for " + layer + "-layer but got " + actual + ".");
    }

    public WrongDimensionException(int[] actual, int[] expected){
        super("The dimensions of these two neural networks don't match: " + Arrays.toString(actual) + ", " + Arrays.toString(expected));
    }

    public WrongDimensionException(){
        super("Dimensions don't match.");
    }

}
