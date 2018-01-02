package homework;

public class Factorial {

    public int factorialOfANumber(int nthterm){
        if(nthterm>19){
            throw new RuntimeException("cannont exceed 19");
        }
        if(nthterm<=0){
            throw new RuntimeException("wrong input");
        }

        int temporary = 1, i;
        for (i=2; i<=nthterm; i++)
        {
            temporary *= i;

        }
        return temporary;
    }
}
