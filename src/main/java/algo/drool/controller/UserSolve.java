package algo.drool.controller;

import algo.drool.controller.body.UserSolveBody;
import algo.drool.controller.response.UserSolveResponseBody;
import algo.drool.service.UserSolveService;
import com.mathworks.toolbox.javabuilder.MWException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
        } catch (MWException e) {
            e.printStackTrace();
        }
        return userSolveResponseBody;
    }
}
