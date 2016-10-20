import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        int sum = 0;
        int max = 0;
        int fakeRow = 0;
        int fakeColumn = 0;
        int midCons = 0;
        int capCons = 1;
        
        System.out.println("Enter numbers for 2d array: ");
        //populating hourglass with for loop
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        for(int c = 0; c < 4; c++){
            capCons++;
            midCons++;
            fakeColumn = c;
            for(int r = 0; r < 4; r++){
                sum = 0;
                // constraint (3 digits on top and bottom row only)
                fakeRow = r;

                // first row  (a b c)
                for(int k = c; k <= capCons; k++){
                    sum += arr[fakeRow][k];
                }

                // second row (x d x)
                fakeRow++;
                sum += arr[fakeRow][midCons];

                // third row (e f g)
                fakeRow++;
                for(int k = c; k <= capCons; k++){
                    sum += arr[fakeRow][k];
                }
                
                if(c == 0 && r == 0 || sum > max){
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
