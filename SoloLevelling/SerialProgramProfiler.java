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

            for (int i = 0; i < GRID_SIZE.size(); i++){
                int size = GRID_SIZE.get(i);
                for (int j = 0; j < DENSITIES.size(); j++){
                    double density = DENSITIES.get(j);
                    for(int x = 0; x<SEEDS.size(); x++){
                        int seed = SEEDS.get(x);

                        long start = System.nanoTime();
                        DungeonHunter.main(new String[]{
                            String.valueOf(size);
                            String.valueOf(density);
                            String.valueOf(seed);
                        });

                        long end = System.nanoTime();
                        long elapsedMs = (end - start)/1_000_000;
                        fileWriter.write(size + "," + density + "," + seed + "," + elapsedMs + "\n");
                        System.out.printf("Ran %d %.2f %d -> %d ms%n", size, density, seed, elapsedMs);
                    }
                }
            }
            System.out.println("Profiling complete. Results saved to " + OUTPUT_FILE);
        }catch(IOException e){
            e.printSackTrace();
        } finally {
            try {
                if (scanner != null) {
                    scanner.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }()
        }
    }
}
