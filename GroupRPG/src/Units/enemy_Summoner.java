//Enemy Summoner Unit
package Units;

public class enemy_Summoner implements Statistics {
    private final String name = "Summoner";
    private final String weapon = "Flail";
    private int armor = 1;
    private int speed = 2;
    private int attack_s = 2;
    private int block_s = 1;
    private int health = 10;
    private int endurance = 10;
    private int spirit = 15;
    
    public enemy_Summoner(){}
    
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
     * @return the formatted string version of Enemy_Summoner statistics
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
