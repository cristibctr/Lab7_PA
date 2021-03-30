/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab7_pa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crist
 */
public class Game {
    private Board board;
    private final List<Player> players = new ArrayList<>();
    private static final int boardSize = 6;
    
    public void newPlayer(Player player){
        players.add(player);
        player.setGame(this);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
    
    public void start(){
        for(Player player : players){
            new Thread(player).start();
        }
    }

    public int getBoardSize() {
        return boardSize;
    }
    
    public static void main(String args[]){
        Game game = new Game();
        game.setBoard(new Board(boardSize));
        game.newPlayer(new Player("Player 1"));
        game.newPlayer(new Player("Player 2"));
        game.newPlayer(new Player("Player 3"));
        game.start();
    }
}
