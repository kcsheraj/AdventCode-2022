import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Day2{

    public static void main(String[] args) throws FileNotFoundException{
        
        File Input = new File("day2Input.txt");
        Scanner scan = new Scanner(Input);

        int mytotalScore = 0;
        while(scan.hasNextLine()){
            String opponent = scan.next();
            String whatToDo = scan.next();
            
            String compareOpponent = "";
            int chosenValue = 0;
            String me = "";
            if(opponent.equals("A")){//CONVERT LETTER
                compareOpponent = "X";//rock
            }
            else if(opponent.equals("B")){
                compareOpponent = "Y";//paper
            }
            else{//opponent.equals("C")
                compareOpponent = "Z";//siszor
            }

            String[] rps = {"Z","Y","X"};
            int otherIndex=0;
            for(int i=0; i<rps.length; i++){
                if(rps[i].equals(compareOpponent)){
                    otherIndex = i;
                }
            }
            //determine what my value should be
            if(whatToDo.equals("Y")){//draw
                me = compareOpponent;
            }
            else if(whatToDo.equals("Z")){//win
                me = rps[(otherIndex+2)%3];
            }
            else{
                me = rps[(otherIndex+1)%3];
            }
            
            if(me.equals("X")){//CONVERT chosenVALUE
                chosenValue = 1;
            }
            else if(me.equals("Y")){
                chosenValue = 2;
            }
            else{
                chosenValue = 3;
            }
            


            //determine who won and update toral score
            
            int meIndex=0;
            for(int i=0; i<rps.length; i++){
                if(rps[i].equals(me)){
                    meIndex = i;
                }
            }

                if(me.equals(compareOpponent)){// draw
                    mytotalScore += 3;
                    mytotalScore += chosenValue;
                    
                }
                else if(rps[(meIndex+1)%3].equals(compareOpponent)){//I won
                        mytotalScore += 6;
                        mytotalScore += chosenValue;
                    }

                else{
                    mytotalScore += chosenValue;
                }

            

        }
         
        System.out.println(mytotalScore);
        


        }


    


}