package com.challenge.resolvit.services;

import com.challenge.resolvit.model.ChallengeResponse;
import com.challenge.resolvit.model.WordSolrDTO;

public interface SentenceService {
	public Iterable<WordSolrDTO> findAllWords();
	
	public void cleanRepository();
	
	public void insertSentences(String request);
	
	public ChallengeResponse getWordsCount();
}
