package com.hy.utils;

import com.hy.pojo.Alog;
import com.hy.pojo.AlogAvg;
import com.hy.pojo.AlogDiff;
public class AlogUtil {
    public static AlogDiff alogDiff(Alog alog, AlogAvg alogAvg) {
        AlogDiff alogDiff = new AlogDiff();
        alogDiff.setCpmDiff(alog.getCpm().subtract(alogAvg.getCpmAvg()));
        alogDiff.setCacDiff(alog.getCac().subtract(alogAvg.getCacAvg()));
        alogDiff.setRoiDiff(alog.getRoi().subtract(alogAvg.getRoiAvg()));
        alogDiff.setMamcGmvRateDiff(alog.getMamcGmvRate().subtract(alogAvg.getMamcGmvRateAvg()));
        alogDiff.setMamcRateDiff(alog.getMamcRate().subtract(alogAvg.getMamcRateAvg()));
        alogDiff.setMasmrRateDiff(alog.getMasmrRate().subtract(alogAvg.getMasmrRateAvg()));
        alogDiff.setMpcmaGmvDiff(alog.getMpcmaGmv().subtract(alogAvg.getMpcmaGmvAvg()));
        alogDiff.setMrrrRateDiff(alog.getMrrrRate().subtract(alogAvg.getMrrrRateAvg()));
        alogDiff.setNmcRateDiff(alog.getNmcRate().subtract(alogAvg.getNmcRateAvg()));
        alogDiff.setNmcGmvRateDiff(alog.getNmcGmvRate().subtract(alogAvg.getNmcGmvRateAvg()));
        alogDiff.setRnmCacDiff(alog.getRnmCac().subtract(alogAvg.getRnmCacAvg()));
        alogDiff.setRnmRoiDiff(alog.getRnmRoi().subtract(alogAvg.getRnmRoiAvg()));
        alogDiff.setPcmaGmvDiff(alog.getPcmaGmv().subtract(alogAvg.getPcmaGmvAvg()));
        alogDiff.setPcnGmvDiff(alog.getPcnGmv().subtract(alogAvg.getPcnGmvAvg()));
        alogDiff.setPanGmvDiff(alog.getPanGmv().subtract(alogAvg.getPanGmvAvg()));
        return alogDiff;
    }


public static AlogDiff alogDiffTwo(Alog alogA,Alog alogB) {
    AlogDiff alogDiffTwo = new AlogDiff();
    alogDiffTwo.setCpmDiff(alogA.getCpm().subtract(alogB.getCpm()));
    alogDiffTwo.setCacDiff(alogA.getCac().subtract(alogB.getCac()));
    alogDiffTwo.setRoiDiff(alogA.getRoi().subtract(alogB.getRoi()));
    alogDiffTwo.setMamcGmvRateDiff(alogA.getMamcGmvRate().subtract(alogB.getMamcGmvRate()));
    alogDiffTwo.setMamcRateDiff(alogA.getMamcRate().subtract(alogB.getMamcRate()));
    alogDiffTwo.setMasmrRateDiff(alogA.getMasmrRate().subtract(alogB.getMasmrRate()));
    alogDiffTwo.setMpcmaGmvDiff(alogA.getMpcmaGmv().subtract(alogB.getMpcmaGmv()));
    alogDiffTwo.setMrrrRateDiff(alogA.getMrrrRate().subtract(alogB.getMrrrRate()));
    alogDiffTwo.setNmcRateDiff(alogA.getNmcRate().subtract(alogB.getNmcRate()));
    alogDiffTwo.setNmcGmvRateDiff(alogA.getNmcGmvRate().subtract(alogB.getNmcGmvRate()));
    alogDiffTwo.setRnmCacDiff(alogA.getRnmCac().subtract(alogB.getRnmCac()));
    alogDiffTwo.setRnmRoiDiff(alogA.getRnmRoi().subtract(alogB.getRnmRoi()));
    alogDiffTwo.setPcmaGmvDiff(alogA.getPcmaGmv().subtract(alogB.getPcmaGmv()));
    alogDiffTwo.setPcnGmvDiff(alogA.getPcnGmv().subtract(alogB.getPcnGmv()));
    alogDiffTwo.setPanGmvDiff(alogA.getPanGmv().subtract(alogB.getPanGmv()));
    return alogDiffTwo;
}
}