import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket client;
    private BufferedReader lineReader;
    private PrintWriter outputWriter;

    public void start(int port) {
        try {
            client = new Socket("localhost", port);
            lineReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outputWriter = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String messageTrade(String msg) {
        outputWriter.println(msg);
        try {
            return lineReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No response";
    }

    public void stopConnection(){
        try {
            outputWriter.close();
            lineReader.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start(8888);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            while (true){
                System.out.print("Enter string: ");
                String inp = br.readLine();
                System.out.println(client.messageTrade(inp));
                if(inp.equals("exit")){
                    client.stopConnection();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
