package com.local.jobsearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class JobPosition {

   @SerializedName("PositionTitle")
   private String title;

   @SerializedName("MinimumRange")
   private Double minRemuneration;

   @SerializedName("MaximumRange")
   private Double maxRemuneration;

   @SerializedName("PositionURI")
   private String url;

   @SerializedName("PositionLocationDisplay")
   private String location;

   @SerializedName("OrganizationName")
   private String organization;

   @SerializedName("JobCategory")
   private List<String> categories;

   @SerializedName("PositionOfferingType")
   private String type; // Fulltime, Parttime, etc

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Double getMinRemuneration() {
      return minRemuneration;
   }

   public void setMinRemuneration(Double minRemuneration) {
      this.minRemuneration = minRemuneration;
   }

   public Double getMaxRemuneration() {
      return maxRemuneration;
   }

   public void setMaxRemuneration(Double maxRemuneration) {
      this.maxRemuneration = maxRemuneration;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public String getOrganization() {
      return organization;
   }

   public void setOrganization(String organization) {
      this.organization = organization;
   }

   public List<String> getCategories() {
      return categories;
   }

   public void setCategories(List<String> categories) {
      this.categories = categories;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof JobPosition)) return false;
      JobPosition that = (JobPosition) o;
      return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getMinRemuneration(), that.getMinRemuneration()) && Objects.equals(getMaxRemuneration(), that.getMaxRemuneration()) && Objects.equals(getUrl(), that.getUrl()) && Objects.equals(getLocation(), that.getLocation()) && Objects.equals(getOrganization(), that.getOrganization()) && Objects.equals(getCategories(), that.getCategories()) && Objects.equals(getType(), that.getType());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getTitle(), getMinRemuneration(), getMaxRemuneration(), getUrl(), getLocation(), getOrganization(), getCategories(), getType());
   }
}
