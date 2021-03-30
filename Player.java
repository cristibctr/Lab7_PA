/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab7_pa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author crist
 */
public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running;
    List<Square> tokensOfPlayer = new ArrayList<>();
    int boardSize;
    
    public Player(String name) {
        this.name = name;
    }
    
    public void setGame(Game game){
        this.game = game;
        boardSize = game.getBoardSize();
    }
    
    public void run(){
        running = true;
        while(running){
            if(!extractToken())
                running = false;
        }
    }
    
    public synchronized boolean extractToken(){
        if(!game.getBoard().tokensExist())
            return false;
        Random rand = new Random();
        int row = rand.nextInt(boardSize);
        int col = rand.nextInt(boardSize);
        while(!game.getBoard().tokenExistsAt(row, col)){
            row = rand.nextInt(boardSize);
            col = rand.nextInt(boardSize);
        }
        tokensOfPlayer.add(game.getBoard().getSquaresAt(row, col));
        System.out.println(name + " extracted: (" + tokensOfPlayer.get(tokensOfPlayer.size()-1).getPair1() + ", " + 
                tokensOfPlayer.get(tokensOfPlayer.size()-1).getPair2() +
                ") | " + tokensOfPlayer.get(tokensOfPlayer.size()-1).getValue());
        game.getBoard().extractTokenAt(row, col);
        return true;
    }
    
}
