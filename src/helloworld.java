import java.lang.reflect.Field;

public class helloworld {

    public static void main(String[] args) throws IllegalAccessException {
        MyClass obj = new MyClass("example", "42", "45" );
        loopThroughAttributes(obj);
    }

    public static void loopThroughAttributes(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // Allow access to private fields
            String name = field.getName();
            Object value = field.get(obj);
            System.out.println("Attribute: " + name + ", Value: " + value);
        }
    }
}

class MyClass {
    String text;
    String number;
    String age;


    public MyClass(String text, String number, String age) {
        this.text = text;
        this.number = number;
        this.age = age;
    }
}
