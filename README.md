# Adversarial-Search-Tic-Tac-Toe-Game
As part of the artificial intelligence course at the Ecole des Mines de Saint-étienne, This is a model of the tic-tac-toe game using adversarial search algotithms: Minimax, Alpha-Beta pruning and Iterative deepening.

Course given by: Gauthier PICARD, Professor. PhD. HDR at the Ecole des Mines de Saint-étienne.

Here is his statement of the problem: https://www.emse.fr/~picard/cours/ai/adversarial/index.html

The source files were written by Pr. Gauthier PICARD, then completed by us following the exercices presented in the previous link. Model realised by me and my colleague Younes Gueddari.

The files are to be found in the src folder of the Java Project. 

_util_ contains a simple example of the maximin search algorithm with and without alpha-beta prunning, it is applied in a simple 2-depth tree.

_adversarial_ contains the interfaces of the game and the search algorithms (AdversarialSearch.java, Game.java). And the search algorithms ready to use : MinimaxSearch.java, AlphaBetaSearch.jave, IterativeDeepeningAlphaBetaSearch.java.

_adversarial/core_ contains Metrics.java which calculates the number of expanded nodes by a used search algorithm.

_adversarial/tictactoe_ The game's folder, contains the game implementation TicTacToe.java, and the gameplay file (which is to execute to try the game) TicTacToeGamePlay.java.


