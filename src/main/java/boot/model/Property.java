package boot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="properties")
public class Property {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String examTalk;
	@Column(length=45)
	private String question;
	@Column(length=45)
	private String alternative;
	@Column(length=45)
	private String checkk;
	

	
	public Property(String examTalk, String question, String alternative, String checkk) {
		super();
	
		this.examTalk = examTalk;
		this.question = question;
		this.alternative = alternative;
		this.checkk = checkk;
	}

	public Property(){
		this("","","","");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExamTalk() {
		return examTalk;
	}

	public void setExamTalk(String examTalk) {
		this.examTalk = examTalk;
	}

	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAlternative() {
		return alternative;
	}

	public void setAlternative(String alternative) {
		this.alternative = alternative;
	}



	public String getCheckk() {
		return checkk;
	}

	public void setCheckk(String checkk) {
		this.checkk = checkk;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", examTalk=" + examTalk + ", question=" + question + ", alternative="
				+ alternative + ", checkk=" + checkk + "]";
	}
	
}
