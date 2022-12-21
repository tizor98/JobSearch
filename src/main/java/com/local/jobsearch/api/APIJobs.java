package com.local.jobsearch.api;

import com.local.jobsearch.JobPosition;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

@Headers("Accept: application/json")
public interface APIJobs {

   @RequestLine("GET /api/Search")
   List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);

}
