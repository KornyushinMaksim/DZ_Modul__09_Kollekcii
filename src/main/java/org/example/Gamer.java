package org.example;

import java.util.*;

public class Gamer {
    private String name;
    private int allRating;
    private HashMap<String, Integer> games;

    public Gamer() {
        this.games = new HashMap<>();
    }

    public Gamer(String name) {
        this.games = new HashMap<>();
        this.name = name;
        this.allRating = 0;
    }

    public Gamer(String name, HashMap<String, Integer> games) {
        this.games = new HashMap<>();
        this.name = name;
        this.games = games;
        this.allRating = 0;
    }

    public void addGamesRat(String game, Integer value) {
        this.games.put(game, value);
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

    //выводит есть ли игра в списке или нет
    public boolean equalsNameGame(String nameGame) {
        return games.containsKey(nameGame);
    }

    //вывод конкретной игры и рейтинга
    public String returnGameAndRating(String nameGame) {
        return String.format(" %s с рейтингом %s", nameGame, this.games.get(nameGame));
    }

    //выводит список игр
    public String[] getNameGame() {
        int i = 0;
        String[] strs = new String[this.games.size()];
        for (Map.Entry<String, Integer> em : this.games.entrySet()) {
            strs[i++] = em.getKey();
        }
        return strs;
    }

    //выводит список рейтингов
    public int getRatingGame() {
        int a = 0;
        for (Map.Entry<String, Integer> em : this.games.entrySet()) {
            a = em.getValue();
        }
        return a;
    }

    //считает общий рейтинг
    public int getAllRating() {
        for (Map.Entry<String, Integer> em : this.games.entrySet()) {
            this.allRating += em.getValue();
        }
        return this.allRating;
    }

    public HashMap<String, Integer> getGames() {
        return games;
    }

    public String getName() {
        return name;
    }

    public void upRating(String nameGame, boolean bool) {
        if (bool) {
            this.games.put(nameGame, (this.games.get(nameGame)) + 1);
        }
    }

    //компаратор для сортировки
    public Gamer mySorted(Comparator comparator) {
        Gamer res = new Gamer();
        if (comparator.compare(res.getRatingGame(), this.getRatingGame()) > 0) {
            res = this;
        }
        return res;
    }

    @Override
    public String toString() {
        return "\nGamer: " + name +
                "\ngames: " + games +
                "}\n";
    }

    public boolean equalsName(String o) {
        if (this.name == o) {
            return true;
        } else {
            return false;
        }
//        if (o == null || getClass() != o.getClass()) return false;
//        Gamer gamer = (Gamer) o;
//        return Objects.equals(name, gamer.name);
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

    public int compareTo(Gamer o2) {
        int res = 0;
        if (o2.getRatingGame() > this.getRatingGame()) {
            res = 1;
        }
        else if (o2.getRatingGame() == this.getRatingGame()) {
            res = 0;
        }
        else if (o2.getRatingGame() < this.getRatingGame()) {
            res = -1;
        }
        return res;
    }
}
