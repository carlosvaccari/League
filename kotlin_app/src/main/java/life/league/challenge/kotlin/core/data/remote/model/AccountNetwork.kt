package life.league.challenge.kotlin.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class AccountNetwork(@SerializedName("api_key") val apiKey: String? = null)
