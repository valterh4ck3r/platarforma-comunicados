package br.com.pdws.comunica;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author leandro
 */
public class ValidadorTag implements ConstraintValidator<ValidaTag, String> {

    public List<String> tags;

    @Override
    public void initialize(ValidaTag validaTag) {
        this.tags = new ArrayList<>();
        this.tags.add("ELETIVA");
        this.tags.add("PDS");
        this.tags.add("PDW");
        this.tags.add("DESCORP");
        this.tags.add("WEB1");
        this.tags.add("WEB2");
        this.tags.add("WEB3");
        this.tags.add("PRODESCORP");
        this.tags.add("MPS");
        this.tags.add("MOBILE");
        this.tags.add("INIINFO");
        this.tags.add("METODO");
        this.tags.add("TCC");
        this.tags.add("TCC2");
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext context) {
        return valor == null ? false : tags.contains(valor);
    }

}
