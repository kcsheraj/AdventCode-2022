import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Day6{

    public static void main(String[] args) throws FileNotFoundException{
        
        File Input = new File("day6Input.txt");
        Scanner scan = new Scanner(Input);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            HashMap<Character,Character> myMap = new HashMap<>();
            for(int i=13; i<line.length(); i++){//for each letter
                boolean noRepeats = true;
                for(int j=i; j>=(i-14)+1; j--){//check back 4 chars
                    char backChar = line.charAt(j);
                    if(!myMap.containsKey(backChar)){
                        myMap.put(backChar, backChar);
                    }
                    else{//if a repeat letter
                        noRepeats = false;
                        myMap.clear();
                        break;
                    }
                }

                if(noRepeats){
                    myMap.clear();
                    System.out.println(i+1);
                    break;
                }
            }
        }

    }


}