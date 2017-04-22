//Object Oriented Programming - Spring 2017
//Group Project
package Units;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class GroupRPG {
    static Scanner scanner = new Scanner(System.in);
    static String buffer = "";
    
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGUI().setVisible(true);
            }
        });
        
        // TODO code application logic here
        System.out.printf("+=============+\n");
        System.out.printf("|  GROUP RPG  |\n");
        System.out.printf("+=============+\n\n");
        
        while(!(buffer.matches("[2](.*)"))){
            
            System.out.printf("\nEnter Option number:\n");
            System.out.printf("<1> Play\n");
            System.out.printf("<2> Quit\n");
            System.out.printf("Input: ");
            buffer = scanner.next();
     
            if(buffer.matches("[1](.*)")){
                newGame();
            }
        }   
    }
    
    public static void newGame(){
        System.out.printf("\n+=============+\n");
        System.out.printf("|  New Game   |\n");
        System.out.printf("+=============+\n");
        System.out.printf("Select Character:\n");
        System.out.printf("<1> Berserker, Claymore (Strength)\n");
        System.out.printf("<2> Juggernaut, Sword and Shield (Strength)\n");
        System.out.printf("<3> Barbarian, Dual Axes (Dexterity)\n");
        System.out.printf("<4> Marksman, Bow (Dexterity)\n");
        System.out.printf("<5> Witch Doctor, Torch (Intelligence)\n");
        System.out.printf("<6> Psychic, Dagger (Intelligence)\n");
        for(int n = 0; n < 3; n++){
            System.out.printf("Choose character %d: ", n+1);
                buffer = scanner.next();
        }
        
        ArrayList<Statistics> PlayerList = new ArrayList<>();
        
        int n = -1;
        if(buffer.matches("[1](.*)")){
            Berserker berserker = new Berserker();
            PlayerList.add(berserker);
        }
        else if(buffer.matches("[2](.*)")){
            Juggernaut juggernaut = new Juggernaut();
            PlayerList.add(juggernaut);
        }
        else if(buffer.matches("[3](.*)")){
            Barbarian barbarian = new Barbarian();
            PlayerList.add(barbarian);
        }
        else if(buffer.matches("[4](.*)")){
            Marksman marksman = new Marksman();
            PlayerList.add(marksman);
        }
        else if(buffer.matches("[5](.*)")){
            WitchDoctor witchdoctor = new WitchDoctor();
            PlayerList.add(witchdoctor);
        }
        else if(buffer.matches("[6](.*)")){
            Psychic psychic = new Psychic();
            PlayerList.add(psychic);
        }
        
        ArrayList<Statistics> EnemyList = new ArrayList<>();
        
        Random rand = new Random();
        n = rand.nextInt(6) + 1;
        if(n == 1){  
            enemy_Marauder marauder = new enemy_Marauder();
            EnemyList.add(marauder);
        }
        else if(n == 2){  
            enemy_Brute brute = new enemy_Brute();
            EnemyList.add(brute);
        }
        else if(n == 3){  
            enemy_Rogue rogue = new enemy_Rogue();
            EnemyList.add(rogue);
        }
        else if(n == 4){  
            enemy_Assassin assassin = new enemy_Assassin();
            EnemyList.add(assassin);
        }
        else if(n == 5){  
            enemy_Summoner summoner =  new enemy_Summoner();
            EnemyList.add(summoner);
        }
        else if(n == 6){  
            enemy_Warlock warlock = new enemy_Warlock();
            EnemyList.add(warlock);
        }
        
        System.out.printf("\nName: %s\n", PlayerList.get(0).getName());
        System.out.printf("Weapon: %s\n", PlayerList.get(0).getWeapon());
        System.out.printf("Armor: %d\n", PlayerList.get(0).getArmor());
        System.out.printf("Speed: %d\n", PlayerList.get(0).getSpeed());
        System.out.printf("Attack: %d\n", PlayerList.get(0).getAttack_s());
        System.out.printf("Block: %d\n", PlayerList.get(0).getBlock_s());
        System.out.printf("Health: %d\n", PlayerList.get(0).getHealth());
        System.out.printf("Endurance: %d\n", PlayerList.get(0).getEndurance());
        System.out.printf("Spirit: %d\n", PlayerList.get(0).getSpirit());
        
        System.out.printf("\nName: %s\n", EnemyList.get(0).getName());
        System.out.printf("Weapon: %s\n", EnemyList.get(0).getWeapon());
        System.out.printf("Armor: %d\n", EnemyList.get(0).getArmor());
        System.out.printf("Speed: %d\n", EnemyList.get(0).getSpeed());
        System.out.printf("Attack: %d\n", EnemyList.get(0).getAttack_s());
        System.out.printf("Block: %d\n", EnemyList.get(0).getBlock_s());
        System.out.printf("Health: %d\n", EnemyList.get(0).getHealth());
        System.out.printf("Endurance: %d\n", EnemyList.get(0).getEndurance());
        System.out.printf("Spirit: %d\n", EnemyList.get(0).getSpirit());
    }
}