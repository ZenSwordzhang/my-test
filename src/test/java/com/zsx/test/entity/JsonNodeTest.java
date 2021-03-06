package com.zsx.test.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
                "referenceInfoList", List.of(ReferenceInfo.of("PermissionManager", "RoleGroup", "uEhJIADk", "remarks")));
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
                "referenceInfoList", List.of(ReferenceInfo.of("PermissionManager", "RoleGroup", "uEhJIADk", "remarks")));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.valueToTree(map);
        System.out.println(jsonNode);
        if (jsonNode instanceof ObjectNode) {
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

    @Test
    void testListRemoveNode() {
        List<ReferenceInfo> infos = List.of(ReferenceInfo.of("PermissionManager", "RoleGroup", "uEhJIADk", "remarks"));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.valueToTree(infos);
        System.out.println(jsonNode);
        if (jsonNode instanceof ArrayNode) {
            List<ReferenceInfo> infos1 = mapper.convertValue(jsonNode, new TypeReference<>(){});
            System.out.println(infos1);
        }
    }


}
