package ohsoontaxi.restTemplate.test;

import lombok.extern.slf4j.Slf4j;
import ohsoontaxi.restTemplate.test.dto.UserInfo;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class RestTemplateService {

    public UserInfo test(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080")
                .path("/api/server/path-variable/{name}")
                .encode()
                .build()
                .expand("이훈일")
                .toUri();
        log.info("uri : {}",uri);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserInfo> responseEntity = restTemplate.postForEntity(uri, null, UserInfo.class);

        log.info("responseEntity.getBody()={}",responseEntity.getBody());
        return responseEntity.getBody();
    }
}
