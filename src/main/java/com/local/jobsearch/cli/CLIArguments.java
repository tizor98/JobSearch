package com.local.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

   CLIArguments() {

   }

   @Parameter(
      required = true,
      descriptionKey = "KEYWORD",
      description = "Word to search within the job opening",
      validateWith = CLIKeyWordValidator.class
   )
   private String keyword;

   @Parameter(
      names = {"--title", "-t"},
      descriptionKey = "TITLE",
      description = "Job title"
   )
   private String title;

   @Parameter(
      names = {"--location", "-l"},
      descriptionKey = "LOCATION",
      description = "Job location"
   )
   private String location;

   @Parameter(
      names = {"--page", "-p"},
      descriptionKey = "PAGE",
      description = "Page number of the result. By default the first page is shown"
   )
   private int page = 1;

   @Parameter(
      names = {"--full", "-f"},
      descriptionKey = "FULLTIME",
      description = "Whether or not search only for full-time positions"
   )
   private boolean isFullTime;

   @Parameter(
      names = {"--help", "-h"},
      descriptionKey = "HELP",
      description = "Ask for help",
      help = true,
      validateWith = CLIHelpValidator.class
   )
   private boolean helpRequested;

   public String getKeyword() {
      return keyword;
   }

   public String getTitle() {
      return title;
   }

   public String getLocation() {
      return location;
   }

   public int getPage() {
      return page;
   }

   public boolean isFullTime() {
      return isFullTime;
   }

   public boolean isHelpRequested() {
      return helpRequested;
   }

   @Override
   public String toString() {
      return "CLIArguments{" +
         "keyword='" + keyword + '\'' +
         ", title='" + title + '\'' +
         ", location='" + location + '\'' +
         ", page=" + page +
         ", isFullTime=" + isFullTime +
         ", helpRequested=" + helpRequested +
         '}';
   }

   public static CLIArguments newInstance() {
      return new CLIArguments();
   }

}
