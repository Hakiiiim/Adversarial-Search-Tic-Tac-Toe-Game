package fr.emse.ai.adversarial.tictactoe;

import fr.emse.ai.adversarial.Game;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe implements Game<List<Integer>, Integer, Integer> {

    public final static Integer[] players = {0, 1};
    public final static List<Integer> initialState = new ArrayList<Integer>();

    public TicTacToe() {
    	for (int i = 0; i <= 25; i++)
    		initialState.add(0);
    }

    @Override
    public List<Integer> getInitialState() {
        return initialState;
    }

    @Override
    public Integer[] getPlayers() {
        return players;
    }

    @Override
    public Integer getPlayer(List<Integer> state) {
        return state.get(0);
    }

    @Override
    public List<Integer> getActions(List<Integer> state) {
        ArrayList<Integer> actions = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++)
            if (state.get(i) == 0) {
            	actions.add(i);
            }
        return actions;
    }

    @Override
    public List<Integer> getResult(List<Integer> state, Integer action) {
        ArrayList<Integer> newState = new ArrayList<Integer>();
        newState.add(1 - state.get(0));
        for (int i = 1; i <= 9; i++)
            if (i == action) {
            	if (state.get(0) == 0) {
            		newState.add(1);
            	} else {
            		newState.add(2);
            	}
            	
            } else {
            	newState.add(state.get(i));
            }
        
        for (int i = 10; i <= 25; i++)
        	newState.add(state.get(i));
        
        if (state.get(0) == 0) {
        	if (action == 1) {
            	newState.set(10,state.get(10)+1);
            	newState.set(13,state.get(13)+1);
            	newState.set(16,state.get(16)+1);
        	} else if (action == 2) {
        		newState.set(11,state.get(11)+1);
            	newState.set(13,state.get(13)+1);
        	} else if (action == 3) {
        		newState.set(12,state.get(12)+1);
            	newState.set(13,state.get(13)+1);
            	newState.set(17,state.get(17)+1);
        	} else if (action == 4) {
        		newState.set(10,state.get(10)+1);
            	newState.set(14,state.get(14)+1);
        	} else if (action == 5) {
        		newState.set(11,state.get(11)+1);
            	newState.set(14,state.get(14)+1);
            	newState.set(16,state.get(16)+1);
            	newState.set(17,state.get(17)+1);
        	} else if (action == 6) {
        		newState.set(12,state.get(12)+1);
            	newState.set(14,state.get(14)+1);
        	} else if (action == 7) {
        		newState.set(10,state.get(10)+1);
            	newState.set(15,state.get(15)+1);
            	newState.set(17,state.get(17)+1);
        	} else if (action == 8) {
        		newState.set(11,state.get(11)+1);
            	newState.set(15,state.get(15)+1);
        	} else {
        		newState.set(12,state.get(12)+1);
            	newState.set(15,state.get(15)+1);
            	newState.set(16,state.get(16)+1);
        	}
    	} else {
    		if (action == 1) {
            	newState.set(10+8,state.get(10+8)+1);
            	newState.set(13+8,state.get(13+8)+1);
            	newState.set(16+8,state.get(16+8)+1);
        	} else if (action == 2) {
        		newState.set(11+8,state.get(11+8)+1);
            	newState.set(13+8,state.get(13+8)+1);
        	} else if (action == 3) {
        		newState.set(12+8,state.get(12+8)+1);
            	newState.set(13+8,state.get(13+8)+1);
            	newState.set(17+8,state.get(17+8)+1);
        	} else if (action == 4) {
        		newState.set(10+8,state.get(10+8)+1);
            	newState.set(14+8,state.get(14+8)+1);
        	} else if (action == 5) {
        		newState.set(11+8,state.get(11+8)+1);
            	newState.set(14+8,state.get(14+8)+1);
            	newState.set(16+8,state.get(16+8)+1);
            	newState.set(17+8,state.get(17+8)+1);
        	} else if (action == 6) {
        		newState.set(12+8,state.get(12+8)+1);
            	newState.set(14+8,state.get(14+8)+1);
        	} else if (action == 7) {
        		newState.set(10+8,state.get(10+8)+1);
            	newState.set(15+8,state.get(15+8)+1);
            	newState.set(17+8,state.get(17+8)+1);
        	} else if (action == 8) {
        		newState.set(11+8,state.get(11+8)+1);
            	newState.set(15+8,state.get(15+8)+1);
        	} else {
        		newState.set(12+8,state.get(12+8)+1);
            	newState.set(15+8,state.get(15+8)+1);
            	newState.set(16+8,state.get(16+8)+1);
        	}
    	}
        
        return newState;
    }

    @Override
    public boolean isTerminal(List<Integer> state) {
        boolean test = false;
        for (int i = 10; i <= 25; i++)
            if (state.get(i) == 3) {
            	test = true;
            }
        
        long k = 0;
    	for (int i = 1; i <= 9; i++)
            if (state.get(i) != 0) {
            	k = k+1;
            }
    	if (k==9) {
    		test = true;
    	}
    	return test;
    }

    @Override
    public double getUtility(List<Integer> state, Integer player) {
        if (state.get(0) == 1-player) {
        	if (state.get(0) == 0) {
        		for (int i = 10; i <= 17; i++)
                    if (state.get(i) == 3) {
                    	return -25;
                    }
            	
            	
            	for (int i = 18; i <= 25; i++)
                    if (state.get(i) == 3) {
                    	return 25;
                    }
            	
            	
            	long k = 0;
            	for (int i = 1; i <= 9; i++)
                    if (state.get(i) != 0) {
                    	k = k+1;
                    }
            	if (k==9) {
            		return 0;
            	} else {
            		long x2 = 0;
            		long x1 = 0;
            		
            		long o2 = 0;
            		long o1 = 0;
            		
            		for (int i = 10; i <= 17; i++)
                        if (state.get(i) == 2) {
                        	x2=x2+1;
                        } else if (state.get(i) == 1) {
                        	x1=x1+1;
                        }
            		
            		for (int i = 18; i <= 25; i++)
                        if (state.get(i) == 2) {
                        	o2=o2+1;
                        } else if (state.get(i) == 1) {
                        	o1=o1+1;
                        }
            		
                	return -3*x2-x1+3*o2+o1;
            	}
      
        	} else {
        		for (int i = 10; i <= 17; i++)
                    if (state.get(i) == 3) {
                    	return 25;
                    }
            	
            	
            	for (int i = 18; i <= 25; i++)
                    if (state.get(i) == 3) {
                    	return -25;
                    }
            	
            	
            	long k = 0;
            	for (int i = 1; i <= 9; i++)
                    if (state.get(i) != 0) {
                    	k = k+1;
                    }
            	if (k==9) {
            		return 0;
            	} else {
            		long x2 = 0;
            		long x1 = 0;
            		
            		long o2 = 0;
            		long o1 = 0;
            		
            		for (int i = 10; i <= 17; i++)
                        if (state.get(i) == 2) {
                        	x2=x2+1;
                        } else if (state.get(i) == 1) {
                        	x1=x1+1;
                        }
            		
            		for (int i = 18; i <= 25; i++)
                        if (state.get(i) == 2) {
                        	o2=o2+1;
                        } else if (state.get(i) == 1) {
                        	o1=o1+1;
                        }
            		
                	return 3*x2+x1-3*o2-o1;
            	}
        	}
        	
        	
        } else {
        	if (state.get(0) == 0) {
        		for (int i = 10; i <= 17; i++)
                    if (state.get(i) == 3) {
                    	return 25;
                    }
            	
            	
            	for (int i = 18; i <= 25; i++)
                    if (state.get(i) == 3) {
                    	return -25;
                    }
            	
            	
            	long k = 0;
            	for (int i = 1; i <= 9; i++)
                    if (state.get(i) != 0) {
                    	k = k+1;
                    }
            	if (k==9) {
            		return 0;
            	} else {
            		long x2 = 0;
            		long x1 = 0;
            		
            		long o2 = 0;
            		long o1 = 0;
            		
            		for (int i = 10; i <= 17; i++)
                        if (state.get(i) == 2) {
                        	x2=x2+1;
                        } else if (state.get(i) == 1) {
                        	x1=x1+1;
                        }
            		
            		for (int i = 18; i <= 25; i++)
                        if (state.get(i) == 2) {
                        	o2=o2+1;
                        } else if (state.get(i) == 1) {
                        	o1=o1+1;
                        }
            		
                	return 3*x2+x1-3*o2-o1;
            	}
      
        	} else {
        		for (int i = 10; i <= 17; i++)
                    if (state.get(i) == 3) {
                    	return -25;
                    }
            	
            	
            	for (int i = 18; i <= 25; i++)
                    if (state.get(i) == 3) {
                    	return 25;
                    }
            	
            	
            	long k = 0;
            	for (int i = 1; i <= 9; i++)
                    if (state.get(i) != 0) {
                    	k = k+1;
                    }
            	if (k==9) {
            		return 0;
            	} else {
            		long x2 = 0;
            		long x1 = 0;
            		
            		long o2 = 0;
            		long o1 = 0;
            		
            		for (int i = 10; i <= 17; i++)
                        if (state.get(i) == 2) {
                        	x2=x2+1;
                        } else if (state.get(i) == 1) {
                        	x1=x1+1;
                        }
            		
            		for (int i = 18; i <= 25; i++)
                        if (state.get(i) == 2) {
                        	o2=o2+1;
                        } else if (state.get(i) == 1) {
                        	o1=o1+1;
                        }
            		
                	return -3*x2-x1+3*o2+o1;
            	}
        	}
        }
    }
}
