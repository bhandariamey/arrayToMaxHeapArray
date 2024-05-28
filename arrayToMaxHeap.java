
import java.util.Scanner;

class arrayToMaxHeap{

    static int calculateParentOfLastIndex(int n){
        return((n-1)/2);
    }

    static void swap(int [] arr, int parentIndex, int maximumIndex){
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[maximumIndex];
        arr[maximumIndex] = temp;
    }

    static int[] heapify(int [] arr, int n, int parentIndex){
       
        for(int j=parentIndex; j>=0; j--){
            
            int leftChildValue;
            int rightChildValue;

            int leftChildIndex = (2*j + 1);
            int rightChildIndex = (2*j + 2);

            int maximumIndex = 0;

            if(leftChildIndex >= n && rightChildIndex >=n ){
                break;
            }
            else if(leftChildIndex >=n && rightChildIndex < n){
                maximumIndex = rightChildIndex;
            }
            else if(rightChildIndex >=n && leftChildIndex < n){
                maximumIndex = leftChildIndex;
            }
            else{
                if(arr[leftChildIndex] >= arr[rightChildIndex]){
                    maximumIndex = leftChildIndex;
                }
                else{
                    maximumIndex = rightChildIndex;
                }
            }
            
            if(arr[j] < arr[maximumIndex]){
                swap(arr, j, maximumIndex);
                heapify(arr, arr.length, maximumIndex);
            }
        }
        return arr;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of elements");
        int n = sc.nextInt();
        int [] arr = new int[n];

        System.out.println("Enter Numbers 1 by 1");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int parentIndex = calculateParentOfLastIndex(n-1);

        int [] res = heapify(arr,n, parentIndex); 

        System.out.print("Max Heap Array is :");
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] +" ");
        }
    }
}