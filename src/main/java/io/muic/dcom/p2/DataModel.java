package io.muic.dcom.p2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DataModel {
    public static class ParcelObserved {
        private String parcelId;
        private String stationId;
        private long timeStamp;

        ParcelObserved(String parcelId_, String stationId_, long ts_) {
            this.parcelId = parcelId_;
            this.stationId = stationId_;
            this.timeStamp = ts_;
        }

        public String getParcelId() { return parcelId; }
        public String getStationId() { return stationId; }
        public long getTimeStamp() { return timeStamp; }
    }

    private List<ParcelObserved> transactions;
    private ConcurrentHashMap<String, String> hashTrail = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> hashCount = new ConcurrentHashMap<>();
    private Long count ;
    private ArrayList<ParcelObserved> getTrail = new ArrayList<>();

    private ParcelObserved parcelObserved ;


    DataModel() {
        transactions = new ArrayList<>();
        getTrail = new ArrayList<>();
        hashTrail = new ConcurrentHashMap<>();
        count = 0L;



    }

    /// IMPLEMENTS CONSTRUCTOR //
    public synchronized void postObserve(String parcelId, String stationId, long timestamp) {

//        ParcelObserved parcelObserved = new ParcelObserved(parcelId, stationId, timestamp);

        hashTrail.put(parcelId, stationId);
        hashCount.put(stationId, count+= 1);

//        transactions.add(parcelObserved);
    }
    // Display only that parceID  <parceID, that station>
    public synchronized   List<ParcelObserved> getParcelTrail(String parcelId) {

        parcelObserved = new ParcelObserved(parcelId, parcelObserved.getStationId(), parcelObserved.getTimeStamp());

        getTrail.add(parcelObserved);


        return getTrail;
    }


    // Count only if that station ID < StationID , howmany (Count) >
    public synchronized long getStopCount(String stationId) {



        return hashCount.get(stationId);
    }
}
