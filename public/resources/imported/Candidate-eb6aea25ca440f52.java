package example.hibernate.associations.many_to_many.bidirectional.entity;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "candidates")
public class Candidate {//This is OWNING side
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private Integer candidateId;
	@Column(name = "candidate_name")
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "candidates_certifications",//Junction table name
			joinColumns = {@JoinColumn(name = "candidate_id")},//Foreign key column in Junction table that refers to primary of the table that represents OWNING side
			inverseJoinColumns = {@JoinColumn(name = "certification_id")}//Foreign key column in Junction table that refers to primary of the table that represents INVERSE side
	)
	private Collection<Certification> certifications;
	public Candidate() {
		certifications = new ArrayList<>();
	}
	public Candidate(Integer candidateId, String name, Collection<Certification> certifications) {
		super();
		this.candidateId = candidateId;
		this.name = name;
		this.certifications = certifications;
	}
	public Integer getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Certification> getCertifications() {
		return certifications;
	}
	public void setCertifications(Collection<Certification> certifications) {
		this.certifications = certifications;
		//Setting other end of the association
		for(Certification currentCertification : certifications) {
			currentCertification.getCandidates().add(this);
		}
	}
	public void addCertification(Certification certification) {
		certifications.add(certification);
		//Setting other end of the association
		certification.getCandidates().add(this);
	}

}








