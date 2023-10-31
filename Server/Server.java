import java.io.*;
import java.net.*;
import java.util.concurrent.locks.ReentrantLock;

public class Server {
    public static void main(String[] args)  {

        try {
            ServerSocket serverSocket = new ServerSocket(9991);
            System.out.println("Merhaba");
            while (true) {

                Socket clientSocket = serverSocket.accept();

                InputStream inputStream = clientSocket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Person incomingPerson = (Person) objectInputStream.readObject();

                System.out.println("Gelen kisi nesnesinin adi: " + incomingPerson.getName());
                System.out.println("Gelen kisi nesnesinin boyu: "+incomingPerson.getHeight());
                System.out.println("Gelen kisi nesnesinin yasi: "+incomingPerson.getAge());

                clientSocket.close();
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}