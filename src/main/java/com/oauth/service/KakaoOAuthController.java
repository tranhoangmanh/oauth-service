package com.oauth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth/kakao")
public class KakaoOAuthController {
    private final KakaoOAuthService kakaoOAuthService;

    public KakaoOAuthController(KakaoOAuthService kakaoOAuthService) {
        this.kakaoOAuthService = kakaoOAuthService;
    }

    @GetMapping("/callback")
    public ResponseEntity<?> kakaoCallback(@RequestParam("code") String code) {
        return ResponseEntity.ok(kakaoOAuthService.getUserInfoByCode(code));
    }
}
