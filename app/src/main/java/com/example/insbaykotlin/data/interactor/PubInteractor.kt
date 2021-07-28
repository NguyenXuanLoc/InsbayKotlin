package com.example.insbaykotlin.data.interactor

import com.example.insbaykotlin.data.mapper.convertToModel
import com.example.insbaykotlin.data.model.AnonymousModel
import com.example.task.data.mapper.convertToModel
import com.example.task.data.model.BaseModel
import io.reactivex.Single

class PubInteractor : BaseInteractor() {
    /* fun login(ob: AccountModel): Single<InfoModel>? {
         var param = HashMap<String, String>()
         param["grant_type"] = "login"
         param["username"] = "0${ob.phone.toString()}"
         param["password"] = ob.password.toString()
         param["captcha"] = "1234"
         return loginService?.login(param)?.map { it.convertToModel() }
     }*/

    fun getAnonymousToken(): Single<AnonymousModel> {
        var param = HashMap<String, String>()
        param["app_key"] = "fdsgdscvdawyknmbnmnbzcxzdzx"
        return pubService.getAnonymousToken(param).map {
            it.convertToModel()
        }
    }
}