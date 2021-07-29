package com.example.insbaykotlin.data.interactor

import com.example.insbaykotlin.data.ServicePubFactory
import com.example.insbaykotlin.data.LoginFactory
import com.example.insbaykotlin.data.ServiceAnoFactory
import com.example.task.common.Env


abstract class BaseInteractor {
    protected val pubService by lazy { ServicePubFactory.create(Env.BASE_URL_PUBLIC) }
    protected val anoService by lazy { ServiceAnoFactory.create(Env.BASE_URL_ANO) }
    protected val loginService by lazy { LoginFactory.create() }
}