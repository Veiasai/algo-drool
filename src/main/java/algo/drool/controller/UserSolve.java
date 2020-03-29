package algo.drool.controller;

import algo.drool.controller.body.UserSolveBody;
import algo.drool.controller.response.UserSolveResponseBody;
import algo.drool.service.UserSolveService;
import com.mathworks.toolbox.javabuilder.MWException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserSolve {
    @Autowired
    private UserSolveService userSolveService;

    @PostMapping("/usersolve")
    public UserSolveResponseBody userSolve(@RequestBody UserSolveBody userSolveBody) throws IOException {
        UserSolveResponseBody userSolveResponseBody = new UserSolveResponseBody();
        String funcFile = System.getProperty("user.home") + "/Documents/MATLAB/InputSolve.m";
        OutputStream f = new FileOutputStream(funcFile);
        f.write(userSolveBody.getFunction().getBytes());
        try {
            Object[] res = userSolveService.solve(userSolveBody.getSolution());
            userSolveResponseBody.setFlag((Integer)res[2]);
            List<List<Double>> x = new ArrayList<>();
            Object[] xObj = (Object[]) res[0];
            for (int i = 0; i < xObj.length; i++) {
                x.add(new ArrayList<>(Arrays.asList((Double[])xObj[i])));
            }
            userSolveResponseBody.setX(x);

            List<List<Double>> fval = new ArrayList<>();
            Object[] fvalObj = (Object[]) res[1];
            for (int i = 0; i < xObj.length; i++) {
                fval.add(new ArrayList<>(Arrays.asList((Double[])fvalObj[i])));
            }
            userSolveResponseBody.setFval(fval);
        } catch (MWException e) {
            e.printStackTrace();
        }
        return userSolveResponseBody;
    }
}
