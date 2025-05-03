import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Field;


public class abc {

    /*
    public static void writeCsv(String filePath, ArrayList<students> detail) {
        File csvFile = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            for (String[] row : data) {
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < row.length; i++) {
                    line.append(escapeSpecialCharacters(row[i]));
                    if (i < row.length - 1) {
                        line.append(",");
                    }
                }
                writer.write(line.toString());
                writer.newLine();
            }
        } */
    public static void writeCsv(String filePath, ArrayList<students> detail) {
        File csvFile = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            for (students row : detail) {
               // writer.write(row.toString());
                StringBuilder line = new StringBuilder();
                line.append(students.loopThroughAttributes(row));
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IllegalAccessException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    static  class students {
        String name;
        String age;
        String gender;
        String height;

        students (String name, String age, String gender, String height) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.height = height;
        }

        public static Object loopThroughAttributes(Object obj) throws IllegalAccessException {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            StringBuilder line = new StringBuilder();
            for (Field row : fields) {
                row.setAccessible(true);
                line.append(row.get(obj));
            }
            return obj;
        }

        @Override
        public String toString() {
            return name + "," + age + "," + gender + "," + height;
        }

        public static int getColumnCount() {
            return students.class.getDeclaredFields().length;
        }

        String getName() {
            return name;
        }
        String getAge() {
            return age;
        }
        String getGender() {
            return gender;
        }
        String getHeight() {
            return height;
        }
    }

    public static void main(String[] args) {
        ArrayList<students> detail = new ArrayList<>();
        detail.add(new students("Ngan", "15", "female", "1.52"));
        detail.add(new students("Chinh", "25", "male", "1.67"));
        detail.add(new students("Hien", "18", "female", "1.60"));
        detail.add(new students("Thanh", "23", "male", "1.72"));
        detail.add(new students("Yen", "30", "female", "1.62"));

        String filePath = "C:\\Users\\admin\\Coding_work\\videoGameSales\\out\\output.csv";
        writeCsv(filePath, detail);
        System.out.println("CSV file created successfully: " + filePath);
    }
}