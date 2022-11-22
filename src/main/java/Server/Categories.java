package Server;

import java.util.ArrayList;
import java.util.HashMap;

public class Categories
{
    // Varje runda kommer att innehålla 6 kategorier


    // {Sport: [Q1, Q2, Q3, Q4, Q5, ...]}

    Question q = new Question("Vem är bäst", new String[] {"Jani", "Frida", "Valeria", "Zoe"}, 1);
    Question q2 = new Question("Vem är bäst", new String[] {"Jani", "Frida", "Valeria", "Zoe"}, 1);
    ArrayList<Question> questionsArray = new ArrayList<>();
    public HashMap<String, ArrayList<Question>> categoriesMap = new HashMap<>();
    public Categories(){
        questionsArray.add(q);
        questionsArray.add(q2);
        categoriesMap.put("Sport", questionsArray);
    }

    public HashMap<String, ArrayList<Question>> getCategoriesMap(){
        return categoriesMap;
    }


}
