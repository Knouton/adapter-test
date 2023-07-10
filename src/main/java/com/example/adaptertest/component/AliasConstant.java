package com.example.adaptertest.component;

public final class AliasConstant {
	public static final String ADAPTER = "adapter";
	public static final String HERO = "Hero";
	public static final String SERVICE = "service";
	public static final String HERO_SERVICE = HERO + " " + SERVICE;
	public static final String LOAD = "load";
	public static final String TO = "to";
	public static final String SAVE_TO_DB = "save to DB";
	public static final String GET_FROM_DB = "get from DB";
	public static final String START_REQUEST = "start request";
	public static final String FINISH_REQUEST = "finish request";
	public static final String ERROR_REQUEST = "error request";
	public static final String WITH_ID = "with id {}";
	public static final String WITH_RESULT = "with result {}";
	public static final String WITH_ENTITY = "with entity {}";

	public static final String HERO_SERVICE_SAVE_TO_DB_START_REQUEST = HERO_SERVICE + " " + SAVE_TO_DB + " " + START_REQUEST + " " + WITH_ENTITY;
	public static final String HERO_SERVICE_SAVE_TO_DB_FINISH_REQUEST = HERO_SERVICE + " " + SAVE_TO_DB + " " + FINISH_REQUEST + " " + WITH_RESULT;

	public static final String HERO_SERVICE_GET_FROM_DB_START_REQUEST = HERO_SERVICE + " " + GET_FROM_DB + " " + START_REQUEST + " " + WITH_ID;
	public static final String HERO_SERVICE_GET_FROM_DB_FINISH_REQUEST = HERO_SERVICE + " " + GET_FROM_DB +  " "+ FINISH_REQUEST + " " + WITH_ID;

	public static final String ADAPTER_SERVICE_LOAD_TO_HERO_START_REQUEST = ADAPTER + " " + SERVICE + " " + LOAD + " " + TO + " " + HERO + START_REQUEST + WITH_ENTITY;
	public static final String ADAPTER_SERVICE_LOAD_TO_HERO_FINISH_REQUEST = ADAPTER + " " + SERVICE + " " + LOAD + " " + TO + " " + HERO + FINISH_REQUEST + WITH_ENTITY;

	public static final String ADAPTER_SERVICE_LOAD_TO_HERO_ERROR_REQUEST = ADAPTER + " " + SERVICE + " " + ERROR_REQUEST + " " + WITH_RESULT;

	public static final String POST_CONTROLLER = "Post controller: {}";
	public static final String CONSUMED_MESSAGE_LOG = "Consumer message from kafka: {}";
	public static final String ERROR_LOG = "Error {}";
}
