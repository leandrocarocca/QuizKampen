package Server;

import Server.ServerQuestionLogic.CategoryRound;
import Server.ServerQuestionLogic.Match;
import Server.ServerQuestionLogic.QuestionRound;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Server extends Thread
{
    //Protokoll p = new Protokoll();
    Socket s;

    public Server(Socket s){
        this.s = s;
    }

    /*public void run(){

        try(
            ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(s.getInputStream())){
            Match match = new Match();

            while (true){
                if (match.checkRemainingCategories()){
                    //output.writeObject(match.getCategoryAmount());
                    output.writeObject("Choose category");
                    String category = String.valueOf(input);
                    System.out.println(category);

                    CategoryRound categoryRound = match.createCategoryRound(category);
                    //output.writeObject(categoryRound.getQuestionsPerCategory());
                    ArrayList<QuestionRound> rounds = categoryRound.getRounds();

                    for (QuestionRound round : rounds) {
                        output.writeObject(round);
                        QuestionRound returnRound = (QuestionRound) input.readObject();
                        returnRound.checkResult();

                        int successResult  = returnRound.getResult();
                        boolean success;
                        if (successResult > 0){
                            success = true;
                        }else if (successResult < 0){
                            success = false;
                        }else {
                            System.out.println("BIG ERROR");
                            break;
                        }
                        match.scoreUpdater(success, false);
                    }
                } else {
                    System.out.println("Player 1 Score: " + match.getPlayer1Score());
                    System.out.println("Player 2 Score: " + match.getPlayer2Score());
                    break;
                }
            }



            /*String message = input.readLine();
            System.out.println(message);
            String[] s = {"Jani", "Frida", "Valeria", "Zoe"};
            Question q = new Question("Vem är bäst?", s, 1);
            output.writeObject(q);

        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)
    {

    }
*/
}
