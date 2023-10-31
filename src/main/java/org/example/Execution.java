package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Execution {

            //рандомно добавляет игроку список игр рандомного размера
    public Gamer randListGame(Gamer gamer){
        String listGames = Arrays.toString(eListGames.values());
        String[] games = listGames.split(",");
        for (int i = 0; i < games.length; i++){
            games[i].trim();
        }
        int cnt = (int)(Math.random() * 8 + 1);
        for (int i = 0; i < cnt; i++) {
            int j = (int) (Math.random() * games.length);
            gamer.addGames(games[j]);
        }
        return gamer;
    }

    //количество сыгранных игр для конкретного игрока
    public void simulatorRating(Gamer gamer, int quantityGame) {
        for (int i = 0; i < quantityGame; i++) {
            simulator(gamer);
        }
        Object[] keyS = gamer.getGames().keySet().toArray();
        Object[] valueS = gamer.getGames().values().toArray();
        for (int j = 0; j < valueS.length; j++) {
            Integer key = (Integer) valueS[j];
            key /= valueS.length;
            gamer.addGamesRat((String) keyS[j], key);
        }
    }

    //рандомно имитирует выигрыш
    private void simulator(Gamer gamer) {
        int victory = (int) (Math.random() * 2);
        boolean vict = false;
        if (victory == 0) {
            vict = true;
        }
        Object[] keyS = gamer.getGames().keySet().toArray();
        for (int i = 0; i < keyS.length; i++) {
            Object key = keyS[(int) (Math.random() * keyS.length)];
            gamer.upRating((String) key, vict);
        }
    }

            //рандомное заполнение списка игр
    public void gamerListGames(Play play) {
        Iterator<Gamer> gamerIterator = play.getGamers().iterator();
        while (gamerIterator.hasNext()) {
            randListGame(gamerIterator.next());
        }
    }

            //рейтинг игр
    public void gamerGamesRating(Play play) {
        Iterator<Gamer> ratingIterator = play.getGamers().iterator();
        while (ratingIterator.hasNext()) {
            simulatorRating(ratingIterator.next(), 200);
        }
    }

            //топ-10 по игре        //подумать над переносом метода в gamer
    public TreeSet<Gamer> top10ForGame(Play play, String nameGame){
        TreeSet<Gamer> gamerTreeSet = new TreeSet<>((o1, o2) -> o2.compareTo(o1));
        gamerTreeSet.add(play.gamerFromGame(nameGame));
        return gamerTreeSet;
    }

}
