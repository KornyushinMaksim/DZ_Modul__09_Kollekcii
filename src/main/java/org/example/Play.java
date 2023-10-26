package org.example;

import java.util.*;

public class Play {
    private HashSet gamers;

    public Play() {
        this.gamers = new HashSet<>();
    }

    public void simulatorRating(Gamer gamer, int quantityGame){
        for (int i = 0; i < quantityGame; i++){
            simulator(gamer);
        }
    }

    public boolean addGamer(Gamer gamer){           //добавление геймера в общий список
        return this.gamers.add(gamer);
    }

    public HashSet<String> showGames(){
        HashSet<String> listGames = new HashSet<>();
        Iterator<Gamer> iterator = this.gamers.iterator();
        while (iterator.hasNext()){
            Gamer gm = iterator.next();
            String[] strsGames = gm.getNameGame();
            for (int i = 0; i < strsGames.length; i++){
                listGames.add(strsGames[i]);
            }
        }

        return listGames;
    }

    private void simulator(Gamer gamer){            //рандомит выбор игр и сколько раз сыгранны и добавляет +1 к рейтингу
        int cnt = (int) (Math.random() * gamer.getGames().size());
        Object[] keyS = gamer.getGames().keySet().toArray();
        for (int i = 0; i < cnt; i++){
            Object key = keyS[(int)(Math.random() * keyS.length)];
            gamer.upRating((String) key, true);
        }
    }

    @Override
    public String toString() {
        return "Play{" +
                "\ngamers=" + gamers +
                '}';
    }
}
