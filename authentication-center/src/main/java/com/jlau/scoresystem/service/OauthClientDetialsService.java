package com.jlau.scoresystem.service;

import com.jlau.scoresystem.dao.OauthClientDetailsMapper;
import com.jlau.scoresystem.model.OauthClientDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/16.
 */
@Service
@Transactional
public class OauthClientDetialsService {
    private Logger logger = LoggerFactory.getLogger(OauthClientDetialsService.class);
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private OauthClientDetailsMapper clientDetailsMapper;
    public OauthClientDetails findOauthClientDetailsById(String clientId){
        OauthClientDetails clientDetails = clientDetailsMapper.findClientDetailsById(clientId);
        return clientDetails;
    }
    public List findAllOauthClientDetails(){
        List clientDetails = clientDetailsMapper.findAllClientDetails();
        return clientDetails;
    }
    public int addOauthClientDetails(OauthClientDetails clientDetails) throws Exception{
        OauthClientDetails exsistClientDetails = findOauthClientDetailsById(clientDetails.getClientId());
        if(exsistClientDetails != null){
            logger.debug(clientDetails.getClientId()+":已经存在该客户端");
            throw new Exception("已经存在该名称客户端");
        }
        clientDetails.setClientSecret(passwordEncoder.encode(clientDetails.getClientSecret()));
        int addResult = clientDetailsMapper.addClientDetails(clientDetails);
        return addResult;
    }
    public int saveOauthClientDetails(OauthClientDetails clientDetails) throws Exception{
        if(clientDetails.getClientId() == null || clientDetails.getClientId() == ""){
            throw new Exception("客户端名称不能为空");
        }
        int saveResult = clientDetailsMapper.saveClientDetails(clientDetails);
        return saveResult;
    }
    public int deleteOauthClientDetails(String id){
        int deleteResult = clientDetailsMapper.deleteClientDetailsById(id);
        return deleteResult;
    }
}
