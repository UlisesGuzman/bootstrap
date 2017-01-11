package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.TermRepository;
import boot.model.Term;

@Service @Transactional
public class TermService {
	
	private final TermRepository termRepository;

	public TermService(TermRepository termRepository){
		super();
		this.termRepository= termRepository;
	}
	
	public List <Term> findAll(){
		List<Term> terms = new ArrayList<Term>();
		for(Term term : termRepository.findAll() ){
			terms.add(term);
		}
		return terms;
	}
	
	public void save(Term term){
		termRepository.save(term);
	}
	
	public void delete(int id){
		termRepository.delete(id);
	}
	
	public  Term finOne(int id){
	return termRepository.findOne(id);
	}

}
