package Calculator;

import Calculator.Commands.SingleInstruction;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class CommandFactory {
    private final Map<String, Class<SingleInstruction>> commands = new HashMap<>();

    public CommandFactory(String configFile) throws ClassNotFoundException, IOException {
        Properties properties = new Properties();
        InputStream file = CommandFactory.class.getResourceAsStream(configFile);

        try {
            properties.load(file);

            for (Object instructionNameObject : properties.keySet()) {
                String instructionName = (String) instructionNameObject;
                commands.put(instructionName, (Class<SingleInstruction>) Class.forName((String) properties.get(instructionNameObject)));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public SingleInstruction getObject(String objectName) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return commands.get(objectName).getDeclaredConstructor().newInstance();
    }
}
