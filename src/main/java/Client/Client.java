package Client;

import Server.Question;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class Client
{
    public Client() throws IOException
    {
        int port = 55559;
        try(
                Socket socket = new Socket("127.0.0.1",port);
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        ){

        }
                 /*
            String name = JOptionPane.showInputDialog("Skriv ditt namn: ");
            output.println(name);
            Object object = input.readObject();
            Question question = (Question) object;
            String description = question.getDescription();
            String[] answers = question.getAnswers();
            int correctAnswerIndex = question.getCorrectAnswerindex();
            System.out.println();
            JOptionPane.showMessageDialog(null, "Frågan är: " + description + "\n" + "Svarsalternativ är: " + Arrays.toString(answers));
            String inputString = JOptionPane.showInputDialog("Ange rätt svar: ");
            if(Integer.parseInt(inputString) == correctAnswerIndex){
                JOptionPane.showMessageDialog(null, "Bra, rätt svar.");
            }
            else {
                JOptionPane.showMessageDialog(null, "FEL! Rätt svar är: " + answers[correctAnswerIndex]);
            }


        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        }


        */
    }

    public static void main(String[] args) throws IOException
    {
        Client c = new Client();
    }

}


