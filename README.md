# OAuth Service

A Spring Boot backend service for OAuth 2.0 authentication supporting Kakao (easily extensible for Naver, Google, etc).

## Official Kakao Developer Documentation
For more details on the Kakao OAuth 2.0 REST API, see the [Official Kakao Developer Document](https://developers.kakao.com/docs/latest/en/kakaologin/rest-api#request-code).

## Features
- OAuth 2.0 login flow with Kakao
- Exchanges authorization code for access token
- Retrieves user profile information from Kakao
- Returns user info to the frontend as JSON

## Endpoints

### 1. Kakao OAuth Callback
```
GET /oauth/kakao/callback?code=AUTH_CODE
```
- Receives the Kakao authorization code from the frontend
- Exchanges the code for an access token
- Fetches user info from Kakao and returns it as JSON

## Getting Started

### Prerequisites
- Java 17+
- Maven
- Kakao Developer account and app credentials

### Setup
1. **Clone the repository:**
   ```sh
   git clone <your-repo-url>
   cd oauth-service
   ```
2. **Configure application properties:**
   - Copy `src/main/resources/application-example.properties` to `src/main/resources/application.properties`.
   - Fill in your Kakao app credentials and URLs:
     ```properties
     kakao.client-id=YOUR_KAKAO_CLIENT_ID
     kakao.redirect-uri=YOUR_KAKAO_REDIRECT_URI
     # kakao.client-secret=YOUR_KAKAO_CLIENT_SECRET (optional)
     kakao.token-url=https://kauth.kakao.com/oauth/token
     kakao.user-info-url=https://kapi.kakao.com/v2/user/me
     ```
3. **Build and run:**
   ```sh
   ./mvnw spring-boot:run
   ```

## Security Notice
- The `application.properties` file is gitignored to prevent accidental commits of sensitive credentials.
- Always keep your client secrets secure!

## Extending
- To add more OAuth providers (e.g., Google, Naver), create new service and controller classes following the Kakao example.

## License
MIT or your preferred license.
