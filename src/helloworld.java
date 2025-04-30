
import java.util.*;
import java.util.Comparator;

public class helloworld {
    static class circle {
        String name;
        double radius;
        int price;

        circle(String name, double radius, int price) {
            this.name = name;
            this.radius = radius;
            this.price = price;
        }

        String getName() {
            return name;
        }

        double getRadius() {
            return radius;
        }

        int getPrice() {
            return price;
        }

        public static Comparator<circle> compareName = new Comparator<circle>() {
            public int compare(circle s1, circle s2) {
                String name1 = s1.getName();
                String name2 = s2.getName();

                // Returning in ascending order
                return name1.compareTo(name2);
            }
        };

        // Comparator for sorting the list by roll no
        public static Comparator<circle> compareRadius = new Comparator<circle>() {
            public int compare(circle s1, circle s2) {

                double radius1 = s1.getRadius();
                double radius2 = s2.getRadius();
                int value1 = (int)radius1;
                int value2 = (int)radius2;

                // For ascending order
                return value2 - value1 ;
            }
        };

        @Override
        public String toString() {
            return "[ radius=" + radius + ", name=" + name + ", price=" + price + "]";
        }
    }

    public static void main(String[] args) {

        ArrayList<circle> abc = new ArrayList<circle>();
        abc.add(new circle("a", 5.3, 23));
        abc.add(new circle("b", 4.5, 56));
        abc.add(new circle("c", 7.8, 13));

        System.out.println("Circle Name Sorting:");
        Collections.reverse(abc);
        for (circle str : abc) {
            System.out.println(str);
        }

        System.out.println("Radius Sorting:");
        Collections.sort(abc, circle.compareRadius);
        for (circle str : abc) {
            System.out.println(str);
        }
    }
}
