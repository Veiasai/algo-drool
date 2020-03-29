package algo.drool.controller.body;

import java.util.List;

public class UserSolveBody {
    private List<List<Double>> solution;
    private String function;

    public List<List<Double>> getSolution() {
        return solution;
    }

    public void setSolution(List<List<Double>> solution) {
        this.solution = solution;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
