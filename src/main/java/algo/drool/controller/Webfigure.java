package algo.drool.controller;

import com.mathworks.toolbox.javabuilder.webfigures.WebFiguresServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "MyServlet",urlPatterns = "/WebFigures/*")
public class Webfigure extends WebFiguresServlet {
}
