package factory;

import entity.IFigure;
import entity.Tetrahedron;
import parser.DataParser;
import reader.DataReader;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronFactory implements IFigure {
    public List<Tetrahedron> createTetrahedronList(String filePath) {
        DataReader dataReader = new DataReader();
        List<String> stringList = dataReader.readData(filePath);
        DataParser dataParser = new DataParser();
        List<Tetrahedron> tetrahedronList = dataParser.parseData(stringList);
        return tetrahedronList;
    }
}
