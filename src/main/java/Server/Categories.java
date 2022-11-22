package Server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Categories
{
    // Varje runda kommer att innehålla 6 kategorier

    // {Sport: [Q1, Q2, Q3, Q4, Q5, ...]}

    public HashMap<String, ArrayList<Question>> categoriesMap;

    public Categories(){
        categoriesMap = createCategoriesHashmap();
    }

    public HashMap<String, ArrayList<Question>> getCategoriesMap(){
        return categoriesMap;
    }

    public HashMap<String, ArrayList<Question>> createCategoriesHashmap() {

        HashMap<String, ArrayList<Question>> categoriesMap = new HashMap<>();

        ArrayList<Question> geography = new ArrayList<>();
        geography.add(new Question("What is the country of origin of the Olympic Games?", new String[]{"Scandinavia", "Greece", "China", "Egypt"}, 1));
        geography.add(new Question("What is the capital city of the Maldives called?", new String[]{"Malé", "Bali", "Jakarta", "Abu Dhabi"}, 0));
        geography.add(new Question("What is the second tallest mountain?", new String[]{"Mount Everest", "K2", "Chomo Lonzo", "Broad Peak"}, 1));
        geography.add(new Question("In which country is the geyser 'Old Faithful' located?", new String[]{"Iceland", "Russia", "Scotland", "United States"}, 3));
        geography.add(new Question("What is the capital city of Australia called?", new String[]{"Sydney", "Canberra", "Melbourne", "Perth"}, 1));
        categoriesMap.put("Geography", geography);

        ArrayList<Question> animals = new ArrayList<>();
        animals.add(new Question("Where are tigers originally from?", new String[]{"Africa", "South America", "Asia", "Europe"}, 2));
        animals.add(new Question("Where can you find emperor penguins?", new String[]{"Arctic", "Australia", "Greenland", "Antarctica"}, 3));
        animals.add(new Question("Which of these animals is the fastest land animal?", new String[]{"Falcon", "Sail Fish", "Turtle", "Cheetah"}, 0));
        animals.add(new Question("One of these animals is the biggest on this planet, which one?", new String[]{"African Elephant", "Blue Whale", "Whale Shark", "Giraffe"}, 1));
        animals.add(new Question("What is a group of hedgehogs called?", new String[]{"Herd", "Skulk", "Bag", "Pickle"}, 3));
        categoriesMap.put("Animals", animals);

        ArrayList<Question> sport = new ArrayList<>();
        sport.add(new Question("Who won the World Football Championship 2002", new String[]{"Germany", "Turkey", "Brazil", "France"}, 2));
        sport.add(new Question("Who has been awarded the Ballon d'or the most?", new String[]{"Cristiano Ronaldo", "Lionel Messi", "Diego Maradona", "Pele"}, 1));
        sport.add(new Question("How many human players does a polo team have", new String[]{"Two", "Six", "Eleven", "Four"}, 3));
        sport.add(new Question("Who headbutted another player in the 2006 world cup?", new String[]{"Wayne Rooney", "Marco Materazzi", "Zinedine Zidane", "Zlatan Ibrahimovic"}, 2));
        sport.add(new Question("Who was the highest paid athlete in 2021?", new String[]{"Connor McGregor", "Lionel Messi", "Roger Federer", "LeBron James"}, 0));
        categoriesMap.put("Sport", sport);

        ArrayList<Question> food = new ArrayList<>();
        food.add(new Question("Which of these spices is the most expensive?", new String[]{"Cardamom", "Saffron", "Pepper", "Vanilla"}, 1));
        food.add(new Question("What food chain has the most locations?", new String[]{"Pizza Hut", "Burger King", "McDonalds", "Subway"}, 3));
        food.add(new Question("From which country did the name 'hamburger' originate?", new String[]{"Germany", "United States", "England", "Italy"}, 0));
        food.add(new Question("What type of food is basmati?", new String[]{"Tomato juice", "Garlic", "Rice", "Milk"}, 2));
        food.add(new Question("What type of milk was mozarella cheese originally made from?", new String[]{"Buffalo milk", "Cow milk", "Goat milk", "Oat milk"}, 0));
        categoriesMap.put("Food", food);

        ArrayList<Question> swedish = new ArrayList<>();
        swedish.add(new Question("What year did the Vasa ship sink?", new String[]{"1598", "1611", "1623", "1628"}, 3));
        swedish.add(new Question("What year was Olof Palme shot?", new String[]{"1990", "1981", "1986", "1995"}, 2));
        swedish.add(new Question("When did women get voting rights in Sweden?", new String[]{"1898", "1908", "1918", "1928"}, 2));
        swedish.add(new Question("Where was Sweden's first university grounded?", new String[]{"Uppsala", "Lund", "Stockholm", "Åbo"}, 0));
        swedish.add(new Question("What year did Queen Silvia and King Carl-Gustav marry?", new String[]{"1977", "1982", "1976", "1979"}, 2));
        categoriesMap.put("Swedish history", swedish);

        ArrayList<Question> music = new ArrayList<>();
        music.add(new Question("Which singer was known amongst other things as 'The King of Pop'?", new String[]{"Elvis Presley", "Elton John", "Frank Sinatra", "Micheal Jackson"}, 3));
        music.add(new Question("They took on the world with the massive hit 'Love Fool', which band?", new String[]{"ABBA", "Cardigans", "Meja", "Erasure"}, 0));
        music.add(new Question("What was Britney Spears’ first single called?", new String[]{"Love you Baby", "I need you Baby", "Baby one more time", "My Baby"}, 2));
        music.add(new Question("What is David Bowie’s real name?", new String[]{"David Jones", "David Evans", "David Robin", "David Stefan"}, 0));
        music.add(new Question("A Swedish duo from the 60s once jammed with Jimi Hendrix. Which duo?", new String[]{"Womack and Womack", "Hansson and Carlsson", "Per and Marie", "Jean and Dean"}, 1));
        categoriesMap.put("Music", music);

        return categoriesMap;
    }
    public Question getSingleQuestion(String category) {
        Random random = new Random();
        int i = random.nextInt(5);
        ArrayList<Question> questions = categoriesMap.get(category);
        return questions.get(i);
    }
}
