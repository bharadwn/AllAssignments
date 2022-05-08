/**
 * Question 1 MARKS : 20
 * Your friend is a chief architect, who is working on building a skyscraper, in Mumbai. The
 * construction is in such a way that the floors will be constructed in other factories and they will be
 * assembled. All the sizes will be distinct.
 * The skyscraper needs to be constructed in N days with the following conditions :
 * a) Every day a floor is constructed in a separate factory of distinct size.
 * b) The floor with the larger size must be placed at the bottom of the building.
 * c) The floor with the smaller size must be placed at the top of the building.
 * Note: A floor cannot be assembled in the building until all floors larger in size are placed.
 * As a friend he wants you to build a small program that will help him analyze the construction
 * process, to avoid manual work and errors.
 * Input
 * First Line: contains the total floors N in the building
 * Second Line onwards: Contains N inputs in which the ith integer denotes the size of the floor
 * that will be given to architect by factories on the ith day.
 * Output
 * You are required to print N lines. Print the size of the floor in descending order, which can be
 * assembled.
 * If no floor can be assembled on the ith day, leave the line empty.
 * Sample Test Cases
 *
 * TestCase 1
 * enter the total no of floors in the building
 * 3 enter the floor size given on day :
 * 1
 * 3 enter the floor size given on day :
 * 2
 * 1 enter the floor size given on day :
 * 3
 * 2
 * The order of construction is as follows
 * Day: 1
 * 3
 * Day: 2
 * Day: 3
 * 2 1
 * Explanation
 * The largest floor size is available on day 1 itself, hence it will be assembled on day 1.
 * On the second day floor of size 1 is available and cannot be assembled as the floor of size 2 is
 * not available.
 * On the third day floor of size 2, is available and accordingly, the remaining floor (2,1) will
 * assemble in the order 2,1
 *
 * --------------------------------------------------------------------------------------------------------------------------
 * TestCase 2
 * enter the total no of floors in the building
 * 5 enter the floor size given on day :
 * 1
 * 4 enter the floor size given on day :
 * 2
 * 5 enter the floor size given on day :
 * 3
 * 1 enter the floor size given on day :
 * 4
 * 2 enter the floor size given on day :
 * 5
 * 3
 * The order of construction is as follows
 * Day: 1
 * Day: 2
 * 5 4
 * Day: 3
 * Day: 4
 * Day: 5
 * 3 2 1
 *
 * Explanation
 * On the first day, the floor of size 4 is given. But it cannot be assembled as the floor of size 5 is
 * still remaining.
 * On the second day, the floor of size 5 is given so now the floor of sizes 5 and 4 can be
 * assembled
 * On the third and fourth days, floors cannot be assembled as the size of 3 needs to be given yet.
 * Therefore, these lines are empty.
 * On the fifth day, all the floors of sizes 3, 2, and 1 can be placed.
 * --------------------------------------------------------------------------------------------------------------------------
 * Test Case 3
 * enter the total no of floors in the building
 * 10
 * enter the floor size given on day : 1
 * 1 enter the floor size given on day :
 * 2
 * 2 enter the floor size given on day :
 * 3
 * 3 enter the floor size given on day :
 * 4
 * 8 enter the floor size given on day :
 * 5
 * 9 enter the floor size given on day :
 * 6
 * 10
 * enter the floor size given on day : 7
 * 4 enter the floor size given on day :
 * 8
 * 5 enter the floor size given on day :
 * 9
 * 7
 * enter the floor size given on day : 10
 * 6
 * The order of construction is as follows
 * Day: 1
 * Day: 2
 * Day: 3
 * Day: 4
 * Day: 5
 * Day: 6
 * 10 9 8
 * Day: 7
 * Day: 8
 * Day: 9
 * 7
 * Day: 10
 * 6 5 4 3 2 1
 * Instructions :
 * 1) You can use any inbuilt java function/s to implement the above functionalities
 * 2) You can choose any DataStructure(Stack, Queue, LinkedList) to implement the above
 * functionality.
 */

package Project2;

import week2.A;

import java.util.*;

public class SkyScraper {
    private ArrayDeque floorsReceivedOrder;
    private int floorsCount;
    private FloorPlan.Floor baseFloor;
    private FloorPlan fp;
    private int[] floorsAlreadyReceived;

    public static void main(String[] args) {
        SkyScraper skyScaperBuilding = new SkyScraper();
        boolean inputTaken = skyScaperBuilding.getInputs();

        //On successful inputs, display the schedule
        if (inputTaken){
            skyScaperBuilding.CreateBuildingSchedule();
        }else{
            System.out.println("Floor Plan failed Wrong inputs.");
        }
    }

    /**
     * Initialize all the parameters before the schedule is displayed
     */
    private void CreateBuildingSchedule() {
        floorsAlreadyReceived=new int[floorsCount+1];

        //Fill all the floors received to respective floors(floor number filled in to the slots)
        for (int j = 0; j < floorsAlreadyReceived.length; j++) {
            floorsAlreadyReceived[j]=j;
        }
        //System.out.println("Array is::"+Arrays.toString(floorsAlreadyReceived));
        int i=0;//day
        int floorExp = floorsCount;//floor expected pointer

        System.out.println("The order of construction is as follows: ");
        buildScheduleOutput(baseFloor, (i+1),  floorExp);
    }


    /**
     * Displays the schedule for the construction
     *  - REcursive method
     * @param abaseFloor
     * @param day
     * @param floorExp
     */
    void buildScheduleOutput(FloorPlan.Floor abaseFloor, int day, int floorExp){
        FloorPlan.Floor tmpFloor=abaseFloor;
        if(tmpFloor==null){
            //System.out.println("Base floor is null , So cannnot display the plan.");
            return;
        }else {
            //System.out.println("Floor expected on this day" + (day) + " is :" + tmpFloor.floorNumber + " floor trying" + floorExp + "(Integer)floorsReceivedOrder.peek()" + (Integer) floorsReceivedOrder.peek());
            System.out.println("");
            System.out.print("Day "+day+": ");
            int floorReceivedThatDay = (Integer) floorsReceivedOrder.poll();
            floorsAlreadyReceived[floorReceivedThatDay] = 0;
            //System.out.println("Array now is------"+Arrays.toString(floorsAlreadyReceived));

            if (floorsAlreadyReceived[floorExp]==0){
                //System.out.println("floorsAlreadyReceived[floorExp]"+floorsAlreadyReceived[floorExp]);
                for (int i = floorExp; i >= tmpFloor.floorNumber; i--) {
                    //System.out.println("i is:"+i+"floorsAlreadyReceived[i]" + floorsAlreadyReceived[i]);
                    if (floorsAlreadyReceived[i] == 0) {
                        System.out.print(i + " ");
                        floorExp--;
                    }else {

                        break;
                    }
                }
            }
            buildScheduleOutput(tmpFloor.floorAbove, day+1,floorExp);
        }
    }

    /**
     * Take user input for floor count
     * Floor plan is built (Right Skewed tree- Base size(biigest) to top(Smallest))
     * Take USer input for floor size received each day(uniquie sizes)
     * In the process build a queue for the floorSizes recieved each day.
     * @return boolean to show input taken successfully
     */
    private boolean getInputs() {
        boolean inputDone = false;

        //Receiving the info for number of floors in the SkyScraper,
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of floors in the building: ");
        floorsCount = scanner.nextInt();

        fp = new FloorPlan();
        //System.out.println("Floors count is::"+floorsCount);

        baseFloor = fp.addFloor(floorsCount);

        if( baseFloor==null)
            System.out.println("Floor count is 0");
        else {
            BuildRightSkewedTree(baseFloor,floorsCount);
        }

        System.out.print("FloorBuilding Plan built :");
        displayTheFloorTree(baseFloor);
        System.out.println();
        //System.out.println("Enter the floors received on each day::");
        //Getting the floors(Uniquely Sized) received on each day, and adding them to the queue
        int days=0;
        floorsReceivedOrder = new ArrayDeque();
        while(days!=floorsCount) {
            System.out.print("Enter the floor size given on day " + (days + 1)+" : ");
            int thatDaysFloor=scanner.nextInt();
            //System.out.println();
            if (thatDaysFloor<=floorsCount) {
                if (!(floorsReceivedOrder.contains(thatDaysFloor))) {
                    floorsReceivedOrder.add(thatDaysFloor);
                    days++;
                } else {
                    System.out.println("The particular floor already exists... name a different one.");
                }
            } else {
                System.out.println("Wrong Floor number, should be within the Building floor count."+floorsCount+ "Please try again.");
            }
        }

        System.out.println("Floors Received is: "+floorsReceivedOrder.toString());

        if (floorsReceivedOrder.size()>0){
            inputDone=true;
        }
        return inputDone;
    }


    /**
     * Displaying the building plan - REcursive method
     * @param abaseFloor
     */
    void displayTheFloorTree(FloorPlan.Floor abaseFloor){
        FloorPlan.Floor tempFloor=abaseFloor;
        if(tempFloor==null){
            //System.out.println("Base floor is null , So cannnot display the plan.");
            return;
        }else{
            System.out.print(tempFloor.floorNumber+" ");
            displayTheFloorTree(tempFloor.floorAbove);
        }
    }

    /**
     *Building a floor tree (descending ) to traverseEg. 3 floors, base floor size to top floor size(gets smaller)-3,2,1)
     *  - REcursive method
     * @param aBaseFloor
     * @return
     */
    private void BuildRightSkewedTree(FloorPlan.Floor aBaseFloor, int afloorsCount) {
        //System.out.println("inside BuildRightSkewedTree-----------"+afloorsCount);

        if (aBaseFloor != null) {
            aBaseFloor.floorAbove =fp.addFloor(afloorsCount-1);
            BuildRightSkewedTree(aBaseFloor.floorAbove, afloorsCount-1);
        } else {
            //System.out.println("Floors count is wrong, input the proper number of floors in the SkyScaper.");
            return;
        }
    }
}
