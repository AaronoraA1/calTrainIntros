import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    static Station [] stations = new Station[8];
    static ArrayList <Passenger> passengers = new ArrayList<Passenger>();
    static ArrayList <Train> trains = new ArrayList<Train>();

    public static void init(){
        stations[0] = new Station(1);
        stations[1] = new Station(2);
        stations[2] = new Station(3);
        stations[3] = new Station(4);
        stations[4] = new Station(5);
        stations[5] = new Station(6);
        stations[6] = new Station(7);
        stations[7] = new Station(8);

    }

    public static void main (String [] args){

        init();

        Scanner sc = new Scanner(System.in);

        System.out.println("enter 1 to add passenger");
        int input = sc.nextInt();

        //add passenger
        while(input!=0){
            System.out.println("enter station source");
            int source = sc.nextInt();
            System.out.println("enter station dest");
            int destination = sc.nextInt();


            Passenger p = new Passenger(passengers.size()+1);
            System.out.println(source);
            System.out.println(destination);

            p.setSrc(stations[source-1]);
            p.setDest(stations[destination-1]);
            System.out.println(stations[source-1]);
            System.out.println(stations[destination-1]);


            passengers.add(p);
           // station_wait_for_train(passengers.get(passengers.size()-1).getSrc(),
                                  // passengers.get(passengers.size()-1));

            System.out.println("passenger "+ p.getPassNum()+" added");

            System.out.println("enter 1 to add passenger");

            input = sc.nextInt();
        }

        System.out.println("enter 1 to add train");
        input = sc.nextInt();

        //add train
        while(input!=0) {
            System.out.println("enter capacity");
            int capacity = sc.nextInt();

            Train t = new Train(trains.size() + 1, capacity, capacity, stations[0]);

            trains.add(t);
            //station_load_train(trains.get(trains.size()-1));

            System.out.println("enter 1 to add train");
            input = sc.nextInt();
        }
        //"Passenger = " + passengers.get(passengers.size()-1).getPassNum() +
        //"\n Station =" + (passengers.get(passengers.size()-1).getSrc().getStationNum()
        // "\n train = " + trains.get(trains.size()-1).getTrainNum() )

        System.out.println("Passenger = " + passengers.get(passengers.size()-1).getPassNum());
        System.out.println("Station =" + passengers.get(passengers.size()-1).getSrc().getStationNum());
        System.out.println("train = " + trains.get(trains.size()-1).getTrainNum());

        run(passengers.get(passengers.size()-1).getSrc(),passengers.get(passengers.size()-1), trains.get(trains.size()-1));

    }

    public static void run(Station station, Passenger passenger, Train train){

        Thread passThread = new Thread () {
            public void run () {
                System.out.println("About to run Passenger Thread");
                while(true) {
              while (station.getCurrTrain()==null){
                }

                if (station.getCurrTrain()!=null && station.getCurrTrain().getAvailable()>0){
                    System.out.println("passenger "+passenger.getPassNum()+" is waiting");
                    station_on_board(station, passenger);
                }

                    System.out.println("passenger " + passenger.getPassNum() + " waiting for train");
                }
            }
        };


        Thread trainThread = new Thread () {
            public void run () {
                System.out.println("About to run Train Thread");
              int index = 0;
                while (true) {
                    while (index < 7) {
                        //there are free seats and there are waiting passengers
                        //while (train.getAvailable()>0 && stations[index].getPassWaiting().size()==0){
                        //load train

                        // }

                        //train is full or no more waiting passengers
                        if (train.getAvailable() != 0 || stations[index].getPassWaiting().size() == 0) {
                            //next station
                            train.setCurrStation(stations[index + 1]);
                            System.out.println(index + 1);
                            stations[index].setCurrTrain(null);
                            stations[index + 1].setCurrTrain(train);
                            System.out.println(train.getTrainNum() + " moved to station " + stations[index + 1].getStationNum());
                        }

                        index++;
                        System.out.println("train " + train.getTrainNum() + " is loading");
                        if (train.getAvailable() > 0) {
                            System.out.println("train " + train.getTrainNum() + " is moving");
                        }
                    }
                }

            }
        };
        trainThread.start();
        passThread.start();

    }


    //passenger's method
    public static void station_wait_for_train(Station station, Passenger passenger){
        Thread t = new Thread () {
            public void run () {
//                while (station.getCurrTrain()==null){
//                    //do nothing
//                }

//                if (station.getCurrTrain()!=null && station.getCurrTrain().getAvailable()>0){
//                    System.out.println("passenger "+passenger.getPassNum()+" is waiting");
//                    station_on_board(station, passenger);
//                }

                System.out.println("passenger "+passenger.getPassNum()+" waiting for train");
            }
        };
        t.start();
    }

    //train's method
    public static void station_load_train(Train train){
        Thread t = new Thread () {
            public void run () {
//                int index = 0;
                while (true){
//                    //there are free seats and there are waiting passengers
//                    while (train.getAvailable()>0 && stations[index].getPassWaiting().size()==0){
//                        //load train
//
//                    }
//
//                    //train is full or no more waiting passengers
//                    if(train.getAvailable()!=0 || stations[index].getPassWaiting().size()==0){
//                        //next station
//                        train.setCurrStation(stations[index+1]);
//                        stations[index].setCurrTrain(null);
//                        stations[index+1].setCurrTrain(train);
//                        System.out.println(train.getTrainNum()+" moved to station "+stations[index].getStationNum());
//                    }
//
//                    index++

                    System.out.println("train "+train.getTrainNum()+" is loading");
                }

            }
        };
        t.start();
    }

    //passenger's method
    public static void station_on_board(Station station, Passenger passenger){
        station.deletePassWaiting(passenger.getPassNum());
        passenger.setTrainIn(station.getCurrTrain());
        passenger.setBoarded(true);
        station.getCurrTrain().addPassBoarded(passenger);
        station.getCurrTrain().setAvailable(station.getCurrTrain().getAvailable()-1);
        System.out.println("Passnger "+passenger.getPassNum()+" boarded train "
                           +passenger.getTrainIn().getTrainNum()+" in station "+station.getStationNum());
    }
}
