import java.util.ArrayList;

public class Station {
    int stationNum;
    Train currTrain;
    ArrayList <Passenger> passWaiting = new ArrayList<Passenger>();

    public Station(int stationNum) {
        this.stationNum = stationNum;
    }

    public int getStationNum() {
        return stationNum;
    }

    public void setStationNum(int stationNum) {
        this.stationNum = stationNum;
    }

    public Train getCurrTrain() {
        return currTrain;
    }

    public void setCurrTrain(Train currTrain) {
        this.currTrain = currTrain;
    }

    public ArrayList<Passenger> getPassWaiting() {
        return passWaiting;
    }

    public void setPassWaiting(ArrayList<Passenger> passWaiting) {
        this.passWaiting = passWaiting;
    }

    public void deletePassWaiting (int passNum) {
        for (int i=0; i<passWaiting.size(); i++){
            if (passWaiting.get(i).getPassNum()==passNum){
                passWaiting.remove(i);
            }
        }
    }
}
