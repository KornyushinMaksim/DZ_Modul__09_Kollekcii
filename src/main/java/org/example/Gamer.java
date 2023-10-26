package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Gamer {
    private String name;
//    private Integer rating;
    private HashMap<String, Integer> games;

    public Gamer() {
        this.games = new HashMap<>();
    }

    public Gamer(String name) {
        this.games = new HashMap<>();
        this.name = name;
    }

    public Gamer(String name, HashMap<String, Integer> games) {
        this.games = new HashMap<>();
        this.name = name;
//        this.rating = getRatingGame(games.keySet().toString());
        this.games = games;
    }

    public void addGames(String game) {
        this.games.put(game, 0);
    }

    public String getNameGame(String nameGame) {
        for (Map.Entry<String, Integer> em : this.games.entrySet()) {
            if (em.getKey().equals(nameGame))
                return em.getKey();
        }
        return "Игры в списке нет";
    }

    public String[] getNameGame() {
        int i = 0;
        String[] strs = new String[this.games.size()];
        for (Map.Entry<String, Integer> em : this.games.entrySet()) {
            strs[i++] = em.getKey();
        }
        return strs;
    }

    public Integer getRatingGame(String nameGame) {
        for (Map.Entry<String, Integer> em : this.games.entrySet()) {
            if (em.getKey().equals(nameGame))
                return em.getValue();
        }
        return null;
    }

    public HashMap<String, Integer> getGames() {
        return games;
    }

    public String getName() {
        return name;
    }

//    public int getRating() {
//        return rating;
//    }

    public void upRating(String nameGame, boolean bool) {
        this.games.put(nameGame, (this.games.get(nameGame)) + 1);
    }

    @Override
    public String toString() {
        return "\nGamer{" +
                "\nname='" + name + '\'' +
                "\ngames=" + games +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamer gamer = (Gamer) o;
        return Objects.equals(name, gamer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
