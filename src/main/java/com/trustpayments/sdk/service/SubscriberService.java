package com.trustpayments.sdk.service;

import com.trustpayments.sdk.ApiClient;

import com.trustpayments.sdk.model.ClientError;
import com.trustpayments.sdk.model.EntityQuery;
import com.trustpayments.sdk.model.EntityQueryFilter;
import com.trustpayments.sdk.model.ServerError;
import com.trustpayments.sdk.model.Subscriber;
import com.trustpayments.sdk.model.SubscriberCreate;
import com.trustpayments.sdk.model.SubscriberUpdate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.api.client.http.*;
import com.google.api.client.json.Json;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


public class SubscriberService {
    private ApiClient apiClient;

    public SubscriberService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Count
    * Counts the number of items in the database as restricted by the given filter.
    * <p><b>200</b> - This status code indicates that a client request was successfully received, understood, and accepted.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param filter The filter which restricts the entities which are used to calculate the count.
    * @return Long
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--count">Count Documentation</a>

    **/
    public Long count(Long spaceId, EntityQueryFilter filter) throws IOException {
        HttpResponse response = countForHttpResponse(spaceId, filter);
        String returnType = "Long";
        if(returnType.equals("String")){
          return (Long) (Object) response.parseAsString();
        }
        TypeReference typeRef = new TypeReference<Long>() {};
        return (Long)apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Count
    * Counts the number of items in the database as restricted by the given filter.
    * <p><b>200</b> - This status code indicates that a client request was successfully received, understood, and accepted.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Long
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--count">Count Documentation</a>

    **/
    public Long count(EntityQueryFilter filter, Long spaceId, Map<String, Object> params) throws IOException {
        HttpResponse response = countForHttpResponse(filter, spaceId, params);
        String returnType = "Long";
        if(returnType.equals("String")){
            return (Long) (Object) response.parseAsString();
        }
        TypeReference typeRef = new TypeReference<Long>() {};
        return (Long)apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse countForHttpResponse(Long spaceId, EntityQueryFilter filter) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling count");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/count");
        if (spaceId != null) {
            String key = "spaceId";
            Object value = spaceId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(filter);
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
        
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

      public HttpResponse countForHttpResponse(Long spaceId, java.io.InputStream filter, String mediaType) throws IOException {
          // verify the required parameter 'spaceId' is set
              if (spaceId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling count");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/count");
              if (spaceId != null) {
                  String key = "spaceId";
                  Object value = spaceId;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }

              String url = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(url);

              HttpContent content = filter == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, filter);
              HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
              
              httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
              return httpRequest.execute();
      }

    public HttpResponse countForHttpResponse(EntityQueryFilter filter, Long spaceId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling count");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/count");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'spaceId' to the map of query params
        allParams.put("spaceId", spaceId);

        for (Map.Entry<String, Object> entryMap: allParams.entrySet()) {
            String key = entryMap.getKey();
            Object value = entryMap.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(filter);
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
        
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

  /**
    * Create
    * Creates the entity with the given properties.
    * <p><b>200</b> - This status code indicates that a client request was successfully received, understood, and accepted.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param entity The customer object with the properties which should be created.
    * @return Subscriber
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--create">Create Documentation</a>

    **/
    public Subscriber create(Long spaceId, SubscriberCreate entity) throws IOException {
        HttpResponse response = createForHttpResponse(spaceId, entity);
        String returnType = "Subscriber";
        if(returnType.equals("String")){
          return (Subscriber) (Object) response.parseAsString();
        }
        TypeReference typeRef = new TypeReference<Subscriber>() {};
        return (Subscriber)apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create
    * Creates the entity with the given properties.
    * <p><b>200</b> - This status code indicates that a client request was successfully received, understood, and accepted.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param entity The customer object with the properties which should be created.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Subscriber
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--create">Create Documentation</a>

    **/
    public Subscriber create(Long spaceId, SubscriberCreate entity, Map<String, Object> params) throws IOException {
        HttpResponse response = createForHttpResponse(spaceId, entity, params);
        String returnType = "Subscriber";
        if(returnType.equals("String")){
            return (Subscriber) (Object) response.parseAsString();
        }
        TypeReference typeRef = new TypeReference<Subscriber>() {};
        return (Subscriber)apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createForHttpResponse(Long spaceId, SubscriberCreate entity) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling create");
        }// verify the required parameter 'entity' is set
        if (entity == null) {
            throw new IllegalArgumentException("Missing the required parameter 'entity' when calling create");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/create");
        if (spaceId != null) {
            String key = "spaceId";
            Object value = spaceId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(entity);
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
        
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

      public HttpResponse createForHttpResponse(Long spaceId, java.io.InputStream entity, String mediaType) throws IOException {
          // verify the required parameter 'spaceId' is set
              if (spaceId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling create");
              }// verify the required parameter 'entity' is set
              if (entity == null) {
              throw new IllegalArgumentException("Missing the required parameter 'entity' when calling create");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/create");
              if (spaceId != null) {
                  String key = "spaceId";
                  Object value = spaceId;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }

              String url = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(url);

              HttpContent content = entity == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, entity);
              HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
              
              httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
              return httpRequest.execute();
      }

    public HttpResponse createForHttpResponse(Long spaceId, SubscriberCreate entity, Map<String, Object> params) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling create");
        }// verify the required parameter 'entity' is set
        if (entity == null) {
            throw new IllegalArgumentException("Missing the required parameter 'entity' when calling create");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/create");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'spaceId' to the map of query params
        allParams.put("spaceId", spaceId);

        for (Map.Entry<String, Object> entryMap: allParams.entrySet()) {
            String key = entryMap.getKey();
            Object value = entryMap.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(entity);
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
        
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

  /**
    * Delete
    * Deletes the entity with the given id.
    * <p><b>409</b> - This status code indicates that there was a conflict with the current version of the data in the database and the provided data in the request.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param id 
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--delete">Delete Documentation</a>

    **/
    public void delete(Long spaceId, Long id) throws IOException {
        deleteForHttpResponse(spaceId, id);
    }

  /**
    * Delete
    * Deletes the entity with the given id.
    * <p><b>409</b> - This status code indicates that there was a conflict with the current version of the data in the database and the provided data in the request.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param id 
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--delete">Delete Documentation</a>

    **/
    public void delete(Long spaceId, Long id, Map<String, Object> params) throws IOException {
        deleteForHttpResponse(spaceId, id, params);
    }

    public HttpResponse deleteForHttpResponse(Long spaceId, Long id) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling delete");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling delete");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/delete");
        if (spaceId != null) {
            String key = "spaceId";
            Object value = spaceId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(id);
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
        
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

      public HttpResponse deleteForHttpResponse(Long spaceId, java.io.InputStream id, String mediaType) throws IOException {
          // verify the required parameter 'spaceId' is set
              if (spaceId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling delete");
              }// verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling delete");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/delete");
              if (spaceId != null) {
                  String key = "spaceId";
                  Object value = spaceId;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }

              String url = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(url);

              HttpContent content = id == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, id);
              HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
              
              httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
              return httpRequest.execute();
      }

    public HttpResponse deleteForHttpResponse(Long spaceId, Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling delete");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling delete");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/delete");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'spaceId' to the map of query params
        allParams.put("spaceId", spaceId);

        for (Map.Entry<String, Object> entryMap: allParams.entrySet()) {
            String key = entryMap.getKey();
            Object value = entryMap.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(id);
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
        
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

  /**
    * Read
    * Reads the entity with the given &#39;id&#39; and returns it.
    * <p><b>200</b> - This status code indicates that a client request was successfully received, understood, and accepted.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param id The id of the customer which should be returned.
    * @return Subscriber
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--read">Read Documentation</a>

    **/
    public Subscriber read(Long spaceId, Long id) throws IOException {
        HttpResponse response = readForHttpResponse(spaceId, id);
        String returnType = "Subscriber";
        if(returnType.equals("String")){
          return (Subscriber) (Object) response.parseAsString();
        }
        TypeReference typeRef = new TypeReference<Subscriber>() {};
        return (Subscriber)apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Read
    * Reads the entity with the given &#39;id&#39; and returns it.
    * <p><b>200</b> - This status code indicates that a client request was successfully received, understood, and accepted.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param id The id of the customer which should be returned.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Subscriber
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--read">Read Documentation</a>

    **/
    public Subscriber read(Long spaceId, Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = readForHttpResponse(spaceId, id, params);
        String returnType = "Subscriber";
        if(returnType.equals("String")){
            return (Subscriber) (Object) response.parseAsString();
        }
        TypeReference typeRef = new TypeReference<Subscriber>() {};
        return (Subscriber)apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse readForHttpResponse(Long spaceId, Long id) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling read");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling read");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/read");
        if (spaceId != null) {
            String key = "spaceId";
            Object value = spaceId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (id != null) {
            String key = "id";
            Object value = id;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = null;
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content);
        httpRequest.getHeaders().setContentType("*/*");
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

    public HttpResponse readForHttpResponse(Long spaceId, Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling read");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling read");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/read");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'spaceId' to the map of query params
        allParams.put("spaceId", spaceId);
        // Add the required query param 'id' to the map of query params
        allParams.put("id", id);

        for (Map.Entry<String, Object> entryMap: allParams.entrySet()) {
            String key = entryMap.getKey();
            Object value = entryMap.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = null;
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content);
        httpRequest.getHeaders().setContentType("*/*");
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

  /**
    * Search
    * Searches for the entities as specified by the given query.
    * <p><b>200</b> - This status code indicates that a client request was successfully received, understood, and accepted.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param query The query restricts the customer which are returned by the search.
    * @return List&lt;Subscriber&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--search">Search Documentation</a>

    **/
    public List<Subscriber> search(Long spaceId, EntityQuery query) throws IOException {
        HttpResponse response = searchForHttpResponse(spaceId, query);
        String returnType = "List&lt;Subscriber&gt;";
        if(returnType.equals("String")){
          return (List<Subscriber>) (Object) response.parseAsString();
        }
        TypeReference typeRef = new TypeReference<List<Subscriber>>() {};
        return (List<Subscriber>)apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Search
    * Searches for the entities as specified by the given query.
    * <p><b>200</b> - This status code indicates that a client request was successfully received, understood, and accepted.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param query The query restricts the customer which are returned by the search.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;Subscriber&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--search">Search Documentation</a>

    **/
    public List<Subscriber> search(Long spaceId, EntityQuery query, Map<String, Object> params) throws IOException {
        HttpResponse response = searchForHttpResponse(spaceId, query, params);
        String returnType = "List&lt;Subscriber&gt;";
        if(returnType.equals("String")){
            return (List<Subscriber>) (Object) response.parseAsString();
        }
        TypeReference typeRef = new TypeReference<List<Subscriber>>() {};
        return (List<Subscriber>)apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse searchForHttpResponse(Long spaceId, EntityQuery query) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling search");
        }// verify the required parameter 'query' is set
        if (query == null) {
            throw new IllegalArgumentException("Missing the required parameter 'query' when calling search");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/search");
        if (spaceId != null) {
            String key = "spaceId";
            Object value = spaceId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(query);
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
        
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

      public HttpResponse searchForHttpResponse(Long spaceId, java.io.InputStream query, String mediaType) throws IOException {
          // verify the required parameter 'spaceId' is set
              if (spaceId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling search");
              }// verify the required parameter 'query' is set
              if (query == null) {
              throw new IllegalArgumentException("Missing the required parameter 'query' when calling search");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/search");
              if (spaceId != null) {
                  String key = "spaceId";
                  Object value = spaceId;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }

              String url = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(url);

              HttpContent content = query == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, query);
              HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
              
              httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
              return httpRequest.execute();
      }

    public HttpResponse searchForHttpResponse(Long spaceId, EntityQuery query, Map<String, Object> params) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling search");
        }// verify the required parameter 'query' is set
        if (query == null) {
            throw new IllegalArgumentException("Missing the required parameter 'query' when calling search");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/search");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'spaceId' to the map of query params
        allParams.put("spaceId", spaceId);

        for (Map.Entry<String, Object> entryMap: allParams.entrySet()) {
            String key = entryMap.getKey();
            Object value = entryMap.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(query);
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
        
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

  /**
    * Update
    * This updates the entity with the given properties. Only those properties which should be updated can be provided. The &#39;id&#39; and &#39;version&#39; are required to identify the entity.
    * <p><b>200</b> - This status code indicates that a client request was successfully received, understood, and accepted.
    * <p><b>409</b> - This status code indicates that there was a conflict with the current version of the data in the database and the provided data in the request.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param entity The customer with all the properties which should be updated. The id and the version are required properties.
    * @return Subscriber
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--update">Update Documentation</a>

    **/
    public Subscriber update(Long spaceId, SubscriberUpdate entity) throws IOException {
        HttpResponse response = updateForHttpResponse(spaceId, entity);
        String returnType = "Subscriber";
        if(returnType.equals("String")){
          return (Subscriber) (Object) response.parseAsString();
        }
        TypeReference typeRef = new TypeReference<Subscriber>() {};
        return (Subscriber)apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update
    * This updates the entity with the given properties. Only those properties which should be updated can be provided. The &#39;id&#39; and &#39;version&#39; are required to identify the entity.
    * <p><b>200</b> - This status code indicates that a client request was successfully received, understood, and accepted.
    * <p><b>409</b> - This status code indicates that there was a conflict with the current version of the data in the database and the provided data in the request.
    * <p><b>442</b> - This status code indicates that the server cannot or will not process the request due to something that is perceived to be a client error.
    * <p><b>542</b> - This status code indicates that the server encountered an unexpected condition that prevented it from fulfilling the client request.
    * @param spaceId 
    * @param entity The customer with all the properties which should be updated. The id and the version are required properties.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Subscriber
    * @throws IOException if an error occurs while attempting to invoke the API
    * For more information visit this link.
    * @see <a href="https://ep.trustpayments.com/doc/api/web-service#subscriber-service--update">Update Documentation</a>

    **/
    public Subscriber update(Long spaceId, SubscriberUpdate entity, Map<String, Object> params) throws IOException {
        HttpResponse response = updateForHttpResponse(spaceId, entity, params);
        String returnType = "Subscriber";
        if(returnType.equals("String")){
            return (Subscriber) (Object) response.parseAsString();
        }
        TypeReference typeRef = new TypeReference<Subscriber>() {};
        return (Subscriber)apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateForHttpResponse(Long spaceId, SubscriberUpdate entity) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling update");
        }// verify the required parameter 'entity' is set
        if (entity == null) {
            throw new IllegalArgumentException("Missing the required parameter 'entity' when calling update");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/update");
        if (spaceId != null) {
            String key = "spaceId";
            Object value = spaceId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(entity);
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
        
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

      public HttpResponse updateForHttpResponse(Long spaceId, java.io.InputStream entity, String mediaType) throws IOException {
          // verify the required parameter 'spaceId' is set
              if (spaceId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling update");
              }// verify the required parameter 'entity' is set
              if (entity == null) {
              throw new IllegalArgumentException("Missing the required parameter 'entity' when calling update");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/update");
              if (spaceId != null) {
                  String key = "spaceId";
                  Object value = spaceId;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }

              String url = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(url);

              HttpContent content = entity == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, entity);
              HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
              
              httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
              return httpRequest.execute();
      }

    public HttpResponse updateForHttpResponse(Long spaceId, SubscriberUpdate entity, Map<String, Object> params) throws IOException {
        // verify the required parameter 'spaceId' is set
        if (spaceId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'spaceId' when calling update");
        }// verify the required parameter 'entity' is set
        if (entity == null) {
            throw new IllegalArgumentException("Missing the required parameter 'entity' when calling update");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/subscriber/update");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'spaceId' to the map of query params
        allParams.put("spaceId", spaceId);

        for (Map.Entry<String, Object> entryMap: allParams.entrySet()) {
            String key = entryMap.getKey();
            Object value = entryMap.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(entity);
        HttpRequest httpRequest = apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content);
        
        
        httpRequest.setReadTimeout(ApiClient.READ_TIMEOUT);
        return httpRequest.execute();
    }

}