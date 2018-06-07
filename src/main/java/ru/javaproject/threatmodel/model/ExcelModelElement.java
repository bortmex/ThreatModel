package ru.javaproject.threatmodel.model;

import java.util.Objects;

public class ExcelModelElement {
    private Threat threat;
    private String breachOfConfidentiality;
    private String integrityViolation;
    private String violationOfAvailability;
    private String Y1P;
    private String Y2;
    private String YJ;
    private String XJ;
    private String UBIaj;
    private String detailedDescription;

    public ExcelModelElement(Threat threat, String breachOfConfidentiality,
                             String integrityViolation, String violationOfAvailability,
                             String y1P, String y2, String YJ, String XJ, String UBIaj,
                             String detailedDescription) {
        this.threat = threat;
        this.breachOfConfidentiality = breachOfConfidentiality;
        this.integrityViolation = integrityViolation;
        this.violationOfAvailability = violationOfAvailability;
        Y1P = y1P;
        Y2 = y2;
        this.YJ = YJ;
        this.XJ = XJ;
        this.UBIaj = UBIaj;
        this.detailedDescription = detailedDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcelModelElement that = (ExcelModelElement) o;
        return breachOfConfidentiality == that.breachOfConfidentiality &&
                integrityViolation == that.integrityViolation &&
                violationOfAvailability == that.violationOfAvailability &&
                Objects.equals(threat, that.threat) &&
                Objects.equals(Y1P, that.Y1P) &&
                Objects.equals(Y2, that.Y2) &&
                Objects.equals(YJ, that.YJ) &&
                Objects.equals(XJ, that.XJ) &&
                Objects.equals(UBIaj, that.UBIaj) &&
                Objects.equals(detailedDescription, that.detailedDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(threat, breachOfConfidentiality, integrityViolation, violationOfAvailability, Y1P, Y2, YJ, XJ, UBIaj, detailedDescription);
    }

    public Threat getThreat() {
        return threat;
    }

    public void setThreat(Threat threat) {
        this.threat = threat;
    }

    public String getBreachOfConfidentiality() {
        return breachOfConfidentiality;
    }

    public void setBreachOfConfidentiality(String breachOfConfidentiality) {
        this.breachOfConfidentiality = breachOfConfidentiality;
    }

    public String getIntegrityViolation() {
        return integrityViolation;
    }

    public void setIntegrityViolation(String integrityViolation) {
        this.integrityViolation = integrityViolation;
    }

    public String getViolationOfAvailability() {
        return violationOfAvailability;
    }

    public void setViolationOfAvailability(String violationOfAvailability) {
        this.violationOfAvailability = violationOfAvailability;
    }

    public String getY1P() {
        return Y1P;
    }

    public void setY1P(String y1P) {
        Y1P = y1P;
    }

    public String getY2() {
        return Y2;
    }

    public void setY2(String y2) {
        Y2 = y2;
    }

    public String getYJ() {
        return YJ;
    }

    public void setYJ(String YJ) {
        this.YJ = YJ;
    }

    public String getXJ() {
        return XJ;
    }

    public void setXJ(String XJ) {
        this.XJ = XJ;
    }

    public String getUBIaj() {
        return UBIaj;
    }

    public void setUBIaj(String UBIaj) {
        this.UBIaj = UBIaj;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }
}
