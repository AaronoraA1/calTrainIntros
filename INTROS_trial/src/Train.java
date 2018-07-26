import java.util.ArrayList;

public class Train {
    int trainNum;
    int capacity;
    int available;
    Station currStation;
    ArrayList <Passenger> passBoarded = new ArrayList<Passenger>();

    public Train(int trainNum, int capacity, int available, Station currStation) {
        this.trainNum = trainNum;
        this.capacity = capacity;
        this.available = available;
        this.currStation = currStation;
    }

    public int getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(int trainNum) {
        this.trainNum = trainNum;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public Station getCurrStation() {
        return currStation;
    }

    public void setCurrStation(Station currStation) {
        this.currStation = currStation;
    }

    public ArrayList<Passenger> getPassBoarded() {
        return passBoarded;
    }

    public void setPassBoarded(ArrayList<Passenger> passBoarded) {
        this.passBoarded = passBoarded;
    }

    public void addPassBoarded (Passenger passenger) {
        passBoarded.add(passenger);
    }
}
