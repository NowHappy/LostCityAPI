package com.happy.game.lostcity.common;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "oauth_client_details")
@Data
@EqualsAndHashCode(callSuper = false)
public class AppEntity {

    @Column(name="client_id")
    private String clientId;

    @Column(name="resource_ids")
    private String resourceIds;

    @Column(name="client_secret")
    private String clientSecret;

    private String scope;

    @Column(name="authorized_grant_types")
    private String authorizedGrantTypes;

    @Column(name="web_server_redirect_uri")
    private String webServerRedirectUri;

    private String authorities;

    @Column(name="access_token_validity")
    private int accessTokenValidity;

    @Column(name="refresh_token_validity")
    private int refreshTokenValidity;

    @Column(name="additional_information")
    private String additionalInformation;

    private String autoapprove;

    @CreatedDate
    @Column(nullable = false, updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(updatable = true, name = "last_modified_at")
    private LocalDateTime lastModifiedAt;


}
