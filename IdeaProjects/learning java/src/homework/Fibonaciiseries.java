package homework;

public class Fibonaciiseries {
   static int firstNumber=0,secondNumber=1,thirdNumber=0;

    public int[] printFibonacci(int nthTerm){
        if(nthTerm>47){
            throw new RuntimeException("cannot exceed 47");
        }
        if(nthTerm<=0){
            throw new RuntimeException("wrong value");
        }
        if(nthTerm==1){
            int temp[]={0};
            return temp;
        }
        if(nthTerm==2){
            int temp[]={0,1};
            return temp;
        }
        int result[]=new int[nthTerm];
        int index=2;
        result[0]=0;
        result[1]=1;

        while(index<nthTerm){

            thirdNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
            result[index]=thirdNumber;
            index++;

        }
        return result;
    }

}

