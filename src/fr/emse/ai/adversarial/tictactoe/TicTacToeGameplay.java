package fr.emse.ai.adversarial.tictactoe;

import fr.emse.ai.adversarial.AlphaBetaSearch;
import fr.emse.ai.adversarial.IterativeDeepeningAlphaBetaSearch;
import fr.emse.ai.adversarial.MinimaxSearch;

import java.util.List;
import java.util.Scanner;

public class TicTacToeGameplay {
	
	public static void board(List<Integer> state) {
		String ligne1 = " ";
		String ligne2 = " ";
		String ligne3 = " ";
		
		if (state.get(1) == 0) {
			ligne1 = ligne1 + " ";
		} else if (state.get(1) == 1) {
			ligne1 = ligne1 + "X";
		} else {
			ligne1 = ligne1 + "O";
		}
		ligne1 = ligne1 + " ";
		if (state.get(2) == 0) {
			ligne1 = ligne1 + " ";
		} else if (state.get(2) == 1) {
			ligne1 = ligne1 + "X";
		} else {
			ligne1 = ligne1 + "O";
		}
		ligne1 = ligne1 + " ";
		if (state.get(3) == 0) {
			ligne1 = ligne1 + " ";
		} else if (state.get(3) == 1) {
			ligne1 = ligne1 + "X";
		} else {
			ligne1 = ligne1 + "O";
		}
		
		System.out.println(ligne1);
		System.out.println("\n _ _ _\n");
		
		if (state.get(4) == 0) {
			ligne2 = ligne2 + " ";
		} else if (state.get(4) == 1) {
			ligne2 = ligne2 + "X";
		} else {
			ligne2 = ligne2 + "O";
		}
		ligne2 = ligne2 + " ";
		if (state.get(5) == 0) {
			ligne2 = ligne2 + " ";
		} else if (state.get(5) == 1) {
			ligne2 = ligne2 + "X";
		} else {
			ligne2 = ligne2 + "O";
		}
		ligne2 = ligne2 + " ";
		if (state.get(6) == 0) {
			ligne2 = ligne2 + " ";
		} else if (state.get(6) == 1) {
			ligne2 = ligne2 + "X";
		} else {
			ligne2 = ligne2 + "O";
		}

		System.out.println(ligne2);
		System.out.println("\n _ _ _\n");
		
		if (state.get(7) == 0) {
			ligne3 = ligne3 + " ";
		} else if (state.get(7) == 1) {
			ligne3 = ligne3 + "X";
		} else {
			ligne3 = ligne3 + "O";
		}
		ligne3 = ligne3 + " ";
		if (state.get(8) == 0) {
			ligne3 = ligne3 + " ";
		} else if (state.get(8) == 1) {
			ligne3 = ligne3 + "X";
		} else {
			ligne3 = ligne3 + "O";
		}
		ligne3 = ligne3 + " ";
		if (state.get(9) == 0) {
			ligne3 = ligne3 + " ";
		} else if (state.get(9) == 1) {
			ligne3 = ligne3 + "X";
		} else {
			ligne3 = ligne3 + "O";
		}
		
		System.out.println(ligne3);
	}

    public static void main(String[] args) {
    	System.out.println("Game rules :");
    	System.out.println("The Board's squares are numbered as follows :");
    	System.out.println("1 2 3\n_ _ _\n4 5 6\n_ _ _\n7 8 9");
    	System.out.println("Choose the number corresponding to the square you would like to play.");
    	System.out.println("You are playing first (and still you are not winning Human).");
    	
    	TicTacToe game = new TicTacToe();
        MinimaxSearch<List<Integer>, Integer, Integer> minimaxSearch = MinimaxSearch.createFor(game);
        AlphaBetaSearch<List<Integer>, Integer, Integer> alphabetaSearch = AlphaBetaSearch.createFor(game);
        IterativeDeepeningAlphaBetaSearch<List<Integer>, Integer, Integer> iterativeDeepeningAlphaBetaSearch = IterativeDeepeningAlphaBetaSearch.createFor(game, -1, 1, 10);
        List<Integer> state = game.getInitialState();
        while (!game.isTerminal(state)) {
            System.out.println("======================");
            System.out.println(state);
            board(state);
            Integer action = -1;
            if (state.get(0) == 0) {
                //human
                List<Integer> actions = game.getActions(state);
                Scanner in = new Scanner(System.in);
                while (!actions.contains(action)) {
                    System.out.println("Human player, what is your action?");
                    action = in.nextInt();
                }
            } else {
                //machine
                System.out.println("Machine player, what is your action?");
            	action = minimaxSearch.makeDecision(state);
                System.out.println("Metrics for Minimax : " + minimaxSearch.getMetrics());
                alphabetaSearch.makeDecision(state);
                System.out.println("Metrics for AlphaBeta : " + alphabetaSearch.getMetrics());
                iterativeDeepeningAlphaBetaSearch.makeDecision(state);
                System.out.println("Metrics for IDAlphaBetaSearch : " + iterativeDeepeningAlphaBetaSearch.getMetrics());
            }
            System.out.println("Chosen action is " + action);
            state = game.getResult(state, action);
        }
        System.out.println("======================");
        System.out.println(state);
        board(state);
        System.out.print("GAME OVER: ");
        
        for (int i = 10; i <= 17; i++)
            if (state.get(i) == 3) {
            	System.out.println("Human wins!");
            }
        
        for (int i = 18; i <= 25; i++)
            if (state.get(i) == 3) {
            	System.out.println("Machine wins!");
            }
        
        long k = 0;
    	for (int i = 1; i <= 9; i++)
            if (state.get(i) != 0) {
            	k = k+1;
            }
    	if (k==9) {
    		System.out.println("Draw!");
    	}

    }
}
