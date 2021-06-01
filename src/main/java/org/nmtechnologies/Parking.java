package org.nmtechnologies;


import java.util.ArrayList;

public class Parking {

    private ArrayList<Integer> carPlaces = new ArrayList<>();
    private ArrayList<Integer> truckPlaces = new ArrayList<>();
    private int firstTruckPlace;

    public Parking(int carCount, int truckCount) {
        for (int i = 0; i < carCount; i++) {
            carPlaces.add(i + 1);
        }
        firstTruckPlace = carPlaces.size() + 1;
        for (int i = 0; i < truckCount; i++) {
            truckPlaces.add(firstTruckPlace + i);
        }
        System.out.println("Свободные места для лекговых авто: " + carPlaces);
        System.out.println("Свободные места для грузовых авто: " + truckPlaces);


    }

    private int getCarPlace() {
        int place;
        if (!carPlaces.isEmpty()) {
            place = carPlaces.get(0);
            carPlaces.remove(0);
            return place;
        } else return getTruckPlace();
    }

    private int getTruckPlace() {
        int place;
        if (!truckPlaces.isEmpty()) {
            place = truckPlaces.get(0);
            truckPlaces.remove(0);
            return place;
        } else return -1;
    }

    public void unPark(int numberPlace) {
        if (numberPlace >= firstTruckPlace) {
            truckPlaces.add(numberPlace);
        } else carPlaces.add(numberPlace);
    }

    public int park(Car car) {
        if (car instanceof PassengerCar) {
            return getCarPlace();
        } else if (car instanceof Truck) return getTruckPlace();
        else return -1;

    }


}
