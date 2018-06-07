package ru.javaproject.threatmodel.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = Threat.ALL_SORTED, query = "SELECT tr FROM Threat tr ORDER BY tr.id")
//        @NamedQuery(name = Meal.UPDATE, query = "UPDATE Meal m SET m.dateTime = :datetime, m.calories= :calories," +
//                "m.description=:desc where m.id=:id and m.user.id=:userId")
})

@Entity
@Table(name = "threat", schema = "public")
public class Threat extends NamedEntity{
    public static final String ALL_SORTED = "Threat.getAll";

    @Column(name = "description", nullable = false)
    @NotNull
    private String description;

    @Column(name = "source_of_threat", nullable = false)
    @NotBlank
    private String sourceOfThreat;

    @Column(name = "the_object_of_the_impact", nullable = false)
    @NotBlank
    private String theObjectOfTheImpact;

    @Column(name = "breach_of_confidentiality", nullable = false)
    @NotBlank
    private int breachOfConfidentiality;

    @Column(name = "integrity_violation", nullable = false)
    @Range(min = 0, max = 1)
    private int integrityViolation;

    @Column(name = "violation_of_availability", nullable = false)
    @Range(min = 0, max = 1)
    private int violationOfAvailability;

    @Column(name = "date_of_inclusion_of_threat_in_the_BND")
    @NotNull
    private LocalDateTime dateOfInclusionOfThreatInTheBND;

    @Column(name = "last_modified_date")
    @NotNull
    private LocalDateTime lastModifiedDate;

    public Threat() {
    }

    public Threat(Integer id, String name, String description, String sourceOfThreat,
                  String theObjectOfTheImpact, int breachOfConfidentiality,
                  int integrityViolation, int violationOfAvailability,
                  LocalDateTime dateOfInclusionOfThreatInTheBND, LocalDateTime lastModifiedDate) {
        super(id, name);
        this.description = description;
        this.sourceOfThreat = sourceOfThreat;
        this.theObjectOfTheImpact = theObjectOfTheImpact;
        this.breachOfConfidentiality = breachOfConfidentiality;
        this.integrityViolation = integrityViolation;
        this.violationOfAvailability = violationOfAvailability;
        this.dateOfInclusionOfThreatInTheBND = dateOfInclusionOfThreatInTheBND;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Threat(String name, String description, String sourceOfThreat,
                  String theObjectOfTheImpact, int breachOfConfidentiality,
                  int integrityViolation, int violationOfAvailability,
                  LocalDateTime dateOfInclusionOfThreatInTheBND, LocalDateTime lastModifiedDate) {
        this(null, name, description, sourceOfThreat, theObjectOfTheImpact,
                breachOfConfidentiality, integrityViolation, violationOfAvailability,
                dateOfInclusionOfThreatInTheBND, lastModifiedDate);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceOfThreat() {
        return sourceOfThreat;
    }

    public void setSourceOfThreat(String sourceOfThreat) {
        this.sourceOfThreat = sourceOfThreat;
    }

    public String getTheObjectOfTheImpact() {
        return theObjectOfTheImpact;
    }

    public void setTheObjectOfTheImpact(String theObjectOfTheImpact) {
        this.theObjectOfTheImpact = theObjectOfTheImpact;
    }

    public int getBreachOfConfidentiality() {
        return breachOfConfidentiality;
    }

    public void setBreachOfConfidentiality(int breachOfConfidentiality) {
        this.breachOfConfidentiality = breachOfConfidentiality;
    }

    public int getIntegrityViolation() {
        return integrityViolation;
    }

    public void setIntegrityViolation(int integrityViolation) {
        this.integrityViolation = integrityViolation;
    }

    public int getViolationOfAvailability() {
        return violationOfAvailability;
    }

    public void setViolationOfAvailability(int violationOfAvailability) {
        this.violationOfAvailability = violationOfAvailability;
    }

    public LocalDateTime getDateOfInclusionOfThreatInTheBND() {
        return dateOfInclusionOfThreatInTheBND;
    }

    public void setDateOfInclusionOfThreatInTheBND(LocalDateTime dateOfInclusionOfThreatInTheBND) {
        this.dateOfInclusionOfThreatInTheBND = dateOfInclusionOfThreatInTheBND;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Threat{" +
                "description='" + description + '\'' +
                ", sourceOfThreat='" + sourceOfThreat + '\'' +
                ", theObjectOfTheImpact='" + theObjectOfTheImpact + '\'' +
                ", breachOfConfidentiality='" + breachOfConfidentiality + '\'' +
                ", integrityViolation=" + integrityViolation +
                ", violationOfAvailability=" + violationOfAvailability +
                ", dateOfInclusionOfThreatInTheBND=" + dateOfInclusionOfThreatInTheBND +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
