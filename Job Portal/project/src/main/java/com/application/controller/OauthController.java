package com.application.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.oauth2.core.user.OAuth2User;

@RestController
@RequestMapping("/api/oauth/")
public class OauthController {
    
    @GetMapping("user")
    public Map<String, Object> getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttributes();
    }        
    
    @GetMapping("token")
    public String getAccessToken(OAuth2AuthenticationToken authentication) {
        OidcUser user = (OidcUser) authentication.getPrincipal();
        return user.getIdToken().getTokenValue();
    }
    

}
