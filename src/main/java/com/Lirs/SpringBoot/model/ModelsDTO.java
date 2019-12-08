package com.Lirs.SpringBoot.model;

import java.util.List;

public class ModelsDTO {
    private List<Attrs> attrs;
    private Global global;

    public List<Attrs> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<Attrs> attrs) {
        this.attrs = attrs;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }
}
