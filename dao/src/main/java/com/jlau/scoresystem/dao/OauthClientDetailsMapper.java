package com.jlau.scoresystem.dao;

import com.jlau.scoresystem.model.OauthClientDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/16.
 */
@Mapper
public interface OauthClientDetailsMapper {
    OauthClientDetails findClientDetailsById(String id);
    List findAllClientDetails();
    Integer addClientDetails(OauthClientDetails clientDetails);
    Integer saveClientDetails(OauthClientDetails clientDetails);
    Integer deleteClientDetailsById(String id);
}
