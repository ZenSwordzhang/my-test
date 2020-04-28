package com.zsx.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Transient;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ReferenceInfo {

    public String referringRealmCode;

    public String referringModelName;

    public String referringDataKey;

    @Transient
    public String remarks;
}
