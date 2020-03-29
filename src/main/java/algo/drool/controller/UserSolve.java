package algo.drool.controller;

import algo.drool.controller.body.UserSolveBody;
import algo.drool.controller.response.UserSolveResponseBody;
import algo.drool.service.UserSolveService;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
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
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@RestController
public class UserSolve {
    @Autowired
    private UserSolveService userSolveService;

    @PostMapping("/usersolve")
    synchronized public UserSolveResponseBody userSolve(@RequestBody UserSolveBody userSolveBody) throws IOException {
        UserSolveResponseBody userSolveResponseBody = new UserSolveResponseBody();
        String funcFile = System.getProperty("user.home") + "/Documents/MATLAB/InputSolve.m";
        OutputStream f = new FileOutputStream(funcFile);
        f.write(userSolveBody.getFunction().getBytes());
        try {
            Object[] res = userSolveService.solve(userSolveBody.getSolution());
            userSolveResponseBody.setFlag(((MWNumericArray)res[2]).getInt());
            List<List<Double>> x = new ArrayList<>();
            Object[] xObj = ((MWNumericArray) res[0]).toArray();
            for (int i = 0; i < xObj.length; i++) {
                x.add(DoubleStream.of((double[]) xObj[i]).boxed().collect(Collectors.toCollection(ArrayList::new)));
            }
            userSolveResponseBody.setX(x);

            List<List<Double>> fval = new ArrayList<>();
            Object[] fvalObj = ((MWNumericArray) res[1]).toArray();
            for (int i = 0; i < xObj.length; i++) {
                fval.add(DoubleStream.of((double[]) fvalObj[i]).boxed().collect(Collectors.toCollection(ArrayList::new)));
            }
            userSolveResponseBody.setFval(fval);
        } catch (MWException e) {
            e.printStackTrace();
        }
        return userSolveResponseBody;
    }
}
