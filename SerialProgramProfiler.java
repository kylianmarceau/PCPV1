import java.util.*;
import java.io.*;

public class SerialProgramProfiler {

    static List<Integer> GRID_SIZE = new Arrays.asList(50, 100, 150, 200);
    static List<double> DENSITIES = new Arrays.asList(0.05, 0.10, 0.20);
    static List<Integer> SEEDS = new Arrays.asList(1, 2, 3);

    static String outputFile = "serial_profile.txt";

    public static void main(String[] args) {
        Scanner scanner = null;
        FileWriter fileWriter = null;

        try{
            fileWriter = new FileWriter(outputFile);
            fileWriter.write("gridSize, Density, Seed, time_ms\n");

            
        }
    }
}
