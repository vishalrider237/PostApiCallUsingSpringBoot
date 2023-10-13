package com.Ap.controller;

import com.Ap.dto.SampleClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;


@RestController
public class Controller {
    BufferedReader in;
    final int BUFFER_SIZE =8*1024;
    @RequestMapping(value = "/sample", method = RequestMethod.POST)
    public String createProducts(@RequestBody SampleClass sampleClass) throws IOException {
        String token="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJJNExzTXlreEQ4czlXdFhOLUxaTXoxbDd3SmxfTmZmNGN5WkM5MEpZbklVIn0.eyJleHAiOjE2OTcxMTkzNjIsImlhdCI6MTY5NzExMjE3OCwiYXV0aF90aW1lIjoxNjk3MTEyMTYyLCJqdGkiOiIxMjVjZDc5Ni02MzZjLTRhYWMtYTM1NC0xMThmNzIzNjE1M2UiLCJpc3MiOiJodHRwczovL2tleWNsb2FrLmNoZXJyeXdvcmtwcm9kdWN0cy5jb20vYXV0aC9yZWFsbXMvRGlnaXRhbEFwcGxpY2F0aW9uU3VpdGUiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiNTdjMjQyZDUtOWY4OC00OTRmLWE4NTgtZmYzYzE5YTBhNzY5IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiaXRtX2RldiIsIm5vbmNlIjoiNGFhNWYzMzgtNTg4OS00NTVkLTgyOTUtMTIzMGQ3NjJhMjlmIiwic2Vzc2lvbl9zdGF0ZSI6IjJkYzI2YTFjLThiZmQtNGNkOS1iYzZhLWY0ZjJjYTFhOWVmNiIsImFjciI6IjAiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cHM6Ly9pdG11aWRldi5jaGVycnl3b3JrcHJvZHVjdHMuY29tIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJVU0VSX0RFRklOSVRJT05fS0VZX3VzZXItYWRtaW4iLCJkZWZhdWx0LXJvbGVzLWludGVsbGlnZW50IHRhc2sgbWFuYWdlbWVudCIsIml0bS1hZG1pbiIsImFjY2Vzcy1pZG0iLCJpdG0tZGVmYXVsdCIsIm9mZmxpbmVfYWNjZXNzIiwiYWNjZXNzLXRhc2siLCJhY2Nlc3MtbW9kZWxlciIsInVtYV9hdXRob3JpemF0aW9uIiwiYWNjZXNzLWFkbWluIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgdWFhLnVzZXIgcHJvZmlsZSBlbWFpbCIsInNpZCI6IjJkYzI2YTFjLThiZmQtNGNkOS1iYzZhLWY0ZjJjYTFhOWVmNiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Ikdlb3JnZSBBYnJhaGFtIiwicGlkIjoiUDAwMDMwMSIsInByZWZlcnJlZF91c2VybmFtZSI6Imdlb3JnZS5hYnJhaGFtQGluY3R1cmUuY29tIiwiZ2l2ZW5fbmFtZSI6Ikdlb3JnZSIsImZhbWlseV9uYW1lIjoiQWJyYWhhbSIsImVtYWlsIjoiZ2VvcmdlLmFicmFoYW1AaW5jdHVyZS5jb20ifQ.Cu_0Zjp8zHMa7YAy0hMhRLF62FcXgwwzij80esjKZge6iEjmEEMVdPZ-3lWxwCgxfimLuO3Bf_ZJbz_EE-gs_AjQt5y_iu30ZAl1oCpNDxlpuY0EM7V1JWTi0MOifzZwPQv4rLC4MrT250ffLp14lPo9_epH9Tv_cDNp0CrCnpuDGZIsakDBzyF0sQJ-6aDQsB_rtJMH8TcyHbRVR1kno7KoyruTzzQQuKeCeJ0DOKWMYtDmrpBSBEGEZCREMnhKpi2q6yLfTfp9c1ytlTcG4h4Fy4lq1nLmGGqTW5eqMWfHOvzrjc5Q9bFqgn_0k-mOGuWMiYDhT76wJEGlPhGmOQ";
        String url1 = "https://wnservices.cherryworkproducts.com/task/createTask";
        URL url = new URL(url1);

        // Open connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to POST
        connection.setRequestMethod("POST");

        // Enable input/output streams
        connection.setDoOutput(true);

        // Set the Authorization header
        connection.setRequestProperty("Authorization", "Bearer " + token);

        // Set request headers (if needed)
        connection.setRequestProperty("Content-Type", "application/json");

        // Write the JSON request body to the connection's output stream
        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(objectToJson(sampleClass).getBytes("UTF-8"));
        }

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Read the response from the input stream
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } finally {
            // Close the connection
            connection.disconnect();
        }
    }

    private static Gson gson = new Gson();
    public static String objectToJson(Object o)
    {
        if(o != null)
            return gson.toJson(o);
        else
            return "";
    }


    }

