package com.local.jobsearch.jobs;

import java.util.List;
import java.util.Objects;

public class JobsInfo {

   private JobPositionResults SearchResult;

   public JobPositionResults getSearchResult() {
      return SearchResult;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof JobsInfo)) return false;
      JobsInfo jobsInfo = (JobsInfo) o;
      return Objects.equals(getSearchResult(), jobsInfo.getSearchResult());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getSearchResult());
   }

   @Override
   public String toString() {
      return "{\"JobsInfo\":\n{" +
         SearchResult +
         "}}";
   }



   // -----------------------------------------INNER CLASS--------------------------------------------------


   private class JobPositionResults {

      private Integer SearchResultCount;

      private Integer SearchResultCountAll;

      private List<JobPosition> SearchResultItems;

      public Integer getSearchResultCount() {
         return SearchResultCount;
      }

      public Integer getSearchResultCountAll() {
         return SearchResultCountAll;
      }

      public List<JobPosition> getSearchResultItems() {
         return SearchResultItems;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof JobPositionResults)) return false;
         JobPositionResults that = (JobPositionResults) o;
         return Objects.equals(getSearchResultCount(), that.getSearchResultCount()) && Objects.equals(getSearchResultCountAll(), that.getSearchResultCountAll()) && Objects.equals(getSearchResultItems(), that.getSearchResultItems());
      }

      @Override
      public int hashCode() {
         return Objects.hash(getSearchResultCount(), getSearchResultCountAll(), getSearchResultItems());
      }

      @Override
      public String toString() {
         return "\"SearchResultCount\":\"" + SearchResultCount + "\"\n" +
            ", \"SearchResultCountAll\":\"" + SearchResultCountAll + "\"\n" +
            ", \"SearchResultItems\":\n" + SearchResultItems;
      }
   }
}