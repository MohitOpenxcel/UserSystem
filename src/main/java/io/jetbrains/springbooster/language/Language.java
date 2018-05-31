package io.jetbrains.springbooster.language;

import javax.persistence.*;

@Entity(name = "language")
public class Language{

    @Id
    @Column(name = "lang_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int lang_id;

    @Column(name = "lang_name")
    String name;

    Language(){

    }

    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language(String name) {
        this.name = name;
    }
}
