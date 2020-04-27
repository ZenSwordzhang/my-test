package com.zsx.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ReferenceInfo {

    public String referringRealmCode;

    public String referringModelName;

    public String referringDataKey;
}
