import java.util.ArrayList;

public class BirthdayProgram {

    private int size;
    private int runs;

    public BirthdayProgram(int size, int runs) {
        this.size = size;
        this.runs = runs;
    }


    public double run() {
        int count = 0;

        for (int i = 0; i < runs; i++) {
            ArrayList<Person> temp = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                temp.add(new Person());
            }

            if (hasSharedBirthday(temp)) {
                count++;
            }
        }

        return (double) count / runs;
    }

    private boolean hasSharedBirthday(ArrayList<Person> temp) {
        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                if (temp.get(i).getBirthday() == temp.get(j).getBirthday())
                    return true;
            }
        }
        return false;
    }
        
}