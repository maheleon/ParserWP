package fr.istic.pdl.wms.groupe6.mediawikitest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class ParserWikipedia {

	public static Map<String,Object> searchWP(String title) throws IOException{
		
		String url = "https://www.wikipedia.org/w/api.php?action=query&titles=" + title + "_(disambiguation)&prop=links&format=json";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("recherche sur Wikipedia pour l'objet :" + title);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.readValue(response.toString(), Object.class);
		String res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
		Map<String,Object> map = mapper.readValue(res, Map.class);

		return map;

	}
	
	public static Map<String,Object> getContentWP(String id) throws IOException {
		
		String url = "https://www.wikipedia.org/w/api.php?action=query&titles=" + id + "&prop=revisions&rvprop=content&format=json";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("recupération de la page :" + id);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.readValue(response.toString(), Object.class);
		String res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
		Map<String,Object> map = mapper.readValue(res, Map.class);
		
		return map;

	}

}

