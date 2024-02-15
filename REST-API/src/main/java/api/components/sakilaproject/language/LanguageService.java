package api.components.sakilaproject.language;

import api.components.sakilaproject.country.Country;
import api.components.sakilaproject.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    @Autowired
    private final LanguageRepository languageRepo;
    public LanguageService (LanguageRepository languageRepo){
        this.languageRepo = languageRepo;
    }

    public List<Language> readLanguages(){
        return languageRepo.findAll();
    }
}
