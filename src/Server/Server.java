package Server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server extends Thread
{
    //Protokoll p = new Protokoll();

    Socket s;

    public Server(Socket s){
        this.s = s;
    }

    public void run(){

        try(
            ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        ){
            String message = input.readLine();
            System.out.println(message);
            String[] s = {"Jani", "Frida", "Valeria", "Zoe"};
            Question q = new Question("Vem är bäst?", s, 1);
            output.writeObject(q);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {

    }

}
