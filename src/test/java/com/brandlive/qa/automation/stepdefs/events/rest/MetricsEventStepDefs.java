package com.brandlive.qa.automation.stepdefs.events.rest;

import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.events.rest.MetricsEventsRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class MetricsEventStepDefs extends StepDefs {
	
	MetricsEventsRest metricsEventRest = new MetricsEventsRest();
	
	@And("^Get Sessions metrics by Event Uuid for Channel$")
	public void Get_Sessions_Metrics_By_Event() {
		metricsEventRest.getSessionsByEventUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> sessionsMetricByEventUuid = MetricsEventsRest.e3EventSessionsMetrics;
		log.debug("There are total of " + sessionsMetricByEventUuid.size() + " sessions for the event in channel " + channel_name());
		for(Map<String, Object> session : sessionsMetricByEventUuid) {
			log.debug("The session uuid " + session.get("uuid") + " is present in this event.");
		}
	}
	
	@And("^Get Device Types metrics by Event Uuid for Channel$")
	public void Get_DeviceTypes_Metrics_By_Event() {
		metricsEventRest.getDeviceTypesByEventUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> deviceTypesMetricByEventUuid = MetricsEventsRest.e3EventDeviceTypesMetrics;
		log.debug("There are total of " + deviceTypesMetricByEventUuid.size() + " sessions for the event in channel " + channel_name());
		for(Map<String, Object> deviceType : deviceTypesMetricByEventUuid) {
			log.debug("The device type " + deviceType.get("label") + " with value " + deviceType.get("value") + " is present in this event.");
		}
	}
	
	@And("^Get Registrations metrics by Event Uuid for Channel$")
	public void Get_Registrations_Metrics_By_Event() {
		metricsEventRest.getRegistrationsByEventUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> registrationsMetricByEventUuid = MetricsEventsRest.e3EventRegistrationsMetrics;
		log.debug("There are total of " + registrationsMetricByEventUuid.get("value") + " registrations for the event in channel " + channel_name());
	}
	
	@And("^Get Emails metrics by Event Uuid for Channel$")
	public void Get_Emails_Metrics_By_Event() {
		metricsEventRest.getEmailsByEventUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> emailsMetricByEventUuid = MetricsEventsRest.e3EventEmailsMetrics;
		log.debug("There are total of " + emailsMetricByEventUuid.get("value") + " emails sent for the event in channel " + channel_name());
	}
	
	@And("^Get Browsers metrics by Event Uuid for Channel$")
	public void Get_Browsers_Metrics_By_Event() {
		metricsEventRest.getBrowsersByEventUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> browsersMetricByEventUuid = MetricsEventsRest.e3EventBrowsersMetrics;
		log.debug("There are total of " + browsersMetricByEventUuid.size() + " browsers types used for the event in channel " + channel_name());
		for(Map<String, Object> browserType : browsersMetricByEventUuid) {
			log.debug("Event accessed by " + browserType.get("label") + " browser " + browserType.get("value") + " time(s).");
		}
	}
	
	@And("^Get Average Duration metrics by Event Uuid for Channel$")
	public void Get_AverageDuration_Metrics_By_Event() {
		metricsEventRest.getAverageDurationByEventUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> averageDurationMetricByEventUuid = MetricsEventsRest.e3EventAverageDurationMetrics;
		log.debug("There are total of " + averageDurationMetricByEventUuid.get("value") + " average duration for the event in channel " + channel_name());
	}
	
	@And("^Get Views metrics by Event Uuid for Channel$")
	public void Get_Views_Metrics_By_Event() {
		metricsEventRest.getViewsByEventUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> viewsMetricByEventUuid = MetricsEventsRest.e3EventViewsMetrics;
		log.debug("There are total of " + viewsMetricByEventUuid.get("value") + " views for the event in channel " + channel_name());
	}
	
	@And("^Get Watch Time metrics by Event Uuid for Channel$")
	public void Get_WatchTime_Metrics_By_Event() {
		metricsEventRest.getWatchTimeByEventUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> watchTimeMetricByEventUuid = MetricsEventsRest.e3EventWatchTimeMetrics;
		log.debug("There are total of " + watchTimeMetricByEventUuid.get("value") + " watch time for the event in channel " + channel_name());
	}
	
	@And("^Get Regions metrics by Event Uuid for Channel$")
	public void Get_Regions_Metrics_By_Event() {
		metricsEventRest.getRegionsByEventUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> regionsMetricByEventUuid = MetricsEventsRest.e3EventRegionsMetrics;
		log.debug("There are total of " + regionsMetricByEventUuid.size() + " regions used for the event in channel " + channel_name());
		for(Map<String, Object> region : regionsMetricByEventUuid) {
			log.debug("Event accessed from " + region.get("label") + " region " + region.get("value") + " time(s).");
		}
	}
	
	@And("^Get Languages metrics by Event Uuid for Channel$")
	public void Get_Languages_Metrics_By_Event() {
		metricsEventRest.getLanguagesByEventUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> languagesMetricByEventUuid = MetricsEventsRest.e3EventLanguagesMetrics;
		log.debug("There are total of " + languagesMetricByEventUuid.size() + " languages used for the event in channel " + channel_name());
		for(Map<String, Object> language : languagesMetricByEventUuid) {
			log.debug("Event accessed using " + language.get("label") + " languages " + language.get("value") + " time(s).");
		}
	}
	
	@And("^Get Country Map metrics by Event Uuid for Channel$")
	public void Get_CountryMap_Metrics_By_Event() {
		metricsEventRest.getCountryMapByEventUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> countryMapMetricByEventUuid = MetricsEventsRest.e3EventCountryMapMetrics;
		log.debug("There are total of " + countryMapMetricByEventUuid.size() + " countries accessed for the event in channel " + channel_name());
		for(Map<String, Object> country : countryMapMetricByEventUuid) {
			log.debug("Event accessed by " + country.get("country") + " country " + country.get("count") + " time(s).");
		}
	}
	
	@And("^Get Rention Average metrics by Event Uuid for Channel$")
	public void Get_RetentionAverage_Metrics_By_Event() {
		metricsEventRest.getRentionAverageByEventUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> retentionAverageMetricByEventUuid = MetricsEventsRest.e3EventRetentionAverageMetrics;
		log.debug("There are total of " + retentionAverageMetricByEventUuid.get("value") + " retention average for the event in channel " + channel_name());
	}
	
	@And("^Get Retention Buckets metrics by Event Uuid for Channel$")
	public void Get_RetentionBuckets_Metrics_By_Event() {
		metricsEventRest.getRentionBucketsByEventUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> retentionBucketsMapMetricByEventUuid = MetricsEventsRest.e3EventRetentionBucketsMetrics;
		log.debug("There are total of " + retentionBucketsMapMetricByEventUuid.size() + " retention buckets for the event in channel " + channel_name());
		for(Map<String, Object> bucket : retentionBucketsMapMetricByEventUuid) {
			log.debug("Event retained " + bucket.get("retention") + " percentage " + bucket.get("count") + " time(s).");
		}
	}
	
	@And("^Get Export Summary metrics by Event Uuid for Channel$")
	public void Get_ExportSummary_Metrics_By_Event() {
		metricsEventRest.getExportSummaryByEventUuidforMetrics(rest_Event_Host(), channel_name());
		String exportSummaryMetricByEventUuid = MetricsEventsRest.e3EventExportSummaryMetrics;
		log.debug("The Export Event Summary response is \n" + exportSummaryMetricByEventUuid);
	}
	
	@And("^Get Export Products metrics by Event Uuid for Channel$")
	public void Get_ExportProducts_Metrics_By_Event() {
		metricsEventRest.getExportProductsByEventUuidforMetrics(rest_Event_Host(), channel_name());
		String exportProductsMetricByEventUuid = MetricsEventsRest.e3EventExportProductsMetrics;
		log.debug("The Export Event Products response is \n" + exportProductsMetricByEventUuid);
	}
	
	@And("^Get Export Documents metrics by Event Uuid for Channel$")
	public void Get_ExportDocuments_Metrics_By_Event() {
		metricsEventRest.getExportDocumentsByEventUuidforMetrics(rest_Event_Host(), channel_name());
		String exportDocumentsMetricByEventUuid = MetricsEventsRest.e3EventExportDocumentsMetrics;
		log.debug("The Export Event Products response is \n" + exportDocumentsMetricByEventUuid);
	}
	
	@And("^Get Export Questions metrics by Event Uuid for Channel$")
	public void Get_ExportQuestions_Metrics_By_Event() {
		metricsEventRest.getExportQuestionsByEventUuidforMetrics(rest_Event_Host(), channel_name());
		String exportQuestionsMetricByEventUuid = MetricsEventsRest.e3EventExportQuestionsMetrics;
		log.debug("The Export Event Products response is \n" + exportQuestionsMetricByEventUuid);
	}
	
	@And("^Get Export Sponsors metrics by Event Uuid for Channel$")
	public void Get_ExportSponsors_Metrics_By_Event() {
		metricsEventRest.getExportSponsorsByEventUuidforMetrics(rest_Event_Host(), channel_name());
		String exportSponsorsMetricByEventUuid = MetricsEventsRest.e3EventExportSponsorsMetrics;
		log.debug("The Export Event Products response is \n" + exportSponsorsMetricByEventUuid);
	}
	
	@And("^Get Export Videos metrics by Event Uuid for Channel$")
	public void Get_ExportVideos_Metrics_By_Event() {
		metricsEventRest.getExportVideosByEventUuidforMetrics(rest_Event_Host(), channel_name());
		String exportVideosMetricByEventUuid = MetricsEventsRest.e3EventExportVideosMetrics;
		log.debug("The Export Event Products response is \n" + exportVideosMetricByEventUuid);
	}
	
}
