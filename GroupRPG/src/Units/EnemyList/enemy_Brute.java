//Enemy Brute Unit
package Units.EnemyList;

import Units.Skills.Combat;
import Units.Skills.StrengthUnit;

public class enemy_Brute extends StrengthUnit implements Combat {
    
    private String weapon = "Mace and Shield";
    
    public enemy_Brute(){ super("Brute"); }
    
    public String getWeapon(){ return weapon; }
    
    public void Staggering_Blow(){
        System.out.printf("The enemy Brute strikes with a Staggering Blow.\nTarget is stunned for 1 turn.\nCosts Endurance\n");
    }
    
    public void Defensive_Stance(){ 
        System.out.printf("The enemy Brute takes a Defensive Stance.\nUnit receives +1 Armor for 2 turns.\nCosts Spirit.\n");
    }


    @Override
    public int Attack(Combat Attacker, Combat Defender) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Block(Combat Defender, Combat Attacker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
