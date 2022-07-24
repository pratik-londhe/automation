package com.brandlive.qa.automation.stepdefs.events.rest;

import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.events.rest.MetricsChannelRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class MetricsChannelStepDefs extends StepDefs {
	
	MetricsChannelRest metricsChannelRest = new MetricsChannelRest();
	
	@And("^Get Events metrics by channel Id$")
	public void Get_Events_Metrics_By_Channel() {
		metricsChannelRest.getEventsByChannelIdforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> eventMetricByChannelId = MetricsChannelRest.e3ChannelEventMetrics;
		log.debug("There are total of " + eventMetricByChannelId.size() + " event metrics for the channel " +channel_name());
	}
	
	@And("^Get Device Types metrics by channel Id$")
	public void Get_DeviceTypes_Metrics_By_Channel() {
		metricsChannelRest.getDeviceTypesByChannelIdforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> deviceTypesMetricByChannelId = MetricsChannelRest.e3ChannelDeviceTypesMetrics;
		log.debug("There are total of " + deviceTypesMetricByChannelId.size() + " device types metrics for the channel " +channel_name());
	}
	
	@And("^Get Registrations metrics by channel Id$")
	public void Get_Registrations_Metrics_By_Channel() {
		metricsChannelRest.getRegistrationsByChannelIdforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> registrationsMetricByChannelId = MetricsChannelRest.e3ChannelRegistrationsMetrics;
		log.debug("There are total of " + registrationsMetricByChannelId.get("value") + " registrations for the channel " +channel_name());
	}
	
	@And("^Get Browsers metrics by channel Id$")
	public void Get_Browsers_Metrics_By_Channel() {
		metricsChannelRest.getBrowsersByChannelIdforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> browsersMetricByChannelId = MetricsChannelRest.e3ChannelBrowsersMetrics;
		log.debug("There are total of " + browsersMetricByChannelId.size() + " types of browser for the channel " +channel_name());

		for(Map<String, Object> browserType : browsersMetricByChannelId) {
			log.debug("Channel accessed by " + browserType.get("label") + " browser " + browserType.get("value") + " time(s).");
		}
	}
	
	@And("^Get Audience metrics by channel Id$")
	public void Get_Audience_Metrics_By_Channel() {
		metricsChannelRest.getAudienceByChannelIdforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> audienceMetricByChannelId = MetricsChannelRest.e3ChannelAudienceMetrics;
		log.debug("There are total of " + audienceMetricByChannelId.get("value") + " audiences for the channel " +channel_name());
		log.debug("There are min of " + audienceMetricByChannelId.get("min") + " audiences for the channel " +channel_name());
		log.debug("There are max of " + audienceMetricByChannelId.get("max") + " audiences for the channel " +channel_name());
	}
	
	@And("^Get Average Duration metrics by channel Id$")
	public void Get_AverageDuration_Metrics_By_Channel() {
		metricsChannelRest.getAverageDurationByChannelIdforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> averageDurationMetricByChannelId = MetricsChannelRest.e3ChannelAverageDurationMetrics;
		log.debug("There are total of " + averageDurationMetricByChannelId.get("value") + " average duration for the channel " +channel_name());
	}
	
	@And("^Get Views metrics by channel Id$")
	public void Get_Views_Metrics_By_Channel() {
		metricsChannelRest.getViewsByChannelIdforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> viewsMetricByChannelId = MetricsChannelRest.e3ChannelViewsMetrics;
		log.debug("There are total of " + viewsMetricByChannelId.get("value") + " views for the channel " +channel_name());
	}
	
	@And("^Get Watch Time metrics by channel Id$")
	public void Get_WatchTime_Metrics_By_Channel() {
		metricsChannelRest.getWatchTimeByChannelIdforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> watchTimeMetricByChannelId = MetricsChannelRest.e3ChannelWatchTimeMetrics;
		log.debug("There are total of " + watchTimeMetricByChannelId.get("value") + " watch time for the channel " +channel_name());
	}
	
	@And("^Get Regions metrics by channel Id$")
	public void Get_Regions_Metrics_By_Channel() {
		metricsChannelRest.getRegionsByChannelIdforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> regionsMetricByChannelId = MetricsChannelRest.e3ChannelRegionsMetrics;
		log.debug("There are total of " + regionsMetricByChannelId.size() + " regions for the channel " +channel_name());

		for(Map<String, Object> region : regionsMetricByChannelId) {
			log.debug("Channel accessed from " + region.get("label") + " region " + region.get("value") + " time(s).");
		}
	}
	
	@And("^Get Retention Average metrics by channel Id$")
	public void Get_RetentionAverage_Metrics_By_Channel() {
		metricsChannelRest.getRetentionAverageByChannelIdforMetrics(rest_Event_Host(), channel_name());
		Map<String, Object> retentionAverageMetricByChannelId = MetricsChannelRest.e3ChannelRetentionAverageMetrics;
		log.debug("There are total of " + retentionAverageMetricByChannelId.get("value") + " retention average for the channel " +channel_name());
	}
	
	@And("^Get Retention Buckets metrics by channel Id$")
	public void Get_RetentionBuckets_Metrics_By_Channel() {
		metricsChannelRest.getRetentionBucketsByChannelIdforMetrics(rest_Event_Host(), channel_name());
		List<Map<String, Object>> retentionBucketsMetricByChannelId = MetricsChannelRest.e3ChannelRetentionBucketsMetrics;
		log.debug("There are total of " + retentionBucketsMetricByChannelId.size() + " retention buckets for the channel " +channel_name());

		for(Map<String, Object> buckets : retentionBucketsMetricByChannelId) {
			log.debug("Channel retention percentage " + buckets.get("retention") + " count is " + buckets.get("count"));
		}
	}

}
