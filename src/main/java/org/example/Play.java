package org.example;

import java.util.*;

public class Play {
    private HashSet gamers;

    public Play() {
        this.gamers = new HashSet<>();
    }

    public HashSet getGamers() {
        return gamers;
    }

    //добавляет игрока
    public String addGamer(Gamer gamer) {
        if (this.gamers.add(gamer)){
            return gamer.getName() + " -успешно добавлен";
        }
        return gamer.getName() + " -этот ник занят!";
    }

    //выводит список игр из общей таблицы
    public HashSet<String> showGames() {
        HashSet<String> listGames = new HashSet<>();
        Iterator<Gamer> iterator = this.gamers.iterator();
        while (iterator.hasNext()) {
            Gamer gm = iterator.next();
            String[] strsGames = gm.getNameGame();
            for (int i = 0; i < strsGames.length; i++) {
                listGames.add(strsGames[i]);
            }
        }
        return listGames;
    }

            //рейтинг игрока по имени и игре
    public String ratingByNameAndGame(String nameGamer, String nameGame){
        ArrayList<Gamer> g = new ArrayList<>(this.gamers);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < g.size(); i ++){
            if(g.get(i).getName().equals(nameGamer)){
                if(g.get(i).equalsNameGame(nameGame)){
                    stringBuilder.append(g.get(i).getName());
                    stringBuilder.append(" ");
                    stringBuilder.append(g.get(i).returnGameAndRating(nameGame));
                }
            }
        }
        return stringBuilder.toString();
    }

            //вывод игрока по игре
    public Gamer gamerFromGame(String nameGame) {
        Gamer tmp = null;
        ArrayList<Gamer> g = new ArrayList<>(this.gamers);
        for (int i = 0; i < g.size(); i++) {
            if (g.get(i).equalsNameGame(nameGame)) {
                tmp = g.get(i);
            }
        }
        return tmp;
    }

//            //компаратор для сортировки
//    public Gamer mySorted(Comparator comparator){
//        Gamer res = new Gamer();
//        ArrayList<Gamer> g = new ArrayList<>(this.gamers);
//        for (int i = 0; i < g.size(); i++){
//            if(comparator.compare(res.getRatingGame(), g.get(i).getRatingGame()) > 0){
//                res = g.get(i);
//            }
//        }
//        return res;
//    }

    @Override
    public String toString() {
        return "Play{" +
                "\ngamers=" + gamers +
                "}";
    }
}
