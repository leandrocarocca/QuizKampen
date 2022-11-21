package Server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Question implements Serializable
{
    String description;
    int correctAnswerindex;
    String[] answers;

    Question(String d, String[] a, int c){
        this.description = d;
        this.answers = a;
        this.correctAnswerindex = c;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getCorrectAnswerindex()
    {
        return correctAnswerindex;
    }

    public void setCorrectAnswerindex(int correctAnswerindex)
    {
        this.correctAnswerindex = correctAnswerindex;
    }

    public String[] getAnswers()
    {
        return answers;
    }

    public void setAnswers(String[] answers)
    {
        this.answers = answers;
    }

    @Override
    public String toString()
    {
        return "Question{" +
                "description='" + description + '\'' +
                ", correctAnswerindex=" + correctAnswerindex +
                ", answers=" + Arrays.toString(answers) +
                '}';
    }
}
