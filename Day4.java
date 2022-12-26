import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Day4{

    public static void main(String[] args) throws FileNotFoundException{
        
        File Input = new File("day4Input.txt");
        Scanner scan = new Scanner(Input);
            int overLap = 0;
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                int dashIndex1 = line.indexOf("-");
                int dashIndex2 = line.lastIndexOf("-");
                int indexComma = line.indexOf(",");

                int pair1Low = Integer.parseInt(line.substring(0,dashIndex1));
                int pair1High = Integer.parseInt(line.substring(dashIndex1+1,indexComma));
                int pair2Low = Integer.parseInt(line.substring(indexComma+1, dashIndex2));
                int pair2High = Integer.parseInt(line.substring(dashIndex2+1, line.length()));
                
                if(pair1Low < pair2Low){
                    if(pair2Low<=pair1High) overLap++;
                }
                else if(pair2Low < pair1Low){//pair 2 is lower
                    if(pair1Low<=pair2High) overLap++;
                }
                else{//equal
                    overLap++;
                }
            }

            System.out.println(overLap);
        }


    


}