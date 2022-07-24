package com.brandlive.qa.automation.stepdefs.events.rest;

import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.events.rest.MetricsSessionsRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class MetricsSessionStepDefs extends StepDefs {
	
	MetricsSessionsRest metricsSessionsRest = new MetricsSessionsRest();
	
	@And("^Get Device Types metrics by Session Uuid for Channel$")
	public void Get_DeviceTypes_Metrics_By_Event() {
		metricsSessionsRest.getDeviceTypesBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> deviceTypesMetricBySessionUuid = MetricsSessionsRest.e3SessionDeviceTypesMetrics;
		log.debug("There are total of " + deviceTypesMetricBySessionUuid.size() + " device types for the session in channel " + channel_name());
		for(Map<String, Object> deviceType : deviceTypesMetricBySessionUuid) {
			log.debug("The device type " + deviceType.get("label") + " with value " + deviceType.get("value") + " is present in this session.");
		}
	}
	
	@And("^Get Registrations metrics by Session Uuid for Channel$")
	public void Get_Registrations_Metrics_By_Event() {
		metricsSessionsRest.getRegistrationsBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> registrationsMetricBySessionUuid = MetricsSessionsRest.e3SessionRegistrationsMetrics;
		log.debug("There are total of " + registrationsMetricBySessionUuid.get("value") + " registrations for the session in channel " + channel_name());
	}
	
	@And("^Get Emails metrics by Session Uuid for Channel$")
	public void Get_Emails_Metrics_By_Event() {
		metricsSessionsRest.getEmailsBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> emailsMetricBySessionUuid = MetricsSessionsRest.e3SessionEmailsMetrics;
		log.debug("There are total of " + emailsMetricBySessionUuid.get("value") + " emails for the session in channel " + channel_name());
	}
	
	@And("^Get Browsers metrics by Session Uuid for Channel$")
	public void Get_Browsers_Metrics_By_Event() {
		metricsSessionsRest.getBrowsersBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> browsersMetricBySessionUuid = MetricsSessionsRest.e3SessionBrowsersMetrics;
		log.debug("There are total of " + browsersMetricBySessionUuid.size() + " browser types for the session in channel " + channel_name());
		for(Map<String, Object> browserType : browsersMetricBySessionUuid) {
			log.debug("The browser type " + browserType.get("label") + " used by this session " + browserType.get("value") + " times.");
		}
	}
	
	@And("^Get Average Duration metrics by Session Uuid for Channel$")
	public void Get_AverageDuration_Metrics_By_Event() {
		metricsSessionsRest.getAverageDurationBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> averageDurationMetricBySessionUuid = MetricsSessionsRest.e3SessionAverageDurationMetrics;
		log.debug("There are total of " + averageDurationMetricBySessionUuid.get("value") + " average duration for the session in channel " + channel_name());
	}
	
	@And("^Get Views metrics by Session Uuid for Channel$")
	public void Get_Views_Metrics_By_Event() {
		metricsSessionsRest.getViewsBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> viewsMetricBySessionUuid = MetricsSessionsRest.e3SessionViewsMetrics;
		log.debug("There are total of " + viewsMetricBySessionUuid.get("value") + " views for the session in channel " + channel_name());
	}
	
	@And("^Get Watch Time metrics by Session Uuid for Channel$")
	public void Get_WatchTime_Metrics_By_Event() {
		metricsSessionsRest.getWatchTimeBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> watchTimeMetricBySessionUuid = MetricsSessionsRest.e3SessionWatchTimeMetrics;
		log.debug("There are total of " + watchTimeMetricBySessionUuid.get("value") + " watch time for the session in channel " + channel_name());
	}
	
	@And("^Get Regions metrics by Session Uuid for Channel$")
	public void Get_Regions_Metrics_By_Event() {
		metricsSessionsRest.getRegionsBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> regionsMetricBySessionUuid = MetricsSessionsRest.e3SessionRegionsMetrics;
		log.debug("There are total of " + regionsMetricBySessionUuid.size() + " regions for the session in channel " + channel_name());
		for(Map<String, Object> region : regionsMetricBySessionUuid) {
			log.debug("The region " + region.get("label") + " used by this session " + region.get("value") + " times.");
		}
	}
	
	@And("^Get Languages metrics by Session Uuid for Channel$")
	public void Get_Languages_Metrics_By_Event() {
		metricsSessionsRest.getLanguagesBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> languagesMetricBySessionUuid = MetricsSessionsRest.e3SessionLanguagesMetrics;
		log.debug("There are total of " + languagesMetricBySessionUuid.size() + " languages used for the session in channel " + channel_name());
		for(Map<String, Object> language : languagesMetricBySessionUuid) {
			log.debug("The language " + language.get("label") + " used by this session " + language.get("value") + " times.");
		}
	}
	
	@And("^Get Timeline metrics by Session Uuid for Channel$")
	public void Get_Timeline_Metrics_By_Event() {
		metricsSessionsRest.getTimelineBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> timelineMetricBySessionUuid = MetricsSessionsRest.e3SessionTimelineMetrics;
		log.debug("There are total of " + timelineMetricBySessionUuid.size() + " time lines used by the session in channel " + channel_name());
	}
	
	@And("^Get Country Map metrics by Session Uuid for Channel$")
	public void Get_CountryMap_Metrics_By_Event() {
		metricsSessionsRest.getCountryMapBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> countryMapMetricBySessionUuid = MetricsSessionsRest.e3SessionCountryMapMetrics;
		log.debug("There are total of " + countryMapMetricBySessionUuid.size() + " countries that this session was accessed from in channel " + channel_name());
		for(Map<String, Object> country : countryMapMetricBySessionUuid) {
			log.debug("The country " + country.get("country") + " used by this session " + country.get("count") + " times.");
		}
	}
	
	@And("^Get Retention Average metrics by Session Uuid for Channel$")
	public void Get_RetentionAverage_Metrics_By_Event() {
		metricsSessionsRest.getRetentionAverageBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> retentionAverageMetricBySessionUuid = MetricsSessionsRest.e3SessionRetentionAverageMetrics;
		log.debug("There are total of " + retentionAverageMetricBySessionUuid.get("value") + " retention average for the session in channel " + channel_name());
	}
	
	@And("^Get Export Summary metrics by Session Uuid for Channel$")
	public void Get_ExportSummary_Metrics_By_Session() {
		metricsSessionsRest.getExportSummaryBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		String exportSummaryMetricBySessionUuid = MetricsSessionsRest.e3SessionExportSummaryMetrics;
		log.debug("The Export Session Summary response is \n" + exportSummaryMetricBySessionUuid);
	}
	
	@And("^Get Export Documents metrics by Session Uuid for Channel$")
	public void Get_ExportDocuments_Metrics_By_Session() {
		metricsSessionsRest.getExportDocumentsBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		String exportDocumentsMetricBySessionUuid = MetricsSessionsRest.e3SessionExportDocumentsMetrics;
		log.debug("The Export Session Summary response is \n" + exportDocumentsMetricBySessionUuid);
	}
	
	@And("^Get Export Questions metrics by Session Uuid for Channel$")
	public void Get_ExportQuestions_Metrics_By_Session() {
		metricsSessionsRest.getExportQuestionsBySessionUuidforMetrics(rest_Event_Host(), channel_name());
		String exportQuestionsMetricBySessionUuid = MetricsSessionsRest.e3SessionExportQuestionsMetrics;
		log.debug("The Export Session Summary response is \n" + exportQuestionsMetricBySessionUuid);
	}

}
