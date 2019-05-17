package fr.epsi.demo.epsi_jee_jaxrs_client.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.epsi.demo.epsi_jee_jaxrs_client.dto.Pays;

/**
 * Exemple sans JAX RS
 *
 */
public class ClientOldSchool {

  public static void main(String[] args) throws Exception {
    URL url = new URL("https://restcountries.eu/rest/v2/name/france");
    URLConnection urlConnection = url.openConnection();
    urlConnection.setDoInput(true);
    urlConnection.setDoOutput(false);

    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
    StringBuilder builder = new StringBuilder();
    reader.lines().forEach(builder::append);
    
    ObjectMapper mapper =  new ObjectMapper();
    Pays[] pays = mapper.readValue(builder.toString(), Pays[].class);
    System.out.println(pays[0]);
    
  }
}
