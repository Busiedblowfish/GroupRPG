//Enemy Marauder Unit
package Units.EnemyList;

import Units.Skills.Combat;
import Units.Skills.StrengthUnit;

public class enemy_Marauder extends StrengthUnit implements Combat {
    
    private String weapon = "Battle Axe";
    
    public enemy_Marauder(){ super("Marauder"); }
    
    public String getWeapon(){ return weapon; }
    
    public void Heavy_Blow(){ 
        System.out.printf("The enemy Marauder swings with a Heavy Blow.\nTarget suffers -1 Attack for 2 turns.\nCosts Endurance\n");
    }
    
    public void Flame_Bomb(){
        System.out.printf("The enemy Marauder throws a Flame Bomb.\nTarget suffers 1 damage for 2 turns.\nCosts Spirit\n");
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
