package gettingStarted;

public class Runner {
    
    public static void main(String args[]){

        Blockchain example = new Blockchain();

        for (int i=0;i<=10;i++){
            example.generateNewBlock();
            
            System.out.println(example.getAllBlocks());
        }
    }

}
