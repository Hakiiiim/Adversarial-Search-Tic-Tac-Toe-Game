# Adversarial-Search-Tic-Tac-Toe-Game
As part of the artificial intelligence course at the Ecole des Mines de Saint-étienne, This is a model of the tic-tac-toe game using adversarial search algotithms: Minimax, Alpha-Beta pruning and Iterative deepening.

Course given by: Gauthier PICARD, Professor. PhD. HDR at the Ecole des Mines de Saint-étienne.

Here is his statement of the problem: https://www.emse.fr/~picard/cours/ai/adversarial/index.html

The source files were written by Pr. Gauthier PICARD, then completed by us following the exercices presented in the previous link. Model realised by me and my colleague Younes Gueddari.

The files are to be found in the src folder of the Java Project. 

_util_ contains a simple example of the maximin search algorithm with and without alpha-beta pruning, it is applied in a simple 2-depth tree.

_adversarial_ contains the interfaces of the game and the search algorithms (AdversarialSearch.java, Game.java). And the search algorithms ready to use : MinimaxSearch.java, AlphaBetaSearch.jave, IterativeDeepeningAlphaBetaSearch.java.

_adversarial/core_ contains Metrics.java which calculates the number of expanded nodes by a used search algorithm.

_adversarial/tictactoe_ The game's folder, contains the game implementation TicTacToe.java, and the gameplay file (which is to execute to try the game) TicTacToeGamePlay.java.

# Game modelization
## State

A state is a list of 25 integers: [P,B1,B2,B3,B4,B5,B6,B7,B8,B9,X1,X2,X3,X4,X5,X6,X7,X8,O1,O2,O3,O4,O5,O6,O7,O8]

P: {0,1} to designate which player should play

B1,...,B9: {0,1,2} equivalent to {-,X,O}, the boards' squares line by line

X1,...,X8: {0,1,2,3} The number of Xs (1s) contained in the three columns, the three lines and the two diagonals (useful to compute evaluation function later)

O1,...,O8: {0,1,2,3} The number of Os (2s) contained in the three columns, the three lines and the two diagonals (useful to compute evaluation function later)

## Evaluation function (a state's utility)
