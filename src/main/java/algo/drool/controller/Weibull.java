package algo.drool.controller;

import algo.drool.controller.body.WeibullInputBody;
import algo.drool.service.WeibullService;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"MyFigure"})
public class Weibull {
    @Autowired
    private WeibullService weibullService;

    @PostMapping("/weibull")
    public String weibull(@RequestBody WeibullInputBody weibullInputBody, Model model) {
        try {
            MWNumericArray numericArray = (MWNumericArray) weibullService.evaluate(weibullInputBody.getData());
            model.addAttribute("a1", numericArray.getDouble(1));
            model.addAttribute("a2", numericArray.getDouble(2));
            model.addAttribute("MyFigure", weibullService.plot(numericArray));
        } catch (MWException e) {
            e.printStackTrace();
        }
        return "weibull";
    }
}
