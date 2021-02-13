package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardShuffler {

    private List<Card> list = new ArrayList<>();

    public CardShuffler() {
        Card card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14,
                card15, card16;

        //default set
        card1 = null;
        card2 = null;
        card3 = null;
        card4 = null;
        card5 = null;
        card6 = null;
        card7 = null;
        card8 = null;
        card9 = null;
        card10 = null;
        card11 = null;
        card12 = null;
        card13 = null;
        card14 = null;
        card15 = null;
        card16 = null;

        //Lord of the Rings
        if (Main.motiveActual == Motives.LORD_OF_THE_RINGS) {
            System.out.println("Karten mischeln Lord of the Rings");
            card1 = new Card(new Image(getClass().getResourceAsStream("Aragorn.png")));
            card2 = new Card(new Image(getClass().getResourceAsStream("Aragorn.png")));
            card3 = new Card(new Image(getClass().getResourceAsStream("Gandalf.png")));
            card4 = new Card(new Image(getClass().getResourceAsStream("Gandalf.png")));
            card5 = new Card(new Image(getClass().getResourceAsStream("LegolasGimli.png")));
            card6 = new Card(new Image(getClass().getResourceAsStream("LegolasGimli.png")));
            card7 = new Card(new Image(getClass().getResourceAsStream("Galandrien.png")));
            card8 = new Card(new Image(getClass().getResourceAsStream("Galandrien.png")));
            card9 = new Card(new Image(getClass().getResourceAsStream("Gollum.png")));
            card10 = new Card(new Image(getClass().getResourceAsStream("Gollum.png")));
            card11 = new Card(new Image(getClass().getResourceAsStream("Eowyn.png")));
            card12 = new Card(new Image(getClass().getResourceAsStream("Eowyn.png")));
            card13 = new Card(new Image(getClass().getResourceAsStream("FrodoSam.png")));
            card14 = new Card(new Image(getClass().getResourceAsStream("FrodoSam.png")));
            card15 = new Card(new Image(getClass().getResourceAsStream("PfeiffeRauchen.png")));
            card16 = new Card(new Image(getClass().getResourceAsStream("PfeiffeRauchen.png")));
        }

        //Arielle
        if (Main.motiveActual == Motives.ARIELLE) {
            System.out.println("Karten mischeln Arielle");
            card1 = new Card(new Image(getClass().getResourceAsStream("ArielleImLoch.png")));
            card2 = new Card(new Image(getClass().getResourceAsStream("ArielleImLoch.png")));
            card3 = new Card(new Image(getClass().getResourceAsStream("Dreizack.png")));
            card4 = new Card(new Image(getClass().getResourceAsStream("Dreizack.png")));
            card5 = new Card(new Image(getClass().getResourceAsStream("Hai.png")));
            card6 = new Card(new Image(getClass().getResourceAsStream("Hai.png")));
            card7 = new Card(new Image(getClass().getResourceAsStream("Krebs.png")));
            card8 = new Card(new Image(getClass().getResourceAsStream("Krebs.png")));
            card9 = new Card(new Image(getClass().getResourceAsStream("Ursula.png")));
            card10 = new Card(new Image(getClass().getResourceAsStream("Ursula.png")));
            card11 = new Card(new Image(getClass().getResourceAsStream("Fisch.png")));
            card12 = new Card(new Image(getClass().getResourceAsStream("Fisch.png")));
            card13 = new Card(new Image(getClass().getResourceAsStream("König.png")));
            card14 = new Card(new Image(getClass().getResourceAsStream("König.png")));
            card15 = new Card(new Image(getClass().getResourceAsStream("Tanzen.png")));
            card16 = new Card(new Image(getClass().getResourceAsStream("Tanzen.png")));
        }

        //Merida
        if (Main.motiveActual == Motives.MERIDA) {
            System.out.println("Karten mischeln Merida");
            card1 = new Card(new Image(getClass().getResourceAsStream("Dingwall.png")));
            card2 = new Card(new Image(getClass().getResourceAsStream("Dingwall.png")));
            card3 = new Card(new Image(getClass().getResourceAsStream("Macintosh.png")));
            card4 = new Card(new Image(getClass().getResourceAsStream("Macintosh.png")));
            card5 = new Card(new Image(getClass().getResourceAsStream("MeridaBogen.png")));
            card6 = new Card(new Image(getClass().getResourceAsStream("MeridaBogen.png")));
            card7 = new Card(new Image(getClass().getResourceAsStream("MeridaBrueder.png")));
            card8 = new Card(new Image(getClass().getResourceAsStream("MeridaBrueder.png")));
            card9 = new Card(new Image(getClass().getResourceAsStream("MeridaPferd.png")));
            card10 = new Card(new Image(getClass().getResourceAsStream("MeridaPferd.png")));
            card11 = new Card(new Image(getClass().getResourceAsStream("MeridaVater.png")));
            card12 = new Card(new Image(getClass().getResourceAsStream("MeridaVater.png")));
            card13 = new Card(new Image(getClass().getResourceAsStream("Mordu.png")));
            card14 = new Card(new Image(getClass().getResourceAsStream("Mordu.png")));
            card15 = new Card(new Image(getClass().getResourceAsStream("MutterMerida.png")));
            card16 = new Card(new Image(getClass().getResourceAsStream("MutterMerida.png")));
        }

        //Pingu
        if (Main.motiveActual == Motives.PINGU) {
            System.out.println("Karten mischeln Pingu");
            card1 = new Card(new Image(getClass().getResourceAsStream("PinguBau.png")));
            card2 = new Card(new Image(getClass().getResourceAsStream("PinguBau.png")));
            card3 = new Card(new Image(getClass().getResourceAsStream("PinguBaustelle.png")));
            card4 = new Card(new Image(getClass().getResourceAsStream("PinguBaustelle.png")));
            card5 = new Card(new Image(getClass().getResourceAsStream("PinguHerz.png")));
            card6 = new Card(new Image(getClass().getResourceAsStream("PinguHerz.png")));
            card7 = new Card(new Image(getClass().getResourceAsStream("PinguIglu.png")));
            card8 = new Card(new Image(getClass().getResourceAsStream("PinguIglu.png")));
            card9 = new Card(new Image(getClass().getResourceAsStream("PinguPostman.png")));
            card10 = new Card(new Image(getClass().getResourceAsStream("PinguPostman.png")));
            card11 = new Card(new Image(getClass().getResourceAsStream("PinguRadio.png")));
            card12 = new Card(new Image(getClass().getResourceAsStream("PinguRadio.png")));
            card13 = new Card(new Image(getClass().getResourceAsStream("PinguSchlitten.png")));
            card14 = new Card(new Image(getClass().getResourceAsStream("PinguSchlitten.png")));
            card15 = new Card(new Image(getClass().getResourceAsStream("PinguSchwester.png")));
            card16 = new Card(new Image(getClass().getResourceAsStream("PinguSchwester.png")));
        }

        //Pingu
        if (Main.motiveActual == Motives.MINION) {
            System.out.println("Karten mischeln Minion");
            card1 = new Card(new Image(getClass().getResourceAsStream("EuvAgnes.png")));
            card2 = new Card(new Image(getClass().getResourceAsStream("EuvAgnes.png")));
            card3 = new Card(new Image(getClass().getResourceAsStream("EuvBlond.png")));
            card4 = new Card(new Image(getClass().getResourceAsStream("EuvBlond.png")));
            card5 = new Card(new Image(getClass().getResourceAsStream("EuvCowboy.png")));
            card6 = new Card(new Image(getClass().getResourceAsStream("EuvCowboy.png")));
            card7 = new Card(new Image(getClass().getResourceAsStream("EuvGeschwister.png")));
            card8 = new Card(new Image(getClass().getResourceAsStream("EuvGeschwister.png")));
            card9 = new Card(new Image(getClass().getResourceAsStream("EuvGru.png")));
            card10 = new Card(new Image(getClass().getResourceAsStream("EuvGru.png")));
            card11 = new Card(new Image(getClass().getResourceAsStream("EuvHomo.png")));
            card12 = new Card(new Image(getClass().getResourceAsStream("EuvHomo.png")));
            card13 = new Card(new Image(getClass().getResourceAsStream("EuvMinion.png")));
            card14 = new Card(new Image(getClass().getResourceAsStream("EuvMinion.png")));
            card15 = new Card(new Image(getClass().getResourceAsStream("EuvVector.png")));
            card16 = new Card(new Image(getClass().getResourceAsStream("EuvVector.png")));
        }


        list.add(card1);
        list.add(card2);
        list.add(card3);
        list.add(card4);
        list.add(card5);
        list.add(card6);
        list.add(card7);
        list.add(card8);
        list.add(card9);
        list.add(card10);
        list.add(card11);
        list.add(card12);
        list.add(card13);
        list.add(card14);
        list.add(card15);
        list.add(card16);

        Collections.shuffle(list);
    }

    public List<Card> getList() {
        return list;
    }
}
