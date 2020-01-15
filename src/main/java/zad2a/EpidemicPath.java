package zad2a;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

import java.util.ArrayList;

public class EpidemicPath implements StepHandler {

    private ArrayList<Double> time = new ArrayList<>();
    private ArrayList<Double> ill = new ArrayList<>();
    private ArrayList<Double> healthy = new ArrayList<>();
    private ArrayList<Double> exposed = new ArrayList<>();

    public ArrayList<Double> getTime() {
        return time;
    }

    public void setTime(ArrayList<Double> time) {
        this.time = time;
    }

    public ArrayList<Double> getIll() {
        return ill;
    }

    public void setIll(ArrayList<Double> ill) {
        this.ill = ill;
    }

    public ArrayList<Double> getHealthy() {
        return healthy;
    }

    public void setHealthy(ArrayList<Double> healthy) {
        this.healthy = healthy;
    }

    public ArrayList<Double> getExposed() {
        return exposed;
    }

    public void setExposed(ArrayList<Double> exposed) {
        this.exposed = exposed;
    }

    @Override
    public void init(double t0, double[] y0, double t) {

    }

    @Override
    public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException {

        time.add(interpolator.getCurrentTime());
        double[] x = interpolator.getInterpolatedState();
        healthy.add(x[0]);
        ill.add(x[1]);
        exposed.add(x[2]);
    }
}
