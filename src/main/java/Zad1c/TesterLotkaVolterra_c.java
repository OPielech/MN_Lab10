package Zad1c;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

import java.util.ArrayList;

public class TesterLotkaVolterra_c {
    public static void main(String[] args) {

        double[] params = new double[]{3, 1, 1, 3, 1, 2};
        double[] xStart = new double[]{50, 10};
        double[] xStop = new double[]{0, 0};

        FirstOrderDifferentialEquations lotkaVolterra = new LotkaVolterraODE_c(params);
        FirstOrderIntegrator eulerInt = new EulerIntegrator(0.01);
        LotkaVolterraPath_c lotkaVolterraPathc = new LotkaVolterraPath_c();
        eulerInt.addStepHandler(lotkaVolterraPathc);

        eulerInt.integrate(lotkaVolterra, 0, xStart, 50, xStop);

        ArrayList<Double> time = lotkaVolterraPathc.getTime();
        ArrayList<Double> preys = lotkaVolterraPathc.getPreys();
        ArrayList<Double> predators = lotkaVolterraPathc.getPredators();

        System.out.println("t, preys, predators");

        for (int i = 0; i < time.size(); i++)
            System.out.println(time.get(i) + "," + preys.get(i) + "," + predators.get(i));

    }//end of main
}//end of class
