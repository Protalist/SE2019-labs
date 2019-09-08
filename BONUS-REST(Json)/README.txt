Non servono tutte le annotazioni come con xml.
Far partire il server e' leggermente diverso

lato client, cambia solo la get per i tipi complessi

ex: 
Client client = ClientBuilder.newBuilder()
            .register(JacksonJsonProvider.class)
            .build();
 Response jsonresponse = client.target(baseurl+"specialNews/9").request(MediaType.APPLICATION_JSON).get();
 SpecialNews mynews = jsonresponse.readEntity(SpecialNews.class);