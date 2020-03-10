package algo.drool.service;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWJavaObjectRef;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.webfigures.WebFigure;
import getfigure.Getfigure;
import getparameter.Getparameter;
import org.springframework.stereotype.Service;

@Service
public class WeibullService {

    private Getfigure getfigure;
    private Getparameter getparameter;

    public WeibullService() throws MWException {
        this.getfigure = new Getfigure();
        this.getparameter = new Getparameter();
    }

    public Object evaluate() throws MWException {
        Object[] result = {null};
        Object[] input = {3029D, 3124D, 3248D, 3345D, 3570D, 3755D, 3974D, 3993D, 4254D, 4357D};
        getparameter.getparameter(result, input);
        MWNumericArray numericArray = (MWNumericArray)result[0];
        return plot(numericArray);
//        return numericArray.toDoubleArray();
    }

    public Object plot(MWNumericArray array) throws MWException {
        Object[] result = {null};
        Object[] input = {array};
        getfigure.getfigure(result, input);
        WebFigure webFigure = (WebFigure) ((MWJavaObjectRef)result[0]).get();
        return webFigure;
    }
}
