//Enemy Rogue Unit
package Units.EnemyList;

import Units.Skills.Combat;
import Units.Skills.DexterityUnit;

public class enemy_Rogue extends DexterityUnit implements Combat {
    
    private String weapon = "Dual Swords";
    
    public enemy_Rogue(){ super("Rogue"); }
    
    public String getWeapon(){ return weapon; }
    
    public void Double_Strike(){
        System.out.printf("The enemy Rogue makes a Double Strike.\nUnit receives +1 Speed for 2 turns.\nCosts Endurance\n");
    }
    
    public void Frost_Bomb(){
        System.out.printf("The enemy Rogue throws a Frost Bomb.\nTarget suffers -1 Speed for 2 turns.\nCosts Spirit\n");
    }
    
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
