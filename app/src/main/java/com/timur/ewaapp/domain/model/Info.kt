package com.timur.ewaapp.domain.model

data class Info(
    val count: Long,
    val pages: Long,
    val next: String?,
    val prev: String?,
)