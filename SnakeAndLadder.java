package SnakeAndLadder;
import java.util.*;

public class SnL {
	static HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
	static {
		mp.put(1,38);mp.put(4,14);mp.put(9,31);
		mp.put(21,42);mp.put(28,84);mp.put(51,67);
		mp.put(71,91);mp.put(80,100);
		mp.put(17,7);mp.put(54,34);mp.put(62,19);
		mp.put(64,60);mp.put(87,24);mp.put(93,73);
		mp.put(95,75);mp.put(98,79);
	}
	
	public static void main (String args[]) throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		int position1 = 0;
		int position2 = 0;
		boolean player = false;
		//print(0);
		do{
			print(position1, position2);
			System.out.println();
			if(!player) System.out.println("player 11111's turn");
			else System.out.println("player 22222's turn");
			System.out.print("Enter 1 to rotate a cube or 0 to quit ");
			System.out.println();
			int b = sc.nextInt();
			if(b == 1){
				Thread.sleep(500);
				int number = 1 + (int)(Math.random()*(6-1)+1);
				if(!player) position1 +=number;
				else position2 +=number;
				System.out.println("Random Number is " + number);
				//System.out.println();
				Thread.sleep(700);
				if(!player) {
					if(mp.containsKey(position1)){
						int val = position1;
						position1 = mp.get(position1);
						if(val < position1) System.out.println("Wow you got the laddder go to " + position1);
						else System.out.println("Oops snake is here, go down to " + position1);
						System.out.println();
					}
				}else {
					if(mp.containsKey(position2)){
						int val = position2;
						position2 = mp.get(position2);
						if(val < position2) System.out.println("Wow you got the laddder go to " + position2);
						else System.out.println("Oops snake is here, go down to " + position2);
						System.out.println();
					}
				}
				if(!player) System.out.println("Position is " + position1);
				else System.out.println("Position is " + position2);
				System.out.println();
				player = (!player);
			}else if(b == 0) break;
		}while(position1 < 100 || position2 < 100);
		
		if(position1 == 100) System.out.println("Congradulations player 1 won");
		else if(position2 == 100) System.out.println("Congradulations player 2 won");
		else System.out.println("Thank you for playing");
	}
	
	public static void print(int pos1,int pos2){
		int i = 100;
		boolean order = false;
		while(i>0){
			
			if(mp.containsKey(i)){
				int j = mp.get(i);
				if(i>j){
					//snake
					System.out.format("%2d", i);
					System.out.print(" S");
					System.out.format("%2d", j);
					if(i == pos1) System.out.print("*| ");
					else if(i == pos2)System.out.print("@| ");
					else System.out.print(" | ");
					 
				}else{
					//ladder
					System.out.format("%2d", i);
					System.out.print(" L");
					if(j == 100) System.out.print("00");
					else System.out.format("%2d", j);
					if(i == pos1) System.out.print("*| ");
					else if(i == pos2)System.out.print("@| ");
					else System.out.print(" | ");
				}
			}
			else{
				if(i == 100){
					if(i == pos1) System.out.print("00    *| ");
					else if(i == pos2)System.out.print("00    @| ");
					else System.out.print("00     | ");

				}else{
					
					System.out.format("%2d", i);
					if(i == pos1) System.out.print("    *| ");
					else if(i == pos2)System.out.print("    @| ");
					else System.out.print("     | ");
				}
			}
			if((i-1)%10 == 0 && (i-1)%20 != 0){
				System.out.println();
				i = i-10;
				order = true;
				
			}else if(i%10 == 0 && i%20 != 0){
				System.out.println();
				i = i-10;
				order = false;
			} else if(order) i++;
			  else i--;
		}
		
	}	

}
