package com.gta.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Qaa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long refId;
	
	@Column(nullable = false, length = 255)
	private String Question;
	@Column(nullable = false, length = 999)
	private String Answer;
	@Column(nullable = false, length = 500)
	private String Action;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRefId() {
		return refId;
	}
	public void setRefId(Long refId) {
		this.refId = refId;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	
	
	@Override
	public String toString() {
		return "Qaa [id=" + id + ", refId=" + refId + ", Question=" + Question + ", Answer=" + Answer + ", Action="
				+ Action + "]";
	}
	
	
	
}
