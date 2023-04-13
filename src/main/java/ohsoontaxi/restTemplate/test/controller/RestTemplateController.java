package ohsoontaxi.restTemplate.test.controller;

import lombok.extern.slf4j.Slf4j;
import ohsoontaxi.restTemplate.test.RestTemplateService;
import ohsoontaxi.restTemplate.test.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest-template")
@Slf4j
public class RestTemplateController {

    RestTemplateService restTemplateService;

    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @PostMapping("/req")
    public UserInfo getHello(){
        UserInfo test = restTemplateService.test();
        log.info(test.getToken());
        return restTemplateService.test();
    }


}
