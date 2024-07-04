package lk.ijse.gdse.aad65.service.impl;

import lk.ijse.gdse.aad65.service.UserClientService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserClientServiceIMPL implements UserClientService {
    private static final Logger logger = LoggerFactory.getLogger(UserClientServiceIMPL.class);
    private final RestTemplate restTemplate;
    @Override
    public boolean isExitsUser(String userId) {
        try {
            String url = "http://user_service/api/v1/user/userExists/" + userId;
            Boolean userExists = restTemplate.getForObject(url, Boolean.class);
            logger.info("User Exists: {}", userExists);
            return userExists != null && userExists;
        } catch (Exception e) {
            logger.error("Error checking if user exists", e);
        }
        return false;
    }
    }
}
