package com.Lirs.SpringBoot.model;

import java.util.List;

public class Attrs {
    private boolean canRelation;
    private boolean unique;
    private String type;
    private boolean validate;
    private boolean canDisplay;
    private String propertyType;
    private boolean canSubscribe;
    private boolean readOnly;
    private boolean canSearch;
    private String column;
    private boolean langSupport;
    private boolean notNull;
    private String key;
    private String length;
    private Object validators;
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValidators() {
        return validators;
    }

    public void setValidators(Object validators) {
        this.validators = validators;
    }

    public boolean isCanRelation() {
        return canRelation;
    }

    public void setCanRelation(boolean canRelation) {
        this.canRelation = canRelation;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public boolean isCanDisplay() {
        return canDisplay;
    }

    public void setCanDisplay(boolean canDisplay) {
        this.canDisplay = canDisplay;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public boolean isCanSubscribe() {
        return canSubscribe;
    }

    public void setCanSubscribe(boolean canSubscribe) {
        this.canSubscribe = canSubscribe;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isCanSearch() {
        return canSearch;
    }

    public void setCanSearch(boolean canSearch) {
        this.canSearch = canSearch;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public boolean isLangSupport() {
        return langSupport;
    }

    public void setLangSupport(boolean langSupport) {
        this.langSupport = langSupport;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Attrs{" +
                "canRelation=" + canRelation +
                ", unique=" + unique +
                ", type='" + type + '\'' +
                ", validate=" + validate +
                ", canDisplay=" + canDisplay +
                ", propertyType='" + propertyType + '\'' +
                ", canSubscribe=" + canSubscribe +
                ", readOnly=" + readOnly +
                ", canSearch=" + canSearch +
                ", column='" + column + '\'' +
                ", langSupport=" + langSupport +
                ", notNull=" + notNull +
                ", key='" + key + '\'' +
                ", length=" + length +
                '}';
    }
}
