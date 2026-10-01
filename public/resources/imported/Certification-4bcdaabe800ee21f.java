package example.hibernate.associations.many_to_many.bidirectional.entity;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "certifications")
public class Certification {//This is the INVERSE side
	@Id
	@Column(name = "certification_id", length = 5)
	private String certificationId;
	@Column(name = "certification_title", length = 50)
	private String title;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "certifications")//Indicates INVERSE side
	private Collection<Candidate> candidates;
	public Certification() {
		candidates = new ArrayList<>();
	}
	public Certification(String certificationId, String title, Collection<Candidate> candidates) {
		super();
		this.certificationId = certificationId;
		this.title = title;
		this.candidates = candidates;
	}
	public String getCertificationId() {
		return certificationId;
	}
	public void setCertificationId(String certificationId) {
		this.certificationId = certificationId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Collection<Candidate> getCandidates() {
		return candidates;
	}
	public void setCandidates(Collection<Candidate> candidates) {
		this.candidates = candidates;
	}

}
