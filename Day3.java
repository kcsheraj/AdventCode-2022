import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Day3{

    public static void main(String[] args) throws FileNotFoundException{
        
        File Input = new File("day3Input.txt");
        Scanner scan = new Scanner(Input);
        
        ArrayList<Character> sharedCharacters = new ArrayList<>();
        //find and add all sharedCharacters in each rusksack
        while(scan.hasNextLine()){
            String rucksack1 = scan.nextLine();
            String rucksack2 = scan.nextLine();
            String rucksack3 = scan.nextLine();
            //BETTER approach is just to use .contains() insted of hashmap!
            HashMap<Character,Character> myMap = new HashMap<>();
            for(int i=0; i<rucksack1.length(); i++){// 1 into map
                myMap.put(rucksack1.charAt(i), rucksack1.charAt(i));
            }
            HashMap<Character,Character> myMap2 = new HashMap<>();
            for(int i=0; i<rucksack2.length(); i++){//compare second and put same in to map 2
                if(myMap.containsKey(rucksack2.charAt(i))){
                    myMap2.put(rucksack2.charAt(i), rucksack2.charAt(i));
                }
            }
            for(int i=0; i<rucksack3.length(); i++){
                if(myMap2.containsKey(rucksack3.charAt(i))){
                    sharedCharacters.add(rucksack3.charAt(i));
                    break;
                }
            }
        }


        int sum = 0;
        for(char x: sharedCharacters){
            if(Character.isUpperCase(x)){
                sum += ((int)x - (int)'A' +1) + 26; 
            }
            else{
                sum += (int)x - (int)'a' +1;
            }
        }


            System.out.println(sum);
        // System.out.println(((int)'L'- (int)'A'+1)+26);

        // System.out.println((int)'b');





        }


    


}