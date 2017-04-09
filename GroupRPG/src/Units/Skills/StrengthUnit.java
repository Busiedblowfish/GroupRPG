//This class is used to generate all Strength type units
package Units.Skills;

import Units.Unit;

public class StrengthUnit extends Unit {
    private int armor = 3;
    private int speed = 1;
    private int attack_s = 4;
    private int block_s = 3;
    private int health = 15;
    private int endurance = 10;
    private int spirit = 10;
    
    public StrengthUnit(String s){ super(s); }
    
    public int get_Attack_s(){ return attack_s; }
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
    
    @Override
    public int Recover(){
        setHealth(getHealth() + 2); setEndurance(getEndurance() + 1); setSpirit(getSpirit() + 1); return 1;
    }
    
    //+3 Attack for being Strength Unit
//    public int Attack(){ return attack_s + 3; }
//    public int Block(){ return getArmor() + block_s; }
}
