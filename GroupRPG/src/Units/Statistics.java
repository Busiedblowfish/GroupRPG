package Units;

public interface Statistics {
        
    //public int Attack(int Defender_health, int Attacker_health);
    //public int Recover();
    //public int Block();
    
    public String getName();
    public String getWeapon();
    public int getArmor();
    public int getSpeed();
    public int getAttack_s();
    public int getBlock_s();
    public int getHealth();
    public int getEndurance();
    public int getSpirit();
    public void setHealth(int h);
    public void setEndurance(int e);
    public void setSpirit(int s);
    public String getCombineStat();
}
