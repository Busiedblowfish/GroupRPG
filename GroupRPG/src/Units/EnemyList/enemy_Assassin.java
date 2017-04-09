//Enemy Rogue Unit
package Units.EnemyList;

import Units.Skills.Combat;
import Units.Skills.DexterityUnit;

public class enemy_Assassin extends DexterityUnit implements Combat {
    
    private String weapon = "Crossbow";
    
    public enemy_Assassin(){ super("Crossbow"); }
    
    public String getWeapon(){ return weapon; }
    
    public void Puncturing_Bolt(){
        System.out.printf("The enemy Assassin fires a Puncturing Bolt.\nTarget suffers -1 Armor for 2 turns.\nCosts Endurance\n");
    }
    
    public void Poisonous_Bolt(){
        System.out.printf("The enemy Assassin fires a Poisonous Bolt.\nTarget suffers 1 damage for 2 turns.\nCosts Spirit\n");
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
