import java.util.ArrayList;
public class Directory {
    public static int underLimitTotal;
    public String name;//done
    public int mySize;
    int totalSize;
    public Directory prevDir;
    public ArrayList<Directory> myDirectories;
    public ArrayList<Afile> myFiles;

    public Directory(String name,Directory prevDir){
        this.name = name;
        this.prevDir = prevDir;
        myDirectories = new ArrayList<>();
        myFiles = new ArrayList<>();
    }

    public Directory cd(String wantToChangeDir) {
        for(Directory x: myDirectories){
            if(x.name.equals(wantToChangeDir)){
                return x;
            }
        }
        return null;
    }

    public int calcTotalSize(ArrayList<Integer> directorySizes){
        int total = 0;
        for(Afile x: myFiles){
            total += x.size;
        }
        for(Directory x: myDirectories){
            total+= x.calcTotalSize(directorySizes);
        }

        totalSize = total;
        if(totalSize<=100000){
            underLimitTotal+= totalSize;
        }

        directorySizes.add(total);

        return total;
    }





}
