//This class is used to generate all Strength type units
package Units.Skills;

import Units.Unit;

public class DexterityUnit extends Unit {
    private int armor = 2;
    private int speed = 3;
    private int attack_s = 3;
    private int block_s = 2;
    private int health = 10;
    private int endurance = 15;
    private int spirit = 10;
    
    public DexterityUnit(String s){ super(s); }
    
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
        setHealth(getHealth() + 1); setEndurance(getEndurance() + 2); setSpirit(getSpirit() + 1); return 1;
    }
    
    //+2 Attack for being Dexterity Unit
//    public int Attack(){ return attack_s + 2; }
//    public int Block(){ return getArmor() + block_s; }

    public Object[] getAttack_s() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[] getBlock_s() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
