package com.challenge.resolvit.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.solr.core.query.result.FacetFieldEntry;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.stereotype.Service;

import com.challenge.resolvit.model.ChallengeResponse;
import com.challenge.resolvit.model.ChallengeResponse.WordDTO;
import com.challenge.resolvit.model.WordSolrDTO;
import com.challenge.resolvit.repository.SentenceRepository;
import com.challenge.resolvit.services.SentenceService;

@Service
public class SentencesServiceImpl implements SentenceService {

	@Autowired
	private SentenceRepository sentenceRepository;

	// Internal attributes
	private static Logger log = LoggerFactory.getLogger(SentencesServiceImpl.class);
	
	@Override
	public Iterable<WordSolrDTO> findAllWords() {
		return sentenceRepository.findAll();
	}

	@Override
	public void cleanRepository() {
		sentenceRepository.deleteAll();		
	}

	@Override
	public void insertSentences(String request) {
		log.debug("Inserting the following sentence: " + request);
		
		List<WordSolrDTO> sentenceList = new ArrayList<WordSolrDTO>();
		String[] sentences = request.split("\\.");
		for(int index = 0; index < sentences.length; index ++) {
			String[] words = sentences[index].split("\\s+");
			for (String word : words) {
				WordSolrDTO model = new WordSolrDTO();
				model.setId(UUID.randomUUID().getMostSignificantBits());
				model.setWord(word);
				model.setSentenceOrder(index);
				sentenceList.add(model);
			}
		}
		
		log.debug("Indexing sentences.");
		sentenceRepository.save(sentenceList);

	}

	@Override
	public ChallengeResponse getWordsCount() {
		log.debug("Getting words count");
		ChallengeResponse response = new ChallengeResponse();
		FacetPage<WordSolrDTO> facetSentences = sentenceRepository.findAllFacetOnWord(new PageRequest(0, 50, null));

		for (Page<FacetFieldEntry> page : facetSentences.getFacetResultPages()) {
			for (FacetFieldEntry entry : page) {
				List<WordSolrDTO> sentences = sentenceRepository.findByWord(entry.getValue());
				WordDTO wordDto = new WordDTO();
				wordDto.setTotalOccurrances(entry.getValueCount());
				wordDto.setWord(entry.getValue());
				for (WordSolrDTO sentence : sentences) {
					wordDto.addSentenceIndex(sentence.getSentenceOrder());
				}

				response.addResult(wordDto);
			}
		}

		log.debug("Sorting words");
		response.getResults().sort((left, right) -> left.getWord().compareTo(right.getWord()));

		return response;
	}

}
