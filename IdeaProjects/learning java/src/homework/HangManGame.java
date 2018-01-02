package homework;

import java.util.Scanner;
import java.util.*;

public class HangManGame {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] words = {"apple", "ball", "elephant", "dog","mouse","orange","yellow","parrot"};
        int randomWordNumber = (int) (Math.random() * words.length);
        char[] enteredLetters = new char[words[randomWordNumber].length()];
        char[] correctLetters = words[randomWordNumber].toCharArray();
        int triesCount = 0;
        int correct=0;
        System.out.println("Take a guess");
        while(correct<correctLetters.length){
            char c = in.next().charAt(0);
            while(!(Character.isLetter(c))){
                System.out.println("enter valid input");
                c=in.next().charAt(0);;
            }
            triesCount++;
            for(int i=0;i<enteredLetters.length;i++){
                if(c==correctLetters[i] && enteredLetters[i]!=c){
                    enteredLetters[i]=c;
                    correct++;
                }
            }
            for(int i=0;i<enteredLetters.length;i++){
                if(!(Character.isLetter(enteredLetters[i]))){
                    System.out.print("_"+" ");
                }
                else{
                System.out.print(enteredLetters[i]+" ");

                }

            }
            System.out.println(" ");

        }
        System.out.println("Number of tries="+triesCount);

    }

}