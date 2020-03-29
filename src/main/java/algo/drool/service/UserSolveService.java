package algo.drool.service;

import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import org.springframework.stereotype.Service;
import usersolve.UserSolve;

import java.util.List;

@Service
public class UserSolveService {
    private UserSolve userSolve;

    public UserSolveService() throws MWException {
        this.userSolve = new UserSolve();
    }

    public Object[] solve(List<List<Double>> solution) throws MWException {
        Object[] objects = new Object[solution.size()];

        for (int i = 0; i < solution.size(); i++) {
            objects[i]  = solution.get(i).toArray();
        }
        Object[] result = {null, null, null};
        Object[] input = {objects};
        userSolve.usersolve(result, input);
        return result;
    }
}
