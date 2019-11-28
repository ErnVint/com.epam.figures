package validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FigureValidator {
    private static final Logger logger = LogManager.getLogger();

    public boolean isValidTetrahedronData(List<String> pointData) {
        boolean result = true;
        ValueValidator valueValidator = new ValueValidator();
        if (pointData.size() < 12) {
            return result = false;
        }
        for (int i = 0; i < 12; i++) {
            if (!valueValidator.isDouble(pointData.get(i))) {
                logger.log(Level.INFO, "Invalid point data: List: " + pointData + "element: " + pointData.get(i));
                result = false;
            }
        }
        return result;
    }
}
