package com.brainXTech.sampleapplevelup.`interface`

interface IResponse<T, E> {
    fun onSuccess(result: T)
    fun onFailure(error: E)
}