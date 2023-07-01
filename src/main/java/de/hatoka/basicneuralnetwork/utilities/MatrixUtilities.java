package de.hatoka.basicneuralnetwork.utilities;

import org.ejml.simple.SimpleMatrix;

import de.hatoka.basicneuralnetwork.WrongDimensionException;

import java.util.Random;

/**
 * Created by KimFeichtinger on 07.03.18.
 */
public class MatrixUtilities
{

    /**
     * @param array values for matrix
     * @return a matrix from given 2D array
     */
    public static SimpleMatrix arrayToMatrix(double[] array)
    {
        double[][] input = { array };
        return new SimpleMatrix(input).transpose();
    }

    /**
     * @param matrix source matrix
     * @return an 2D array from given SimpleMatrix 
     */
    public static double[][] matrixTo2DArray(SimpleMatrix matrix)
    {
        double[][] result = new double[matrix.numRows()][matrix.numCols()];

        for (int j = 0; j < result.length; j++)
        {
            for (int k = 0; k < result[0].length; k++)
            {
                result[j][k] = matrix.get(j, k);
            }
        }
        return result;
    }

    /**
     * @param matrix source matrix
     * @param column selected column
     * @return one specific column of a matrix as an 1D array
     */
    public static double[] getColumnFromMatrixAsArray(SimpleMatrix matrix, int column)
    {
        double[] result = new double[matrix.numRows()];

        for (int i = 0; i < result.length; i++)
        {
            result[i] = matrix.get(i, column);
        }
        return result;
    }

    /**
     * @param matrixA matrix one
     * @param matrixB matrix two
     * @param probability that value from matrixB is used (executed for each element of the new matrix)
     * @return a new matrix merged from two given ones
     */
    public static SimpleMatrix mergeMatrices(SimpleMatrix matrixA, SimpleMatrix matrixB, double probability)
    {
        if (matrixA.numCols() != matrixB.numCols() || matrixA.numRows() != matrixB.numRows())
        {
            throw new WrongDimensionException();
        }
        Random random = new Random();
        SimpleMatrix result = new SimpleMatrix(matrixA.numRows(), matrixA.numCols());

        for (int i = 0; i < matrixA.getNumElements(); i++)
        {
            // %-chance of replacing this value with the one from the input nn
            result.set(i, random.nextDouble() > probability ? matrixA.get(i) : matrixB.get(i));
        }
        return result;
    }
}
