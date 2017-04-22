//Enemy Rogue Unit
package Units;

public class enemy_Rogue implements Statistics {
    private String name = "Rogue";
    private String weapon = "Dual Swords";
    private int armor = 2;
    private int speed = 3;
    private int attack_s = 3;
    private int block_s = 2;
    private int health = 10;
    private int endurance = 15;
    private int spirit = 10;
    
    public enemy_Rogue(){}
    
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
//        setHealth(getHealth() + 1); setEndurance(getEndurance() + 2); setSpirit(getSpirit() + 1); return 1;
//    }
//    
//    @Override
//    public int Attack(int Defender_health, int Attacker_damage){
//        return Defender_health - Attacker_damage;
//    }
//    
//    public void Double_Strike(){
//        System.out.printf("The enemy Rogue makes a Double Strike.\nUnit receives +1 Speed for 2 turns.\nCosts Endurance\n");
//    }
//    
//    public void Frost_Bomb(){
//        System.out.printf("The enemy Rogue throws a Frost Bomb.\nTarget suffers -1 Speed for 2 turns.\nCosts Spirit\n");
//    }
}
