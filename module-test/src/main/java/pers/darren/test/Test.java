package pers.darren.test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpRequest.BodyPublishers;
import static java.net.http.HttpResponse.BodyHandlers;
import static java.nio.charset.StandardCharsets.UTF_8;
import static pers.darren.common.constant.Constants.APPLICATION_JSON;

public final class Test {

    private static final String GET_ROLE_BY_ID = "http://localhost:8888/role/getRoleById?id=74deda54-d7e5-4256-b68a-830c622d95de";
    private static final String MODIFY_ROLE_BY_ID = "http://localhost:8888/role/modifyRoleById";

    public static void main(String[] args) throws IOException, InterruptedException {
        getRoleById();
        modifyRoleById();
    }

    public static void getRoleById() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(GET_ROLE_BY_ID)).GET().build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString(UTF_8));
        System.out.println(httpResponse.body());
    }

    public static void modifyRoleById() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        String requestBody = """
                {
                    "id": "74deda54-d7e5-4256-b68a-830c622d95de",
                    "roleName": "系统管理员",
                    "roleDesc": "系统管理员，拥有系统级别的权限",
                    "modifiedBy": "1"
                }
                """;
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(MODIFY_ROLE_BY_ID)).setHeader("Content-Type", APPLICATION_JSON).POST(BodyPublishers.ofString(requestBody.stripIndent(), UTF_8)).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString(UTF_8));
        System.out.println(httpResponse.body());
    }
}
