/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab7_pa;

import java.util.Random;


/**
 *
 * @author crist
 */
public class Board {
    private Square[][] squares;
    private boolean[][] tokenExists;

    public Board(int numberOfSquares) {
        Random rand = new Random();
        squares = new Square[numberOfSquares][numberOfSquares];
        tokenExists = new boolean[numberOfSquares][numberOfSquares];
        for(int i = 0; i < numberOfSquares; i++){
            for(int j = 0; j < numberOfSquares; j++)
            {
                int pair1 = rand.nextInt(numberOfSquares), pair2 = rand.nextInt(numberOfSquares), value = rand.nextInt(numberOfSquares);
                while(pair1 == pair2)
                    pair2 = rand.nextInt(numberOfSquares);
                squares[i][j] = new Square(pair1, pair2, value);
                tokenExists[i][j] = true;
            }
        }
    }

    public Square getSquaresAt(int row, int col) {
        return squares[row][col];
    }
    
    public void extractTokenAt(int row, int col){
        squares[row][col] = null;
        tokenExists[row][col] = false;
    }
    
    public boolean tokenExistsAt(int row, int col){
        return tokenExists[row][col];
    }
    
    public boolean tokensExist(){
        for(int i = 0; i < tokenExists.length; i++)
            for(int j = 0; j < tokenExists.length; j++)
                if(tokenExists[i][j])
                    return true;
        return false;
    }
}
