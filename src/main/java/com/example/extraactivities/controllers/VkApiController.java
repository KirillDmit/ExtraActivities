package com.example.extraactivities.controllers;

import com.example.extraactivities.services.VKService;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "REST Controller", description = "REST API Controller")
@RequestMapping("/vk")
@AllArgsConstructor
public class VkApiController {
    private VKService vkService;
    @Operation(summary = "get all posts", description = "allows to get all posts that exist in the vk")
    @GetMapping("/rent_flats")
    public GetResponse getFeedRTF(@RequestParam int offset) throws ClientException, ApiException {
        return vkService.getStudentUnionInfo("rent_flats",0);
    }
    @GetMapping("/sporturfu")
    public GetResponse getSport(@RequestParam int offset) throws ClientException, ApiException {
        return vkService.getStudentUnionInfo("sporturfu",offset);
    }
    @GetMapping("/urfumemes")
    public GetResponse getMemes(@RequestParam int offset) throws ClientException, ApiException {
        return vkService.getStudentUnionInfo("urfumemes",offset);
    }
    @GetMapping("/iot_first_urfu")
    public GetResponse getIOT(@RequestParam int offset) throws ClientException, ApiException {
        return vkService.getStudentUnionInfo("iot_first_urfu",offset);
    }
    @GetMapping("/eda_urfu")
    public GetResponse getFood(@RequestParam int offset) throws ClientException, ApiException {
        return vkService.getStudentUnionInfo("eda_urfu",offset);
    }
    @GetMapping("/posnews")
    public GetResponse getFeed(@RequestParam int offset) throws ClientException, ApiException {
        return vkService.getStudentUnionInfo("posnews",offset);
    }
}
