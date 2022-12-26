import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Day1{

    public static void main(String[] args) {
        try{
        File Input = new File("day1Input.txt");
        Scanner scan = new Scanner(Input);
        ArrayList<Integer> sumList = new ArrayList<>();
        
        while(scan.hasNextLine()){
            String next = scan.nextLine();
            int sum = 0;
            while(!next.equals("")){
                sum += Integer.parseInt(next);

                if(scan.hasNext()){
                    next = scan.nextLine();
                }
                else{
                    next = "";
                }
            }
            sumList.add(sum);

        }
        
        int sumOf3 = 0;

    for(int i=0; i<3; i++){
        int maxCal = 0;
        int indexMax = 0;
        int index = 0;
        for(int x:sumList){
            if(x>maxCal){
                maxCal = x;
                indexMax = index;
            }
            index++;
        }
        sumOf3 += maxCal;
        sumList.remove(indexMax);
    }

        System.out.println(sumOf3);
    }
    catch(FileNotFoundException e){

    }
        


        }


    


}