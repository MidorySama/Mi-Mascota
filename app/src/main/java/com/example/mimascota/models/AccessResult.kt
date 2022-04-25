import com.example.mimascota.models.ListAllPets
import com.google.gson.annotations.SerializedName

data class AccessResult(
    @SerializedName("pets")
    val requestUserAccess: MutableList<ListAllPets> = mutableListOf()
)
