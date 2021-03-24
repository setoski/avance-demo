package com.avance.dto;

import com.sun.istack.Nullable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AddNaceDto {
    @Min(1)
    @Positive(message = "Nace order cannot be negative")
    private long order;
    @NotNull(message = "Nace level is required")
    private int level;
    @NotNull(message = "Nace code is required")
    private char code;
    @Nullable
    private String parent;
    @Nullable
    private String description;
    @Nullable
    private String thisItemAlsoIncludes;
    @Nullable
    private String thisItemIncludes;
    @Nullable
    private String rulings;
    @Nullable
    private String thisItemExcludes;
    @NotNull(message = "Nace reference ISIC is required")
    private char referenceToISICRev4;

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getThisItemAlsoIncludes() {
        return thisItemAlsoIncludes;
    }

    public void setThisItemAlsoIncludes(String thisItemAlsoIncludes) {
        this.thisItemAlsoIncludes = thisItemAlsoIncludes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThisItemIncludes() {
        return thisItemIncludes;
    }

    public void setThisItemIncludes(String thisItemIncludes) {
        this.thisItemIncludes = thisItemIncludes;
    }

    public String getRulings() {
        return rulings;
    }

    public void setRulings(String rulings) {
        this.rulings = rulings;
    }

    public String getThisItemExcludes() {
        return thisItemExcludes;
    }

    public void setThisItemExcludes(String thisItemExcludes) {
        this.thisItemExcludes = thisItemExcludes;
    }

    public char getReferenceToISICRev4() {
        return referenceToISICRev4;
    }

    public void setReferenceToISICRev4(char referenceToISICRev4) {
        this.referenceToISICRev4 = referenceToISICRev4;
    }
}
