//User playable 1H/Shield Strength unit: Stuns (Endurance) & Buff Shouts (Spirit)
package Units;

public class Juggernaut implements Statistics {
    private String name = "Juggernaut";    //Variable to overwrite default name
    private String weapon = "Sword and Shield";
    private int armor = 3;
    private int speed = 1;
    private int attack_s = 4;
    private int block_s = 3;
    private int health = 15;
    private int endurance = 10;
    private int spirit = 10;
    
    public Juggernaut(){}
    
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
            
//    public void endrSkill_1(){ /*Uses endurance*/ }
//    
//    public void endrSkill_2(){ /*Uses endurance*/ }
//    
//    public void sprtSkill_1(){ /*Uses spirit*/ }
//    
//    public void sprtSkill_2(){ /*Uses spirit*/ }
}