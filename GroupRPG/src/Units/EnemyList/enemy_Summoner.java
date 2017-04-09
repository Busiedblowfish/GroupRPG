//Enemy Summoner Unit
package Units.EnemyList;

import Units.Skills.Combat;
import Units.Skills.IntelligenceUnit;

public class enemy_Summoner extends IntelligenceUnit implements Combat {
    private String weapon = "Flail";
    
    public enemy_Summoner(){ super("Summoner"); }
    
    public String getWeapon(){ return weapon; }
    
    public void Rending_Lash(){
        System.out.printf("The enemy Summoner strikes with a Rending Lash.\nTarget suffers 1 damage for 2 turns.\nCosts Endurance\n");
    }
    
    public void Malevolent_Shade(){
        System.out.printf("The enemy Summoner commands a Malevolent Shade.\nIf there is an empty tile, the unit is summoned.\nCosts Spirit\n");
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
