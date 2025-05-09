import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Scanner;


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
                writer.write(row.toString());
                writer.newLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    static class students implements Comparable<students> {
        String name;
        String age;
        String gender;
        double height;

        students (String name, String age, String gender, double height) {
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
        double getHeight() {
            return height;
        }
        public int compareTo(students other) {
            // Compare by grade (descending order)
            if (Double.compare(other.height, this.height) != 0) {
                return Double.compare(this.height, other.height);
            }
            return 0;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<students> detail = new ArrayList<>();
        detail.add(new students("Ngan", "15", "female", 1.52));
        detail.add(new students("Lam", "25", "male", 1.67));
        detail.add(new students("Hien", "18", "female", 1.60));
        detail.add(new students("Thanh", "23", "male", 1.72));
        detail.add(new students("Yen", "30", "female", 1.62));

        System.out.println(" Enter 1 if you want to sort in ascending order\n Or enter 2 if you want to sort in reverse order");
        int y = sc.nextInt();
        if (y == 2) {
            Collections.sort(detail, Collections.reverseOrder());
            for (int a = 0; a < detail.size(); a++) {
                System.out.println(detail.get(a).getName() + " " + detail.get(a).getHeight());
            }
            System.out.println("Do you want to save these data\n Enter 1 to save \n or enter 0 to exit");
            int z = sc.nextInt();
            if (z == 1) {
                //System.out.println("Enter the location where you want to save them");
                String filePath = "N:\\Coding\\videoGameSales\\out\\output1.csv";
                writeCsv(filePath, detail);
                System.out.println("CSV file created successfully: " + filePath);
            }
        }
        /*
        String filePath = "C:\\Users\\admin\\Coding_work\\videoGameSales\\out\\output.csv";
        writeCsv(filePath, detail);
        System.out.println("CSV file created successfully: " + filePath);
        */

    }
}