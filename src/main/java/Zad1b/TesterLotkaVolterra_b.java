package Zad1b;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

import java.util.ArrayList;

public class TesterLotkaVolterra_b {
    public static void main(String[] args) {

        double[] params = new double[]{3, 1, 1, 3, 2, 1};
        double[] xStart = new double[]{50, 10};
        double[] xStop = new double[]{0, 0};

        FirstOrderDifferentialEquations lotkaVolterra = new LotkaVolterraODE_b(params);
        FirstOrderIntegrator eulerInt = new EulerIntegrator(0.01);
        LotkaVolterraPath_b lotkaVolterraPathb = new LotkaVolterraPath_b();
        eulerInt.addStepHandler(lotkaVolterraPathb);

        eulerInt.integrate(lotkaVolterra, 0, xStart, 50, xStop);

        ArrayList<Double> time = lotkaVolterraPathb.getTime();
        ArrayList<Double> preys = lotkaVolterraPathb.getPreys();
        ArrayList<Double> predators = lotkaVolterraPathb.getPredators();

        System.out.println("t, preys, predators");

        for (int i = 0; i < time.size(); i++)
            System.out.println(time.get(i) + "," + preys.get(i) + "," + predators.get(i));
    }//end of main
}//end of class
