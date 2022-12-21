package com.local.jobsearch.jobs;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class JobPosition {

   private Description MatchedObjectDescriptor;

   public Description getMatchedObjectDescriptor() {
      return MatchedObjectDescriptor;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof JobPosition)) return false;
      JobPosition that = (JobPosition) o;
      return Objects.equals(getMatchedObjectDescriptor(), that.getMatchedObjectDescriptor());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getMatchedObjectDescriptor());
   }

   @Override
   public String toString() {
      return "{" +
         MatchedObjectDescriptor +
         "}\n";
   }



   // -----------------------------------------INNER CLASS--------------------------------------------------



   private class Description {

      @SerializedName("PositionTitle")
      private String title;

      @SerializedName("PositionURI")
      private String url;

      @SerializedName("PositionLocationDisplay")
      private String location;

      @SerializedName("OrganizationName")
      private String organization;

      public String getTitle() {
         return title;
      }

      public String getUrl() {
         return url;
      }

      public String getLocation() {
         return location;
      }

      public String getOrganization() {
         return organization;
      }

      @Override
      public String toString() {
         return "\"title\":\"" + title + '\"' +
            ", \"url\":\"" + url + '\"' +
            ", \"location\":\"" + location + '\"' +
            ", \"organization\":\"" + organization + '\"';
      }
   }

}
