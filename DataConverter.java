import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataConverter {

    public static void main(String[] args) {
        String inputFile = "data_file_1.txt";
        String outputFile = "data_file_2.txt";

        try {
            convertData(inputFile, outputFile);
            System.out.println("Conversion successful!");
        } catch (IOException e) {
            System.err.println("Error converting data: " + e.getMessage());
        }
    }

    private static void convertData(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",\\s*");
                if (parts.length == 3) {
                    // Assuming the first and third columns need to be concatenated
                    String convertedLine = parts[0] + " " + parts[2];
                    writer.println(convertedLine);
                } else {
                    System.err.println("Invalid input format: " + line);
                }
            }
        }
    }
}
