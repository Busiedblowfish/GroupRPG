//Enemy Rogue Unit
package Units;

public class enemy_Rogue implements Statistics {
    private final String name = "Rogue";
    private final String weapon = "Dual Swords";
    private int armor = 2;
    private int speed = 3;
    private int attack_s = 3;
    private int block_s = 2;
    private int health = 10;
    private int endurance = 15;
    private int spirit = 10;
    
    public enemy_Rogue(){}
    
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
    
    @Override
    public void setHealth(int h){ health += h; }
    @Override
    public void setEndurance(int e){ endurance +=  e;}
    @Override
    public void setSpirit(int s){ spirit += s; }    
    
    /**
     *
     * @return the formatted string version of Enemy_Rogue statistics
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

}
