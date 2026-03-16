import java.io.*;
import java.util.*;

public class MP08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask user for CSV dataset path
        System.out.print("Enter CSV file path: ");
        String path = scanner.nextLine();

        // Ask for keyword to filter
        System.out.print("Enter keyword to filter: ");
        String keyword = scanner.nextLine().toLowerCase();

        ArrayList<Record> records = new ArrayList<>();

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

                String name = parts[0].replace("\"", "");
                String[] data = parts[1].split(",");

                // Create Record object
                Record r = new Record(
                        name,
                        data[0],   // role
                        data[2],   // exam
                        data[3],   // language
                        data[4],   // date
                        data[5],   // score
                        data[6],   // result
                        data[7]    // time
                );

                records.add(r);
            }

            br.close();

            System.out.println("\nFiltered Records:\n");

            int count = 0;

            // Filter by keyword in exam field
            for (Record r : records) {
                if (r.exam.toLowerCase().contains(keyword)) {
                    System.out.println(r.name + " | " + r.exam + " | " + r.result);
                    count++;
                }
            }

            System.out.println("\nTotal Matches: " + count);

        } catch (Exception e) {
            System.out.println("Error reading dataset.");
        }

        scanner.close();
    }
}
