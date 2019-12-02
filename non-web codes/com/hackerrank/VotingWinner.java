package com.hackerrank;
/*
 * this program finds the winner of maximum votes 
 * from an array of String containing the names of candidates
 */
import java.util.*;

public class VotingWinner {
	public static void main(String[] args) {
		String[] ar  = { "john", "johnny", "jackie",
                "johnny", "john", "jackie",
                "jamie", "jamie", "john",
                "johnny", "jamie", "johnny",
                "john" };
		String winner = findWinner(ar);
		System.out.println(winner);
		}
	
	public static String findWinner(String[] ar){
		int size = ar.length;
		Map<String, Integer> m = new HashMap<String, Integer>();
		
		for(int i = 0; i<size; i++){
			if(m.containsKey(ar[i])){
				m.put(ar[i], m.get(ar[i])+1);
			}
			
			else{
				m.put(ar[i], 1);
			}
		}
		
		int max = 0;
		String winner = "";
		
		Set s = m.entrySet();
		
		Iterator itr = s.iterator();
		
		while(itr.hasNext()){
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) itr.next();
			
			int val = entry.getValue();
			String key = entry.getKey();
			
			if(val > max){
				max = val;
				winner = key;
			}
			else if(val == max && key.compareTo(winner) > 0){
				winner = key;		
			}
		}
		return winner;
	}
	}
