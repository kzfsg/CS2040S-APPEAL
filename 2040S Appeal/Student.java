public class Student {
    private int startTime;
    private int id;
    private int startDistance;
    private int rate;
    private int arrivalTime;

    public Student(int startTime, int id, int startDistance, int rate) {
        this.startTime = startTime;
        this.id = id;
        this.startDistance = startDistance;
        this.rate = rate;
        this.arrivalTime = startTime + (startDistance / rate);
    }

    public int getStartTime() {
        return startTime;
    }

    public int getId() {
        return id;
    }

    public int getStartDistance() {
        return startDistance;
    }

    public int getRate() {
        return rate;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDistanceAtTime(int time) {
        if (time < startTime) {
            return startDistance;
        }
        int distance = startDistance - (rate * (time - startTime));
        //return Math.max(0, distance);
        return distance;
    }
} 