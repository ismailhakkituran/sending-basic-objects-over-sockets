import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9991);
        System.out.println("Connected!");

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        Person person = new Person();
        person.setHeight(190);
        person.setName("ismail hakki turan");
        person.setAge(32);

        System.out.println("Sending an object over the Socket");
        objectOutputStream.writeObject(person);

        System.out.println("Closing socket and terminating program.");
        socket.close();
    }
}