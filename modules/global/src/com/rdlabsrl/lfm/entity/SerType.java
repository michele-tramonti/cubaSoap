package com.rdlabsrl.lfm.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum SerType implements EnumClass<Integer> {

    NOT_SERIALIZED(0),
    LOT_MANAGED(1),
    SERIALIZED_NO_TRACK(2),
    SERIALIZED_AND_TRACK(3),
    TEST_ORDER(4);

    private Integer id;

    SerType(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static SerType fromId(Integer id) {
        for (SerType at : SerType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}