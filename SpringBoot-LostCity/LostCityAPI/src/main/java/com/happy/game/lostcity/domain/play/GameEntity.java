package com.happy.game.lostcity.domain.play;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "games")
@Data
public class GameEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "games_generator")
    @SequenceGenerator(name = "games_generator", sequenceName = "games_sid_seq", allocationSize = 1)
    @Column(name = "sid")
    @Setter(AccessLevel.NONE)
    private Long sid;
	
	private String address; //for private game
	
	@Column(name = "first_user")
	private Long firstUser;
	@Column(name = "second_user")
	private Long secondUser;
	
	@Column(name = "first_user_cards_in_hand")
	private Integer[] firstUserCardsInHand;
	@Column(name = "second_user_cards_in_hand")
	private Integer[] secondUserCardsInHand;
	
	@Column(name = "first_user_card_in_point")
	private Integer[] firstUserCardsInPoint;
	@Column(name = "second_user_card_in_point")
	private Integer[] secondUserCardsInPoint;
	
	@Column(name = "stack_of_cards")
	public Integer[] stackOfCards;
	
	private Integer[] yellow;
	private Integer[] blue;
	private Integer[] white;
	private Integer[] green;
	private Integer[] red;
	
	@Column(name = "first_user_score")
	private int firstUserScore = 0;
	@Column(name = "second_user_score")
	private int secondUserScore = 0;
	
	@Column(name = "whos_turn")
	private Integer whosTurn; //users_sid who is turn
	
	@CreatedDate
    @Column(nullable = false, updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(updatable = true, name = "last_modified_at")
    private LocalDateTime lastModifiedAt;
	
}
