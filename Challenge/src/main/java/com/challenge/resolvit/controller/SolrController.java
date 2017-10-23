package com.challenge.resolvit.controller;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.resolvit.model.ChallengeResponse;
import com.challenge.resolvit.model.SentenceSolrDTO;
import com.challenge.resolvit.services.SentenceService;

@RestController
@RequestMapping("/solr")
public class SolrController {
	@Autowired
	private SentenceService sentenceService;


	@RequestMapping(value = "/allWords", method = RequestMethod.GET)
	public Iterable<SentenceSolrDTO> findByRepo() throws IOException {
		return sentenceService.findAllWords();
	}

	@RequestMapping(value = "/countWords", method = RequestMethod.POST)
	@ResponseBody
	public ChallengeResponse countWords(@RequestBody String request) {
		if (StringUtils.isBlank(request)) {
			return null;
		}
		
		sentenceService.cleanRepository();
		sentenceService.insertSentences(request);
		return sentenceService.getWordsCount();
	}


}
