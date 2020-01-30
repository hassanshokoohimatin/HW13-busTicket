package ir.sunsor.repositories;

import ir.sunsor.config.CrudRepository;
import ir.sunsor.entities.Trip;

public class TripRepository extends CrudRepository<Trip , Long> {

    private static TripRepository tripRepository;

    private TripRepository(){}

    public static TripRepository getInstance(){
        if (tripRepository == null)
            tripRepository = new TripRepository();
        return tripRepository;
    }

    @Override
    protected Class<Trip> getEntityClass() {
        return Trip.class;
    }
}
