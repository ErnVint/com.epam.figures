package parser;

import entity.Point;
import entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validator.FigureValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParser {
    private static final String REGEX_DELIMITER = "\\s+";
    private static final Logger logger = LogManager.getLogger();

    public List<Tetrahedron> parseData(List<String> pointList) {
        List<Tetrahedron> tetrahedronList = new ArrayList<>();
        FigureValidator figureValidator = new FigureValidator();
        for (String pointLine : pointList) {
            List<String> parsedPoint = parseStringToArray(pointLine);
            if (figureValidator.isValidTetrahedronData(parsedPoint)) {
                List<Double> doublePointList = parseToDouble(parsedPoint);
                tetrahedronList.add(new Tetrahedron(new Point(doublePointList.get(0), doublePointList.get(1), doublePointList.get(2)),
                                                    new Point(doublePointList.get(3), doublePointList.get(4), doublePointList.get(5)),
                                                    new Point(doublePointList.get(6), doublePointList.get(7), doublePointList.get(8)),
                                                    new Point(doublePointList.get(9), doublePointList.get(10), doublePointList.get(11))));
            }
        }
        return tetrahedronList;
    }

    public List<Double> parseToDouble(List<String> parsedStringPoint) {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            result.add(Double.parseDouble(parsedStringPoint.get(i)));
        }
        return result;
    }

    public List<String> parseStringToArray(String point) {
        point = point.trim();
        List<String> stringList = Arrays.asList(point.split(REGEX_DELIMITER));
        return stringList;
    }
}
