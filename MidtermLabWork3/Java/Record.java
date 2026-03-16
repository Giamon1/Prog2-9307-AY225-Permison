// Record class represents one row in the dataset
public class Record {

    String name;
    String role;
    String exam;
    String language;
    String date;
    String score;
    String result;
    String time;

    // Constructor initializes all fields
    public Record(String name, String role, String exam, String language,
                  String date, String score, String result, String time) {
        this.name = name;
        this.role = role;
        this.exam = exam;
        this.language = language;
        this.date = date;
        this.score = score;
        this.result = result;
        this.time = time;
    }
}
