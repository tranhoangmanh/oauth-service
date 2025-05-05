package com.oauth.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class KakaoUserResponse {
    private Long id;
    @JsonProperty("kakao_account")
    private Map<String, Object> kakaoAccount;
    @JsonProperty("properties")
    private Map<String, Object> properties;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Map<String, Object> getKakaoAccount() { return kakaoAccount; }
    public void setKakaoAccount(Map<String, Object> kakaoAccount) { this.kakaoAccount = kakaoAccount; }
    public Map<String, Object> getProperties() { return properties; }
    public void setProperties(Map<String, Object> properties) { this.properties = properties; }
}
