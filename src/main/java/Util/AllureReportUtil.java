package Util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AllureReportUtil {
    public static void removeParametersInReport() throws Exception {
        File dir = new File(System.getProperty("user.dir") + "/target/allure-results");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.getName().contains("result")) {
                    removeParameterInJson(child);
                }
            }
        } else {
            throw new Exception(String.format("Directory %s/allure-results does not exist", System.getProperty("user.dir")));
        }
    }

    private static void removeParameterInJson(File fileToBeUpdated) throws Exception {
        try {
            FileReader reader = new FileReader(fileToBeUpdated);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            List<Object> newParametersValues = new LinkedList<>();
            jsonObject.put("parameters", newParametersValues);

            try (FileWriter file = new FileWriter(fileToBeUpdated)) {
                file.write(jsonObject.toString());
            }

        } catch (NullPointerException | ParseException | IOException e) {
            throw new Exception(String.format("Something went wrong when updating %s", fileToBeUpdated.getName()), e);
        }
    }
}
