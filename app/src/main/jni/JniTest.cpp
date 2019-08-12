#include "com_example_dzj_android_practice_jnidemo_JniTest.h"
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_example_dzj_android_practice_jnidemo_JniTest
 * Method:    nativeFunc
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_example_dzj_android_1practice_jnidemo_JniTest_nativeFunc
  (JNIEnv* env, jobject obj){
  jclass jniTestClazz = env -> GetObjectClass(obj);

  jmethodID javaMethodId = env -> GetMethodID (jniTestClazz,"javaFunc","()V" );
  env->CallVoidMethod(obj,javaMethodId);

  jfieldID fieldId=env -> GetFieldID (jniTestClazz,"name","C" );
  // GetCharField  Get<java的类型>Field
  jchar name=env->GetCharField(obj,fieldId);
    LOGI("%c",name);
  }

#ifdef __cplusplus
}
#endif