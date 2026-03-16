import java.io.*;
import java.util.*;

public class MP09 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask user for CSV dataset path
        System.out.print("Enter CSV file path: ");
        String path = scanner.nextLine();

        int total = 0;
        int pass = 0;
        int fail = 0;

        try {

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                // Skip non-data rows
                if (!line.startsWith("\"")) continue;

                // Split name (quoted) from other columns
                String[] parts = line.split("\",", 2);
                if (parts.length < 2) continue;

                String[] data = parts[1].split(",");

                total++;

                String result = data[6].trim().toUpperCase();

                if (result.equals("PASS")) pass++;
                if (result.equals("FAIL")) fail++;
            }

            br.close();

            System.out.println("\nDataset Statistics");
            System.out.println("--------------------");
            System.out.println("Total Records: " + total);
            System.out.println("PASS: " + pass);
            System.out.println("FAIL: " + fail);

        } catch (Exception e) {
            System.out.println("Error reading dataset.");
        }

        scanner.close();
    }
}
