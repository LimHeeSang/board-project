package com.heesang.boardproject.domain.constant;

import lombok.Getter;

@Getter
public enum FormStatus {

    CREATE("저장", false),
    UPDATE("수정", true);

    private final String description;
    private final boolean isUpdate;

    FormStatus(String description, boolean isUpdate) {
        this.description = description;
        this.isUpdate = isUpdate;
    }
}
