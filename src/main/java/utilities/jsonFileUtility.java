package utilities;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;

public class jsonFileUtility {
	public static JsonNode readJsonFile(String fileName) throws IOException, URISyntaxException {
		URL url = Resources.getResource(fileName);
		String jsonString = FileUtils.readFileToString(new File(url.toURI()), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(jsonString);
		return rootNode;
	}
}
