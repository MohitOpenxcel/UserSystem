package io.jetbrains.springbooster.language;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language,Integer> {

    @Query(value = "SELECT lang_id FROM language where lang_id NOT IN (SELECT lang_id FROM department );",nativeQuery = true)
    List<Integer> getLangIds();
}
