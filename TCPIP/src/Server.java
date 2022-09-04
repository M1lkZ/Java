import commands.CommandHandler;

import java.net.*;
import java.io.*;

public class Server {
    private Socket client;
    private ServerSocket serverSocket;
    private BufferedReader lineReader;
    private PrintWriter outputWriter;

    public void start(int port){
        try {
            CommandHandler handler = new CommandHandler();
            serverSocket = new ServerSocket(port);
            client = serverSocket.accept();
            lineReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outputWriter = new PrintWriter(client.getOutputStream(), true);
            while(true){
                String str = lineReader.readLine();
                if(str.equals("exit")){
                    break;
                }
                String action = handler.handle(str);
                outputWriter.println(action);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start(8888);
    }
}
