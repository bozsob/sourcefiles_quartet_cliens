import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by trixi on 2017.03.16..
 */
public class Cliens {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.150.190", 8312);
            String message = "";
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());
            //System.out.println("data from server:   " + dataInput.readUTF());
            while (true) {
                String dataFromServer = dataInput.readUTF();
                System.out.println("data from server:   " + dataFromServer);

                Scanner sc = new Scanner(System.in);
                message = sc.nextLine();
                dataOutput.writeUTF(message);
            }
            //dataOutput.writeUTF("hello");


        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try {
            Socket socket = new Socket("192.168.150.190", 8312);

            InputStream in = socket.getInputStream();
            ObjectInputStream input = new ObjectInputStream(in);

            OutputStream out = socket.getOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(out);

            input.readObject();
            output.writeObject("hello_outputstream");



        } catch (Exception e) {
            e.printStackTrace();
        }
        */

    }

}
