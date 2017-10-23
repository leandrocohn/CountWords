package com.challenge.resolvit.services;

import com.challenge.resolvit.model.ChallengeResponse;
import com.challenge.resolvit.model.SentenceSolrDTO;

public interface SentenceService {
	public Iterable<SentenceSolrDTO> findAllWords();
	
	public void cleanRepository();
	
	public void insertSentences(String request);
	
	public ChallengeResponse getWordsCount();
}
