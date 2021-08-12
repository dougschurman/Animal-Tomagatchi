//Tiger.java
import java.util.*;
import java.io.*;

public class Tiger extends AbsPet implements Serializable{
  protected Health health = new Health();
  protected Hunger hunger = new Hunger();
  protected Thirst thirst = new Thirst();

  public void play(){
    if(this.health.getNum() < 3.26 && this.hunger.getNum() > 0.49 && this.thirst.getNum() > 0.49){ 
     this.health.increaseState();
     this.hunger.decreaseState();
     this.thirst.decreaseState();
    } else{
     System.out.println("Your pet isn't in the right shape to be played with.");
  }
  }

  
  public void feed(){
    if(this.hunger.getNum() < 3.26 && this.thirst.getNum() > 0.99 && this.health.getNum() > 0.49){
      this.hunger.increaseState();
      this.thirst.decreaseState();
      this.thirst.decreaseState();
      this.health.decreaseState();
    } else{
      System.out.println("Your pet isn't in the right shape to be fed.");
  }
  }
  
  public void water(){
    if(this.thirst.getNum() < 3.26 && this.health.getNum() > 0.49){
      this.thirst.increaseState();
      this.health.decreaseState();
    } else{
      System.out.println("Your pet is hydrated enough already.");
    }
  }

  public String getHealthState(){
    return this.health.getState();
  }

  public String getHungerState(){
    return this.hunger.getState();
  }
  
  public String getThirstState(){
    return this.thirst.getState();
  }
}
