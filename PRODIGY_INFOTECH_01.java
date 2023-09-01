import java.util.*;
public class arrayprac{
    public static void update(int marks[]){
        for(int i=0; i<marks.length; i++){
            marks[i] = marks[i] + 1;
        }
    }
    public static void main(String args[]){
        int marks[] = {22,23,24};
        update(marks);
        //print
        for(int i=0; i<marks.length; i++){
            System.out.println(marks[i]+ " ");
        }
    }
}