package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread {
    public ServerListener(){
            int port = 55553;
            try (ServerSocket ss = new ServerSocket(port);){
                while(true) {
                    Socket s = ss.accept();
                    Server serv = new Server(s);
                    serv.start();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static void main(String[] args) {
            ServerListener sl = new ServerListener();
        }
    }
