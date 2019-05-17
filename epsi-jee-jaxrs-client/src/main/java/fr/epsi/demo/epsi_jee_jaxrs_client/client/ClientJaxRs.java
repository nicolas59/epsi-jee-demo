package fr.epsi.demo.epsi_jee_jaxrs_client.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import fr.epsi.demo.epsi_jee_jaxrs_client.dto.Pays;

public class ClientJaxRs {

  public static void main(String[] args) {
    Client client = ClientBuilder.newClient();
    Pays[] pays = client.target("https://restcountries.eu/rest/v2/name/france")
      .queryParam("fullText", "true")
      .request()
      .get(Pays[].class);
    System.out.println(pays[0]);
  }

}
