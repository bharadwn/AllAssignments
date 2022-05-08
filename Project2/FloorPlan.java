package Project2;

/**
 * Floor PLan class is provided to help the construction of Floors (analogous to Nodes)
 */
public class FloorPlan {
    Floor addFloor(int afloorNumber) {
        if (afloorNumber==0){
            return null;
        }else {
            Floor tempFloor = new Floor(afloorNumber);
            tempFloor.floorAbove = null;
            return tempFloor;
        }
    }

    /**
     * Class Floor(Node)
     * Constructor provided with floor name
     */
    class Floor {
        int floorNumber;
        Floor floorAbove;
        Floor(int floorNumber){
            this.floorNumber=floorNumber;
        }
    }
}
