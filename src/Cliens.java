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
        }

        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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

    /* public void setupNetwork() {
        String messageToServer = "";
        try {
            Socket socket = new Socket("192.168.150.190", 8312);
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            while(true) {
                input.readObject();

                Scanner sc = new Scanner(System.in);
                messageToServer = sc.nextLine();
                output.writeObject(messageToServer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

}




        /* DataOutputStream dataOutput = null;
        DataInputStream dataInput = null;
        try {
            Socket socket = new Socket("192.168.150.190", 8312);
            dataOutput = new DataOutputStream(socket.getOutputStream());
            dataInput = new DataInputStream(socket.getInputStream());
            //System.out.println("data from server:   " + dataInput.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                String dataFromServer = dataInput.readUTF();
                System.out.println("data from server:   " + dataFromServer);
                Scanner sc = new Scanner(System.in);
                messageToServer = sc.nextLine();
                dataOutput.writeUTF(messageToServer);

            } catch (IOException e) {
                e.printStackTrace();
            }

            //dataOutput.writeUTF("hello");

        }
        */





