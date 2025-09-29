package main.java.org.mzerek.solutions.algorithms_03.search;

import java.util.*;

public class BinarySearchExample {

    public static void main(String[] args) {
        // generate 50 number between 0 and 50
        /*int[] searchArray = new int[51];
        Arrays.setAll(searchArray, IntUnaryOperator.identity());
        Arrays.stream(searchListV3).forEach(System.out::println);*/

        //ImmutableCollections
        //List<Integer> searchListTest = Arrays.stream(searchArray).boxed().toList();
        ///UnsupportedOperationException -> ImmutableCollections
        //Collections.shuffle(searchListTest);


        /*List<Integer> searchList = Arrays.stream(searchArray).boxed().collect(Collectors.toList());
        Collections.shuffle(searchList);
        System.out.println(searchList);*/

        // generate 50 random number between 0 and 50
        /*int[]  searchListV2 = IntStream
                .generate(() -> new Random().nextInt(50))
                .limit(50).toArray();
        System.out.println(Arrays.toString(searchListV2));*/

        // generate 50 random number between 0 and 50
       /* int[] searchListV3 = new Random()
                .ints(8, 1, 50)
                .toArray();*/
        int[] searchListV3 =  {-4, -6, 38, 33, 39, 27, 1, 45, 20, 13, 12, 13};
        System.out.println("Search list: " + Arrays.toString(searchListV3));

        int searchItem = 47;
        boolean isExistRecursion = binarySearchRecursion(searchListV3, searchItem);
        System.out.println("Result: " + isExistRecursion);

        //boolean isExistLoop = binarySearchLoop(searchListV3, searchItem);
        //System.out.println("binarySearchLoop Result: " + isExistLoop);
    }

    public static boolean binarySearchRecursionV2(int[] searchList, int searchItem) {
        if(searchList.length < 1) {
            return false;
        }
        Arrays.sort(searchList);
        //System.out.println(Arrays.toString(searchList));
        int left = 0;
        int right = searchList.length - 1;

        int middle = (left+right)/2;
        if(searchItem == searchList[middle]) {
            return true;
        }
        else if (searchItem > searchList[middle]){
            if(middle == 0) {
                middle = middle + 1;
            }
            return binarySearchRecursionV2(Arrays.copyOfRange(searchList, middle, searchList.length), searchItem);
        }
        else if (searchItem < searchList[middle]){
            return binarySearchRecursionV2(Arrays.copyOfRange(searchList, 0, middle), searchItem);
        } else {
            return false;
        }
    }

/*    private static boolean binarySearchLoop(int[] searchList, int searchItem) {
        Arrays.sort(searchList);
        System.out.println("Sorted search list: " + Arrays.toString(searchList));
        int left = 0;
        int right = searchList.length - 1;

        while(left<=right) {
            int checkIndex = (left + right)/2;
            System.out.println("left : " + left + " right: " + right);
            System.out.println("searchList[" + checkIndex +"] : " + searchList[checkIndex]);
            if(searchList[checkIndex] == searchItem){
                return true;
            } else if(searchList[checkIndex] < searchItem) {
                left = checkIndex + 1;
            } else if (searchList[checkIndex] > searchItem) {
                right = checkIndex - 1;
            }
        }
        return  false;
    }*/

    public static boolean binarySearchRecursion(int[] searchList, int searchItem) {
        Arrays.sort(searchList);
        System.out.println(Arrays.toString(searchList));
        int left = 0;
        int right = searchList.length - 1;

        int middle = (left+right)/2;

        if(right<=1 && (searchList[left] == searchItem || searchList[right] == searchItem)) {
            return true;
        }

        if(searchItem == searchList[middle] && right!=1) {
                return true;
        }
        else if (searchItem > searchList[middle] && right!=1){
            return binarySearchRecursion(Arrays.copyOfRange(searchList, middle, searchList.length), searchItem);
        }
        else if (searchItem < searchList[middle] && right!=1){
            return binarySearchRecursion(Arrays.copyOfRange(searchList, 0, middle), searchItem);
        } else {
            return false;
        }
    }
}
