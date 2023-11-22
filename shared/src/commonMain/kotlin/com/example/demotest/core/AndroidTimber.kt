package com.example.demotest.core

expect object AndroidTimber {
    fun d(message: String)
    fun i(message: String)
    fun e(message: String, exception: Throwable? = null)
    fun w(message: String)
}