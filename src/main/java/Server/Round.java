package Server;

    public class Round {
        Question question;
        int result;

        Round(Question question){
            this.question = question;
        }

        public void checkResult(int answerIndex){
            if (answerIndex == question.correctAnswerindex){
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

