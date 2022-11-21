package Server.ServerQuestionLogic;

import Server.Question;

public class QuestionRound {
    Question question;
    int result;

    QuestionRound(Question question){
        this.question = question;
    }

    public void checkResult(int answerIndex){
        if (answerIndex == question.getCorrectAnswerindex()){
            setResult(1);
        }
        else {
            setResult(-1);
        }
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}

