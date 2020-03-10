package algo.drool.controller;

import algo.drool.controller.body.WeibullInputBody;
import algo.drool.service.WeibullService;
import com.mathworks.toolbox.javabuilder.MWException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Router {
    @Autowired
    private WeibullService weibullService;

    @PostMapping("/weibull")
    public Object weibull(@RequestBody WeibullInputBody weibullInputBody) {
        try {
            return weibullService.evaluate();
        } catch (MWException e) {
            e.printStackTrace();
        }
        return null;
    }
}
