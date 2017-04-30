//User playable 2H Strength unit: Debuff Attacks (Endurance) & Debuff Shouts (Spirit)
package Units;

public class Berserker implements Statistics {
    private final String name = "Berserker";    //Variable to overwrite default name
    private final String weapon = "Claymore";
    private int armor = 3;
    private int speed = 1;
    private int attack_s = 4;
    private int block_s = 3;
    private int health = 15;
    private int endurance = 10;
    private int spirit = 10;
    
    public Berserker(){}
    
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
     * @return the formatted string version of Berserker statistics
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
        
//    public void endrSkill_1(){ /*Uses endurance*/ }
//    
//    public void endrSkill_2(){ /*Uses endurance*/ }
//    
//    public void sprtSkill_1(){ /*Uses spirit */ }
//    
//    public void sprtSkill_2(){ /*Uses spirit*/ }
}