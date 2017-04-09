//This is the abstract unit class. All unique and enemy characters will be generated from this class
package Units;

public abstract class Unit {
    private String name = "";
    
    public Unit(){}
    
    public Unit(String n){
        setName(n);
    }
    
    private void setName(String n){
        name = n;
    }
    
    public String getName(){
        return name;
    }
    
    //Units are awarded health, endurance, and spirit for surviving a round of attacks
    //Unit returns 1 on successful Recover
    public abstract int Recover();
}
