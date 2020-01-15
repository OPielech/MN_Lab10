package zad2a;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

public class EpidemicODE implements FirstOrderDifferentialEquations {

    private double[] params;

    public EpidemicODE(double[] params) {
        this.params = params;
    }

    @Override
    public int getDimension() {
        return 3;
    }

    @Override
    public void computeDerivatives(double t, double[] x, double[] dxdt) throws MaxCountExceededException, DimensionMismatchException {
        dxdt[0] = -params[0] / params[1] * x[0] * x[1];
        dxdt[1] = params[0] / params[1] * x[0] * x[1] - 1 / params[2] * x[2];
        dxdt[2] = 1 / params[2] * x[2];
    }
}
