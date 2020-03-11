package algo.drool.service;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWJavaObjectRef;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.webfigures.WebFigure;
import getfigure.Getfigure;
import getparameter.Getparameter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeibullService {

    private Getfigure getfigure;
    private Getparameter getparameter;

    public WeibullService() throws MWException {
        this.getfigure = new Getfigure();
        this.getparameter = new Getparameter();
    }

    public Object evaluate(List<Double> args) throws MWException {
        Object[] result = {null};
        Object[] input = {args.toArray()};
        getparameter.getparameter(result, input);
        return result[0];
    }

    public Object plot(Object args) throws MWException {
        Object[] result = {null};
        Object[] input = {args};
        getfigure.getfigure(result, input);
        return ((MWJavaObjectRef)result[0]).get();
    }
}
