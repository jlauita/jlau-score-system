package com.jlau.scoresystem.controller;

import com.jlau.scoresystem.model.OauthClientDetails;
import com.jlau.scoresystem.service.OauthClientDetialsService;
import com.jlau.scoresystem.vo.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by cxr1205628673 on 2020/9/16.
 */
@RestController
public class OauthClientController {
    Logger logger = LoggerFactory.getLogger(OauthClientController.class);
    @Autowired
    private OauthClientDetialsService clientDetialsService;
    @PostMapping("/client/register")
    public Object registerOauthClient(@RequestBody OauthClientDetails clientDetails){
        try {
            int result = clientDetialsService.addOauthClientDetails(clientDetails);
        }catch (Exception e){
            ResultModel model = ResultModel.fail(e.getMessage());
            return model;
        }
        return ResultModel.ok();
    }
    @GetMapping("/user/info")
    public Principal getUserInfo(Principal principal){
        logger.info("User get principal : "+principal.toString());
        return principal;
    }
}
