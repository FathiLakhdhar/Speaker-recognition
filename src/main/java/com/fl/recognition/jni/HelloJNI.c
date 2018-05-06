#include <jni.h>
#include <stdio.h>
#include "HelloJNI.h"
 
JNIEXPORT void JNICALL Java_com_fl_recognition_jni_HelloJNI_sayHello(JNIEnv *env, jobject thisObj) {
   printf("Hello World from C !\n");
   return;
}