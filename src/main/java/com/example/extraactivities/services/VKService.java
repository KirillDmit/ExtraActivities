package com.example.extraactivities.services;

import com.example.extraactivities.configs.VkAppConfig;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.springframework.stereotype.Service;

@Service
public class VKService {
    private VkAppConfig params;
    private final UserActor actor;
    private final VkApiClient vk;


    public VKService(VkAppConfig params) {
        this.params = params;
        TransportClient transportClient = HttpTransportClient.getInstance();
        vk = new VkApiClient(transportClient);
        actor = new UserActor(params.getAppId(), params.getAccessToken());
    }

    public GetResponse getStudentUnionInfo(String group, int offset) throws ClientException, ApiException {
        return vk.wall().get(actor).domain(group).count(10).offset(offset).execute();
    }
}
