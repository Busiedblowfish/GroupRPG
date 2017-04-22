//Enemy Brute Unit
package Units;

public class enemy_Brute implements Statistics {
    private String name = "Brute";
    private String weapon = "Mace and Shield";
    private int armor = 3;
    private int speed = 1;
    private int attack_s = 4;
    private int block_s = 3;
    private int health = 15;
    private int endurance = 10;
    private int spirit = 10;
    
    public enemy_Brute(){}
    
    public String getName(){ return name; }
    public String getWeapon(){ return weapon; }
    public int getArmor(){ return armor; }
    public int getSpeed(){ return speed; }
    public int getAttack_s(){ return attack_s; }
    public int getBlock_s(){ return block_s; }
    public int getHealth(){ return health; }
    public int getEndurance(){ return endurance; }
    public int getSpirit(){ return spirit; }    
    
    private void setHealth(int h){ health = h; }
    private void setEndurance(int e){ endurance =  e;}
    private void setSpirit(int s){ spirit = s; }
    
//    @Override
//    public int Recover(){
//        setHealth(getHealth() + 2); setEndurance(getEndurance() + 1); setSpirit(getSpirit() + 1); return 1;
//    }
//    
//    @Override
//    public int Attack(int Defender_health, int Attacker_damage){
//        return Defender_health - Attacker_damage;
//    }
//    
//    public void Staggering_Blow(){
//        System.out.printf("The enemy Brute strikes with a Staggering Blow.\nTarget is stunned for 1 turn.\nCosts Endurance\n");
//    }
//    
//    public void Defensive_Stance(){ 
//        System.out.printf("The enemy Brute takes a Defensive Stance.\nUnit receives +1 Armor for 2 turns.\nCosts Spirit.\n");
//    }
}
