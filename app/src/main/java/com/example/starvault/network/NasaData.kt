import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NasaData(
    val collection: NasaCollection
)

@Serializable
data class NasaCollection(
    val version: String? = null,
    val href: String,
    val items: List<ItemsData> = emptyList(),
    val links: List<Links>? = null,
    val metadata: Mdata? = null
)

@Serializable
data class ItemsData(
    val href: String,
    val data: List<Data> = emptyList(),
    val links: List<Links>? = null
)

@Serializable
data class Mdata(
    @SerialName("total_hits")
    val hits: Int
)

@Serializable
data class Data(
    val album: List<String>? = null,
    val center: String? = null,

    @SerialName("date_created")
    val date: String? = null,

    val description: String? = null,

    @SerialName("description_508")
    val description2: String? = null,

    val keywords: List<String>? = null,

    val location: String? = null,

    @SerialName("media_type")
    val mediaType: String? = null,

    @SerialName("nasa_id")
    val nasaId: String,

    val photographer: String? = null,

    @SerialName("secondary_creator")
    val secondaryCreator: String? = null,

    val title: String? = null
)

@Serializable
data class Links(
    val href: String,
    val prompt: String? = null,  // Corrected from "prompts"
    val rel: String? = null,
    val render: String? = null,
    val width: Int? = null,
    val size: Int? = null,
    val height: Int? = null
)
