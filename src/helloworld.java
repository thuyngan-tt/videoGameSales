public class helloworld {
    static class students {
        String name;
        int old;
        String gender;

        students(String name, int old, String gender){
            this.name = name;
            this.old = old;
            this.gender = gender;
        }
    }

    public static void main (String[] args) {
        System.out.println("Hello, world");

        students Ngan = new students("Ngan", 29, "female");

    }
}
