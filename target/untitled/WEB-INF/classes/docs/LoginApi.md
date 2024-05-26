# LoginApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**webappJSPEntranceJspPost**](LoginApi.md#webappJSPEntranceJspPost) | **POST** /webapp/JSP/Entrance.jsp | Login


<a name="webappJSPEntranceJspPost"></a>
# **webappJSPEntranceJspPost**
> InlineResponse200 webappJSPEntranceJspPost(inlineObject)

Login

Logs in a user with a login and password.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoginApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    LoginApi apiInstance = new LoginApi(defaultClient);
    InlineObject inlineObject = new InlineObject(); // InlineObject | 
    try {
      InlineResponse200 result = apiInstance.webappJSPEntranceJspPost(inlineObject);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoginApi#webappJSPEntranceJspPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inlineObject** | [**InlineObject**](InlineObject.md)|  | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**400** | Bad Request |  -  |

