package com.food.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="documents")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(length = 36)
	private Long id;
	
	@Column(name="document_type",length = 50,nullable = false)
private String documentType;
	
	@Column(name="verification_status",length = 20,nullable = false)
private String verificationStatus;
	
	@Column(length = 500)
private String remarks;

@CreationTimestamp
@Column(name="uploaded_at",nullable = false,updatable = false)
private LocalDateTime uploadedAt;

@ManyToOne()
@JoinColumn(name="media_id",nullable = false)
//@Column(name="media_id",length = 36,nullable = false)
private Media media;

@ManyToOne()
@JoinColumn(name="user_id",nullable = false)
//@Column(name="user_id",length = 36,nullable = false)
private User user;


}
