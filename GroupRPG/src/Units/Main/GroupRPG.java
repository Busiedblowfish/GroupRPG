//Object Oriented Programming - Spring 2017
//Group Project
package Units.Main;
import Units.Skills.StrengthUnit;
import Units.Skills.IntelligenceUnit;
import Units.Skills.Combat;
import Units.Skills.DexterityUnit;
import Units.PlayerList.Juggernaut;
import Units.PlayerList.Marksman;
import Units.PlayerList.Psychic;
import Units.PlayerList.WitchDoctor;
import Units.PlayerList.Barbarian;
import Units.PlayerList.Berserker;
import Units.EnemyList.enemy_Assassin;
import Units.EnemyList.enemy_Marauder;
import Units.EnemyList.enemy_Rogue;
import Units.EnemyList.enemy_Warlock;
import Units.EnemyList.enemy_Brute;
import Units.EnemyList.enemy_Summoner;
import Units.Unit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class GroupRPG {
    static Scanner scanner = new Scanner(System.in);
    static String buffer = "";
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.printf("+=============+\n");
        System.out.printf("|  GROUP RPG  |\n");
        System.out.printf("+=============+\n\n");
        
        while(!(buffer.matches("[3](.*)"))){
            
            System.out.printf("\nEnter Option number:\n");
            System.out.printf("<1> View Units\n");
            System.out.printf("<2> Play\n");
            System.out.printf("<3> Quit\n");
            System.out.printf("Input: ");
            buffer = scanner.next();
        
            if(buffer.matches("[1](.*)")){
                System.out.printf("\n+=============+\n");
                System.out.printf("|    Units    |\n");
                System.out.printf("+=============+\n");
                System.out.printf("Enter Option number:\n");
                System.out.printf("<1> Base Class Units\n");
                System.out.printf("<2> Playable Units\n");
                System.out.printf("<3> Enemy Units\n");
                buffer = scanner.next();
                
                if(buffer.matches("[1](.*)")){
                    getBaseUnits();
                }
                else if(buffer.matches("[2](.*)")){
                    getPlayableUnits();
                }
                else if(buffer.matches("[3](.*)")){
                    getEnemyUnits(); 
                }
            }
            else if(buffer.matches("[2](.*)")){
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
        System.out.printf("Input: ");
        buffer = scanner.next();
        
        ArrayList<Unit> PlayerList = new ArrayList<>();
        
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
        
        ArrayList<Combat> EnemyList = new ArrayList<>();
        
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
        
        for(Unit player: PlayerList){
            System.out.println(player); //
            //System.out.println(player.get_Attack_s());
            //System.out.println(player.Block());
        }
        
        for(Combat enemy: EnemyList){
            System.out.println(enemy);
            //System.out.println(enemy.Attack());
            //System.out.println(enemy.Block());
        }
        
//        System.out.printf("Player: %s\n", UnitList.getName());
//        System.out.printf("Enemy: %s\n", UnitList[1].getName());
    }
    
    public static void getBaseUnits(){
        StrengthUnit strength = new StrengthUnit("Strength");
        DexterityUnit dexterity = new DexterityUnit("Dexterity");
        IntelligenceUnit intelligence = new IntelligenceUnit("Intelligence");
        
        //Print Strength unit stats
        System.out.printf("Base Units:\n");
        System.out.printf("Name: %s\n", strength.getName());
        System.out.printf("Armor: %d\n", strength.getArmor());
        System.out.printf("Speed: %d\n", strength.getSpeed());
        System.out.printf("Health: %d\n", strength.getHealth());
        System.out.printf("Endurance: %d\n", strength.getEndurance());
        System.out.printf("Spirit: %d\n", strength.getSpirit());
        System.out.printf("Attack: %d\n", strength.getAttack_s());
        System.out.printf("Block: %d\n\n", strength.getBlock_s());
        
        //Print Dexterity unit stats
        System.out.printf("Name: %s\n", dexterity.getName());
        System.out.printf("Armor: %d\n", dexterity.getArmor());
        System.out.printf("Speed: %d\n", dexterity.getSpeed());
        System.out.printf("Health: %d\n", dexterity.getHealth());
        System.out.printf("Endurance: %d\n", dexterity.getEndurance());
        System.out.printf("Spirit: %d\n", dexterity.getSpirit());
        System.out.printf("Attack: %d\n", dexterity.getAttack_s());
        System.out.printf("Block: %d\n\n", dexterity.getBlock_s());
        
        //Print Intelligence unit stats
        System.out.printf("Name: %s\n", intelligence.getName());
        System.out.printf("Armor: %d\n", intelligence.getArmor());
        System.out.printf("Speed: %d\n", intelligence.getSpeed());
        System.out.printf("Health: %d\n", intelligence.getHealth());
        System.out.printf("Endurance: %d\n", intelligence.getEndurance());
        System.out.printf("Spirit: %d\n", intelligence.getSpirit());
        System.out.printf("Attack: %d\n", intelligence.getAttack_s());
        System.out.printf("Block: %d\n\n", intelligence.getBlock_s());
    }
    
    public static void getPlayableUnits(){
        Berserker berserker = new Berserker();
        Juggernaut juggernaut = new Juggernaut();
        Barbarian barbarian = new Barbarian();
        Marksman marksman = new Marksman();
        WitchDoctor witchdoctor = new WitchDoctor();
        Psychic psychic = new Psychic();
        
        System.out.printf("Playable Units:\n");
        System.out.printf("%s, %s\n", berserker.getName(), berserker.getWeapon());
        System.out.printf("%s, %s\n", juggernaut.getName(), juggernaut.getWeapon());
        System.out.printf("%s, %s\n", barbarian.getName(), barbarian.getWeapon());
        System.out.printf("%s, %s\n", marksman.getName(), marksman.getWeapon());
        System.out.printf("%s, %s\n", witchdoctor.getName(), witchdoctor.getWeapon());
        System.out.printf("%s, %s\n\n", psychic.getName(), psychic.getWeapon());
    }
    
    public static void getEnemyUnits(){
        enemy_Marauder marauder = new enemy_Marauder();
        enemy_Brute brute = new enemy_Brute();
        enemy_Rogue rogue = new enemy_Rogue();
        enemy_Assassin assassin = new enemy_Assassin();
        enemy_Summoner summoner = new enemy_Summoner();
        enemy_Warlock warlock = new enemy_Warlock();
        
        System.out.printf("Enemy Units:\n");
        System.out.printf("%s, %s\n", marauder.getName(), marauder.getWeapon());
        System.out.printf("%s, %s\n", brute.getName(), brute.getWeapon());
        System.out.printf("%s, %s\n", rogue.getName(), rogue.getWeapon());
        System.out.printf("%s, %s\n", assassin.getName(), assassin.getWeapon());
        System.out.printf("%s, %s\n", summoner.getName(), summoner.getWeapon());
        System.out.printf("%s, %s\n\n", warlock.getName(), warlock.getWeapon());
    }
}