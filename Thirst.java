//Thirst.java
import java.util.*;

public class Thirst extends AbsAttr{
  protected ArrayList<String> states = new ArrayList<String>();
  protected double state;

  public Thirst(){
    this.state = 3.0;
    this.states.add("Dehydrated");
    this.states.add("Thirsty");
    this.states.add("Fine");
    this.states.add("Bloated");
  }

  public String getState(){
    if(3.1 < this.state && this.state < 4.0){
      return this.states.get(3);
    } else if(2.1 < this.state && this.state < 3.0){
      return this.states.get(2);
    } else if(1.1 < this.state && this.state < 2.0){
      return this.states.get(1);
    } else{
      return this.states.get(0);
    }
  }
 
  public double getNum(){
    return this.state;
  }

  public void increaseState(){
    this.state += 0.75;
  }

  public void decreaseState(){
    this.state -= 0.50;
  }
}

