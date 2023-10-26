//Есть сайт, на котором рассчитывается рейтинг игроков различных сетевых игр.
//        Игрок при регистрации указывает ник, а так же список игр, в которые он играет.
//        Задача – написать программу, которая:
//        ■ регистрирует игроков в системе (должна быть проверка, занят ли ник);
//        ■ добавляет рейтинг игроку, в случае его выигрыша в игре;
//        ■ выводит список игр, в которые играют все игроки на сайте;
//        ■ выводит рейтинг по имени игрока и игре;
//        ■ выводит 10 лучших игроков в определенной игре;
//        ■ выводит 10 лучших игроков с учетом всех игр.

package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Play play = new Play();
        Gamer gamer = new Gamer("Ivan");
        Gamer gamer1 = new Gamer("Oleg");
//        Gamer gamer2 = new Gamer("Fedya");
//        Gamer gamer3 = new Gamer("Janna");
//        Gamer gamer4 = new Gamer("Jan");
        gamer.addGames("GTA 1");
        gamer.addGames("GTA 2");
        gamer.addGames("GTA 3");
        gamer.addGames("GTA 4");
        gamer.addGames("GTA 5");
        gamer1.addGames("GTA 10");
        gamer1.addGames("GTA 20");
        gamer1.addGames("GTA 3");
        gamer1.addGames("GTA 40");
        gamer1.addGames("GTA 5");

        System.out.println(play.addGamer(gamer));
        System.out.println(play.addGamer(new Gamer("Ivan")));
        System.out.println(play.addGamer(gamer1));

        play.simulatorRating(gamer, 200);
        play.simulatorRating(gamer1, 200);
        System.out.println(play);
        System.out.println(play.showGames());

        String[] listGames = new String[]{Arrays.toString(eListGames.values())};
        for (int i = 0; i < listGames.length; i++){
            System.out.println(listGames[i]);
        }
    }
}