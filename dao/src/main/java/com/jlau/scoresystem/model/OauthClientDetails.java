package com.jlau.scoresystem.model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by cxr1205628673 on 2020/9/16.
 */
public class OauthClientDetails implements Serializable{
    @NotBlank(message = "客户端id不能为空")
    private String clientId;
    private String resourceIds;
    @NotBlank(message = "客户端密钥不能为空")
    private String clientSecret;
    @NotBlank(message = "权限作用域不能为空")
    private String scope;
    private String authorizedGrantTypes;
    private String webServerRedirectUri;
    private String authorities;
    private int accessTokenValidity = 12*3600;
    private int refreshTokenValidity = 12*3600;
    private String additionalInformation;
    private String autoApprove;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUrl) {
        this.webServerRedirectUri = webServerRedirectUrl;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public int getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(int accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public int getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(int refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionInformation) {
        this.additionalInformation = additionInformation;
    }

    public String getAutoApprove() {
        return autoApprove;
    }

    public void setAutoApprove(String autoApprove) {
        this.autoApprove = autoApprove;
    }

}
