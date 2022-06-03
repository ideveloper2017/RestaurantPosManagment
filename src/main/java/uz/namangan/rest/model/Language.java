package uz.namangan.rest.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_code")
    private String languageCode;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "is_default")
    @Type(type="true_false")
    private boolean isDefault;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Language) {
            if (obj != null) {
                Language language = (Language) obj;
                return language.getId() == getId();
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return getLanguageName();
    }
}