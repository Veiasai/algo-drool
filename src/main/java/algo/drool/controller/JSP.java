package algo.drool.controller;

import algo.drool.controller.body.WeibullInputBody;
import algo.drool.service.WeibullService;
import com.mathworks.toolbox.javabuilder.MWException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"MyFigure"})
public class JSP {
    @Autowired
    private WeibullService weibullService;

    @PostMapping("/weibulljsp")
    public String weibull(@RequestBody WeibullInputBody weibullInputBody, Model model) {
        try {
            model.addAttribute("MyFigure", weibullService.evaluate());
        } catch (MWException e) {
            e.printStackTrace();
        }
        return "weibull";
    }
}
