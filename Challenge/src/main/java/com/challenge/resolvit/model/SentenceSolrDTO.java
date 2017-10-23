package com.challenge.resolvit.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

public class SentenceSolrDTO {

	@Id
	@Field
	private long id;

	@Field
	private String sentence;
	@Field("sentence_order")
	private long sentenceOrder;

	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public long getSentenceOrder() {
		return sentenceOrder;
	}
	public void setSentenceOrder(long sentenceOrder) {
		this.sentenceOrder = sentenceOrder;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
