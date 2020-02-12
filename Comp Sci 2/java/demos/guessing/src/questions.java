import java.util.Scanner;
public class questions
{
   private static Scanner input = new Scanner(System.in);
   public static void main(String[] args)
   {
      BTNode<String> root;

      instruct();
      root = beginningTree();
      do
         start(root);
      while (question("start again?"));

      System.out.println("Descision Tree has been updated.");
   }

   public static void instruct()
   {
      System.out.println("Choose an ocean animal.");
      System.out.println("Yes or No questions will be asked to try to figure out what animal you have chosen.");
   }


   public static void start(BTNode<String> current)
   {
      while (!current.isLeaf())
      {
         if (question(current.getData()))
            current = current.getLeft();
         else
            current = current.getRight();
      }

      System.out.print("Your animal is a " + current.getData() + ". ");
      if (!question("Am I right?"))
         learn(current);
      else
         System.out.println("Great!");
   }

   public static BTNode<String> beginningTree()   
   {
      BTNode<String> root=null;
      BTNode<String> child=null;
      BTNode<String> child1=null;
      BTNode<String> child2=null;
      BTNode<String> child3=null;
      BTNode<String> child4=null;
      BTNode<String> child5=null;
      BTNode<String> child6=null;
      BTNode<String> child7=null;
      BTNode<String> child8=null;
      BTNode<String> child9=null;
      BTNode<String> child10=null;
      BTNode<String> child11=null;
      BTNode<String> child12=null;
      BTNode<String> child13=null;
      BTNode<String> child14=null;

      final String ROOT_QUESTION = "Is it a mammal?";
      final String LEFT_QUESTION = "Is it able to move on land?";
      final String LEFT_QUESTION2 = "Is it a solitary animal?";
      final String RIGHT_QUESTION2 = "Is it larger than a truck?";
      final String RIGHT_QUESTION3 = "Does it have tusks?";
      final String RIGHT_QUESTION = "Does it have any limbs/tentacles?";
      final String LEFT_QUESTION4 = "Does it have more than four limbs/tentacles?";
      final String LEFT_QUESTION5 = "Does it have an exoskeleton?";
      final String LEFT_QUESTION6 = "Does it have claws?";
      final String LEFT_QUESTION7 = "Does it have a long tail?";
      final String RIGHT_QUESTION7 = "Does it have 8 arms?";
      final String RIGHT_QUESTION5 = "Does it have a shell?";
      final String RIGHT_QUESTION4 = "Can it sting?";
      final String LEFT_QUESTION8 = "Is it long and snakelike?";
      final String RIGHT_QUESTION8 = "Is it generally smaller than a car?";
      final String ANIMAL1 = "Seal";
      final String ANIMAL2 = "Sea Lion";
      final String ANIMAL3 = "Walrus";
      final String ANIMAL4 = "Whale";
      final String ANIMAL5 = "Dolphin";
      final String ANIMAL6 = "Shrimp";
      final String ANIMAL7 = "Lobster";
      final String ANIMAL8 = "Crab";
      final String ANIMAL9 = "Jellyfish";
      final String ANIMAL10 = "Octopus";
      final String ANIMAL11 = "Squid";
      final String ANIMAL12 = "Turtle";
      final String ANIMAL13 = "Alligator";
      final String ANIMAL14 = "Eel";
      final String ANIMAL15 = "Stingray";
      final String ANIMAL16 = "Shark";
      final String ANIMAL17 = "Fish";

    
      root = new BTNode<String>(ROOT_QUESTION, null, null);

      child = new BTNode<String>(LEFT_QUESTION, child2, child14);
      root.setLeft(child);

      child2 = new BTNode<String>(LEFT_QUESTION2,null,child3);
      child2.setLeft(new BTNode<String>(ANIMAL1, null, null));
      child.setLeft(child2);

      child14 = new BTNode<String>(RIGHT_QUESTION2,null,null);
      child14.setLeft(new BTNode<String>(ANIMAL4,null,null));
      child14.setRight(new BTNode<String>(ANIMAL5,null,null));
      child.setRight(child14);

      child3 = new BTNode<String>(RIGHT_QUESTION3, null, null);
      child3.setLeft(new BTNode<String>(ANIMAL3, null, null));
      child3.setRight(new BTNode<String>(ANIMAL2, null, null));
      child.setRight(child3);

      child1 = new BTNode<String>(RIGHT_QUESTION, child4, child8);
      root.setRight(child1);

      child4 = new BTNode<String>(LEFT_QUESTION4,child5,child10);
      child1.setLeft(child4);

      child5 = new BTNode<String>(LEFT_QUESTION5,child6,child8);
      child4.setLeft(child5);

      child6 = new BTNode<String>(LEFT_QUESTION6,child7, null);
      child6.setRight(new BTNode<String>(ANIMAL6,null,null));
      child5.setLeft(child6);

      child7 = new BTNode<String>(LEFT_QUESTION7, null, null);
      child7.setLeft(new BTNode<String>(ANIMAL7,null,null));
      child7.setRight(new BTNode<String>(ANIMAL8,null,null));
      child6.setLeft(child7);

      child8 = new BTNode<String>(RIGHT_QUESTION4,null,child9);
      child8.setLeft(new BTNode<String>(ANIMAL9,null,null));
      child5.setRight(child8);

      child9 = new BTNode<String>(RIGHT_QUESTION7,null,null);
      child9.setLeft(new BTNode<String>(ANIMAL10,null,null));
      child9.setRight(new BTNode<String>(ANIMAL11,null,null));
     child8.setRight(child9);

      child10 = new BTNode<String>(RIGHT_QUESTION5,null,null);
      child10.setLeft(new BTNode<String>(ANIMAL12,null,null));
      child10.setRight(new BTNode<String>(ANIMAL13,null,null));
      child4.setRight(child10);

      child11 = new BTNode<String>(RIGHT_QUESTION4,child12,child13);
      child1.setRight(child11);

      child12 = new BTNode<String>(LEFT_QUESTION8,null,null);
      child12.setLeft(new BTNode<String>(ANIMAL14,null,null));
      child12.setRight(new BTNode<String>(ANIMAL15,null,null));
     child11.setLeft(child12);

      child13 = new BTNode<String>(RIGHT_QUESTION8,null,null);
      child13.setLeft(new BTNode<String>(ANIMAL17,null,null));
      child13.setRight(new BTNode<String>(ANIMAL16,null,null));
      child11.setRight(child13);

      return root;
   }


   public static void learn(BTNode<String> current)

   {
      String guess;   
      String correct; 
      String newQ;   

    
      guess = current.getData( );
      System.out.println("I do not know. What are you? ");
      correct = input.nextLine( );
      System.out.println("Enter a yes or no question that will help choose between a");
      System.out.println(correct + " and a " + guess + ".");
      newQ = input.nextLine( );

    
      current.setData(newQ);
      System.out.println("As a " + correct + ", " + newQ);
      if (question("Please answer"))
      {
         current.setLeft(new BTNode<String>(correct, null, null));
         current.setRight(new BTNode<String>(guess, null, null));
      }
      else
      {
         current.setLeft(new BTNode<String>(guess, null, null));
         current.setRight(new BTNode<String>(correct, null, null));
      }         
   }

   public static boolean question(String prompt)
   {
      String answer;

      System.out.print(prompt + " [Y or N]: ");
      answer = input.nextLine( ).toUpperCase( );
      while (!answer.startsWith("Y") && !answer.startsWith("N"))
      {
    System.out.print("Invalid input type Y or N: ");
    answer = input.nextLine( ).toUpperCase( );
      }

      return answer.startsWith("Y");
   }

}
