import java.io.*;
import java.util.*;

public class MP10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask user for CSV dataset path
        System.out.print("Enter CSV file path: ");
        String path = scanner.nextLine();

        HashSet<String> seen = new HashSet<>();
        int duplicates = 0;

        try {

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                // Skip non-data rows
                if (!line.startsWith("\"")) continue;

                // Detect duplicates
                if (seen.contains(line)) {
                    System.out.println("Duplicate Record: " + line);
                    duplicates++;
                } else {
                    seen.add(line);
                }
            }

            br.close();

            System.out.println("\nTotal Duplicates: " + duplicates);

        } catch (Exception e) {
            System.out.println("Error reading dataset.");
        }

        scanner.close();
    }
}
