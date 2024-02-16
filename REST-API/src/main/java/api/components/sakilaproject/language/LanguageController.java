package api.components.sakilaproject.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/languages")
public class LanguageController {
    @Autowired
    private final LanguageService languageService;

    public LanguageController (LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public Iterable<Language> getAllLanguages() {
        return languageService.readLanguages();
    }
}
