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


    public void setupNetworking() {
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





