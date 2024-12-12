package adoption.usermanagementservice.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("ASSOCIATION")
public class Association extends User {
    @Column(name = "nomOrganisation", length = 250)
    private String nomOrganisation;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "adresse", length = 500)
    private String adresse;

    @Column(name = "siteWeb", length = 250)
    private String siteWeb;

    @Column(name = "NR", length = 50)
    private String nr;

    @Column(name = "document_verification", length = 250)
    private String documentVerification;


    public String getNomOrganisation() {
        return nomOrganisation;
    }

    public void setNomOrganisation(String nomOrganisation) {
        this.nomOrganisation = nomOrganisation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getDocumentVerification() {
        return documentVerification;
    }

    public void setDocumentVerification(String documentVerification) {
        this.documentVerification = documentVerification;
    }
}