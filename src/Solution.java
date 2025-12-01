import java.util.List;

class Result {

    public static int simpleArraySum(List<Integer> ar) {

        int sum = 0;

        for (int element : ar){
            sum+= element;
        }

        return sum;
    }

}
