package Server;

import java.util.ArrayList;
import java.util.HashMap;

public class Categories
{
    // Varje runda kommer att innehålla 6 kategorier

    // {Sport: [Q1, Q2, Q3, Q4, Q5, ...]}

    private HashMap<String, ArrayList<Question>> categoriesMap;

    public Categories(){
        this.categoriesMap = createCategoriesHashmap();
    }

    public HashMap<String, ArrayList<Question>> getCategoriesMap(){
        return categoriesMap;
    }
    public HashMap<String, ArrayList<Question>> createCategoriesHashmap() {

        return categoriesMap;
    }
}
