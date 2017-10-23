package com.challenge.resolvit.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChallengeResponse {
	private List<WordDTO> results = new ArrayList<WordDTO>();
	public List<WordDTO> getResults() {
		return results;
	}
	public void setResults(List<WordDTO> results) {
		this.results = results;
	}
	public void addResult(WordDTO word) {
		results.add(word);
	}

	public static class WordDTO {
		private String word;
		@JsonProperty("total-occurances")
		private Long totalOccurrances;
		@JsonProperty("sentence-indexes")
		private List<Long> sentenceIndexes = new ArrayList<Long>();

		public String getWord() {
			return word;
		}
		public void setWord(String word) {
			this.word = word;
		}
		public Long getTotalOccurrances() {
			return totalOccurrances;
		}
		public void setTotalOccurrances(Long totalOccurrances) {
			this.totalOccurrances = totalOccurrances;
		}
		public List<Long> getSentenceIndexes() {
			return sentenceIndexes;
		}
		public void setSentenceIndexes(List<Long> sentenceIndexes) {
			this.sentenceIndexes = sentenceIndexes;
		}
		public void addSentenceIndex(Long index) {
			sentenceIndexes.add(index);
		}
	}
}
