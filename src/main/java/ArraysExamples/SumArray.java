package ArraysExamples;

public class SumArray {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6};
        sumArray(a);
    }

    static void sumArray(int a[]){
        int sum=0;
        for (int i=0;i<a.length;i++){
            sum+=a[i];
        }
        System.out.println("Sum of an array: "+sum);
    }
}
