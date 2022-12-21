package com.local.jobsearch.api;

import com.local.jobsearch.jobs.JobsInfo;

import feign.HeaderMap;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

@Headers("Accept: application/json")
public interface APIJobs {

   @RequestLine("GET /api/Search")
   JobsInfo jobs(@QueryMap Map<String, Object> queryMap, @HeaderMap Map<String, String> header);

}