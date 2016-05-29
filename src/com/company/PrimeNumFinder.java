import java.util.ArrayList;

public class PrimeNumFinder {

    int range;

    public PrimeNumFinder(int numrange) {
        range = numrange;
    }

    public void compute() {
        ArrayList<Integer> deletion = new ArrayList<Integer>();
        ArrayList<Integer> whole_list = new ArrayList<Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int n = 2; n <= range; n++) {
            whole_list.add(n);
        }
        for (int number = 0; number < whole_list.size(); number++) {
            if (!deletion.contains(number)) {
                for (int time = number + whole_list.get(number); time < whole_list.size(); time += whole_list.get(number)) {
                    if (!deletion.contains(time)) {
                        deletion.add(time);
                    }
                }
            }
        }
        for (int pos : deletion) {
            whole_list.set(pos, 0);
        }
        for (int num : whole_list) {
            if (num != 0) {
                output.add(num);
            }
        }

        System.out.println(output);
    }

    public static void main(String[] args) {
        PrimeNumFinder primenum = new PrimeNumFinder(3000);
        primenum.compute();

    }
}
