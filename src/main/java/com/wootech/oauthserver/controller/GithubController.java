package com.wootech.oauthserver.controller;

import java.util.HashMap;
import java.util.Map;

import com.wootech.oauthserver.dto.OauthTokenResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@RestController
public class GithubController {
    private static final String OAUTH_ID = "TEST1";
    private static final String EMAIL = "iu@email.com";
    private static final String NAME = "iu";
    private static final String IMAGE_URL = "https://www.allkpop.com/upload/2018/10/af_org/27105129/IU.jpg";
    private static final String GITHUB_URL = "https://github.com";

    @PostMapping(value = "/oauth/token", consumes = APPLICATION_FORM_URLENCODED_VALUE)
    public OauthTokenResponse fakeAccessToken() {
        return new OauthTokenResponse(
                "access-token",
                "email,name,image_url",
                "Bearer"
        );
    }

    @GetMapping(value = "/user")
    public Map<String, Object> fakeUserInfo() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("id", OAUTH_ID);
        attributes.put("email", EMAIL);
        attributes.put("name", NAME);
        attributes.put("avatar_url", IMAGE_URL);
        attributes.put("html_url", GITHUB_URL);
        return attributes;
    }
}
