package Server.ServerQuestionLogic;

import Server.Categories;

import java.util.ArrayList;

public class CategoryRound {

    int questionsPerCategory = 2;
    Categories categories = new Categories();
    ArrayList<QuestionRound> rounds = new ArrayList<>();
    
    CategoryRound(String category){
        for (int i = 0; i < questionsPerCategory; i++) {
            QuestionRound round = new QuestionRound(categories.getCategoriesMap().get(category).get(i));
            rounds.add(round);
        }
    }

}
