# Description

Sample project showing that when creating RestClient using request factory new `JdkClientHttpRequestFactory()`, like the code below

```java
@Bean
  public RestClient restClient(RestClient.Builder builder) {
    return builder
        .requestFactory(new JdkClientHttpRequestFactory()) 
        .baseUrl(baseUrl)
        .build();
  }
```

Tests using `@RestClientTest()` and `MockRestServiceServer server` fail to connect unless new JdkClientHttpRequestFactory() is removed
