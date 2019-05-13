package com.andy.resepsehat

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class DataItem(

	@field:SerializedName("resep_sehat")
	val resepSehat: String? = null,

	@field:SerializedName("nama_sehat")
	val namaSehat: String? = null,

	@field:SerializedName("gambar_sehat")
	val gambarSehat: String? = null,

	@field:SerializedName("id_sehat")
	val idSehat: String? = null
)