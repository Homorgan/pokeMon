#include <iostream>
#include <string>
#include <sstream>
#include <unistd.h>

using namespace std;

struct pokeMon {
	string user_name;
	string name;
	int health;
	int att_bonus;
	int def_bonus;
};

pokeMon user_build (pokeMon user);
void user_print (pokeMon user);
int die (int sides);
int die_def (int sides);
void battle (pokeMon user, pokeMon user1);
void Menu();
bool hit(int attack, int defense);

int main() {
	Menu();
	pokeMon user1;
	pokeMon user2;
	user1.user_name = "User1";
	user2.user_name = "User2";
	user1 = user_build(user1);
	user2 = user_build(user2);
	cout << user1.user_name << " has fliiped a coin to see who will attack first!\n";
	if(die(2)>1){
		cout << user1.user_name << " has flipped a head and will go first.\n";
		battle(user1, user2);
	}
	else {
		cout << user1.user_name << " has flipped a tail and will go second.\n";
		battle(user2, user1);
	}
//	user_print (user2);
//	battle (user2, user1);
//	battle (user1, user2);
		
	return 0;
}	

pokeMon user_build(pokeMon user)
{
		cout << user.user_name << ", please enter your Pokenmon's name: ";
		cin >> user.name;
		cout << "Please enter your pokemon's health: ";
		cin >> user.health;
		while (user.health < 1 || user.health > 50)
		{
			cout << user.user_name << ", your pokemon's health must be between 1 and 50. \n";
			cout << "Please enter your pokemon's health: ";
			cin >> user.health;
		} 

		cout << "You now must enter your attack bonus.\n";
		cout << "Your pokemon's attack bonus must be between 1 and 49. \n";
		cout << "Please enter your pokemon's attack level: ";
		cin >> user.att_bonus;
		while (user.att_bonus < 1 || user.att_bonus > 49)
		{
			cout <<  user.user_name << ", your pokemon's attack bonus is not between 1 and 49. \n";
			cout << "Please enter your pokemon's attack level: ";
			cin >> user.att_bonus;
			return user;
		}
		
		cout << user.user_name << ", your pokemon's defense bonus needs to be between 1 and ";
		cout << 50 - user.att_bonus << ".\n";
		cout << "Please enter your pokemon's defense bonus: ";
		cin >> user.def_bonus;
		while (user.def_bonus < 1 || user.def_bonus > (50 - user.att_bonus))
		{
			cout << user.user_name << ", your pokemon's defense bonus needs to be between 1 and ";
			cout << 50 - user.att_bonus << ".\n";
			cout << "Please enter your pokemon's defense level: ";
			cin >> user.def_bonus;
		}
	return user;
}
void user_print (pokeMon user)
{
	cout << user.user_name << ", your pokemon's name is " << user.name << ".\n";
	cout << user.name << "'s health is " << user.health << ".\n";
	cout << "\n";
}
int die (int sides)
{
	int numfaces;
	int roll;
	srand (time(NULL));
	numfaces = sides;
//	cout << "You rolled " << (rand() %numfaces+1) << "\n";
	for (int j = 1; j < 50000000; j++){
	roll =  (rand() %numfaces+1);
	}
	return roll;
}
int die_def (int sides)
{
	int numfaces;
	int roll;
	srand (time(0));
	numfaces = sides;
	for (int j = 1; j < 50000000; j++){
	roll =  (rand() %numfaces+1);
	}
	return roll;
}
void battle (pokeMon attacker, pokeMon defender)
{
	int att_die;
	int att_die2;
	int def_die;
	int def_die2;
	int damage;
	string enter;
	for (int i = 1; i < 11; i++)
	{
		cout << "Round " << i << "!!!\n";
		cout << "";
	att_die = die(20) + attacker.att_bonus;
	def_die = die(20) + defender.def_bonus;
	cout << attacker.name << " is attacking " << defender.name << "!\n";
	if(hit(att_die, def_die)) {
		damage = die(6) + die(6) + die(6);
		cout << attacker.name << " has hit " << defender.name << " and has inflicted " << damage << " points of damage.\n";
		defender.health = defender.health - damage;
	if(defender.health<1){
		cout << defender.name << " has lost.\n";
		break;
	}
	else {
		cout << defender.name << " has " << defender.health << " health points left.\n";
	}
	}
	att_die2 = die(20) + defender.att_bonus;
	def_die2 = die(20) + attacker.def_bonus;
	cout << defender.name << " is attacking " << attacker.name << "!\n";
	if(hit(att_die2, def_die2)) {
		damage = die(6) + die(6) + die(6);
		cout << defender.name << " has hit " << attacker.name << " and has inflicted " << damage << " points of damage.\n";
		attacker.health = attacker.health - damage;
	if(attacker.health<1) {
		cout << attacker.name << " has lost.\n";
		break;
	}
	else {
		cout << attacker.name << " has " << attacker.health << " health points left.\n";
	}
	}
	}
}
void Menu ()
{
	cout << "Welcome to the game.  This game has two players.\n";
	cout << " \n";
}
bool hit (int attack, int defense)
{
	if(attack>defense) {
	return true;
	}
	else {
		return false;
	}
}