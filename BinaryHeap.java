import java.util.Arrays;

public class BinaryHeap {

	public int[] arr;
	public int size;


	public BinaryHeap (){

		arr = new int[10];
		size = 0;

	}

	// public static void main(String[] args){

	// 	 BinaryHeap b = new BinaryHeap();

	// 	 b.add(12);
	// 	 b.add(19);
	// 	 b.add(17);

	// 	b.add(3);

	// 	b.add(4);

	// 	b.add(45);

	// 	 // b.remove();
	// 	 // b.remove();
	// 	 // b.remove();

	// 	 System.out.println(Arrays.toString(arr));


	// }


	public void add(int pri){


		if(size == arr.length){

			growArray();

		}

			
		size++;
		arr[size - 1] = pri;


		shiftUp(size - 1);

	}

	public int remove() {

		if(arr.length == 0){

			throw new IllegalArgumentException();

		}

		int pri = arr[0];

		arr[0] = arr[size - 1];

		--size;

		shiftdown(0);

		return pri;
	}

	public boolean isleaf(int pos) {

		return ((pos > size/2) && (pos < size));

    }

    public int leftChild(int i){
		return (2 * i + 1);
	}

	public int getParentIndex(int nodeIndex) {
        return (nodeIndex - 1) / 2;
    }

	public int rightChild(int i){

		return (2 * i + 2);
	}

	public void shiftUp(int nodeIndex) {

        int parentIndex, tmp; 

        if (nodeIndex != 0) {

            parentIndex = getParentIndex(nodeIndex); 

            if (arr[parentIndex] > arr[nodeIndex]) {

                swap(arr, parentIndex, nodeIndex);

                shiftUp(parentIndex);                           //Move up the tree
            
            }
        }
    } 

	public void shiftdown(int parent){

		int child; 
        int leftChildIndex = leftChild(parent);
        int rightChildIndex = rightChild(parent);
  
        if (rightChildIndex >= size) {  

            if (leftChildIndex >= size) {        
                return;                                              
            } else {
                child = leftChildIndex;
            }

        } else {

            if (arr[leftChildIndex] <= arr[rightChildIndex]) {
                child = leftChildIndex;
            } else {
                child = rightChildIndex;
            }

        }
		

		if(arr[parent] > arr[child]){

			swap(arr, child, parent);

			shiftdown(child);
			
		}

	}

	public void growArray(){

		int[] newArray = new int[arr.length * 2];

		for(int i = 0; i < arr.length - 1; i++){

			newArray[i] = arr[i];


		}

		arr = newArray;

	}


	public void swap(int[] arr, int a, int b){

		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}


	
}