package algo.drool.controller.response;

import java.util.List;

public class UserSolveResponseBody {
    private Integer flag;
    private List<List<Double>> x;
    private List<List<Double>> fval;

    public List<List<Double>> getX() {
        return x;
    }

    public void setX(List<List<Double>> x) {
        this.x = x;
    }

    public List<List<Double>> getFval() {
        return fval;
    }

    public void setFval(List<List<Double>> fval) {
        this.fval = fval;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
