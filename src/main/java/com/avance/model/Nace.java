package com.avance.model;

import javax.persistence.*;

@Entity(name = "Nace")
@Table(name = "nace")
@NamedQuery(name = "getNaceByOrderId", query = "SELECT n FROM Nace n WHERE n.order = :orderId")
public class Nace {
    @Id
    @Column(name = "nace_order")
    private long order;
    @Column(name = "nace_level")
    private int level;
    @Column(name = "nace_code")
    private char code;
    @Column(name = "parent")
    private String parent;
    @Column(name = "nace_description")
    private String description;
    @Lob
    @Column(name = "this_item_includes")
    private String thisItemIncludes;
    @Lob
    @Column(name = "this_item_also_includes")
    private String thisItemAlsoIncludes;
    @Column(name = "nace_rulings")
    private String rulings;
    @Column(name = "this_item_excludes")
    private String thisItemExcludes;
    @Column(name = "reference_to_isic_rev4")
    private char referenceToISICRev4;

    public Nace() {
    }

    public Nace(long order, int level, char code, String parent, String description, String thisItemAlsoIncludes, String thisItemIncludes, String rulings, String thisItemExcludes, char referenceToISICRev4) {
        this.order = order;
        this.level = level;
        this.code = code;
        this.parent = parent;
        this.description = description;
        this.thisItemIncludes = thisItemIncludes;
        this.thisItemAlsoIncludes = thisItemAlsoIncludes;
        this.rulings = rulings;
        this.thisItemExcludes = thisItemExcludes;
        this.referenceToISICRev4 = referenceToISICRev4;
    }

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

    public String getThisItemAlsoIncludes() {
        return thisItemAlsoIncludes;
    }

    public void setThisItemAlsoIncludes(String thisItemAlsoIncludes) {
        this.thisItemAlsoIncludes = thisItemAlsoIncludes;
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
