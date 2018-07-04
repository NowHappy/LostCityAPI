package com.happy.game.lostcity.domain.users;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserDto {

	@Data
	public static class Create{
		private String id;
	    private String name;
	    private String pwd;
	}
	
    @Data
    public static class Password {
        @NotBlank
        @Size(min = 6)
        private String pwd;
    	
        @NotBlank
        @Size(min = 6)
        private String new_pwd;
    }
	
	@Data
	public static class UserInfo{
		private Long sid;
		
		private String id;
	    private String name;
	    
	    @JsonProperty("created_at")
        private LocalDateTime createdAt;

        @JsonProperty("last_modified_at")
        private LocalDateTime lastModifiedAt;
	}
}