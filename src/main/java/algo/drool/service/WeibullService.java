package algo.drool.service;

import WeibullJA.Class1;
import com.mathworks.toolbox.javabuilder.MWException;
import org.springframework.stereotype.Service;

@Service
public class WeibullService {

    private Class1 class1;

    public WeibullService() throws MWException {
        this.class1 = new Class1();
    }

    public Object[] evaluate() throws MWException {
        Object[] result = {null};
        Object[] input = {3029D, 3124D, 3248D, 3345D, 3570D, 3755D, 3974D, 3993D, 4254D, 4357D};
        class1.WeibullJA(result, input);
        return result;
    }
}
