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

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Play play = new Play();
        Execution execution = new Execution();

        Gamer gamer = new Gamer("Ivan");
        Gamer gamer1 = new Gamer("Oleg");
        Gamer gamer2 = new Gamer("Jan");
        Gamer gamer3 = new Gamer("Yana");
        Gamer gamer4 = new Gamer("Oleg");
        Gamer gamer5 = new Gamer("Fedya");

        System.out.println(play.addGamer(gamer));
        System.out.println(play.addGamer(gamer1));
        System.out.println(play.addGamer(gamer2));
        System.out.println(play.addGamer(gamer3));
        System.out.println(play.addGamer(gamer4));
        System.out.println(play.addGamer(gamer5));

        execution.gamerListGames(play);
        execution.gamerGamesRating(play);

        System.out.println(play);
        System.out.println();
        System.out.println(gamer.getAllRating());
        System.out.println(gamer1.getAllRating());
        System.out.println(gamer2.getAllRating());
        System.out.println(gamer3.getAllRating());
        System.out.println(gamer5.getAllRating());
        System.out.println();
        System.out.println(play.showGames());
        Scanner in = new Scanner(System.in);
//        System.out.println("search");
//        String name = in.nextLine();
//        String game = in.nextLine();
//        System.out.println(play.ratingByNameAndGame(name, game));


        System.out.println(execution.top10ForGame(play, "Wii_Sports_Resort"));
    }
}