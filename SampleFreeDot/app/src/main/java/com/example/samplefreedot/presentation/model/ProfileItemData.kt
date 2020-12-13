package com.example.samplefreedot.presentation.model

data class ProfileItemData(
    val title : String,
    val userSpecList : List<UserSpec>
)

data class UserSpec(
    val title : String
)