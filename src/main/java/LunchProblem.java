import java.util.ArrayDeque;
import java.util.Queue;

// 1700. Number of Students Unable to Eat Lunch

/**
 * Solution
 * 1. Put the students and sandwiches into two separate queues
 * 2. Compare the elements at the top of the queue
 * 3. Use a counter to keep track of whether an element has been moved to the back of the queue
 * 4. If the elements at the top match, remove them from their respective queues and reset counter to 0
 * 5. If they don't match, move the element at the top of the student queue to the back of the queue and add 1 to the counter
 * 6. Repeat until the counter is equal to the size of the queue
 * 7. When the counter is equal to the queue size return the queue size*/
public class LunchProblem {
    static Queue<Integer> studentQueue = new ArrayDeque<>();
    static Queue<Integer> sandwichQueue = new ArrayDeque<>();
    static int to_back_counter = 0;

    public static int countStudents(int[] students, int[] sandwiches) {
        for(int student: students){
            studentQueue.add(student);
        }

        for(int sandwich: sandwiches){
            sandwichQueue.add(sandwich);
        }

        while(studentQueue.size() != 0)
        {
            if (studentQueue.peek().equals(sandwichQueue.peek())){
                to_back_counter = 0;
                studentQueue.poll();
                sandwichQueue.poll();
                System.out.println("studentQueue: "+studentQueue + " sandwichQueue: "+sandwichQueue);
                System.out.println("Counter: "+to_back_counter);
            }
            else {
                int tempStudent = studentQueue.poll();
                studentQueue.add(tempStudent);
                to_back_counter++;
                System.out.println("Moved: "+to_back_counter);

            }
            if (to_back_counter == sandwichQueue.size()) {
                System.out.println("Students not eating: " + sandwichQueue.size());
                break;
            }
        }
        return sandwichQueue.size();
    }

    public static void main(String[] args) {

        int[] studs = {1,1,1,0,0,1};
        int[] sands = {1,0,0,0,1,1};

        countStudents(studs,sands);

        /* int to_back_counter = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        q1.add(1);
        q1.add(1);
        q1.add(1);
        q1.add(0);,
        q1.add(0);
        q1.add(1);

        q2.add(1);
        q2.add(0);
        q2.add(0);
        q2.add(0);
        q2.add(1);
        q2.add(1);

        while(q1.size() != 0)
        {
            if (q1.peek().equals(q2.peek())){
                to_back_counter = 0;
                q1.poll();
                q2.poll();
                System.out.println("q1: "+q1 + " q2: "+q2);
                //System.out.println("Counter before: "+to_back_counter);
                //to_back_counter = to_back_counter - to_back_counter;
                System.out.println("Counter: "+to_back_counter);
            }
            else {
                int temp = q1.poll();
                q1.add(temp);
                to_back_counter++;
                System.out.println("Moved: "+to_back_counter);

            }
            if (to_back_counter == q2.size()) {
                System.out.println("Students not eating: " + q2.size());
                break;
            }
        } */

    }

}
