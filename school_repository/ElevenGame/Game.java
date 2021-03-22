package com.ElevenGame;

import com.ElevenGame.Utils.Card;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game extends JFrame {
    public Card selectedCard1;
    public Card selectedCard2;
    public Card selectedCard3;

    private ArrayList<Card> balicek = new ArrayList<>();

    private Random random = new Random();

    public Game(){
        super("Eleven Game");
        this.setUP();
    }

    private void setUP(){
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
    }

    public void startGame(){
        this.loadPackages();
        this.loadCardsToPanel(9);
    }

    private void loadCardsToPanel(int number){
        int yy = 0;
        int xx = 0;
        for(int i = 0;i < number;i++){
            if(xx >= 4){
                xx = 0;
                yy++;
            }
            int rndNumber = this.random.nextInt(balicek.size());
            Card tmp = this.balicek.get(rndNumber);
            tmp.setPosition(xx * 85 + 10, yy * 135 + 10);
            this.add(tmp);
            xx++;

            this.balicek.remove(tmp);
            System.out.println(tmp.getSymbol());
            repaint();
        }
    }

    private void loadPackages(){
        //LOAD BALICEK
        this.loadPackage("♣",Color.BLACK,this.balicek);
        this.loadPackage("♦",Color.RED,this.balicek);
        this.loadPackage("♥",Color.RED,this.balicek);
        this.loadPackage("♠",Color.BLACK,this.balicek);
        //ZAMICHANI
        Collections.shuffle(this.balicek);
    }

    public void removeObjectO(Card oldCard){
        if(balicek.size() > 0) {
            this.remove(oldCard);
            int tmpX = oldCard.getX();
            int tmpY = oldCard.getY();
            int rnd = random.nextInt(balicek.size());
            Card tmpCard = balicek.get(rnd);
            tmpCard.setPosition(tmpX, tmpY);
            this.add(tmpCard);
            balicek.remove(tmpCard);
            repaint();
        }
    }

    private void loadPackage(String symbol,Color color,ArrayList<Card> arrayList){
        for(int i = 1;i < 14;i++){
            arrayList.add(new Card(this,symbol,i,color));
        }
    }
}
