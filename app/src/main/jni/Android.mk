LOCAL_PATH:=$(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES+=./*.cpp
LOCAL_LDLIBS := -L$(SYSROOT)/usr/lib -llog
LOCAL_LDLIBS += -landroid
LOCAL_LDLIBS += -lz

LOCAL_MODULE:=libjnitest

include $(BUILD_SHARED_LIBRARY)
include $(call all-makefiles-under,$(LOCAL_PATH))