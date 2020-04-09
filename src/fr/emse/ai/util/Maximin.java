package fr.emse.ai.util;

import java.util.ArrayList;

public class Maximin {

	public static Integer Minvalue(SimpleTwoPlyGameTree<Integer> tree){
        
		if (!tree.isLeaf()) {

			ArrayList<SimpleTwoPlyGameTree<Integer>> children = 
					   tree.getChildren();
			
			for (SimpleTwoPlyGameTree<Integer> child : children) {
				
				if (Maxvalue(child) < tree.getValue()) {
					tree.setValue(child.getValue());
				}
				
				System.out.printf("\n noead est " + child.getValue().toString());
			}
			
			return tree.getValue();
		} else {
			return tree.getValue();
		}
    }
	
	
	public static Integer Maxvalue(SimpleTwoPlyGameTree<Integer> tree){
        
		if (!tree.isLeaf()) {

			ArrayList<SimpleTwoPlyGameTree<Integer>> children = 
					   tree.getChildren();
			
			for (SimpleTwoPlyGameTree<Integer> child : children) {
				
				if (Minvalue(child) > tree.getValue()) {
					tree.setValue(child.getValue());
				}
				
				System.out.printf("\n noead est " + child.getValue().toString());
			}
			
			return tree.getValue();
		} else {
			return tree.getValue();
		}
    }
	
	
public static Integer Minvalueab(SimpleTwoPlyGameTree<Integer> tree, Integer alpha, Integer beta){
        
		if (!tree.isLeaf()) {

			ArrayList<SimpleTwoPlyGameTree<Integer>> children = 
					   tree.getChildren();
			
			for (SimpleTwoPlyGameTree<Integer> child : children) {
				
				if (Maxvalueab(child,alpha,beta) < tree.getValue()) {
					tree.setValue(child.getValue());
				}
				
				if (tree.getValue() < alpha) {
					return tree.getValue();
				}
				
				System.out.printf("\n noead est " + child.getValue().toString() +
						" alpha est " + alpha.toString() +
						" beta est "+ beta.toString()); 
				
				if (child.getValue() < beta) {
					beta = child.getValue();
				}
				
			}
			
			return tree.getValue();
		} else {
			return tree.getValue();
		}
    }
	
	
	public static Integer Maxvalueab(SimpleTwoPlyGameTree<Integer> tree, Integer alpha, Integer beta){
        
		if (!tree.isLeaf()) {

			ArrayList<SimpleTwoPlyGameTree<Integer>> children = 
					   tree.getChildren();
			
			for (SimpleTwoPlyGameTree<Integer> child : children) {
				
				if (Minvalueab(child,alpha,beta) > tree.getValue()) {
					tree.setValue(child.getValue());
				}
				
				if (tree.getValue() > beta) {
					return tree.getValue();
				}
				
				System.out.printf("\n noead est " + child.getValue().toString() +
						" alpha est " + alpha.toString() +
						" beta est "+ beta.toString());
				
				if (child.getValue() > alpha) {
					alpha = child.getValue();
				}
			}
			
			return tree.getValue();
		} else {
			return tree.getValue();
		}
    }
	
	
	public static void main(String[] args) {
       
		SimpleTwoPlyGameTree<Integer> tree1 = 
				new SimpleTwoPlyGameTree<Integer>(Integer.MIN_VALUE,false);
		
		
		ArrayList<SimpleTwoPlyGameTree<Integer>> sublist1 = 
				new ArrayList<SimpleTwoPlyGameTree<Integer>>();
		
    	sublist1.add(new SimpleTwoPlyGameTree<Integer>(3,true));
		sublist1.add(new SimpleTwoPlyGameTree<Integer>(12,true));
		sublist1.add(new SimpleTwoPlyGameTree<Integer>(8,true));
		
		SimpleTwoPlyGameTree<Integer> subtree1 = 
				new SimpleTwoPlyGameTree<Integer>(Integer.MAX_VALUE,false,sublist1);
		
		
		ArrayList<SimpleTwoPlyGameTree<Integer>> sublist2 = 
				new ArrayList<SimpleTwoPlyGameTree<Integer>>();
		
		sublist2.add(new SimpleTwoPlyGameTree<Integer>(2,true));
		sublist2.add(new SimpleTwoPlyGameTree<Integer>(4,true));
		sublist2.add(new SimpleTwoPlyGameTree<Integer>(6,true));
		
		SimpleTwoPlyGameTree<Integer> subtree2 = 
				new SimpleTwoPlyGameTree<Integer>(Integer.MAX_VALUE,false,sublist2);
		
		
		ArrayList<SimpleTwoPlyGameTree<Integer>> sublist3 = 
				new ArrayList<SimpleTwoPlyGameTree<Integer>>();
		
		sublist3.add(new SimpleTwoPlyGameTree<Integer>(14,true));
		sublist3.add(new SimpleTwoPlyGameTree<Integer>(5,true));
		sublist3.add(new SimpleTwoPlyGameTree<Integer>(2,true));
		
		SimpleTwoPlyGameTree<Integer> subtree3 = 
				new SimpleTwoPlyGameTree<Integer>(Integer.MAX_VALUE,false,sublist3);
		
		tree1.addChild(subtree1);
		tree1.addChild(subtree2);
		tree1.addChild(subtree3);
		
		// Integer test = Maxvalue(tree1);
		Integer test = Maxvalueab(tree1,Integer.MIN_VALUE,Integer.MAX_VALUE);
		
		System.out.printf("\n" + tree1.toString()); 
    	
    }
}

