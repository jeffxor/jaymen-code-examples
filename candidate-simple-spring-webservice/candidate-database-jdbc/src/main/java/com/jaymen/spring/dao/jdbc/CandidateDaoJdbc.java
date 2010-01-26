package com.jaymen.spring.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jaymen.spring.dao.CandidateDao;
import com.jaymen.spring.model.Candidate;

public class CandidateDaoJdbc extends NamedParameterJdbcDaoSupport implements CandidateDao {
	//Use slf4j for logging purposes
	private static Logger logger = LoggerFactory.getLogger(CandidateDaoJdbc.class);
	
	public Candidate getCandidate(Integer id) {
		logger.debug("getting candidate with id: " + id);
		Map<String, Integer> map =  new HashMap<String, Integer>();
		map.put("id", id);
		return (Candidate)this.getNamedParameterJdbcTemplate().queryForObject("SELECT * FROM candidate WHERE id = :id", 
				map, new BeanPropertyRowMapper(Candidate.class));
	}
	
	@SuppressWarnings("unchecked")
	public List<Candidate> getCandidates() {
		logger.debug("getting all candidates");
		Map<String, String> map =  new HashMap<String, String>();
		return this.getNamedParameterJdbcTemplate().query("SELECT * FROM candidate", map, new BeanPropertyRowMapper(Candidate.class));
	}
	
	public Boolean addCandidate(Candidate candidate){
		logger.debug("attempting to add a new candidate");
		String sql = "INSERT INTO candidate (name, address, phone, email) " +
				"VALUES (:name, :address, :phone, :email)";
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(candidate);
		
		int rows = this.getNamedParameterJdbcTemplate().update(sql, paramSource);

		return new Boolean(rows > 0);
	}

	public Boolean updateCandidate(Candidate candidate) {
		logger.debug("updating candidate name:" + candidate.getName() + " with id: " + candidate.getId());
		String sql = "UPDATE candidate SET name = :name, address = :address, phone = :phone, email = :email " +
				" WHERE id = :id";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(candidate);
		int rows = this.getNamedParameterJdbcTemplate().update(sql, paramSource);

		return new Boolean(rows > 0);
	}

}
