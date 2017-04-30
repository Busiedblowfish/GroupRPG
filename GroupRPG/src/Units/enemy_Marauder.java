//Enemy Marauder Unit
package Units;

public class enemy_Marauder implements Statistics {
    private final String name = "Marauder";
    private final String weapon = "Battle Axe";
    private int armor = 3;
    private int speed = 1;
    private int attack_s = 4;
    private int block_s = 3;
    private int health = 15;
    private int endurance = 10;
    private int spirit = 10;

    
    public enemy_Marauder(){}
    
    @Override
    public String getName(){ return name; }
    @Override
    public String getWeapon(){ return weapon; }
    @Override
    public int getArmor(){ return armor; }
    @Override
    public int getSpeed(){ return speed; }
    @Override
    public int getAttack_s(){ return attack_s; }
    @Override
    public int getBlock_s(){ return block_s; }
    @Override
    public int getHealth(){ return health; }
    @Override
    public int getEndurance(){ return endurance; }
    @Override
    public int getSpirit(){ return spirit; }
        
    private void setHealth(int h){ health = h; }
    private void setEndurance(int e){ endurance =  e;}
    private void setSpirit(int s){ spirit = s; }
    
    
    /**
     *
     * @return the formatted string version of Enemy_Marauder statistics
     */
    @Override
    public String getCombineStat() 
    {
        return String.format
        (
            "Name: " + this.getName() + "\n"
            + "Weapon: " + this.getWeapon() + "\n"
            + "Armor: " + this.getArmor() + "\n"
            + "Speed: " + this.getSpeed() + "\n"
            + "Attack: " + this.getAttack_s() + "\n"
            + "Block: " + this.getBlock_s() + "\n"
            + "Health: " + this.getHealth() + "\n"
            + "Endurance: " + this.getEndurance() + "\n"
            + "Spirit: " + this.getSpirit() + "\n"
        );
    }
    
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
//    public void Heavy_Blow(){ 
//        System.out.printf("The enemy Marauder swings with a Heavy Blow.\nTarget suffers -1 Attack for 2 turns.\nCosts Endurance\n");
//    }
//    
//    public void Flame_Bomb(){
//        System.out.printf("The enemy Marauder throws a Flame Bomb.\nTarget suffers 1 damage for 2 turns.\nCosts Spirit\n");
//    }
}
