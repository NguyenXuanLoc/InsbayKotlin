package com.example.insbaykotlin.data.interactor

import com.example.insbaykotlin.data.LoginFactory
import com.example.insbaykotlin.data.ServiceFactory


abstract class BaseInteractor {
    protected val service by lazy { ServiceFactory.create() }
    protected val loginService by lazy { LoginFactory.create() }
}