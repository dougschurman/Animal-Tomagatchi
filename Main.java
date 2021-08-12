//Main.java
import java.util.*;
import java.io.*;

public class Main{
  Scanner input = new Scanner(System.in);  
  public static void main(String[] args){
    new Main();
  }

  public Main(){
    ArrayList<AbsPet> pets = new ArrayList<AbsPet>();
    boolean keepGoing = true;
    while(keepGoing){
      System.out.println("Welcome to the Perfect Pet! Choose an option");
      System.out.println("(1) Create a pet");
      System.out.println("(2) Interact with pets");
      System.out.println("(3) Save pets and exit");
      System.out.println("(4) Load pets");
      String response = input.nextLine();
      if(response.equals("1")){
        pets = createPet(pets);
      } else if(response.equals("2")){
        pets = petMenu(pets);
      } else if(response.equals("3")){
        savePets(pets);
        keepGoing = false;
      } else if(response.equals("4")){
        pets = loadPets(pets);
      } else{
        System.out.println("Not a valid input, try again.");
        continue;
      }
    }
  }
  
  public ArrayList<AbsPet> createPet(ArrayList<AbsPet> pets){
    boolean choosing = true;
    while(choosing){
      System.out.println("Choose a pet or go back:");
      System.out.println("(1) Monkey");
      System.out.println("(2) Tiger");
      System.out.println("(3) Giraffe");
      System.out.println("(4) Go back");
      String petChoice = input.nextLine();
      if(petChoice.equals("1")){
        pets.add(new Monkey());
      } else if(petChoice.equals("2")){
        pets.add(new Tiger());
      } else if(petChoice.equals("3")){
        pets.add(new Giraffe());
      } else if(petChoice.equals("4")){
        choosing = false;
      } else{
        System.out.println("Not a valid option, try again.");
        continue;
      }
    }
    return pets; 
  }
  public ArrayList<AbsPet> petMenu(ArrayList<AbsPet> pets){
    int size = pets.size();
    System.out.println("Choose which animal to interact with.");
    System.out.println("You have " + size + " pets.");
    System.out.println("Enter the number of the pet you want: ");
    String chosen = input.nextLine();
    int chosenPet;
    try{
      chosenPet = Integer.parseInt(chosen);
    } catch (NumberFormatException e){
      chosenPet = 0;
    }
    chosenPet -= 1;
    if(chosenPet > size){
      return pets;
    }
    boolean playing = true;
    while(playing){
      System.out.println("Pet " + (chosenPet + 1) + ": ");
      System.out.println("Health: " + pets.get(chosenPet).getHealthState());
      System.out.println("Hunger: " + pets.get(chosenPet).getHungerState());
      System.out.println("Thirst: " + pets.get(chosenPet).getThirstState());
      System.out.println("Choose an option to interact with your pet: ");
      System.out.println("(1) Play");
      System.out.println("(2) Feed");
      System.out.println("(3) Water");
      System.out.println("(4) Quit");
      String interact = input.nextLine();
      if(interact.equals("1")){
        pets.get(chosenPet).play();
      } else if(interact.equals("2")){
        pets.get(chosenPet).feed();
      } else if(interact.equals("3")){
        pets.get(chosenPet).water();
      } else if(interact.equals("4")){
        playing = false;
      } else{
        System.out.println("Not a valid option, try again.");
        continue;
      }
    }
    return pets; 
  }
  
  public void savePets(List<AbsPet> pets){
    try{
    FileOutputStream fo = new FileOutputStream("Pets.txt");
    ObjectOutputStream obOut = new ObjectOutputStream(fo);
    obOut.writeObject(pets);
    obOut.close();
    fo.close();
    } catch (IOException i){
      }
  }

  public ArrayList<AbsPet> loadPets(ArrayList<AbsPet> pets){
    try{
    FileInputStream fi = new FileInputStream("Pets.txt");
    ObjectInputStream in = new ObjectInputStream(fi);
    pets = (ArrayList) in.readObject();
    in.close();
    fi.close();
    return pets;
    } catch (IOException i){
      return pets;
    } catch (ClassNotFoundException c){
      System.out.println("No pets found.");
      return pets;
    }
  }
}
