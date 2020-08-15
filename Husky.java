// T. J. O'Connor
// 5.29.18
// CSE 142 Section AS
// TA: Chin Yeoh
// Assignment 8: Critters (Husky)

import java.awt.*;
import java.util.*;

public class Husky extends Critter {
   
   private int moves;
   
   private Random rand;
   
   //private int random;
   
   private static int deaths;
   
   private static int births;
   
   //constructor
   public Husky() {
      rand = new Random();
      random = rand.nextInt(4) + 1;
      births++;
   }
   
   public boolean eat() {
      int random = rand.nextInt(3) + 1;
      if (births - deaths > 20) {
         return true;
      } else if ((getNeighbor(Direction.NORTH).equals(".") ||
               getNeighbor(Direction.NORTH).equals(" ") ||
               getNeighbor(Direction.NORTH).equals("S")) &&
               (getNeighbor(Direction.EAST).equals(".") ||
               getNeighbor(Direction.EAST).equals(" ") ||
               getNeighbor(Direction.EAST).equals("S")) &&
               (getNeighbor(Direction.SOUTH).equals(".") ||
               getNeighbor(Direction.SOUTH).equals(" ") ||
               getNeighbor(Direction.SOUTH).equals("S")) &&
               (getNeighbor(Direction.WEST).equals(".") ||
               getNeighbor(Direction.WEST).equals(" ") ||
               getNeighbor(Direction.WEST).equals("S"))) {
         return true; 
      } else if (random == 1) {
         return true;
      } else {
         return false;
      }
   }
   
   public Attack fight(String opponent) {
      int random = rand.nextInt(3) + 1;
      if (births - deaths < 10) {
         if (opponent.equals("9") || opponent.equals("8") ||
            opponent.equals("7") || opponent.equals("6") || 
            opponent.equals("5") || opponent.equals("4") ||
            opponent.equals("3") || opponent.equals("2") ||
            opponent.equals("1") || opponent.equals("%")) {
            return Attack.SCRATCH;
         }
         return Attack.POUNCE;

      } else if (births - deaths < 4) {
         if (random == 1) {
            return Attack.SCRATCH;
         } else if (random == 2) {
            return Attack.ROAR;
         } else {
            return Attack.POUNCE;
         }
      
      } else if (opponent.equals("9") || opponent.equals("8") ||
            opponent.equals("7") || opponent.equals("6") || 
            opponent.equals("5") || opponent.equals("4") ||
            opponent.equals("3") || opponent.equals("2") ||
            opponent.equals("1") || opponent.equals("%")) {
         return Attack.ROAR;
      } else if (opponent.equals("S")) {
         return Attack.POUNCE;
      } else {
         return Attack.SCRATCH;
      }
   }

   public Color getColor() {
      return Color.PINK;

   }

   public String toString() {
      return "S";
   }
   
   public Direction getMove() {
      int random = rand.nextInt(4) + 1;
      if (births - deaths > 10) {
         if (!getNeighbor(Direction.NORTH).equals(" ") &&
               !getNeighbor(Direction.NORTH).equals("S") &&
               !getNeighbor(Direction.NORTH).equals(".")) {
            return Direction.NORTH;
         } else if (!getNeighbor(Direction.EAST).equals(" ") &&
               !getNeighbor(Direction.EAST).equals("S") &&
               !getNeighbor(Direction.EAST).equals(".")) {
            return Direction.EAST;
         } else if (!getNeighbor(Direction.SOUTH).equals(" ") &&
               !getNeighbor(Direction.SOUTH).equals("S") && 
               !getNeighbor(Direction.SOUTH).equals(".")) {
            return Direction.SOUTH;
         } else if (!getNeighbor(Direction.WEST).equals(" ") &&
               !getNeighbor(Direction.WEST).equals("S") &&
               !getNeighbor(Direction.WEST).equals(".")) {
            return Direction.WEST;
         } 
      }
      if (moves == 5) {
         moves = 0;
      }
      moves++;  
      if (random == 1) {
         return Direction.NORTH;
      } else if (random == 2) {
         return Direction.EAST;
      } else if (random == 3) {
         return Direction.SOUTH;
      } else {
         return Direction.WEST;
      }   
   }
   
   public void lose() {
      deaths++;
   }
   
   public static void resetAll() {
      deaths = 0;
      births = 0;
   }
}
