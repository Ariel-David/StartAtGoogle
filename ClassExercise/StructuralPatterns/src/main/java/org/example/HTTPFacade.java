package StructuralPatterns.src.main.java.org.example;

import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.auth.BasicScheme;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class HTTPFacade {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://reqres.in/api/users?page=2";
    private static final String POST_URL = "https://reqres.in/api/users";


    static void sendPOST() throws IOException {3
        HttpPost httpPost = new HttpPost(POST_URL);
        CloseableHttpClient client = HttpClients.createDefault();
        httpPost.setHeader("content-type", "application/json");
        StringEntity stringEntity = new StringEntity("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response2 = client.execute(httpPost);
        Scanner sc = new Scanner(response2.getEntity().getContent());
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }

    public static void sendGET() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(GET_URL);
        httpGet.addHeader("User-Agent", USER_AGENT);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        final String code = httpResponse.toString();
        System.out.println(code);


        BufferedReader reader = new BufferedReader(new InputStreamReader(
                httpResponse.getEntity().getContent()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        // print result
        System.out.println(response.toString());
        httpClient.close();
    }

    public static void RequestPUT() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPut httpPut = new HttpPut("https://reqres.in/api/users/2");
            httpPut.setHeader("content-type", "application/json");
            StringEntity stringEntity = new StringEntity("{\n" +
                    "    \"name\": \"morpheus\",\n" +
                    "    \"job\": \"zion resident\"\n" +
                    "}");
            httpPut.setEntity(stringEntity);
            CloseableHttpResponse response2 = httpclient.execute(httpPut);
            Scanner sc = new Scanner(response2.getEntity().getContent());
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
        }
    }

    public static void RequestDELETE() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete("https://reqres.in/api/users/2");
            CloseableHttpResponse response = httpclient.execute(httpDelete);
            HttpEntity entity = response.getEntity();
            if(entity != null){
                EntityUtils.toString(entity);
            }
            else{
                System.out.println("Delete: null");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendPATCH() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPatch httpPatch = new HttpPatch("https://reqres.in/api/users/2");
        httpPatch.setHeader("content-type", "application/json");
        StringEntity stringEntity = new StringEntity("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}");
        httpPatch.setEntity(stringEntity);
        CloseableHttpResponse response2 = httpclient.execute(httpPatch);
        Scanner sc = new Scanner(response2.getEntity().getContent());
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }

}
