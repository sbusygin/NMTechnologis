package org.nmtechnologies;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

    Parking parking = new Parking(3, 2);

    @Test
    void parkOnePassengerCar() {
        int expected = 1;
        int result = parking.park(new PassengerCar());
        assertEquals(expected, result);
    }

    @Test
    void parkManyPassengerCar() {
        int expected = 4;
        int result = -1;
        for (int i = 0; i < 4; i++) {
            result = parking.park(new PassengerCar());
        }
        assertEquals(expected, result);
    }

    @Test
    void parkOneTrackCar() {
        int expected = 4;
        int result = parking.park(new Truck());
        assertEquals(expected, result);
    }

    @Test
    void unPark() {
        for (int i = 0; i < 3; i++) {
            parking.park(new PassengerCar());
        }
        parking.unPark(3);
        int result = parking.park(new PassengerCar());
        int expected = 3;
        assertEquals(expected, result);

    }

}