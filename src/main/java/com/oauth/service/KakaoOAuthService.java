package com.oauth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class KakaoOAuthService {
    @Value("${kakao.client-id}")
    private String clientId;
    @Value("${kakao.redirect-uri}")
    private String redirectUri;
    @Value("${kakao.client-secret:}")
    private String clientSecret;
    @Value("${kakao.token-url}")
    private String tokenUrl;
    @Value("${kakao.user-info-url}")
    private String userInfoUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public KakaoUserResponse getUserInfoByCode(String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", clientId);
        params.add("redirect_uri", redirectUri);
        params.add("code", code);
        if (clientSecret != null && !clientSecret.isEmpty()) {
            params.add("client_secret", clientSecret);
        }
        HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(params, headers);
        ResponseEntity<KakaoTokenResponse> tokenResponse = restTemplate.postForEntity(tokenUrl, tokenRequest, KakaoTokenResponse.class);
        String accessToken = tokenResponse.getBody().getAccess_token();

        // 2. Use access token to get user info
        HttpHeaders userHeaders = new HttpHeaders();
        userHeaders.setBearerAuth(accessToken);
        HttpEntity<?> userRequest = new HttpEntity<>(userHeaders);
        ResponseEntity<KakaoUserResponse> userResponse = restTemplate.exchange(userInfoUrl, HttpMethod.GET, userRequest, KakaoUserResponse.class);
        return userResponse.getBody();
    }
}
