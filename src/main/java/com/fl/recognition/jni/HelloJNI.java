package com.fl.recognition.jni;

public class HelloJNI {
	
	// Load native library at runtime
	// hello.dll (Windows) or libhello.so
	// (Unixes)
	static {
		System.loadLibrary("hello");
	}

	// Declare a native method sayHello() that receives nothing and returns void
	public native void sayHello();

}