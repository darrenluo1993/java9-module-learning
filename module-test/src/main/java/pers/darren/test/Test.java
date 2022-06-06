package pers.darren.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pers.darren.common.core.model.AjaxResult;
import pers.darren.dao.role.model.Role;
import pers.darren.dao.user.model.User;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static java.net.http.HttpRequest.BodyPublishers;
import static java.net.http.HttpResponse.BodyHandlers;
import static java.nio.charset.StandardCharsets.UTF_8;
import static pers.darren.common.constant.Constants.APPLICATION_JSON;

public final class Test {

    private static final String LIST_ALL_USER = "http://localhost:8888/user/listAllUser";
    private static final String MODIFY_ROLE_BY_ID = "http://localhost:8888/role/modifyRoleById";
    private static final String MODIFY_USER_BY_ID = "http://localhost:8888/user/modifyUserById";
    private static final String GET_ROLE_BY_ID = "http://localhost:8888/role/getRoleById?id=74deda54-d7e5-4256-b68a-830c622d95de";

    public static void main(String[] args) throws IOException, InterruptedException {
        listAllUser();
        // getRoleById();
        // modifyRoleById();
        // modifyUserById();
    }

    private static void getRoleById() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(GET_ROLE_BY_ID)).GET().build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString(UTF_8));
        System.out.println("ResponseBody>>>" + httpResponse.body());
        // ResponseBody转成AjaxResult
        ObjectMapper objectMapper = new ObjectMapper();
        AjaxResult result = objectMapper.readValue(httpResponse.body(), AjaxResult.class);
        System.out.println("Code>>>" + result.getCode());
        System.out.println("Msg>>>" + result.getMsg());
        System.out.println("Data>>>" + result.getData());
        // 从AjaxResult中取出data（Role对象）并转成JSON字符串
        StringWriter writer = new StringWriter();
        objectMapper.writeValue(writer, result.getData());
        System.out.println("RoleMapJSON>>>" + writer);
        String roleMapJSON = objectMapper.writeValueAsString(result.getData());
        System.out.println("RoleMapJSON>>>" + roleMapJSON);
        // 将Role对象JSON字符串转成Role对象
        Role role = objectMapper.readValue(writer.toString(), Role.class);
        System.out.println("Role>>>" + role.toString());
        // 将Role对象转成JSON字符串
        writer = new StringWriter();
        objectMapper.writeValue(writer, role);
        System.out.println("RoleJSON>>>" + writer);
        String roleJSON = objectMapper.writeValueAsString(role);
        System.out.println("RoleJSON>>>" + roleJSON);
    }

    private static void modifyRoleById() throws IOException, InterruptedException {
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

    private static void listAllUser() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(LIST_ALL_USER)).GET().build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString(UTF_8));
        System.out.println("ResponseBody>>>" + httpResponse.body());
        ObjectMapper objectMapper = new ObjectMapper();
        AjaxResult result = objectMapper.readValue(httpResponse.body(), AjaxResult.class);
        String data = objectMapper.writeValueAsString(result.getData());
        System.out.println("UserListJSON>>>" + data);
        List<User> list = objectMapper.readValue(data, new TypeReference<>() {
        });
        System.out.println("UserList>>>" + list);
        list.forEach(System.out::println);
    }

    private static void modifyUserById() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        String requestBody = """
                {
                    "id": "8086331d-4ff3-4d10-b4bb-d7497cfc0e56",
                    "realname": "Jack",
                    "gender": "Male",
                    "age": 100,
                    "modifiedBy": "1"
                }
                """;
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(MODIFY_USER_BY_ID)).setHeader("Content-Type", APPLICATION_JSON).POST(BodyPublishers.ofString(requestBody.stripIndent(), UTF_8)).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString(UTF_8));
        System.out.println("ResponseBody>>>" + httpResponse.body());
        AjaxResult result = new ObjectMapper().readValue(httpResponse.body(), AjaxResult.class);
        System.out.println("AjaxResult>>>" + result.toString());
    }
}
