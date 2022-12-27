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

        //int visible = (treeGridCols*2) + ((treeGridRows-2)*2);

        int maxScenicScore = 0;

        for(int row=0; row<treeGridRows; row++){//traverse r/c in interior trees
            for(int col=0; col<treeGridCols; col++){
                int tempScenicScore = 0;
                //for each tree
                //boolean isVisible = true;
                int currentTreeHeight = Character.getNumericValue(treeGrid.get(row).charAt(col));
                int scoreUp = 0;
                int scoreDown = 0;
                int scoreLeft = 0;
                int scoreRight = 0;

                //check up
                for(int tempR=row; tempR>=1; tempR--){
                    int tempTreeHeight = Character.getNumericValue(treeGrid.get(tempR-1).charAt(col));
                    if(tempTreeHeight>=currentTreeHeight){
                        scoreUp++;
                        break;
                    }
                    scoreUp++;
                }
                

                for(int tempR=row; tempR<treeGridRows-1; tempR++){
                    int tempTreeHeight = Character.getNumericValue(treeGrid.get(tempR+1).charAt(col));
                        if(tempTreeHeight>=currentTreeHeight){
                            scoreDown++;
                            break;
                        }
                        scoreDown++;
                }

                        //check left

                for(int tempC=col; tempC>=1; tempC--){
                            int tempTreeHeight = Character.getNumericValue(treeGrid.get(row).charAt(tempC-1));
                            if(tempTreeHeight>=currentTreeHeight){
                                scoreLeft++;
                            
                                break;
                            }
                            scoreLeft++;
                }

                        
                            //check right
                for(int tempC=col; tempC<treeGridCols-1; tempC++){
                                int tempTreeHeight = Character.getNumericValue(treeGrid.get(row).charAt(tempC+1));
                                if(tempTreeHeight>=currentTreeHeight){
                                    scoreRight++;
                                    
                                    break;
                                }
                                scoreRight++;
                }

                tempScenicScore = scoreUp*scoreDown*scoreLeft*scoreRight;

                if(tempScenicScore>maxScenicScore){
                    maxScenicScore = tempScenicScore;
                }

            }
        }

        //System.out.println(visible);
        System.out.println(maxScenicScore);

    }


}