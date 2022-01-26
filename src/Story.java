import enums.Mood;
import classes.*;
import interfaces.Dialog;
import Exception.*;

import java.util.ArrayList;


public class Story {

    public static void main(String[] args) {
        Thing bell = new Thing("колокольчик");
        Thing lace = new Thing("шнурок");
        ArrayList<Thing> fav = new ArrayList<>();
        ArrayList<Song> fluff_song = new ArrayList<>();
        fav.add(lace);
        fluff_song.add(new Song("Кто нашел хвост?"));
        Thing announcement = new Thing("объявление");
        Background home = new Background("Дом");
        Background outside = new Background("улица");
        Background forest = new Background("Лес");
        Background.Weather story=new Background.Weather("Солнечно");
        Personage Fluff = new Personage("Пух", home, Mood.NORMAL);
        Personage.Mind fluff_mind = Fluff.new Mind(fluff_song);
        Personage Owl = new Personage("Сова", home, Mood.NORMAL);
        Personage Ia = new Personage("Иа", forest, Mood.SAD);
        Ia.setFavorite_things(fav);
        Dialog fluff = new Dialog() { //анонимный класс
            @Override
            public void AskaboutSomething(boolean x, boolean lasttime) {

                if (lasttime) {
                    System.out.println("Нет, нет, никогда!");
                } else {
                    if (x) {
                        System.out.println("Софа спросила,пух ответил да");
                    } else {
                        System.out.println("Софа спросила,пух ответил нет");
                    }
                }
            }
        };
        fluff.AskaboutSomething(true, false);
        fluff.AskaboutSomething(false, false);
        fluff.AskaboutSomething(true, true);
        Fluff.changeLocation(outside);
        Owl.changeLocation(outside);
        Fluff.look(bell);
        Fluff.look(announcement);
        Fluff.look(lace);
        Fluff.take(lace);
        Fluff.changeLocation(forest);
        try {
            Fluff.give(lace, Ia);
        } catch (TickledException e) {
            Fluff.setMood(Mood.HUNGRY);
        }
        Fluff.changeLocation(home);
        try {
            Fluff.eat(false);
        } catch (DirtyException e) {
            System.out.println("вытирает губы");
        }
        fluff_mind.sing(0);
    }
}
