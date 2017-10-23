package com.challenge.resolvit.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.challenge.resolvit.model.SentenceSolrDTO;

public interface SentenceRepository extends SolrCrudRepository<SentenceSolrDTO, String> {

	@Query(value = "*:*")
	@Facet(fields = { "sentence" }, limit = 999)
	FacetPage<SentenceSolrDTO> findAllFacetOnSentence(Pageable page);

    public List<SentenceSolrDTO> findBySentence(String sentence);

}
