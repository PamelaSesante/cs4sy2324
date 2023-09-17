/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cs4sesante_exercise4;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class RockPaperScissors{
	public static void main(String[] args){
		Move rock = new Move("Rock");
		Move paper = new Move("Paper");
		Move scissors = new Move("Scissors");
		
		rock.setStrongAgainst(scissors);
		paper.setStrongAgainst(rock);
		scissors.setStrongAgainst(paper);
		
		int roundsToWin = 2;
                Scanner scan = new Scanner(System.in);
                String gameStatus = "Continue";
                
                
                while (gameStatus.equals("Continue")) {
                System.out.println("\nWelcome to Rock, Paper, Scissors. Please choose an option: \n 1. Start game \n 2. Change number of rounds \n 3. Exit application");
                int firstChoice = Integer.parseInt(scan.nextLine());
                
                if(firstChoice==1) {
                    
                    int playerWins = 0;
                    int computerWins = 0;
                
                    System.out.printf("\nThis match will be first to %d wins. \n", roundsToWin);
                    while(playerWins<roundsToWin || roundsToWin<computerWins){
                        int computerMoveNumber = (int) Math.floor(Math.random()*3) + 1;
                        
                        Move computerMove = null;
                        Move playerMove = null;
                        
                        
                        switch (computerMoveNumber){
                            case 1:
                                computerMove = rock;
                                break;
                            case 2:
                                computerMove = paper;
                                break;
                            case 3:
                                computerMove = scissors;
                                break;
                        }
                        
                        System.out.println("The computer has selected its move. Select your move: \n 1. Rock \n 2. Paper \n 3. Scissors ");
                        int playerMoveNumber = Integer.parseInt(scan.nextLine());
                        
                        switch (playerMoveNumber){
                            case 1:
                                playerMove = rock;
                                break;
                            case 2:
                                playerMove = paper;
                                break;
                            case 3:
                                playerMove = scissors;
                                break;
                        }
                        
                        int moveComparison = Move.compareMoves(playerMove, computerMove);
                        String playerMoveName = playerMove.getName();
                        String computerMoveName = computerMove.getName();
                        
                        switch (moveComparison) {
                            case 0:
                                System.out.println("\nPlayer chose " + playerMoveName + ". Computer chose " + computerMoveName + ". Player wins!");
                                playerWins++;
                                System.out.println("Player: " + playerWins + " - Computer: " + computerWins + "\n");
                                break; 
                            case 1:
                                System.out.println("\nPlayer chose " + playerMoveName + ". Computer chose " + computerMoveName + ". Computer wins!");
                                computerWins++;
                                System.out.println("\nPlayer: " + playerWins + " - Computer: " + computerWins + "\n");
                                break;
                            case 2:
                                System.out.println("\nPlayer chose " + playerMoveName + ". Computer chose " + computerMoveName + ". Round is tied!");
                                System.out.println("Player: " + playerWins + " - Computer: " + computerWins + "\n");
                                break;
                        }
                        
                        if (playerWins == roundsToWin){
                        System.out.println("Player wins!");
                        break;
                        }
                        
                        else if (computerWins == roundsToWin) {
                        System.out.println("Computer wins!");
                        break;
                        }    
                    }                    
                }
                
                else if (firstChoice==2){
                    System.out.println("\nHow many wins are needed to win a match?");
                    roundsToWin = Integer.parseInt(scan.nextLine());
                    System.out.println("\nNew setting has been saved!");
                    firstChoice = 0;
                }             
                
		else if (firstChoice==3){
                System.out.println("\nThank you for playing!");
                break;
                }          
	}
        }
}
