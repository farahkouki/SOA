package org.example.entities;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="logement")

public class Logement {

    private int reference;
    private String adresse;
    private String delegation;
    private String gouvernorat;
    private String type;
    private String description;
    private float prix;

    public Logement() {
    }

    public Logement(int reference, String adresse, String delegation, String gouvernorat, String type, String description, float prix) {
        this.reference = reference;
        this.adresse = adresse;
        this.delegation = delegation;
        this.gouvernorat = gouvernorat;
        this.type = type;
        this.description = description;
        this.prix = prix;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    @Override // methode equals
    public boolean equals(Object o) {
        if (this == o) return true; // Vérifie si les objets pointent sur la même référence mémoire
        if (o == null || getClass() != o.getClass()) return false; // Vérifie le type de l'objet

        Logement logement = (Logement) o;

        return reference == logement.reference; // Compare les références des logements
    }

    @Override // methode hashcode
    public int hashCode() {
        return Integer.hashCode(reference); // Retourne un code de hachage basé sur la référence
    }

}
