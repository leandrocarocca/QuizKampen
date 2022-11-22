package Server.ServerQuestionLogic;

public class Match {
    private int player1Score = 0;
    private int player2Score = 0;
    int categoryAmount = 2;

    boolean checkRemainingCategories(){
        return categoryAmount < 0;
    }

    void createCategoryRound(String category){
        new CategoryRound(category);
    }

    void scoreUpdater(boolean player1scored, boolean player2scored){
        if (player1scored) {
            setPlayer1Score(getPlayer1Score() + 1);
        }
        if (player2scored) {
            setPlayer2Score(getPlayer2Score() + 1);
        }
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }
}
