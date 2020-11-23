package com.gabrielmarrani.aula35.detalhecategoria.model

import com.google.gson.annotations.SerializedName

data class JokesModel (
    @SerializedName("value")
    val mensagem: String,
    @SerializedName("icon_url")
    val imagem: String
)


