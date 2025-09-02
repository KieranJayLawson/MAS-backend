package com.hy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActivityAlogAndDiff {
    private ActivityAnalysis activityAnalysisA;
    private ActivityAnalysis activityAnalysisB;
    private AlogDiff alogDiff;
}
