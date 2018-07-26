public class Passenger {
    int passNum;
    Station src;
    Station dest;
    Train trainIn;
    boolean boarded;

    public Passenger(int passNum) {
        this.passNum = passNum;
        this.boarded = false;
    }

    public int getPassNum() {
        return passNum;
    }

    public void setPassNum(int passNum) {
        this.passNum = passNum;
    }

    public Station getSrc() {
        return src;
    }

    public void setSrc(Station src) {
        this.src = src;
    }

    public Station getDest() {
        return dest;
    }

    public void setDest(Station dest) {
        this.dest = dest;
    }

    public Train getTrainIn() {
        return trainIn;
    }

    public void setTrainIn(Train trainIn) {
        this.trainIn = trainIn;
    }




    public boolean isBoarded() {
        return boarded;
    }

    public void setBoarded(boolean boarded) {
        this.boarded = boarded;
    }
}
