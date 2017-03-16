import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by trixi on 2017.03.16..
 */
public class Cliens {

    public static void main(String[] args) {
    }

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Socket socket;
    private ClientGui clientGui;
    private String server, username;
    private int port;
    private Message message;

    // Constructor called by console mode
    public Cliens(String server, int port, String username) {
        this.server = server;
        this.port = port;
        this.username = username;
    }

    // Constructor called by gui mode
    public Cliens(String server, int port, String username, ClientGui clientGui) {
        this.server = server;
        this.port = port;
        this.username = username;
        this.clientGui = clientGui;
    }

    public boolean setupNetworking() {
        try {
            Socket socket = new Socket(server, port);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void sendMessageToServer() {
        try {
            outputStream.writeObject(Message message);
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




