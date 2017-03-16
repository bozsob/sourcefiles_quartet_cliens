import java.io.*;
import java.net.Socket;

/**
 * Created by trixi on 2017.03.16..
 */
public class Client {

    public static void main(String[] args) {

        Message m = new Message("hello");

        Client c = new Client("127.0.0.1", 8000, "Trixi");
        c.setupNetworking();
        c.sendMessageToServer(m);
    }

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Socket socket;
    private String server, username;
    private int port;
    private Message message;


    public Client(String server, int port, String username) {
        this.server = server;
        this.port = port;
        this.username = username;
    }

    public boolean setupNetworking() {
        try {
            Socket socket = new Socket(server, port);
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void sendMessageToServer(Message message) {
        try {
            outputStream.writeObject(message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessageFromServer() {
        try {
            inputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}




