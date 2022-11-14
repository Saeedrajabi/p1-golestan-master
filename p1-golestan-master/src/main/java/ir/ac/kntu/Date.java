package ir.ac.kntu;

public class Date {
    private int d;

    public Date() {

    }

    public Date(int d) {
        //set date in constructor
        setD(d);
    }

    public Date(Date o) {  // Copier Constructor
        this.d = o.d;
    }

    @Override
    public String toString() {
        //show in formal format
        return "Date: " + d;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        //check before setting Day
        //positive values are acceptable
        if (d < 1) {
            d = 1;
        }
        if (d > 7) {
            d = 7;
        } else {
            this.d = d;
        }
    }

//    public int compareTo(Date other) {
//        if (this.y != other.y)
//            return this.y - other.y;
//        if (this.m != other.m)
//            return this.m - other.m;
//        else {
//            return this.d - other.d;
//        }
//    }
}