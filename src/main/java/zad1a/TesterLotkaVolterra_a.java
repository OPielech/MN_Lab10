package zad1a;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

import java.util.ArrayList;

public class TesterLotkaVolterra_a {
    public static void main(String[] args) {

        double[] params = new double[]{3, 1, 2, 1};//kolejne wartości a,b,c,d
        //warunki początkowe, ilosc ofiar a pozniej drapieznikow
        double[] xStart = new double[]{50, 10};
        double[] xStop = new double[]{0, 0};

        //bo lotkaVOlterra implementuje ten interfejs
        FirstOrderDifferentialEquations lotkaVolterra = new LotkaVolterraODE_a(params);
        FirstOrderIntegrator eulerInt = new EulerIntegrator(0.01);
        LotkaVolterraPath_a lotkaVolterraPathb = new LotkaVolterraPath_a();
        eulerInt.addStepHandler(lotkaVolterraPathb);
        //zaczynamy w 0, warunki poczatkowe, t koncowe, xStop
        eulerInt.integrate(lotkaVolterra, 0, xStart, 50, xStop);

        ArrayList<Double> time = lotkaVolterraPathb.getTime();
        ArrayList<Double> preys = lotkaVolterraPathb.getPreys();
        ArrayList<Double> predators = lotkaVolterraPathb.getPredators();

        System.out.println("t, preys, predators");

        for (int i = 0; i < time.size(); i++)
            System.out.println(time.get(i) + "," + preys.get(i) + "," + predators.get(i));

    }//end of main
}//end of class
