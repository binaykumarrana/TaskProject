package com.binay.taskproject.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Binay on 12/03/17.
 */

public class Message {
    @SerializedName("monthly_investment")
    private Integer monthlyInvestment;
    @SerializedName("risk_level")
    private Integer riskLevel;
    private String name;
    @SerializedName("glide_path")
    private String glidePath;
    @SerializedName("target_pv")
    private Integer targetPv;
    @SerializedName("cagr")
    private Integer cagr;
    @SerializedName("annual_inv_schedule")
    private String annualInvSchedule;
    @SerializedName("asset_alloc")
    private Integer assetAlloc;
    @SerializedName("monthly_inv_schedule")
    private String monthlyInvSchedule;
    @SerializedName("increment")
    private Integer increment;
    @SerializedName("starting_amount")
    private Integer startingAmount;
    @SerializedName("total_investment")
    private Integer totalInvestment;
    @SerializedName("time_horizon")
    private Integer timeHorizon;
    private Integer target;
    private String funds;
    private Projections projections;

    public Integer getMonthlyInvestment() {
        return monthlyInvestment;
    }

    public void setMonthlyInvestment(Integer monthlyInvestment) {
        this.monthlyInvestment = monthlyInvestment;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGlidePath() {
        return glidePath;
    }

    public void setGlidePath(String glidePath) {
        this.glidePath = glidePath;
    }

    public Integer getTargetPv() {
        return targetPv;
    }

    public void setTargetPv(Integer targetPv) {
        this.targetPv = targetPv;
    }

    public Integer getCagr() {
        return cagr;
    }

    public void setCagr(Integer cagr) {
        this.cagr = cagr;
    }

    public String getAnnualInvSchedule() {
        return annualInvSchedule;
    }

    public void setAnnualInvSchedule(String annualInvSchedule) {
        this.annualInvSchedule = annualInvSchedule;
    }

    public Integer getAssetAlloc() {
        return assetAlloc;
    }

    public void setAssetAlloc(Integer assetAlloc) {
        this.assetAlloc = assetAlloc;
    }

    public String getMonthlyInvSchedule() {
        return monthlyInvSchedule;
    }

    public void setMonthlyInvSchedule(String monthlyInvSchedule) {
        this.monthlyInvSchedule = monthlyInvSchedule;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    public Integer getStartingAmount() {
        return startingAmount;
    }

    public void setStartingAmount(Integer startingAmount) {
        this.startingAmount = startingAmount;
    }

    public Integer getTotalInvestment() {
        return totalInvestment;
    }

    public void setTotalInvestment(Integer totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public Integer getTimeHorizon() {
        return timeHorizon;
    }

    public void setTimeHorizon(Integer timeHorizon) {
        this.timeHorizon = timeHorizon;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public Projections getProjections() {
        return projections;
    }

    public void setProjections(Projections projections) {
        this.projections = projections;
    }

}
