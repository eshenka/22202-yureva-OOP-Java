package Calculator;

import Calculator.Commands.SingleInstruction;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandFactory {
    private Map<String, Class<SingleInstruction>> commands = new HashMap<>();

    public CommandFactory(String configFile) throws ClassNotFoundException, FileNotFoundException {
        File file = new File(configFile);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split("=");

            commands.put(tokens[0], (Class<SingleInstruction>) Class.forName(tokens[1]));
        }
    }

    public SingleInstruction getObject(String objectName) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return commands.get(objectName).getDeclaredConstructor().newInstance();
    }
}
