package pokeMon1;

import java.util.Scanner;

public class Pokemon {
	private int health, attack_bonus, defense_bonus;		//health, attack points, and defense points
	private static String myPokemon;		//name of pokemon
	private int d20, d6;		//twenty and six sided dice
	int damage;
	int sum;
	
	public Pokemon(){
		int health = 0, attack = 0, defense = 0;		//Initializes all numeric data to zero and strings to "" (the empty string)
		String myPokemon = "";

		
	}
	
	public int attack(int acttack_roll, int defense_roll){
		
		if((acttack_roll+get_attackBonus())>(defense_roll+get_defenseBonus())){
			die di6_1 = new die(6);
//			die di6_2 = new die(6);
//			die di6_3 = new die(6);
			int dice6a = di6_1.roll();
			int dice6b = di6_1.roll();
			int dice6c = di6_1.roll();
			damage = dice6a + dice6b + dice6c;
			System.out.println("The attack hits dealing 3-D6 damage!");
			System.out.println("The rolls are are " + dice6a + ", " + dice6b + " and " + dice6c + " totaling: "+ damage + " damage!" );
			
		}
		else{
			damage = 0;
			System.out.println("The attack missed!");
		}
		return damage;
	}
	public int attacks(){
		
			die di6_1 = new die(6);
			int dice6a = di6_1.roll();
			int dice6b = di6_1.roll();
			int dice6c = di6_1.roll();
			damage = dice6a + dice6b + dice6c;
			System.out.println("The attack hits dealing 3-D6 damage!");
			System.out.println("The rolls are are " + dice6a + ", " + dice6b + " and " + dice6c + " totaling: "+ damage + " damage!" );
			
		return damage;
	}
	public int set_attackBonus(int attackBonus){
		return attackBonus = d20;
		}
	public int set_defenseBonus(int defenseBonus){
		return defenseBonus = d20;
	}
	public int get_attackBonus(){
		return attack_bonus;
	}
	public int get_defenseBonus(){
		return defense_bonus;
	}
	public static String set_name(String name){
		return myPokemon = name;
	}
	public static String get_name(){
		return myPokemon;
	}
	public int set_health(int health){
		return health;
	}
	public int get_health(int damage){
		health = health - damage;
		return health;
	}
	public int healthcheck(){
		return health;
	}
	public boolean attack_rolls (String poke1, int Attacker, String poke2, int Defender){
		die d20 = new die(20);
		int attack_die = d20.roll() + Attacker;
		int defend_die = d20.roll() + Defender;
		System.out.println(poke1 + " rolls an attack bonus of " + attack_die);
		System.out.println(poke2 + " rolls a defense bonus " + defend_die);
		if(attack_die>defend_die)
			return true;
		else
			return false;
	}
	public void userBuild(){
		
			//Scanner myScan = new Scanner(System.in);		//get pokemon name
		//System.out.print("Please name your pokemon: ");
		//myPokemon = myScan.next();
		
		//System.out.println("");
		do{
			System.out.print("How many hit points will it have? (1-50): ");			//get hp between 1 and 50
			Scanner myScan1 = new Scanner(System.in);
			health = myScan1.nextInt();
		}while(health>0 != health<51);
		
		System.out.println("");
		System.out.println("Split fifty points between attack level and defense level ");		//get attack between 1 and 49
		System.out.print("Enter your attack level (1-49): ");
		while(attack_bonus>0 != attack_bonus<50){
		Scanner myScan2 = new Scanner(System.in);
			attack_bonus = myScan2.nextInt();
			System.out.println("");
			if(attack_bonus>0 != attack_bonus<50)
			System.out.print("Sorry. The attack level must be between 1 and 49: ");
			}
		//System.out.println("");
		int sum = (50 - attack_bonus);
		System.out.print("Enter your defense level (1-" + sum + "): ");			//get defense between 1 and attack subtracted from 50
		while(defense_bonus>0 != defense_bonus<=sum){
			Scanner myScan3 = new Scanner(System.in);
			defense_bonus = myScan3.nextInt();
			System.out.println("");
			if(defense_bonus>0 != defense_bonus<=sum)
			System.out.print("Sorry. The defense level must be between 1 and " + sum + ": ");
		}
		
		
	}
	
}

	