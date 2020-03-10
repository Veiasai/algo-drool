package algo.drool.service;

import com.mathworks.toolbox.javabuilder.MWException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeibullServiceTest {

    private WeibullService weibullService;

    @BeforeEach
    void init() {
        try {
            weibullService = new WeibullService();
        } catch (MWException e) {
            e.printStackTrace();
        }
    }

    @Test
    void evaluate() {
        try {
            System.out.println(weibullService.evaluate());
        } catch (MWException e) {
            e.printStackTrace();
        }
    }

    @Test
    void plot() {
    }
}