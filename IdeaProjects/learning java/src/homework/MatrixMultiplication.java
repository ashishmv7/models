package homework;

public class MatrixMultiplication {
    public int[][] matrixMultiplicationOfTwoMatrices(int[][]a,int[][]b){
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(a[i][j]>Integer.MAX_VALUE || a[i][j]<Integer.MIN_VALUE || b[i][j]<Integer.MIN_VALUE
                    || b[i][j]>Integer.MAX_VALUE){
                throw new RuntimeException("enter valid input");
            }
        }
    }


    int c[][]=new int[3][3];

    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            c[i][j]=0;
            for(int k=0;k<3;k++)
            {
                if((c[i][j]+(a[i][k]*b[k][j]))>Integer.MAX_VALUE ||(c[i][j]+(a[i][k]*b[k][j]))<Integer.MIN_VALUE){
                    throw new RuntimeException("error");
                }
                c[i][j]+=a[i][k]*b[k][j];
            }

        }

    }
    return c;
    }
}
