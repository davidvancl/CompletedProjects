package com.ElevenGame.Utils;

import com.ElevenGame.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Card extends JPanel implements MouseListener {
    private String symbol;
    private int number;
    private Game game;

    private int x;
    private int y;

    public Card(Game game,String symbol,int number,Color foreground){
        if(number == 1){
            this.symbol = symbol + "A";
            this.number = number;
        } else if(number == 11) {
            this.symbol = symbol + "J";
            this.number = 0;
        } else if(number == 12) {
            this.symbol = symbol + "Q";
            this.number = 0;
        } else if(number == 13) {
            this.symbol = symbol + "K";
            this.number = 0;
        } else {
            this.symbol = symbol + "" + number;
            this.number = number;
        }

        this.game = game;

        this.setBounds(0,0,80,130);
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(foreground));
        this.setForeground(foreground);
        this.loadSymbol(this.symbol,foreground);
        this.addMouseListener(this);

        this.repaint();
    }

    private void loadSymbol(String symbol,Color foreground){
        JLabel label = new JLabel(symbol);
        label.setForeground(foreground);
        label.setBounds(35,50,50,30);
        label.addMouseListener(this);
        this.add(label);
    }

    public void setPosition(int x,int y){
        this.x = x;
        this.y = y;

        this.setBounds(x,y,this.getWidth(),this.getHeight());
    }

    public int getNumber(){
        return number;
    }

    public String getSymbol(){
        return symbol;
    }

    private boolean checkSelection(){
        if(this.game.selectedCard1 == this){
            return true;
        } else if(this.game.selectedCard2 == this){
            return true;
        } else if(this.game.selectedCard3 == this){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(checkSelection()){
            if(this.game.selectedCard1 == this){
                this.game.selectedCard1 = null;
            }
            if(this.game.selectedCard2 == this){
                this.game.selectedCard2 = null;
            }
            if(this.game.selectedCard3 == this){
                this.game.selectedCard3 = null;
            }
        } else {
            if (this.game.selectedCard1 == null && this.game.selectedCard2 != this && this.game.selectedCard3 != this) {
                this.game.selectedCard1 = this;
            }
            if(this.game.selectedCard2 == null && this.game.selectedCard1 != this && this.game.selectedCard3 != this){
                this.game.selectedCard2 = this;
            }
            if(this.game.selectedCard3 == null && this.game.selectedCard1 != this && this.game.selectedCard2 != this){
                this.game.selectedCard3 = this;
            }
        }

        if(this.game.selectedCard1 != null && this.game.selectedCard2 != null && this.game.selectedCard3 != null){
            if(this.game.selectedCard1.getNumber() + this.game.selectedCard2.getNumber() + this.game.selectedCard3.getNumber() == 0){
                System.out.println("SUCCESS");
                this.game.removeObjectO(this.game.selectedCard1);
                this.game.removeObjectO(this.game.selectedCard2);
                this.game.removeObjectO(this.game.selectedCard3);
                clearSelection();
            } else {
                System.out.println("WRONG");
                clearSelection();
            }
        } else if(this.game.selectedCard1 != null && this.game.selectedCard2 != null){
            if(this.game.selectedCard1.getNumber() + this.game.selectedCard2.getNumber() == 11){
                System.out.println("SUCCESS");
                this.game.removeObjectO(this.game.selectedCard1);
                this.game.removeObjectO(this.game.selectedCard2);
                clearSelection();
            } else if (this.game.selectedCard1.getNumber() + this.game.selectedCard2.getNumber() != 0) {
                System.out.println("WRONG");
                clearSelection();
            }
        }

        if(this.game.selectedCard1 != null){
            System.out.println("O1: " + this.game.selectedCard1.getSymbol());
        }
        if(this.game.selectedCard2 != null){
            System.out.println("O2: " + this.game.selectedCard2.getSymbol());
        }
        if(this.game.selectedCard3 != null){
            System.out.println("O3: " + this.game.selectedCard3.getSymbol());
        }
    }

    private void clearSelection(){
        this.game.selectedCard1 = null;
        this.game.selectedCard2 = null;
        this.game.selectedCard3 = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
