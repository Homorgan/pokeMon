package pokeMon;

import java.util.Scanner;

public class Colosseum {
	public static void main(String[] args){
				
		int diceNums;
		String pokeMon1;
		String pokeMon2;
		
		System.out.println("Player 1, build your Pokemon!");
		System.out.println("=====================");
		
		Scanner player1 = new Scanner(System.in);		//get pokemon name
		System.out.print("Please name your pokemon: ");
		pokeMon1 = player1.next();
		
		System.out.println("");
		Pokemon user1 = new Pokemon();
		user1.userBuild();
		
		System.out.println("Player 2, build your Pokemon!");
		System.out.println("=====================");
		
		//System.out.println("");
		
		Scanner player2 = new Scanner(System.in);		//get pokemon name
		System.out.print("Please name your pokemon: ");
		pokeMon2 = player2.next();
		System.out.println("");
		
		Pokemon user2 = new Pokemon();
		user2.userBuild();

		
		System.out.println("Player 1 will roll a D2, to decides who goes first.");
		die di2_1 = new die(2);
		for(int i = 0; i<1; i++){
			int roll = di2_1.roll();
			if(roll == 1){
				System.out.println("Player 1 rolls a " + roll + " and will go first");
				for(int j = 1; j<=10; j++){
				System.out.println("");
				System.out.println("Round " + j + "!");
				System.out.println(" ");
				System.out.println(pokeMon1 + " is attacking " + pokeMon2);
				if(user1.attack_rolls(pokeMon1, user1.get_attackBonus(), pokeMon2, user2.get_defenseBonus())){
					user2.get_health(user1.attacks());
					if(user2.healthcheck()>0)
					System.out.println(pokeMon2 + " " + user2.healthcheck() + " hit points left");
					else {
						System.out.println(pokeMon2 + " have been defeated!");
						break;
					}
				}
				else {
					System.out.println("Attacked missed!");
				}
				System.out.println(pokeMon2 + " is attacking " + pokeMon1);
				if(user2.attack_rolls(pokeMon2, user2.get_attackBonus(), pokeMon1, user1.get_defenseBonus())){
					user1.get_health(user2.attacks());
					if(user1.healthcheck()>0)
					System.out.println(pokeMon1 + " " + user1.healthcheck() + " hits points left");
					else{
						System.out.println(pokeMon1 + " have been defeated!");
						break;
					}
				}
				else {
					System.out.println("Attack missed!");
				}
			}
			}
			else{
				System.out.println("Player 1 rolls a " + roll + " and will go second");
				System.out.println("");
				for(int j = 1; j<=10; j++){
				System.out.println(" ");	
				System.out.println("Round " + j + "!");
				System.out.println(" ");
				System.out.println(pokeMon2 + " is attacking " + pokeMon1);
				if(user2.attack_rolls(pokeMon2, user2.get_attackBonus(), pokeMon1, user1.get_defenseBonus())){
					user1.get_health(user2.attacks());
					if(user1.healthcheck()>0)
					System.out.println(pokeMon1 + " " + user1.healthcheck() + " hits points left");
					else {
						System.out.println(pokeMon1 + " have been defeated!");
						break;
					}
				}
				else {
					System.out.println("Attack missed!");
				}
				System.out.println(pokeMon1 + " is attacking " + pokeMon2);
				if(user1.attack_rolls(pokeMon1, user1.get_attackBonus(), pokeMon2, user2.get_defenseBonus())){
					user2.get_health(user1.attacks());
					if(user2.healthcheck()>0)
					System.out.println(pokeMon2 + " " +  user2.healthcheck()+ " hit points left");
					else {
						System.out.println(pokeMon2 + " have been defeated!");
						break;
					}
				}
				else {
					System.out.println("Attacked missed!");
				}

			}
		}
		
	}
		if(user1.healthcheck()>0 && user2.healthcheck()>0){
		System.out.println("Both fighters are still standing! It's a draw!");
		}

}}
