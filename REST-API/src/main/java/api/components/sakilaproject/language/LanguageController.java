package api.components.sakilaproject.language;

import api.components.sakilaproject.country.Country;
import api.components.sakilaproject.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/languages")
public class LanguageController {
    @Autowired
    private LanguageRepository languageRepo;

    @GetMapping
    public Iterable<Language> getAllLanguages() {
        return languageRepo.findAll();
    }
}
