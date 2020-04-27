package com.zsx.test.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonNodeTest {

    @Test
    void testStringToJsonNode() throws JsonProcessingException {
        String data = "{\"realmCode\": \"Butler\"," +
                "\"modelName\": \"Permission\"," +
                "\"dataId\": \"kcrfXMRp\"," +
                    "\"referenceInfoList\": [{" +
                    "\"referringRealmCode\": \"PermissionManager\"," +
                    "\"referringModelName\": \"RoleGroup\"," +
                    "\"referringDataKey\": \"uEhJIADk\"" +
                "}]}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(data);
        System.out.println(jsonNode);
    }

    @Test
    void testMapToJsonNode() {
        Map<String, Object> map = Map.of("realmCode", "Butler",
                "modelName", "Permission",
                "dataId", "kcrfXMRp",
                "referenceInfoList", List.of(ReferenceInfo.of("PermissionManager", "RoleGroup", "uEhJIADk")));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.valueToTree(map);
        System.out.println(jsonNode);
    }

    @Test
    void testJsonNodeToMap() throws JsonProcessingException {
        String data = "{\"realmCode\": \"Butler\"," +
                "\"modelName\": \"Permission\"," +
                "\"dataId\": \"kcrfXMRp\"," +
                "\"referenceInfoList\": [{" +
                "\"referringRealmCode\": \"PermissionManager\"," +
                "\"referringModelName\": \"RoleGroup\"," +
                "\"referringDataKey\": \"uEhJIADk\"" +
                "}]}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(data);
        System.out.println(jsonNode);
        Map<String, Object> result = mapper.convertValue(jsonNode, new TypeReference<>(){});
        result.remove("referenceInfoList");
        System.out.println(result);
    }

    @Test
    void testJsonNodeRemoveNode() {
        Map<String, Object> map = Map.of("realmCode", "Butler",
                "modelName", "Permission",
                "dataId", "kcrfXMRp",
                "referenceInfoList", List.of(ReferenceInfo.of("PermissionManager", "RoleGroup", "uEhJIADk")));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.valueToTree(map);
        System.out.println(jsonNode);
        Map<String, Object> result = mapper.convertValue(jsonNode, new TypeReference<>(){});
        result.remove("referenceInfoList");
        System.out.println(result);
        JsonNode jsonNode1 = mapper.valueToTree(result);
        System.out.println(jsonNode1);
        Iterator<String> fieldNames = jsonNode1.fieldNames();
        while(fieldNames.hasNext()) {
            System.out.println(fieldNames.next());
        }

    }


}
