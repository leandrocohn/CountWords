package com.challenge.resolvit.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

public class WordSolrDTO {

	@Id
	@Field
	private long id;

	@Field
	private String word;
	@Field("sentence_order")
	private long sentenceOrder;

	public String getWord() {
		return word;
	}
	public void setWord(String sentence) {
		this.word = sentence;
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
