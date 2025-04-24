import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.jar.JarEntry;

public class Main {

    static void printfile (String file) {
        BufferedReader reader = null;
        String line ="";

        try {
            reader = new BufferedReader(new FileReader(file));
            int i=0;
            ArrayList<gameSales> gameArray = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                /*
                for (String index : row) {
                    System.out.printf("-%10s", index);
                }
                */
                // System.out.println();
                gameSales abc = new gameSales(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], row[10]);
                // System.out.println(abc.getName() + "  " + abc.getPlatform() + "  " +  abc.getYear() + "  " +  abc.getGenre() + "  " +  abc.getPublisher() + "  " +  abc.getNAs() + "  " +  abc.getEUs() + "  " +  abc.getJPs() + "  " +  abc.getOtherSales() + "  " +  abc.getGlobalSale());
                gameArray.add (abc);
            }
            for (int a = 0 ; a< gameArray.size(); a++) {
                System.out.println(gameArray.get(a).getRank() + gameArray.get(a).getName() + gameArray.get(a).getPlatform() + gameArray.get(a).getYear() + gameArray.get(a).getPublisher() + gameArray.get(a).getNAs() + gameArray.get(a).getEUs() + gameArray.get(a).getJPs() + gameArray.get(a).getOtherSales() + gameArray.get(a).getGlobalSale());
            }
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
       printfile("src//videoGamesSales.csv");


    }
}

