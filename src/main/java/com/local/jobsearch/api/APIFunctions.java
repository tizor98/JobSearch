package com.local.jobsearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;

public interface APIFunctions {

   static <T> T buildAPI(Class<T> classToGenerate, String url) {
      return Feign.builder() // Build cliente web
                  .decoder(new GsonDecoder()) // Decodificar los resultados utilizando Gson
                  .target(classToGenerate, url); // Apuntando a una API en una url
   }

}
