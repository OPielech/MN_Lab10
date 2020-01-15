package zad2a;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

import java.util.ArrayList;

public class TesterEpidemic {
    public static void main(String[] args) {
//        2a
//        double[] params = new double[]{1,1000,10};
//        double[] xStart = new double[]{900, 90, 10};
//        2b
        double[] params = new double[]{10, 1000, 100};
        double[] xStart = new double[]{100, 150, 50};
        double[] xStop = new double[]{0, 0, 0};

        FirstOrderDifferentialEquations epidemic = new EpidemicODE(params);
        FirstOrderIntegrator eulerInt = new EulerIntegrator(0.01);
        EpidemicPath epidemicPath = new EpidemicPath();
        eulerInt.addStepHandler(epidemicPath);

        eulerInt.integrate(epidemic, 0, xStart, 50, xStop);

        ArrayList<Double> time = epidemicPath.getTime();
        ArrayList<Double> ill = epidemicPath.getIll();
        ArrayList<Double> healthy = epidemicPath.getHealthy();
        ArrayList<Double> exposed = epidemicPath.getExposed();

        System.out.println("t, healthy, ill, exposed");

        for (int i = 0; i < time.size(); i++)
            System.out.println(time.get(i) + "," + healthy.get(i) + "," + ill.get(i) + "," + exposed.get(i));
    }//end of main
}//end of class
