import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
    public static void writeCsv(String filePath, ArrayList<gameSales> gameList) {
        File csvFile = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            for (gameSales row : gameList) {
                writer.write(row.toString());
                writer.newLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
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

        @Override
        public String toString() {
            return rank + "," + name + "," + platform + "," + year + "," + genre + "," + year + ","
                    + publisher + "," + NAs + "," + EUs + "," + JPs + "," + otherSales + "," + globalSale;
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
            if (Double.compare(other.globalSale, this.globalSale) != 0) {
                    return Double.compare(this.globalSale, other.globalSale);
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your csv file location then choose one of options:\n 1: Print file\n 2: Sort data base on globalSale");
        System.out.println("Your csv file location: ");
        String locationFile = sc.nextLine();
        int enter = 0;
        ArrayList<gameSales> gameList = readFileIntoArraylist(locationFile);
        do {
            System.out.println(" Choose one of options:\n 1: Print file\n 2: Sort data base on globalSale\n3: Search globalSale base on name of video game");
            int x = sc.nextInt();
            if (x == 1) {
                BufferedReader reader = null;
                String line = "";

                try {
                    reader = new BufferedReader(new FileReader(locationFile));
                    while ((line = reader.readLine()) != null) {
                        String[] row = line.split(",");
                        for (String index : row) {
                            System.out.printf("-%10s", index);
                        }
                        System.out.println();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if (x == 2) {
                System.out.println(" Enter 1 if you want to sort in ascending order\n Or enter 2 if you want to sort in reverse order");
                int y = sc.nextInt();
                if (y == 1) {
                    Collections.sort(gameList);
                    for (int a = 0; a < gameList.size(); a++) {
                        System.out.println(gameList.get(a).getRank() + " " + gameList.get(a).getName() + " " + gameList.get(a).getGlobalSale());
                    }
                    System.out.println("Do you want to save these data\n Enter 1 to save \n or enter 0 to exit");
                    int z = sc.nextInt();
                    if (z == 1) {
                        Scanner sb = new Scanner(System.in);
                        System.out.println("Enter the location where you want to save them");
                        String filePath = sb.nextLine();
                        writeCsv(filePath, gameList);
                        System.out.println("CSV file created successfully: " + filePath);
                    }
                    else if (z == 0) {
                        break;
                    }
                }
                else if (y == 2) {
                    Collections.sort(gameList, Collections.reverseOrder());
                    for (int a = 0; a < gameList.size(); a++) {
                        System.out.println(gameList.get(a).getRank() + " " + gameList.get(a).getName() + " " + gameList.get(a).getGlobalSale());
                    }
                    System.out.println("Do you want to save these data\n Enter 1 to save \n or enter 0 to exit");
                    int z = sc.nextInt();
                    if (z == 1) {
                        Scanner sb = new Scanner(System.in);
                        System.out.println("Enter the location where you want to save them");
                        String filePath = sb.nextLine();;
                        writeCsv(filePath, gameList);
                        System.out.println("CSV file created successfully: " + filePath);
                    }
                    else if (z == 0) {
                        break;
                    }
                }
            }
            else if (x == 3) {
                Scanner sb = new Scanner(System.in);
                System.out.println(" Enter name of video game then we will return its globalSale");
                String gameName = sb.nextLine();
                for (int i=0; i<gameList.size(); i++) {
                    if (gameList.get(i).getName().equals(gameName)) {
                        System.out.println("name: " + gameName + "globalSale: " + " " + gameList.get(i).getGlobalSale());
                    }
                }
            }
            System.out.println("Enter 1 to continue\n or enter 0 to exit program");
            enter = sc.nextInt();
        } while (enter == 1);
    }
}



