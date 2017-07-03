package com.example.mypc.retrofitexample.model.responseResultModel;

import com.example.mypc.retrofitexample.model.ExtraChargeSummary;
import com.example.mypc.retrofitexample.model.RevenueDetail;
import com.example.mypc.retrofitexample.model.TicketCancelSummary;
import com.example.mypc.retrofitexample.model.TicketPaidSummary;
import com.example.mypc.retrofitexample.model.TicketProccessingSummary;
import com.example.mypc.retrofitexample.model.TicketSale;
import com.example.mypc.retrofitexample.model.TicketSaleByDate;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MyPC on 6/20/2017.
 */

public class ResponseReportData {
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("event_name")
    @Expose
    private String eventName;
    @SerializedName("event_location")
    @Expose
    private String eventLocation;
    @SerializedName("event_logo")
    @Expose
    private String eventLogo;
    @SerializedName("is_cancel")
    @Expose
    private Boolean isCancel;
    @SerializedName("income_amount")
    @Expose
    private Integer incomeAmount;
    @SerializedName("revenue")
    @Expose
    private Integer revenue;
    @SerializedName("service_fee")
    @Expose
    private Integer serviceFee;
    @SerializedName("tkb_rate")
    @Expose
    private String tkbRate;
    @SerializedName("organizer_money_fee")
    @Expose
    private Integer organizerMoneyFee;
    @SerializedName("organizer_percent_fee")
    @Expose
    private Integer organizerPercentFee;
    @SerializedName("extra_charge_amount")
    @Expose
    private Integer extraChargeAmount;
    @SerializedName("total_ticket_quantity")
    @Expose
    private Integer totalTicketQuantity;
    @SerializedName("total_paid_ticket_quantity")
    @Expose
    private Integer totalPaidTicketQuantity;
    @SerializedName("total_processing_ticket_quantity")
    @Expose
    private Integer totalProcessingTicketQuantity;
    @SerializedName("total_canceled_ticket_quantity")
    @Expose
    private Integer totalCanceledTicketQuantity;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("ticket_paid_summary")
    @Expose
    private TicketPaidSummary ticketPaidSummary;
    @SerializedName("ticket_proccessing_summary")
    @Expose
    private TicketProccessingSummary ticketProccessingSummary;
    @SerializedName("ticket_cancel_summary")
    @Expose
    private TicketCancelSummary ticketCancelSummary;
    @SerializedName("ticket_sales")
    @Expose
    private List<TicketSale> ticketSales = null;
    @SerializedName("ticket_sale_by_dates")
    @Expose
    private List<TicketSaleByDate> ticketSaleByDates = null;
    @SerializedName("extra_charge_summaries")
    @Expose
    private List<ExtraChargeSummary> extraChargeSummaries = null;
    @SerializedName("revenue_details")
    @Expose
    private List<RevenueDetail> revenueDetails = null;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventLogo() {
        return eventLogo;
    }

    public void setEventLogo(String eventLogo) {
        this.eventLogo = eventLogo;
    }

    public Boolean getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Boolean isCancel) {
        this.isCancel = isCancel;
    }

    public Integer getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Integer incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Integer serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getTkbRate() {
        return tkbRate;
    }

    public void setTkbRate(String tkbRate) {
        this.tkbRate = tkbRate;
    }

    public Integer getOrganizerMoneyFee() {
        return organizerMoneyFee;
    }

    public void setOrganizerMoneyFee(Integer organizerMoneyFee) {
        this.organizerMoneyFee = organizerMoneyFee;
    }

    public Integer getOrganizerPercentFee() {
        return organizerPercentFee;
    }

    public void setOrganizerPercentFee(Integer organizerPercentFee) {
        this.organizerPercentFee = organizerPercentFee;
    }

    public Integer getExtraChargeAmount() {
        return extraChargeAmount;
    }

    public void setExtraChargeAmount(Integer extraChargeAmount) {
        this.extraChargeAmount = extraChargeAmount;
    }

    public Integer getTotalTicketQuantity() {
        return totalTicketQuantity;
    }

    public void setTotalTicketQuantity(Integer totalTicketQuantity) {
        this.totalTicketQuantity = totalTicketQuantity;
    }

    public Integer getTotalPaidTicketQuantity() {
        return totalPaidTicketQuantity;
    }

    public void setTotalPaidTicketQuantity(Integer totalPaidTicketQuantity) {
        this.totalPaidTicketQuantity = totalPaidTicketQuantity;
    }

    public Integer getTotalProcessingTicketQuantity() {
        return totalProcessingTicketQuantity;
    }

    public void setTotalProcessingTicketQuantity(Integer totalProcessingTicketQuantity) {
        this.totalProcessingTicketQuantity = totalProcessingTicketQuantity;
    }

    public Integer getTotalCanceledTicketQuantity() {
        return totalCanceledTicketQuantity;
    }

    public void setTotalCanceledTicketQuantity(Integer totalCanceledTicketQuantity) {
        this.totalCanceledTicketQuantity = totalCanceledTicketQuantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public TicketPaidSummary getTicketPaidSummary() {
        return ticketPaidSummary;
    }

    public void setTicketPaidSummary(TicketPaidSummary ticketPaidSummary) {
        this.ticketPaidSummary = ticketPaidSummary;
    }

    public TicketProccessingSummary getTicketProccessingSummary() {
        return ticketProccessingSummary;
    }

    public void setTicketProccessingSummary(TicketProccessingSummary ticketProccessingSummary) {
        this.ticketProccessingSummary = ticketProccessingSummary;
    }

    public TicketCancelSummary getTicketCancelSummary() {
        return ticketCancelSummary;
    }

    public void setTicketCancelSummary(TicketCancelSummary ticketCancelSummary) {
        this.ticketCancelSummary = ticketCancelSummary;
    }

    public List<TicketSale> getTicketSales() {
        return ticketSales;
    }

    public void setTicketSales(List<TicketSale> ticketSales) {
        this.ticketSales = ticketSales;
    }

    public List<TicketSaleByDate> getTicketSaleByDates() {
        return ticketSaleByDates;
    }

    public void setTicketSaleByDates(List<TicketSaleByDate> ticketSaleByDates) {
        this.ticketSaleByDates = ticketSaleByDates;
    }

    public List<ExtraChargeSummary> getExtraChargeSummaries() {
        return extraChargeSummaries;
    }

    public void setExtraChargeSummaries(List<ExtraChargeSummary> extraChargeSummaries) {
        this.extraChargeSummaries = extraChargeSummaries;
    }

    public List<RevenueDetail> getRevenueDetails() {
        return revenueDetails;
    }

    public void setRevenueDetails(List<RevenueDetail> revenueDetails) {
        this.revenueDetails = revenueDetails;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

}
