LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_RRO_THEME := PlatformPurpleAccent
LOCAL_CERTIFICATE := platform
LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/res
LOCAL_PACKAGE_NAME := PlatformPurpleAccent

LOCAL_PRIVATE_PLATFORM_APIS := true

include $(BUILD_RRO_SYSTEM_PACKAGE)
