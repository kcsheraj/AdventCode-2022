import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;
public class Day7{

    public static void main(String[] args) throws FileNotFoundException{
        
        File Input = new File("day7Input.txt");
        Scanner scan = new Scanner(Input);
        //find all of the directories with a total size of at most 100000
        //then calculate the sum of their total sizes.
        // cd x
        // ls
        // cd..
        //TAKE input and make into array of strings split by new line
        Directory rootDirectory = new Directory("/", null);
        Directory curDirectory = rootDirectory;
        String inpuString = "";
        while(scan.hasNextLine()){
            inpuString += scan.nextLine();
            inpuString += "\n";
        }
        String[] input = inpuString.split("\n");//HAVE INPUT AS ARRAY
        
        int lineIndex = 1;
        while(lineIndex<input.length){
            String line = input[lineIndex];
            String command = line.substring(2,line.length());
            if(command.equals("ls")){
                lineIndex++;
                String nextLine = input[lineIndex];
                while(nextLine.charAt(0)!='$'){
                    if(nextLine.substring(0,3).equals("dir")){//dealing with dir
                        //add dir to current dir
                        String dirName = nextLine.substring(4, nextLine.length());
                        curDirectory.myDirectories.add(new Directory(dirName, curDirectory));
                    }
                    else{//dealing with file
                        //add file to current dir
                        String[] parts = nextLine.split(" ");
                        int fileSize = Integer.parseInt(parts[0]);
                        String fileName = parts[1];
                        curDirectory.myFiles.add(new Afile(fileName,fileSize));//name,size
                    }
                    lineIndex++;
                    if(lineIndex<input.length){
                    nextLine = input[lineIndex];
                    }
                    else break;
                }
            }
            else if(command.equals("cd ..")){
                curDirectory = curDirectory.prevDir;
                lineIndex++;
            }
            else{//command.equals(cd _)//move to directory _
                String wantToChangeDir = command.substring(3,command.length());
                curDirectory = curDirectory.cd(wantToChangeDir);
                lineIndex++;
            }

        }
        ArrayList<Integer> rootDirectorySizes= new ArrayList<>();
        int totalSizeFileSystem = rootDirectory.calcTotalSize(rootDirectorySizes);
        int amoutUnused = 70000000 - totalSizeFileSystem;
        System.out.println("amount used:"+amoutUnused);
        int needRemoved = 30000000 - amoutUnused;
        System.out.println("space need remove:"+ needRemoved);
        //get array of all directory sizes
        int sizeSmallestRemove = 70000000;
        for(int x: rootDirectorySizes){
            if(x>=needRemoved && x<sizeSmallestRemove){
                sizeSmallestRemove = x;
            }
        }



        System.out.println(sizeSmallestRemove);

    }


}