package api.components.sakilaproject.language;

import api.components.sakilaproject.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

@Entity
@Table(name="language")
public class Language {
    @Id
    @Column(name="language_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({JsonViews.Actor.class})
    private short languageID;

    @Column(name="name")
    @JsonView({JsonViews.Film.class,JsonViews.Actor.class})
    private String languageName;

    public short getLanguageID() {
        return languageID;
    }

    public void setLanguageID(short languageID) {
        this.languageID = languageID;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
