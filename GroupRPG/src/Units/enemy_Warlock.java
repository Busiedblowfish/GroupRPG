//Enemy Warlock Unit
package Units;

public class enemy_Warlock implements Statistics {
    private String name = "Warlock";
    private String weapon = "Wand";
    private int armor = 1;
    private int speed = 2;
    private int attack_s = 2;
    private int block_s = 1;
    private int health = 10;
    private int endurance = 10;
    private int spirit = 15;
    
    public enemy_Warlock(){}
    
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
//        setHealth(getHealth() + 1); setEndurance(getEndurance() + 1); setSpirit(getSpirit() + 2); return 1;
//    }
//    
//    @Override
//    public int Attack(int Defender_health, int Attacker_damage){
//        return Defender_health - Attacker_damage;
//    }
//        
//    public void Lightning_Bolt(){
//        System.out.printf("The enemy Warlock fires a Lightning Bolt.\nTarget is stunned for 1 turn.\nCosts Endurance\n");
//    }
//    
//    public void Draining_Curse(){
//        System.out.printf("The enemy Warlock casts a Draining Curses.\nTarget suffers 1 damage for 2 turns.\nCosts Spirit\n");
//    }
}
