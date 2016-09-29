import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        String clientInput;
        String capitalizedInput;

        ServerSocket welcomeSocket = new ServerSocket(8044);

        Socket connectionSocket = welcomeSocket.accept();
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

        while (true) {
            clientInput = inFromClient.readLine();
            System.out.println(clientInput);
            capitalizedInput = clientInput.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedInput);
        }
    }
}
