//This class is used to generate all Intelligence type units
package Units.Skills;

import Units.Unit;

public class IntelligenceUnit extends Unit {
    private int armor = 1;
    private int speed = 2;
    private int attack_s = 2;
    private int block_s = 1;
    private int health = 10;
    private int endurance = 10;
    private int spirit = 15;
    
    public IntelligenceUnit(String s){ super(s); }
    
    public int get_Attack_s(){ return attack_s; }
    public int getArmor(){ return armor; }
    public int getSpeed(){ return speed; }
    public int getHealth(){ return health; }
    public int getEndurance(){ return endurance; }
    public int getSpirit(){ return spirit; }
    
    private void setHealth(int h){ health = h; }
    private void setEndurance(int e){ endurance =  e;}
    private void setSpirit(int s){ spirit = s; }
    
    @Override
    public int Recover(){
        setHealth(getHealth() + 1); setEndurance(getEndurance() + 1); setSpirit(getSpirit() + 2); return 1;
    }
    
    //+1 Attack for being Intelligence Unit
//    public int Attack(){ return attack_s + 1; }
//    public int Block(){ return getArmor() + block_s; }

    public Object[] getAttack_s() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[] getBlock_s() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
