package ocp.fi.lamp;

public class Lamp {

    boolean isOn;
    int watt = 50;

    public Lamp(){}

    public Lamp( boolean isOn){
        this.isOn = isOn;
    }

    public Lamp( boolean isOn, int watt){
        this.isOn = isOn;
        this.watt = watt;
    }

    public void toggle(){
        isOn = ( isOn) ? false : true;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getWatt() {
        return watt;
    }

    @Override
    public String toString() {
         return "I am " + ((isOn) ? " ON": " OFF") + " using " + watt + " of power";
    }

}
