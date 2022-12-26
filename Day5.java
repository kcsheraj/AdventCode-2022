import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Day5{

    public static void main(String[] args) throws FileNotFoundException{
        
        File Input = new File("day5Input.txt");
        Scanner scan = new Scanner(Input);
        ArrayList<String> lines = new ArrayList();

        String line = scan.nextLine();
        lines.add(line);

        line = scan.nextLine();
        int numRows = 8;//HARDCODED8
        while(!line.equals("")){//get first part of it in lines
            lines.add(line);
            line = scan.nextLine();
        }
        String lastLineNumbers = lines.get(lines.size()-1);
        int numStacks = Integer.parseInt(lastLineNumbers.substring(lastLineNumbers.length()-2, lastLineNumbers.length()-1));
        System.out.println("numStacks:"+numStacks);
        lines.remove(lines.size()-1);//remove the last one(the stack numbers);
        
        ArrayList<ArrayList<Character>> stacks  = new ArrayList();
        for(int i=0; i<numStacks; i++){
            stacks.add(new ArrayList<Character>());
        }

        int stopValue = (4*numStacks)-2;
        // ADD values to the corresponding stacks
        for(int r=0; r<numRows; r++){//for each row
            String row = lines.get(r);
            int stackIndex = 0;
            for(int i=1; i<stopValue; i+=4){//check each box in row and place in correct stack
                char box = row.charAt(i);
                if(box!=' '){//if a letter
                    stacks.get(stackIndex).add(box);
                }
                stackIndex++;
            }
        }

        System.out.println("");

        while(scan.hasNextLine()){//do movements
            String lineInstruction = scan.nextLine();
            String[] splittedInstructions = lineInstruction.split(" ");
            int amount = Integer.parseInt(splittedInstructions[1]);
            int fromStackIndex = Integer.parseInt(splittedInstructions[3])-1;
            int toStackIndex = Integer.parseInt(splittedInstructions[5])-1;
            ArrayList<Character> fromStack = stacks.get(fromStackIndex);
            ArrayList<Character> toStack = stacks.get(toStackIndex);

            ArrayList<Character> temp = new ArrayList<>();
            for(int i=0; i<amount; i++){
                temp.add(fromStack.remove(0));
            }
            toStack.addAll(0,temp);

        }

        String ans ="";

        //get the top element from each stack;
        for(int i=0; i<stacks.size(); i++){
            ans+= stacks.get(i).get(0);
        }

        System.out.println(ans);



        


    }



    


}