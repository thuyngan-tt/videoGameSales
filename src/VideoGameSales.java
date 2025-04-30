import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VideoGameSales {

    static ArrayList readFileIntoArraylist(String file) throws IOException {
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            ArrayList<gameSales> gameArray = new ArrayList<>();
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                boolean checkNA = true;
                if (row[3].equals("N/A"))
                    checkNA = false;
                if (i != 0 && checkNA) {
                    gameSales abc = new gameSales(Integer.valueOf(row[0]), row[1], row[2], Integer.valueOf(row[3]), row[4], row[5], Double.valueOf(row[6]), Double.valueOf(row[7]), Double.valueOf(row[8]), Double.valueOf(row[9]), Double.valueOf(row[10]));
                    gameArray.add(abc);
                }
                i = i + 1;
            }
            return gameArray;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    static class gameSales implements Comparable<gameSales> {
        int rank;
        String name;
        String platform;
        int year;
        String genre;
        String publisher;
        double NAs;
        double EUs;
        double JPs;
        double otherSales;
        double globalSale;

        gameSales(int rank, String name, String platform, int year, String genre, String publisher, double NAs, double EUs, double JPs, double otherSales, double globalSale) {
            this.rank = rank;
            this.name = name;
            this.platform = platform;
            this.year = year;
            this.genre = genre;
            this.publisher = publisher;
            this.NAs = NAs;
            this.EUs = EUs;
            this.JPs = JPs;
            this.otherSales = otherSales;
            this.globalSale = globalSale;
        }

        int getRank() {
            return rank;
        }

        String getName() {
            return name;
        }

        String getPlatform() {
            return platform;
        }

        int getYear() {
            return year;
        }

        String getGenre() {
            return genre;
        }

        String getPublisher() {
            return publisher;
        }

        double getNAs() {
            return NAs;
        }
        double getEUs() {
            return EUs;
        }

        double getJPs() {
            return JPs;
        }

        double getOtherSales() {
            return otherSales;
        }

        double getGlobalSale() {
            return globalSale;
        }

        public int compareTo(gameSales other) {
            // Compare by grade (descending order)
            if (Integer.compare(other.rank, this.rank) != 0) {
                return Double.compare(other.rank, this.rank );
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {

        ArrayList<gameSales> gameList = readFileIntoArraylist("src//videoGamesSales.csv");

        Collections.sort(gameList);
        for (int a = 0; a < gameList.size(); a++) {
            System.out.println(gameList.get(a).getRank() + " " + gameList.get(a).getName() + " " + gameList.get(a).getGlobalSale());

        }
    }
}



