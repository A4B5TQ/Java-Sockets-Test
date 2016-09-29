import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String argv[]) throws Exception {
        String input;
        String modifiedInput;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("127.0.0.1", 8044);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        input = inFromUser.readLine();

        while (!input.equals("STOP")){
            outToServer.writeBytes(input + '\n');
            modifiedInput = inFromServer.readLine();
            System.out.println(modifiedInput);
            input = inFromUser.readLine();
        }
        clientSocket.close();
    }
}