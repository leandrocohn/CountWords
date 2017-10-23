package com.challenge.resolvit.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.challenge.resolvit.model.WordSolrDTO;

public interface SentenceRepository extends SolrCrudRepository<WordSolrDTO, String> {

	@Query(value = "*:*")
	@Facet(fields = { "word" }, limit = 999)
	FacetPage<WordSolrDTO> findAllFacetOnWord(Pageable page);

    public List<WordSolrDTO> findByWord(String word);

}
