package com.local.jobsearch.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface CLIGeneratorFunctions {

   static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentsSupplier) {
      JCommander jCommander = JCommander
                                    .newBuilder()
                                    .addObject(argumentsSupplier.get())
                                    .build();
      jCommander.setProgramName(cliName);
      return jCommander;
   }

   static Optional<List<Object>> parseArguments(JCommander jc, String[] args, Consumer<JCommander> onError) {

      try {
         jc.parse(args);
         return Optional.of(jc.getObjects());
      } catch (ParameterException exception) {
         onError.accept(jc);
      }
      return Optional.empty();

   }

   static Map<String, Object> CLIArgToMap(CLIArguments cliArguments) {

      Map<String, Object> params = new HashMap<>();

      String jobType = cliArguments.isFullTime() ? "15317" : null;

      params.put("PositionOfferingTypeCode", jobType);
      params.put("LocationName", cliArguments.getLocation());
      params.put("Page", cliArguments.getPage());
      params.put("PositionTitle", cliArguments.getTitle());
      params.put("keyword", cliArguments.getKeyword());

      return params;
   }

}
