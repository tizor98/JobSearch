package com.local.jobsearch;

import com.beust.jcommander.JCommander;
import com.local.jobsearch.api.APIJobs;
import com.local.jobsearch.cli.CLIArguments;
import com.local.jobsearch.cli.CLIGeneratorFunctions;
import com.local.jobsearch.jobs.JobsInfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

import static com.local.jobsearch.api.APIFunctions.buildAPI;
import static com.local.jobsearch.cli.CLIGeneratorFunctions.*;

public class JobSearch {

   public static void main(String[] args) {

      JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

      // Stream only has one object
      Stream<CLIArguments> streamOfCLI = parseArguments(jCommander, args, JCommander::usage)
                                                   .orElse(Collections.emptyList())
                                                   .stream()
                                                   .map(obj -> (CLIArguments) obj);


      Optional<CLIArguments> cliArgumentsOptional = streamOfCLI
         .filter( cli -> !cli.isHelpRequested())
         .filter( cli -> cli.getKeyword() != null)
         .findFirst();

      cliArgumentsOptional.map(CLIGeneratorFunctions::CLIArgToMap)
         .map(JobSearch::executeRequest)
         .orElse(Stream.empty())
         .forEach( jobsInfo -> {
            try {
               Files.writeString(Path.of("./jobResults.json"), jobsInfo.toString(), StandardCharsets.UTF_8);
            } catch (IOException e) {
               throw new RuntimeException(e);
            }
         });

   }

   private static final String EMAIL = System.getenv("EMAIL_API");

   private static final String API_KEY = System.getenv("API_KEY");

   private static Stream<JobsInfo> executeRequest(Map<String, Object> params) {

      Map<String, String> header = new HashMap<>();
      header.put("Host", "data.usajobs.gov");
      header.put("User-Agent", EMAIL);
      header.put("Authorization-Key", API_KEY);

      APIJobs api = buildAPI(APIJobs.class, "https://data.usajobs.gov/");
      return Stream.of(params)
         .map( e -> api.jobs(e, header));
   }

}
