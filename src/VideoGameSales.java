import java.io.*;
import java.util.ArrayList;


public class VideoGameSales {

    static ArrayList readFileIntoArraylist (String file) {
        BufferedReader reader = null;
        String line ="";

        try {
            reader = new BufferedReader(new FileReader(file));
            ArrayList<gameSales> gameArray = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                gameSales abc = new gameSales(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], row[10]);
                gameArray.add (abc);
            }
            return gameArray;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    static class gameSales {
        String rank;
        String name;
        String platform;
        String year;
        String genre;
        String publisher;
        String NAs;
        String EUs;
        String JPs;
        String otherSales;
        String globalSale;

        gameSales(String rank, String name, String platform, String year, String genre, String publisher, String NAs, String EUs, String JPs, String otherSales, String globalSale) {
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

        String getRank() {
            return rank;
        }
        String getName() {
            return name;
        }
        String getPlatform() {
            return platform;
        }
        String getYear() {
            return year;
        }
        String getGenre() {
            return genre;
        }
        String getPublisher() {
            return publisher;
        }
        String getNAs() {
            return NAs;
        }
        String getEUs() {
            return EUs;
        }
        String getJPs() {
            return JPs;
        }
        String getOtherSales() {
            return otherSales;
        }
        String getGlobalSale() {
            return globalSale;
        }
    }

    public static void main (String[] args) {

        ArrayList<gameSales> gameList = readFileIntoArraylist("src//videoGamesSales.csv");
        for (int a = 0 ; a< gameList.size(); a++) {
            System.out.println(gameList.get(a).getRank() + gameList.get(a).getName() + gameList.get(a).getPlatform() + gameList.get(a).getYear() + gameList.get(a).getGenre() + gameList.get(a).getPublisher() + gameList.get(a).getNAs() + gameList.get(a).getEUs() + gameList.get(a).getJPs() + gameList.get(a).getOtherSales() + gameList.get(a).getGlobalSale());
        }
    }
}

