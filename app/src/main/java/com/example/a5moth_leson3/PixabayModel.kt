package com.example.a5moth_leson3

import java.net.URL

data class PixabayModel (
    val hits:ArrayList<ImageModel>
        )

data class  ImageModel(
    var largeImageURL: String
)
