//User playable Mage unit: Direct Magic Attack (Endurance) & Area of Effect Attack (Spirit)
package Units.PlayerList;

import Units.Skills.Combat;
import Units.Skills.IntelligenceUnit;

public class Psychic extends IntelligenceUnit implements Combat {
    private String name;    //Variable to overwrite default name
    private String weapon = "Dagger";
    
    public Psychic(){ super("Psychic"); }
    
    public Psychic(String s){ super(s); }
    
    public String getWeapon(){ return weapon; }
    
    public void endrSkill_1(){ /*Uses endurance*/ }
    
    public void endrSkill_2(){ /*Uses endurance*/ }
    
    public void sprtSkill_1(){ /*Uses spirit */ }
    
    public void sprtSkill_2(){ /*Uses spirit*/ }    
    
//    @Override
//    public int Attack(int Defender_health, int Attacker_damage){
//        return Defender_health - Attacker_damage;
//    }

    @Override
    public int Attack(Combat Attacker, Combat Defender) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Block(Combat Defender, Combat Attacker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
