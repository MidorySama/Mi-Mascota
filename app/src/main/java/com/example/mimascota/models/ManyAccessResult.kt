import com.example.mimascota.models.ListAllPets
import com.google.gson.annotations.SerializedName

data class ManyAccessResult(
    @SerializedName("pets")
    val requestUserAccess: MutableList<ListAllPets> = mutableListOf()
)
