/**@Gilbert CS145 QuestionTree
 *@version 1.0 (06/08/2023)
 *@see QuestionTree class*/
 
import java.util.*;
import java.io.*;

public class QuestionTree {
   private UserInterface my;
   private QuestionNode overallRoot;
   private int totalGames;
   private int gamesWon;
   
   /*Constructs a new question tree with a single answer.
   @param ui the UserInterface to interact with.
   @throws IllegalArgumentException if the ui is null.
   */
   public QuestionTree(UserInterface ui) {
      if (ui == null) throw new IllegalArgumentException();

      this.my = ui;
      this.overallRoot = new QuestionNode("Jedi");
      this.totalGames = 0;
      this.gamesWon = 0;
   }

   public void play() {
      overallRoot = play(overallRoot);
      totalGames++;
   }
   
   /*Recursive helper method for play.
   @param root the current node in the decision tree.
   @return the updated decision tree node.
   */
   private QuestionNode play(QuestionNode root) {
      if (root.getYesNode() != null && root.getNoNode() != null) {
         my.print(root.getData());
         if (my.nextBoolean()) {
            root.setYesNode(play(root.getYesNode()));
         } else {
            root.setNoNode(play(root.getNoNode()));
         }
      } else {
         my.print("Would your object happen to be " + root.getData() + "?");
         if (my.nextBoolean()) {
            my.println("I win!");
            gamesWon++;
            return root;
         } else {
            my.print("I lose. What is your object?");
            String object = my.nextLine();
            my.print("Type a yes/no question to distinguish your item from " + root.getData() + ":");
            String question = my.nextLine();
            my.print("And what is the answer for your object?");
            boolean answer = my.nextBoolean();

            QuestionNode newObjectNode = new QuestionNode(object);

            if (answer) {
               return new QuestionNode(question, newObjectNode, root);
            } else {
               return new QuestionNode(question, root, newObjectNode);
            }
         }
      }
      return root;
   }
   
   /*Save the current decision tree to a file.
   @param output the PrintStream to write to.
   @throws IllegalArgumentException if output is null.
   */
   public void save(PrintStream output) {
      if (output == null) throw new IllegalArgumentException();
      save(output, overallRoot);
   }
   
   /*Recursive helper method for save.
   @param output the PrintStream to write to.
   @param root the current node in the decision tree.
   */
   private void save(PrintStream output, QuestionNode root) {
      if (root != null) {
         if (root.getYesNode() == null && root.getNoNode() == null) {
            output.println("A:");
            output.println(root.getData());
         } else {
            output.println("Q:");
            output.println(root.getData());
            save(output, root.getYesNode());
            save(output, root.getNoNode());
         }
      }
   }
   
   /*Load a decision tree from a file.
   @param input the Scanner to read from.
   @throws IllegalArgumentException if input is null.
   */
   public void load(Scanner input) {
      if (input == null) throw new IllegalArgumentException();
      overallRoot = loadG(input);
   }
   
   /*Recursive helper method for load.
   @param input the Scanner to read from.
   @return the new decision tree.
   */
   private QuestionNode loadG(Scanner input) {
      if (!input.hasNextLine()) {
         return null;
      }
      String line = input.nextLine();
      String[] parts = line.split(":");
      String type = parts[0];
      String data = parts[1].trim();

      QuestionNode node;
      if (type.equals("A")) {
         node = new QuestionNode(data);
      } else {
         node = new QuestionNode(data, loadG(input), loadG(input));
      }

      return node;

   }
   
   /*Get the total number of games played.
   @return the total number of games.
   */
   public int totalGames() {
      return totalGames;
   }
   
   /*Get the number of games won.
   @return the number of games won.
   */
   public int gamesWon() {
      return gamesWon;
   }
}