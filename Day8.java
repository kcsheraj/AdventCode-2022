import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;
public class Day8{

    public static void main(String[] args) throws FileNotFoundException{
        
        File Input = new File("day8Input.txt");
        Scanner scan = new Scanner(Input);

        ArrayList<String> treeGrid = new ArrayList<>();
        while(scan.hasNextLine()){
            treeGrid.add(scan.nextLine());
        }

        int treeGridRows = treeGrid.size();
        int treeGridCols = treeGrid.get(0).length();

        int visible = (treeGridCols*2) + ((treeGridRows-2)*2);

        for(int row=1; row<treeGridRows-1; row++){//traverse r/c in interior trees
            for(int col=1; col<treeGridCols-1; col++){
                //for each tree
                boolean isVisible = true;
                int currentTreeHeight = Character.getNumericValue(treeGrid.get(row).charAt(col));

                //check up
                for(int tempR=row; tempR>=1; tempR--){
                    int tempTreeHeight = Character.getNumericValue(treeGrid.get(tempR-1).charAt(col));
                    if(tempTreeHeight>=currentTreeHeight){
                        isVisible=false;
                        break;
                    }
                }
                
                if(isVisible==false){
                    //check down
                    isVisible = true;
                    for(int tempR=row; tempR<treeGridRows-1; tempR++){
                        int tempTreeHeight = Character.getNumericValue(treeGrid.get(tempR+1).charAt(col));
                        if(tempTreeHeight>=currentTreeHeight){
                            isVisible=false;
                            break;
                        }
                    }
                    if(isVisible==false){
                        //check left
                        isVisible = true;
                        for(int tempC=col; tempC>=1; tempC--){
                            int tempTreeHeight = Character.getNumericValue(treeGrid.get(row).charAt(tempC-1));
                            if(tempTreeHeight>=currentTreeHeight){
                                isVisible=false;
                                break;
                            }
                        }
                        if(isVisible==false){
                            //check right
                            isVisible = true;
                            for(int tempC=col; tempC<treeGridCols-1; tempC++){
                                int tempTreeHeight = Character.getNumericValue(treeGrid.get(row).charAt(tempC+1));
                                if(tempTreeHeight>=currentTreeHeight){
                                    isVisible=false;
                                    break;
                                }
                            }
                            if(isVisible==true){
                                visible++;
                            }
                        }
                        else visible++;
                    }
                    else visible++;
                }
                else visible++;
            }
        }

        System.out.println(visible);

    }


}