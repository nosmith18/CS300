//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
import java.util.ArrayList;

public class WinterCarnival extends SimulationEngine {
  
    public static void main(String[] args) {
    WinterCarnival s = new WinterCarnival();
  }
    
  private ArrayList<FrozenStatue> objects = new ArrayList<FrozenStatue>();
  
  /*
   * WinterCarnival Constructor which adds FrozenStatue, StarshipRobot, and Dancing Badger objects
   * to the objects ArrayList
   */
  public WinterCarnival() {
    objects.add(new FrozenStatue(new float[]{600,100}));
    objects.add(new FrozenStatue(new float[]{200,500}));
    objects.add(new StarshipRobot(new float[][] {{0,0},{600,100}}));
    objects.add(new StarshipRobot(new float[][] {{800,300},{200,500}}));
    
    DanceStep[] steps = new DanceStep[] {DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left, 
        DanceStep.Down, DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left, DanceStep.Up}; //Order of steps for DancingBadgers
    
    objects.add(new DancingBadger(new float[] {304,268}, steps));
    objects.add(new DancingBadger(new float[] {368,268}, steps));
    objects.add(new DancingBadger(new float[] {432,268}, steps));
    objects.add(new DancingBadger(new float[] {496,268}, steps));
  }
  
  /*
   * This method is the overridden version of update from the Simulation Engine class, to 
   * describe how this simulation should change and be updated over time. This method will 
   * automatically be called repeatedly, until the program is terminated on any new 
   * SimulationEngine that is created.
   */
  @Override
  public void update() {
    for(int i = 0; i<objects.size(); i++) {
      objects.get(i).update(this);
    }
  }
  


}
